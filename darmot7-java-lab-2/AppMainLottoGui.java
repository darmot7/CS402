package java402lab2LottoGUI;

import java402lab2AddressInformation.AddressScreen;

public class AppMainLottoGui {

	private static void createAndShowGUI() {
		LottoGUI sampleWindow = new LottoGUI();
	}
	
	
	public static void main(String[] args) {
		//AddressScreen sampleWindow = new AddressScreen();
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
		public void run() {
			createAndShowGUI();
		}

	});

	}

}
