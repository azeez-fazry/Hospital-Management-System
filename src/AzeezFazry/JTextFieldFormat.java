/*
 * @author	: AzeezFazry
 * @e-mail	: azeezfazry@gmail.com
 * @github	: github.com/azeez-fazry
 */
package AzeezFazry;

import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

public class JTextFieldFormat extends JTextField {
	
	public JTextFieldFormat(int columns) {
		setFont(new Font("Serif", Font.PLAIN, 25));
		setText(null);
		setOpaque(false);
		setBorder(new BevelBorder(BevelBorder.RAISED, SystemColor.desktop, SystemColor.desktop, SystemColor.desktop, SystemColor.desktop));
		setHorizontalAlignment(SwingConstants.CENTER);
		setColumns(columns);
	}
	
}
