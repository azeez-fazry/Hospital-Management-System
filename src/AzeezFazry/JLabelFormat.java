/*
 * @author	: AzeezFazry
 * @e-mail	: azeezfazry@gmail.com
 * @github	: github.com/azeez-fazry
 */
package AzeezFazry;

import java.awt.Font;

import javax.swing.JLabel;

public class JLabelFormat extends JLabel {

	public JLabelFormat(String text) {
		setText(text);
		setFont(new Font("Serif", Font.BOLD, 30));
	}

}
