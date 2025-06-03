import pickle
import zlib
from math import gcd


class Rsa:
    def __init__(self, p, q):
        self.p = p
        self.q = q
        self.__calculate_n()
        self.__calc_totient()
        self.__public_key()
        self.__private_key()

    def __calculate_n(self):
        self.n = self.p * self.q

    def __calc_totient(self):
        self.t = (self.p - 1) * (self.q - 1)

    def __public_key(self):
        # Usa 65537 como 'e' padrão (se possível)
        self.e = 65537
        if gcd(self.e, self.t) != 1:
            # Fallback para outro valor (raro em primos grandes)
            self.e = 3
            while gcd(self.e, self.t) != 1 and self.e < self.t:
                self.e += 2

    def __private_key(self):
        self.__d = pow(self.e, -1, self.t)

    def __message_to_int(self, message):
        data = pickle.dumps(message)
        compressed = zlib.compress(data)
        m = int.from_bytes(compressed, byteorder="big")
        return m

    def __int_to_message(self, m_int):
        byte_length = (m_int.bit_length() + 7) // 8
        compressed = m_int.to_bytes(byte_length, byteorder="big")
        data = zlib.decompress(compressed)
        message = pickle.loads(data)
        return message

    def criptografar(self, message, e, n):
        m = self.__message_to_int(message)
        if m >= n:
            raise ValueError("Mensagem é muito grande para a chave RSA.")
        c = pow(m, e, n)
        return c

    def descriptografar(self, encrypt_message):
        m = pow(encrypt_message, self.__d, self.n)
        return self.__int_to_message(m)
