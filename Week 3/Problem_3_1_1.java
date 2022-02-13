public class Problem_3_1_1 {
    public static void main(String[] args) {
        int count = 0;

        for (int i = 2; count < 100; i++) {
            if (primeCheck(i) && palindromeCheck(i)) {
                System.out.print(i + " ");
                count++;
                if (count % 10 == 0) {
                    System.out.println();
                }
            }
        }
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