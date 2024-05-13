// Variable para la suma
let result=0;
// Función con un bucle para pedir números hasta que se pulse "cancelar"
const sumar=(result) => {
    while ((numero = prompt("Introduzca un número o pulse cancelar para salir:")) !== null) {
        if (!isNaN(numero)) {
        result += parseFloat(numero);
        } else {
            // Alerta por si se introduce algo distinto a un número
            alert("El valor introducido no es un número. Inténtelo de nuevo.");
        }
    }
    // Devolvemos el número
    return result;
}
// Imprimimos el texto por pantalla
document.write(sumar(result));