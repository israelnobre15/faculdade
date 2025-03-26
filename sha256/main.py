# Strings binárias de exemplo
binary_string1 = "01100010011000100110001001100010"
binary_string2 = "01001100010011000100110001001100"
binary_string3 = "00000110001001100010011000100110"

# Converter as strings binárias para inteiros
num1 = int(binary_string1, 2)
num2 = int(binary_string2, 2)
num3 = int(binary_string3, 2)

# Realizar a operação XOR
xor_result = num1 ^ num2 ^ num3

# Converter o resultado de volta para uma string binária
xor_result_binary = bin(xor_result)[2:]

# Para garantir que a string resultante tenha o mesmo comprimento das strings de entrada
xor_result_binary = xor_result_binary.zfill(len(binary_string1))

print(xor_result_binary)  # Saída do resultado XOR
