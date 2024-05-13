// 1)	Sumar todos los números en un array de números.
const definirLongitud=() => {
    let long;
    do{
        long=prompt("Dame la longitud del Array");
    }while(isNaN(long));
    return long;
}
// Función para generar el array aleatoriamente
const generarArray=(n) => {
    let array=[];
    for (let i=0; i<n; i++) {
        array[i]=Math.floor(Math.random()*100+1);
    }
    return array;
}
const mostrarArray=(array) => {
    for (let i = 0; i < array.length; i++) {
        document.write(array[i]+" ");
    }
}

// Tras esto, se ha creado un array automaticamente.
let pos=definirLongitud();
let arrayNuevo=generarArray(pos);

document.write("<strong>TU ARRAY ES:</strong><br>")
mostrarArray(arrayNuevo);

const sumarNumeros=(array) => {
    let suma=0;
    for (let i=0; i<array.length; i++) {
        suma+=array[i];
    }
    return suma;
}

document.write("<br><br>")
document.write("<strong>La suma de los números del array es</strong> "+sumarNumeros(arrayNuevo));


// 2)	Calcular el promedio de dicho array.
const media=(array) => {
    let contador=0;
    let suma=0;
    for (let i=0; i<array.length; i++) {
        suma+=array[i];
        contador++;
    }
    return suma/contador;
}
document.write("<br><br>")
document.write("<strong>La media de los números del array es</strong> "+media(arrayNuevo));


// 3)	Encontrar el número más grande de ese array.
const numeroMayor=(array) => {
    let mayor=0;
    for (let i=0; i<array.length; i++) {
        if(array[i] > mayor){
            mayor=array[i];
        }
    }
    return mayor;
}
document.write("<br><br>")
document.write("<strong>El mayor número del array es</strong> "+numeroMayor(arrayNuevo));

// 4)	Encontrar el número más pequeño.
const numeroMenor=(array) => {
    let menor=999;
    for (let i=0; i<array.length; i++) {
        if(array[i] < menor){
            menor=array[i];
        }
    }
    return menor;
}
document.write("<br><br>")
document.write("<strong>El menor número del array es</strong> "+numeroMenor(arrayNuevo));