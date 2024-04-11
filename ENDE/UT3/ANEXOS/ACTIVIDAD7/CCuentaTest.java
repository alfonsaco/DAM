package ACTIVIDAD7;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CCuentaTest {

	@Test
	void testIngresar() {
		CCuenta cuenta = new CCuenta("Carlos Domingo", "1234567890", 1000.0, 0.0);
        try {
            cuenta.ingresar(500.0);
            assertEquals(1500.0, cuenta.estado(), 0.0);
        } catch (Exception e) {
            fail("Se produjo una excepción: " + e.getMessage());
        }
	}

	@Test
	void testRetirar() {
		CCuenta cuenta = new CCuenta("Antonio Mas Mas", "0987654321", 2000.0, 0.0);
        try {
            cuenta.retirar(1000.0);
            assertEquals(1000.0, cuenta.estado(), 0.0);
        } catch (Exception e) {
            fail("Se produjo una excepción: " + e.getMessage());
        }
	}

}
