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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.ParseException;
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
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class GetAppointment extends JFrame {

	protected static final boolean True = false;
//  Variables declaration - do not modify

	private JPanel contentPane;
	Toolkit toolkit = getToolkit();
	Dimension size = toolkit.getScreenSize();
	Image img = Toolkit.getDefaultToolkit()
			.getImage("E:\\IntelliJ\\Fazry's Hospital Management System\\Images\\background.jpg");
	static String dbUrl = "jdbc:mysql://localhost:3306/hospital_management_system";
	static String username = "admin";
	static String password = "admin@123";
	Connection connection;
	Statement statement;
	ResultSet resultSet;
	String datePattern = "YYYY-MM-dd";
	Date date = new Date();
	SimpleDateFormat ft = new SimpleDateFormat(datePattern);
	String curr = ft.format(date);
	private JTextField textField1;
	private JTextField textField2;
	private JTextField textField3;
	private JTextField textField4;
	private JTextField textField5;
	private JTextField textField6;
	private JTextField textField7;
	String pid;
	String did;
//  End of variables declaration

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new GetAppointment().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GetAppointment() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, size.width, size.height - 30);
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage("E:\\IntelliJ\\Fazry's Hospital Management System\\Images\\logo.png"));

		contentPane = new BackgroundJPanel(img);
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);

		JLabel title = new JLabel("GET NEW APPOINTMENT");
		title.setFont(new Font("Serif", Font.BOLD, 60));

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
				submitButtonactionPerformed();
			}
		});

		JPanel panel1 = new JPanel();
		panel1.setBorder(new TitledBorder(new LineBorder(SystemColor.controlDkShadow, 2, true), "PATIENT INFORMATION",
				TitledBorder.LEADING, TitledBorder.TOP, new Font("serf", 1, 11), Color.BLACK));
		panel1.setOpaque(false);

		JPanel panel2 = new JPanel();
		panel2.setBorder(new TitledBorder(new LineBorder(SystemColor.controlDkShadow, 2, true), "DOCTOR & DATE",
				TitledBorder.LEADING, TitledBorder.TOP, new Font("serf", 1, 11), Color.BLACK));
		panel2.setOpaque(false);

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup().addGap(283)
								.addComponent(backButton, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
								.addGap(394).addComponent(submitButton, GroupLayout.PREFERRED_SIZE, 200,
										GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup().addContainerGap().addComponent(title,
								GroupLayout.PREFERRED_SIZE, 908, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup().addGap(50)
								.addComponent(panel1, GroupLayout.PREFERRED_SIZE, 600, GroupLayout.PREFERRED_SIZE)
								.addGap(66)
								.addComponent(panel2, GroupLayout.PREFERRED_SIZE, 600, GroupLayout.PREFERRED_SIZE)))
				.addContainerGap(101, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addComponent(title, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE).addGap(106)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(panel2, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
								.addComponent(panel1, GroupLayout.PREFERRED_SIZE, 327, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED, 165, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(backButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
								.addComponent(submitButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
						.addContainerGap()));

		JLabel jLabel2 = new JLabelFormat("Doctor ID:");

		JLabel jLabel3 = new JLabelFormat("Appointment Date:");

		textField2 = new JTextFieldFormat(10);
		textField2.setText("2");

		textField3 = new JTextFieldFormat(10);
		textField3.setText(curr);
		GroupLayout gl_panel2 = new GroupLayout(panel2);
		gl_panel2.setHorizontalGroup(gl_panel2.createParallelGroup(Alignment.TRAILING).addGroup(Alignment.LEADING,
				gl_panel2.createSequentialGroup().addContainerGap().addGroup(gl_panel2
						.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel2.createSequentialGroup()
								.addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(textField3, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel2.createSequentialGroup()
								.addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(textField2, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(30, Short.MAX_VALUE)));
		gl_panel2.setVerticalGroup(gl_panel2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel2.createSequentialGroup().addContainerGap()
						.addGroup(gl_panel2.createParallelGroup(Alignment.BASELINE)
								.addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(textField2, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_panel2.createParallelGroup(Alignment.BASELINE)
								.addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(textField3, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(25, Short.MAX_VALUE)));
		panel2.setLayout(gl_panel2);

		JLabel jLabel1 = new JLabelFormat("Patient ID:");

		JLabel jLabel4 = new JLabelFormat("Blood Pressure:");

		JLabel jLabel5 = new JLabelFormat("Blood Sugar:");

		JLabel jLabel6 = new JLabelFormat("Weight:");

		JLabel jLabel7 = new JLabelFormat("Temperature:");

		textField1 = new JTextFieldFormat(10);
		textField1.setText("1");

		textField4 = new JTextFieldFormat(10);

		textField5 = new JTextFieldFormat(10);

		textField6 = new JTextFieldFormat(10);

		textField7 = new JTextFieldFormat(10);

		GroupLayout gl_panel1 = new GroupLayout(panel1);
		gl_panel1.setHorizontalGroup(gl_panel1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel1.createSequentialGroup().addGap(23)
						.addGroup(gl_panel1.createParallelGroup(Alignment.LEADING)
								.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(38)
						.addGroup(gl_panel1.createParallelGroup(Alignment.TRAILING)
								.addComponent(textField6, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField5, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField7, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField4, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField1, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(24, Short.MAX_VALUE)));
		gl_panel1
				.setVerticalGroup(gl_panel1.createParallelGroup(Alignment.TRAILING).addGroup(Alignment.LEADING,
						gl_panel1.createSequentialGroup().addGap(19).addGroup(gl_panel1
								.createParallelGroup(
										Alignment.LEADING)
								.addGroup(gl_panel1.createSequentialGroup()
										.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addGap(18)
										.addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addGap(18)
										.addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addGap(18)
										.addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addGap(18)
										.addComponent(
												jLabel7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel1.createSequentialGroup()
										.addComponent(textField1, GroupLayout.PREFERRED_SIZE, 40,
												GroupLayout.PREFERRED_SIZE)
										.addGap(18)
										.addComponent(textField4, GroupLayout.PREFERRED_SIZE, 40,
												GroupLayout.PREFERRED_SIZE)
										.addGap(18)
										.addComponent(textField5, GroupLayout.PREFERRED_SIZE, 40,
												GroupLayout.PREFERRED_SIZE)
										.addGap(18)
										.addComponent(textField6, GroupLayout.PREFERRED_SIZE, 40,
												GroupLayout.PREFERRED_SIZE)
										.addGap(18).addComponent(textField7, GroupLayout.PREFERRED_SIZE, 40,
												GroupLayout.PREFERRED_SIZE)))
								.addContainerGap(37, Short.MAX_VALUE)));
		panel1.setLayout(gl_panel1);

		contentPane.setLayout(gl_contentPane);
	}

	protected void submitButtonactionPerformed() {
		String App_Date = textField3.getText();
		boolean isValidDate = compareDate(App_Date);
		if (isValidDate) {
			try {
				// get connection to database
				connection = DriverManager.getConnection(dbUrl, username, password);

				// get statement
				statement = connection.createStatement();

				pid = textField1.getText();
				did = textField2.getText();
				String S = "insert into appointment (p_id,d_id,app_date,blood_pressure,blood_sugar,weight,temperature) values('"
						+ pid + "','" + did + "','" + textField3.getText() + "','" + textField4.getText() + "','"
						+ textField5.getText() + "','" + textField6.getText() + "','" + textField7.getText() + "');";

				statement.executeUpdate(S);

				String query = "select max(d_id) from appointment;";
				resultSet = statement.executeQuery(query);
				if (resultSet.next()) {
					String id = resultSet.getString("max(d_id)");
					JOptionPane.showMessageDialog(null, "Record Inserted Successfully." + "\n" + "\n" + "APPOINTMENT ID: " + id,
							"Record Inserted Successfully", JOptionPane.NO_OPTION);
				}

				textField1.setText("1");
				textField2.setText("2");
				textField3.setText(curr);

			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, ex, "ERROR", 0);
			}
		} else {
			textField3.setText(curr);
		}

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				new BillInfo(pid, did).setVisible(true);
			}
		});
	}

	private boolean compareDate(String App_Date) {

		// check date format YYYY-MM-dd
		try {
			DateFormat df = new SimpleDateFormat(datePattern);
			df.setLenient(false);
			df.parse(App_Date);
		} catch (ParseException ex) {
			JOptionPane.showMessageDialog(null, " Please enter the date in the form of YYYY-MM-DD ", " Invalid Date! ",
					JOptionPane.NO_OPTION);
			return false;
		}

		// check whether the input date coming on or after the current date
		try {
			Date currentDate = ft.parse(curr);
			Date inputDate = ft.parse(App_Date);
			if (inputDate.compareTo(currentDate) >= 0) {
				return true;
			} else {
				JOptionPane.showMessageDialog(null, " Please enter a date on or after " + curr, " Invalid Date! ",
						JOptionPane.NO_OPTION);
				return false;
			}
		} catch (Exception e) {
		}
		return false;
	}

}
