import java.util.Scanner;

public class S1Q1_64010462 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean check = false;

        System.out.print("Input size of matrix : ");
        int size = input.nextInt();

        if (size < 4) {
            input.close();
            return;
        }

        int[][] matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = (int) (Math.random() * 10);
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        System.out.print("Please input value of Row and Columnn : ");
        int row = input.nextInt();
        int column = input.nextInt();

        System.out.println("The selected member is " + matrix[row][column]);
        System.out.print("(i) Members on Top : ");
        for (int i = row - 1; i >= 0; i--) {
            check = true;
            if (i != 0)
                System.out.print(matrix[i][column] + ", ");
            else
                System.out.print(matrix[i][column]);
        }
        if (check == false)
            System.out.print("NO");
        check = false;

        System.out.print("\n" + "(ii) Members on the Right Hand Side : ");
        for (int i = column + 1; i < size; i++) {
            check = true;
            if (i != size - 1)
                System.out.print(matrix[row][i] + ", ");
            else
                System.out.print(matrix[row][i]);
        }
        if (check == false)
            System.out.print("NO");
        check = false;

        System.out.print("\n" + "(iii) Members on the Bottom : ");
        for (int i = row + 1; i < size; i++) {
            check = true;
            if (i != size - 1)
                System.out.print(matrix[i][column] + ", ");
            else
                System.out.print(matrix[i][column]);
        }
        if (check == false)
            System.out.print("NO");
        check = false;

        System.out.print("\n" + "(iiii) Members on the Left Hand Side : ");
        for (int i = column - 1; i >= 0; i--) {
            check = true;
            if (i != 0)
                System.out.print(matrix[row][i] + ", ");
            else
                System.out.print(matrix[row][i]);
        }
        if (check == false)
            System.out.print("NO");
        check = false;

        System.out.println("\n" + "End of program.");
        input.close();
    }
}