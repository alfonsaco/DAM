// Función para crear la pirámide
const piramide=() => {
    let numero=1;
    for (let i = 1; i < 30; i++) {
        document.write(i+"<br>");
        numero++;
        for (let e = 1; e < numero; e++) {
            document.write(numero);
        }
    }
}
// Llamamos a la función
piramide();
