# Escriba un programa que pida dos nu meros enteros y escriba la suma de todos los
# enteros desde el primer nu mero hasta el segundo.
n1=int(input("Dame un número entero: "))
n2=int(input("Dame otro número entero: "))

suma=0
if n1 > n2 :
    for i in range(n2+1, n1) :
        suma+=i
else :
    for i in range(n1+1, n2) :
        suma+=i

print(f"Suma total de número entre {n1} y {n2} = {suma}")