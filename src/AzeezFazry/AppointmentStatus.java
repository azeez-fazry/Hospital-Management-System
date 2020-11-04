/**
 * @author AzeezFazry
 */
package AzeezFazry;

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

public class AppointmentStatus extends JFrame {

//  Variables declaration - do not modify

	private JPanel contentPane;
	Toolkit toolkit = getToolkit();
	Dimension size = toolkit.getScreenSize();
	Image img = Toolkit.getDefaultToolkit()
			.getImage("E:\\IntelliJ\\Fazry's Hospital Management System\\Images\\background.jpg");
	static String dbUrl = "jdbc:mysql://localhost:3306/hospital_management_system";
	static String username = "admin";
	static String password = "admin@123";
	Connection connection = null;
	Statement statement = null;
	ResultSet resultSet = null;
	Date date = new Date();
	SimpleDateFormat f = new SimpleDateFormat("YYYY-MM-dd");
	private JTextField textField1;
	private JTextField textField2;
	private JTextField jLabel1;
	private JTextField jLabel2;
	private JTextField jLabel3;
	private JTextField jLabel4;

//  End of variables declaration

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new AppointmentStatus().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AppointmentStatus() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, size.width, size.height - 30);
//		setResizable(false);

		contentPane = new BackgroundJPanel(img);
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);

		JLabel title = new JLabel("APPOINTMENT STATUS");
		title.setFont(new Font("Serif", Font.BOLD, 60));

		JButton backButton = new JButton();
		backButton.setIcon(new ImageIcon("E:\\IntelliJ\\Fazry's Hospital Management System\\Images\\back.jpg"));
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		JLabel lblNewLabel = new JLabelFormat("Enter Patient ID:");

		textField1 = new JTextFieldFormat(10);
		textField1.setText("1");

		JLabel lblNewLabel_1 = new JLabelFormat("Appointment Date:");

		textField2 = new JTextFieldFormat(10);
		textField2.setText(f.format(date));

		JButton cleanButton = new JButton();
		cleanButton.setIcon(new ImageIcon("E:\\IntelliJ\\Fazry's Hospital Management System\\Images\\clean.jpg"));
		cleanButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jLabel1.setText("");
				jLabel2.setText("");
				jLabel3.setText("");
				jLabel4.setText("");
				textField1.setText("1");
				textField2.setText(f.format(date));
			}
		});
		JButton searchButton = new JButton();
		searchButton.setIcon(new ImageIcon("E:\\IntelliJ\\Fazry's Hospital Management System\\Images\\search.jpg"));
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchButtonactionPerformed();
			}
		});
		JLabel lblNewLabel_2 = new JLabelFormat("Appointment ID:");

		JLabel lblNewLabel_3 = new JLabelFormat("Doctor Name:");

		JLabel lblNewLabel_4 = new JLabelFormat("Patient Name:");

		JLabel lblNewLabel_5 = new JLabelFormat("Disease:");

		jLabel1 = new JTextFieldFormat(10);
		jLabel1.setEditable(false);

		jLabel2 = new JTextFieldFormat(10);
		jLabel2.setEditable(false);

		jLabel3 = new JTextFieldFormat(10);
		jLabel3.setEditable(false);

		jLabel4 = new JTextFieldFormat(10);
		jLabel4.setEditable(false);

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane
				.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup().addContainerGap()
								.addComponent(title, GroupLayout.DEFAULT_SIZE, 1271, Short.MAX_VALUE).addGap(85))
						.addGroup(
								gl_contentPane.createSequentialGroup().addGap(74)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGap(39)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(textField1, GroupLayout.PREFERRED_SIZE, 250,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(textField2, GroupLayout.PREFERRED_SIZE, 250,
														GroupLayout.PREFERRED_SIZE))
										.addGap(913))
						.addGroup(gl_contentPane.createSequentialGroup().addGap(155)
								.addComponent(cleanButton, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
								.addGap(106)
								.addComponent(searchButton, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(859, Short.MAX_VALUE))
						.addGroup(
								gl_contentPane.createSequentialGroup().addGap(583)
										.addComponent(backButton, GroupLayout.PREFERRED_SIZE, 200,
												GroupLayout.PREFERRED_SIZE)
										.addGap(646))
						.addGroup(gl_contentPane.createSequentialGroup().addGap(397)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
										.addComponent(lblNewLabel_5, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lblNewLabel_4, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lblNewLabel_3, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(
												lblNewLabel_2, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGap(18)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(jLabel4, GroupLayout.DEFAULT_SIZE, 300,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(jLabel3, GroupLayout.DEFAULT_SIZE, 300,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(jLabel2, GroupLayout.DEFAULT_SIZE, 300,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(jLabel1, GroupLayout.DEFAULT_SIZE, 300,
												GroupLayout.PREFERRED_SIZE))
								.addContainerGap(586, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addComponent(title, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE).addGap(18)
						.addGroup(gl_contentPane
								.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(
										textField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
								.createSequentialGroup()
								.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addGap(43)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(cleanButton, GroupLayout.PREFERRED_SIZE, 40,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(searchButton, GroupLayout.PREFERRED_SIZE, 40,
												GroupLayout.PREFERRED_SIZE)))
								.addComponent(textField2, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
						.addGap(100)
						.addComponent(backButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));

		contentPane.setLayout(gl_contentPane);
	}

	protected void searchButtonactionPerformed() {
		String P_ID = textField1.getText();
		String DATE = textField2.getText();
		String D_ID = null;

		try {
			// get connection to database
			connection = DriverManager.getConnection(dbUrl, username, password);

			// create a statement
			statement = connection.createStatement();

			// execute sql query
			String query1 = "SELECT app_id,d_id FROM appoinment WHERE p_id=" + P_ID + " AND app_date='" + DATE + "'";
			String query2 = "SELECT fname,lname,disease FROM patients WHERE id=" + P_ID;

			resultSet = statement.executeQuery(query1);
			if (resultSet.next()) {
				jLabel1.setText(resultSet.getString("app_id"));
				D_ID = resultSet.getString("d_id");
			} else {
				JOptionPane.showMessageDialog(null, "NO APPOINTMENT FOUND!", "ERROR", 0);
			}

			resultSet = statement.executeQuery(query2);
			if (resultSet.next()) {
				jLabel3.setText(resultSet.getString("fname") + " " + resultSet.getString("lname"));
				jLabel4.setText(resultSet.getString("disease"));
			}
//			else {
//				JOptionPane.showMessageDialog(null, this, "ERROR", 0);
//			}

			String query3 = "SELECT fname,lname FROM doctors WHERE id=" + D_ID;

			resultSet = statement.executeQuery(query3);
			if (resultSet.next()) {
				jLabel2.setText(resultSet.getString("fname") + " " + resultSet.getString("lname"));
			}
//			else {
//				JOptionPane.showMessageDialog(null, this, "ERROR", 0);
//			}

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "DATABASE NOT CONNECTED!", "ERROR", 0);
		}
	}

}
