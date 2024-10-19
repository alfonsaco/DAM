import subprocess

n = input("Dame un número: ")

result = subprocess.run(['python3', 'divisores.py', n], capture_output=True, text=True)

print(result.stdout)