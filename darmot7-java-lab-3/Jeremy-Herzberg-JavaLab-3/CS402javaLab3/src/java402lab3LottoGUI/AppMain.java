package java402lab3LottoGUI;


public class AppMain {

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
