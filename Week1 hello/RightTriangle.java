/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

public class RightTriangle {
    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        int c = Integer.parseInt(args[2]);
        int mymax = Math.max(Math.max(a, b), Math.max(a, c));
        int mymin = Math.min(Math.min(a, b), Math.min(a, c));
        int mymid = a + b + c - mymax - mymin;
        boolean result = false;

        boolean checkPositive = mymin > 0;
        boolean checkSquare = mymax * mymax == mymin * mymin + mymid * mymid;
        result = checkPositive && checkSquare;

        System.out.println(result);

    }
}
