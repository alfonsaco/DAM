// Declaramos la variable numero, que servirá como contador para definir cada número en cada fila
let numero=1;

// For para crear la pirámides
for (let i = 1; i < 30; i++) {
    document.write(i+"<br>");
    numero++;
    for (let e = 1; e < numero; e++) {
        document.write(numero)
    }
}