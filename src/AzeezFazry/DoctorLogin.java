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

import javax.swing.BorderFactory;
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
import javax.swing.SwingConstants;
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
	JTextField jLabel3;
	JTextField jLabel7;
	JTextField jLabel9;
	String datePattern = "YYYY-MM-dd";
	SimpleDateFormat ft = new SimpleDateFormat(datePattern);
	String curr = ft.format(date);

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

	/*
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

		JLabel Jlabel1 = new JLabelFormat("Enter Your ID:");

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
		table = new JTable();
		table.setBorder(UIManager.getBorder("OptionPane.border"));
		table.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null, null }, { null, null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null, null } },
				new String[] { "App_ID", "App_Date", "Patient Name", "Disease", "Blood Pressure", "Blood Sugar",
						"Weight", "Temperature" }));
		scrollPane.setViewportView(table);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0, 30));

		JPanel namepanel = new JPanel();
		namepanel.setBackground(new Color(0, 0, 0, 30));

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(title, GroupLayout.DEFAULT_SIZE, 734, Short.MAX_VALUE)
					.addGap(622))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(421)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 544, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(401, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(583)
					.addComponent(logoutButton, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(583, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(34)
					.addComponent(Jlabel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(39)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
					.addGap(47)
					.addComponent(searchButton, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(706, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(433)
					.addComponent(namepanel, GroupLayout.PREFERRED_SIZE, 500, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(433, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(84)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 1200, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(88, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(title)
					.addGap(35)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(Jlabel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(searchButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
					.addGap(21)
					.addComponent(namepanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(29)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE)
					.addGap(35)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
					.addComponent(logoutButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);

		jLabel3 = new JTextField("");
		jLabel3.setBorder(BorderFactory.createEmptyBorder());
		jLabel3.setForeground(Color.RED);
		jLabel3.setFont(new Font("Serif", Font.BOLD, 30));
		jLabel3.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel3.setEditable(false);
		jLabel3.setOpaque(false);

		GroupLayout gl_namepanel = new GroupLayout(namepanel);
		gl_namepanel.setHorizontalGroup(gl_namepanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_namepanel.createSequentialGroup().addGap(20)
						.addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 460, GroupLayout.PREFERRED_SIZE)
						.addGap(10)));
		gl_namepanel.setVerticalGroup(gl_namepanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_namepanel.createSequentialGroup().addContainerGap()
						.addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		namepanel.setLayout(gl_namepanel);

		JLabel jLabel4 = new JLabelFormat("Number of patients on:");

		JLabel jLabel5 = new JLabelFormat(curr);
		jLabel5.setForeground(Color.RED);

		JLabel jLabel6 = new JLabelFormat("is");

		jLabel7 = new JTextField();
		jLabel7.setBorder(BorderFactory.createEmptyBorder());
		jLabel7.setForeground(Color.RED);
		jLabel7.setFont(new Font("Serif", Font.BOLD, 30));
		jLabel7.setEditable(false);
		jLabel7.setOpaque(false);

		JLabel jLabel8 = new JLabelFormat("Total Amount Rs.");

		jLabel9 = new JTextField();
		jLabel9.setBorder(BorderFactory.createEmptyBorder());
		jLabel9.setForeground(Color.RED);
		jLabel9.setFont(new Font("Serif", Font.BOLD, 30));
		jLabel9.setEditable(false);
		jLabel9.setOpaque(false);

		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addGroup(gl_panel
						.createParallelGroup(
								Alignment.LEADING)
						.addGroup(
								gl_panel.createSequentialGroup().addContainerGap()
										.addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addGap(10).addComponent(jLabel7, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup().addGap(96)
								.addComponent(jLabel8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addGap(18).addComponent(jLabel9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(70, Short.MAX_VALUE)));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addContainerGap()
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(jLabel8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addContainerGap(18, Short.MAX_VALUE)));
		panel.setLayout(gl_panel);

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
			String query = "SELECT APP_ID,APP_DATE,P_FNAME,P_LNAME,DISEASE,BLOOD_PRESSURE,BLOOD_SUGAR,WEIGHT,TEMPERATURE FROM APPOINTMENT A JOIN PATIENT P WHERE A.P_ID = P.P_ID AND A.D_ID = "
					+ did;
			String query1 = "SELECT D_FNAME,D_LNAME,FEE,COUNT(*) FROM BILLINFO B JOIN DOCTOR D WHERE B.D_ID = D.D_ID AND D.D_ID = "
					+ did + " GROUP BY D.D_ID";

			resultset = statement.executeQuery(query);

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

				Object[] data = { APP_ID, DATE, FNAME + " " + LNAME, DISEASE, PRESSURE, SUGAR, WEIGHT, TEMPERATURE };
				tableModel.addRow(data);
				table.setModel(tableModel);

			}

			resultset = statement.executeQuery(query1);

			while (resultset.next()) {
				String dname = resultset.getString("D_FNAME") + " " + resultset.getString("D_LNAME");
				jLabel3.setText("Dr. " + dname.toString());

				int num = Integer.parseInt(resultset.getString("COUNT(*)"));
				jLabel7.setText(String.valueOf(num));

				Double total = Double.parseDouble(resultset.getString("FEE")) * num;
				jLabel9.setText(total.toString());
			}

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", 0);

		}

	}
}
