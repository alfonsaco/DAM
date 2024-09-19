import random

print("JUEGO DEL QUINCE")

g1=random.randint(1,10)
g2=random.randint(1,10)
g3=random.randint(1,10)

h1=random.randint(1,10)
h2=random.randint(1,10)
h3=random.randint(1,10)

sumaG=g1+g2+g3
sumaH=h1+h2+h3

print(f"Gloria ha sacado {g1}, {g2} y {g3}. TOTAL: {sumaG}")
print(f"Hector ha sacado {h1}, {h2} y {h3}. TOTAL: {sumaH}")

if(sumaG < 15 and sumaH < 15) :
    if(sumaG > sumaH) :
        print("Ha ganado Gloria")
    elif(sumaG == sumaH) :
        print("Empate")
    else :
        print("Ha ganado Hector")
elif(sumaG >= 15 and sumaH >= 15) :
    print("Ambos pierden")
elif(sumaH >= 15 and sumaG < 15) :
    print("Gloria ha ganado")
elif(sumaG >= 15 and sumaH < 15) :
    print("Hector ha ganado")