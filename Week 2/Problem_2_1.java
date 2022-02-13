import java.util.Scanner;

public class Problem_2_1 {
    public static void main(String[] args) {
        String[] day = { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };
        Scanner inputDay = new Scanner(System.in);

        System.out.print("Enter today's day: ");
        int firstDay = inputDay.nextInt(), sumDay;

        if (firstDay < 0 || firstDay > 6) {
            System.out.println("Error. Please Enter the correct day ( 0 - 6 )");
            inputDay.close();
            return;
        }

        System.out.print("Enter the number of days elapsed since today: ");
        int upComingDay = inputDay.nextInt();

        if (upComingDay < 0) {
            System.out.println("Error. Please Enter the correct day ( >= 0 )");
            inputDay.close();
            return;
        }

        sumDay = (firstDay + upComingDay) % 7;
        System.out.print("Today is " + day[firstDay] + " and the future day is " + day[sumDay]);
        inputDay.close();
    }
}
