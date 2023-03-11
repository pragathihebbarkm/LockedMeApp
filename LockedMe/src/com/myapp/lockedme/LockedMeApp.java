package com.myapp.lockedme;

public class LockedMeApp {
	
	public static void main(String[] args) {
		// To create "docs" folder if not present in current folder structure
					FileHandleOps.createDocsFolderIfNotPresent("docs");
					
					Menu.displayWelcomeScreen("LockedMeApp", "Pragathi Hebbar K M");
					
					DisplayOptions.handleWelcomeScreenInput();
	}
}
