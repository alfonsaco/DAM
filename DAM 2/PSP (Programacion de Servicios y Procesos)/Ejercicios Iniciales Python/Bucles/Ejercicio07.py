# Escriba un programa que pida un numero entero mayor que 1 y que escriba si el
# numero es un nu mero primo o no.
n=int(input("Dame un número mayor que 1: "))

while n <= 1 :
    n=int(input("Dame un número mayor que 1: "))

contPrimo=0
for i in range(2, n) :
    if n%i == 0 :
        contPrimo+=1

if contPrimo > 0 :
    print(f"{n} no es primo")
else :
    print(f"{n} es primo")