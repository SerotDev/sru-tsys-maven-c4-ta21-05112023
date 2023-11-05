package com.sergi.calculadora;

import javax.swing.JOptionPane;

public class Controller {
	private static double memoryNum = 0;
	private static char memoryOperator = '0';
	
	public static double getMemoryNum() {
		return memoryNum;
	}

	/**
	 * It validates if the char is valid to enter into the text field depending of the caret position 
	 * 
	 * @param charKey is the char from keyboard or buttons that is trying to enter into the text field
	 */
	public static void enterValidCharToActualNum(char charKey) {
		String textActualNum = Calculadora.getOperationText();
		int caretPos = Calculadora.getOperationCartetPosition();
		
		//if char is a dot
		if (charKey == '.') {
			// adds the dot into the textField if if it has no dots
			if (!textActualNum.contains(".")) {
				Calculadora.setKeyCharToOperation(charKey,caretPos);
			}
		//if its not a dot (its number)
		} else {
			Calculadora.setKeyCharToOperation(charKey,caretPos);
		}
		
		// check the text field and formated to double expression
		formatOfDoubleTextField();
		
	}
	
	/**
	 * It formats the text field to a double expression in case to put a dot in some place that is not correct
	 */
	public static void formatOfDoubleTextField() {
		String textActualNum = Calculadora.getOperationText();
		int caretPos = Calculadora.getOperationCartetPosition();
		
		//if text have only one char and its a subtract sign it is deleted automatically
		if (textActualNum.length() == 1) {
			if (textActualNum.charAt(0) == '-') Calculadora.setOperationText("");
		}
		
		//if text have some content
		if (textActualNum.length() > 0) {
			//if the first number is a dot it puts a 0 before
			if (textActualNum.charAt(0) == '.') {
				Calculadora.setOperationText("0" + textActualNum);
				Calculadora.setOperationCartetPosition(caretPos+1);
			}
			//if the content is longer than one char and at the first char has minus sign
			if (textActualNum.length() > 1) {
				if (textActualNum.charAt(0) == '-' && textActualNum.charAt(1) == '.') {
					Calculadora.setOperationText("-0" + textActualNum.substring(1));
					Calculadora.setOperationCartetPosition(caretPos+1);
				}
			}
		}
	}
	
	/**
	 * It inverts the text field operand sign
	 */
	public static void invertActualNumSign() {
		formatOfDoubleTextField(); // format textfield to double expression and deletes the negative sign if its the only sign
		
		String textActualNum = Calculadora.getOperationText();
		int caretPos = Calculadora.getOperationCartetPosition();
		//if text field have some content
		if (textActualNum.length() > 0) {
			//if text is negative
			if (textActualNum.charAt(0) == '-') {
				Calculadora.setOperationText(textActualNum.substring(1));
				if (caretPos > 0) {
					Calculadora.setOperationCartetPosition(caretPos-1);
				}else {
					Calculadora.setOperationCartetPosition(caretPos);
				}
			//if text is positive
			} else {
				Calculadora.setOperationText("-" + textActualNum);
				Calculadora.setOperationCartetPosition(caretPos+1);
			}
		}
		
	}

	/**
	 * It clears all of the content (memory number and the text field content)
	 */
	public static void clear() {
		Calculadora.setOperationText("");
		memoryNum = 0;
		memoryOperator = '0';
	}
	
	/**
	 * It clears the text field content
	 */
	public static void clearEntry() {
		Calculadora.setOperationText("");
	}
	
	/**
	 * it deletes the char at the left of the caret position if its possible
	 */
	public static void eraseLeft() {
		String textActualNum = Calculadora.getOperationText();
		int caretPos = Calculadora.getOperationCartetPosition();
		if (caretPos > 0) {
			Calculadora.setOperationText(textActualNum.substring(0,caretPos-1) + textActualNum.substring(caretPos,textActualNum.length()));
			Calculadora.setOperationCartetPosition(caretPos-1);
		}
		
		formatOfDoubleTextField(); // format text field to double expression
		
	}
	
