import java.util.GregorianCalendar;

public class Problem_4_2_1 {
    public static void main(String[] args) {

        GregorianCalendar cld = new GregorianCalendar();
        System.out.println("Current year, month, date, and day of week");
        System.out.println("Year is " + cld.get(GregorianCalendar.YEAR));
        System.out.println("Month is " + cld.get(GregorianCalendar.MONTH));
        System.out.println("Date is " + cld.get(GregorianCalendar.DATE));
        System.out.println("Day of week is " + cld.get(GregorianCalendar.DAY_OF_WEEK));

        cld.setTimeInMillis(cld.getTimeInMillis() + 86400000);
        System.out.println("------------");
        System.out.println("After specified the elapsed time of one day after current day");
        System.out.println("Year is " + cld.get(GregorianCalendar.YEAR));
        System.out.println("Month is " + cld.get(GregorianCalendar.MONTH));
        System.out.println("Date is " + cld.get(GregorianCalendar.DATE));
        System.out.println("Day of week is " + cld.get(GregorianCalendar.DAY_OF_WEEK));
        System.out.println(cld.getTime());

    }
}