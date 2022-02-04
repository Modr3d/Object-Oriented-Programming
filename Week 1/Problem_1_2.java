import java.util.Scanner;

public class Problem_1_2 {
    public static void main(String[] args) {
        Scanner Value = new Scanner(System.in);
        System.out.printf("Enter the Value of a : "); // Input Value
        double a = Value.nextDouble();
        System.out.printf("Enter the Value of b : ");
        double b = Value.nextDouble();
        System.out.printf("Enter the Value of c : ");
        double c = Value.nextDouble();
        System.out.printf("Enter the Value of d : ");
        double d = Value.nextDouble();
        System.out.printf("Enter the Value of e : ");
        double e = Value.nextDouble();
        System.out.printf("Enter the Value of f : ");
        double f = Value.nextDouble();

        double x = (e * d - b * f) / (a * d - b * c); // Calculate
        double y = (a * f - e * c) / (a * d - b * c);
        System.out.printf("The Value of x : %f\n", x); // Display
        System.out.printf("The Value of y : %f", y);
        Value.close();
    }
}