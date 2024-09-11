const enlacesNav = document.querySelectorAll(".navbar a");

// Iterar sobre cada enlace y agregar los event listeners
enlacesNav.forEach(enlace => {
    // Event listener para cambiar color al pasar el ratón por encima
    enlace.addEventListener("mouseover", cambiarColor);
    
    // Event listener para reestablecer el color al quitar el ratón
    enlace.addEventListener("mouseout", quitarColor);
});

// Función cambiar color
function cambiarColor(event) {
    const randomColor = "#" + Math.floor(Math.random()*16777215).toString(16);
    event.target.style.color = randomColor;
}

// Función reestablecer color
function quitarColor(event) {
    event.target.style.color = '#333';
}

/*
// Botones
const botones=document.querySelectorAll(".btn");

botones.addEventListener("mouseover", colorBoton);
function colorBoton() {
    botones.style.backgroundColor='#eb6579';
}


// Fichas
const fichas=document.getElementsByClassName(".price");

box.addEventListener("mouseover", cambiarTama);
function cambiarTama() {
    price.style.font-size='7em';
    price.style.transition='font-size 0.3s ease';
}*/