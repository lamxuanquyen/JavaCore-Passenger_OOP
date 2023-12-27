package fa.training.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import fa.training.entities.Children;
import fa.training.entities.Adult;
import fa.training.entities.Passenger;
import fa.training.entities.Pregnant;
import fa.training.utils.ConnectionUtil;
import fa.training.utils.DateUtils;


public class Function {
	private static Scanner sc = new Scanner(System.in);
	
	/**
	 * @author : Quyenlx1
	 * @birthday: 25-12-1990
	 * insert dữ liệu của Passenger vào database
	 * @param Passenger
	 */
	public static int insertToDB(List<Passenger> passengerList) {
		int numberRecords = 0;
		try(Connection con = ConnectionUtil.getConnection();) {
			
			String sql = "INSERT INTO Passenger(type,passengerID,name,birthDate,address,phone,testDate,flightDate,job,school,grade,gestationalAge,pretermBirth) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement prstmt = con.prepareStatement(sql);
			con.setAutoCommit(false);
			
			for (Passenger Passenger : passengerList) {
				prstmt.setInt(1,Passenger.getType());
				prstmt.setString(2,Passenger.getPassengerID());
				prstmt.setString(3,Passenger.getName());
				prstmt.setDate(4,DateUtils.convertUtilToSqlDate(Passenger.getBirthDate()));
				prstmt.setString(5,Passenger.getAddress());
				prstmt.setString(6,Passenger.getPhone());
				prstmt.setDate(7,DateUtils.convertUtilToSqlDate(Passenger.getTestDate()));
				prstmt.setDate(8,DateUtils.convertUtilToSqlDate(Passenger.getFlightDate()));
				
//				prstmt.setString(9,Passenger.getJob());
//				prstmt.setString(10,Passenger.getSchool());
//				prstmt.setString(11,Passenger.getGrade());
//				prstmt.setString(12,Passenger.getGestationalAge());
//				prstmt.setString(13,Passenger.getPretermBirth());
//				
//				prstmt.setNull(9, java.sql.Types.INTEGER);
//				prstmt.setNull(8, java.sql.Types.DATE);
//				prstmt.setNull(12, java.sql.Types.TINYINT);
//				prstmt.setNull(13, java.sql.Types.VARCHAR);						
				
				if (Passenger instanceof Adult) {
					prstmt.setString(9,((Adult)Passenger).getJob());
					prstmt.setNull(10, java.sql.Types.VARCHAR);
					prstmt.setNull(11, java.sql.Types.VARCHAR); 
					prstmt.setNull(12, java.sql.Types.VARCHAR); 
					prstmt.setNull(13, java.sql.Types.VARCHAR);
				}
				if (Passenger instanceof Children) {
					prstmt.setNull(9, java.sql.Types.VARCHAR); 
					prstmt.setString(10, ((Children)Passenger).getSchool());
					prstmt.setString(11, ((Children)Passenger).getGrade());
					prstmt.setNull(12, java.sql.Types.VARCHAR);
					prstmt.setNull(13, java.sql.Types.VARCHAR);
				}
				if (Passenger instanceof Pregnant) {
					prstmt.setNull(9, java.sql.Types.VARCHAR); 
					prstmt.setNull(10, java.sql.Types.VARCHAR);
					prstmt.setNull(11, java.sql.Types.VARCHAR); 
					prstmt.setString(12, ((Pregnant)Passenger).getGestationalAge());
					prstmt.setString(13, ((Pregnant)Passenger).getPretermBirth());
				}			
				prstmt.addBatch();				
			}
			
			int[] result = prstmt.executeBatch();
			
			con.commit();
			con.setAutoCommit(true);
			
			for (int i = 0; i < result.length; i++) {
				numberRecords += result[i];
			}			
			
		} catch (SQLException e) {
			e.printStackTrace();
			return numberRecords;
		}
		return numberRecords;
	}

	/**
	 * @author : Quyenlx1
	 * @birthday: 25-12-1990
	 * hiển thị thông tin của Passenger ra ->( note: chưa xong)
	 * @param passengerList
	 */
	public static void showInformation(List<Passenger> passengerList) {
		for (Passenger passenger : passengerList) {
			if (passenger == null) {
				continue;
			}
			if (passenger instanceof Adult) {
				((Adult) passenger).showInfo();
				System.out.println("--------------------");
			}
			if (passenger instanceof Children) {
				((Children) passenger).showInfo();
				System.out.println("--------------------");
			}
			if (passenger instanceof Pregnant) {
				((Pregnant) passenger).showInfo();
				System.out.println("--------------------");
			}
		}
	}
	
