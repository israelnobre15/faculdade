import secrets


class Helper:
    @staticmethod
    def is_prime(n, k=5):
        """
        Teste de Miller-Rabin para primalidade.
        :param n: Número a ser testado.
        :param k: Número de rodadas (aumenta a precisão).
        :return: True se provavelmente primo, False se composto.
        """
        if n <= 1:
            return False
        if n <= 3:
            return True
        if n % 2 == 0:
            return False

        # Escreve n-1 como d * 2^s
        d = n - 1
        s = 0
        while d % 2 == 0:
            d //= 2
            s += 1

        # Testa k vezes
        for _ in range(k):
            a = secrets.randbelow(n - 3) + 2
            x = pow(a, d, n)
            if x == 1 or x == n - 1:
                continue
            for __ in range(s - 1):
                x = pow(x, 2, n)
                if x == n - 1:
                    break
            else:
                return False
        return True

    @staticmethod
    def generate_large_prime(bits=1024):
        """
        Gera um número primo grande com 'bits' de tamanho.
        """
        while True:
            num = secrets.randbits(bits)
            num |= (1 << bits - 1) | 1  # Garante o tamanho e ímpar
            if Helper.is_prime(num):
                return num
