package fa.training.entities;

import java.util.Date;

public class Pregnant extends Passenger {
	private String gestationalAge;
	private String pretermBirth;

	
	public Pregnant() {
		// TODO Auto-generated constructor stub
	}



	public Pregnant(int type, String passengerID, String name, Date birthDate, String address, String phone, Date testDate,
			Date flightDate, String gestationalAge, String pretermBirth) {
		super(type, passengerID, name, birthDate, address, phone, testDate, flightDate);
		this.gestationalAge = gestationalAge;
		this.pretermBirth = pretermBirth;	
	}
	
	


	/**
	 * @return the gestationalAge
	 */
	public String getGestationalAge() {
		return gestationalAge;
	}



	/**
	 * @return the pretermBirth
	 */
	public String getPretermBirth() {
		return pretermBirth;
	}



	/**
	 * @param gestationalAge the gestationalAge to set
	 */
	public void setGestationalAge(String gestationalAge) {
		this.gestationalAge = gestationalAge;
	}



	/**
	 * @param pretermBirth the pretermBirth to set
	 */
	public void setPretermBirth(String pretermBirth) {
		this.pretermBirth = pretermBirth;
	}


	@Override
	public String toString() {
		return "Pregnant [gestationalAge=" + gestationalAge + ", pretermBirth=" + pretermBirth + "]";
	}

	//"+ super.toString()+ "
	@Override
	public void showInfo() {
		System.out.println("Pregnant ["+ super.toString()+ "gestationalAge=" + gestationalAge + ", pretermBirth=" + pretermBirth + "]");
		
	}

}
