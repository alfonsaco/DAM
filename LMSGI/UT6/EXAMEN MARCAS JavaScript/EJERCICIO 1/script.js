// Alert inicial
alert("ADIVINA EL NÚMERO - La aplicación te pedirá dos valores, se generará un número aleatorio entre estos y un número de intentos para adivinar dicho número secreto. ¡SUERTE!")

// Prompts para pedir números
let min;
let max;
do{
    min=prompt("Introduce el valor mínimo del rango de números");
    max=prompt("Introduce el valor máximo del rango de números");
}while(min>max || isNaN(min) || isNaN(max) || max==0 || min==max);

let ran=Math.floor(Math.random()*(max-min)+1);

// Pedimos el número de intentos
let intentos=prompt("Introduce el número de intentos");
let intentosSobrantes=intentos;
let contIntentos=1;

let opcion;

// Intro juego
alert("Adivina el número entre "+min+" y "+max+" en "+intentos+" intentos")


const juegoAdivinar=(ran, intentos, intentosSobrantes, contIntentos) => {
    do {
        intentosSobrantes--;
        // Contador de intentos
        opcion=prompt("Intento #"+contIntentos+": ¿Cual es tu número?");
        contIntentos++;
        // Condición para ejecutar el juego
        if(opcion==ran){
            alert("¡Felicidades! Adivinaste el número en "+(contIntentos-1)+" intentos");
            break;
        }else{
            if(intentosSobrantes==0){
                alert("Agotaste tus "+intentos+" intentos. El número era "+ran);
                break;
            }
            if(ran>opcion){
                alert("El número es mayor. Te quedan "+intentosSobrantes+" intentos");
            }else{
                alert("El número es menor. Te quedan "+intentosSobrantes+" intentos");
            }
        }
    } while (intentosSobrantes>0);
}
// Llamamos al método
juegoAdivinar(ran, intentos, intentosSobrantes, contIntentos);

document.write(ran);