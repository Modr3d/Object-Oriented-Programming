import java.util.Arrays;
import java.util.Scanner;

public class Problem_3_2_1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Input List 1
        System.out.print("Enter list1: ");
        String strNum = input.nextLine();
        String[] temp = strNum.split(" ");

        int[] list1 = new int[temp.length];

        for (int i = 0; i < temp.length; i++)
            list1[i] = Integer.parseInt(temp[i]);

        // Input List 2
        System.out.print("Enter list2: ");
        strNum = input.nextLine();
        temp = strNum.split(" ");

        int[] list2 = new int[temp.length];

        for (int i = 0; i < temp.length; i++)
            list2[i] = Integer.parseInt(temp[i]);

        // Merge and Print
        int[] list3 = merge(list1, list2);

        System.out.print("The merged list is ");
        for (int i = 0; i < list3.length; i++)
            System.out.print(list3[i] + " ");

        input.close();
    }

    public static int[] merge(int[] list1, int[] list2) {
        int[] list3 = new int[list1.length + list2.length];

        for (int i = 0; i < list1.length; i++)
            list3[i] = list1[i];

        for (int i = list1.length; i < list1.length + list2.length; i++)
            list3[i] = list2[i - list1.length];

        Arrays.sort(list3);
        return list3;
    }
}