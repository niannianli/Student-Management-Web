import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateDemo {

	public static void main(String[] args) {

		Date date = new Date();
		// we can use Date constructor
		// but use Calendar is better

		// static method
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, 1989);
		// 0-11
		calendar.set(Calendar.MONTH, 1);
		calendar.set(Calendar.DAY_OF_MONTH, 23);
		Date date1 = calendar.getTime();
		System.out.println(date1);
		System.out.println(Calendar.DAY_OF_WEEK);

		// how to print date not time?
		System.out.println(date);

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println(dateFormat.format(date));
	}

	// use calendar to tell day diff, month diff, year diff
	// Integer dayDiff(Date d1, Date d2){
	// }

	// check calendar class

	// delete, spring: same project in maven

}
