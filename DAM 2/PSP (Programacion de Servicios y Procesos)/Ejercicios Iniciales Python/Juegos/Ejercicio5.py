#Escriba un programa que pida un número de dados, que tire el número de dados
# indicado y diga cuál es el valor más alto obtenido.

import random

# Verificar que es correcto el número
print("DADO MÁS ALTO (1)")
n=int(input("Número de dados: "))

while n<=0 :
    print("¡Imposible!")
    print("DADO MÁS ALTO (1)")
    n=int(input("Número de dados: "))

# Mayor dado
mayor=0
print("Dados: ", end="")
for i in range(n) :
    nRandom=random.randint(1,6)
    print(nRandom, end=" ")

    if(nRandom > mayor) :
        mayor=nRandom

print(f"\nEl valor más alto es {mayor}")