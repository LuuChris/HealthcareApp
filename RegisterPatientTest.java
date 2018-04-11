package testing;

import static org.junit.Assert.*; 

import org.junit.Test;

import medpack.Main;
import medpack.user;
import medpack.patient;

public class RegisterPatientTest {

	@Test
	public void patientObjectTest1() {
		Main m = new Main();
		patient p = new patient("1111111111", "chrisl@email.com", "chris", "l", "password", "eggs", "0", "user", 1, 11111, "bees", "2222 street", "other", "none", 20);
		
		assertEquals("1111111111", p.getContact());
		assertEquals("chrisl@email.com", p.getEmail());
		assertEquals("chris", p.getFirstName());
		assertEquals("l", p.getLastName());
		assertEquals("password", p.getPassword());
	}
	
	@Test
	public void patientObjectTest2() {
		Main m = new Main();
		patient p = new patient("1111111111", "chrisl@email.com", "chris", "l", "password", "eggs", "0", "user", 1, 11111, "bees", "2222 street", "other", "none", 20);
	
		assertEquals("eggs", p.getSecurityAnswer());
		assertEquals("0", p.getType());
		assertEquals("user", p.getUsername());
		assertEquals(1, p.getSecurityInt());
		assertEquals(11111, p.getUserKey());
	}
	
	@Test
	public void patientObjectTest3() {
		Main m = new Main();
		patient p = new patient("1111111111", "chrisl@email.com", "chris", "l", "password", "eggs", "0", "user", 1, 11111, "bees", "2222 street", "other", "none", 20);
		
		assertEquals("bees", p.getAllergy());
		assertEquals("2222 street", p.getAddress());
		assertEquals("other", p.getEthnicity());
		assertEquals("none", p.getMedicalCondition());
		assertEquals(20, p.getAge());
	}

}
