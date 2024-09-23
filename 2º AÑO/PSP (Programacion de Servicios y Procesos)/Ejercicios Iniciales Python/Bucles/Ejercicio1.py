print("PARES E IMPARES")
n1=int(input("Escriba un número entero: "))
n2=int(input(f"Escriba un número mayor o igual que {n1}: "))

# Función
def verificarNumero(n) :
    if n%2 == 0 :
        print(f"{n} es par")
    else :
        print(f"{n} es impar")

# Verificar si es mayor o no el n1 que el n2
while n1 > n2 :
    print(f"¡Le he pedido un número entero mayor o igual que {n1}\n")
    print("PARES E IMPARES")
    n1=int(input("Escriba un número entero: "))
    n2=int(input(f"Escriba un número mayor o igual que {n1}: "))

verificarNumero(n1)
verificarNumero(n2)