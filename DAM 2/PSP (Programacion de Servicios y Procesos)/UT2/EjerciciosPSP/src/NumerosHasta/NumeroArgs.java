package NumerosHasta;

public class NumeroArgs {
	public static void main(String[] args) {
		int n=Integer.parseInt(args[0]);
		String cadena="";
		
		for (int i = 1; i < n; i++) {
			cadena+=i+" ";
		}
		
		System.out.println("Los números que hay hasta "+n+" son "+cadena);
	}
}
