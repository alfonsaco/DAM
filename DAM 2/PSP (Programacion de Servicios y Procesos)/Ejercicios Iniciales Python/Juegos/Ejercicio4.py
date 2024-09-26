# Escriba un programa que pida un número de dados, un valor a objetivo y que tire
# después el número de dados indicado. El jugador gana si saca el valor ganador.

import random

# Verificar que es correcto el número
print("OBTENER VALOR (2)")
n=int(input("Número de dados: "))

while n<=0 :
    print("¡Imposible!")
    print("OBTENER VALOR (2)")
    n=int(input("Número de dados: "))

# Verificar que es correcto el valor
valor=int(input("Valor a conseguir: "))
while valor<0 or valor>6 :
    print(f"¡Imposible conseguir un {valor}!")
    valor=int(input("Valor a conseguir: "))

# Dados random
print("Dados: ", end="")
contResult=0
for i in range(n) :
    nRandom=random.randint(1,6)
    print(nRandom, end=" ")
    if(nRandom == valor) :
        contResult+=1

# Resultado
if(contResult == 0) :
    print("\nEl jugador ha perdido")
else :
    print("\nEl jugador ha ganado")