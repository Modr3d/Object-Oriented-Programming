import java.util.Scanner;

public class Problem_2_4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String temp;

        System.out.print("Enter the first city: ");
        String city_1 = input.nextLine();
        System.out.print("Enter the second city: ");
        String city_2 = input.nextLine();
        System.out.print("Enter the third city: ");
        String city_3 = input.nextLine();

        if (city_2.compareTo(city_1) < 0 && city_2.compareTo(city_3) < 0) {
            temp = city_1;
            city_1 = city_2;
            city_2 = temp;
        } else if (city_3.compareTo(city_1) < 0 && city_3.compareTo(city_2) < 0) {
            temp = city_1;
            city_1 = city_3;
            city_3 = temp;
        }
        if (city_3.compareTo(city_2) < 0) {
            temp = city_2;
            city_2 = city_3;
            city_3 = temp;
        }

        System.out.print("The three cities in alphabetical order are " + city_1 + " " + city_2 + " " + city_3);
        input.close();
    }
}
