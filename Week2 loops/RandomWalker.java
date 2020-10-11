/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class RandomWalker {
    public static void main(String[] args) {
        int r = Integer.parseInt(args[0]);
        int ran = (int) (1 + Math.random() * (4 - 1 + 1));
        int step = 0;

        int x = 0;
        int y = 0;
        System.out.println("( " + x + ", " + y + ")");
        while (Math.abs(x) + Math.abs(y) - r != 0) {
            if (ran == 1) {
                x = x + 1;
            }
            else if (ran == 2) {
                x = x - 1;
            }
            else if (ran == 3) {
                y = y + 1;
            }
            else {
                y = y - 1;
            }
            System.out.println("( " + x + ", " + y + ")");
            ran = (int) (1 + Math.random() * (4 - 1 + 1));
            step = step + 1;

        }
        System.out.println("steps = " + step);
    }
}
