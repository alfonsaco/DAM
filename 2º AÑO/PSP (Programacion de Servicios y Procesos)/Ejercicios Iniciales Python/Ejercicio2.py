import random

print("JUEGO DE DADOS 2")
c1=random.randint(0,5)
c2=random.randint(0,5)
arrayC=[c1,c2]

d1=random.randint(0,5)
d2=random.randint(0,0)
arrayD=[d1,d2]

print(f"Carmen ha sacado un {c1} y {c2}")
print(f"David ha sacado un {d1} y {d2}")

sumaC=c1+c2
sumaD=d1+d2

if(sumaC > sumaD) :
    print("Ha ganado Carmen")
elif(sumaC == sumaD) :
    if(max(arrayC) > max(arrayD)) :
        print("Ha ganado Carmen")
    elif(max(arrayC) == max(arrayD)) :
        print("Empate")
    else :
        print("Ha ganado David")
else :
    print("Ha ganado David")