// Declaramos constantes
const precio=document.getElementById('precio');
const cantidad=document.getElementById('cantidad');
const enviar=document.getElementById('enviar');
const total=document.getElementById('total');

enviar.addEventListener("click", calcular);
// Función para realizar la operación al hacer click
function calcular() {
    total.value=cantidad.value*precio.value;
}

