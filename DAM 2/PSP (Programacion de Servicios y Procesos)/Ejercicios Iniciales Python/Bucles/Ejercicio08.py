# Escriba un programa que pregunte cuantos nu meros se van a introducir, pida esos
# nu meros (que puedan ser decimales) y calcule su suma.
n=int(input("¿Cuantos números quieres introducir?"))
suma=0

for i in range(n) :
    numero=float(input("Dame un número: "))
    suma+=numero

print(suma)