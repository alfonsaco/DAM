// Declaramos constantes
const numero=document.getElementById('numero');
const sumar=document.getElementById('sumar');
const restar=document.getElementById('restar');
const reset=document.getElementById('reset');
// Declaro el contador
let contador=0;

// Función para sumar y poner color verde
sumar.addEventListener("click", sumarNumero);
function sumarNumero() {
    contador++;
    numero.innerText=contador;
    colores(contador);
}

// Función para restar y poner color rojo
restar.addEventListener("click", restarNumero);
function restarNumero() {  
    contador--;
    numero.innerText=contador;
    colores(contador);
}

// Función para poner a 0 el contador al pulsar reset
reset.addEventListener("click", reseteo);
function reseteo() {
    numero.style.color='rgb(19, 19, 19)';
    contador=0;
    numero.innerText=contador;
    colores(contador);
}


const colores=(contador) => {
    if(contador<0){
        numero.style.color='#DB3545';
        // Si el número es 0, se pone negro
    }else if(contador==0){
        numero.style.color='rgb(19, 19, 19)';
    }else{
        numero.style.color='rgb(25, 135, 84)';
    }
}