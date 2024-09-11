const generarArray=() => {
    let array=[];
    for (let i=0; i<5; i++) {
        array[i]=Math.floor(Math.random()*100+1);
    }
    return array;
}
let arrayNuevo=generarArray();

// Función para pedir las posiciones
const alertas=(array) => {
    // Mensajes
    alert("Tu array es ["+array+"]");
    alert("En la próxima alerta, me dirás que posiciones del array querrás cambiar");
}
// Función para pedirle al usuario qué posición quiere cambiar
const pedirPosicion=(array) => {
    do {
        x=prompt("Dame una posición");
        // Condiciones para que no sea mayor que el array, que a y b no sean iguales, y que no sea menor de 0
    } while (isNaN(x) || x<0 || x>=array.length);
    return x;
}
// Función para cambiar la posición de los números
const cambiarPosicion=(a, b, array) => {
    // Creamos variables para sustituir los números
    let pos1=array[a];
    let pos2=array[b];
    array[a]=pos2;
    array[b]=pos1;
    return array;
}
// Llamamos a los métodos
alertas(arrayNuevo);
let a=pedirPosicion(arrayNuevo);
let b=pedirPosicion(arrayNuevo);

document.write("<strong>ARRAY INICIAL</strong><br>");
document.write(arrayNuevo+"<br><br>");

document.write("<strong>ARRAY FINAL</strong><br>");
document.write(cambiarPosicion(a,b,arrayNuevo));