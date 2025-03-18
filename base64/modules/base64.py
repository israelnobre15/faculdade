tabela_ref = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/"


class Base64:

    tabela_ref = (
        "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/"
    )

    @staticmethod
    def text_to_bin(texto):
        # Converte cada caractere em seu equivalente binário
        return "".join(format(ord(caractere), "08b") for caractere in texto)

    @staticmethod
    def add_padding_bytes(qnt_padding, bites_str):
        return bites_str + "0" * 8 * qnt_padding

    @staticmethod
    def split_bytes_str(bites_str):
        byte_list = []
        for i in range(0, len(bites_str), 6):
            byte_list.append(bites_str[i : i + 6])
        return byte_list

    @staticmethod
    def split_bytes_base64(bites_str):
        byte_list = []
        for i in range(0, len(bites_str), 8):
            byte_list.append(bites_str[i : i + 8])
        return byte_list

    @staticmethod
    def num_bytes(str):
        qnt_bites = len(str)

        return int(qnt_bites / 8)

    @staticmethod
    def padding_rule(qnt_bytes: int):
        if qnt_bytes % 3 == 1:
            return 2
        elif qnt_bytes % 3 == 2:
            return 1
        return 0

    @staticmethod
    def encoder(obj: str | bytes):
        encoded = ""
        if isinstance(obj, str):
            obj = Base64.text_to_bin(texto=obj)

        obj_padding = Base64.add_padding_bytes(
            Base64.padding_rule(Base64.num_bytes(obj)), obj
        )
        list_bytes = Base64.split_bytes_str(obj_padding)

        for bytes in list_bytes:
            if str(bytes) == "000000":
                string = "="
            else:
                string = Base64.tabela_ref[int(bytes, 2)]
            encoded += string

        return encoded

    @staticmethod
    def find_index(str_base64: str):
        str_bin = ""
        for c in str_base64:
            index = Base64.tabela_ref.find(c)
            binario = bin(index)[2:]
            binario = binario.zfill(6)
            str_bin += binario
        return str_bin

    def decoder_string(str_base64):
        string = ""

        bytes_list = Base64.split_bytes_base64(
            Base64.find_index(str_base64=str_base64)
        )
        for byte in bytes_list:
            print(int(byte, 2))
            c = chr(int(byte, 2))
            string += c

        return string
