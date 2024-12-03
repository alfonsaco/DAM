import subprocess

n=input("Dame un número: ")

# Llamo al subproceso
result=subprocess.run(['python','factorial.py',n], capture_output=True, text=True)

print(result.stdout)