/*
 * @author	: AzeezFazry
 * @e-mail	: azeezfazry@gmail.com
 * @github	: github.com/azeez-fazry
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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

public class DoctorLogin extends JFrame {

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
	ResultSet resultset = null;
	Date date = new Date();
	SimpleDateFormat f = new SimpleDateFormat("YYYY-MM-dd");
	private JTextField textField;
	private JTable table;

//  End of variables declaration

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DoctorLogin frame = new DoctorLogin();
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
	public DoctorLogin() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, size.width, size.height - 30);
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage("E:\\IntelliJ\\Fazry's Hospital Management System\\Images\\logo.png"));

		contentPane = new BackgroundJPanel(img);
		setContentPane(contentPane);

		JLabel title = new JLabel("DOCTOR LOGIN");
		title.setFont(new Font("Serif", Font.BOLD, 60));

		JButton logoutButton = new JButton();
		logoutButton.setIcon(new ImageIcon("E:\\IntelliJ\\Fazry's Hospital Management System\\Images\\logout.jpg"));
		logoutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		JLabel lblNewLabel = new JLabelFormat("Enter Your ID:");

		textField = new JTextFieldFormat(10);
		textField.setText("2");

		JButton searchButton = new JButton();
		searchButton.setIcon(new ImageIcon("E:\\IntelliJ\\Fazry's Hospital Management System\\Images\\search.jpg"));
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = textField.getText();
				searchButtonactionPerformed(id);
			}
		});
		getRootPane().setDefaultButton(searchButton);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setOpaque(false);
		table = new JTable();
		table.setBorder(UIManager.getBorder("OptionPane.border"));
		table.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null, null }, { null, null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null, null } },
				new String[] { "App_ID", "App_Date", "Patient Name", "Disease", "Blood Pressure", "Blood Sugar",
						"Weight", "Temperature" }));
		scrollPane.setViewportView(table);

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane
				.setHorizontalGroup(
						gl_contentPane
								.createParallelGroup(
										Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup().addGap(74)
										.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addGap(39)
										.addComponent(textField, GroupLayout.PREFERRED_SIZE, 144,
												GroupLayout.PREFERRED_SIZE)
										.addGap(47)
										.addComponent(searchButton, GroupLayout.PREFERRED_SIZE, 200,
												GroupLayout.PREFERRED_SIZE)
										.addGap(666))
								.addGroup(
										gl_contentPane.createSequentialGroup().addGap(83)
												.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 1200,
														Short.MAX_VALUE)
												.addGap(83))
								.addGroup(gl_contentPane.createSequentialGroup().addGap(583)
										.addComponent(logoutButton, GroupLayout.PREFERRED_SIZE, 200, Short.MAX_VALUE)
										.addGap(583))
								.addGroup(Alignment.LEADING,
										gl_contentPane.createSequentialGroup().addContainerGap()
												.addComponent(title, GroupLayout.DEFAULT_SIZE, 734, Short.MAX_VALUE)
												.addGap(622)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addComponent(title).addGap(30)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(searchButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
						.addGap(100)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 221, Short.MAX_VALUE)
						.addComponent(logoutButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));

		contentPane.setLayout(gl_contentPane);
	}

	protected void searchButtonactionPerformed(String id) {
		String did = id;
		String[] columnNames = { "App_ID", "App_Date", "Patient Name", "Disease", "Blood Pressure", "Blood Sugar",
				"Weight", "Temperature" };

		DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);

		try {
			// get connection to database
			connection = DriverManager.getConnection(dbUrl, username, password);

			// create statement
			statement = connection.createStatement();
			String query = "SELECT APP_ID,APP_DATE,P_FNAME,P_LNAME,DISEASE,BLOOD_PRESSURE,BLOOD_SUGAR,WEIGHT,TEMPERATURE FROM APPOINTMENT NATURAL JOIN PATIENT WHERE D_ID="
					+ did;
			resultset = statement.executeQuery(query);

			try {
					while (resultset.next()) {

						String APP_ID = resultset.getString("APP_ID");
						String PRESSURE = resultset.getString("BLOOD_PRESSURE");
						String SUGAR = resultset.getString("BLOOD_SUGAR");
						String WEIGHT = resultset.getString("WEIGHT");
						String TEMPERATURE = resultset.getString("TEMPERATURE");
						String DATE = resultset.getString("APP_DATE");
						String FNAME = resultset.getString("P_FNAME");
						String LNAME = resultset.getString("P_LNAME");
						String DISEASE = resultset.getString("DISEASE");

						Object[] data = { APP_ID, DATE, FNAME + " " + LNAME, DISEASE, PRESSURE, SUGAR, WEIGHT,
								TEMPERATURE };
						tableModel.addRow(data);
						table.setModel(tableModel);

					}

			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", 0);
			}

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", 0);
		}

	}

}
