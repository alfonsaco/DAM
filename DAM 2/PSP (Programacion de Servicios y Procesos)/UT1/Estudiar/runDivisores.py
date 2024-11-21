import subprocess

n=input("Dame un número, te diré sus divisores: ")

result=subprocess.run(['python','divisor.py',n], capture_output=True, text=True)

print(result.stdout)