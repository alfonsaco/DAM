const cambioColor=document.getElementById('cambioColor');
// Evento para que la función se ejecute al cargar el DOM
window.addEventListener('load', enCarga);

function enCarga(){
    // Cambiar color
    cambioColor.addEventListener('mouseover', ratonHover);
    function ratonHover(){
        cambioColor.style.backgroundColor='red';
    }
    // Reestablecer color por defecto
    cambioColor.addEventListener('mouseout', quitarRaton);
    function quitarRaton(){
        cambioColor.style.backgroundColor='white';
    }
}