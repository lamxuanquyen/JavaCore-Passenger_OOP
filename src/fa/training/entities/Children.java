package fa.training.entities;

import java.util.Date;

public class Children extends Passenger {
	private String school;
	private String grade;

	
	public Children() {
		// TODO Auto-generated constructor stub
	}



	public Children(int type, String passengerID, String name, Date birthDate, String address, String phone, Date testDate,
			Date flightDate, String school, String grade) {
		super(type, passengerID, name, birthDate, address, phone, testDate, flightDate);
		this.school = school;
		this.grade = grade;	
	}
	
	
	/**
	 * @return the school
	 */
	public String getSchool() {
		return school;
	}



	/**
	 * @return the grade
	 */
	public String getGrade() {
		return grade;
	}



	/**
	 * @param school the school to set
	 */
	public void setSchool(String school) {
		this.school = school;
	}



	/**
	 * @param grade the grade to set
	 */
	public void setGrade(String grade) {
		this.grade = grade;
	}



	@Override
	public String toString() {
		return "Children [school=" + school + ", grade=" + grade + "]";
	}


	//"+ super.toString()+ "
	@Override
	public void showInfo() {
		System.out.println("Children ["+ super.toString()+ "school=" + school + ", grade=" + grade + "]");
		
	}

}
