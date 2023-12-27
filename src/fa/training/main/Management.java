package fa.training.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import fa.training.entities.Passenger;
import fa.training.services.Function;
import fa.training.services.ReadFileData;
import fa.training.services.SortByComparator;
import fa.training.utils.DateUtils;

public class Management {
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {


		LOOP: do {
			System.out.println("Moi chon chuc nang");
			System.out.println("1/ insert Passenger");
			System.out.println("2/ show Passenger from file");
			System.out.println("3/ update Passenger ");
			System.out.println("4/ delete Passenger ");
			System.out.println("5/ get all Passenger after update and sort");
			System.out.println("6/ ");		
			System.out.println("7/ ");
			System.out.println("8/ Thoat vong lap");

			int choice;
			try {
				choice = Integer.parseInt(sc.nextLine().trim());
			} catch (NumberFormatException nfe) {
				System.out.println("Invalid number. Please enter again!");
				continue;
			}
			
			List<Passenger> passengerList = ReadFileData.readDataFromFile();

			switch (choice) {
			case 1:
				System.out.println("----- nhap thong tin Passenger -----");				
				int countResult = Function.insertToDB(passengerList);
				System.out.println("Số lượng bản ghi đã được chèn vào bảng la:" + countResult);
				break;
			case 2:
				System.out.println("----- Thong Tin Toan Bo Passenger từ file ----");
				Function.showInformation(passengerList);
				
				break;
			case 3:
				System.out.println(" Cập nhật ");
				Date curentDate = new Date();
				
				List<String> idUpdateList = new ArrayList<>();
				
				for (Passenger passenger : passengerList) {
					if (DateUtils.isDateGreaterOneWeek(passenger.getTestDate(), curentDate)) {
						//kiểm tra Id này đã có trong list đã update chưa? nếu có rồi thì bỏ qua
						if (idUpdateList.contains(passenger.getPassengerID())) {
							continue;
						}
						
						int count = Function.updateFlightDateById(2, passenger.getPassengerID());
						if (count > 0) {
							System.out.println("update thanh cong ID: " + passenger.getPassengerID());
						}else {
							System.out.println("update that bai ID: " + passenger.getPassengerID());
						}
						
						idUpdateList.add(passenger.getPassengerID());
						
						//tạo ra 1 list id có cùng địa chỉ -> add vào
						List<String> idSameAdressList = new ArrayList<>();
						for (Passenger passenger2 : passengerList) {
							if (passenger.getAddress().equals(passenger2.getAddress())) {
								idSameAdressList.add(passenger2.getPassengerID());
							}
						}
						
						//nếu list này lớn hơn 1 thì lọc từng id trong đó, cái nào chưa dc update thì update
						if (idSameAdressList.size() > 1) {
							for (String id : idSameAdressList) {
								if (idUpdateList.contains(id)) {
									continue;
								}else {
									int count1 = Function.updateFlightDateById(2, id);
									if (count1 > 0) {
										idUpdateList.add(id);
									}
								}
							}
						}
					}
				}
				
				break;
			case 4:
				System.out.println("delete Passenger where testDate is null");
				int count = Function.deletePassenger();
				System.out.println("so record duoc xoa la: " + count);
				break;
			case 5:
				System.out.println("get all Passenger after update and sort");
			
				List<Passenger> allpassengerList = Function.getAllPassenger();
				Collections.sort(allpassengerList, new SortByComparator());
				
//				Collections.sort(allpassengerList, Comparator.comparing(Passenger::getFlightDate,Comparator.reverseOrder())
//						.thenComparing(Passenger::getPassengerID));
				Function.showInformation(allpassengerList);
				
				break;
			case 6:
				System.out.println(" ");
		
				
				break;
			case 7:
				System.out.println(" ");
			
				break;
			case 8:
				System.out.println("Hẹn gặp lại");
				break LOOP;
			default:
				System.out.println("Bạn nhập không hợp lệ! Vui lòng nhập lại!");
				break;
			}
		} while (true);
	}


}
