/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class ActivationFunction {

    // Returns the Heaviside function of x.
    public static double heaviside(double x) {
        if (Double.isNaN(x)) return Double.NaN;
        if (x == 0.0) return 0.5;
        if (x < 0.0) return 0.0;
        return 1.0;
    }

    // Returns the sigmoid function of x.
    public static double sigmoid(double x) {
        if (Double.isNaN(x)) return Double.NaN;
        return 1.0 / (1 + Math.exp(-x));
    }

    // Returns the hyperbolic tangent of x.
    public static double tanh(double x) {
        if (Double.isNaN(x)) return Double.NaN;
        if (x > 20) return 1.0;
        if (x < -20) return -1.0;
        double e = Math.exp(x);
        return (e - 1.0 / e) / (e + 1.0 / e);
    }

    // Returns the softsign function of x.
    public static double softsign(double x) {
        if (Double.isNaN(x)) return Double.NaN;
        if (x == Double.POSITIVE_INFINITY) return 1;
        if (x == Double.NEGATIVE_INFINITY) return -1;
        return (x / (1 + Math.abs(x)));

    }

    // Returns the square nonlinearity function of x.
    public static double sqnl(double x) {
        if (Double.isNaN(x)) return Double.NaN;
        if (x <= -2) {
            return -1;
        }
        else if (x < 0) {
            return (x + x * x / 4);
        }
        else if (x < 2) {
            return (x - x * x / 4);
        }
        else {
            return 1;
        }
    }

    // // Takes a double command-line argument x and prints each activation
    // // function, evaluated, in the format (and order) given below.
    public static void main(String[] args) {
        double num = Double.parseDouble(args[0]);
        StdOut.printf("heaviside (%.2f) = %.2f\n", num, heaviside(num));
        StdOut.printf("  sigmoid (%.2f) = %f\n", num, sigmoid(num));
        StdOut.printf("     tanh (%.2f) = %f\n", num, tanh(num));
        StdOut.printf(" softsign (%.2f) = %f\n", num, softsign(num));
        StdOut.printf("     sqnl (%.2f) = %f\n", num, sqnl(num));
    }
}
