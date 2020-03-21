package hospitalmanagement;

/*
* Class that represents a user's acccount.
* It stores the user's information such as username and password.
*/
public class Account {

	private String firstName;
	private String lastName;
	private int age;
	private String email;
	private String gender;
	private String username;
	private String password;
	
	/**
	 * Constructor for accounts that accept an age (Patients).
	 * @param first: the user's first name
	 * @param last: the user's last name
	 * @param age: the user's age
	 * @param email: the user's email
	 * @param gender: the user's gender
	 * @param password: the user's password
	 */
	public Account(String first, String last, int age, String email, String gender, String password) {
		this(first, last, email, gender, password);
		this.age = age;
	}
	
	/**
	 * Constructor for accounts that do not accept an age (Staff).
	 * @param first: the user's first name
	 * @param last: the user's last name
	 * @param email: the user's email
	 * @param gender: the user's gender
	 * @param password: the user's password
	 */
	public Account(String first, String last, String email, String gender, String password) {
		this.firstName = first;
		this.lastName = last;
		this.email = email;
		this.gender = gender;
		this.username = email.substring(0, email.indexOf("@"));
		this.password = password;
	}

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

	/**
	 * This is a getter method for the first name.
	 * @return String: the user's first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * This is a setter method for the user's first name.
	 * @param firstName: the name to be set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * This is a getter method for age.
	 * @return int: the user's age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * This is a setter method for the user's age.
	 * @param age: the age to be set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * This is a getter method for the last name.
	 * @return String: the user's last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * This is a setter method for the user's last name.
	 * @param lastName: the last name to be set.
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * This is a getter method for the user's gender.
	 * @return String: the user's gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * This is a setter method for the user's gender.
	 * @param gender: the gender to be set.
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * This is a getter method for the user's email.
	 * @return String: the user's email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * This is a setter method for the user's email.
	 * @param email: the email to be set.
	 */
	public void setEmail(String email) {
		this.email = email;
	}
}
