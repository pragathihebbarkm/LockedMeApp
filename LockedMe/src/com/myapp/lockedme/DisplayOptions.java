package com.myapp.lockedme;

import java.util.List;
import java.util.Scanner;

public class DisplayOptions {

	public static void handleWelcomeScreenInput() {
		boolean running = true;
		Scanner sc = new Scanner(System.in);
		do {
			try {
				Menu.displayMenuOptions();
				int input = sc.nextInt();

				switch (input) {
				case 1:
					FileHandleOps.displayAllFiles("docs");
					break;
				case 2:
					DisplayOptions.handleFileMenuOptions();
					break;
				case 3:
					System.out.println("Program exited successfully.");
					running = false;
					sc.close();
					System.exit(0);
					break;
				default:
					System.out.println("Please select a valid option from above.");
				}
			} catch (Exception e) {
				System.out.println(e.getClass().getName());
				handleWelcomeScreenInput();
			} 
		} while (running == true);
	}
	
	public static void handleFileMenuOptions() {
		boolean running = true;
		Scanner sc = new Scanner(System.in);
		do {
			try {
				Menu.displayFileHandleOptions();
				FileHandleOps.createDocsFolderIfNotPresent("docs");
				
				int input = sc.nextInt();
				switch (input) {
				case 1:
					// File Add
					System.out.println("Enter the name of the file to be added to the \"docs\" folder");
					String fileToAdd = sc.next();
					
					FileHandleOps.addNewFile(fileToAdd, sc);
					
					break;
				case 2:
					// File/Folder delete
					System.out.println("Enter the name of the file to be deleted from \"docs\" folder");
					String fileToDelete = sc.next();
					
					FileHandleOps.createDocsFolderIfNotPresent("docs");
					List<String> filesToDelete = FileHandleOps.displayFileLocations(fileToDelete, "docs");
					
					String deletionPrompt = "\nSelect index of which file to delete?"
							+ "\n(Enter 0 if you want to delete all elements)";
					System.out.println(deletionPrompt);
				
					int idx = sc.nextInt();
					
					if (idx != 0) {
						FileHandleOps.deleteFileRecursively(filesToDelete.get(idx - 1));
					} else {
						
						// If idx == 0, delete all files displayed for the name
						for (String path : filesToDelete) {
							FileHandleOps.deleteFileRecursively(path);
						}
					}
					

					break;
				case 3:
					// File/Folder Search
					System.out.println("Enter the name of the file to be searched from \"docs\" folder");
					String fileName = sc.next();
					
					FileHandleOps.createDocsFolderIfNotPresent("docs");
					FileHandleOps.displayFileLocations(fileName, "docs");

					
					break;
				case 4:
					// Go to Previous menu
					return;
				case 5:
					// Exit
					System.out.println("Program exited successfully.");
					running = false;
					sc.close();
					System.exit(0);
				default:
					System.out.println("Please select a valid option from above.");
				}
			} catch (Exception e) {
				System.out.println(e.getClass().getName());
				handleFileMenuOptions();
			}
		} while (running == true);
	}
}
