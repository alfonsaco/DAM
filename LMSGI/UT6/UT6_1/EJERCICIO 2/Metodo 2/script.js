//PRIMER MÉTODO
// Declaramos la variable
let aviso=document.getElementById('contenedor');
// Función
aviso.addEventListener("click", saltarAviso);
// Función para que salte el aviso al pulsar en el div
function saltarAviso(){
    alert("Pulsaste sobre el botón");
}