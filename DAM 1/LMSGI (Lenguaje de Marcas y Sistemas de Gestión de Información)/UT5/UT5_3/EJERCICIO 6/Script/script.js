const multiplos=() => {
    // Variable para crear la línea cada 5 números
    let linea=0;

    // For para crear la línea
    for (let i = 1; i <= 500; i++) {
        linea++;
        // Condicionales de los múltiplos
        if(i%9==0 && i%4==0){
            document.write(i+" (Múltiplo de 9 y 4)<br>")
        } else if(i%9==0){
            document.write(i+" (Múltiplo de 9)<br>")
        } else if(i%4==0){
            document.write(i+" (Múltiplo de 4)<br>")
        } else{
            document.write(i+"<br>")
        }
        // If para crear la línea
        if(linea%5==0){
            document.write("<hr>")
        }
    }
}

multiplos();