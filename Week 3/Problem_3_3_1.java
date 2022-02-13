import java.util.Scanner;

public class Problem_3_3_1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int row = 0, column = 0;
        boolean diag = false;

        System.out.print("Enter the size for the matrix: ");
        int size = input.nextInt();

        if (size < 2) {
            System.out.print("Input Error. The size must be more than 1 ( >= 2 )");
            input.close();
            return;
        }
        int[][] matrix = new int[size][size];

        // Create and Display Matrix
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = (int) (Math.random() * 2);
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }

        // Row Check
        for (int i = 0; i < 2; i++)
            for (int j = 0; j < size; j++)
                if (rowCheck(matrix, j, i) == true) {
                    System.out.println("All " + i + "s " + "on row " + j);
                    row++;
                }

        if (row == 0)
            System.out.println("No same numbers on a row");

        // Column Check
        for (int i = 0; i < 2; i++)
            for (int j = 0; j < size; j++)
                if (columnCheck(matrix, j, i) == true) {
                    System.out.println("All " + i + "s " + "on column " + j);
                    column++;
                }

        if (column == 0)
            System.out.println("No same numbers on a column");

        // SuperDiagonal Check
        if (superDiagonal(matrix, 0) || superDiagonal(matrix, 1)) {
            System.out.printf("Superdiagonal 0s : %s\n", superDiagonal(matrix, 0) ? "true" : "false");
            System.out.printf("Superdiagonal 1s : %s\n", superDiagonal(matrix, 1) ? "true" : "false");
        } else {
            System.out.println("No same numbers on the superdiagonal");
        }

        // Diagonal Check
        for (int i = 0; i < 2; i++)
            if (diagonal(matrix, i)) {
                System.out.printf("Diagonal %ds : %s\n", i, diagonal(matrix, i) ? "true" : "false");
                diag = true;
            }
        for (int i = 0; i < 2; i++)
            if (secondaryDiagonal(matrix, i)) {
                System.out.printf("Secondary Diagonal %ds : %s\n", i, secondaryDiagonal(matrix, i) ? "true" : "false");
                diag = true;
            }

        if (diag == false)
            System.out.println("No same numbers on the diagonal");

        // SubDiagonal Check
        if (subDiagonal(matrix, 0) || subDiagonal(matrix, 1)) {
            System.out.printf("Subdiagonal 0s : %s\n", subDiagonal(matrix, 0) ? "true" : "false");
            System.out.printf("Subdiagonal 1s : %s\n", subDiagonal(matrix, 1) ? "true" : "false");
        } else {
            System.out.println("No same numbers on the subdiagonal");
        }

        input.close();
    }

    public static boolean rowCheck(int[][] matrix, int row, int num) {

        for (int i = 0; i < matrix[row].length; i++)
            if (matrix[row][i] != num)
                return false;
        return true;

    }

    public static boolean columnCheck(int[][] matrix, int column, int num) {

        for (int i = 0; i < matrix.length; i++)
            if (matrix[i][column] != num)
                return false;
        return true;

    }

    public static boolean superDiagonal(int[][] matrix, int num) {

        for (int i = 0; i < matrix.length - 1; i++)
            if (matrix[i][i + 1] != num)
                return false;
        return true;

    }

    public static boolean diagonal(int[][] matrix, int num) {

        for (int i = 0; i < matrix.length; i++)
            if (matrix[i][i] != num)
                return false;
        return true;

    }

    public static boolean secondaryDiagonal(int[][] matrix, int num) {

        for (int i = matrix.length - 1; i >= 0; i--)
            if (matrix[i][matrix.length - i - 1] != num)
                return false;
        return true;

    }

    public static boolean subDiagonal(int[][] matrix, int num) {

        for (int i = 1; i < matrix.length; i++)
            if (matrix[i][i - 1] != num)
                return false;
        return true;

    }
}