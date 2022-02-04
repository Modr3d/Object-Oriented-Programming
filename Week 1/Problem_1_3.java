import java.util.*;

public class Problem_1_3 {
    public static void main(String[] args) {
        int result = 0;
        Scanner input = new Scanner(System.in);
        System.out.printf("Enter a number between 0 and 1000: ");
        int sum = input.nextInt();
        if (sum < 0 || sum > 1000)
            System.out.printf("Out of Range ( 0 - 1000 )");
        else {
            result += sum % 10;
            result += sum % 100 / 10;
            result += sum % 1000 / 100;
            result += sum / 1000;

            System.out.printf("The sum of the digits is %d", result);
            input.close();
        }
    }
}