// Ejercicio 1.1
// Declaramos variables
let mayor=0;
let stringMayor='';

let valores=[true, 5, false, "hola", "adios", 2];
// For para ver cual es mayor
for (let i=0; i<valores.length; i++) {
    if (typeof valores[i] === 'string') {
        if(valores[i].length > mayor){
            // Mayor tendrá el valor de la longitud del valores[i]
            mayor=valores[i].length;
            // El stringMayor tomará el valor del string de la posición i
            stringMayor=valores[i];
        }
    }
}
// Imprimimos por pantalla
document.write("\""+stringMayor+"\""+" es el mayor con "+mayor+" caracteres<br><br>");


// Ejercicio 1.2
// Realiamos la operacion true OR false
let opTrue=valores[0] || valores[2];
document.write(opTrue+"<br>");
// Realizamos la operación true AND false
let opFalse=valores[0] && valores[2];
document.write(opFalse+"<br>"+"<br>");


// Ejercicio 1.3
// Declaramos a y b
let a=valores[1];
let b=valores[5];
// Realizamos las operaciones
let suma=a+b;
let resta=a-b;
let multi=a*b;
let division=a/b;
let resto=a%b;
// Imprimimos
document.write("Suma: "+suma+"<br>Resta: "+resta+"<br>Multiplicación: "+multi+"<br>División: "+division+"<br>Resto: "+resto);