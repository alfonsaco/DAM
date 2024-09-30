# Escriba un programa que permita crear una lista de palabras y que, a
# continuacio n, pida una palabra y diga cua ntas veces aparece esa palabra en la lista.

n=int(input("Dime cuántas palabras quieres que tenga la lista: "))

lista=[]

for i in range(n) :
    palabra=input(f"Dime la palabra {i+1}: ")
    lista.append(palabra)

print(f"La lista creada es {str(lista)}")
# Buscar la palabra en la lista
palabraBuscar=input("Dígame la palabra a buscar: ")
contPal=0

for i in range(len(lista)) :
    if lista[i] == palabraBuscar :
        contPal+=1
# Resultado
print(f"La palabra {palabraBuscar} aparece {contPal} veces en la lista")