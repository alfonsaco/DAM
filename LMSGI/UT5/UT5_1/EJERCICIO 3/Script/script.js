// Declaramos variables
let cadena='';
let result;

// Do while para juntar cadenas
do{
    result=prompt("Dame un texto:");
    if(result==null){
      cadena+='';
    }else{
      cadena+=result+' - ';
    }
}while(result!=null);

// Imprimimos las cadenas
document.write(cadena);