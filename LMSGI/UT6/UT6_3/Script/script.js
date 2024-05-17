// Constante para el campo de texto
const escribir=document.getElementById('campoTexto');

// Constantes para los números
const cero=document.getElementById('cero');
const uno=document.getElementById('uno');
const dos=document.getElementById('dos');
const tres=document.getElementById('tres');
const cuatro=document.getElementById('cuatro');
const cinco=document.getElementById('cinco');
const seis=document.getElementById('seis');
const siete=document.getElementById('siete');
const ocho=document.getElementById('ocho');
const nueve=document.getElementById('nueve');
const punto=document.getElementById('punto');

// Constantes para las funciones de borrar, solución y resetear
const reset=document.getElementById('reset');
const delet=document.getElementById('delete');
const result=document.getElementById('igual');

// Constantes para los operadores
const mas=document.getElementById('mas');
const menos=document.getElementById('menos');
const multi=document.getElementById('multi');
const division=document.getElementById('division');

// Variable cadena
let cadena='';


// Eventos para la letras
cero.addEventListener("click", numeroCero);
function numeroCero() {
    cadena+=0;
    escribir.value=cadena;
}
uno.addEventListener("click", numeroUno);
function numeroUno() {
    cadena+=1;
    escribir.value=cadena;

}
dos.addEventListener("click", numeroDos);
function numeroDos() {
    cadena+=2;
    escribir.value=cadena;

}
tres.addEventListener("click", numeroTres);
function numeroTres() {
    cadena+=3;
    escribir.value=cadena;

}
cuatro.addEventListener("click", numeroCuatro);
function numeroCuatro() {
    cadena+=4;
    escribir.value=cadena;

}
cinco.addEventListener("click", numeroCinco);
function numeroCinco() {
    cadena+=5;
    escribir.value=cadena;

}
seis.addEventListener("click", numeroSeis);
function numeroSeis() {
    cadena+=6;
    escribir.value=cadena;

}
siete.addEventListener("click", numeroSiete);
function numeroSiete() {
    cadena+=7;
    escribir.value=cadena;
}
ocho.addEventListener("click", numeroOcho);
function numeroOcho() {
    cadena+=8;
    escribir.value=cadena;
}
nueve.addEventListener("click", numeroNueve);
function numeroNueve() {
    cadena+=9;
    escribir.value=cadena;

}
punto.addEventListener("click", anadirPunto);
function anadirPunto() {
    cadena+='.';
    escribir.value=cadena;
}


// Eventos para los operadores
mas.addEventListener("click", simboloSuma);
function simboloSuma() {
    cadena+='+';
    escribir.value=cadena;

}
menos.addEventListener("click", simboloResta);
function simboloResta() {
    cadena+='-';
    escribir.value=cadena;

}
multi.addEventListener("click", simboloMultiplicacion);
function simboloMultiplicacion() {
    cadena+='x';
    escribir.value=cadena;

}
division.addEventListener("click", simboloDivision);
function simboloDivision() {
    cadena+='÷';
    escribir.value=cadena;

}


// Eventos para funciones especiales
reset.addEventListener("click", resetearValor);
function resetearValor() {
    cadena='';
    escribir.value=cadena;
}
delet.addEventListener("click", borrarCaracter);
function borrarCaracter() {
    cadena=cadena.substring(0,cadena.length-1);
    escribir.value=cadena;
}
result.addEventListener("click", mostrarResultado);
function mostrarResultado() {
    let resultado=eval(cadena.replace('x','*').replace('÷','/'));
    // Condición para que, en caso de que el resultado tenga muchos decimales, se redondee
    if(resultado-Math.round(resultado)!=0){
        escribir.value=resultado.toFixed(2);
        cadena=resultado.toFixed(2);
    }else{
        escribir.value=resultado;
        cadena=resultado;
    }
    // Condición para que en caso de que pulsemos AC antes de escribir números, no nos devuelva undefined
    if(cadena==undefined){
        escribir.value='';
        cadena='';
    }
}