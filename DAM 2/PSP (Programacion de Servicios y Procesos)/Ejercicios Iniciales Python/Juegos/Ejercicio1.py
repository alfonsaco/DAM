# Escriba un programa que pida un número de dados y muestre los valores de ese
# número de dados, al azar.

import random

print("TIRADA DE DADOS")
tiro=int(input("Número de dados: "))   

# Verificar que tiro no sea igual a 0
while tiro <= 0 :
    print("¡Imposible!")
    print("TIRADA DE DADOS")
    tiro=int(input("Número de dados: "))   

# Imprimos los dados
print("Dados: ")
for i in range(tiro) :
    n=random.randint(1,6)
    print(n, end=" ")