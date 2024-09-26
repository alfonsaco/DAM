# Escriba un programa que pida un número de dados y tire esa cantidad de dados.
# El primer jugador obtiene un punto por cada dado par. El segundo jugador obtiene
# un punto por cada dado impar. El jugador que saque más puntos, gana.

import random

# Verificar que sea correcto el dado
print("PARES Y NONES")
n=int(input("Número de dados: "))

while n<=0 :
    print("¡Imposible!")
    print("DADO MÁS ALTO (1)")
    n=int(input("Número de dados: "))

# Jugador 1
contPar=0
print("\n\tDado J1: ", end="")
for i in range(n) :
    nRandom=random.randint(1,6)
    print(nRandom, end=" ")

    if nRandom%2 == 0 :
        contPar+=1

# Jugador 2
contImpar=0
print("\n\tDado J2: ", end="")
for i in range(n) :
    nRandom=random.randint(1,6)
    print(nRandom, end=" ")

    if nRandom%2 != 0 :
        contImpar+=1

# Resultado
if contImpar > contPar :
    print(f"\n\nJ2 gana con {contImpar} puntos")
else :
    print(f"\n\nJ1 gana con {contPar} puntos")
