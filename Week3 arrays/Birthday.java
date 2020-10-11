/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class Birthday {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int trails = Integer.parseInt(args[1]);
        int Birthday = 0;
        boolean[] currentroom = new boolean[n];
        int[] count = new int[n + 2];
        int[] sumcount = new int[n + 2];
        // java Birthday 365 1000000

        // Do experiment trails times
        for (int i = 0; i < trails; i++) {
            for (int j = 0; j <= n + 1; j++) {
                Birthday = (int) (Math.random() * (n));
                if (currentroom[Birthday] == true) {
                    if (count[j] == 0) {
                        count[j] = 1;
                    }
                    else {
                        count[j] += 1;
                    }
                    currentroom = new boolean[n];
                    break;
                }
                else {
                    currentroom[Birthday] = true;
                }
            }
        }
        //Update sumCount
        sumcount[0] = count[0];
        for (int x = 1; x < count.length; x++) {
            sumcount[x] = count[x] + sumcount[x - 1];
        }
        double fraction;
        for (int k = 0; k < 26; k++) {
            fraction = ((sumcount[k] + 0.0) / trails);
            System.out.print(k + 1);
            System.out.print("  " + count[k] + "  " + fraction);
            System.out.println(" ");
            if (fraction >= 0.5) break;

        }


    }
}
