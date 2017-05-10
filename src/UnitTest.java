import static org.junit.Assert.*;
import org.junit.Test;

public class UnitTest {
	
	private final static String TITLE_1 = "Star Wars";
	private final static String TITLE_2 = "Harry Potter";
	
	private final static int MOVIE_1_DAYS = 7;
	private final static int MOVIE_2_DAYS = 4;
	
	private final static String CUSTOMER_1 = "Max Mustermann";

	@Test
	public void test() {
        Movie movie_1 = new Movie(TITLE_1, 1);
        Movie movie_2 = new Movie(TITLE_2, 2);
        
        Rental rental_1 = new Rental(movie_1, MOVIE_1_DAYS);
        Rental rental_2 = new Rental(movie_2, MOVIE_2_DAYS);
        
        Customer customer_1 = new Customer(CUSTOMER_1);  
        
        customer_1.addRental(rental_1);
        customer_1.addRental(rental_2);
        
        String expectedStatement = "Rental Record for " +CUSTOMER_1 +"\n\tTitle\t\tDays\tAmount\n";
        expectedStatement += "\t" +TITLE_1 +"\t\t" +MOVIE_1_DAYS +"\t21.0\n";
        expectedStatement += "\t" +TITLE_2 +"\t\t" +MOVIE_2_DAYS +"\t3.0\n";
        expectedStatement += "Amount owed is 24.0\n";
        expectedStatement += "You earned 3 frequent renter points";
		
		assertEquals(expectedStatement, customer_1.statement());		
	}

}