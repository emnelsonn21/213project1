import java.util.Calendar

public class Date implements Comparable<Date> {
	private int year;
	private int month;
	private int day;
	
	//absolutely no idea if this is even remotely correct
	public Date(String date) {
		StringTokenizer tokens = new StringTokenizer(date, "/")
		day = tokens.nextToken;
		month = tokens.nextToken;
		year = tokens.nextToken;
		
		Calendar calendar = Calendar.getInstance();
		calendar.clear;
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month);
		calendar.set(Calendar.DATE, day);
	
	}
	
	public Date() {
		Calendar calendar = Calendar.getInstance();
	}
	
	public boolean isValid() {}
	
	@Override
	public int compareTo(Date date) {}
}
