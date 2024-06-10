package com.examen.ut3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ClienteElectricidadTest {

	@Test
	void testCalcularTotalFactura() {
		ClienteElectricidad cliente=new ClienteElectricidad("22222", true, 300, 4);
		try {
			cliente.calcularTotalFactura();
			assertEquals(0.0, cliente.getTotalFactura());
		} catch (Exception e) {
			fail("Se produjo una excepcion: "+e.getMessage());
		}
	}
	
	@Test
	void testCalcularTotalFactura1() {
		ClienteElectricidad cliente1=new ClienteElectricidad("22222", false, 300, 4);
		try {
			cliente1.calcularTotalFactura();
			assertEquals(58.650000000000006, cliente1.getTotalFactura());
		} catch (Exception e) {
			fail("Se produjo una excepcion: "+e.getMessage());
		}
	}
	
	@Test
	void testCalcularTotalFactura2() {
		ClienteElectricidad cliente1=new ClienteElectricidad("22222", false, 200, 4);
		try {
			cliente1.calcularTotalFactura();
			assertEquals(41.0, cliente1.getTotalFactura());
		} catch (Exception e) {
			fail("Se produjo una excepcion: "+e.getMessage());
		}
	}
	
	@Test
	void testCalcularTotalFactura3() {
		ClienteElectricidad cliente1=new ClienteElectricidad("22222", false, 400, 4);
		try {
			cliente1.calcularTotalFactura();
			assertEquals(78.2, cliente1.getTotalFactura());
		} catch (Exception e) {
			fail("Se produjo una excepcion: "+e.getMessage());
		}
	}
	
	@Test
	void testCalcularTotalFactura4() {
		ClienteElectricidad cliente1=new ClienteElectricidad("22222", false, 400, 12);
		try {
			cliente1.calcularTotalFactura();
			assertEquals(74.29, cliente1.getTotalFactura());
		} catch (Exception e) {
			fail("Se produjo una excepcion: "+e.getMessage());
		}
	}
}
