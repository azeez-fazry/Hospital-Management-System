package AzeezFazry;

import java.awt.Font;

import javax.swing.JTextField;

public class JTextFieldFormat extends JTextField {
	
	public JTextFieldFormat(int columns) {
		setFont(new Font("Serif", Font.PLAIN, 25));
		setColumns(columns);
	}
	
}
