# Escriba un programa que permita crear una lista de palabras y que, a
# continuacio n, pida dos palabras y sustituya la primera por la segunda en la lista.

n=int(input("Dígame cuántas palabras tiene la lista: "))
# Creamos la lista
lista=[]
# Insertamos las palabras en la lista
for i in range(n) :
    palabra=input(f"Dígame la palabra {i+1}: ")
    lista.append(palabra)

print(f"La lista creada es ahora: {str(lista)}")
# Sustituir palabras
sustituir=input("Sustituir la palabra: ")
sustituida=input("Por la palabra: ")

for i in range(len(lista)) :
    if lista[i] == sustituir :
        lista[i] = sustituida
# Lista final
print(f"La lista creada es ahora: {str(lista)}")