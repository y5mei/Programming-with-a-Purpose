/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

import java.util.Arrays;
import java.util.Collections;

public class BarChartRacer {
    // private static void readBars() {
    //
    // }


    public static void main(String[] args) {
        StdDraw.enableDoubleBuffering();
        StdDraw.setCanvasSize(1000, 700);
        // StdAudio.loop("soundtrackA.wav");
        String fileName = args[0];
        int k = Integer.parseInt(args[1]); // Number of Bars to draw

        In file = new In(fileName);

        String title = file.readLine();
        String xAxis = file.readLine();
        String source = file.readLine();
        BarChart chart = new BarChart(title, xAxis, source);

        while (file.hasNextLine()) {
            // 读每一年的数据
            file.readLine(); // skip the empty line
            int n = Integer.parseInt(file.readLine());
            String[] inf = new String[5]; // 存每一行读到的信息
            Bar[] bars = new Bar[n]; // 存每一年读到的信息画成的bars

            // 把信息读到 bars 里，然后排序
            for (int i = 0; i < n; i++) {
                String temp = file.readLine();
                inf = temp.split(","); //Year_0, name_1, country_2, value_3, category_4
                //                     1982-01-14,101 Dalmations,USA,51000000,Buena Vista
                bars[i] = new Bar(inf[1], Integer.parseInt(inf[3]), inf[4]);
            }
            Arrays.sort(bars, Collections.reverseOrder());

            // 把 bars 画成 chart
            chart.reset();
            chart.setCaption(inf[0]);
            for (int i = 0; i < k; i++) {
                Bar b = bars[i];
                chart.add(b.getName(), b.getValue(), b.getCategory());
            }

            // draw the bar chart


            StdDraw.clear();
            chart.draw();
            StdDraw.show();
            StdDraw.pause(50);
        }


    }
}
