public class Problem_2_Ex_1 {
    static int recursive(int num) {
        if (num == 1)
            return 1;
        else if (num == 2)
            return 3;
        else if (num % 2 != 0)
            return recursive(num - 2) + num - 1;
        else
            return recursive(num - 2) + 3;
    }

    public static void main(String[] args) {
        int max = 20;
        for (int i = 1; i <= max; i++) {
            if (i != max)
                System.out.print(recursive(i) + ", ");
            else
                System.out.print(recursive(i));
        }
    }
}