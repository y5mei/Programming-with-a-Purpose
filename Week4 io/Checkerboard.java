/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class Checkerboard {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        StdDraw.setScale(0, n);

        double radius = 0.5;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
                if ((i + j) % 2 == 0) {
                    StdDraw.setPenColor(StdDraw.BLUE);
                }
                StdDraw.filledSquare(i + 0.5, j + 0.5, radius);
            }
        }

    }
}
