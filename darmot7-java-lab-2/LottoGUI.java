package java402lab2LottoGUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import java402lab2AddressInformation.SpringUtilities;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

public class LottoGUI {

	public LottoGUI() {
		
		
		JPanel container = new JPanel();
		container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
		
		
		//has buttons and numbers in it
		JPanel bigButtonsandLottoNumber = new JPanel();
		bigButtonsandLottoNumber.setLayout(new BoxLayout(bigButtonsandLottoNumber, BoxLayout.X_AXIS));
		
		
		
		//this is the lotto grid set up
		JPanel lottoGrid = new JPanel(new SpringLayout());
		int col = 7;
		int row = 7;
		int counter = 0;
		String box;
		
		for (int r = 0; r < row; r++ ) {
			for (int c = 0; c < col; c++) {
				box = Integer.toString(counter++);
				JButton lottoButton = new JButton(box);
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
		
		JButton draw = new JButton("Draw");
		draw.setBackground(Color.BLACK);
		draw.setForeground(Color.GREEN);
		drawResetQuit.add(draw);
		JButton reset = new JButton("Reset");
		reset.setBackground(Color.BLACK);
		reset.setForeground(Color.RED);
		drawResetQuit.add(reset);
		JButton quit = new JButton("Quit");
		quit.setBackground(Color.BLACK);
		quit.setForeground(Color.WHITE);
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
		JLabel dollas = new JLabel("$10",JLabel.RIGHT);
		bottomLabels.add(dollas);
		
		
		//biggest container that has the buttons, grid and bottom labels in it
		container.add(bigButtonsandLottoNumber);
		
		container.add(bottomLabels);
		
		
		JFrame lottoWindow = new JFrame("CompSci Lotto");
		lottoWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		lottoWindow.add(container);
		bigButtonsandLottoNumber.setOpaque(true);
		
		
		lottoWindow.pack();
		lottoWindow.setVisible(true);
	}
}
