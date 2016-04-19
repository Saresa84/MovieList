package appPackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import moviePackage.Movie;
import moviePackage.Validation;
import moviePackage.MovieIO;

public class MovieApp {
	// variables
	static String userInput;

	public static void main(String[] args) {
		// open scanner
		Scanner input = new Scanner(System.in);

		// create Validation object
		Validation v1 = new Validation();

		// create MovieIO object
		MovieIO movieGC = new MovieIO();

		// arrays for movies and categories
		String[] movies = { "The Expendables", "Die Hard", "Finding Nemo", "Nightmare on Elm Street", "Star Wars",
				"Serinty", "Tranformers", "Deadpool", "Talladega Nights", "Howl's Moving Castle" };
		String[] category = { "action", "action", "animated", "horror", "scifi", "scifi", "action", "scifi", "Comedy",
				"animated" };

		// Movie object Array List
		ArrayList<Movie> movieA = new ArrayList<>();

		// title
		System.out.println("Welcome to the Movie List Application!" + "\n");

		// directions
		System.out.println("There are 10 movies in this list.");
		
		//trying to create object in movieA ArrayListfrom MovieIO
		 for (int index = 9; index < 110; index++ ){
		 movieA.add(MovieIO.getMovie(index));
		 }
		// check for keepGoing
		String keepGoing = "y";
		while (keepGoing.equalsIgnoreCase("y")) {
			// method that moves movies and categories from array into objects
			// ListArray movieA
			moveMovCatListArray_movieA(movies, category, movieA);
			 
			
			// prompt for type of search
			System.out.println("Would you like to search by entering the category our selecting from menu?");
			System.out.print("Enter 1.select from menu OR 2.enter category type: ");
			// began switch for search by number menu or typing category
			// variable for switch
			int choice =v1.validForSwitch();
			
			// switch
			switch (choice) {
			
			case 1:
				// search buy menu with numbers
				int userInt = 0;
				System.out.println("Which category would you like to search by?");
				System.out.println("1. action" + "\n" + "2. comedy" + "\n" + "3. animated" + "\n" + "4. scifi" + "\n"
						+ "5. horror" + "\n");
				System.out.print("Enter a number: ");
				userInt = v1.validForMenu();
				//input.nextLine();
				
				// method to put string in userInput based on numbers
				getCategoryFromNumber(userInt);

				// prompt user for alphabetical order
				System.out.println("Would you like the list in alphabetical order (y/n)?: ");
				String alphOrder = v1.checkYesOrNo();

				// empty line
				System.out.println();

				// print ArrayList matching userInput from movieA
				printListChoice(userInput, movieA, alphOrder);
				System.out.print("Would you like to continue (y/n)?: ");
				keepGoing = v1.checkYesOrNo();
				break;
				
				
			case 2:
				// should be in while loop for keep going
				System.out.print("What category are you interested in?: ");
				userInput = v1.checkUserInput();

				// empty line between user prompt and List of movies
				System.out.println();

				// prompt user for alphabetical order
				System.out.print("Would you like the list in alphabetical order (y/n)?: ");
				alphOrder = v1.checkYesOrNo();

				// print ArrayList matching userInput from movieA
				printListChoice(userInput, movieA, alphOrder);

				// empty line between user prompt and List of movies
				System.out.println();
				
				//empty line
				System.out.println();

				// prompt user for continue
				System.out.print("Would you like to continue (y/n)?: ");
				keepGoing = v1.checkYesOrNo();
				break;
			}// end keepGoing while
			
		} // end switch

		System.out.println("Goodbye!");
		
		// close input
		input.close();
	}

	public static void getCategoryFromNumber(int userInt) {

		if (userInt == 1) {
			userInput = "action";
		} else if (userInt == 2) {
			userInput = "comedy";
		} else if (userInt == 3) {
			userInput = "animated";
		} else if (userInt == 4) {
			userInput = "scifi";
		} else if (userInt == 5) {
			userInput = "horror";
		} // end if else
	}

	public static void printListChoice(String userInput, ArrayList<Movie> movieA, String alphOrder) {
		if (alphOrder.equalsIgnoreCase("y")) {
			printMovieListSorted(userInput, movieA);
		} else {
			printMovieListMatchCat(userInput, movieA);
		} // end if else
	}

	public static void printMovieListMatchCat(String userInput, ArrayList<Movie> movieA) {

		for (Movie x : movieA) {
			if (userInput.equalsIgnoreCase(x.getCategory())) {
				x.printMovie();

			}
		}
	}

	public static void printMovieListSorted(String userInput, ArrayList<Movie> movieA) {
		ArrayList<String> tempList = new ArrayList<>();
		//for loop to put movies in array to sort
		for (Movie x : movieA) {
			if (userInput.equalsIgnoreCase(x.getCategory())) {
				tempList.add(x.getMovie());
			} // end if to get movie titles
		} // end for to get titles in temp array
		//sort ArrayList
		Collections.sort(tempList);
		for (String y : tempList) {
			System.out.println(y);
		}
		
	}

	public static void moveMovCatListArray_movieA(String[] movies, String[] category, ArrayList<Movie> movieA) {
		// add movies and categories to Array List movieA
		for (int i = 0; i < movies.length; i++) {
			movieA.add(new Movie());

			movieA.get(i).setMovie(movies[i]);
			movieA.get(i).setCategory(category[i]);

		} // end for loop to add to ArrayListM
	}
}
