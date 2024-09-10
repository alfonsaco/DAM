// Función para calcular el cuadrado
const cuadrado=(n) => {
    return n*n;
}
// Función para calcular el cubo
const cubo=(n) => {
    return n*n*n;
}
// Llamamos a las funciones
let numero=prompt("Dame un número");
document.write("<strong>"+numero+" AL CUADRADO: </strong>"+ cuadrado(numero)+"<br>");
document.write("<strong>"+numero+" AL CUBO: </strong>"+ cubo(numero));