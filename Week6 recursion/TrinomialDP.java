/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class TrinomialDP {
    // Returns the trinomial coefficient T(n, k).
    public static long trinomial(int n, int k) {
        if (n == 0 && k == 0) {
            return 1;
        }
        if (k > n || k < -n) {
            return 0;
        }
        // Calculate the Trainagle
        long[] dp = new long[n + 2];


        for (int i = 0; i < n; i++) {
            long zero = 0;
            long temp = 0;
            long pre = 0;
            long cur = 0;
            for (int j = n + 1; j >= 0; j--) {
                if (j > i) {
                    dp[j] = 0;
                    zero = dp[0] + dp[1] * 2;
                    continue;
                }
                if (i == 0 && j == 0) {
                    dp[j] = 1;
                    continue;
                }
                if (i >= j) {
                    if (j == 0) {
                        dp[0] = zero;
                    }
                    else {
                        // System.out.println(i + "   " + j + "___" + temp + "  " + pre + "  " + cur);
                        temp = dp[j];
                        dp[j] = pre + cur + dp[j - 1];
                        pre = temp;
                        cur = dp[j - 1];
                        // System.out.println(temp + pre + cur);
                    }

                }
            }
            // System.out.println(Arrays.toString(dp));
        }

        if (k == 0) {
            return dp[0] + 2 * dp[1];
        }
        else {
            if (k < 0) {
                k = -k;
            }
            return dp[k - 1] + dp[k] + dp[k + 1];
        }


    }

    // Takes two integer command-line arguments n and k and prints T(n, k).
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);
        System.out.println(trinomial(n, k));
    }
}
