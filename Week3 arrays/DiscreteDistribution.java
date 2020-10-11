/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class DiscreteDistribution {
    public static void main(String[] args) {

        int m = Integer.parseInt(args[0]);
        int len = args.length - 1;
        int[] s = new int[len + 1];
        s[0] = 0;


        // Generate list of S
        for (int i = 1; i <= len; i++) {
            if (i == 1) {
                s[i] = Integer.parseInt(args[i + 1]);
            }
            else {
                s[i] = s[i - 1] + Integer.parseInt(args[i]);

            }
            // System.out.println(s[i]);

        }

        for (int j = 0; j < m; j++) {
            // generate a random variable, r
            int r = (int) (Math.random() * (s[s.length - 1] - 1));
            // System.out.println("random is " + r);
            // System.out.println("*********");
            for (int k = 0; k < len; k++) {
                if (s[k] <= r && s[k + 1] > r) {
                    System.out.print(k + 1 + " ");
                    break;
                }

            }


        }

    }
}
