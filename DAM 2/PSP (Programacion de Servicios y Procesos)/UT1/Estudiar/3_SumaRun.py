import subprocess

n1=input("Dame el primer número: ")
n2=input("Dame el segundo número: ")

result=subprocess.run(['python3','3_Suma.py',n1,n2], capture_output=True, text=True)

print(result.stdout)