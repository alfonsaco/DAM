// Declaramos variables
let a;
let b;
// Do while para pedir números solo
do {
    a=prompt("Dame el primer número");
    b=prompt("Dame el segundo número");
} while (isNaN(a) || isNaN(b) || a<0 || b<0);
// Hacemos la operación
let potencia=a**b;
document.write(a+" elevado a "+b+" es "+potencia);