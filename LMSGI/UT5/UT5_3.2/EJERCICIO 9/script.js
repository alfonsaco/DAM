// Función para generar un array
const generarArray=() => {
    let array=[];
    for (let i=0; i<9; i++) {
        array[i]=Math.floor(Math.random()*6+1);
    }
    return array;
}
let arrayNuevo=generarArray();
// Imprimo el nuevo array generado
document.write("<strong>El array original es: </strong>"+arrayNuevo+"<br>");
// Función para eliminar los elementos no repetidos
const quitarNoRepetidos=(array) => {
    let arrayNoRep=[];
    let contadorRep=0;
    let contadorPos=0;
    for (let i=0; i<array.length; i++) {
        for (let e=0; e<array.length; e++) {
            if(array[i] == array[e]){
                contadorRep++;
            }
        }
        // Si el contador de repetidos es mayor de 1, se insertará el valor en el aarray nuevo
        if(contadorRep > 1){
            arrayNoRep[contadorPos]=array[i];
            contadorPos++;
        }
        // Ponemos el contador de repetidos a 0
        contadorRep=0;
    }
    return arrayNoRep;
}
// Llamamos a la función
let arrayNoRep=quitarNoRepetidos(arrayNuevo);
document.write("<strong>El array nuevo es: </strong>"+arrayNoRep+"<br>");