	/**
	 * @author : Quyenlx1
	 * @birthday: 25-12-1990
	 * lấy tất cả Passenger từ data
	 * @return
	 */
	public static List<Passenger> getAllPassenger() {
		List<Passenger> passengerList = new ArrayList<>();
		
		String sql = "SELECT * FROM Passenger";
		
		try(Connection con = ConnectionUtil.getConnection();) {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {		
				int PassengerType = rs.getInt("type");				
				switch (PassengerType) {
				case 1:					
					Passenger obj = new Adult();
					
					obj.setType(rs.getInt("type"));
					obj.setPassengerID(rs.getString("passengerID"));
					obj.setName(rs.getString("name"));
					obj.setBirthDate(DateUtils.convertSqlToUtilDate(rs.getDate("birthDate")));
					obj.setAddress(rs.getString("address"));
					obj.setPhone(rs.getString("phone"));
					obj.setTestDate(DateUtils.convertSqlToUtilDate(rs.getDate("testDate")));
					obj.setFlightDate(DateUtils.convertSqlToUtilDate(rs.getDate("flightDate")));
					
//					obj.setJob(rs.getString("job"));
//					obj.setSchool(rs.getString("school"));
//					obj.setGrade(rs.getString("grade"));
//					obj.setGestationalAge(rs.getString("gestationalAge"));
//					obj.setPretermBirth(rs.getString("pretermBirth"));

					((Adult) obj).setJob(rs.getString("job"));
					passengerList.add(obj);
					
					break;
				case 2:
					Passenger obj1 = new Children();
					obj1.setType(rs.getInt("type"));
					obj1.setPassengerID(rs.getString("passengerID"));
					obj1.setName(rs.getString("name"));
					obj1.setBirthDate(DateUtils.convertSqlToUtilDate(rs.getDate("birthDate")));
					obj1.setAddress(rs.getString("address"));
					obj1.setPhone(rs.getString("phone"));
					obj1.setTestDate(DateUtils.convertSqlToUtilDate(rs.getDate("testDate")));
					obj1.setFlightDate(DateUtils.convertSqlToUtilDate(rs.getDate("flightDate")));
										
					((Children) obj1).setSchool(rs.getString("school"));
					((Children) obj1).setGrade(rs.getString("grade"));
					
					passengerList.add(obj1);	
					
					break;			
				case 3:
					Passenger obj2 = new Pregnant();
					obj2.setType(rs.getInt("type"));
					obj2.setPassengerID(rs.getString("passengerID"));
					obj2.setName(rs.getString("name"));
					obj2.setBirthDate(DateUtils.convertSqlToUtilDate(rs.getDate("birthDate")));
					obj2.setAddress(rs.getString("address"));
					obj2.setPhone(rs.getString("phone"));
					obj2.setTestDate(DateUtils.convertSqlToUtilDate(rs.getDate("testDate")));
					obj2.setFlightDate(DateUtils.convertSqlToUtilDate(rs.getDate("flightDate")));
										
					((Pregnant) obj2).setGestationalAge(rs.getString("gestationalAge"));
					((Pregnant) obj2).setPretermBirth(rs.getString("pretermBirth"));
					
					passengerList.add(obj2);
					
					break;
				default:
					break;
				}				
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return passengerList;
	}
	

	/**
	 * @author : Quyenlx1
	 * @birthday: 25-12-1990
	 * get id of all Passenger from database
	 * @return
	 */
	public static ArrayList<String> getIdPassenger() {
		ArrayList<String> idList = new ArrayList<>();
		
		String sql = "SELECT PassengerID FROM Passenger";
		
		try(Connection con = ConnectionUtil.getConnection();) {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				idList.add(rs.getString("PassengerID"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return idList;
	}
	
	/**
	 * @author : Quyenlx1
	 * @birthday: 25-12-1990
	 * update flightDate by id and number date
	 * @param idString
	 * @param soNgay
	 */
	public static int updateFlightDateById(int soNgay, String idString) {

		String sql = "UPDATE Passenger SET flightDate = DATEADD(day, ?, flightDate) WHERE passengerID = ?";
		int countRowUpdate = 0;
		try(Connection con = ConnectionUtil.getConnection();) {
			PreparedStatement prstmt = con.prepareStatement(sql);
			
			prstmt.setInt(1, soNgay);
			prstmt.setString(2, idString);
			
			countRowUpdate = prstmt.executeUpdate();
		
		} catch (SQLException e) {
			e.printStackTrace();			
		}
		return countRowUpdate;
	}
	
	/**
	 * @author : Quyenlx1
	 * @birthday: 25-12-1990
	 * delete Passenger where passPort is null
	 * @param idString
	 * @param name
	 */
	public static int deletePassenger() {

		String sql = "DELETE FROM Passenger WHERE testDate IS NULL";
		int countRowUpdate = 0;
		try(Connection con = ConnectionUtil.getConnection();) {
			PreparedStatement prstmt = con.prepareStatement(sql);		
			countRowUpdate = prstmt.executeUpdate();
		
		} catch (SQLException e) {
			e.printStackTrace();			
		}
		return countRowUpdate;
	}

}
