import psutil
import time

for proc in psutil.process_iter() :
    try :
        nombreProceso = proc.name()
        if proc.name() == "notepad.exe" :
            PID=proc.id
            time.sleep(5)
            print("Eliminando el proceso: ", nombreProceso,' ::: ', PID)
            proc.kill()
    except (psutil.NoSuchProcess, psutil.AcessDenied, psutil.ZombieProcess) :
        print("ERROR")