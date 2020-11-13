/**
 * @author AzeezFazry
 */
package AzeezFazry;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Home extends JFrame {

//  Variables declaration - do not modify

	private JPanel contentPane;
	Toolkit toolkit = getToolkit();
	Dimension size = toolkit.getScreenSize();
	Image img = Toolkit.getDefaultToolkit()
			.getImage("E:\\IntelliJ\\Fazry's Hospital Management System\\Images\\backgroundHome.jpg");

//  End of variables declaration

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new Home().setVisible(true);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e, "ERROR", 0);
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
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);

		JButton logintButton = new JButton();
		logintButton.setIcon(new ImageIcon("E:\\IntelliJ\\Fazry's Hospital Management System\\Images\\login.jpg"));
		logintButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						new Login().setVisible(true);
					}
				});
			}
		});

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup().addGap(583)
						.addComponent(logintButton, GroupLayout.PREFERRED_SIZE, 200, Short.MAX_VALUE).addGap(583)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap(687, Short.MAX_VALUE)
						.addComponent(logintButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));

		contentPane.setLayout(gl_contentPane);
	}
}
