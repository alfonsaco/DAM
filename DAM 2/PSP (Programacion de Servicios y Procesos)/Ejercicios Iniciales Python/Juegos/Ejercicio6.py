# Escriba un programa que pida un número de dados y tire esa cantidad para dos
# jugadores. El jugador que saque el valor más alto, gana.

import random

n=int(input("Número de dados: "))

# Jugador 1
mayorJ1=0
print("\n\tJ1 Dados: ", end="")
for i in range(n) :
    nRandom=random.randint(1,6)
    print(nRandom, end=" ")
    if nRandom>mayorJ1 :
        mayorJ1=nRandom

# Jugador 2
mayorJ2=0
print("\n\tJ2 Dados: ", end="")
for i in range(n) :
    nRandom=random.randint(1,6)
    print(nRandom, end=" ")
    if nRandom>mayorJ2 :
        mayorJ2=nRandom

# Resultados finales
if mayorJ2>mayorJ1 :
    print("\n\nJugador 2 gana")
elif mayorJ1==mayorJ2 :
    print("\n\nEmpate")
else :
    print("\n\nJugador 1 gana")