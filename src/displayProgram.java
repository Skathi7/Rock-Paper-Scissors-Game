/*
 * This is meant to be a rock paper scissors game that runs in Java. It has a main page, a Play Game button that takes the user to the next window.
 * On the next window the user can play the work paper scissor game, it will give the user three chooses (rock, paper, scissors) and it will get a random
 * choice from the computer. The program will display both the user's choice and the comptuer's random choice. The user also has the choice to return to the
 * home page on the game window
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
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.CardLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;

public class displayProgram {

	private JFrame frmRockPaperScisscors;
	private JPanel panelMajor = new JPanel();
	private JPanel panelHome = new JPanel();
	private JPanel panelGame = new JPanel();
	private JLabel lblWelcome = new JLabel("Rock Paper Scissor Game");
	private JButton btnPlay = new JButton("Play Game");		
	private JLabel lblRock = new JLabel("");
	private JLabel lblScissors = new JLabel("");
	private JLabel lblPaper = new JLabel("");	
	private String[] rps = {"Rock", "Paper", "Scissors"}; //0 is rock, 1 is paper, 2 is scissors
	private String userChoice = "";
	private JButton btnScissors = new JButton("Scissors");
	private JButton btnRock = new JButton("Rock");
	private JButton btnPaper = new JButton("Paper");
	private Random rand = new Random();
	private int compChoice = 0;
	private JLabel lblYourChoiceWords = new JLabel("Your Choice:");
	private JLabel lblMyChoice = new JLabel("");
	private JLabel lblComputerChoiceWords = new JLabel("Computer Choice: ");
	private JLabel lblComputerChoice = new JLabel("");
	private JButton btnReturnHome = new JButton("Return Home");
	private JLabel lblRSPimg = new JLabel("");
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
		frmRockPaperScisscors.setResizable(false);
		frmRockPaperScisscors.setTitle("Rock Paper Scisscors");
		frmRockPaperScisscors.getContentPane().setBackground(new Color(173, 255, 47));
				
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
		panelMajor.setLayout(new CardLayout(0, 0));
		
		panelMajor.add(panelHome, "home");
		
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setFont(new Font("Castellar", Font.BOLD, 40));
		
		GroupLayout gl_panelHome = new GroupLayout(panelHome);
		gl_panelHome.setHorizontalGroup(
			gl_panelHome.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelHome.createSequentialGroup()
					.addGroup(gl_panelHome.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelHome.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblWelcome, GroupLayout.DEFAULT_SIZE, 676, Short.MAX_VALUE))
						.addGroup(gl_panelHome.createSequentialGroup()
							.addGap(305)
							.addComponent(btnPlay)))
					.addContainerGap())
				.addGroup(gl_panelHome.createSequentialGroup()
					.addContainerGap(202, Short.MAX_VALUE)
					.addComponent(lblRSPimg, GroupLayout.PREFERRED_SIZE, 317, GroupLayout.PREFERRED_SIZE)
					.addGap(177))
		);
		gl_panelHome.setVerticalGroup(
			gl_panelHome.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelHome.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblWelcome)
					.addPreferredGap(ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
					.addComponent(lblRSPimg, GroupLayout.PREFERRED_SIZE, 222, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnPlay)
					.addGap(101))
		);
		Image imgRPS = new ImageIcon(this.getClass().getResource("/rpsimg.png")).getImage(); //Getting the image resource for rock
		lblRSPimg.setIcon(new ImageIcon(imgRPS));

		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelMajor.removeAll();
				panelMajor.add(panelGame);
				panelMajor.repaint();
				panelMajor.revalidate();
			}
		});
		
		btnReturnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelMajor.removeAll();
				panelMajor.add(panelHome);
				panelMajor.repaint();
				panelMajor.revalidate();
			}
		});
		panelHome.setLayout(gl_panelHome);
				
		panelMajor.add(panelGame, "game");
						
		Image imgRock = new ImageIcon(this.getClass().getResource("/rock.png")).getImage(); //Getting the image resource for rock
		lblRock.setIcon(new ImageIcon(imgRock));
				
		Image imgScissors = new ImageIcon(this.getClass().getResource("/Scissors.png")).getImage();//Getting the image resource for scissors
		lblScissors.setIcon(new ImageIcon(imgScissors));
				
		Image imgPaper = new ImageIcon(this.getClass().getResource("/Paper.png")).getImage();//Getting the image resource for paper
		lblPaper.setIcon(new ImageIcon(imgPaper));
		
		GroupLayout gl_panelGame = new GroupLayout(panelGame);
		gl_panelGame.setHorizontalGroup(
			gl_panelGame.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelGame.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelGame.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelGame.createSequentialGroup()
							.addComponent(lblYourChoiceWords)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblMyChoice))
						.addGroup(gl_panelGame.createSequentialGroup()
							.addComponent(lblComputerChoiceWords)
							.addGap(1)
							.addGroup(gl_panelGame.createParallelGroup(Alignment.LEADING)
								.addComponent(lblComputerChoice)
								.addGroup(gl_panelGame.createSequentialGroup()
									.addGroup(gl_panelGame.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panelGame.createSequentialGroup()
											.addGap(10)
											.addComponent(btnScissors)
											.addGap(129)
											.addComponent(btnRock))
										.addGroup(gl_panelGame.createSequentialGroup()
											.addComponent(lblScissors)
											.addGap(93)
											.addComponent(lblRock)))
									.addGap(96)
									.addGroup(gl_panelGame.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblPaper)
										.addComponent(btnPaper)))))
						.addComponent(btnReturnHome))
					.addContainerGap(107, Short.MAX_VALUE))
		);
		gl_panelGame.setVerticalGroup(
			gl_panelGame.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelGame.createSequentialGroup()
					.addGroup(gl_panelGame.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelGame.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnReturnHome)
							.addGap(107)
							.addGroup(gl_panelGame.createParallelGroup(Alignment.LEADING)
								.addComponent(lblPaper)
								.addComponent(lblScissors)))
						.addGroup(gl_panelGame.createSequentialGroup()
							.addGap(163)
							.addComponent(lblRock)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelGame.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnScissors)
						.addComponent(btnRock)
						.addComponent(btnPaper))
					.addGap(100)
					.addGroup(gl_panelGame.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblYourChoiceWords)
						.addComponent(lblMyChoice))
					.addPreferredGap(ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
					.addGroup(gl_panelGame.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblComputerChoiceWords)
						.addComponent(lblComputerChoice))
					.addContainerGap())
		);
		
		btnScissors.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userChoice = "Scissors";//Setting user's choice to equal the button they pressed: scissors
				compareToComputer(userChoice);//Calling function to display results
			}
		});
		btnRock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userChoice = "Rock";//Setting user's choice to equal the button they pressed: rock
				compareToComputer(userChoice);//Calling function to display results
			}
		});
		btnPaper.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userChoice = "Paper";//Setting user's choice to equal the button they pressed: paper
				compareToComputer(userChoice);//Calling function to display results
			}
		});
		panelGame.setLayout(gl_panelGame);
		frmRockPaperScisscors.getContentPane().setLayout(groupLayout);
		frmRockPaperScisscors.setBounds(100, 100, 736, 516);
		frmRockPaperScisscors.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	private void compareToComputer(String userChoice) {
		compChoice = rand.nextInt(rps.length);//Getting random number
		lblMyChoice.setText(userChoice);//Displaying the user's choice
		lblComputerChoice.setText(rps[compChoice]);//Displaying the computer's choice
		
	}//End of function compareToComputer
}
