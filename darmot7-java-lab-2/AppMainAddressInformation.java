package java402lab2AddressInformation;




public class AppMainAddressInformation {

	private static void createAndShowGUI() {
		AddressScreen sampleWindow = new AddressScreen();
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