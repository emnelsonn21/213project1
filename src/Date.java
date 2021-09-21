import java.util.Calendar;
import java.util.StringTokenizer;

public class Date implements Comparable<Date> {
	private int year;
	private int month;
	private int day;
	
	public Date(String date) {}
	public Date() {}
	
	
	public Calendar getDate(String dat) {
		StringTokenizer tokenizer = new StringTokenizer(dat, "/");
		if (tokenizer.hasMoreElements()) {
			try {
				month = Integer.valueOf(tokenizer.nextToken());
				day = Integer.valueOf(tokenizer.nextToken());
				year = Integer.valueOf(tokenizer.nextToken());
			}
			catch (NumberFormatException nfe) {
				throw new IllegalArgumentException("invalid date");
		    }
			
			Calendar calendar = Calendar.getInstance();
			calendar.set(Calendar.YEAR, year);
			calendar.set(Calendar.MONTH, month);
			calendar.set(Calendar.DATE, day);
			return calendar;
	    }
		return null;
	}
	
	public boolean isValid() {}
	
	@Override
	public int compareTo(Date date) {}
}
