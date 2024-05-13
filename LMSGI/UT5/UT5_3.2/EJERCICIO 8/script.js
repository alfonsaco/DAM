// Función para generar un array aleatorio
const generarArray=() => {
    let array=[];
    for (let i=0; i<9; i++) {
        array[i]=Math.floor(Math.random()*4+1);
    }
    return array;
}
let arrayNuevo=generarArray();
// Imprimimos el nuevo array
document.write("<strong>El array original es: </strong>"+arrayNuevo+"<br>");
// Función para quitar todos los repetidos del array
const quitarTodosRepetidos=(array) => {
    let arrayNoRep=[];
    let contadorRep=0;
    let contadorPos=0;
    for (let i=0; i<array.length; i++) {
        for (let e=0; e<array.length; e++) {
            if(array[i] == array[e]){
                contadorRep++;
            }
        }
        if(contadorRep == 1){
            arrayNoRep[contadorPos]=array[i];
            contadorPos++;
        }
        contadorRep=0;
    }
    return arrayNoRep;
}
const quitarRepetidos=(array) => {
    let arrayNoRep = [];
    for (let i = 0; i < array.length; i++) {
        if (arrayNoRep.indexOf(array[i]) === -1) {
            arrayNoRep.push(array[i]);
        }
    }
    return arrayNoRep;
}
// Llamamos a la función
let arrayNoRep=quitarRepetidos(arrayNuevo);
document.write("<strong>El array nuevo es: </strong>"+arrayNoRep+"<br>");
document.write("<strong>El array si descartamos cualquier elemento que esté repetido es: </strong>"+quitarTodosRepetidos(arrayNuevo));