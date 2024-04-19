// Variable para la suma
let suma = 0;

// Bucle para pedir números hasta que se pulse "cancelar"
while ((numero = prompt("Introduzca un número o pulse cancelar para salir:")) !== null) {
        if (!isNaN(numero)) {
        suma += parseFloat(numero);
    } else {
        // Alerta por si se introduce algo distinto a un número
        alert("El valor introducido no es un número. Inténtelo de nuevo.");
    }
}

// Imprimimos el texto por pantalla
document.write(suma);