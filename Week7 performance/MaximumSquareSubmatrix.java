public class MaximumSquareSubmatrix {

    // Returns the size of the largest contiguous square submatrix
    // of a[][] containing only 1s.
    // This is actually a leetcode question
    //    https://leetcode.com/problems/maximal-square/discuss/600149/Python-Thinking-Process-Diagrams-DP-Approach
    public static int size(int[][] a) {
        int n = a.length;
        int[] temp = new int[3];
        int result = 0;
        for (int y = 0; y < n; y++) {
            // System.out.println(" ");
            for (int x = 0; x < n; x++) {
                if (x == 0 || y == 0) continue;
                if (a[x][y] == 0) continue;
                temp[0] = a[x - 1][y - 1];
                temp[1] = a[x][y - 1];
                temp[2] = a[x - 1][y];

                a[x][y] = Math.min(Math.min(temp[0], temp[1]), temp[2]) + 1;
                result = Math.max(result, a[x][y]);
                // System.out.print(a[x][y] + " ");

            }

        }
        return result;
    }

    // Reads an n-by-n matrix of 0s and 1s from standard input
    // and prints the size of the largest contiguous square submatrix
    // containing only 1s.
    public static void main(String[] args) {
        int n = StdIn.readInt();
        int[][] m = new int[n][n];
        int result = 0;

        for (int y = 0; y < n; y++) {
            // System.out.println(" ");
            for (int x = 0; x < n; x++) {
                m[x][y] = StdIn.readInt();
                // System.out.print(m[x][y] + " ");
            }
        }
        // System.out.println(" ");
        System.out.println(size(m));
    }
}
