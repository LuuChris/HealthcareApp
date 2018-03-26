
public class patient extends user{
	
	private String currentMedicalCondition, allergy, age, gender, address, ethnicity;
	
	public patient(String email, String password, String name, String securityQuestion, String securityAnswer, int key, Boolean type, String allergy, String currentMedicalCondition, String age, String gender, String address, String ethnicity, String contact) {
		super(email, password, name, securityQuestion, securityAnswer, key, type, contact);
		this.currentMedicalCondition = currentMedicalCondition;
		this.allergy = allergy;
		this.age = age;
		this.gender = gender;
		this.address = address;
		this.ethnicity = ethnicity;
	}
	
	public void CreateTicket() {
		
	}
	
	public void EditTicket() {
		
	}
	
	public void ViewDoctorInfo() {
		
	}
	
//-------------------------------------------------------------------------------
	
	public String getCurrentMedicalCondition() {
		return currentMedicalCondition;
	}
	
	public String getAllergy() {
		return allergy;
	}
	
	public String getAge() {
		return age;
	}
	
	public String getGender() {
		return gender;
	}
	
	public String getAddress() {
		return address;
	}
	
	public String getEthnicity() {
		return ethnicity;
	}
	
//--------------------------------------------------------------------------------

	public void setCurrentMedicalCondition(String currentMedicalCondition) {
		this.currentMedicalCondition = currentMedicalCondition;
	}
	
	public void setAllergy(String allergy) {
		this.allergy = allergy;
	}
	
	public void setAge(String age) {
		this.age = age;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public void setEthnicity(String ethnicity) {
		this.ethnicity = ethnicity;
	}
	
}
