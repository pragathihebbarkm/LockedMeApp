package com.myapp.lockedme;

public class Menu {
	public static void displayWelcomeScreen(String appName, String developerName) {
		String companyDetails = String.format("---------------------------------------------------------------\n"
				+ "** Welcome to %s.com. \n" + "** This application was developed by %s.\n"
				+ "---------------------------------------------------------------\n", appName, developerName);
		String appFunction = "You can use this application to : \n"
				+ " Retrieve all file names in the \"docs\" folder\n"
				+ "Search, add, or delete files in \"docs\" folder.\n"
				+ "\n**Please ensure you give the correct filename for searching or deleting files.**\n";
		System.out.println(companyDetails);

		System.out.println(appFunction);
	}

	public static void displayMenuOptions() {
		String menu = "\n\n****** Select any option number from below and press Enter ******\n\n"
				+ "1) Retrieve all files inside \"docs\" folder\n" 
				+ "2) Display menu for performing File operations\n"
				+ "3) Close the Application\n";
		System.out.println(menu);

	}

	public static void displayFileHandleOptions() {
		String fileMenu = "\n\n****** Select any option number from below and press Enter ******\n\n"
				+ "1) Add a file to \"docs\" folder\n" 
				+ "2) Delete a file from \"docs\" folder\n"
				+ "3) Search for a file from \"docs\" folder\n" 
				+ "4) Show Previous Menu\n" + "5) Exit program\n";

		System.out.println(fileMenu);
	}
}
