package fa.training.entities;

import java.util.Date;

public class Adult extends Passenger {
	private String job;
	
	public Adult() {
		// TODO Auto-generated constructor stub
	}

	public Adult(int type, String passengerID, String name, Date birthDate, String address, String phone, Date testDate,
			Date flightDate, String job) {
		super(type, passengerID, name, birthDate, address, phone, testDate, flightDate);
		this.job = job;
	}

	
	
	/**
	 * @return the job
	 */
	public String getJob() {
		return job;
	}

	/**
	 * @param job the job to set
	 */
	public void setJob(String job) {
		this.job = job;
	}

	@Override
	public String toString() {
		return "Adult [job=" + job + "]";
	}

	//"+ super.toString()+ "
	@Override
	public void showInfo() {
		System.out.println("Adult ["+ super.toString()+ "job=" + job + "]");
		
	}

}
