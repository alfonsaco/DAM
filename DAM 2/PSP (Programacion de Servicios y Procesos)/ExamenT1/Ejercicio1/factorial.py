import sys

n=int(sys.argv[1])

# Para evitar que el usuario no introduzca ningún valor
if len(sys.argv) < 2 :
    print("Debe proporcionar un numero")
    sys.exit(1)

# Variables
cadena=""
factorial=1

if n<0 :
    print("Número no válido. Debe ser mayor o igual que 0")
    sys.exit(1)

elif n==0 :
    cadena="0"

else :
    for i in range(1, n+1) :
        cadena+=str(i)+" "
        factorial*=i


print(f"El factorial es {cadena} = {factorial}")