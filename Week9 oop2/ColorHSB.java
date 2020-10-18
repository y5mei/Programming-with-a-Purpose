/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class ColorHSB {

    // the instance variables must be private, otherwise, people can by pass the
    // Corner Cases to assign the illegal values to them
    private final int hue;
    private final int saturation;
    private final int brightness;

    // Creates a color with hue h, saturation s, and brightness b.
    public ColorHSB(int h, int s, int b) {
        if (h < 0 || h > 359 || s < 0 || s > 100) {
            throw new IllegalArgumentException("Illegal Input");
        }

        hue = h;
        saturation = s;
        brightness = b;

    }

    // Returns a string representation of this color, using the format (h, s, b).
    public String toString() {
        return ("(" + hue + ", " + saturation + ", " + brightness + ")");
    }

    // Is this color a shade of gray?
    public boolean isGrayscale() {
        if (saturation * brightness == 0) return true;
        return false;
    }

    // Returns the squared distance between the two colors.
    public int distanceSquaredTo(ColorHSB that) {
        int a = (this.hue - that.hue) * (this.hue - that.hue);
        int b = (360 - Math.abs(this.hue - that.hue)) * (360 - Math.abs(this.hue - that.hue));
        a = Math.min(a, b) + (this.saturation - that.saturation) * (this.saturation
                - that.saturation)
                + (this.brightness - that.brightness) * (this.brightness - that.brightness);
        return a;

    }

    // Sample client (see below).
    public static void main(String[] args) {

        int h = Integer.parseInt(args[0]);
        int s = Integer.parseInt(args[1]);
        int b = Integer.parseInt(args[2]);
        ColorHSB inputColor = new ColorHSB(h, s, b);

        int minDist = Integer.MAX_VALUE;
        String strDist = "";

        while (!StdIn.isEmpty()) {
            String temp = StdIn.readString();
            int newh = StdIn.readInt();
            int news = StdIn.readInt();
            int newb = StdIn.readInt();
            int myDist = inputColor.distanceSquaredTo(new ColorHSB(newh, news, newb));
            // StdOut.println(" ** " + temp + "___" + myDist);


            // Find the min distance element
            if (myDist < minDist) {
                strDist = temp;
                minDist = myDist;
                h = newh;
                s = news;
                b = newb;
            }
        }
        StdOut.println(strDist + " " + new ColorHSB(h, s, b).toString());

    }

}
