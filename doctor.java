
public class doctor extends user{
	
	private String insurance;
	private String profession;
	private int workTime;
	
	public doctor(String email, String password, String name, String securityQuestion, String securityAnswer, int key, Boolean type, String insurance, String profession, int workTime, String contact) {
		super(email, password, name, securityQuestion, securityAnswer, key, type, contact);
		this.insurance = insurance;
		this.profession = profession;
		this.workTime = workTime;
	}
	
	public void ChooseTicket() {
		
	}
	
	public void ViewChosenTicket() {
		
	}
	
//-------------------------------------------------------------------------------
	
	public String getInsurance() {
		return insurance;
	}
	
	public String getProfession() {
		return profession;
	}
	
	public int workTime() {
		return workTime;
	}
	
//-------------------------------------------------------------------------------
	
	public void setInsurance(String insurance) {
		this.insurance = insurance;
	}
	
	public void setProfession(String profession) {
		this.profession = profession;
	}
	
	public void setWorkTime(int workTime) {
		this.workTime = workTime;
	}
	

}
