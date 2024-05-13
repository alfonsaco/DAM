// Función para mostrar un menú
const menu=() => {
    return prompt("1. Sumar\n2. restar\n3. Multiplicar\n4. Dividir");
}
// Funciones de las diferentes operaciones
const suma=(a,b) => {
    return a+b;
}
const resta=(a,b) => {
    return a-b;
}
const multi=(a,b) => {
    return a*b;
}
const division=(a,b) => {
    if(a==0 && b==0){
        return "Indeterminado";
    }else{
        return a/b;
    }
}
// Función para pedir un número
const pedirNumero=() => {
    do {
        n=parseInt(prompt("Dame un número"));
    } while (isNaN(n));
    return n;
}

// Declaramos a y b usando la función pedirNumero
let a=pedirNumero();
let b=pedirNumero();

let opcion=parseInt(menu());
switch (opcion) {
    case 1:
        document.write(suma(a,b));
        break;
    case 2:
        document.write(resta(a,b));
        break;
    case 3:
        document.write(multi(a,b));
        break;
    case 4:
        document.write(division(a,b));
        break;
    default:
        document.write("Esta operación no existe")
        break;
}