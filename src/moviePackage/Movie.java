package moviePackage;

public class Movie {
	//variables
	private String Movie;
	private String Category;
	
	//constructors
	public Movie(String a, String b){
		Movie =a;
		Category=b;
	}
	public Movie(){
		Movie ="";
		Category="";
	}

	public String getMovie() {
		return Movie;
	}
	public void setMovie(String movie) {
		Movie = movie;
	}
	public String getCategory() {
		return Category;
	}
	public void setCategory(String category) {
		Category = category;
	}
	//methods
	public void printMovie(){
		System.out.println(getMovie());
	}
	
	public void printMovieCat(){
		System.out.println(getCategory());
	}
	//getters and setters
	
	
	
	
	
	
}
