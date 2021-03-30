package movieReviewSystem;
import java.util.*;

public class User {
	
	String name;
	HashMap<Movie, Integer> reviews;
	UserBehaviour u ; 
	
	User(String name){
		this.name = name ; 
		reviews = new HashMap<>();
		u = UserBehaviour.VIEWER ; 
	}
	
	public boolean isMovieReviewed(Movie m) {
		return reviews.containsKey(m);
	}
	
	public UserBehaviour getUserBehaviour() {
		return u;
	}
	
	
	
	public void addReview(Movie m, int rating) {
		
		reviews.put(m, rating);
		if(reviews.size() < 3)
			u = UserBehaviour.VIEWER;
		else if(reviews.size() < 6)
			u = UserBehaviour.CRITIC;
		else if(reviews.size() < 9)
			u = UserBehaviour.EXPERT;
		else
			u = UserBehaviour.ADMIN ; 
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.name;
	}
	
	
	
	

}
