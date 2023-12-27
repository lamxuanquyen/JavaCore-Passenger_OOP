package fa.training.main;


import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

import fa.training.user.exception.CommonException;
import fa.training.utils.DateUtils;
import fa.training.utils.Validator;

public class Test {
	public static void main(String[] args){
//		String str = "gfhsgfASDGA1234454";
//
//		System.out.println(Validator.isNumAndChar(str));

//		String strDate = "10/1/2023";
//		
//		Date date = DateUtils.convertStringToUtilDate(strDate);
//		LocalDate local = DateUtils.cvrtUtilToLocalDate(date);
//		
//		Calendar cal = Calendar.getInstance();
//		Date currentDate = cal.getTime();
//		
//		if (date.after(currentDate)) {
//			System.out.println(date + " after " + currentDate);
//		}else {
//			System.out.println(date + " before " + currentDate);
//		}
//		
//		LocalDate currentDate1 = LocalDate.now();
//		System.out.println(currentDate1);
//		
//		if (local.isAfter(currentDate1) || local.isEqual(currentDate1)) {
//			System.out.println(local + " after " + currentDate1);
//		}else {
//			System.out.println(local + " before " + currentDate1);
//		}
//		
//		System.out.println(local.isEqual(currentDate1));
		
//		String test = "IMfgfasjkfakfajf";
//		try {
//			System.out.println(Validator.isCheckFullName(test));
//		} catch (CommonException e) {
//			System.out.println(e.getMessage());
//		}

//		String str = "0905123456";
//		System.out.println(Validator.isValidPhone(str));
//		
		Date date1 = new Date(2023, 10, 2);
        Date date2 = new Date(2023, 10, 10);

        long time1 = date1.getTime();
        long time2 = date2.getTime();

        long difference = time2 - time1;
        System.out.println(difference / (24 * 60 * 60 * 1000));
        if (difference / (24 * 60 * 60 * 1000) == 7) {
            System.out.println("Date1 is 1 week after Date2");
        } else {
            System.out.println("Date1 is not 1 week after Date2");
        }
		
	}
	
}