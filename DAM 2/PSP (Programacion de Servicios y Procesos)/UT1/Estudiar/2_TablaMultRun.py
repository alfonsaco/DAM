import subprocess

n=input("Dame un número: ")

result=subprocess.run(['python','2_TablaMult.py',n], capture_output=True, text=True)

print(result.stdout)