package moviePackage;

import java.util.Scanner;

public class Validation {
	String x;
	static Scanner input = new Scanner(System.in);
	//while loop for userInput for categories not valid prompt user
	public String checkUserInput (){
		x = input.nextLine();
		while ( validateUserInput()== false){
			System.out.println("You must enter a categorgy for movies available.");
			System.out.println("Categories are: action , horror, comedy , scifi and animated." + "\n");
			System.out.print("Please enter movie category: ");
			x = input.nextLine();
		}
		return x;
	}
	//checks userInput return false if not available category----- work with above
	public boolean validateUserInput (){
		if (x.equalsIgnoreCase("action")){
			return true;
		}else if (x.equalsIgnoreCase("comedy")){
			return true;
		}else if (x.equalsIgnoreCase("animated")){
			return true;
		}else if (x.equalsIgnoreCase("scifi")){
			return true;
		}else  if (x.equalsIgnoreCase("horror")){
			return true;
		}else{
			return false;
		}//end if else
	}
	//check that yes/no question validated
	public String checkYesOrNo (){
		String x= input.nextLine();
		while (!x.equalsIgnoreCase("y") && !x.equalsIgnoreCase("n")){
			System.out.println("You must enter \"y\" for yes or \"n\" for no.");
			System.out.println("Would you like the list in alphabetical order (y/n)?: ");
			x=input.nextLine();
		}//end while
		return x;
	}
	public int validForSwitch(){
		int x= input.nextInt();
		input.nextLine();
		while (x!=1 && x!=2){
			System.out.println("You must enter 1 or 2.");
			System.out.println("Would you like to search by entering the category our selecting from menu?");
			System.out.print("Enter 1.select from menu OR 2.enter category type: ");
			x= input.nextInt();
			//input.nextLine();
		}return x;
	}
	public int validForMenu(){
		int x= input.nextInt();
		input.nextLine();
		while (x<0 && x>5){
			System.out.println("You must enter a number 1 - 5.");
			System.out.println("Which category would you like to search by?");
			System.out.println("1. action" + "\n" + "2. comedy" + "\n" + "3.animated" + "\n" + "4. scifi" + "\n"+ "5. horror" + "\n");
			System.out.print("Enter a number: ");
			x= input.nextInt();
			input.nextLine();
		}
		//input.nextLine();
		return x;
	}
}
