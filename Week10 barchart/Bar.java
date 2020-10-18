/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

import java.util.Arrays;

// 思路：Java 里对于 Arrays 这个类，有排序， sort 这个方法
//           sort() 要求被排序的每个元素 mutable，并且 可以被比较，有 compareTo() 方法
//       我们想做一个 bar 这个 class，这个是 java 没有的，我们要做的
//       但是 bar 这个对象，不可以被比较，所以需要从 Comparable 这个 interface 里，
//       继承 compareTo 这个方法，并且 overwirte 成比较 bar.value


// Interface inheritance (subtyping).
public class Bar implements Comparable<Bar> {
    private final String n;
    private final int v;
    private final String c;

    // Creates a new bar.
    public Bar(String name, int value, String category) {
        if (name == null) {
            throw new IllegalArgumentException("name is null");
        }
        if (category == null) {
            throw new IllegalArgumentException("category is null");
        }
        if (value < 0) {
            throw new IllegalArgumentException("negative value");
        }
        n = name;
        v = value;
        c = category;
    }

    // print
    public String toString() {
        return (this.n + "  " + this.v + "  " + this.c);
    }

    // Returns the name of this bar.
    public String getName() {
        return this.n;
    }

    // Returns the value of this bar.
    public int getValue() {
        return this.v;
    }

    // Returns the category of this bar.
    public String getCategory() {
        return this.c;
    }

    // Compare two bars by value.
    // https://docs.oracle.com/javase/8/docs/api/java/lang/Comparable.html
    // Include a method compareTo() to specify how to compare two Bar objects.
    // In this case, return a
    //     { negative integer, zero, positive integer }
    // if value of the invoking object is
    //     { less than, equal to, greater than }
    // the value of the argument object.
    public int compareTo(Bar that) {
        if (that == null) {
            throw new NullPointerException("nothing to compare to");
        }
        return this.v - that.v;
    }

    // Sample client (see below).
    public static void main(String[] args) {
        Bar[] bars = new Bar[10];
        bars[0] = new Bar("Beijing", 22674, "East Asia");
        bars[1] = new Bar("Cairo", 19850, "Middle East");
        bars[2] = new Bar("Delhi", 27890, "South Asia");
        bars[3] = new Bar("Dhaka", 19633, "South Asia");
        bars[4] = new Bar("Mexico City", 21520, "Latin America");
        bars[5] = new Bar("Mumbai", 22120, "South Asia");
        bars[6] = new Bar("Osaka", 20409, "East Asia");
        bars[7] = new Bar("São Paulo", 21698, "Latin America");
        bars[8] = new Bar("Shanghai", 25779, "East Asia");
        bars[9] = new Bar("Tokyo", 38194, "East Asia");

        // sort in ascending order by weight
        Arrays.sort(bars);
        for (Bar b : bars) {
            System.out.println(b);
        }
        Bar p = new Bar("Hangzhou", 902278, "East Asia");
        Bar q = new Bar("Buenos Aires", 99643, "Latin America");
        System.out.println(p.compareTo(q));
        // q - p = 99643-902278
    }

}
