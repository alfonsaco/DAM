// Declaramos variables
let cadena='';
let result;

// Función para concatenar cadenas
const concatenar=(result, cadena) => {
    do{
      result=prompt("Dame un texto:");
      if(result!=null){
        cadena+=result+' - ';
      }
    }while(result!=null);
    // Substring para quitar los últimos carácteres
    return cadena.substring(0, cadena.length-3);
}
// Imprimimos las cadenas
document.write(concatenar(result, cadena));