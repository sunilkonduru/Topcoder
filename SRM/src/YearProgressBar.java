import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class YearProgressbar
{
	
	HashMap<String, Integer> monthMap = new HashMap<String, Integer>();
	String[] months = {"January", "February", "March", "April", "May","June","July","August","September","October","November","December"};
	int[] days   = {31,28,31,30,31,30,31,31,30,31,30,31};
	public double percentage(String currentDate)
	{
		String[] parse = currentDate.split(" ");
		
		String month=parse[0];
		int date = Integer.parseInt(parse[1].split(",")[0]);
		int year = Integer.parseInt(parse[2]);
		String time = parse[3];
		int hours = Integer.parseInt(time.split(":")[0]);
		int mins = Integer.parseInt(time.split(":")[1]);
		double mins_hrs = mins/60.0;
		double day = (mins_hrs + (double) hours)/24.0;
		double totalDaysInMonth = date + day - 1;
		int totalDays = 0;
		for(int i=0;i<months.length;i++){
		
		  if(months[i].equals("February")){
		     if(isLeapYear(year)){
		       monthMap.put("February",29);
		       totalDays += 29;
		       continue;
		     }
		  }
		  totalDays  += days[i];
		  monthMap.put(months[i],days[i]);
		}
		
		int monthsBefore = 0;
		
		for(int i=0;!months[i].equals(month);i++){
		  monthsBefore++;
		}
		double count_days = totalDaysInMonth;
		
		for(int i=0;i<monthsBefore;i++){
		  count_days += monthMap.get(months[i]); 
		}
		
		System.out.println(count_days);
		
		return (double)((count_days/(totalDays))*100);
		
		
	}
	
	public boolean isLeapYear(int year){
	  if(year%400==0 ||(year%4==0&&year%100!=0)){
	    return true;
	  }
	  return false;
	}
	
		
}



  static String[] months = { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" };
  static int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
  boolean isLeap(int y) { if (y%400==0) return true; if (y%100==0) return false; if (y%4==0) return true; return false; }
  int daysInMonth(int m, int y) { if (m==2 && isLeap(y)) return 29; return days[m-1]; }
  int getMonth(String name) { for (int i=0; i<12; i++) if (name.equals(months[i])) return i+1; return 0; }

  public double percentage(String currentDate) {
    String[] tokens = currentDate.split("[ ,:]");
    int month = getMonth(tokens[0]);
    int day = Integer.parseInt(tokens[1]);
    int year = Integer.parseInt(tokens[3]);
    int hour = Integer.parseInt(tokens[4]);
    int minute = Integer.parseInt(tokens[5]);

    double daysInYear = 365; if (isLeap(year)) daysInYear += 1;
    double daysElapsed = 0;
    for (int m=1; m<month; m++) daysElapsed += daysInMonth(m,year);
    daysElapsed += day-1;
    daysElapsed += hour / 24.;
    daysElapsed += minute / 24. / 60.;
    return 100 * daysElapsed / daysInYear;
  }

An alter