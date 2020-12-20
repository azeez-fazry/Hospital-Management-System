package AzeezFazry;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

/*
 * @author					: AzeezFazry
 * @e-mail					: azeezfazry@gmail.com
 * @github					: github.com/azeez-fazry
 */
public class JLabelHome extends JLabel {

	public JLabelHome(String text) {
		setText(text);
		setOpaque(true);
		setFont(new Font("Serif", Font.PLAIN, 25));
		setBorder(new BevelBorder(BevelBorder.RAISED, SystemColor.desktop, SystemColor.desktop,
				SystemColor.desktop, SystemColor.desktop));
		setHorizontalAlignment(SwingConstants.CENTER);
	}

}
