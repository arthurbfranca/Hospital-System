package hospitalmanagement;

import java.util.ArrayList;
import java.util.List;
/**
 * @author erinpaslawski
 *
 */
public class Patient {

	private static int nextId = 5;
	private final Integer id;
	private String first_name;
	private String last_name;
	private Integer age;
	private String email;
	private String gender;
	private String password;
	private List<String> prescriptions = new ArrayList<String>();
	private List<Integer> appointments = new ArrayList<Integer>();

	Patient(String first_name, String last_name, int age, String email, String gender, String password) {
		this.id = nextId++;
		this.first_name = first_name;
		this.age = age;
		this.email = email;
		this.gender = gender;
		this.password = password;
	}

	@Override
	public String toString() {
		return "Patient [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", age=" + age
				+ ", email=" + email + ", gender=" + gender + ", password=" + password + ", prescriptions="
				+ prescriptions + ", appointments=" + appointments + "]";
	}

	/**
	 * @return the first_name
	 */
	public String getFirst_name() {
		return first_name;
	}

	/**
	 * @param first_name the first_name to set
	 */
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	/**
	 * @return the last_name
	 */
	public String getLast_name() {
		return last_name;
	}

	/**
	 * @param last_name the last_name to set
	 */
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	/**
	 * @return the age
	 */
	public Integer getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(Integer age) {
		this.age = age;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the prescriptions
	 */
	public List<String> getPrescriptions() {
		return prescriptions;
	}

	/**
	 * @param prescriptions the prescriptions to set
	 */
	public void setPrescriptions(List<String> prescriptions) {
		this.prescriptions = prescriptions;
	}

	/**
	 * @return the appointments
	 */
	public List<Integer> getAppointments() {
		return appointments;
	}

	/**
	 * @param appointments the appointments to set
	 */
	public void setAppointments(List<Integer> appointments) {
		this.appointments = appointments;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	// getters and setters

}
