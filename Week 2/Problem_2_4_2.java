import java.util.Arrays;
import java.util.Scanner;

public class Problem_2_4_2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] city = new String[3];;

        System.out.print("Enter the first city: ");
        city[0] = input.nextLine();
        System.out.print("Enter the second city: ");
        city[1] = input.nextLine();
        System.out.print("Enter the third city: ");
        city[2] = input.nextLine();

        Arrays.sort(city);

        System.out.print("The three cities in alphabetical order are " + city[0] + " " + city[1] + " " + city[2]);
        input.close();
    }
}
