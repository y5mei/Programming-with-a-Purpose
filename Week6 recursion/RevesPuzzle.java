/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class RevesPuzzle {
    // Let k denote the integer nearest to n+1−√2n+1.
    // Transfer (recursively) the k smallest discs to a single pole other than the start or destination poles.
    // Transfer the remaining n−k disks to the destination pole (without using the pole that now contains the smallest k discs). To do so, use the algorithm for the 3-pole towers of Hanoi problem.
    // Transfer (recursively) the k smallest discs to the destination pole.
    private static void hanoi(int n, String from, String temp, String to, int k) {
        if (n == 0) {
            return;
        }
        hanoi(n - 1, from, to, temp, k);
        StdOut.println("Move disc " + (n + k) + " from " + from + " to " + to);
        hanoi(n - 1, temp, from, to, k);
    }

    private static void reves(int n, String from, String temp1, String temp2, String dist) {
        if (n == 0) return;
        int k = (int) Math.round(n + 1 - Math.sqrt(2 * n + 1));

        reves(k, from, dist, temp2, temp1);
        hanoi(n - k, from, temp2, dist, k);
        reves(k, temp1, from, temp2, dist);

    }


    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        reves(n, "A", "B", "C", "D");
    }
}
