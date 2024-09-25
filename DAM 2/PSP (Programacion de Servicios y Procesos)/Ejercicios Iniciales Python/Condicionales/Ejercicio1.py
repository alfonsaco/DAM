import random

print('JUEGO DE DADOS')
j1=random.randint(0,10)
j2=random.randint(0,10)

print(f"J1 TIENE UN {j1}")
print(f"J2 TIENE UN {j2}")

if(j1 > j2) :
    print(f"J1 HA GANADO CON UN {j1}")
elif(j1 == j2) :
    print("EMPATE")
else :
    print(f"J2 HA GANADO CON UN {j2}")