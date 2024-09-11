// Declaramos variables
let año;
let mes;
let dia;
// Do while para pedir el dia del mes
do {
    dia=prompt("Dame el día del mes");
} while (dia<1 || dia>30);
// Do while para pedir el mes
do {
    mes=prompt("Dame el mes");
} while (mes<1 || mes>12);
// Do while para pedir el año
do {
    año=prompt("Dame el año");
} while (año<0);
// Array de meses
let meses=["enero", "febrero", "marzo", "abril", "mayo", "junio", "julio", "agosto", "septiembre", "octubre", "noviembre", "diciembre"];
document.write(dia+" de "+meses[mes-1]+" de "+año);