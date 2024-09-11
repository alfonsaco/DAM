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



window.addEventListener("keydown", numerosTecla);
function numerosTecla(event) {
    if(event.key=="0"){
        cero.classList.add("active-teclas");
        numeroCero();
    }
    if(event.key=="1"){
        uno.classList.add("active-teclas");
        numeroUno();
    }
    if(event.key=="2"){
        dos.classList.add("active-teclas");
        numeroDos();
    }
    if(event.key=="3"){
        tres.classList.add("active-teclas");
        numeroTres();
    }
    if(event.key=="4"){
        cuatro.classList.add("active-teclas");
        numeroCuatro();
    }
    if(event.key=="5"){
        cinco.classList.add("active-teclas");
        numeroCinco();
    }
    if(event.key=="6"){
        seis.classList.add("active-teclas");
        numeroSeis();
    }
    if(event.key=="7"){
        siete.classList.add("active-teclas");
        numeroSiete();
    }
    if(event.key=="8"){
        ocho.classList.add("active-teclas");
        numeroOcho();
    }
    if(event.key=="9"){
        nueve.classList.add("active-teclas");
        numeroNueve();
    }
    if(event.key=="Backspace"){
        delet.classList.add("active-teclas");
        borrarCaracter();
    }
    if(event.key=="+"){
        mas.classList.add("active-teclas");
        simboloSuma();
    }
    if(event.key=="-"){
        menos.classList.add("active-teclas");
        simboloResta();
    }
    if(event.key=="/"){
        division.classList.add("active-teclas");
        simboloDivision();
    }
    if(event.key=="x"){
        multi.classList.add("active-teclas");
        simboloMultiplicacion();
    }
    if(event.key=="Enter"){
        result.classList.add("active-igual");
        mostrarResultado();
    }
    if(event.key=="."){
        punto.classList.add("active-teclas");
        anadirPunto();
    }
}

window.addEventListener("keyup", borrarTeclas);
function borrarTeclas(event) {
    if(event.key=="0"){
        cero.classList.remove("active-teclas");
    }
    if(event.key=="1"){
        uno.classList.remove("active-teclas")
    }
    if(event.key=="2"){
        dos.classList.remove("active-teclas")
    }
    if(event.key=="3"){
        tres.classList.remove("active-teclas")
    }
    if(event.key=="4"){
        cuatro.classList.remove("active-teclas")
    }
    if(event.key=="5"){
        cinco.classList.remove("active-teclas")
    }
    if(event.key=="6"){
        seis.classList.remove("active-teclas")
    }
    if(event.key=="7"){
        siete.classList.remove("active-teclas")
    }
    if(event.key=="8"){
        ocho.classList.remove("active-teclas")
    }
    if(event.key=="9"){
        nueve.classList.remove("active-teclas")
    }
    if(event.key=="Backspace"){
        delet.classList.remove("active-teclas")
    }
    if(event.key=="+"){
        mas.classList.remove("active-teclas")
    }
    if(event.key=="-"){
        menos.classList.remove("active-teclas")
    }
    if(event.key=="/"){
        division.classList.remove("active-teclas")
    }
    if(event.key=="x"){
        multi.classList.remove("active-teclas")
    }
    if(event.key=="."){
        punto.classList.remove("active-teclas")
    }
    if(event.key=="Enter"){
        result.classList.remove("active-igual")
    }
}