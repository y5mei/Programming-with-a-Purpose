/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class Q45 {
    public static String method3(int n) {
        if (n == 0) return "";
        if (n == 1) return "x";
        return method3(n / 2) + method3(n - n / 2);
    }

    public static void main(String[] args) {
        System.out.println(method3(100));

    }
}

