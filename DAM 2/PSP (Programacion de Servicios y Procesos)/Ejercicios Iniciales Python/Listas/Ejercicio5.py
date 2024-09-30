#Escriba un programa que pida un nu mero y a continuacio n escriba la lista de todos los divisores del
# nu mero (incluidos el uno y e l mismo)

n=int(input("Dígame un número: "))

lista=[]
cont=0
# Calcular divisores
for i in range(1, n+1) : 
    if n%i == 0 :
        lista.append(i)
        cont+=1
# Resultado final
print(f"{n} tiene {cont} divisores: {str(lista)}")