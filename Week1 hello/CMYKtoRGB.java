/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

//import static java.lang.Math.round;

public class CMYKtoRGB {
    public static void main(String[] args) {
        // Parase arguments from Command line
        double cyan = Double.parseDouble(args[0]);
        double magenta = Double.parseDouble(args[1]);
        double yellow = Double.parseDouble(args[2]);
        double black = Double.parseDouble(args[3]);

        double white = 1.0 - black;
        long red = java.lang.Math.round(255.0 * white * (1.0 - cyan));
        long green = java.lang.Math.round(255.0 * white * (1.0 - magenta));
        long blue = java.lang.Math.round(255.0 * white * (1.0 - yellow));

        System.out.println("red   = " + red);
        System.out.println("green = " + green);
        System.out.println("blue  = " + blue);

    }
}
