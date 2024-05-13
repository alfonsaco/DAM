// Cremos la variable edad
let edad=prompt("Introduce tu edad: ")

// Función para calcular edad
const calcularEdad=() => {
    // If para verificar si puede conducir o no
    if (edad<18){
        document.write("No eres apto para conducir")
    }else{
        document.write("Ya puedes conducir")
    }    
}

// Llamamos al método
calcularEdad(edad);