	/**
	 * It takes the operation actual values and stored them if do not exist, but if exist calculates the result and stored them to continue operate
	 * 
	 * @param operator
	 */
	public static void operate(char operator) {
		formatOfDoubleTextField(); // format text field to double expression
		
		String textActualNum = Calculadora.getOperationText();
		
		//if the last char of the actual operand text is a dot, we deleted it to calculate
		if (textActualNum.length() > 0) {
			if (textActualNum.charAt(textActualNum.length()-1) == '.') {
				textActualNum = textActualNum.substring(0, textActualNum.length()-1);
			}
		}
		
		//if text of the actual num have no content it counts as 0
		if (!(textActualNum.length() > 0)) {
			textActualNum = "0";
		}
		
		//if we have no operator in memory it saves the actual number and operator to memory and clear the entry to enter the next data
		if (memoryOperator == '0') {
			memoryNum = Double.parseDouble(textActualNum);
			memoryOperator = operator;
			clearEntry();
		//if have operator in memory it calculates with the actual num
		} else {
			//it calculates the result
			String result = calculate(memoryNum, memoryOperator, Double.parseDouble(textActualNum));
			
			//if the result its a number saves the value to the memory and clears the entry to catch the next number
			if (isNumeric(result)) {
				memoryNum = Double.parseDouble(result);
				memoryOperator = operator;
				clearEntry();
			}
		}
	}
	
	/**
	 * This method eval if it can calculate, and if it can do the job and show the result in the textLabel
	 */
	public static void equal() {
		formatOfDoubleTextField(); // format text field to double expression
		
		String textActualNum = Calculadora.getOperationText();
		
		//if the last char of the actual operand text is a dot, we deleted it to calculate
		if (textActualNum.length() > 0) {
			if (textActualNum.charAt(textActualNum.length()-1) == '.') {
				textActualNum = textActualNum.substring(0, textActualNum.length()-1);
			}
		}
		
		//if text of the actual num have no content it counts as 0
		if (!(textActualNum.length() > 0)) {
			textActualNum = "0";
		}
		
		//if we have an operator in memory do the calculation, and if its numeric clear the memory, and show the result
		if (memoryOperator != '0') {
			String result = calculate(memoryNum, memoryOperator, Double.parseDouble(textActualNum));
			if (isNumeric(result)) {
				memoryNum = 0;
				memoryOperator = '0';
				Calculadora.setOperationText(result);
			}
		}
		
	}
	
	
	/**
	 * It calculates and returns the result in string type
	 * 
	 * @param firstOperand Is the first number to calculate
	 * @param operator Is the operator
	 * @param secondOperand Is the second number to calculate
	 * @return
	 */
	public static String calculate(double firstOperand, char operator, double secondOperand) {
		double result = 0;
		switch (operator) {
		case '+':
			result = addition(firstOperand, secondOperand);
			break;
		case '-':
			result = subtraction(firstOperand, secondOperand);
			break;
		case '*':
			result = multiply(firstOperand, secondOperand);
			break;
		case '/':
			if (secondOperand == 0) {
				JOptionPane.showMessageDialog(null, "Can't divide by 0.");
			} else {
				result = division(firstOperand, secondOperand);
			}
			break;
		default:
			break;
		}
		return String.valueOf(result);
	}
	
	/**
	 * It calculates the addition of two numbers
	 * 
	 * @param firstOperand The first number to calculate
	 * @param secondOperand The second number to calculate
	 * @return it returns the result of the operation
	 */
	public static double addition(double firstOperand, double secondOperand) {
		return firstOperand + secondOperand;
	}
	
	/**
	 * It calculates the subtraction of two numbers
	 * 
	 * @param firstOperand The first number to calculate
	 * @param secondOperand The second number to calculate
	 * @return it returns the result of the operation
	 */
	public static double subtraction(double firstOperand, double secondOperand) {
		return firstOperand - secondOperand;
	}
	
	/**
	 * It calculates the division of two numbers
	 * 
	 * @param firstOperand The first number to calculate
	 * @param secondOperand The second number to calculate
	 * @return it returns the result of the operation
	 */
	public static double division(double firstOperand, double secondOperand) {
		return firstOperand / secondOperand;
	}
	
	/**
	 * It calculates the multiply of two numbers
	 * 
	 * @param firstOperand The first number to calculate
	 * @param secondOperand The second number to calculate
	 * @return it returns the result of the operation
	 */
	public static double multiply(double firstOperand, double secondOperand) {
		return firstOperand * secondOperand;
	}
	
	
	/**
	 * it validates if string is numeric or not
	 * @param str Is the string that will validate if its numeric or not
	 * @return it returns a boolean (true) is numeric, (false) is not numeric 
	 */
	public static boolean isNumeric(String str) {
		return str.matches("-?\\d+(\\.\\d+)?");  //match a number with optional '-' and decimal.
	}
}

