public class Inversions {

    // Return the number of inversions in the permutation a[].
    // Backtracking DP solution
    public static long count(int[] a) {
        int l = a.length;
        if (l <= 1) return 0;
        if (l == 2) {
            if (a[1] > a[0]) return 0;
            return 1;
        }

        int[] localmin = new int[l];
        int currentmin = a[l - 1];
        long count = 0;

        // generate DP table
        for (int i = l - 2; i >= 0; i--) {
            //            System.out.println(i + " " + currentmin + " " + a[i + 1]);
            currentmin = Math.min(currentmin, a[i + 1]);
            localmin[i] = currentmin;
        }
        //        System.out.println(Arrays.toString(localmin));

        for (int x = 0; x < l; x++) {
            // if not in order, we count
            if (a[x] > localmin[x]) {
                for (int y = x; y < l; y++) {
                    if (a[y] < a[x]) count += 1;

                }
            }
        }
        return count;

    }

    // Return a permutation of length n with exactly k inversions.
    public static int[] generate(int n, long k) {
        int[] result = new int[n];
        if (n == 0) return result;
        // Base Case
        if (k <= n - 1) {
            // Mid
            result[(int) (n - k - 1)] = n - 1;
            // Left
            for (int i = 0; i < n - k - 1; i++) {
                result[i] = i;

            }
            // Right
            for (int i = (int) (n - k); i < n; i++) {
                result[i] = i - 1;

            }
        }
        else {
            result = appendArray(n - 1, generate(n - 1, k - n + 1));

        }

        return result;

    }

    // appendArray append an int a to the begining of int array b
    // and return the appended array
    private static int[] appendArray(int a, int[] b) {
        int l = b.length;
        int[] append = new int[l + 1];
        append[0] = a;
        for (int i = 1; i <= l; i++) {
            append[i] = b[i - 1];
        }
        return append;
    }

    private static int[] listgen(int n) {
        // int n = 65536;
        int[] res = new int[n];
        int i = 0;
        while (n > 1) {
            res[i] = n;
            i++;
            n--;
        }
        return res;
    }

    // Takes an integer n and a long k as command-line arguments,
    // and prints a permutation of length n with exactly k inversions.
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        long k = Long.parseLong(args[1]);

        int[] mylist = generate(n, k);
        for (int i : mylist) {
            System.out.print(i + " ");
        }

        // long r = count(listgen(65537));
        // System.out.println(r + " ");

    }
}
