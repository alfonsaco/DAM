// Método para pedir el número
const pedirNumero=(numero) =>{
  // Declaramos el número
  numero=prompt("Dame tu DNI (Sin letra)");
  // If para verificar si el número es válido
  if(numero < 1 || numero > 99999999 || isNaN(numero)){
      alert("Número no válido");
  } else {
      return numero;
  }
}
// Método para pedir la letra
const pedirLetra=(letra) => {
  letra=prompt("Dame tu letra del DNI");
    // If para verificar si la letra es válida
  if(typeof letra !== 'string'){
        alert("No es una letra válida");
  } else {
        return letra;
  }
}
// Método para verificar la letra
const verificarLetra=(letraReal, letra) => {
    // If para verificar si ambas letras son iguales
    if(letraReal != letra){
        alert("Su letra \""+letra+"\" no es correcta");
    } else {
        alert("Su DNI es correcto")
    }
}
// Método para imprimir por consola
const salidaConsola=(letraReal, letra) => {
    // f. Salida con mensaje de error por consola
    if(letraReal != letra){
        console.error("Su letra \""+letra+"\" no es correcta");
    } else{
        console.log("Su letra \""+letra+"\" es correcta");
    }
}
// Método para imprimir dentro del HTML
const salidaHTML=(letraReal, letra) => {
  // g. Salida en el propio HTML
  if(letraReal != letra){
      document.write("Su letra \""+letra+"\" no es correcta");
  } else {
      document.write("Su letra \""+letra+"\" es correcta");
  }
}

// Declaramos variables llamando a los métodos
let numero=pedirNumero();
let letra=pedirLetra();
var letras = new Array('T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E');
numeroLetra=numero%23;
letraReal=letras[numeroLetra];
// Llamaos a los métodos para verificar
verificarLetra(letraReal, letra);
salidaConsola(letraReal, letra);
salidaHTML(letraReal, letra);



