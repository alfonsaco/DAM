const factorial=() => {
    // Declaramos variables
    let numero=prompt("Dame un número");
    let factorial=1;
    // For para calcular el fctorial
    for (let i=1; i<=numero; i++) {
        factorial*=i;
    }
    // Imprimimos el factorial por pantalla
    document.write("Factorial del número "+numero+": "+factorial);
}
// Llamamos a la función
factorial();