
public class patient extends user{
	
	private String backgroundHistory, age, gender, address, ethnicity;
	
	public patient(String email, int key, String password, String name, Boolean type, String backgroundHistory, String age, String gender, String address) {
		super(email, password, name, securityQuestion, securityAnswer, key, type);
		this.backgroundHistory = backgroundHistory;
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
	
	public String getBackgroundHistory() {
		return backgroundHistory;
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

	public void setBackgroundHistory(String backgroundHistory) {
		this.backgroundHistory = backgroundHistory;
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
