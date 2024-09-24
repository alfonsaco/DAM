# Escriba un programa que pregunte cua ntos nu meros se van a introducir, pida esos nu meros, y muestre un mensaje 
# cada vez que un nu mero no sea mayor que el anterior.
n=int(input("¿Cuántos números quieres pedir?"))

for i in range(n) :
    nuevo=int(input("Dame un número: "))

    # Pongo i>0 para que no haga la orden en el primer número
    if i > 0 :
        if nuevo <= anterior :
            print(f"{nuevo} no es mayor que {anterior}")
    anterior=nuevo