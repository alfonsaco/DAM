#!/bin/bash

letra=A

while [ "$letra" != "C" ]
do
	echo "A. Mostrar la fecha y hora actual"
	echo "B. Mostrar el directorio actual"
	echo "C. Salir"
	read letra
	if [ "$letra" == "A" ];then
		pwd
	elif [ "$letra" == "B" ];then
		time
	fi
done

