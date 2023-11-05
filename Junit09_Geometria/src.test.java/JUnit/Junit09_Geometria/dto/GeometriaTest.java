package JUnit.Junit09_Geometria.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class GeometriaTest {

	Geometria geo = new Geometria();
	Geometria geoId3 = new Geometria(3);
	private final double DELTA = 0.01;

	// test del metodo area del cuadrado
	@Test
	void testAreacuadrado() {
		assertEquals(9, geo.areacuadrado(3));
	}

	// test del metodo area del circulo
	@Test
	void testAreaCirculo() {
		assertEquals(28.27, geo.areaCirculo(3), DELTA);
	}

	// test del metodo area del triangulo
	@Test
	void testAreatriangulo() {
		assertEquals(6, geo.areatriangulo(2, 6));
	}

	// test del metodo area del rectangulo
	@Test
	void testArearectangulo() {
		assertEquals(12, geo.arearectangulo(3, 4));
	}

	// test del metodo area del pentagono
	@Test
	void testAreapentagono() {
		assertEquals(6, geo.areapentagono(2, 6));
	}

	// test del metodo area del rombo
	@Test
	void testArearombo() {
		assertEquals(6, geoId3.arearombo(2, 6));
	}

	// test del metodo area del romboide
	@Test
	void testArearomboide() {
		assertEquals(12, geoId3.arearomboide(2, 6));
	}

	// test del metodo area del trapecio
	@Test
	void testAreatrapecio() {
		assertEquals(28, geoId3.areatrapecio(5, 3, 7));
	}

	// test del Selector de figuras
	@Test
	void testFigura() {
		assertEquals("cuadrado", geo.figura(1));
		assertEquals("Circulo", geo.figura(2));
		assertEquals("Triangulo", geo.figura(3));
		assertEquals("Rectangulo", geo.figura(4));
		assertEquals("Pentagono", geo.figura(5));
		assertEquals("Rombo", geo.figura(6));
		assertEquals("Romboide", geo.figura(7));
		assertEquals("Trapecio", geo.figura(8));
		assertEquals("Default", geo.figura(0));
	}

	// Tests de Getters y Setters
	@Test
	void testGetId() {
		assertEquals(3, geoId3.getId());
	}

	@Test
	void testSetId() {
		geo.setId(5);
		assertEquals(5, geo.getId());
	}

	@Test
	void testGetNom() {
		assertEquals("Triangulo", geoId3.getNom());
	}

	@Test
	void testSetNom() {
		geoId3.setNom("test");
		assertEquals("test", geoId3.getNom());
	}

	@Test
	void testGetArea() {
		geoId3.setArea(13);
		assertEquals(13, geoId3.getArea());
	}

	@Test
	void testSetArea() {
		geoId3.setArea(12);
		assertEquals(12, geoId3.getArea());
	}

	@Test
	void testToString() {
		assertEquals("Geometria [id=" + geoId3.getId() + ", nom=" + geoId3.getNom() + ", area=" + geoId3.getArea() + "]", geoId3.toString());
	}

}
