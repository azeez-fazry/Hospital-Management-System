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
import java.awt.SystemColor;
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
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class BillInfo extends JFrame {

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
	String datePattern = "YYYY-MM-dd";
	Date date = new Date();
	SimpleDateFormat ft = new SimpleDateFormat(datePattern);
	String curr = ft.format(date);
	private JTextField jLabel23;
	private JTextField jLabel24;
	String did;
	String pid;
	String dname;
	String pname;
	Double total;
	Double discount;
	String dfees;
	Double hfees = 500.0;
//  End of variables declaration

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new BillInfo("111", "211").setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/*
	 * Create the frame.
	 * 
	 * @param pid
	 * @param did
	 */
	public BillInfo(String pid, String did) {
		this.pid = pid;
		this.did = did;
		try {

			// get connection to database
			connection = DriverManager.getConnection(dbUrl, username, password);

			// create a statement
			statement = connection.createStatement();

			// execute sql query
			String query1 = "SELECT d_fname,d_lname,fee FROM doctor WHERE d_id=" + did;
			String query2 = "SELECT p_fname,p_lname FROM patient WHERE p_id=" + pid;

			resultSet = statement.executeQuery(query1);
			if (resultSet.next()) {
				dname = resultSet.getString("d_fname") + " " + resultSet.getString("d_lname");
				dfees = resultSet.getString("fee");
			}

			resultSet = statement.executeQuery(query2);
			if (resultSet.next()) {
				pname = resultSet.getString("p_fname") + " " + resultSet.getString("p_lname");
			}
		} catch (Exception ex) {

			JOptionPane.showMessageDialog(null, "", "ERROR", 0);
		}

		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, size.width, size.height - 30);
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage("E:\\IntelliJ\\Fazry's Hospital Management System\\Images\\logo.png"));

		contentPane = new BackgroundJPanel(img);
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);

		JLabel title = new JLabel("BILL INFORMATION");
		title.setFont(new Font("Serif", Font.BOLD, 60));

		JButton submitButton = new JButton();
		submitButton.setIcon(new ImageIcon("E:\\IntelliJ\\Fazry's Hospital Management System\\Images\\submit.jpg"));
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Double.parseDouble(jLabel23.getText()) >= total) {
					submitButtonactionPerformed();
				}
			}
		});
		getRootPane().setDefaultButton(submitButton);


		JPanel appointmentDetailsPanel = new JPanel();
		appointmentDetailsPanel.setOpaque(false);

		JPanel billDetailsPanel = new JPanel();
		billDetailsPanel.setBorder(new TitledBorder(new LineBorder(SystemColor.controlDkShadow, 2, true),
				"BILLING INFORMATION", TitledBorder.LEADING, TitledBorder.TOP, new Font("serf", 1, 20), Color.BLACK));
		billDetailsPanel.setOpaque(false);

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup().addContainerGap()
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(title, GroupLayout.PREFERRED_SIZE, 908,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(appointmentDetailsPanel, GroupLayout.DEFAULT_SIZE, 1346,
												Short.MAX_VALUE)))
						.addGroup(gl_contentPane.createSequentialGroup().addGap(583).addComponent(submitButton,
								GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup().addGap(346).addComponent(billDetailsPanel,
								GroupLayout.PREFERRED_SIZE, 670, GroupLayout.PREFERRED_SIZE)))
				.addContainerGap()));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addComponent(title, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
				.addGap(18)
				.addComponent(appointmentDetailsPanel, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
				.addGap(29).addComponent(billDetailsPanel, GroupLayout.PREFERRED_SIZE, 445, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
				.addComponent(submitButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
				.addContainerGap()));

		JLabel jLabel7 = new JLabelFormat("Doctor Fee:");

		JLabel jLabel8 = new JLabelFormat("Hospital Fee:");

		JLabel jLabel9 = new JLabelFormat("Tax: (2.5%)");

		JLabel jLabel10 = new JLabelFormat("Discount:");

		JLabel jLabel25 = new JLabelFormat("Total:");

		JLabel jLabel11 = new JLabelFormat("Received Amount:");

		JLabel jLabel12 = new JLabelFormat("Balance:");

		JLabel jLabel13 = new JLabelFormat("Rs.");

		JLabel jLabel14 = new JLabelFormat("Rs.");

		JLabel jLabel15 = new JLabelFormat("Rs.");

		JLabel jLabel16 = new JLabelFormat("Rs.");

		JLabel jLabel17 = new JLabelFormat("Rs.");

		JLabel jLabel26 = new JLabelFormat("Rs.");

		JLabel jLabel18 = new JLabelFormat("Rs.");

		JLabel jLabel19 = new JLabelFormat("");
		jLabel19.setText(dfees);

		JLabel jLabel20 = new JLabelFormat("");
		jLabel20.setText(hfees.toString());

		total = Double.parseDouble(dfees) + hfees;

		Double tax = total * 0.25;
		JLabel jLabel21 = new JLabelFormat("");
		jLabel21.setText(tax.toString());

		total = (Double.parseDouble(dfees) + hfees + tax);
		discount = total - (total % 100);
		discount = total - discount;

		JLabel jLabel27 = new JLabelFormat("");
		jLabel27.setText(discount.toString());

		total = total - discount;
		JLabel jLabel22 = new JLabelFormat("");
		jLabel22.setText(total.toString());

		jLabel23 = new JTextFieldFormat(10);
		jLabel23.getDocument().addDocumentListener(new DocumentListener() {

			public void removeUpdate(DocumentEvent e) {
				change();
			}

			public void insertUpdate(DocumentEvent e) {
				change();
			}

			public void changedUpdate(DocumentEvent e) {
				change();
			}
		});

		jLabel24 = new JTextFieldFormat(10);

		GroupLayout gl_billDetailsPanel = new GroupLayout(billDetailsPanel);
		gl_billDetailsPanel.setHorizontalGroup(gl_billDetailsPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_billDetailsPanel.createSequentialGroup().addGap(46)
						.addGroup(gl_billDetailsPanel.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_billDetailsPanel.createSequentialGroup()
										.addGroup(gl_billDetailsPanel.createParallelGroup(Alignment.LEADING)
												.addComponent(jLabel11, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(jLabel12, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGap(44)
										.addGroup(gl_billDetailsPanel.createParallelGroup(Alignment.TRAILING)
												.addComponent(jLabel17, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(jLabel18, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGap(41)
										.addGroup(gl_billDetailsPanel.createParallelGroup(Alignment.LEADING)
												.addComponent(jLabel24, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(jLabel23, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_billDetailsPanel.createSequentialGroup()
										.addGroup(gl_billDetailsPanel.createParallelGroup(Alignment.LEADING)
												.addComponent(jLabel7, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(jLabel8, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(jLabel9, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(jLabel10, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(jLabel25, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGap(107)
										.addGroup(gl_billDetailsPanel.createParallelGroup(Alignment.LEADING, false)
												.addGroup(gl_billDetailsPanel.createSequentialGroup()
														.addComponent(jLabel26, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.RELATED,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(
																jLabel22, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
												.addGroup(gl_billDetailsPanel.createSequentialGroup()
														.addGroup(gl_billDetailsPanel
																.createParallelGroup(Alignment.LEADING)
																.addComponent(jLabel14, GroupLayout.PREFERRED_SIZE,
																		GroupLayout.DEFAULT_SIZE,
																		GroupLayout.PREFERRED_SIZE)
																.addComponent(jLabel15, GroupLayout.PREFERRED_SIZE,
																		GroupLayout.DEFAULT_SIZE,
																		GroupLayout.PREFERRED_SIZE)
																.addComponent(jLabel16, GroupLayout.PREFERRED_SIZE,
																		GroupLayout.DEFAULT_SIZE,
																		GroupLayout.PREFERRED_SIZE)
																.addComponent(
																		jLabel13, GroupLayout.PREFERRED_SIZE,
																		GroupLayout.DEFAULT_SIZE,
																		GroupLayout.PREFERRED_SIZE))
														.addGap(147)
														.addGroup(gl_billDetailsPanel
																.createParallelGroup(Alignment.TRAILING)
																.addComponent(jLabel19, GroupLayout.PREFERRED_SIZE,
																		GroupLayout.DEFAULT_SIZE,
																		GroupLayout.PREFERRED_SIZE)
																.addComponent(jLabel21, GroupLayout.PREFERRED_SIZE,
																		GroupLayout.DEFAULT_SIZE,
																		GroupLayout.PREFERRED_SIZE)
																.addComponent(jLabel20, GroupLayout.PREFERRED_SIZE,
																		GroupLayout.DEFAULT_SIZE,
																		GroupLayout.PREFERRED_SIZE)
																.addComponent(jLabel27, GroupLayout.PREFERRED_SIZE,
																		GroupLayout.DEFAULT_SIZE,
																		GroupLayout.PREFERRED_SIZE))))))
						.addGap(48)));
		gl_billDetailsPanel.setVerticalGroup(gl_billDetailsPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_billDetailsPanel.createSequentialGroup().addContainerGap().addGroup(gl_billDetailsPanel
						.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_billDetailsPanel.createSequentialGroup().addGroup(gl_billDetailsPanel
								.createParallelGroup(
										Alignment.LEADING)
								.addGroup(gl_billDetailsPanel.createSequentialGroup()
										.addComponent(jLabel13, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addGap(18)
										.addComponent(jLabel14, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addGap(18)
										.addComponent(jLabel15, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addGap(18).addComponent(
												jLabel16, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_billDetailsPanel.createSequentialGroup()
										.addComponent(jLabel19, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addGap(18)
										.addComponent(jLabel20, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addGap(18)
										.addComponent(jLabel21, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addGap(18).addComponent(jLabel27, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
								.addGap(18)
								.addGroup(gl_billDetailsPanel.createParallelGroup(Alignment.BASELINE)
										.addComponent(jLabel26, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(jLabel22, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_billDetailsPanel.createSequentialGroup()
								.addComponent(jLabel7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(jLabel8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(jLabel9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(jLabel10, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addGap(18).addComponent(jLabel25, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(133, Short.MAX_VALUE))
				.addGroup(gl_billDetailsPanel.createSequentialGroup().addContainerGap(304, Short.MAX_VALUE)
						.addGroup(gl_billDetailsPanel.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_billDetailsPanel.createParallelGroup(Alignment.LEADING)
										.addComponent(jLabel23, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_billDetailsPanel.createParallelGroup(Alignment.TRAILING)
												.addGroup(gl_billDetailsPanel.createSequentialGroup()
														.addComponent(jLabel17, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addGap(18).addComponent(jLabel18, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
												.addComponent(jLabel24, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_billDetailsPanel.createSequentialGroup()
										.addComponent(jLabel11, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addGap(18).addComponent(jLabel12, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addContainerGap()));
		billDetailsPanel.setLayout(gl_billDetailsPanel);

		JLabel jLabel1 = new JLabelFormat("Patient Name:");

		JLabel jLabel2 = new JLabelFormat("Doctor Name:");

		JLabel jLabel3 = new JLabelFormat("Appointment Date:");

		JLabel jLabel4 = new JLabelFormat("");
		jLabel4.setForeground(Color.RED);
		jLabel4.setText(pname);

		JLabel jLabel5 = new JLabelFormat("");
		jLabel5.setForeground(Color.RED);
		jLabel5.setText(dname);

		JLabel jLabel6 = new JLabelFormat("2020-11-10");

		GroupLayout gl_appointmentDetailsPanel = new GroupLayout(appointmentDetailsPanel);
		gl_appointmentDetailsPanel.setHorizontalGroup(gl_appointmentDetailsPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_appointmentDetailsPanel.createSequentialGroup()
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(gl_appointmentDetailsPanel
								.createParallelGroup(
										Alignment.LEADING)
								.addGroup(
										gl_appointmentDetailsPanel.createSequentialGroup()
												.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addGap(18)
												.addComponent(jLabel4, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addGap(428)
												.addComponent(jLabel2, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addGap(18).addComponent(jLabel5, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_appointmentDetailsPanel.createSequentialGroup().addGap(271).addComponent(
										jLabel6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)))
						.addGap(429)));
		gl_appointmentDetailsPanel.setVerticalGroup(gl_appointmentDetailsPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_appointmentDetailsPanel.createSequentialGroup().addContainerGap()
						.addGroup(gl_appointmentDetailsPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_appointmentDetailsPanel.createParallelGroup(Alignment.TRAILING)
								.addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addContainerGap(85, Short.MAX_VALUE)));
		appointmentDetailsPanel.setLayout(gl_appointmentDetailsPanel);

		contentPane.setLayout(gl_contentPane);
	}

	/*
	 * This method is used for DocumentListener.
	 */
	protected void change() {
		try {
			Double balance = (Double.parseDouble(jLabel23.getText()) - total);
			jLabel24.setText(balance.toString());
		} catch (Exception e) {
			jLabel24.setText("");
		}
	}

	/*
	 * This method is used to store the input data to server.
	 */
	protected void submitButtonactionPerformed() {

		try {
			// get connection to database
			connection = DriverManager.getConnection(dbUrl, username, password);

			// get statement
			statement = connection.createStatement();

			String query3 = "insert into billinfo (p_id,d_id,bill_date,total_amount) values('" + pid + "','" + did
					+ "','" + curr + "','" + total + "');";

			statement.executeUpdate(query3);

			JOptionPane.showMessageDialog(null, "Record Successfully Inserted");

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex, "ERROR", 0);
		}
		dispose();
	}
}
