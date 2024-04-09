#!/bin/bash

echo "Dame el primer numero"
read a

echo "Dame el segundo número"
read b

suma(){
	echo "$((a+b))"
}

resta(){
	echo "$((a-b))"
}

multi(){
	echo "$((a*b))"
}

division(){
	echo "$((a/b))"
}

echo "¿Que operacion quieres realizar?"
echo "1. Suma"
echo "2. Resta"
echo "3. Multiplicacion"
echo "4. Division"
read opcion

case $opcion in
	1)
		suma
	;;
	2)
		resta
	;;
	3)
		multi
	;;
	4)
		division
	;;
esac
