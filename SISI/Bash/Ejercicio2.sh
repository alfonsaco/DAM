#!/bin/bash

for i in $(seq 1 5)
do
	echo "Dame un numero"
	read numero
	if [ $((numero%2)) == 0 ];then
		echo "Es un numero par"
	elif [ $((numero%2)) != 0 ];then
		echo "Es un numero impar"
	fi
done
