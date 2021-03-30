package movieReviewSystem;
import java.time.LocalDate;
import java.util.*;

public class Movie implements Comparable<Movie>{

	String name ; 

	HashMap<User, Integer> viewers ; 
	HashMap<User, Integer> critics ; 
	HashMap<User, Integer> experts ; 
	HashMap<User, Integer> admins ; 
	int yearOfRelease;
	Set<String> genres;
	


	Movie(String name, Set<String> genres, int year){
		this.name = name ; 
		this.genres = genres ; 
		this.yearOfRelease = year ;
		viewers = new HashMap<>();
		critics = new HashMap<>();
		experts = new HashMap<>();
		admins = new HashMap<>();
	}

	public boolean isMovieReleased() {
		LocalDate currentdate = LocalDate.now();
//		System.out.println(currentdate.getYear() + ":" +  this.yearOfRelease);
//		System.out.println(currentdate.getYear() > this.yearOfRelease);
		return currentdate.getYear() > this.yearOfRelease ; 
	}

	public void addCriticReview(User u, int rating) {		
		critics.put(u, rating);
	}

	public void addViewerReview(User u, int rating) {
		viewers.put(u, rating);
	}

	public void addExpertReview(User u, int rating) {
		experts.put(u, rating);
	}

	public void addAdminReview(User u, int rating) {
		admins.put(u, rating);

	}
	
	
	@Override
	public int compareTo(Movie o) {
		int myMovieCriticScore = 0 ;

		for(User u : this.critics.keySet()) {
			myMovieCriticScore += this.critics.get(u) ; 
		}

		int otherMovieCriticScore = 0 ;

		for(User u : o.critics.keySet()) {
			otherMovieCriticScore += o.critics.get(u) ; 
		}
		
		return otherMovieCriticScore - myMovieCriticScore ; 
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.name + " released in Year " +  this.yearOfRelease + " for Genres " + this.genres;
	}
	
	public int returnTotalScore() {
		int sum = 0 ; 
		for(User u : viewers.keySet()) {
			sum += viewers.get(u);
		}
		
		for(User u : critics.keySet()) {
			sum += critics.get(u);
		}
		
		for(User u : experts.keySet()) {
			sum += experts.get(u);
		}
		
		for(User u : admins.keySet()) {
			sum += admins.get(u);
		}
		
		return sum ; 
	}
	
	public int totalNumberOfReviews() {
		return critics.size() + viewers.size() + admins.size() + experts.size();
	}








}
