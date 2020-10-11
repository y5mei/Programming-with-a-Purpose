/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

// import static java.lang.Math.asin;
// import static java.lang.Math.cos;
// import static java.lang.Math.sin;
// import static java.lang.Math.sqrt;

public class GreatCircle {
    public static void main(String[] args) {
        // Parase arguments from Command line
        double x1 = Math.toRadians(Double.parseDouble(args[0]));
        double y1 = Math.toRadians(Double.parseDouble(args[1]));
        double x2 = Math.toRadians(Double.parseDouble(args[2]));
        double y2 = Math.toRadians(Double.parseDouble(args[3]));
        double r = 6371.0;

        double x = (x2 - x1) / 2.0;
        double y = (y2 - y1) / 2.0;
        double left = java.lang.Math.sin(x) * java.lang.Math.sin(x);
        double right = java.lang.Math.cos(x1) * java.lang.Math.cos(x2) * java.lang.Math.sin(y)
                * java.lang.Math.sin(y);
        double root = java.lang.Math.sqrt(left + right);
        double dist = 2 * r * java.lang.Math.asin(root);
        System.out.println(dist + " kilometers");

    }
}
