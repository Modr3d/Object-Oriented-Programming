import java.util.Scanner;

public class Problem_2_5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of lines: ");
        int num = input.nextInt();

        if (num < 0 || num > 15) {
            System.out.print("Error. Please Enter the correct number ( 0 - 15 )");
            input.close();
            return;
        }

        for (int i = 1; i <= num; i++) {
            for (int j = num * 2; j >= 1; j--) {
                if (j < num)
                    if (num + 1 - j <= i)
                        System.out.print(num + 1 - j + " ");
                    else
                        System.out.print("  ");
                else if (j > num)
                    if (j - num <= i)
                        System.out.print(j - num + " ");
                    else
                        System.out.print("  ");
            }
            System.out.print("\n");
        }
        input.close();
    }
}