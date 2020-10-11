/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class AudioCollage {

    // Returns a new array that rescales a[] by a multiplicative factor of alpha.
    public static double[] amplify(double[] a, double alpha) {
        int n = a.length;
        if (alpha > 0) {
            for (int i = 0; i < n; i++) {
                a[i] = alpha * a[i];
            }
        }
        return a;

    }

    // Returns a new array that is the reverse of a[].
    public static double[] reverse(double[] a) {
        double[] r = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            r[a.length - 1 - i] = a[i];
        }
        return r;
    }

    // Returns a new array that is the concatenation of a[] and b[].
    public static double[] merge(double[] a, double[] b) {
        double[] newsound = new double[a.length + b.length];
        for (int i = 0; i < a.length; i++) {
            newsound[i] = a[i];
        }
        for (int j = 0; j < b.length; j++) {
            newsound[a.length + j] = b[j];
        }
        return newsound;
    }

    // Returns a new array that is the sum of a[] and b[],
    // padding the shorter arrays with trailing 0s if necessary.
    public static double[] mix(double[] a, double[] b) {
        int newlength = Math.max(a.length, b.length);
        double[] newsound = new double[newlength];
        for (int i = 0; i < a.length; i++) {
            newsound[i] += a[i];
        }
        for (int j = 0; j < b.length; j++) {
            newsound[j] += b[j];
        }
        return newsound;
    }

    // Returns a new array that changes the speed by the given factor.
    public static double[] changeSpeed(double[] a, double alpha) {
        int newlength = (int) (a.length / alpha);
        double[] newsound = new double[newlength];
        for (int i = 0; i < newlength; i++) {
            newsound[i] = a[(int) (i * alpha)];
        }
        return newsound;
    }


    // Creates an audio collage and plays it on standard audio.
    // See below for the requirements.
    public static void main(String[] args) {
        double[] sampleone = StdAudio.read("cow.wav");
        double[] sampletwo = StdAudio.read("harp.wav");
        double[] samplethree = StdAudio.read("piano.wav");
        double[] samplefour = StdAudio.read("scratch.wav");
        double[] samplefive = StdAudio.read("singer.wav");
        double[] sample1 = reverse(sampleone);
        double[] sample2 = merge(samplethree, sampletwo);
        double[] sample3 = mix(samplefour, samplefive);
        double[] sample4 = merge(sample3, sample2);
        double[] sample5 = merge(sample4, sample1);
        double[] sample6 = changeSpeed(sample5, 1.2);
        double[] sample7 = amplify(sample6, 0.2);
        StdAudio.play(sample7);
    }
}
