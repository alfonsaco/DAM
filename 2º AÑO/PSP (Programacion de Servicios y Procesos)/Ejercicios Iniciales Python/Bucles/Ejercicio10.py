# Mejora el programa anterior haciendo que el programa escriba la suma realizada
n1=int(input("Dame un número entero: "))
n2=int(input("Dame otro número entero: "))

cadena=''
suma=0
if n1 > n2 :
    for i in range(n2+1, n1) :
        suma+=i
        cadena+=f'{i} + '
else :
    for i in range(n1+1, n2) :
        suma+=i
        cadena+=f'{i} + '

cadena=cadena[:-3]
cadena+=f' = {suma}'
print(cadena)