package fa.training.entities;

import java.util.Date;

public abstract class Passenger {
	private int type;
	private String passengerID;
	private String name;
	private Date birthDate;
	private String address;
	private String phone;
	private Date testDate;
	private Date flightDate;

	
	public Passenger(int type, String passengerID, String name, Date birthDate, String address, String phone,
			Date testDate, Date flightDate) {
		super();
		this.type = type;
		this.passengerID = passengerID;
		this.name = name;
		this.birthDate = birthDate;
		this.address = address;
		this.phone = phone;
		this.testDate = testDate;
		this.flightDate = flightDate;
	}


	public Passenger() {
		// TODO Auto-generated constructor stub
	}

	

	/**
	 * @return the type
	 */
	public int getType() {
		return type;
	}


	/**
	 * @return the passengerID
	 */
	public String getPassengerID() {
		return passengerID;
	}


	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}


	/**
	 * @return the birthDate
	 */
	public Date getBirthDate() {
		return birthDate;
	}


	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}


	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}


	/**
	 * @return the testDate
	 */
	public Date getTestDate() {
		return testDate;
	}


	/**
	 * @return the flightDate
	 */
	public Date getFlightDate() {
		return flightDate;
	}


	/**
	 * @param type the type to set
	 */
	public void setType(int type) {
		this.type = type;
	}


	/**
	 * @param passengerID the passengerID to set
	 */
	public void setPassengerID(String passengerID) {
		this.passengerID = passengerID;
	}


	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}


	/**
	 * @param birthDate the birthDate to set
	 */
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}


	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}


	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}


	/**
	 * @param testDate the testDate to set
	 */
	public void setTestDate(Date testDate) {
		this.testDate = testDate;
	}


	/**
	 * @param flightDate the flightDate to set
	 */
	public void setFlightDate(Date flightDate) {
		this.flightDate = flightDate;
	}

	
	@Override
	public String toString() {
		return "type=" + type + ", passengerID=" + passengerID + ", name=" + name + ", birthDate="
				+ birthDate + ", address=" + address + ", phone=" + phone + ", testDate=" + testDate + ", flightDate="
				+ flightDate + ",";
	}


	public abstract void showInfo();	

	
	
}
