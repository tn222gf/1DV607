package ws2.view;

import java.io.IOException;
import java.util.Scanner;

public class Console {
	
	// Base-commands
	private String[] commands = {"exit", "create", "remove", "change", "list", "view"};
	private Scanner scan = new Scanner(System.in);
	private String currentCommand = "";
	
	// Returns string of input
	protected String getInput() {
		
		StringBuilder sb = new StringBuilder();
		
		try {
			
			char c = (char) System.in.read();
			
			while (c != '\n' || c != '\n') {
				
				sb.append(c);
				
				c = (char) System.in.read();
				
			}
			
			return sb.toString().trim();
			
		} catch (IOException e) {
			
			System.out.println(e);
			return sb.toString().trim();
		}
		
	}
	
	// return string of existing command
	public String getCommand() {
		
		String input = getInput();
		
		while (!isCommand(input)) {

			printWrongCommando();
			input = getInput();
		}
		
		return currentCommand;
	}
	
	// boolean of current input is a command
	private boolean isCommand(String cmd) {
		
		for (int i = 0; i < commands.length; i++) {
			if (cmd.toLowerCase().trim().equals(commands[i])) {
				currentCommand = cmd.toLowerCase().trim();
				return true;
			}
		}
		
		return false;
	}
	
	public void printCommando() {
		System.out.print("Command: ");
	}
	
	public void printNoMembers() {
		System.out.print("No members found, please create new members.");
	}
	
	public void presentInstructions() {
		System.out.println("Welcome to your member and boat manager!");
		System.out.println("Use the commands Create, List, Remove, Change, View, Exit, to use the program.");
		System.out.println("Your database of members are now loaded.");
	}
	
	public void printWrongCommando() {
		System.out.println("No command to match your input, try again.");
	}
	
	public boolean wantToExit() {
		return currentCommand.equals("exit");
	}
	
	public void printExitProgram() {
		System.out.println("Closing program");
	}
	
	// Let's the user enter freely a new member no control on input, returning array with name and personal number
	public String[] getNewMember() {
		
		String[] answers = new String[2];
		
		System.out.println("Creating member!");
		
		System.out.print("Full Name: ");
		answers[0] = getInput();
		
		System.out.print("Personal Number: ");
		answers[1] = getInput();
		
		return answers;
	}
	
	// Asking for id of member which is unique, return the id
	public int getIntToGetMember() {
		
		int id = 0;
		boolean validNumber = false;
		
		System.out.println("Enter ID of the member you wish to " + currentCommand.toUpperCase());
		
		while (!validNumber) {
			
			if (scan.hasNextInt()) {
				id = Integer.parseInt(scan.next());
				validNumber = true;
			} else {
				System.out.println("Not a number");
				scan.nextLine();
			}
		}
		
		return id;
	}
	
	public void printMemberRemoved() {
		System.out.println("A Member has been removed!");
	}
	
	public void printNoMemberWithIdFound() {
		System.out.println("No member with that ID found, please try again.");
	}
	
	// Return a string of compact or verbose
	public String getListCommando() {
		
		System.out.println("[Compact] or [Verbose] list?");
		String input = getInput().toLowerCase().trim();
		boolean correctCommando = false;
				
		while (!correctCommando) {
			
			if (input.equals("compact") || input.equals("verbose")) {
				correctCommando = true;
			} else {
				System.out.print("Wrong command choose compact or verbose");
				input = getInput().toLowerCase().trim();			
			}
		}
		
		return input;
	}
	
	// Return a string with command to change member or further on boat
	public String getMemberCommand() {
		
		System.out.println("Change [name] or personal number [pnumber] or go to boat options [boat]?");
		String input = getInput().toLowerCase().trim();
		boolean correctCommando = false;
				
		while (!correctCommando) {
			
			if (input.equals("name") || input.equals("pnumber") || input.equals("boat")) {
				correctCommando = true;
			} else {
				System.out.print("Wrong command choose name, pnumber or boat to change this member");
				input = getInput().toLowerCase().trim();	
			}
		}
		
		return input;
	}
	
	// REturn a string with one command to create/remove/change boat.
	public String getBoatCommand() {
		System.out.println("[Create] a new Boat, [change] or [remove] an existing boat?");
		String input = getInput().toLowerCase().trim();
		boolean correctCommando = false;
				
		while (!correctCommando) {
			
			if (input.equals("create") || input.equals("change") || input.equals("remove")) {
				correctCommando = true;
			} else {
				System.out.print("Wrong command choose create, change or remove for boat");
				input = getInput().toLowerCase().trim();	
			}
		}
		
		return input;
	}
	
	// Function to get input for changes and returning a string.
	public String getChangeInput(String whatToChange) {
		System.out.print("Enter new " + whatToChange);
		return getInput();
	}
	
	// In order to know which boat to remove/change boat let user choose index of boat -1
	public int getIntToGetBoat(String cmd) {
		
		boolean validNumber = false;

		System.out.println("Enter number of the boat you wish to " + cmd.toUpperCase());
		String input = getInput().trim();
		
		while (!validNumber) {
			
			if (input.matches("^[+]?\\d+$")) {
				
				if (Integer.parseInt(input) != 0) {
					validNumber = true;
				} else {
					System.out.println("Not a correct number, try again.");
					input = getInput().trim();	
				}
			} else {
				System.out.println("Not a correct number, try again.");
				input = getInput().trim();
			}
		}
		
		// -1 because to mathc with arraylist indexes
		return Integer.parseInt(input) - 1;
	}
	
	// Returning an array of strings, with type and length for a new or changed boat
	public String[] getNewBoat(String cmd) {
		String[] answers = new String[2];

		System.out.println(cmd.toUpperCase() + " boat!");

		System.out.print("Boat type, choose [sailboat], [motorsailer], [kayak](same as Canoe), [other]");
		// Controll answer
		
		String input = getInput().toLowerCase().trim();
		boolean correctCommando = false;
				
		while (!correctCommando) {
			
			if (input.equals("sailboat") || input.equals("motorsailer") || input.equals("kayak") || input.equals("other")) {
				correctCommando = true;
			} else {
				System.out.print("Wrong input choose between sailboat, motorsailer, kayak (same as Canoe) or other for boat type");
				input = getInput().toLowerCase().trim();	
			}
		}
		
		answers[0] = input;
		correctCommando = false;
		
		System.out.print("Enter the boats length in meter: ");
		input = getInput().toLowerCase().trim();
		
		// Controll answer
		while (!correctCommando) {

			if (input.matches("^[+]?\\d+$")) {
				correctCommando = true;
			} else {
				System.out.println("Not a correct length");
				input = getInput().toLowerCase().trim();	
			}
		}

		answers[1] = input;
	
		return answers;
	}
	
	public void printBoatNotFound() {
		System.out.println("Can't find boat");
	}
	
	public void printList(String list) {
		System.out.println(list);
	}
	
	
}