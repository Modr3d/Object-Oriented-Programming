import java.util.Scanner;

public class Problem_2_3 {
    public static void main(String[] args) {
        String[] dayList = { "Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday" };
        Scanner input = new Scanner(System.in);
        System.out.printf("Enter year: ");
        int year = input.nextInt();
        if (year < 0) {
            System.out.print("Error. Please Enter the correct year ( >= 0 )");
            input.close();
            return;
        }
        System.out.print("Enter month: ");
        int month = input.nextInt();
        if (month < 1 || month > 12) {
            System.out.print("Error. Please Enter the correct month ( 1 - 12 )");
            input.close();
            return;
        }
        System.out.print("Enter day of the month: ");
        int day = input.nextInt();
        if ((day < 1 || day > 31) || (day > 29 && month == 2)
                || (day > 28 && month == 2 && (year % 4 != 0 || year % 100 == 0) && year % 400 != 0)
                || (day > 30 && (month == 4 || month == 6 || month == 9 || month == 11))) {
            System.out.print("Error. Please Enter the correct day");
            input.close();
            return;
        }

        if (month == 1 || month == 2) {
            if (month == 1)
                month = 13;
            else
                month = 14;
            year--;
        }

        int outputDay = (day + (26 * (month + 1) / 10) + (year % 100) + (year % 100) / 4 + (year / 100 / 4)
                + 5 * (year / 100)) % 7;

        System.out.print("The day of the week is " + dayList[outputDay] + ".");
        input.close();
    }
}