const potencia=() => {
    // Declaramos variables
    let a;
    let b;
    let pot=1;
    // Do while para pedir números solo
    do {
        a=prompt("Dame el primer número");
        b=prompt("Dame el segundo número");
    } while (isNaN(a) || isNaN(b) || a<0 || b<0);
    // Hacemos la operación
    for (let i=0; i<b; i++) {
        pot*=a;
    }
    // Imprimimos
    document.write(a+" elevado a "+b+" es "+pot);
}
// Llamamos al método
potencia();