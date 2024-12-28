package Model;

public class UserLoginModel {

	private String email;
    private String password;
	public UserLoginModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public UserLoginModel(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}


	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPass() {
		return password;
	}
	public void setPass(String password) {
		this.password = password;
	}
    
    
}
