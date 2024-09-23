# Escriba un programa que pida un nu mero entero mayor que cero y que escriba sus divisores.
n=int(input("Dame un número entero mayor que 0: "))

while n <= 0 :
    n=int(input("Dame un número entero mayor que 0: "))

print(f"Los divisores de {n} son:\n")
for i in range(1, n+1) :
    if (n%i == 0) :
        print(f"{i} es divisor de {n}")