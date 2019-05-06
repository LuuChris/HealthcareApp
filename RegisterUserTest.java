package testing;

import static org.junit.Assert.*; 

import org.junit.Test;

import medpack.Main;

public class RegisterUserTest {

	@Test
	public void matchedUsernameAndEmail() {
		Main m = new Main();
		Boolean b = m.checkUser("chris", "chris@email.com");
		assertFalse(b);
	}
	
	@Test
	public void matchedUsername() {
		Main m = new Main();
		Boolean b = m.checkUser("chris", "random");
		assertFalse(b);
	}
	
	@Test
	public void matchedEmail() {
		Main m = new Main();
		Boolean b = m.checkUser("random", "chris@email.com");
		assertFalse(b);
	}
	
	@Test
	public void unmatched() {
		Main m = new Main();
		Boolean b = m.checkUser("random123", "random123");
		assertTrue(b);
	}
	
	@Test
	public void empty() {
		Main m = new Main();
		Boolean b = m.checkUser("", "");
		assertTrue(b);
	}

}
