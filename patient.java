package medpack;

public class patient extends user{
	
	private String allergy, address, ethnicity, medicalcondition;
	private int age, userkey;
	
	public patient(String contact, String email, String firstname, String lastname, String password, String securityanswer, String type, String username, int securityint, int userkey, String allergy, String address, String ethnicity, String medicalcondition, int age) {
		super(contact, email, firstname, lastname, password, securityanswer, type, username, securityint, userkey);
		this.allergy = allergy;
		this.address = address;
		this.ethnicity = ethnicity;
		this.medicalcondition = medicalcondition;
		this.age = age;
		this.userkey = userkey;
	}
	
	public static void CreateTicket(int num) {
		frontCreateTicket f = new frontCreateTicket(num);
		f.setVisible(true);
	}
	
	public static void EditTicket(int patientkey) {
		frontEditTicket f = new frontEditTicket(patientkey);
		f.setVisible(true);
		
	}
	
	public static void ViewDoctorInfo() {
		
	}
	
//-------------------------------------------------------------------------------
	
	public String getAllergy() {
		return allergy;
	}
	
	public String getMedicalCondition() {
		return medicalcondition;
	}
	
	public String getAddress() {
		return address;
	}
	
	public String getEthnicity() {
		return ethnicity;
	}
	
	public int getAge() {
		return age;
	}
	
	public int getUserKey() {
		return userkey;
	}
	
//--------------------------------------------------------------------------------

	public void setAllergy(String allergy) {
		this.allergy = allergy;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public void setEthnicity(String ethnicity) {
		this.ethnicity = ethnicity;
	}
	
	public void setMedicalCondition(String medicalcondition) {
		this.medicalcondition = medicalcondition;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public void setUserKey(int userkey) {
		this.userkey = userkey;
	}
	
}
