// Método para pedir el día
const pedirDia=(dia) => {
    // Do while para pedir el dia del mes
    do {
        dia=prompt("Dame el día del mes");
    } while (dia<1 || dia>31);
    return dia;
}
// Método para pedir el mes
const pedirMes=(mes) => {
    // Do while para pedir el mes
    let cont=0;
    do {
        mes=prompt("Dame el mes");
        if(mes==2 && dia>28){
            alert("Febrero tiene menos de 29 días");
        } else if (mes==4 && dia>30 || mes==6 && dia>30 || mes==9 && dia>30 || mes==11 && dia>30){
            alert("Este mes tiene menos de 31 días")
        } else{
            cont++;
        }
    } while (cont<1);
    return mes;
}
// Método para pedir el año
const pedirAño=(año) => {
    // Do while para pedir el año
    do {
        año=prompt("Dame el año");
    } while (año<0);
    return año;
}

// Declaramos variables usando los métodos
let dia=pedirDia();
let mes=pedirMes();
let año=pedirAño();
let meses=["enero", "febrero", "marzo", "abril", "mayo", "junio", "julio", "agosto", "septiembre", "octubre", "noviembre", "diciembre"];

document.write(dia+" de "+meses[mes-1]+" de "+año);s