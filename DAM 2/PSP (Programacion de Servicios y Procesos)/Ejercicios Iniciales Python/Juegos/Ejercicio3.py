# Escriba un programa que pida un número de jugadores y un valor que se pretende
# conseguir. A continuación, se tira un dado para cada jugador y el programa debe
# decir qué jugador ha conseguido obtener el valor.

import random

n=int(input("Introduce el número de jugadores: "))
valor=int(input("Introduce el valor que se pretende conseguir (Entre 1 y 6): "))

# Bucle para que no se introduzca menos de 1 o más de 6
while valor < 1 or valor > 6 :
    valor=int(input("Introduce el valor que se pretende conseguir (Entre 1 y 6): "))

contValor=0
for i in range(n) :
    nRandom=random.randint(1,6)
    if nRandom == valor :
        print(f"Jugador {i+1} ha conseguido obtener el valor")
        contValor+=1

# Contador, para el caso en que ningún jugador haya obtenido el valor
if contValor==0 :
    print("Ningún jugador ha obtenido el valor")