from constants import K_bits


class SHA256:
    def __init__(self, word: str):
        self.word = word
        self.word_len = len(word)
        self.bin_word = self.str_to_bin()
        self.bin_word_len = format(
            self.word_len * 8, "064b"
        )  # comprimento original em bits com 64 bits de largura
        self.padding = self.calc_multiplo()
        self.full_word_bin = self.binired_word()
        self.chuncks_512 = []
        self.separa_chuncks()
        self.h0 = "01101010000010011110011001100111"
        self.h1 = "10111011011001111010111010000101"
        self.h2 = "00111100011011101111001101110010"
        self.h3 = "10100101010011111111010100111010"
        self.h4 = "01010001000011100101001001111111"
        self.h5 = "10011011000001010110100010001100"
        self.h6 = "00011111100000111101100110101011"
        self.h7 = "01011011111000001100110100011001"

    def str_to_bin(self):
        return "".join(
            format(ord(caractere), "08b") for caractere in self.word
        )

    def calc_multiplo(self):
        # Calcula o comprimento da palavra em bits
        bit_length = self.word_len * 8
        # O comprimento final (considerando o bit 1 e o comprimento da mensagem)
        total_length = (
            bit_length + 1 + 64
        )  # +1 para o bit '1' e +64 para o comprimento original da palavra

        # Calcula o padding necessário para que o comprimento total seja múltiplo de 512
        padding = (
            512 - (total_length % 512)
        ) % 512  # Garantir que o valor seja entre 0 e 511
        return padding

    def binired_word(self):
        # Monta a palavra final com o bit '1', o padding calculado e o comprimento original da mensagem
        full_word_bin = (
            self.bin_word
            + "1"  # Adiciona o bit '1'
            + "0" * self.padding  # Adiciona o padding necessário (zeros)
            + self.bin_word_len  # Adiciona o comprimento original da palavra em binário (64 bits)
        )
        return full_word_bin

    def separa_chuncks(self):
        # Calcula o número de pedaços completos de 512 bits
        len_chuncks = len(self.full_word_bin) // 512

        # Itera sobre os pedaços, avançando de 512 em 512
        for i in range(len_chuncks):
            chunck = self.full_word_bin[i * 512 : (i + 1) * 512]
            self.chuncks_512.append(chunck)

    def rotate(self, binary_string, n_bits):

        binary_value = int(binary_string, 2)

        total_bits = len(binary_string)
        rotated_value = (binary_value >> n_bits) | (
            binary_value << (total_bits - n_bits)
        )

        rotated_value &= (1 << total_bits) - 1
        rotated_binary_string = bin(rotated_value)[2:].zfill(total_bits)

        return rotated_binary_string

    def shift(self, binary_string, n_bits):
        binary_value = int(binary_string, 2)

        total_bits = len(binary_string)
        rotated_value = binary_value >> n_bits

        rotated_value &= (1 << total_bits) - 1
        rotated_binary_string = bin(rotated_value)[2:].zfill(total_bits)

        return rotated_binary_string

    def calculate_o1(self, indice):
        rotate_7 = self.rotate(indice, 17)
        rotate_18 = self.rotate(indice, 19)
        shift_3 = self.shift(indice, 10)

        num_1 = int(rotate_7, 2)
        num_2 = int(rotate_18, 2)
        num_3 = int(shift_3, 2)

        xor_result = num_1 ^ num_2 ^ num_3
        xor_result_binary = bin(xor_result)[2:]

        xor_result_binary = xor_result_binary.zfill(len(rotate_7))
        return xor_result_binary

    def calculate_o0(self, indice):
        rotate_7 = self.rotate(indice, 7)
        rotate_18 = self.rotate(indice, 18)
        shift_3 = self.shift(indice, 3)

        num_1 = int(rotate_7, 2)
        num_2 = int(rotate_18, 2)
        num_3 = int(shift_3, 2)

        xor_result = num_1 ^ num_2 ^ num_3
        xor_result_binary = bin(xor_result)[2:]

        xor_result_binary = xor_result_binary.zfill(len(rotate_7))
        return xor_result_binary

    def sigma_1(self, bin_string):
        rotate_6 = self.rotate(bin_string, 6)
        rotate_11 = self.rotate(bin_string, 11)
        rotate_25 = self.rotate(bin_string, 25)

        num_1 = int(rotate_6, 2)
        num_2 = int(rotate_11, 2)
        num_3 = int(rotate_25, 2)

        xor_result = num_1 ^ num_2 ^ num_3
        xor_result_binary = bin(xor_result)[2:]

        xor_result_binary = xor_result_binary.zfill(len(rotate_6))
        return xor_result_binary

    def sigma_0(self, bin_string):
        rotate_2 = self.rotate(bin_string, 2)
        rotate_13 = self.rotate(bin_string, 13)
        rotate_22 = self.rotate(bin_string, 22)

        num_1 = int(rotate_2, 2)
        num_2 = int(rotate_13, 2)
        num_3 = int(rotate_22, 2)

        xor_result = num_1 ^ num_2 ^ num_3
        xor_result_binary = bin(xor_result)[2:]

        xor_result_binary = xor_result_binary.zfill(len(rotate_2))
        return xor_result_binary

    def choice(self, e, f, g):
        e_int = int(e, 2)
        f_int = int(f, 2)
        g_int = int(g, 2)
        choice = (e_int & f_int) ^ ((~e_int) & g_int)
        # choice &= (1 << len(e)) - 1
        choice_bin = bin(choice)[2:].zfill(32)
        return choice_bin

    def temp_1(self, h, sigma_1, choice, indice_k, indice_w):
        h_num = int(h, 2)
        sigma_num = int(sigma_1, 2)
        choice_num = int(choice, 2)
        indice_k_num = int(indice_k, 2)
        indice_w_num = int(indice_w, 2)
        sum_bin = h_num + sigma_num + choice_num + indice_k_num + indice_w_num
        sum_bin &= (1 << 32) - 1
        result = bin(sum_bin)[2:].zfill(32)
        return result

    def temp_2(
        self,
        majority,
        sigma_0,
    ):
        majority_num = int(majority, 2)
        sigma_num = int(sigma_0, 2)
        sum_bin = majority_num + sigma_num
        sum_bin &= (1 << 32) - 1
        result = bin(sum_bin)[2:].zfill(32)
        return result

    def majority(self, a, b, c):
        a_num = int(a, 2)
        b_num = int(b, 2)
        c_num = int(c, 2)
        majority = (a_num & b_num) ^ (a_num & c_num) ^ (b_num & c_num)
        majority_bin = bin(majority)[2:].zfill(32)
        return majority_bin

    def sum_bin(self, bin_1, bin_2):
        bin1_num = int(bin_1, 2)
        bin2_num = int(bin_2, 2)
        sum_bin = bin1_num + bin2_num
        sum_bin &= (1 << 32) - 1
        result = bin(sum_bin)[2:].zfill(32)
        return result

    def process_chuncks(self):

        for chunck in self.chuncks_512:
            a = self.h0
            b = self.h1
            c = self.h2
            d = self.h3
            e = self.h4
            f = self.h5
            g = self.h6
            h = self.h7
            # print(len(list_64_bits))
            list_64_bits = []

            # Realiza embaralhamento de chuncks complementando todos os 64 indices com informações de 32 bits
            for i in range(0, len(chunck), 32):
                list_64_bits.append(chunck[i : i + 32])

            while len(list_64_bits) <= 63:
                list_64_bits.append("0" * 32)

            w0 = 0
            w1 = 1
            w9 = 9
            w14 = 14
            for i in range(16, 64, 1):
                o0 = self.calculate_o0(list_64_bits[w1])
                o1 = self.calculate_o1(list_64_bits[w14])
                bin_int1 = int(list_64_bits[w0], 2)
                bin_int2 = int(list_64_bits[w9], 2)
                bin_int3 = int(o0, 2)
                bin_int4 = int(o1, 2)
                sum_bin = bin_int1 + bin_int2 + bin_int3 + bin_int4
                sum_bin &= (1 << 32) - 1
                list_64_bits[i] = bin(sum_bin)[2:].zfill(32)
                w0 += 1
                w1 += 1
                w9 += 1
                w14 += 1
            # _____________________________________
            for i in range(0, 64, 1):
                sigma_1 = self.sigma_1(e)
                choice = self.choice(e=e, f=f, g=g)
                sigma_0 = self.sigma_0(a)
                temp1 = self.temp_1(
                    h=h,
                    sigma_1=sigma_1,
                    choice=choice,
                    indice_k=K_bits[i],
                    indice_w=list_64_bits[i],
                )
                majority = self.majority(a=a, b=b, c=c)
                temp_2 = self.temp_2(majority=majority, sigma_0=sigma_0)
                h = g
                g = f
                f = e
                e = self.sum_bin(bin_1=d, bin_2=temp1)
                d = c
                c = b
                b = a
                a = self.sum_bin(bin_1=temp1, bin_2=temp_2)

            self.h0 = self.sum_bin(bin_1=self.h0, bin_2=a)
            self.h1 = self.sum_bin(bin_1=self.h1, bin_2=b)
            self.h2 = self.sum_bin(bin_1=self.h2, bin_2=c)
            self.h3 = self.sum_bin(bin_1=self.h3, bin_2=d)
            self.h4 = self.sum_bin(bin_1=self.h4, bin_2=e)
            self.h5 = self.sum_bin(bin_1=self.h5, bin_2=f)
            self.h6 = self.sum_bin(bin_1=self.h6, bin_2=g)
            self.h7 = self.sum_bin(bin_1=self.h7, bin_2=h)

        binary_final = [
            self.h0,
            self.h1,
            self.h2,
            self.h3,
            self.h4,
            self.h5,
            self.h6,
            self.h7,
        ]

        hex_str = ""
        for binario in binary_final:
            for i in range(0, len(binario), 8):
                bin_int = int(binario[i : i + 8], 2)
                hex_atual = hex(bin_int)[2:]
                hex_str += hex(bin_int)[2:].zfill(2)
                hex_str.zfill(1)
                print(hex_atual)

        return hex_str


# Exemplo de uso
sha256 = SHA256("teste")

print(sha256.process_chuncks())
