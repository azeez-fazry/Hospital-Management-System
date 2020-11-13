/**
 * @author AzeezFazry
 */
package AzeezFazry;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;

public class AboutUs extends JFrame {

//  Variables declaration - do not modify

	private JPanel contentPane;
	Toolkit toolkit = getToolkit();
	Dimension size = toolkit.getScreenSize();
	Image img = Toolkit.getDefaultToolkit()
			.getImage("E:\\IntelliJ\\Fazry's Hospital Management System\\Images\\aboutus.jpg");
	private JTextField textField;
	private JTextField textField_1;

//  End of variables declaration

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AboutUs frame = new AboutUs();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AboutUs() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, size.width, size.height - 30);
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage("E:\\IntelliJ\\Fazry's Hospital Management System\\Images\\logo.png"));

		contentPane = new BackgroundJPanel(img);
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);

		JLabel title = new JLabel("HOSPITAL MANAGEMENT SYSTEM");
		title.setFont(new Font("Serif", Font.BOLD, 60));

		JButton backButton = new JButton();
		backButton.setIcon(new ImageIcon("E:\\IntelliJ\\Fazry's Hospital Management System\\Images\\back.jpg"));
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(SystemColor.controlDkShadow, 2, true), "DESIGNED BY",
				TitledBorder.LEADING, TitledBorder.TOP, new Font("serf", 1, 20), Color.BLACK));
		panel.setOpaque(false);

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(579)
					.addComponent(backButton, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(587, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(title, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(328))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(493)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 819, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(54, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(title, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 278, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 304, Short.MAX_VALUE)
					.addComponent(backButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);

		JLabel lblNewLabel = new JLabel("AZEEZ MOHAMED FAZRY");
		lblNewLabel.setFont(new Font("Serif", Font.BOLD, 40));
		
		JLabel lblNewLabel_1 = new JLabelFormat("-- 1CE18CS010 --");
		
		textField = new JTextField("azeezfazry@gmail.com");
		textField.setFont(new Font("Serif", Font.BOLD, 30));
		textField.setEditable(false);
		textField.setOpaque(false);
		
		textField_1 = new JTextField("http://github.com/azeez-fazry");
		textField_1.setFont(new Font("Serif", Font.BOLD, 30));
		textField_1.setEditable(false);
		textField_1.setOpaque(false);
		
		JLabel lblNewLabel_4 = new JLabelFormat("+91 89714 29746");
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(31)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(46)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(257, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(lblNewLabel)
					.addGap(6)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(38, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}
}
