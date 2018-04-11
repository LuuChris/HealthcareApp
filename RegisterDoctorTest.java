package testing;

import static org.junit.Assert.*;

import org.junit.Test;

import medpack.Main;
import medpack.user;
import medpack.doctor;

public class RegisterDoctorTest {

	@Test
	public void doctorObjectTest1() {
		doctor d = new doctor("0000000000", "doctor@email.com", "Dr. Wizard", "of Oz", "password", "pizza", "1", "Oz", 1, 88888, "StateFarm", "Dentist", "1000", "1700");
		
		assertEquals("0000000000", d.getContact());
		assertEquals("doctor@email.com", d.getEmail());
		assertEquals("Dr. Wizard", d.getFirstName());
		assertEquals("of Oz", d.getLastName());
		assertEquals("password", d.getPassword());
	}
	
	@Test
	public void doctorObjectTest2() {
		doctor d = new doctor("0000000000", "doctor@email.com", "Dr. Wizard", "of Oz", "password", "pizza", "1", "Oz", 1, 88888, "StateFarm", "Dentist", "1000", "1700");
	
		assertEquals("pizza", d.getSecurityAnswer());
		assertEquals("1", d.getType());
		assertEquals("Oz", d.getUsername());
		assertEquals(1, d.getSecurityInt());
		assertEquals(88888, d.getUserKey());
	}
	
	@Test
	public void doctorObjectTest3() {
		doctor d = new doctor("0000000000", "doctor@email.com", "Dr. Wizard", "of Oz", "password", "pizza", "1", "Oz", 1, 88888, "StateFarm", "Dentist", "1000", "1700");
	
		assertEquals("StateFarm", d.getInsurance());
		assertEquals("Dentist", d.getSpecialty());
		assertEquals("1000", d.getWorkStart());
		assertEquals("1700", d.getWorkEnd());
		
	}

}
