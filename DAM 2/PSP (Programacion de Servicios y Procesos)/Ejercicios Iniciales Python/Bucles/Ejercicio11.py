# Escriba un programa que pregunte cua ntos nu meros se van a introducir, pida esos
# nu meros, y escriba el mayor, el menor y la media aritme tica. Recuerda que la media
# aritme tica de un conjunto de valores es la suma de esos valores dividida por la cantidad de
# valores.
n=int(input("¿Cuántos números quieres introducir?"))

# Variables
mayor=0
menor=99999
suma=0

for i in range(n) :
    numero=int(input("Introduce un número: "))

    # Condicionales para el mayor y menor
    if mayor < numero :
        mayor=numero
    
    if menor > numero :
        menor=numero
    
    suma+=numero

media=(suma/n)
print(f"\nEl menor número es {menor} \nEl mayor número es {mayor}\nLa media es {media}")