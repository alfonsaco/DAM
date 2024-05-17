// Declaramos constantes
const divCambio=document.getElementById('divCambio');
const divEfecto=document.getElementById('efecto');

divCambio.addEventListener("mouseover", ratonHover);
// Función para poner color verde
function ratonHover(){
    divEfecto.style.backgroundColor='green';
    divEfecto.style.color='white';
}
// Función para volver al color por defecto
divCambio.addEventListener("mouseout", quitarHover);
function quitarHover(){
    divEfecto.style.backgroundColor='white';
    divEfecto.style.color='black';
}