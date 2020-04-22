package main;

import java.util.Scanner;

import index.HashIndex;

public class Main {

	public static void main(String[] args) {
	
		Scanner scanner = new Scanner(System.in);
		
		DatabaseManager dbms = new DatabaseManager();
		
		while(true) {
			
			System.out.println("Enter a command: ");
			String cmd = scanner.nextLine();
			
			
			if(cmd.equalsIgnoreCase("CREATE INDEX ON RANDOMV")) {
				dbms.createIndexes();
				System.out.println("The hash-based and array-based indexes are built");
			} else if(cmd.startsWith("SELECT * FROM Project2Dataset WHERE RandomV = ")) {
				
			}
			
		}
		
		
	}

}
