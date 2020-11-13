/**
 * @author AzeezFazry
 */
package AzeezFazry;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JPasswordField;
import javax.swing.border.TitledBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;

public class Login extends JFrame {

	// Variables declaration - do not modify
	private JPanel contentPane;
	Toolkit toolkit = getToolkit();
	Dimension size = toolkit.getScreenSize();
	Image img = Toolkit.getDefaultToolkit()
			.getImage("E:\\IntelliJ\\Fazry's Hospital Management System\\Images\\backgroundLogin.jpg");
	private JTextField textField;
	private JPasswordField passwordField;
	// End of variables declaration

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Login().setVisible(true);
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, size.width, size.height - 30);
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage("E:\\IntelliJ\\Fazry's Hospital Management System\\Images\\logo.png"));

		contentPane = new BackgroundJPanel(img);

		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);

		JLabel title = new JLabel("LOGIN");
		title.setFont(new Font("Serif", Font.BOLD, 60));

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(SystemColor.controlDkShadow, 2, true), "LOGIN INFORMATION",
				TitledBorder.LEADING, TitledBorder.TOP, new Font("serf", 1, 20), Color.BLACK));
		panel.setOpaque(false);

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap()
						.addComponent(title, GroupLayout.DEFAULT_SIZE, 734, Short.MAX_VALUE).addGap(622))
				.addGroup(gl_contentPane.createSequentialGroup().addGap(353)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 660, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(355, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addComponent(title, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE).addGap(300)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 333, GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));

		JLabel jLabel1 = new JLabelFormat("USERNAME:");

		JLabel jLabel2 = new JLabelFormat("PASSWORD:");

		textField = new JTextFieldFormat(10);

		passwordField = new JPasswordField();
		passwordField.setOpaque(false);
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), new Color(0, 0, 0),
				new Color(0, 0, 0), new Color(0, 0, 0)));
		passwordField.setFont(new Font("Serif", Font.PLAIN, 35));

		JButton loginButton = new JButton();
		loginButton.setIcon(new ImageIcon("E:\\IntelliJ\\Fazry's Hospital Management System\\Images\\login.jpg"));
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = textField.getText();
				String password = new String(passwordField.getPassword());

				if (username.equals("admin") && password.equals("admin@123")) {

					JOptionPane
							.showMessageDialog(
									null, "Login Successful." + "\n" + "\n" + "Welcome to Hospital Management System."
											+ "\n" + "Please click OK to proceed.",
									"Login Successful", JOptionPane.NO_OPTION);
					textField.setText(null);
					passwordField.setText(null);
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							new Activities().setVisible(true);
						}
					});

				} else if (username.equals("doctor") && password.equals("doctor@123")) {

					JOptionPane.showMessageDialog(null, "Login Successful." + "\n" + "\n"
							+ "Welcome Doctor,Have a Nice Day" + "\n" + "Please click OK to proceed.",
							"Login Successful", JOptionPane.NO_OPTION);
					textField.setText(null);
					passwordField.setText(null);
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							new DoctorLogin().setVisible(true);
						}
					});

				} else {

					JOptionPane.showMessageDialog(null,
							" Either Username Or Password Is Incorrect! " + " Please Try Again. ", " Login Failed ",
							JOptionPane.NO_OPTION);
					textField.setText(null);
					passwordField.setText(null);
				}
			}
		});

		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup().addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup().addGap(217).addComponent(loginButton,
								GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup().addGap(88)
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_panel.createSequentialGroup().addGap(2).addComponent(jLabel2,
												GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)))
								.addGap(30)
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(textField, GroupLayout.PREFERRED_SIZE, 250,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(passwordField, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE,
												250, GroupLayout.PREFERRED_SIZE))))
						.addContainerGap(98, Short.MAX_VALUE)));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel
				.createSequentialGroup().addGap(37)
				.addGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel.createSequentialGroup()
						.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addGap(52).addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
								.addGap(51).addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 40,
										GroupLayout.PREFERRED_SIZE)))
				.addGap(58).addComponent(loginButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
				.addContainerGap(45, Short.MAX_VALUE)));
		panel.setLayout(gl_panel);

		contentPane.setLayout(gl_contentPane);
	}

}