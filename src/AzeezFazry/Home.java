/*
 * @author					: AzeezFazry
 * @e-mail					: azeezfazry@gmail.com
 * @github					: github.com/azeez-fazry
 */

package AzeezFazry;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.BevelBorder;

public class Home extends JFrame {

//  Variables declaration - do not modify

	Toolkit toolkit = getToolkit();
	Dimension size = toolkit.getScreenSize();
	Image img = Toolkit.getDefaultToolkit()
			.getImage("E:\\IntelliJ\\Fazry's Hospital Management System\\Images\\homeBackground.jpg");
	static String dbUrl = "jdbc:mysql://localhost:3306/hospital_management_system";
	static String username = "admin";
	static String password = "admin@123";
	Connection connection = null;
	Statement statement = null;
	ResultSet resultSet = null;

//  End of variables declaration

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
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
	public Home() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, size.width, size.height - 30);
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage("E:\\IntelliJ\\Fazry's Hospital Management System\\Images\\logo.png"));

		contentPane = new BackgroundJPanel(img);
		setContentPane(contentPane);

		JLabel totalPatient = new JLabel();
		totalPatient.setFont(new Font("Serif", Font.BOLD, 25));

		JLabel totalDoctor = new JLabel();
		totalDoctor.setFont(new Font("Serif", Font.BOLD, 25));

		JLabel totalAppointment = new JLabel();
		totalAppointment.setFont(new Font("Serif", Font.BOLD, 25));

		JLabel totalNurse = new JLabel();
		totalNurse.setFont(new Font("Serif", Font.BOLD, 25));

		JLabel totalStaff = new JLabel();
		totalStaff.setFont(new Font("Serif", Font.BOLD, 25));

		try {
			connection = DriverManager.getConnection(dbUrl, username, password);
			statement = connection.createStatement();
			String query1 = "SELECT COUNT(*) FROM PATIENT";
			String query2 = "SELECT COUNT(*) FROM DOCTOR";
			String query3 = "SELECT COUNT(*) FROM APPOINTMENT";
			String query4 = "SELECT COUNT(*) FROM NURSE";
			String query5 = "SELECT COUNT(*) FROM STAFF";
			resultSet = statement.executeQuery(query1);
			while (resultSet.next()) {
				totalPatient.setText(resultSet.getString("COUNT(*)"));
			}
			resultSet = statement.executeQuery(query2);
			while (resultSet.next()) {
				totalDoctor.setText(resultSet.getString("COUNT(*)"));
			}
			resultSet = statement.executeQuery(query3);
			while (resultSet.next()) {
				totalAppointment.setText(resultSet.getString("COUNT(*)"));
			}
			resultSet = statement.executeQuery(query4);
			while (resultSet.next()) {
				totalNurse.setText(resultSet.getString("COUNT(*)"));
			}
			resultSet = statement.executeQuery(query5);
			while (resultSet.next()) {
				totalStaff.setText(resultSet.getString("COUNT(*)"));
			}

		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, e1, "ERROR", 0);
		}

		JPanel panel = new JPanel();
		panel.setOpaque(false);
		
		JPanel gitPanel = new JPanel();
		gitPanel.setBackground(new Color(0, 191, 255, 90));
		gitPanel.setBorder(new BevelBorder(BevelBorder.RAISED, SystemColor.desktop, SystemColor.desktop,
				SystemColor.desktop, SystemColor.desktop));


		GroupLayout groupLayout = new GroupLayout(contentPane);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 327, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(gitPanel, GroupLayout.PREFERRED_SIZE, 978, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(43, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(gitPanel, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
							.addGap(19))))
		);
		
		JLabel lblNewLabel = new JLabel("https://github.com/azeez-fazry/Hospital-Management-System");
		lblNewLabel.setFont(new Font("Agency FB", Font.BOLD, 43));
		
		GroupLayout gl_gitPanel = new GroupLayout(gitPanel);
		gl_gitPanel.setHorizontalGroup(
			gl_gitPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_gitPanel.createSequentialGroup()
					.addContainerGap(35, Short.MAX_VALUE)
					.addComponent(lblNewLabel)
					.addGap(30))
		);
		gl_gitPanel.setVerticalGroup(
			gl_gitPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_gitPanel.createSequentialGroup()
					.addComponent(lblNewLabel)
					.addGap(7))
		);
		gitPanel.setLayout(gl_gitPanel);

		JPanel patient = new JPanel();
		patient.setBackground(new Color(255, 255, 255, 90));
		patient.setBorder(new BevelBorder(BevelBorder.RAISED, SystemColor.desktop, SystemColor.desktop,
				SystemColor.desktop, SystemColor.desktop));

		JPanel doctor = new JPanel();
		doctor.setBackground(new Color(255, 255, 255, 90));
		doctor.setBorder(new BevelBorder(BevelBorder.RAISED, SystemColor.desktop, SystemColor.desktop,
				SystemColor.desktop, SystemColor.desktop));

		JPanel appointment = new JPanel();
		appointment.setBackground(new Color(255, 255, 255, 90));
		appointment.setBorder(new BevelBorder(BevelBorder.RAISED, SystemColor.desktop, SystemColor.desktop,
				SystemColor.desktop, SystemColor.desktop));

		JPanel nurse = new JPanel();
		nurse.setBackground(new Color(255, 255, 255, 90));
		nurse.setBorder(new BevelBorder(BevelBorder.RAISED, SystemColor.desktop, SystemColor.desktop,
				SystemColor.desktop, SystemColor.desktop));

		JPanel staff = new JPanel();
		staff.setBackground(new Color(255, 255, 255, 90));
		staff.setBorder(new BevelBorder(BevelBorder.RAISED, SystemColor.desktop, SystemColor.desktop,
				SystemColor.desktop, SystemColor.desktop));

		JLabelFormat staffLabel = new JLabelFormat("STAFF");

		JLabel sTotalLabel = new JLabel("Total : ");
		sTotalLabel.setFont(new Font("Serif", Font.PLAIN, 25));

		JLabel addStaff = new JLabelHome("ADD");
		addStaff.setBackground(new Color(255, 0, 0, 100));
		addStaff.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				new AddStaff().setVisible(true);
			}
		});

		JLabel viewStaff = new JLabelHome("VIEW");
		viewStaff.setBackground(new Color(0, 0, 153, 100));
		viewStaff.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				new SearchStaff().setVisible(true);
			}
		});

		GroupLayout gl_staff = new GroupLayout(staff);
		gl_staff.setHorizontalGroup(gl_staff.createParallelGroup(Alignment.LEADING).addGroup(gl_staff
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_staff.createParallelGroup(Alignment.LEADING)
						.addComponent(staffLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_staff.createSequentialGroup().addComponent(sTotalLabel).addGap(6)
								.addComponent(totalStaff, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_staff.createSequentialGroup()
								.addComponent(addStaff, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
								.addComponent(viewStaff, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)))
				.addContainerGap(13, Short.MAX_VALUE)));
		gl_staff.setVerticalGroup(gl_staff.createParallelGroup(Alignment.LEADING).addGroup(gl_staff
				.createSequentialGroup()
				.addComponent(
						staffLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_staff.createParallelGroup(Alignment.LEADING)
						.addComponent(sTotalLabel, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(totalStaff, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
				.addGroup(gl_staff.createParallelGroup(Alignment.LEADING)
						.addComponent(addStaff, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(viewStaff, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
				.addContainerGap()));
		staff.setLayout(gl_staff);

		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addContainerGap()
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(patient, GroupLayout.PREFERRED_SIZE, 303, GroupLayout.PREFERRED_SIZE)
								.addComponent(doctor, GroupLayout.PREFERRED_SIZE, 303, GroupLayout.PREFERRED_SIZE)
								.addComponent(appointment, GroupLayout.PREFERRED_SIZE, 303, GroupLayout.PREFERRED_SIZE)
								.addComponent(nurse, GroupLayout.PREFERRED_SIZE, 303, GroupLayout.PREFERRED_SIZE)
								.addComponent(staff, GroupLayout.PREFERRED_SIZE, 303, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(14, Short.MAX_VALUE)));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
						.addComponent(patient, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(doctor, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(appointment, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(nurse, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(staff, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE).addGap(18)));

		JLabel patientLabel = new JLabelFormat("PATIENT");

		JLabel pTotalLabel = new JLabel("Total : ");
		pTotalLabel.setFont(new Font("Serif", Font.PLAIN, 25));

		JLabel addPatient = new JLabelHome("ADD");
		addPatient.setBackground(new Color(255, 0, 0, 100));
		addPatient.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				new AddPatient().setVisible(true);
			}
		});

		JLabel viewPatient = new JLabelHome("VIEW");
		viewPatient.setBackground(new Color(0, 0, 153, 100));
		viewPatient.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				new SearchPatient().setVisible(true);
			}
		});

		GroupLayout gl_patient = new GroupLayout(patient);
		gl_patient.setHorizontalGroup(gl_patient.createParallelGroup(Alignment.LEADING).addGroup(gl_patient
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_patient.createParallelGroup(Alignment.LEADING)
						.addComponent(patientLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_patient.createSequentialGroup().addComponent(pTotalLabel)
								.addPreferredGap(ComponentPlacement.RELATED).addComponent(totalPatient))
						.addGroup(gl_patient.createSequentialGroup()
								.addComponent(addPatient, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, 10, Short.MAX_VALUE).addComponent(
										viewPatient, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)))
				.addContainerGap()));
		gl_patient.setVerticalGroup(gl_patient.createParallelGroup(Alignment.LEADING).addGroup(gl_patient
				.createSequentialGroup()
				.addComponent(
						patientLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_patient
						.createParallelGroup(Alignment.BASELINE).addComponent(pTotalLabel).addComponent(totalPatient))
				.addPreferredGap(ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
				.addGroup(gl_patient.createParallelGroup(Alignment.BASELINE)
						.addComponent(addPatient, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(viewPatient, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
				.addContainerGap()));
		patient.setLayout(gl_patient);

		JLabel doctorLabel = new JLabelFormat("DOCTOR");

		JLabel dTotalLabel = new JLabel("Total : ");
		dTotalLabel.setFont(new Font("Serif", Font.PLAIN, 25));

		JLabel addDoctor = new JLabelHome("ADD");
		addDoctor.setBackground(new Color(255, 0, 0, 100));
		addDoctor.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				new AddDoctor().setVisible(true);
			}
		});

		JLabel viewDoctor = new JLabelHome("VIEW");
		viewDoctor.setBackground(new Color(0, 0, 153, 100));
		viewDoctor.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				new SearchDoctor().setVisible(true);
			}
		});

		GroupLayout gl_doctor = new GroupLayout(doctor);
		gl_doctor.setHorizontalGroup(gl_doctor.createParallelGroup(Alignment.LEADING).addGroup(gl_doctor
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_doctor.createParallelGroup(Alignment.LEADING)
						.addComponent(doctorLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_doctor.createSequentialGroup().addComponent(dTotalLabel).addGap(6)
								.addComponent(totalDoctor, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_doctor.createSequentialGroup()
								.addComponent(addDoctor, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
								.addComponent(viewDoctor, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)))
				.addContainerGap(13, Short.MAX_VALUE)));
		gl_doctor.setVerticalGroup(gl_doctor.createParallelGroup(Alignment.LEADING).addGroup(gl_doctor
				.createSequentialGroup()
				.addComponent(
						doctorLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_doctor.createParallelGroup(Alignment.LEADING)
						.addComponent(dTotalLabel, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(totalDoctor, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
				.addGroup(gl_doctor.createParallelGroup(Alignment.LEADING)
						.addComponent(addDoctor, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(viewDoctor, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
				.addContainerGap()));
		doctor.setLayout(gl_doctor);

		JLabel appointmentLabel = new JLabelFormat("APPOINTMENT");

		JLabel aTotalLabel = new JLabel("Total : ");
		aTotalLabel.setFont(new Font("Serif", Font.PLAIN, 25));

		JLabel addAppointment = new JLabelHome("ADD");
		addAppointment.setBackground(new Color(255, 0, 0, 100));
		addAppointment.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				new GetAppointment().setVisible(true);
			}
		});

		JLabel viewAppointment = new JLabelHome("VIEW");
		viewAppointment.setBackground(new Color(0, 0, 153, 100));
		viewAppointment.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				new AppointmentStatus().setVisible(true);
			}
		});

		GroupLayout gl_appointment = new GroupLayout(appointment);
		gl_appointment.setHorizontalGroup(gl_appointment.createParallelGroup(Alignment.LEADING).addGroup(gl_appointment
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_appointment.createParallelGroup(Alignment.LEADING)
						.addComponent(appointmentLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addGroup(
								gl_appointment.createSequentialGroup().addComponent(aTotalLabel).addGap(6).addComponent(
										totalAppointment, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_appointment.createSequentialGroup()
								.addComponent(addAppointment, GroupLayout.PREFERRED_SIZE, 135,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, 10, Short.MAX_VALUE).addComponent(
										viewAppointment, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)))
				.addContainerGap(13, Short.MAX_VALUE)));
		gl_appointment.setVerticalGroup(gl_appointment.createParallelGroup(Alignment.LEADING).addGroup(gl_appointment
				.createSequentialGroup()
				.addComponent(appointmentLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_appointment.createParallelGroup(Alignment.LEADING)
						.addComponent(aTotalLabel, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(totalAppointment, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
				.addGroup(gl_appointment.createParallelGroup(Alignment.LEADING)
						.addComponent(addAppointment, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(viewAppointment, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
				.addContainerGap()));
		appointment.setLayout(gl_appointment);

		JLabel nurseLabel = new JLabelFormat("NURSE");

		JLabel nTotalLabel = new JLabel("Total : ");
		nTotalLabel.setFont(new Font("Serif", Font.PLAIN, 25));

		JLabel addNurse = new JLabelHome("ADD");
		addNurse.setBackground(new Color(255, 0, 0, 100));
		addNurse.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				new AddNurse().setVisible(true);
			}
		});

		JLabel viewNurse = new JLabelHome("VIEW");
		viewNurse.setBackground(new Color(0, 0, 153, 100));
		viewNurse.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				new SearchNurse().setVisible(true);
			}
		});

		GroupLayout gl_nurse = new GroupLayout(nurse);
		gl_nurse.setHorizontalGroup(gl_nurse.createParallelGroup(Alignment.LEADING).addGroup(gl_nurse
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_nurse.createParallelGroup(Alignment.LEADING)
						.addComponent(nurseLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_nurse.createSequentialGroup().addComponent(nTotalLabel).addGap(6)
								.addComponent(totalNurse, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_nurse.createSequentialGroup()
								.addComponent(addNurse, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
								.addComponent(viewNurse, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)))
				.addContainerGap(13, Short.MAX_VALUE)));
		gl_nurse.setVerticalGroup(gl_nurse.createParallelGroup(Alignment.LEADING).addGroup(gl_nurse
				.createSequentialGroup()
				.addComponent(
						nurseLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_nurse.createParallelGroup(Alignment.LEADING)
						.addComponent(nTotalLabel, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(totalNurse, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
				.addGroup(gl_nurse.createParallelGroup(Alignment.LEADING)
						.addComponent(addNurse, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(viewNurse, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
				.addContainerGap()));
		nurse.setLayout(gl_nurse);
		panel.setLayout(gl_panel);
		getContentPane().setLayout(groupLayout);
	}
}