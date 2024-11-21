import sys

# Números primos hasta el n
if len(sys.argv) < 2 :
    print("Proporcione algún argumento")
    sys.exit(1)

n=int(sys.argv[1])
cadena=""
contPrimo=0

for i in range (1, n+1) :
    contPrimo=0
    for e in range (1, i+1) :
        if(i%e == 0) :
            contPrimo+=1;
    if(contPrimo <= 2) :
        cadena+=str(i)+" "

print("Los primos que contien el número son "+cadena)