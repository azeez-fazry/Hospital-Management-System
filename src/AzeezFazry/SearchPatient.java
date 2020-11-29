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

public class SearchPatient extends JFrame {

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
	private JTextField jLabel1;
	private JTextField jLabel2;
	private JTextField jLabel3;
	private JTextField jLabel4;
	private JTextField jLabel5;

//  End of variables declaration

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new SearchPatient().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SearchPatient() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, size.width, size.height - 30);
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage("E:\\IntelliJ\\Fazry's Hospital Management System\\Images\\logo.png"));

		contentPane = new BackgroundJPanel(img);
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);

		JLabel title = new JLabel("SEARCH PATIENT");
		title.setFont(new Font("Serif", Font.BOLD, 60));

		JLabel lblNewLabel = new JLabelFormat("Enter ID:");

		textField1 = new JTextFieldFormat(10);
		textField1.setText("1");

		JButton backButton = new JButton();
		backButton.setIcon(
				new ImageIcon("E:\\IntelliJ\\Fazry's Hospital Management System\\Images\\back.jpg"));
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		JButton cleanButton = new JButton();
		cleanButton.setIcon(
				new ImageIcon("E:\\IntelliJ\\Fazry's Hospital Management System\\Images\\clean.jpg"));
		cleanButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField1.setText("1");
				jLabel1.setText("");
				jLabel2.setText("");
				jLabel3.setText("");
				jLabel4.setText("");
				jLabel5.setText("");
			}
		});

		JButton searchButton = new JButton();
		searchButton.setIcon(
				new ImageIcon("E:\\IntelliJ\\Fazry's Hospital Management System\\Images\\search.jpg"));
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchButtonactionPerformed();
			}
		});

		JLabel lblNewLabel_2 = new JLabelFormat("Name:");

		JLabel lblNewLabel_3 = new JLabelFormat("Age:");

		JLabel lblNewLabel_4 = new JLabelFormat("Disease");

		JLabel lblNewLabel_5 = new JLabelFormat("Phone:");

		JLabel lblNewLabel_1 = new JLabelFormat("Address:");

		jLabel1 = new JTextFieldFormat(10);
		jLabel1.setEditable(false);

		jLabel2 = new JTextFieldFormat(10);
		jLabel2.setEditable(false);

		jLabel3 = new JTextFieldFormat(10);
		jLabel3.setEditable(false);

		jLabel4 = new JTextFieldFormat(10);
		jLabel4.setEditable(false);

		jLabel5 = new JTextFieldFormat(10);
		jLabel5.setEditable(false);

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup().addGap(283)
								.addComponent(backButton, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
								.addGap(394)
								.addComponent(cleanButton, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup().addContainerGap().addGroup(gl_contentPane
								.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
										.createSequentialGroup().addGap(344)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
														.addComponent(lblNewLabel_4, Alignment.LEADING,
																GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addComponent(lblNewLabel_3, Alignment.LEADING,
																GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addComponent(lblNewLabel_2, Alignment.LEADING,
																GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
												.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 300,
														GroupLayout.PREFERRED_SIZE)
												.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
														.addComponent(jLabel5, GroupLayout.DEFAULT_SIZE, 300,
																Short.MAX_VALUE)
														.addComponent(jLabel4, GroupLayout.DEFAULT_SIZE, 300,
																Short.MAX_VALUE)
														.addComponent(jLabel3, GroupLayout.DEFAULT_SIZE, 300,
																Short.MAX_VALUE)
														.addComponent(jLabel2, GroupLayout.DEFAULT_SIZE, 300,
																Short.MAX_VALUE))))
										.addGroup(
												gl_contentPane.createSequentialGroup()
														.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addGap(51)
														.addComponent(textField1, GroupLayout.PREFERRED_SIZE, 189,
																GroupLayout.PREFERRED_SIZE)
														.addGap(30).addComponent(searchButton,
																GroupLayout.PREFERRED_SIZE, 200,
																GroupLayout.PREFERRED_SIZE)))
								.addComponent(title, GroupLayout.PREFERRED_SIZE, 908, GroupLayout.PREFERRED_SIZE))))
				.addContainerGap(289, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addComponent(title, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
				.addGap(50)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(textField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addComponent(searchButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED, 124, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(jLabel1, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 40,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup().addGap(18)
								.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addGap(18).addComponent(
										lblNewLabel_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup().addGap(19)
								.addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)))
				.addGap(18)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
				.addGap(108)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(backButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(cleanButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
				.addContainerGap()));

		contentPane.setLayout(gl_contentPane);
	}

	protected void searchButtonactionPerformed() {
		String ID = textField1.getText();

		try {

			// get connection to database
			connection = DriverManager.getConnection(dbUrl, username, password);

			// get statement
			statement = connection.createStatement();

			// execute sql query
			String query = "SELECT p_fname,p_lname,age,disease,phone,address FROM patient WHERE p_id=" + ID;

			resultSet = statement.executeQuery(query);

			if (resultSet.next()) {
				jLabel1.setText(resultSet.getString("p_fname") + " " + resultSet.getString("p_lname"));
				jLabel2.setText(resultSet.getString("age"));
				jLabel3.setText(resultSet.getString("disease"));
				jLabel4.setText(resultSet.getString("phone"));
				jLabel5.setText(resultSet.getString("address"));
			} else {
				
				JOptionPane.showMessageDialog(null, "INVALID ID!", "ERROR", 0);
			}
		} catch (Exception ex) {
			
			JOptionPane.showMessageDialog(null, "DATABASE NOT CONNECTED!", "ERROR", 0);
		}
	}

}
