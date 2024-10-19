import sys

n = int(sys.argv[1])

arrayDivisores=[];
for i in range(1, n+1) :
    if(n%i == 0) :
        arrayDivisores.append(i)

print(f"Divisores de {n}: {arrayDivisores}")