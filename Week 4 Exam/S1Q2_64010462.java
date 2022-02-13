import java.util.Scanner;

public class S1Q2_64010462 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] character = new int[5], checkChar = { 97, 98, 99, 100, 101, 102, 103, 104, 105, 106 };
        int[] number = new int[5], checkNum = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        int countChar = 0, countNum = 0;
        int rand = (int) (Math.random() * 2) + 1;

        System.out.print("Random charactes are : ");
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                character[countChar] = (int) (Math.random() * 10) + 97;
                countChar++;
            } else {
                number[countNum] = (int) (Math.random() * 10);
                countNum++;
            }
        }

        for (int i = 0; i < 5; i++) {
            if (rand == 1) {
                System.out.print((char) (character[i]) + " ");
                System.out.print(number[i] + " ");
            }
            if (rand == 2) {
                System.out.print(number[i] + " ");
                System.out.print((char) (character[i]) + " ");
            }
        }
        System.out.print("\n" + "Select group of characters [1] character or [2] numeric : ");
        int group = input.nextInt();

        if (group < 1 || group > 2) {
            System.out.print("Please input number 1 or 2.");
            input.close();
            return;
        }

        if (group == 1) {
            for (int i = 0; i < 5; i++)
                for (int j = 0; j < 10; j++)
                    if (character[i] == checkChar[j])
                        checkChar[j] = 0;

            System.out.print("Characters not in the list are : ");
            for (int i = 0; i < 10; i++) {
                if (checkChar[i] != 0)
                    System.out.print((char) (checkChar[i]) + " ");
            }
        } else {
            for (int i = 0; i < 5; i++)
                for (int j = 0; j < 10; j++)
                    if (number[i] == checkNum[j])

                        checkNum[j] = -1;

            System.out.print("Numerics not in the list are : ");
            for (int i = 0; i < 10; i++) {
                if (checkNum[i] != -1)
                    System.out.print(checkNum[i] + " ");
            }
        }
        System.out.print("\n" + "End of program.");
        input.close();
    }
}