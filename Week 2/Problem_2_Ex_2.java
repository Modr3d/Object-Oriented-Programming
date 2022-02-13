public class Problem_2_Ex_2 {
    public static void main(String[] args) {
        int max = 10;
        int[] arr = new int[max];
        arr[0] = 1;
        arr[1] = 3;
        for (int i = 0; i < max; i++) {
            if (i != 0 && i != 1) {
                if ((i + 1) % 2 == 0)
                    arr[i] = arr[i - 2] + 3;
                else
                    arr[i] = arr[i - 2] + i;
            }
            if (i != max - 1)
                System.out.print(arr[i] + ", ");
            else
                System.out.print(arr[i]);
        }
    }
}