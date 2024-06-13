package fechas;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class EjemplosFechas {

	public static void main(String[] args) {
		LocalDate hoy = LocalDate.now();
		System.out.println(hoy);
		LocalTime ahora = LocalTime.now();
		System.out.println(ahora);
		LocalDateTime hoyAhora = LocalDateTime.now();
		System.out.println(hoyAhora);
		LocalDate fecha = LocalDate.of(1999, 6, 22);
		System.out.println(fecha.getMonth());
		System.out.println(fecha.getDayOfYear());
		
		// Formatear
		DateTimeFormatter fechaFormato = DateTimeFormatter.ofPattern("EEEE"+"   "+"dd-MMMM-YYYY HH:mm:ss");
		String fechaFinal = hoyAhora.format(fechaFormato);
		System.out.println(fechaFinal);

		if (fecha.isBefore(hoy)) {
			System.out.println("Es después");
		}
		
		
	}
	
}
