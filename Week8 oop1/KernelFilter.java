/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

import java.awt.Color;

public class KernelFilter {

    // Returns a new picture that applies the identity filter to the given picture.
    public static Picture identity(Picture picture) {
        double[][] weights = {
                { 0, 0, 0 },
                { 0, 1, 0 },
                { 0, 0, 0 }
        };
        int renormalized = 1;
        return kernel(picture, weights, renormalized);
    }

    // Returns a new picture that applies a Gaussian blur filter to the given picture.
    public static Picture gaussian(Picture picture) {
        double[][] weights = {
                { 1, 2, 1 },
                { 2, 4, 2 },
                { 1, 2, 1 }
        };
        int renormalized = 16;
        return kernel(picture, weights, renormalized);
    }

    // Returns a new picture that applies a sharpen filter to the given picture.
    public static Picture sharpen(Picture picture) {

        Picture res = new Picture(picture.width(), picture.height());
        for (int y = 0; y < picture.height(); y++)
            for (int x = 0; x < picture.width(); x++) {
                double[] pix = new double[3];

                // Java 是大傻子啊，-1%5 = -1 啊， python 里 等于4 等于的好好的啊！！！
                // 取余咋能取出负值来啊！！！
                Color color = picture.get(x, y);
                Color c1 = picture.get((x + 1) % picture.width(), y % picture.height());
                Color c2 = picture
                        .get((x - 1 + picture.width()) % picture.width(), y % picture.height());
                Color c3 = picture.get(x % picture.width(), (y + 1) % picture.height());
                Color c4 = picture
                        .get(x % picture.width(), (y - 1 + picture.height()) % picture.height());
                pix[0] = color.getRed() * 5 - c1.getRed() - c2.getRed() - c3.getRed() - c4.getRed();
                pix[1] = color.getGreen() * 5 - c1.getGreen() - c2.getGreen() - c3.getGreen() - c4
                        .getGreen();
                pix[2] = color.getBlue() * 5 - c1.getBlue() - c2.getBlue() - c3.getBlue() - c4
                        .getBlue();


                int[] rgb = new int[3];
                rgb[0] = (int) Math.round(pix[0]);
                rgb[1] = (int) Math.round(pix[1]);
                rgb[2] = (int) Math.round(pix[2]);

                for (int i = 0; i < 3; i++) {
                    if (rgb[i] < 0) rgb[i] = 0;
                    if (rgb[i] > 255) rgb[i] = 255;
                }

                res.set(x, y, new Color(rgb[0], rgb[1], rgb[2]));

            }
        return res;
    }

    // Returns a new picture that applies an Laplacian filter to the given picture.
    public static Picture laplacian(Picture picture) {
        double[][] weights = {
                { -1, -1, -1 },
                { -1, 8, -1 },
                { -1, -1, -1 }
        };
        int renormalized = 1;
        return kernel(picture, weights, renormalized);

    }

    // Returns a new picture that applies an emboss filter to the given picture.
    public static Picture emboss(Picture picture) {
        // double[][] weights = { { 0, -1, 0 }, { -1, 5, -1 }, { 0, -1, 0 } };
        double[][] weights = {
                { -2, -1, 0 },
                { -1, 1, 1 },
                { 0, 1, 2 }
        };
        int renormalized = 1;
        return kernel(picture, weights, renormalized);

    }

    // Returns a new picture that applies a motion blur filter to the given picture.
    public static Picture motionBlur(Picture picture) {
        double[][] weights = new double[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (i == j) {
                    weights[i][j] = 1;

                }
                else {
                    weights[i][j] = 0;
                }
            }

        }
        int renormalized = 9;
        return kernel(picture, weights, renormalized);

    }

    // Returns a new picture that applies an arbitrary kernel filter to the given picture.
    private static Picture kernel(Picture picture, double[][] weights, int renormalized) {
        Picture res = new Picture(picture.width(), picture.height());

        for (int y = 0; y < picture.height(); y++) {
            for (int x = 0; x < picture.width(); x++) {

                double[] pix = new double[3]; //初始化一个颜色list R G B
                // System.out.println(" this is point" + x + "/" + y);
                // find all the neighboor of pixel x,y
                for (int r = 0; r < weights.length; r++) {
                    for (int c = 0; c < weights[0].length; c++) {
                        Color color = picture
                                .get((x + picture.width() + c - weights[0].length / 2) % picture
                                             .width(),
                                     (y + picture.height() + r - weights.length / 2) % picture
                                             .height());
                        // System.out.print(
                        //         "*" + (x + picture.width() + c - weights[0].length / 2) % picture
                        //                 .width() + "/"
                        //                 + (y + picture.height() + r - weights.length / 2) % picture
                        //                 .height() + "-");
                        pix[0] += color.getRed() * weights[c][r] / renormalized;
                        pix[1] += color.getGreen() * weights[c][r] / renormalized;
                        pix[2] += color.getBlue() * weights[c][r] / renormalized;


                    }
                }
                // Round up to a integer
                int[] rgb = new int[3];
                rgb[0] = (int) Math.round(pix[0]);
                rgb[1] = (int) Math.round(pix[1]);
                rgb[2] = (int) Math.round(pix[2]);

                for (int i = 0; i < 3; i++) {
                    if (rgb[i] < 0) rgb[i] = 0;
                    if (rgb[i] > 255) rgb[i] = 255;
                }

                // Draw the pixel
                res.set(x, y, new Color(rgb[0], rgb[1], rgb[2]));


            }
        }
        return res;
    }

    // Test client (ungraded).
    public static void main(String[] args) {
        Picture pic = new Picture(args[0]);
        sharpen(pic).show();
        identity(pic).show();
        gaussian(pic).show();
        laplacian(pic).show();
        emboss(pic).show();
        motionBlur(pic).show();


    }

}
