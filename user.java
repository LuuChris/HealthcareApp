
public class user {
	
	protected String contact, email, name, password, securityQuestion, securityAnswer;
	protected int userKey;
	private Boolean type;
	
	public user(String email, String password, String name, String securityQuestion, String securityAnswer, int key, Boolean type, String contact){
		this.email = email;
		this.password = password;
		this.name = name;
		this.securityQuestion = securityQuestion;
		this.securityAnswer = securityAnswer;
		this.userKey = key;
		this.type = type;
		this.contact = contact;
	}
	
	public void Register() {
		
	}
	
	public static void Login(String username, String password) {
		if(Main.authenticate(username, password)) {
			setClientTo(username);
			setWindow(home);
			return;
		}
		else {
			
		}
	}
	
	public void Logout() {
		
	}
	
	public void DeleteAccount() {
		
	}
	
	public void EditAccount() {
		
	}
	
	public void ForgetPassword() {
		
	}
	
//--------------------------------------------------------------------------------------
	
	public String getEmail() {
		return email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getName() {
		return name;
	}
	
	public String getSecurityQuestion() {
		return securityQuestion;
	}
	
	public String getSecurityAnswer() {
		return securityAnswer;
	}
	
	public int getKey() {
		return key;
	}
	
	public Boolean getLogin() {
		return type;
	}
	
//-------------------------------------------------------------------------------------------
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setSecurityQuestion(String securityQuestion) {
		this.securityQuestion = securityQuestion;
	}
	
	public void setSecurityAnswer(String securityAnswer) {
		this.securityAnswer = securityAnswer;
	}
	
	public void setKey(int key) {
		this.key = key;
	}
	
	public void setType(Boolean type) {
		this.type = type;
	}

}
