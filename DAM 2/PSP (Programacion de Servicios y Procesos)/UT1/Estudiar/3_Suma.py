import sys

if len(sys.argv) < 3 :
    print("Dame 2 argumentos")
    sys.exit(1)

n1=int(sys.argv[1])
n2=int(sys.argv[2])

print("La suma es "+str(n1+n2))