/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class WorldMap {
    public static void main(String[] args) {
        int w = StdIn.readInt();
        int h = StdIn.readInt();
        int nvertices;
        String name;

        StdDraw.setCanvasSize(w, h);
        StdDraw.setXscale(0, w);
        StdDraw.setYscale(0, h);

        while (!StdIn.isEmpty()) {
            name = StdIn.readString();
            // name = StdIn.readString();
            nvertices = StdIn.readInt();
            double[] x = new double[nvertices];
            double[] y = new double[nvertices];
            for (int i = 0; i < nvertices; i++) {

                x[i] = StdIn.readDouble();
                y[i] = StdIn.readDouble();
            }
            StdDraw.polygon(x, y);

        }


    }
}
