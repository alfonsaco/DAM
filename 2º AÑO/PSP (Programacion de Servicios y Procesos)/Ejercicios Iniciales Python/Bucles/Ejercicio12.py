# Escriba un programa que pida un nu mero entero mayor que cero y calcule su factorial.
n=int(input("Introduce un número: "))

factorial=1

# For para calcular el factorial
for i in range(1, n+1) :
    factorial*=i

print(f"\El factorial de {n} es {factorial}")