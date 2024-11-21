import sys

if len(sys.argv) < 2 :
    print("Proporcione algún argumento")
    sys.exit(1)

n=int(sys.argv[1])

for i in range(10) :
    print(f"{n} x {i+1} = {(i+1)*n}")