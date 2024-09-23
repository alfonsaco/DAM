# Escriba un programa que pregunte cua ntos numeros se van a introducir, pida esos nu meros, y muestre un 
# mensaje cada vez que un numero no sea mayor que el primero.
cantidad=int(input("¿Cuantos números quieres pedir?"))

for i in range(cantidad) :
    n=int(input("Dame un número: "))

    if i == 0 :
        primero=n

    if(n <= primero and n != primero) :
        print(f"{n} es menor o igual que {primero}")
    