const inputLetras=document.getElementById('letras');

inputLetras.addEventListener("input", quitarNumeros);
function quitarNumeros() {
  let valorInput=inputLetras.value;
  let soloLetras = /^[A-Za-z]+$/;
  // Utilizamos .test para comprobar si la cadena cumple con el valor especificado
  if (!soloLetras.test(valorInput)) {
    // Sustituye los números por ''
    inputLetras.value = valorInput.replace(/[^A-Za-z]/g, '')
}
}