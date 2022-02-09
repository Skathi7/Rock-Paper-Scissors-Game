/*
 * This is meant to be a rock paper scissors game that runs in java. It is still in the works and not completed yet, this is an ongoing project
 * The part completed so far is the main page. It will have another window where the user will have the choice between pressing rock, paper or scissors
 * and the program will randomly choose one of the three in response and compare the to see who is the winner 
 * 
 * 
 * 
 * 
 */

import java.awt.EventQueue;
import java.awt.Image;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.border.EtchedBorder;

public class displayProgram {

	private JFrame frmRockPaperScisscors;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					displayProgram window = new displayProgram();
					window.frmRockPaperScisscors.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	 //Create the application.
	public displayProgram() {
		initialize();
	}
	 //Initialize the contents of the frame.

	private void initialize() {
		frmRockPaperScisscors = new JFrame();
		frmRockPaperScisscors.setTitle("Rock Paper Scisscors");
		frmRockPaperScisscors.getContentPane().setBackground(new Color(173, 255, 47));
		
		JPanel panelMajor = new JPanel();
		panelMajor.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelMajor.setBackground(new Color(220, 220, 220));
		GroupLayout groupLayout = new GroupLayout(frmRockPaperScisscors.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panelMajor, GroupLayout.DEFAULT_SIZE, 687, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panelMajor, GroupLayout.DEFAULT_SIZE, 436, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JLabel lblRPSIMG = new JLabel("");//Making a label for the image, this will be where the image is located
		Image img = new ImageIcon(this.getClass().getResource("/rps.png")).getImage();//Getting the image

		lblRPSIMG.setIcon(new ImageIcon(img));//Setting the image
		
		JLabel lblNewLabel = new JLabel("Rock Paper Scissors Game");
		lblNewLabel.setFont(new Font("Blackadder ITC", Font.PLAIN, 40));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		GroupLayout gl_panelMajor = new GroupLayout(panelMajor);
		gl_panelMajor.setHorizontalGroup(
			gl_panelMajor.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelMajor.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelMajor.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelMajor.createSequentialGroup()
							.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 676, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(Alignment.TRAILING, gl_panelMajor.createSequentialGroup()
							.addComponent(lblRPSIMG)
							.addGap(193))))
		);
		gl_panelMajor.setVerticalGroup(
			gl_panelMajor.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panelMajor.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
					.addGap(56)
					.addComponent(lblRPSIMG)
					.addContainerGap(111, Short.MAX_VALUE))
		);
		panelMajor.setLayout(gl_panelMajor);
		frmRockPaperScisscors.getContentPane().setLayout(groupLayout);
		frmRockPaperScisscors.setBounds(100, 100, 736, 516);
		frmRockPaperScisscors.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
