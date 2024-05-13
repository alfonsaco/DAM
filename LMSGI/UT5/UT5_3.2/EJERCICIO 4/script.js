// Función para generar un array aleatoriamente
const generarArray=() => {
    let array=[];
    for (let i=0; i<(Math.floor(Math.random()*10+3)); i++) {
        array[i]=Math.floor(Math.random()*100+1);
    }
    return array;
}
let arrayNuevo=generarArray();
// Mostramos por pantalla el array nuevo
alert("Tu array es ["+arrayNuevo+"]");
// Función para pedir el número que queremosbuscar en el array
const pedirNumero=(array) => {
    let n;
    while(isNaN(n) || n<0 || n>100){
        n=prompt("Dime qué número quieres buscar, y te diré en qué posición está");
    }
    return n;
}
const findInex=(array, n) => {
    for (let i=0; i<array.length; i++) {
        if(n == array[i]){
            return n+" está en la posición "+i+" del array "+array;
        }
    }
    return n+" no está en el array "+array;
}
// Llamamos a los métodos
let numero=pedirNumero(arrayNuevo);
document.write(findInex(arrayNuevo, numero));