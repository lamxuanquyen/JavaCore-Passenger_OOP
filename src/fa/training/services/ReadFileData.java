package fa.training.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fa.training.entities.Adult;
import fa.training.entities.Children;
import fa.training.entities.Passenger;
import fa.training.entities.Pregnant;
import fa.training.user.exception.CommonException;
import fa.training.utils.DateUtils;
import fa.training.utils.IOUtil;
import fa.training.utils.Validator;

public class ReadFileData {

	public static void main(String[] args) {

//		List<Passenger> PassengerList = readDataFromFile();
//		for (Passenger Passenger : PassengerList) {
//			Passenger.showInfo();
//		}
	}

	/**
	 * @author : Quyenlx1
	 * @birthday: 1990-12-25
	 * read data from file
	 * @return
	 */
	public static List<Passenger> readDataFromFile() {
		String path = "D:\\baitap_java\\Passenger_OOP\\src\\data.csv";
		List<Passenger> list = new ArrayList<>();
		try {
			List<String> lineDataList = IOUtil.readDataInFile(path);
			int type = 0;
			String passengerID;
			String name;
			Date birthDate;
			String address;
			String phone;
			Date testDate;
			Date flightDate;
			String job;
			String school;
			String grade;
			String gestationalAge;
			String pretermBirth;

			
			ArrayList<String> idList = new ArrayList<>();
			
			for (String line : lineDataList) {				
				String[] lineData = line.split(",");
				
				if (Validator.isIntNumber(lineData[0])) {
					type = Integer.parseInt(lineData[0]);
				}			
				
				passengerID = lineData[1];
				if (!Validator.isValidStringStartWith(passengerID)) {
					System.out.println("PassengerID must be in format of “PSxxx”!!!");
					continue;
				}
				
				if (idList.contains(passengerID)) {
					System.out.println("Passenger " + passengerID + " has duplicate ID");
					continue;
				}else {
					idList.add(passengerID);
				}
				
				name = lineData[2];
				birthDate = DateUtils.convertStringToUtilDate(lineData[3]);
				address = lineData[4];
				phone = lineData[5];
				
				testDate = DateUtils.convertStringToUtilDate(lineData[6]);
				try {
					if (!DateUtils.isDateBeforeCurrentDate(testDate)) {
						throw new CommonException("Test Date of Covid must be less than current date!!!");
					}
				} catch (CommonException e) {
					System.out.println(e.getMessage());
					continue;
				}
				flightDate = DateUtils.convertStringToUtilDate(lineData[7]);
				
//				job = lineData[8];
//				school = lineData[9];
//				grade = lineData[10];
//				gestationalAge = lineData[11];
//				pretermBirth = lineData[12];
				
				switch (type) {
				case 1:
					job = lineData[8];					
					Passenger hanhKhach = new Adult(type,  passengerID,  name,  birthDate,  address,  phone,  testDate,
							 flightDate,  job);					
					list.add(hanhKhach);
					break;
				case 2:				
					school = lineData[9];
					grade = lineData[10];					
					Passenger treEm = new Children(type,  passengerID,  name,  birthDate,  address,  phone,  testDate,
							 flightDate,  school, grade);					
					list.add(treEm);
					break;
				case 3:
					gestationalAge = lineData[11];
					pretermBirth = lineData[12];
					Passenger nguoiThai = new Pregnant(type,  passengerID,  name,  birthDate,  address,  phone,  testDate,
							 flightDate,  gestationalAge, pretermBirth);
					list.add(nguoiThai);
					break;
				default:
					break;
				}
			}

		} catch (IOException e) {
			System.out.println("Loi doc file data");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Program have an unexpected error occurred !!!");
			e.printStackTrace();
		}
		return list;
	}
}
