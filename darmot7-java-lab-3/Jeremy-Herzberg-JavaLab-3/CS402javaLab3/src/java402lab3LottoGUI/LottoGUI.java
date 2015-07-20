package java402lab3LottoGUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

public class LottoGUI implements ActionListener {

	ArrayList<Integer> storedNumbers = new ArrayList<Integer>(6);
	int storedNumberIndex= 0;
	JFrame lottoWindow;
	JPanel lottoGrid;
	JButton draw;
	ArrayList<Integer> winningNumbers;
	JLabel dollas;
	int money = 10;
	
	public LottoGUI() {
		JPanel container = new JPanel();
		container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
		
		
		//has buttons and numbers in it
		JPanel bigButtonsandLottoNumber = new JPanel();
		bigButtonsandLottoNumber.setLayout(new BoxLayout(bigButtonsandLottoNumber, BoxLayout.X_AXIS));
		
		
		
		//this is the lotto grid set up
		lottoGrid = new JPanel(new SpringLayout());
		int col = 7;
		int row = 7;
		int counter = 0;
		String box;
		
		for (int r = 0; r < row; r++ ) {
			for (int c = 0; c < col; c++) {
				box = Integer.toString(counter++);
				JButton lottoButton = new JButton(box);
				//lottoButton.setActionCommand("CLICK");
				lottoButton.addActionListener(this);
				lottoGrid.add(lottoButton);
			}
		}
		
		
		SpringUtilities.makeCompactGrid(lottoGrid, //parent
                row, col,
                3, 3,  //initX, initY
                3, 3); //xPad, yPad
		
		//this is the left most button layout
		JPanel drawResetQuit = new JPanel();
		GridLayout drawResetQuitlayout = new GridLayout(0,1);
	
		drawResetQuit.setLayout(drawResetQuitlayout);
		
		draw = new JButton("Draw");
		draw.setBackground(Color.BLACK);
		draw.setForeground(Color.BLACK);
		draw.addActionListener(this);
		drawResetQuit.add(draw);
		
		JButton reset = new JButton("Reset");
		reset.setBackground(Color.BLACK);
		reset.setForeground(Color.RED);
		reset.addActionListener(this);
		drawResetQuit.add(reset);
		
		JButton quit = new JButton("Quit");
		quit.setBackground(Color.BLACK);
		quit.setForeground(Color.WHITE);
		quit.addActionListener(this);
		drawResetQuit.add(quit);
		
		//adding the grid and buttons to one of the panels
		bigButtonsandLottoNumber.add(drawResetQuit);
		bigButtonsandLottoNumber.add(lottoGrid);
		
		
		//the bottom labels
		JPanel bottomLabels = new JPanel();
		bottomLabels.setLayout(new BoxLayout(bottomLabels, 0));
		
		JLabel pickingNum = new JLabel("Picking Numbers...", JLabel.LEFT);
		bottomLabels.add(pickingNum);
		bottomLabels.add(Box.createRigidArea(new Dimension(300,0)));
		dollas = new JLabel("$" + money,JLabel.RIGHT);
		bottomLabels.add(dollas);
		
		
		//biggest container that has the buttons, grid and bottom labels in it
		container.add(bigButtonsandLottoNumber);
		
		container.add(bottomLabels);
		
		
		lottoWindow = new JFrame("CompSci Lotto");
		lottoWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		lottoWindow.add(container);
		bigButtonsandLottoNumber.setOpaque(true);
		
		
		lottoWindow.pack();
		lottoWindow.setVisible(true);
	}

	public String pickWinner(boolean cheat) {
		
		
		//create winning numbers array
		winningNumbers = new ArrayList<Integer>(6);
		
		while (winningNumbers.size() < 6) {
			winningNumbers.add((int) (Math.random()*48));
		}
		

		if(!cheat) {if (storedNumbers == winningNumbers) {
			
			 return "YOUR A WINNER!";
			
			
		}
		
		else return "You loSE!" + "\n" + storedNumbers.toString()+ "   "+ winningNumbers.toString();
		
		
		}
		
		else  return "YOUR A WINNER!";
	}
	public void actionPerformed(ActionEvent event) {
		
		JButton button = ((JButton) event.getSource());
		
		
		if (button.getText().equals("Draw")) {
			
			winningNumbers = new ArrayList<Integer>(6);
			
			while (winningNumbers.size() < 6) {
				winningNumbers.add((int) (Math.random()*48));
			}
			
		if (button.getForeground() == Color.GREEN) {
		
			if (money > 0) {
			dollas.setText("$" + --money);
			
			winningNumbers = new ArrayList<Integer>(6);
			
			while (winningNumbers.size() < 6) {
				winningNumbers.add((int) (Math.random()*48));
			}
			
			
			System.out.println(pickWinner(false));
		}
		
		else {
		System.out.println("You have no money, you can not draw, GOODBYE");
		lottoWindow.dispose();
		}
	}
		else ;
		}
		else if (button.getText().equals("Reset")) {
			
				Component[] lottoButtons = lottoGrid.getComponents();
				
				for (int i = 0; i < lottoButtons.length; i++) {
					if (lottoButtons[i].getBackground() == Color.BLUE)
					lottoButtons[i].setBackground(new JButton().getBackground());
				
			}
		
			storedNumbers.clear();
			System.out.println("RESET!");
		}
		
		else if (button.getText().equals("Quit")) {
			lottoWindow.dispose();
		}
		
		else {
		
		if (storedNumbers.size() < 6 && button.getBackground() == new JButton().getBackground()) {
		storedNumbers.add( Integer.parseInt(button.getText()));
		button.setBackground(Color.BLUE);
		
		if (storedNumbers.size() == 6) draw.setForeground(Color.GREEN);
		}
		
		else if (button.getBackground() == Color.BLUE) {
			if (draw.getForeground() == Color.GREEN) draw.setForeground(Color.BLACK);
			
			storedNumbers.remove(storedNumbers.indexOf(Integer.parseInt(button.getText())));
			button.setBackground(new JButton().getBackground());
			}
		
		
		
		
		else ;
			
		
		
		System.out.println("Clicked " + button.getText() );
		
		System.out.println(storedNumbers.toString());
		
		
		}
	}
}
