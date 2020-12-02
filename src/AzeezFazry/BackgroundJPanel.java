package AzeezFazry;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JTree;

public class BackgroundJPanel extends JPanel {

	Image img;

	public BackgroundJPanel(Image img) {
		
		this.img = img;
		repaint();

	}

	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		g.drawImage(img, 0, 0, 1366, 768, this);
		initComponents();

	}

	public void initComponents() {
		
		JButton exitButton = new JButton();
		exitButton.setIcon(new ImageIcon("E:\\IntelliJ\\Fazry's Hospital Management System\\Images\\close.png"));
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(1);
			}
		});

		JButton aboutUsButton = new JButton();
		aboutUsButton.setIcon(new ImageIcon("E:\\IntelliJ\\Fazry's Hospital Management System\\Images\\contact.jpg"));
		aboutUsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							new AboutUs().setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});

		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(372, Short.MAX_VALUE)
					.addComponent(aboutUsButton, 31, 31, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(exitButton, 31, 31, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(aboutUsButton, Alignment.LEADING, 31, 31, GroupLayout.PREFERRED_SIZE)
						.addComponent(exitButton, Alignment.LEADING, 31, 31, GroupLayout.PREFERRED_SIZE))
					.addGap(258))
		);
		setLayout(groupLayout);
		
	}
}
