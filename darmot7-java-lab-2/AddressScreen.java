package java402lab2AddressInformation;



import java.awt.Container;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;



public class AddressScreen {

	
	public AddressScreen() {
		
		String[] labels = {"Name                                             ", "Address ", "City ", "State ", "Zip "};
        int numPairs = labels.length;
 
       JPanel container = new JPanel();
       container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
       
        
        
        //Create and populate the panel.
       JPanel topOfForm = new JPanel(new SpringLayout());
       for (int i = 0; i < numPairs; i++) {
            JLabel l = new JLabel(labels[i], JLabel.LEADING);
            
            topOfForm.add(l);
            JTextField textField = new JTextField(20);
            l.setLabelFor(textField);
            
            
            topOfForm.add(textField);
        }
 
        //Lay out the panel.
        SpringUtilities.makeCompactGrid(topOfForm,
                                        numPairs, 2, //rows, cols
                                        6, 6,        //initX, initY
                                        6, 6);       //xPad, yPad
		
       
       
       JFrame addresscreenWindow = new JFrame("Address Information"); 
       JButton addButton = new JButton("Add");
       JButton addButton2 = new JButton("Modify");
       JButton addButton3 = new JButton("Delete");
       
       
       JPanel buttons = new JPanel();
       
       buttons.add(addButton);
       buttons.add(addButton2);
       buttons.add(addButton3);
       addButton.setBounds(200, 200, 200, 200);
        
		
 
       topOfForm.setOpaque(true);
       buttons.setOpaque(true);
       container.add(topOfForm);
       container.add(buttons);
       
       addresscreenWindow.setContentPane(container);
       
		
		
		
       addresscreenWindow.pack();
       addresscreenWindow.setVisible(true);
	}
	
	
}
