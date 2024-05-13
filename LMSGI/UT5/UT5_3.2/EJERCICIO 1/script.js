// EJERCICIO 1
let array=[1,2,3,4,5,6];

// Iterar por todos los elementos dentro de un array utilizando while y mostrarlos en pantalla.
const iterarWhile=(array) => {
    let cont=0;
    while(cont<array.length){
        document.write(array[cont]+" ");
        cont++;
    }
}
// Iterar por todos los elementos dentro de un array utilizando for y mostrarlos en pantalla.
const iterarFor=(array) => {
    for (let i=0; i<array.length; i++) {
        document.write(array[i]+" ");
    }
}
// Iterar por todos los elementos dentro de un array utilizando .forEach y mostrarlos en pantalla.
const iterarForEach=(array) => {
    array.forEach(i => {
        document.write(array[i-1]+" ")
    });
}
// Mostrar todos los elementos dentro de un array sumándole uno a cada uno.
const iterarMasUno=(array) => {
    for (let i=0; i<array.length; i++) {
        document.write((array[i]+1)+" ");
    }
}
// Generar una copia de un array, pero con todos los elementos incrementado en 1.
const crearArray=(array) => {
    let arrayNuevo=[];
    for (let i=0; i<array.length; i++) {
        arrayNuevo[i]=(array[i]+1);
    }
    return arrayNuevo;
}
let arrayNuevo=crearArray(array);

document.write("<strong>Iterar con While:</strong> <br>");
iterarWhile(array);

document.write("<br><br><strong>Iterar con For:</strong> <br>");
iterarFor(array);

document.write("<br><br><strong>Iterar con For Each:</strong> <br>");
iterarForEach(array);

document.write("<br><br><strong>Iterar sumando 1:</strong> <br>");
iterarMasUno(array);

document.write("<br><br><strong>Copia de array incrementado a 1:</strong> <br>");
iterarFor(arrayNuevo);



// EJERCICIO 2
// Crear un array vacío, luego generar 20 números al azar y guardarlos en un array.
document.write("<br><br><hr><br>");
// Declaramos el array vacio
const arrayRandom=(n) => {
    let array=[];
    for (let i=0; i<n; i++) {
        array[i]=Math.floor(Math.random()*100+1);
    }
    return array;
}
// Indicamos la longitud del array llamando al método
let arrayVacio=arrayRandom(20)

document.write("<strong>Array random:</strong> <br>");
iterarFor(arrayVacio);



// EJERCICIO 3
// Crear un array vacío, luego generar N números al azar y guardarlos en un array, N es introducido por el 
// usuario a través de un prompt.
document.write("<br><br><hr><br>");

let opcion;
while(isNaN(opcion)){
    opcion=prompt("¿De cuantas posiciones quieres que sea el array?")
}

let arrayVacio2=arrayRandom(opcion);
document.write("<strong>Tu array:</strong> <br>");
iterarFor(arrayVacio2);



// EJERCICIO 4
// Dado un array que contiene ["azul", "amarillo", "rojo", "verde", "café", "rosa"] determinar si un color 
// introducido por el usuario a través de un prompt se encuentra dentro del array o no.
document.write("<br><br><hr><br>");
let colores=["azul", "amarillo", "rojo", "verde", "café", "rosa"];
// Funciñon para verificar si el color está o no
const verificarArray=(opcion, array) => {
    for (let i=0; i<array.length; i++) {
        if(color === array[i]){
            return "El color "+opcion+" está presente en el array";
        }
    }
    return "El color "+opcion+" NO está presente en el array";
}

let color=prompt("Dame color");
document.write(verificarArray(color, colores));