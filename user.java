
public class user {
	
	protected String email;
	protected int key;
	private String password;
	private String name;
	
	public user(String email, int key, String password, String name){
		this.email = email;
		this.key = key;
		this.password = password;
		this.name = name;
	}
	
	public void Register() {
		
	}
	
	public void Login(String username, String password) {
		
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
	
	public int getKey() {
		return key;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getName() {
		return name;
	}
	
//-------------------------------------------------------------------------------------------
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setKey(int key) {
		this.key = key;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setName(String name) {
		this.name = name;
	}

}
