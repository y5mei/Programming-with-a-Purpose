/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class Minesweeper {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);
        int k = Integer.parseInt(args[2]);

        int total = m * n;
        boolean[][] ifMine = new boolean[m + 2][n + 2];
        int[][] countMine = new int[m + 2][n + 2];
        int minex;
        int miney;
        int mineNum = 0;

        // Place the k mines
        for (int i = 0; i < k; i++) {
            minex = (int) (Math.random() * m) + 1;
            miney = (int) (Math.random() * n) + 1;
            if (ifMine[minex][miney]) {
                k += 1;
            }
            else {
                ifMine[minex][miney] = true;
            }
        }

        // Count neighboring mines:
        for (int j = 1; j <= m; j++) {
            for (int u = 1; u <= n; u++) {
                // Loop over 9 cells to count

                for (int p = j - 1; p <= j + 1; p++) {
                    for (int q = u - 1; q <= u + 1; q++) {
                        if (ifMine[p][q]) {
                            mineNum += 1;
                        }
                    }
                }
                countMine[j][u] = mineNum;
                mineNum = 0;
            }
        }


        // Print the mine map:
        for (int x = 1; x <= m; x++) {
            for (int y = 1; y <= n; y++) {
                if (!ifMine[x][y]) {
                    System.out.print(countMine[x][y] + "  ");
                }
                else {
                    System.out.print("*  ");
                }
            }
            System.out.println("");

        }

    }
}
