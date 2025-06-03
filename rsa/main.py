import threading
import time

import requests
from flask import Flask, request

from modules.rsa import Rsa
from modules.utils import Helper

p = Helper.generate_large_prime(2048)
q = Helper.generate_large_prime(2048)
rsa = Rsa(p=p, q=q)
app = Flask(__name__)

public_key_n = rsa.n
public_key_e = rsa.e


peer_public_key = None


@app.route("/message", methods=["POST"])
def recive_message():
    global peer_public_key

    data = request.json

    if data.get("type") == "key":

        peer_public_key = {"n": data["n"], "e": data["e"]}
        print("Chave recebida com sucesso")
        return {"status": "chave recebida"}, 200

    elif data.get("type") == "message":
        message = data["msg"]
        decrypted = rsa.descriptografar(message)
        print(f"Peer: {decrypted}")
        return {"status": "mensagem recebida"}, 200

    return {"error": "tipo desconhecido"}, 400


def post_with_retry(url, json_data, retries=5, backoff=2):
    """
    Faz uma requisição POST com retry.

    :param url: URL do webhook peer
    :param json_data: Dados JSON a serem enviados
    :param retries: Número máximo de tentativas
    :param backoff: Tempo (segundos) para esperar entre tentativas
    """
    attempt = 0
    while attempt < retries:
        try:
            response = requests.post(url, json=json_data, timeout=5)
            response.raise_for_status()
            print(f"[SUCCESS] Mensagem enviada para {url}")
            return response
        except requests.exceptions.RequestException as e:
            attempt += 1
            print(f"[RETRY {attempt}/{retries}] Falha ao enviar mensagem: {e}")
            time.sleep(backoff)

    print(
        f"[ERROR] Não foi possível enviar a mensagem após {retries} tentativas."
    )
    return None


def send_message():

    global peer_public_key
    time.sleep(20)
    PEER_URL = input(
        "Insira URL do peer para conexão exemplo: http://localhost:5001/message: "
    )

    print("Enviando chave publica para o peer")
    json = {"type": "key", "e": rsa.e, "n": rsa.n}

    res = None
    while not res:

        res = post_with_retry(PEER_URL, json_data=json)

    print("Chave encaminhada com sucesso")

    while not peer_public_key:
        pass

    while True:
        message = input("Você: ")
        encrypted = rsa.criptografar(
            message=message, e=peer_public_key["e"], n=peer_public_key["n"]
        )
        payload = {"type": "message", "msg": encrypted}
        post_with_retry(PEER_URL, json_data=payload)


def run_server():
    MY_PORT = int(input("Insira qual a porta será inicializada: "))
    app.run(port=MY_PORT, debug=True, use_reloader=False)


threading.Thread(target=run_server, daemon=True).start()
send_message()
