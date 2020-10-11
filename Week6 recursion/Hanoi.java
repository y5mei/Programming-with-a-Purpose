/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class Hanoi {
    // move n smallest discs from one pole to another, using the temp pole
    private static void hanoi(int n, String from, String temp, String to) {
        System.out.println("We are going to move " + n + " disc from " + from + " to " + to);
        if (n == 0) {
            // System.out.println("Disc " + from + " is empty");
            return;
        }
        // move the 1st n-1 disc to the temp pole 1st
        hanoi(n - 1, from, to, temp);
        System.out.println("Move Disc from " + n + " from " + from + " to " + to);
        // Then move the n-1 disc from temp pole to the final pole
        hanoi(n - 1, temp, from, to);
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        hanoi(n, "A", "B", "C");

    }
}
