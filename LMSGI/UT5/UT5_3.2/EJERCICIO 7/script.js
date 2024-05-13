// Función para sacar todos los números que hay hasta n
const decreciente=(n) => {
    for (let i=n; i>0; i--) {
        document.write(i+" ");
    }
}
// Llamamos al método
let numero=prompt("Dame un número");
decreciente(numero);