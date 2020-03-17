package hospitalmanagement;

/*
* Class that represents a user's acccount information such as username and password
*/
public class Account {

	private String username;
	private String password;

	/*
	* This method is used to check the length of the username of an account
	* @param username: the username for the account
	* @return boolean: returns whether the username length is less than or equal to 16 characters
	*/
	public static boolean checkUsername(String username) {
		if(username.length() <= 16) {
			return true;
		}
		return false; 
	}
	
	/*
	* This method is used to check the length of the password of an account
	* @param pass: the password for the account
	* @return boolean: returns true/false on whether the password length is greater than or equal to 16 characters
	*/
	public static boolean checkPassword(String pass) {
		if(pass.length() >= 16) {
			return true;
		}
		return false; 
	}
	
	/*
	* This constructor is used to get the username and password 
	* @param user: the username for the account
	* @param pass: the password for the account
	*/
	public Account(String user, String pass) {
		this.username = user;
		this.password = pass;
	}

	/*
	* This is a getter method for the username 
	* @return String: the username 
	*/
	protected String getUsername() {
		return username;
	}

	
	/*
	* This is a setter method for the username
	* @param username: the username for the account
	* @return boolean: returns true/false on whether the username length has been checked
	*/
	protected boolean setUsername(String username) {
		if(Account.checkUsername(username)) {
			this.username = username;
			return true;
		}
		return false;
	}

	/*
	* This is a getter method for the password
	* @return String: the password
	*/
	protected String getPassword() {
		return password;
	}

	/*
	* This is a setter method for the password
	* @param password: the password for the account
	* @return boolean: returns true/false on whether the password length has been checked
	*/
	protected boolean setPassword(String password) {
		if(Account.checkPassword(password)) {
			this.password = password;
			return true;
		}
		return false;
	}
}
