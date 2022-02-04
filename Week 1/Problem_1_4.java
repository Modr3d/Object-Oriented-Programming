import java.util.Scanner;

public class Problem_1_4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.printf("Enter weight in pounds: "); // Input Weight
        double weight = input.nextDouble();
        System.out.printf("Enter height in inches: "); // Input Height
        double height = input.nextDouble();
        double sum = ((weight * 0.45359237) / (Math.pow(height * 0.0254, 2))); // Calculate

        System.out.printf("BMI is %.4f", sum); // Display
        input.close();
    }
}