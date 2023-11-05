package com.sergi.calculadora;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Calculadora {

	public static ButtonGroup numbersGroup = new ButtonGroup();
	public static ButtonGroup operatorsGroup = new ButtonGroup();
	public JFrame frmCalculadora;
	private static JTextField textField;
	private JButton btnSign;

	/**
	 * Create the application.
	 */
	public Calculadora() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCalculadora = new JFrame();
		frmCalculadora.setTitle("Calculadora");
		frmCalculadora.setBounds(100, 100, 388, 460);
		frmCalculadora.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCalculadora.getContentPane().setLayout(null);
		frmCalculadora.setLocationRelativeTo(null);

		textField = new JTextField("");
		textField.addKeyListener(textFieldKeyListener); //it adds the listener when type some key there
		textField.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textField.setBounds(10, 10, 350, 43);
		frmCalculadora.getContentPane().add(textField);
		textField.setColumns(10);

		JButton btn0 = new JButton("0");
		numbersGroup.add(btn0);
		btn0.addActionListener(clickBtnNumber);
		btn0.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btn0.setBounds(100, 273, 80, 60);
		frmCalculadora.getContentPane().add(btn0);

		JButton btn1 = new JButton("1");
		numbersGroup.add(btn1);
		btn1.addActionListener(clickBtnNumber);
		btn1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btn1.setBounds(10, 203, 80, 60);
		frmCalculadora.getContentPane().add(btn1);

		JButton btn2 = new JButton("2");
		numbersGroup.add(btn2);
		btn2.addActionListener(clickBtnNumber);
		btn2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btn2.setBounds(100, 203, 80, 60);
		frmCalculadora.getContentPane().add(btn2);

		JButton btn3 = new JButton("3");
		numbersGroup.add(btn3);
		btn3.addActionListener(clickBtnNumber);
		btn3.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btn3.setBounds(190, 203, 80, 60);
		frmCalculadora.getContentPane().add(btn3);

		JButton btn4 = new JButton("4");
		numbersGroup.add(btn4);
		btn4.addActionListener(clickBtnNumber);
		btn4.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btn4.setBounds(10, 133, 80, 60);
		frmCalculadora.getContentPane().add(btn4);

		JButton btn5 = new JButton("5");
		numbersGroup.add(btn5);
		btn5.addActionListener(clickBtnNumber);
		btn5.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btn5.setBounds(100, 133, 80, 60);
		frmCalculadora.getContentPane().add(btn5);

		JButton btn6 = new JButton("6");
		numbersGroup.add(btn6);
		btn6.addActionListener(clickBtnNumber);
		btn6.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btn6.setBounds(190, 133, 80, 60);
		frmCalculadora.getContentPane().add(btn6);

		JButton btn7 = new JButton("7");
		numbersGroup.add(btn7);
		btn7.addActionListener(clickBtnNumber);
		btn7.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btn7.setBounds(10, 63, 80, 60);
		frmCalculadora.getContentPane().add(btn7);

		JButton btn8 = new JButton("8");
		numbersGroup.add(btn8);
		btn8.addActionListener(clickBtnNumber);
		btn8.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btn8.setBounds(100, 63, 80, 60);
		frmCalculadora.getContentPane().add(btn8);

		JButton btn9 = new JButton("9");
		numbersGroup.add(btn9);
		btn9.addActionListener(clickBtnNumber);
		btn9.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btn9.setBounds(190, 63, 80, 60);
		frmCalculadora.getContentPane().add(btn9);

		JButton btnComma = new JButton(",");
		numbersGroup.add(btnComma);
		btnComma.addActionListener(clickBtnNumber);
		btnComma.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnComma.setBounds(190, 273, 80, 60);
		frmCalculadora.getContentPane().add(btnComma);

		JButton btnDivision = new JButton("÷");
		operatorsGroup.add(btnDivision);
		btnDivision.addActionListener(clickBtnOperator);
		btnDivision.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnDivision.setBounds(280, 63, 80, 60);
		frmCalculadora.getContentPane().add(btnDivision);

		JButton btnMultiply = new JButton("×");
		operatorsGroup.add(btnMultiply);
		btnMultiply.addActionListener(clickBtnOperator);
		btnMultiply.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnMultiply.setBounds(280, 133, 80, 60);
		frmCalculadora.getContentPane().add(btnMultiply);

		JButton btnAddition = new JButton("+");
		operatorsGroup.add(btnAddition);
		btnAddition.addActionListener(clickBtnOperator);
		btnAddition.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnAddition.setBounds(280, 203, 80, 60);
		frmCalculadora.getContentPane().add(btnAddition);

		JButton btnSubtraction = new JButton("-");
		operatorsGroup.add(btnSubtraction);
		btnSubtraction.addActionListener(clickBtnOperator);
		btnSubtraction.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnSubtraction.setBounds(280, 273, 80, 60);
		frmCalculadora.getContentPane().add(btnSubtraction);

		JButton btnEquals = new JButton("=");
		btnEquals.addActionListener(clickBtnEqual);
		btnEquals.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnEquals.setBounds(280, 343, 80, 60);
		frmCalculadora.getContentPane().add(btnEquals);
		
		btnSign = new JButton("+/-");
		btnSign.addActionListener(clickBtnInvertNumSign);
		btnSign.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnSign.setBounds(10, 273, 80, 60);
		frmCalculadora.getContentPane().add(btnSign);
		
		JButton btnEraseLeft = new JButton("<html>&#9003</html>");
		btnEraseLeft.addActionListener(clickBtnEraseLeft);
		btnEraseLeft.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnEraseLeft.setBounds(190, 343, 80, 60);
		frmCalculadora.getContentPane().add(btnEraseLeft);

		JButton btnCe = new JButton("CE");
		btnCe.addActionListener(clickBtnClearEntry);
		btnCe.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnCe.setBounds(100, 343, 80, 60);
		frmCalculadora.getContentPane().add(btnCe);

		JButton btnC = new JButton("C");
		btnC.addActionListener(clickBtnClear);
		btnC.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnC.setBounds(10, 343, 80, 60);
		frmCalculadora.getContentPane().add(btnC);
	}
	
	public static int getOperationCartetPosition() {
		return textField.getCaretPosition();
	}
	
	public static void setOperationCartetPosition(int caretPos) {
		textField.setCaretPosition(caretPos);
	}
	
	public static String getOperationText() {
		return textField.getText();
	}
	
	public static void setOperationText(String operation) {
		textField.setText(operation);
	}
	
	public static void setKeyCharToOperation(char keyChar, int caretPos) {
		String operation = textField.getText();
		textField.setText(operation.substring(0,caretPos) + keyChar + operation.substring(caretPos, operation.length()));
		textField.setCaretPosition(caretPos+1);
	}
	
	KeyListener textFieldKeyListener = new KeyListener() {
		public void textFieldKeyTyped(KeyEvent event) {
			char keyTyped = event.getKeyChar();
			//if its not a valid char the event consume the key typed. this prevents the key typed from appearing on the text field
			
			//if user press any number, dot or comma it validate if it can be inserted into the text field, and if it can do it the value is formated and inserted.
			if(Character.isDigit(keyTyped) || keyTyped == ',' || keyTyped == '.') {
				if (keyTyped == ',') keyTyped = '.'; //if the user press comma the value is set to dot
				Controller.enterValidCharToActualNum(keyTyped);
			
			//if user press any operator sign makes calculation
			}else if (keyTyped == '*' && keyTyped == '/' && keyTyped == '+' || keyTyped == '-') {
				Controller.operate(keyTyped);
			
			//if the user press enter or equals
			}else if (keyTyped == KeyEvent.VK_ENTER || keyTyped == '=') {
				Controller.equal();
				
			//if user press delete it clears the entry
			} else if(keyTyped == KeyEvent.VK_DELETE) {
				Controller.clearEntry();
			}
			
			event.consume(); //it prevents to set the event key char to appear into the text field
			
			
		}
		//when key is typed and the source of the event matches with the textfield is because the user is typing on the textfield
		@Override
		public void keyTyped(KeyEvent e) {
			//if key is typed in the textField we check if its number, operand symbol, dot or comma
			if(e.getSource() == textField){
				textFieldKeyTyped(e);
			}	
		}

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
	};
	
	ActionListener clickBtnNumber = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			JButton boton = (JButton) e.getSource();
			char btnChar = boton.getText().charAt(0);
			
			if (btnChar == ',') btnChar = '.'; //format comma to dot
			
			Controller.enterValidCharToActualNum(btnChar);
		}
	};
	
	ActionListener clickBtnOperator = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			JButton boton = (JButton) e.getSource();
			char btnChar = boton.getText().charAt(0);
			
			//format comma, division and multiply operands
			if (btnChar == '÷') btnChar = '/'; 
			if (btnChar == '×') btnChar = '*';
			
			Controller.operate(btnChar);
		}
	};
	
	ActionListener clickBtnEqual = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Controller.equal();
		}
	};
	
	ActionListener clickBtnInvertNumSign = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Controller.invertActualNumSign();
		}
	};
	
	ActionListener clickBtnClear = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Controller.clear();
		}
	};
	
	ActionListener clickBtnClearEntry = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Controller.clearEntry();
		}
	};
	
	ActionListener clickBtnEraseLeft = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Controller.eraseLeft();
		}
	};
}
