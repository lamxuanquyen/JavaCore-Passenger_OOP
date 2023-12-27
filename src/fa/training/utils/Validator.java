package fa.training.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import fa.training.user.exception.CommonException;
import fa.training.user.exception.CommonException;

public class Validator {

	/**
	 * @author : Quyenlx1
	 * @birthday: 1990-12-25
	 * kiểm tra 1 string ko rỗng
	 * @param str
	 * @return
	 */
	public static boolean isValidString(String str) {
		return str != null && str.trim().length() > 0;
	}
	
	/**
	 * @author : Quyenlx1
	 * @birthday: 1990-12-25
	 * check validate for Full name length must be between 10 and 50 characters.
	 * @param name
	 * @return
	 * @throws CommonException 
	 */
	public static boolean isCheckFullName(String name) throws CommonException {
		String NAME_REGEX = "^[a-zA-Z]{10,50}$";
		Pattern pattern = Pattern.compile(NAME_REGEX);
		Matcher matcher = pattern.matcher(name);
		if (!matcher.matches()) {
			throw new CommonException("Full name length must be between 10 and 50 characters.");
		}
		return matcher.matches();		
	}
	
	/**
	 * @author : Quyenlx1
	 * @birthday: 1990-12-25
	 * check string gom chu va so
	 * @param str
	 * @return
	 */
	public static boolean isNumAndChar(String str) {
		return str.matches("^[a-zA-Z0-9]+$");
	}
	

	/**
	 * @author : Quyenlx1
	 * @birthday: 1990-12-25
	 * check validate for email
	 * @param email
	 * @return
	 * @throws CommonException 
	 */
	public static boolean isValidateEmail(String email) throws CommonException {
//		return email.matches("^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z]{2,}$");
		String EMAIL_REGEX = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-z]{2,}$";
		Pattern pattern = Pattern.compile(EMAIL_REGEX);
		Matcher matcher = pattern.matcher(email);
		if (!matcher.matches()) {
			throw new CommonException("dinh dang email khong dung");
		}
		return matcher.matches();
		
	}

	/**
	 * @author : Quyenlx1
	 * @birthday: 1990-12-25
	 * kiểm tra xem : 1900 < năm nhập vào < năm hiện tại không?
	 * @param dateString
	 * @return
	 * @throws CommonException 
	 */
	public static boolean isCheckDate(String dateString) throws CommonException {
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		dateFormat.setLenient(false);
		boolean isCheck = false;
		try {
			Date inputDate = dateFormat.parse(dateString);
			
			Calendar cal = Calendar.getInstance();
			cal.setTime(inputDate);
			//kiểm tra xem : 1900 < năm nhập vào < 2023
			if (cal.get(Calendar.YEAR) <= 2023 && cal.get(Calendar.YEAR) >= 1900) {
				isCheck = true;
			}else {
				throw new CommonException("year khong dung yeu cau: 1900 < year <= hientai");
			}

		} catch (ParseException e) {
			isCheck = false;
			e.getStackTrace();
		}
		return isCheck;
	}

	/**
	 * @author : Quyenlx1
	 * @birthday: 1990-12-25
	 * kiểm tra sdt có 10 số bắt đầu bằng số 0
	 * "^(090|098|091|031|035|038)\\d{7}$
	 * @param phone
	 * @return
	 */
	public static boolean isValidPhone(String phone) {
        return phone.matches("^(0)[0-9]{9}$");
    }
	
//	public static boolean isValidPhone(String phone) {
//        return phone.matches("^(03|05|07|08|09)[0-9]{8}$");
//    }

	/**
	 * @author : Quyenlx1
	 * @birthday: 1990-12-25
	 * kiem ta string la 1 so nguyen
	 * @param numberString
	 * @return
	 */
	public static boolean isIntNumber(String numberString) {
		try {
			Integer.parseInt(numberString.trim());			
		} catch (NumberFormatException nfe) {			
			nfe.getStackTrace();
			System.out.println(nfe.getMessage());
			return false;
		}
		return true;
	}
	
	/**
	 * @author : Quyenlx1
	 * @birthday: 1990-12-25
	 * kiem ta string la 1 so double
	 * @param numberString
	 * @return
	 */
	public static boolean isDoubleNumber(String numberString) {
		try {
			Double.parseDouble(numberString.trim());		
		} catch (NumberFormatException nfe) {			
			nfe.getStackTrace();
			System.out.println(nfe.getMessage());
			return false;
		}
		return true;
	}
	
	/**
	 * @author : Quyenlx1
	 * @birthday: 1990-12-25
	 * kiem ta string la 1 so float
	 * @param numberString
	 * @return
	 */
	public static boolean isFloatNumber(String numberString) {
		try {
			Float.parseFloat(numberString.trim());		
		} catch (NumberFormatException nfe) {			
			nfe.getStackTrace();
			System.out.println(nfe.getMessage());
			return false;
		}
		return true;
	}
	
	/**
	 * @author : Quyenlx1
	 * @birthday: 1990-12-25
	 * kiểm tra String startwith "IM" and 3 digits: ^[Ii][Mm][0-9]{3}$
	 * kiểm tra String startwith "IM" hoạc "ab" and 3 digits: "^(IM|ab)\\d{3}$"
	 * @param phone
	 * @return
	 */
	public static boolean isValidStringStartWith(String str) {
        return str.matches("PS\\d{3}$");
    }
}
