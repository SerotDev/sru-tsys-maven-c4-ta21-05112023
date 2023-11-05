package com.sergi.calculadora;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ControllerTest {
	
	Calculadora calc = new Calculadora();
	Controller cont = new Controller();
	
	@Test
	void testEnterValidCharToActualNum() {
		Calculadora.setOperationText("367");
		Calculadora.setOperationCartetPosition(2);
		Controller.enterValidCharToActualNum('4');
		assertEquals("3647", Calculadora.getOperationText());
		
		Calculadora.setOperationText("3.67");
		Calculadora.setOperationCartetPosition(2);
		Controller.enterValidCharToActualNum('.');
		assertEquals("3.67", Calculadora.getOperationText());
		
		Calculadora.setOperationText("367");
		Calculadora.setOperationCartetPosition(2);
		Controller.enterValidCharToActualNum('.');
		assertEquals("36.7", Calculadora.getOperationText());
	}

	@Test
	void testInvertActualNumSign(){
		Calculadora.setOperationText("337");
		Controller.invertActualNumSign();
		assertEquals("-337", Calculadora.getOperationText());
		
		Calculadora.setOperationCartetPosition(0);
		Controller.invertActualNumSign();
		assertEquals("337", Calculadora.getOperationText());
		
		Calculadora.setOperationText("-337");
		Calculadora.setOperationCartetPosition(2);
		Controller.invertActualNumSign();
		assertEquals("337", Calculadora.getOperationText());
	}
	
	@Test
	void testClear() {
		Calculadora.setOperationText("337");
		Controller.clear();
		assertEquals("", Calculadora.getOperationText());
		assertEquals(0, Controller.getMemoryNum());
	}
	
	@Test
	void testEraseLeft() {
		Calculadora.setOperationText("337");
		Calculadora.setOperationCartetPosition(2);
		Controller.eraseLeft();
		assertEquals("37", Calculadora.getOperationText());
	}
	
	@Test
	void testOperate() {
		Calculadora.setOperationText("337");
		Controller.operate('+');
		
		Calculadora.setOperationText("-.45");
		Controller.operate('+');
		
		Calculadora.setOperationText(".45");
		Controller.operate('+');
		
		Calculadora.setOperationText("45.");
		Controller.operate('+');
		
		Calculadora.setOperationText("-");
		Controller.operate('+');
		
		Calculadora.setOperationText("");
		Controller.operate('+');
	}
	
	@Test
	void testCalculate(){
		Controller.calculate(13, '+', 2);
		Controller.calculate(13, '-', 2);
		Controller.calculate(13, '*', 2);
		Controller.calculate(13, '/', 2);
		Controller.calculate(13, '/', 0);
	}
	
	@Test
	void testEqual() {
		Controller.equal();
		
		Calculadora.setOperationText("2");
		Controller.operate('+');
		Calculadora.setOperationText("2");
		Controller.equal();
		assertEquals("4.0", Calculadora.getOperationText());
		
		Calculadora.setOperationText("2");
		Controller.operate('+');
		Calculadora.setOperationText("2.");
		Controller.equal();
		assertEquals("4.0", Calculadora.getOperationText());
		
	}

}
