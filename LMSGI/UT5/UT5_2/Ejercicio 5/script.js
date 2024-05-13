// Declaramos el número
let numero=prompt("Dame tu DNI (Sin letra)");
// If para verificar si el número es válido
if(numero < 1 || numero > 99999999){
    alert("Número no válido");
}

let letra=prompt("Dame tu letra del DNI");
// If para verificar si la letra es válida
if(typeof letra !== 'string'){
    alert("No es una letra válida");
}
// Array de letras
var letras = new Array('T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E');
numeroLetra=numero%23;
letraReal=letras[numeroLetra];
// If para verificar si ambas letras son iguales
if(letraReal != letra){
    alert("Su letra \""+letra+"\" no es correcta");
}


// f. Salida con mensaje de error por consola
if(letraReal != letra){
    console.error("Su letra \""+letra+"\" no es correcta");
}

// g. Salida en el propio HTML
if(letraReal != letra){
    document.write("Su letra \""+letra+"\" no es correcta");
}