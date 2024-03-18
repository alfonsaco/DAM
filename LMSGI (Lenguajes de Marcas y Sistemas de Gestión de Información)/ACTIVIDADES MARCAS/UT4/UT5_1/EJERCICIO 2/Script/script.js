// Creamos la variable nota
let nota=prompt("Dime tu nota: ")

// Condicionales para definir la calificación
if (nota>=0 && nota<3){
    document.write("MUY DEFICIENTE")
} else if (nota>=3 && nota<5){
    document.write("INSUFICIENTE")
} else if (nota>=5 && nota<6){
    document.write("SUFICIENTE")
} else if (nota>=6 && nota<7){
    document.write("BIEN")
} else if (nota>=7 && nota<9){
    document.write("NOTABLE")
} else if (nota>=9 && nota<=10){
    document.write("SOBRESALIENTE")
} else {
    document.write("NOTA NO VÁLIDA")
}