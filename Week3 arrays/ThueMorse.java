/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class ThueMorse {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int[] thue = new int[n];
        // Generate a Morse Array
        thue[0] = 0;
        for (int i = 1; i < thue.length; i++) {
            if ((i & 1) == 1) {
                // if i is odd
                thue[i] = 1 - thue[i - 1];
            }
            else {
                thue[i] = thue[i / 2];
            }
        }

        // Generate the array

        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                if (thue[x] == thue[y]) {
                    System.out.print("+  ");
                }
                else {
                    System.out.print("-  ");
                }

            }
            System.out.println(" ");

        }
    }
}

