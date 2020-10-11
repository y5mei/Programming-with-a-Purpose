/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class ShannonEntropy {
    public static void main(String[] args) {
        // parse command-line arguemnts
        int m = Integer.parseInt(args[0]);
        int[] countx = new int[m + 1];
        int num = 0;
        double h = 0.0;
        int x;
        double p;
        while (!StdIn.isEmpty()) {
            x = StdIn.readInt();
            countx[x] += 1;
            num += 1;
        }
        // calculate p
        for (int i = 1; i <= m; i++) {
            p = (countx[i] + 0.0) / num;
            if (p == 0) continue;
            h -= p * Math.log(p) / Math.log(2);
        }
        StdOut.printf("%.4f\n", h);
    }
}

