# Escriba un programa que pregunte cua ntos nu meros se van a introducir, pida
# esos nu meros y escriba cua ntos negativos ha introducido
n=int(input("¿Cuántos numeros quieres introducir?"))
contNeg=0

for i in range(n) :
    numero=int(input("Dame un número: "))

    if numero < 0 :
        contNeg+=1

print(f"\nSe han introducido {contNeg} números negativos") 