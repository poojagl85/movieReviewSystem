package movieReviewSystem;
import java.util.*;

public class Client {
	
	public static void main(String[] args) throws Exception {
		MovieReviewService m = new MovieReviewService() ;
		
		// adding movies
		Set<String> m1 = new HashSet<>();
		m1.add("action");
		m1.add("comedy");
		m.addMovie("Don", m1, 2006);
		
		Set<String> m2 = new HashSet<>();
		m2.add("drama");		
		m.addMovie("Tiger", m2, 2008);
		
		Set<String> m3 = new HashSet<>();
		m3.add("comedy");
		m.addMovie("Padmavat", m1, 2006);
		
		
		Set<String> m4 = new HashSet<>();
		m4.add("drama");
		m.addMovie("Lunchbox", m1, 2021);
		
		
		Set<String> m5 = new HashSet<>();
		m5.add("drama");
		m.addMovie("Guru", m1, 2006);
		
		Set<String> m6 = new HashSet<>();
		m6.add("romance");
		m.addMovie("Metro", m1, 2006);
		
		
		//adding users
		
		m.addUser("SRK");
		m.addUser("Salman");
		m.addUser("Deepika");
		
		
		// adding reviews
		
		m.addReview("Don", 2 , "SRK");
		m.addReview("Padmavat", 8 , "SRK");
		m.addReview("Don", 5 , "Salman");
		m.addReview("Don", 9 , "Deepika");
		m.addReview("Guru", 6 , "Deepika");
//		m.addReview("Metro", 10 , "SRK");
//		m.addReview("Lunchbox", 5 , "Deepika");
		m.addReview("Tiger", 5 , "SRK");
		m.addReview("Metro", 7 , "SRK");
		
		m.averageReviewScoreInAParticularYear(2006);

	}

}
