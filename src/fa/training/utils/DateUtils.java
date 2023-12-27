package fa.training.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

import fa.training.user.exception.CommonException;

public class DateUtils {

	/**
	 * Account: quyenlx1 Birthday: 25-12-1990 Kiểm tra tính hợp lệ của chuỗi ngày
	 * theo định dạng.
	 * 
	 * @param dateStr   Chuỗi ngày cần kiểm tra.
	 * @param formatStr Định dạng ngày.
	 * @return True nếu chuỗi ngày hợp lệ theo định dạng, ngược lại trả về false.
	 */
	public static boolean isValidDate(String dateStr, String formatStr) {
		DateFormat dateFormat = new SimpleDateFormat(formatStr);
		// chặn SimpleDateFormat từ việc tự động điều chỉnh dữ liệu không hợp lệ và chỉ
		// chấp nhận các giá trị chính xác và hợp lệ
		dateFormat.setLenient(false);
		try {
			dateFormat.parse(dateStr);
			return true;
		} catch (ParseException e) {
			return false;
		}
	}

	/**
	 * Account: quyenlx1 Birthday: 25-12-1990 Chuyển đổi chuỗi ngày thành đối tượng
	 * Date của util.
	 * 
	 * @param dateStr Chuỗi ngày cần chuyển đổi.
	 * @return Đối tượng Date của SQL nếu chuỗi hợp lệ, ngược lại trả về null.
	 */
	public static Date convertStringToUtilDate(String dateStr) {
		if (isValidDate(dateStr, "MM/dd/yyyy")) {
			DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
			dateFormat.setLenient(false);
			try {
				java.util.Date utilDate = dateFormat.parse(dateStr);
				return new Date(utilDate.getTime());
			} catch (ParseException e) {
				e.printStackTrace();
				return null;
			}
		} else {
			return null;
		}
	}

	/**
	 * Account: quyenlx1 Birthday: 25-12-1990 Convert Util Date to SQL Date change
	 * type util date to sql date
	 * 
	 * @param date
	 * @return
	 */
	public static java.sql.Date convertUtilToSqlDate(Date utilDate) {
		return new java.sql.Date(utilDate.getTime());
	}

	/**
	 * *Account: quyenlx1 Birthday: 25-12-1990 change type sqlDate to utils date
	 * 
	 * @param date
	 * @return
	 */
	public static Date convertSqlToUtilDate(java.sql.Date sqlDate) {
		return new Date(sqlDate.getTime());
	}

	/**
	 * Account: quyenlx1 Birthday: 25-12-1990 change date to calendar
	 * 
	 * @param input
	 * @return
	 */
	public static Calendar cvrtDateToCalendar(Date input) {
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(input.getTime());
		return cal;
	}

	/**
	 * Account: quyenlx1 Birthday: 25-12-1990 change type util date to local Date
	 * 
	 * @param input
	 * @return
	 */
	public static LocalDate cvrtUtilToLocalDate(Date date) {
		return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	}

	/**
	 * Account: quyenlx1 Birthday: 25-12-1990 change type sql date to local Date
	 * 
	 * @param input
	 * @return
	 */
	public static LocalDate cvrtSqlToLocalDate(java.sql.Date dateSql) {
		return dateSql.toLocalDate();
	}

	/**
	 * @author : Quyenlx1
	 * @birthday: 1990-12-25
	 * compare date vs currentDate.if before -> return true
	 * @param date
	 * @return
	 */
	public static boolean isDateBeforeCurrentDate(Date date) {
		boolean isCheck = false;
		try {
			if (date == null) {
				throw new CommonException(" Date is not in the correct format!...");
			}
			LocalDate currentDate = LocalDate.now();
			LocalDate dateLocal = cvrtUtilToLocalDate(date);
			if (dateLocal.isBefore(currentDate)) {
				return isCheck = true;
			} 
//			if (dateLocal.isEqual(currentDate) || dateLocal.isAfter(currentDate)) {
//				return isCheck = false;
//			}
		} catch (CommonException e) {
			System.out.println(e.getMessage());
		}
		return isCheck;
	}
	
	/**
	 * @author : Quyenlx1
	 * @birthday: 1990-12-25
	 * compare date vs currentDate.if before -> return true
	 * @param date
	 * @return
	 */
	public static boolean isDateGreaterOneWeek(Date date1 ,Date date2 ) {
		boolean isCheck = false;
		try {
			if (date1 == null || date2 == null) {
				throw new CommonException(" Date is not in the correct format!...");
			}
			long time1 = date1.getTime();
			long time2 = date2.getTime();
			long difference;
			if (time2 >= time1) {
				difference = time2 - time1;
			}else {
				difference = time1 - time2;
			}
			
			if (difference / (24 * 60 * 60 * 1000) > 7) {
				isCheck = true;
	        }

		} catch (CommonException e) {
			System.out.println(e.getMessage());
		}
		return isCheck;
	}
}
