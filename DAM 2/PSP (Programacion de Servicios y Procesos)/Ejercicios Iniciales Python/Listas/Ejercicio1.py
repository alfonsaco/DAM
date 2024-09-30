# 1. Escriba un programa que permita crear una lista de palabras. Para ello, el programa
# tiene que pedir un nu mero y luego solicitar ese nu mero de palabras para crear la lista. Por
# u ltimo, el programa tiene que escribir la lista.

n=int(input("Dígame cuántas palabras tiene la lista: "))
# Creamos la lista
lista=[]
# Insertamos las palabras en la lista
for i in range(n) :
    palabra=input(f"Dígame la palabra {i+1}: ")
    lista.append(palabra)
# La imprimimos
print(f"La lista creada es {str(lista)}")