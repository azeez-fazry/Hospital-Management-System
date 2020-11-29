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

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

public class Activities extends JFrame {

	
//	Variables declaration - do not modify
	 
	private JPanel contentPane;
	Toolkit toolkit = getToolkit();
	Dimension size = toolkit.getScreenSize();
	Image img = Toolkit.getDefaultToolkit()
			.getImage("E:\\IntelliJ\\Fazry's Hospital Management System\\Images\\backgroundActivities.jpg");
	
//	End of variables declaration
	 

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) { EventQueue.invokeLater(new Runnable() { public void run() {  new Activities().setVisible(true);  } }); }

	/**
	 * Create the frame.
	 */
	public Activities() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, size.width, size.height - 30);
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage("E:\\IntelliJ\\Fazry's Hospital Management System\\Images\\logo.png"));

		contentPane = new BackgroundJPanel(img);
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);

		JLabel title = new JLabel("ACTIVITIES");
		title.setFont(new Font("Serif", Font.BOLD, 60));

		JButton backButton = new JButton();
		backButton.setIcon(new ImageIcon("E:\\IntelliJ\\Fazry's Hospital Management System\\Images\\logout.jpg"));
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		JButton jButton1 = new JButton();
		jButton1.setIcon(
				new ImageIcon("E:\\IntelliJ\\Fazry's Hospital Management System\\Images\\activities\\ADD PATIENT.jpg"));
		jButton1.setBorder(null);
		jButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							new AddPatient().setVisible(true);
						} catch (Exception e) {
							JOptionPane.showMessageDialog(null, e, "ERROR", 0);
						}
					}
				});
			}
		});

		JButton jButton2 = new JButton();
		jButton2.setBorder(null);
		jButton2.setIcon(new ImageIcon(
				"E:\\IntelliJ\\Fazry's Hospital Management System\\Images\\activities\\SEARCH PATIENT.jpg"));
		jButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							new SearchPatient().setVisible(true);
						} catch (Exception e) {
							JOptionPane.showMessageDialog(null, e, "ERROR", 0);
						}
					}
				});
			}
		});

		JButton jButton3 = new JButton();
		jButton3.setBorder(null);
		jButton3.setIcon(
				new ImageIcon("E:\\IntelliJ\\Fazry's Hospital Management System\\Images\\activities\\ADD DOCTOR.jpg"));
		jButton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							new AddDoctor().setVisible(true);
						} catch (Exception e) {
							JOptionPane.showMessageDialog(null, e, "ERROR", 0);
						}
					}
				});
			}
		});

		JButton jButton4 = new JButton();
		jButton4.setBorder(null);
		jButton4.setIcon(new ImageIcon(
				"E:\\IntelliJ\\Fazry's Hospital Management System\\Images\\activities\\SEARCH DOCTOR.jpg"));
		jButton4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							new SearchDoctor().setVisible(true);
						} catch (Exception e) {
							JOptionPane.showMessageDialog(null, e, "ERROR", 0);
						}
					}
				});
			}
		});

		JButton jButton5 = new JButton();
		jButton5.setBorder(null);
		jButton5.setIcon(
				new ImageIcon("E:\\IntelliJ\\Fazry's Hospital Management System\\Images\\activities\\ADD NURSE.jpg"));
		jButton5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							new AddNurse().setVisible(true);
						} catch (Exception e) {
							JOptionPane.showMessageDialog(null, e, "ERROR", 0);
						}
					}
				});
			}
		});

		JButton jButton6 = new JButton();
		jButton6.setBorder(null);
		jButton6.setIcon(new ImageIcon(
				"E:\\IntelliJ\\Fazry's Hospital Management System\\Images\\activities\\SEARCH NURSE.jpg"));
		jButton6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							new SearchNurse().setVisible(true);
						} catch (Exception e) {
							JOptionPane.showMessageDialog(null, e, "ERROR", 0);
						}
					}
				});
			}
		});

		JButton jButton7 = new JButton();
		jButton7.setBorder(null);
		jButton7.setIcon(
				new ImageIcon("E:\\IntelliJ\\Fazry's Hospital Management System\\Images\\activities\\ADD STAFF.jpg"));
		jButton7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							new AddStaff().setVisible(true);
						} catch (Exception e) {
							JOptionPane.showMessageDialog(null, e, "ERROR", 0);
						}
					}
				});
			}
		});

		JButton jButton8 = new JButton("");
		jButton8.setBorder(null);
		jButton8.setIcon(new ImageIcon(
				"E:\\IntelliJ\\Fazry's Hospital Management System\\Images\\activities\\SEARCH STAFF.jpg"));
		jButton8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							new SearchStaff().setVisible(true);
						} catch (Exception e) {
							JOptionPane.showMessageDialog(null, e, "ERROR", 0);
						}
					}
				});
			}
		});

		JButton jButton9 = new JButton();
		jButton9.setBorder(null);
		jButton9.setIcon(new ImageIcon(
				"E:\\IntelliJ\\Fazry's Hospital Management System\\Images\\activities\\GET APPOINTMENT.jpg"));
		jButton9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							new GetAppointment().setVisible(true);
						} catch (Exception e) {
							JOptionPane.showMessageDialog(null, e, "ERROR", 0);
						}
					}
				});
			}
		});

		JButton jButton10 = new JButton();
		jButton10.setBorder(null);
		jButton10.setIcon(new ImageIcon(
				"E:\\IntelliJ\\Fazry's Hospital Management System\\Images\\activities\\APPOINTMENT STATUS.jpg"));
		jButton10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							new AppointmentStatus().setVisible(true);
						} catch (Exception e) {
							JOptionPane.showMessageDialog(null, e, "ERROR", 0);
						}
					}
				});
			}
		});

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(583)
							.addComponent(backButton, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(title, GroupLayout.PREFERRED_SIZE, 908, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(183)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(jButton5, GroupLayout.PREFERRED_SIZE, 300, Short.MAX_VALUE)
								.addComponent(jButton7, GroupLayout.PREFERRED_SIZE, 300, Short.MAX_VALUE)
								.addComponent(jButton3, GroupLayout.PREFERRED_SIZE, 300, Short.MAX_VALUE)
								.addComponent(jButton1, 0, 0, Short.MAX_VALUE))
							.addGap(50)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(jButton9, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
								.addComponent(jButton10, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE))
							.addGap(50)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
								.addComponent(jButton4, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
								.addComponent(jButton6, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
								.addComponent(jButton8, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE))))
					.addGap(448))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(title, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
					.addGap(80)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(jButton3, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
							.addGap(60)
							.addComponent(jButton5, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
							.addGap(60)
							.addComponent(jButton7, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
							.addGap(60)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(jButton9, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
								.addComponent(jButton4, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(60)
									.addComponent(jButton6, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
									.addGap(60)
									.addComponent(jButton8, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(61)
									.addComponent(jButton10, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)))))
					.addPreferredGap(ComponentPlacement.RELATED, 138, Short.MAX_VALUE)
					.addComponent(backButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);

		contentPane.setLayout(gl_contentPane);
	}
}
