package movieReviewSystem;
import java.util.*;

public class MovieReviewService {
	
	HashMap<String, User> users ; 
	HashMap<String, Movie> movies;
	HashMap<String, ArrayList<Movie>> genreVsMovies;
	HashMap<Integer, ArrayList<Movie>> yearvsMovies ; 
	
	public MovieReviewService() {
		users = new HashMap<>();
		movies = new HashMap<>();
		genreVsMovies = new HashMap<>();
		yearvsMovies = new HashMap<>() ; 
		
		genreVsMovies.put("action", new ArrayList<>());
		genreVsMovies.put("comedy", new ArrayList<>());
		genreVsMovies.put("romance", new ArrayList<>());
		genreVsMovies.put("drama", new ArrayList<>());
		
		
	}
	
	public void addUser(String user_name) throws Exception {
		if(users.containsKey(user_name))
			throw new Exception("User already exists");
		
		User nu = new User(user_name);
		users.put(user_name, nu);
	}
	
	public void addMovie(String movie_name, Set<String> genres, int year) throws Exception {
		
		if(movies.containsKey(movie_name))
			throw new Exception("Movie already exists");
		
		Movie nm = new Movie(movie_name, genres, year);
		movies.put(movie_name, nm);
		
		for(String s : genres) {
			genreVsMovies.get(s).add(nm) ; 
		}
		
		if(!yearvsMovies.containsKey(year)) {
			yearvsMovies.put(year, new ArrayList<>());
		}
		
		yearvsMovies.get(year).add(nm) ; 
		
		
	}
	
	public void addReview(String movie_name, int rating, String user_name) throws Exception {
		
		User u = users.get(user_name);
		System.out.println(u);
		Movie m = movies.get(movie_name);
		
		if(u.isMovieReviewed(m))
			throw new Exception("Multiple reviews for a movie not allowed");
		
		if(!m.isMovieReleased())
			throw new Exception("Movie is not yet released");
		
		UserBehaviour ub = u.getUserBehaviour() ; 
		
		if(ub == UserBehaviour.CRITIC) {
			rating *= 2 ; 
			m.addCriticReview(u, rating);
		}else if(ub == UserBehaviour.EXPERT) {
			rating *= 3 ; 	
			m.addExpertReview(u, rating);
		}else if(ub == UserBehaviour.ADMIN) {
			rating *= 4 ;
			m.addAdminReview(u, rating);
		}else {
			m.addViewerReview(u, rating);
		}
		
		u.addReview(m, rating);
		
		
	
	}
	
	public void listTopMoviesByCriticReviewInParticularGenre(String genre, int n) {
		
		ArrayList<Movie> genreMovies = genreVsMovies.get(genre);
		
		Collections.sort(genreMovies);
		int i = 0 ;
		
		while(n > 0 && i > genreMovies.size()) {
			System.out.println(genreMovies.get(i));
			i++ ; 
			n-- ; 
		}
		
	}

	public void averageReviewScoreInAParticularYear(int year) {
		
		if(!yearvsMovies.containsKey(year)) {
			System.out.println("Average Review Score in year " + year + " is " + 0);
			return ; 
		}
		
		ArrayList<Movie> movies = yearvsMovies.get(year);
		System.out.println(movies);
		
		double totalScore = 0 ; 
		for(Movie m : movies) {
			totalScore += m.returnTotalScore() ; 
		}
		
	    double average = totalScore/movies.size() ;
	    System.out.println("Average Review Score in year " + year + " is " + average);
			
	}
	
	public void averagereviewscoreforaparticularmovie(String movie) {
		Movie m = movies.get(movie) ;
		
		double totalSum = m.returnTotalScore() ; 
		double totalReviews = m.totalNumberOfReviews() ; 
		double average = totalSum/totalReviews ; 
		
		System.out.println("Average score for a movie " + movie + " is " + average);
	}
}
