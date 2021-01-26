package com.sezayir.demo.input;

public class InputMenu {

	public static void displayMainMenu() {
		System.out.println("---BOOKING MAIN MENU----");
		System.out.println("[1]  Active Tour List(Info)");
		System.out.println("[2]  Create New Bookings(Hiker)");
		System.out.println("[3]  Cancel Bookings(Hiker)");
		System.out.println("[4]  List My Bookings(Hiker)");
		System.out.println("[5]  List Daily Bookings(Admin)");
		System.out.println("[E]  Exit");
		System.out.println("Select option: ");
	}

	
	public static void displayCreationMenu() {
		System.out.println("[1]  Create booking for yourself?");
		System.out.println("[2]  Create booking for friends?");
		System.out.println("[M]  Main Menu");
	}
}