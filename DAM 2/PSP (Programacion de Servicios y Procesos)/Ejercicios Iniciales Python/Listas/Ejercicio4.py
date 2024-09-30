# Escriba un programa que permita crear una lista de palabras y que, a
# continuacio n, pida una palabra y elimine esa palabra de la lista

n=int(input("Dígame cuántas palabras tiene la lista: "))
# Creamos la lista
lista=[]
# Insertamos las palabras en la lista
for i in range(n) :
    palabra=input(f"Dígame la palabra {i+1}: ")
    lista.append(palabra)

print(f"La lista creada es ahora: {str(lista)}")

# Eliminar la palabra en cuestión
eliminar=input("Palabra a eliminar: ")
while eliminar in lista : 
    lista.remove(eliminar)

# Lista 
print(f"La lista creada es ahora: {str(lista)}")