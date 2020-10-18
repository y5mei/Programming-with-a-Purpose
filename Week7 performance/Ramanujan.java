public class Ramanujan {


    private static long power3(long a) {
        return a * a * a;
    }

    // Is n a Ramanujan number?
    public static boolean isRamanujan(long n) {
        if (n < 1729) return false;
        long m = (long) Math.floor(Math.cbrt(n));
        int count = 0;

        long left = 1;
        long right = m;
        long testnum = 0;

        while (left < right) {
            testnum = power3(left) + power3(right);
            // System.out.println("test for " + left + "  **  " + right + "result is " + testnum);

            if (testnum == n) {
                count += 1;
                if (count == 2) return true;
            }
            else if (testnum > n) {
                right -= 1;
                continue;
            }
            else {
                left += 1;
                continue;
            }
            left += 1;
            right -= 1;
        }
        return false;
    }

    // Takes a long integer command-line arguments n and prints true if
    // n is a Ramanujan number, and false otherwise.
    public static void main(String[] args) {
        long n = Long.parseLong(args[0]);
        System.out.print(isRamanujan(n));

    }
}
