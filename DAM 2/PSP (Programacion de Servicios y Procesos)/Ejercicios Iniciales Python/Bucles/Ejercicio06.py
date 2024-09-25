# Escriba un programa que pregunte cua ntos nu meros se van a introducir, pida
# esos nu meros, y diga al final cua ntos han sido pares y cua ntos impares.
n=int(input("¿Cuántos números quieres introducir?"))

contPar=0
contImpar=0
for i in range(n) :
    numero=int(input("Dame un número: "))

    if numero%2 == 0 :
        contPar+=1
    else :
        contImpar+=1

print(f"\nTotal pares: {contPar}\nTotal impares: {contImpar}")