import sys

if len(sys.argv) < 2:
    print("Por favor, proporciona algún argumento")
    sys.exit(1)

n=int(sys.argv[1])
cadena=""

for i in range(1, n+1) :
    if n%i == 0 :
        cadena += str(i)+" "

print("Lo divisores son: "+cadena)