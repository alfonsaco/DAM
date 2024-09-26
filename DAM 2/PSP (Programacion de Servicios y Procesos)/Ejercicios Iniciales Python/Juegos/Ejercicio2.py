# Escriba un programa que pida un número de jugadores y tire un dado para cada
# jugador.

import random

n=int(input("¿Cuántos jugadores sois?"))

for i in range(n) :
    numero=random.randint(1,6)
    print(f"Jugador {i+1}: {numero}")