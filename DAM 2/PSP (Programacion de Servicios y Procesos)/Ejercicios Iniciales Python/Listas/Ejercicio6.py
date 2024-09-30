#Escriba un programa que pida un nu mero y a continuacio n escriba la lista de 
# todos los nu meros primos hasta el

n=int(input("Dame un número: "))
# Declaramos variables
lista=[]
contPrimo=0

for i in range(1, n+1) :
    for e in range(1, i+1) :
        if i%e == 0 :
            contPrimo+=1
    # Si es menor o igual a 2, será primo
    if contPrimo <= 2 :
        lista.append(i)
    # Volvemos a ponerlo a 0
    contPrimo=0
# Lista final
print(f"Primos hasta {n}: {str(lista)}")