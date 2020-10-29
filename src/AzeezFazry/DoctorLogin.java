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
import java.awt.event.ContainerEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class DoctorLogin extends JFrame {

//  Variables declaration - do not modify

	private JPanel contentPane;
	Toolkit toolkit = getToolkit();
	Dimension size = toolkit.getScreenSize();
	Image img = Toolkit.getDefaultToolkit()
			.getImage("E:\\IntelliJ\\Fazry's Hospital Management System - FullScreen\\Images\\background.jpg");
	static String dbUrl = "jdbc:mysql://localhost:3306/hospital_management_system";
	static String username = "admin";
	static String password = "admin@123";
	Connection connection = null;
	PreparedStatement statement = null;
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
//		setResizable(false);

		contentPane = new BackgroundJPanel(img);
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);

		JLabel title = new JLabel("DOCTOR LOGIN");
		title.setFont(new Font("Serif", Font.BOLD, 60));

		JButton logoutButton = new JButton();
		logoutButton.setIcon(
				new ImageIcon("E:\\IntelliJ\\Fazry's Hospital Management System - FullScreen\\Images\\logout.jpg"));
		logoutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		JButton exitButton = new JButton();
		exitButton.setIcon(
				new ImageIcon("E:\\IntelliJ\\Fazry's Hospital Management System - FullScreen\\Images\\close.png"));
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(1);
			}
		});

		JButton aboutUsButton = new JButton();
		aboutUsButton.setIcon(
				new ImageIcon("E:\\IntelliJ\\Fazry's Hospital Management System - FullScreen\\Images\\contact.jpg"));
		aboutUsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		});

		JLabel lblNewLabel = new JLabelFormat("Enter Your ID:");

		textField = new JTextFieldFormat(10);

		JButton searchButton = new JButton();
		searchButton.setIcon(
				new ImageIcon("E:\\IntelliJ\\Fazry's Hospital Management System - FullScreen\\Images\\search.jpg"));
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = textField.getText();
				searchButtonactionPerformed(id);
			}
		});

		JScrollPane scrollPane = new JScrollPane();
		table = new JTable();
		table.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] { { null, null, null, null }, { null, null, null, null }, { null, null, null, null },
						{ null, null, null, null } },
				new String[] { "App_ID", "App_Date", "Patient Name", "Disease" }));
		table.addContainerListener(new java.awt.event.ContainerAdapter() {
			public void componentAdded(java.awt.event.ContainerEvent evt) {
				jTable1ComponentAdded(evt);
			}
		});

		scrollPane.setViewportView(table);

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap()
						.addComponent(title, GroupLayout.DEFAULT_SIZE, 734, Short.MAX_VALUE).addGap(540)
						.addComponent(aboutUsButton, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(exitButton, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup().addGap(74)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addGap(39).addComponent(textField, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
						.addGap(47)
						.addComponent(searchButton, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
						.addGap(666))
				.addGroup(gl_contentPane.createSequentialGroup().addGap(233)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 900, Short.MAX_VALUE).addGap(233))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup().addGap(583)
						.addComponent(logoutButton, GroupLayout.PREFERRED_SIZE, 200, Short.MAX_VALUE).addGap(583)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING).addGroup(
				Alignment.LEADING,
				gl_contentPane.createSequentialGroup().addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(title, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(searchButton, GroupLayout.PREFERRED_SIZE, 40,
												GroupLayout.PREFERRED_SIZE))
								.addGap(106)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup().addContainerGap()
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(aboutUsButton, GroupLayout.PREFERRED_SIZE, 31,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(exitButton, GroupLayout.PREFERRED_SIZE, 31,
												GroupLayout.PREFERRED_SIZE))))
						.addPreferredGap(ComponentPlacement.RELATED, 221, Short.MAX_VALUE)
						.addComponent(logoutButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));

		contentPane.setLayout(gl_contentPane);
	}

	protected void jTable1ComponentAdded(ContainerEvent evt) {
		// TODO Auto-generated method stub

	}

	protected void searchButtonactionPerformed(String id) {
		try {
			// get connection to database
			connection = DriverManager.getConnection(dbUrl, username, password);

			// create statement
			String query1 = "SELECT app_id,p_id,app_date FROM appoinment WHERE d_id=?";
			statement = connection.prepareStatement(query1);
			String D_ID = id;
			statement.setString(1, D_ID);
			ResultSet resultSet1 = statement.executeQuery();

			String FNAME = null;
			String LNAME = null;
			String DISEASE = null;
			String[] columnNames = { "App_ID", "App_Date", "Patient Name", "Disease" };
			DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
			try {
				while (resultSet1.next()) {
					int APP_ID = resultSet1.getInt("app_id");
					int P_ID = resultSet1.getInt("p_id");
					String DATE = resultSet1.getString("app_date");
					try {
						connection = DriverManager.getConnection(dbUrl, username, password);
						String query2 = "SELECT fname,lname,disease FROM patients WHERE id=?";
						statement = connection.prepareStatement(query2);
						statement.setInt(1, P_ID);
						ResultSet resultSet2 = statement.executeQuery();
						if (resultSet2.next()) {
							FNAME = resultSet2.getString("fname");
							LNAME = resultSet2.getString("lname");
							DISEASE = resultSet2.getString("disease");
						}
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(null, this, "Error", 0);
					}
					Object[] data = { APP_ID, DATE, FNAME + " " + LNAME, DISEASE };
					tableModel.addRow(data);
					table.setModel(tableModel);
				}
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, this, "Error", 0);
			}

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, this, "Error", 0);
		}
	}

}
