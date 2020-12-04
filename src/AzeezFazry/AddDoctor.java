/*
 * @author	: AzeezFazry
 * @e-mail	: azeezfazry@gmail.com
 * @github	: github.com/azeez-fazry
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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

public class AddDoctor extends JFrame {

//  Variables declaration - do not modify

	private JPanel contentPane;
	Toolkit toolkit = getToolkit();
	Dimension size = toolkit.getScreenSize();
	Image img = Toolkit.getDefaultToolkit()
			.getImage("E:\\IntelliJ\\Fazry's Hospital Management System\\Images\\background.jpg");
	private JTextField textField1;
	private JTextField textField2;
	private JTextField textField3;
	private JTextField textField4;
	private JTextField textField5;
	private JTextField textField6;
	private JTextField textField7;
	private JTextField textField8;
	private JTextField textField9;
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JLabel jLabel4;
	private JLabel jLabel5;
	private JLabel jLabel6;
	private JLabel jLabel7;
	private JLabel jLabel8;
	private JLabel jLabel9;
	static String dbUrl = "jdbc:mysql://localhost:3306/hospital_management_system";
	static String username = "admin";
	static String password = "admin@123";
	Connection connection;
	Statement statement;
	ResultSet resultSet;
	Date date = new Date();
	SimpleDateFormat f = new SimpleDateFormat("YYYY-MM-dd");

//  End of variables declaration

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddDoctor frame = new AddDoctor();
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
	public AddDoctor() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, size.width, size.height - 30);
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage("E:\\IntelliJ\\Fazry's Hospital Management System\\Images\\logo.png"));

		contentPane = new BackgroundJPanel(img);
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);

		JLabel title = new JLabel("ADD NEW DOCTOR");
		title.setFont(new Font("Serif", Font.BOLD, 60));

		textField1 = new JTextFieldFormat(10);
		textField2 = new JTextFieldFormat(10);
		textField3 = new JTextFieldFormat(10);
		textField4 = new JTextFieldFormat(10);
		textField5 = new JTextFieldFormat(10);
		textField6 = new JTextFieldFormat(10);
		textField7 = new JTextFieldFormat(10);
		textField8 = new JTextFieldFormat(10);
		textField9 = new JTextFieldFormat(10);

		textField8.setText(f.format(date));

		jLabel1 = new JLabelFormat("First Name:");
		jLabel2 = new JLabelFormat("Last Name:");
		jLabel3 = new JLabelFormat("Address:");
		jLabel4 = new JLabelFormat("Phone Number:");
		jLabel5 = new JLabelFormat("Qualification:");
		jLabel6 = new JLabelFormat("Department:");
		jLabel7 = new JLabelFormat("Fee:");
		jLabel8 = new JLabelFormat("Date Of Joining:");
		jLabel9 = new JLabelFormat("Age:");

		JButton backButton = new JButton();
		backButton.setIcon(new ImageIcon("E:\\IntelliJ\\Fazry's Hospital Management System\\Images\\back.jpg"));
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		JButton submitButton = new JButton();
		submitButton.setIcon(new ImageIcon("E:\\IntelliJ\\Fazry's Hospital Management System\\Images\\submit.jpg"));
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				submitButtonActionPerformed();
			}
		});
		getRootPane().setDefaultButton(submitButton);
		

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING).addGroup(gl_contentPane
				.createSequentialGroup().addGap(300)
				.addComponent(backButton, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE).addGap(366)
				.addComponent(submitButton, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE).addGap(300))
				.addGroup(gl_contentPane.createSequentialGroup().addGap(433).addGroup(gl_contentPane
						.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(jLabel9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(jLabel8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED))
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
												.addComponent(jLabel7, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED))
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_contentPane.createSequentialGroup()
														.addComponent(jLabel6, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.RELATED))
												.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
														.addGroup(gl_contentPane.createSequentialGroup()
																.addComponent(jLabel5, GroupLayout.PREFERRED_SIZE,
																		GroupLayout.DEFAULT_SIZE,
																		GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(ComponentPlacement.RELATED))
														.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
																.addGroup(gl_contentPane.createSequentialGroup()
																		.addComponent(jLabel4,
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(ComponentPlacement.RELATED))
																.addGroup(gl_contentPane
																		.createParallelGroup(Alignment.LEADING)
																		.addGroup(gl_contentPane.createSequentialGroup()
																				.addComponent(jLabel3,
																						GroupLayout.PREFERRED_SIZE,
																						GroupLayout.DEFAULT_SIZE,
																						GroupLayout.PREFERRED_SIZE)
																				.addPreferredGap(
																						ComponentPlacement.RELATED))
																		.addGroup(gl_contentPane
																				.createParallelGroup(Alignment.LEADING)
																				.addGroup(gl_contentPane
																						.createSequentialGroup()
																						.addComponent(jLabel1,
																								GroupLayout.DEFAULT_SIZE,
																								157, Short.MAX_VALUE)
																						.addGap(89))
																				.addGroup(gl_contentPane
																						.createSequentialGroup()
																						.addComponent(jLabel2,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE)
																						.addPreferredGap(
																								ComponentPlacement.RELATED))))))))))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(textField1, GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
								.addComponent(textField2).addComponent(textField3).addComponent(textField4)
								.addComponent(textField5).addComponent(textField6).addComponent(textField7)
								.addComponent(textField8).addComponent(textField9, GroupLayout.DEFAULT_SIZE,
										GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGap(436))
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap()
						.addComponent(title, GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE).addGap(656)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addComponent(title, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(textField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(52)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(backButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
								.addComponent(submitButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
						.addContainerGap()));
		contentPane.setLayout(gl_contentPane);
	}

	protected void submitButtonActionPerformed() {
		try {
			// get connection to database
			connection = DriverManager.getConnection(dbUrl, username, password);

			// create statement
			statement = connection.createStatement();

			String S = "insert into doctor (d_fname,d_lname,address,phone,qualification,department,fee,date,age) values('"
					+ textField1.getText() + "','" + textField2.getText() + "','" + textField3.getText() + "','"
					+ textField4.getText() + "','" + textField5.getText() + "','" + textField6.getText() + "','"
					+ textField7.getText() + "','" + textField8.getText() + "','" + textField9.getText() + "');";

			statement.executeUpdate(S);

			String query = "select max(d_id) from doctor;";
			resultSet = statement.executeQuery(query);
			if (resultSet.next()) {
				String id = resultSet.getString("max(d_id)");
				JOptionPane.showMessageDialog(null, "Record Inserted Successfully." + "\n" + "\n" + "DOCTOR ID: " + id,
						"Record Inserted Successfully", JOptionPane.NO_OPTION);
			}

			textField1.setText(null);
			textField2.setText(null);
			textField3.setText(null);
			textField4.setText(null);
			textField5.setText(null);
			textField6.setText(null);
			textField7.setText(null);
			textField8.setText(f.format(date));
			textField9.setText(null);

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex, "ERROR", 0);
		}
	}

}
