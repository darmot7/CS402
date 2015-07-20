package java402lab2DialogViewer;

import java.awt.Component;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class AppMainDialogViewer {

	public static void main(String[] args) {
		System.out.println("Please enter the command Line Argument you'd like to view. Your options are: the letters 'f', 'c', and 'm' ");
		Scanner in = new Scanner(System.in);
		String input = in.next();
		
		if (input.equals("f")) {
			JFileChooser chooser = new JFileChooser();
			Component parent = null;
			int retrunVal = chooser.showOpenDialog(parent);
			if (retrunVal == JFileChooser.APPROVE_OPTION) {
				System.out.println("You chose to open this file: " + chooser.getSelectedFile().getName());
			}
		}
				
		else if (input.equals("c")){
			
			String[] options = {"Yes",
                    "No",
                    "Cancel"};
			Component frame = null;
			int n = JOptionPane.showOptionDialog(frame,"Are you sure?  ","", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[2]);
			System.out.print("You chose: ");
			if (n == 0) System.out.println(" Yes");
			else if (n == 1) System.out.println(" No");
			else System.out.println(" Cancel");
		}
		
		else if (input.equals("m")) {
			Component frame = null;
			JOptionPane.showMessageDialog(frame, "Jeremy Herzberg", "My Name is", JOptionPane.PLAIN_MESSAGE);
		}
		
		else System.out.println("Your input doesn't match any of the accepted inputs.");
		

	}

}
