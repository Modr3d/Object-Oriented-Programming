public class Problem_4_3_1 {
    public static void main(String[] args) {

        double[] array = new double[1000];

        System.out.println("Creating a list containing 1000 elements,");
        for (int i = 0; i < 1000; i++) {
            array[i] = Math.random() * 1000;
            if (i % 5 == 0)
                System.out.println();
            System.out.printf("%.2f\t", array[i]);
        }
        System.out.println("\n" + "List created.");
        StopWatch stopwatch = new StopWatch();
        stopwatch.start();
        System.out.print("Sorting stopwatch starts...");
        selectionSort(array);
        stopwatch.stop();

        for (int i = 0; i < 1000; i++) {
            if (i % 5 == 0)
                System.out.println();
            System.out.printf("%.2f\t", array[i]);
        }

        System.out.println("\n" + "Sorting stopwatch stoped.");
        System.out.println("The sort time is " + stopwatch.getElapsedTime() + " milliseconds.");
        System.out.println("------------------------------------------------------------");
        System.out.println("The palindromPrime Stopwatch starts...");
        System.out.println("Creating 1000 PalindromPrime...");

        int count = 0;
        stopwatch.start();
        for (int i = 2; count < 1000; i++) {
            if (palindromeCheck(i) == true && primeCheck(i) == true) {
                System.out.printf("%d ", i);
                count++;
                if (count % 10 == 0)
                    System.out.println();
            }
        }
        stopwatch.stop();
        System.out.println("PalindromePrime created.");
        System.out.println("The palindromPrime stopwatch stoped.");
        System.out.println("The palindromPrime time is " + stopwatch.getElapsedTime() + " milliseconds");
    }

    public static double[] selectionSort(double[] array) {

        double temp;

        for (int i = 0; i < 1000; i++) {
            for (int j = i + 1; j < 1000; j++) {
                if (array[i] > array[j]) {
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }

    public static boolean primeCheck(int num) {

        if (num < 2)
            return false;

        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0)
                return false;
        }

        return true;
    }

    public static boolean palindromeCheck(int num) {
        if (num == reverse(num))
            return true;
        return false;
    }

    public static int reverse(int num) {
        int result = 0;

        while (num > 0) {
            result *= 10;
            result += (num % 10);
            num /= 10;
        }

        return result;
    }
}