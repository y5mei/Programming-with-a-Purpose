/******************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 *****************************************************************************/

public class Clock {
    private int h;
    private int m;

    // Creates a clock whose initial time is h hours and m minutes.
    // Two-argument constructor.
    public Clock(int hour, int min) {
        if (hour < 0 || hour > 23 || min < 0 || min > 59) {
            throw new IllegalArgumentException("Illegal Input");
        }
        this.h = hour;
        this.m = min;
    }

    // Creates a clock whose initial time is specified as a string, using the format HH:MM.
    public Clock(String s) {
        // Check the length of string is 5
        if (s.length() != 5) {
            throw new IllegalArgumentException("Length of input is not hh:mm");
        }
        // Check the strin is seperate by :
        String colon = s.substring(2, 3);
        if (!colon.equals(":")) {
            throw new IllegalArgumentException("not seperate by :");
        }

        // Check the mins and hours are in range
        String hourStr = s.substring(0, 2);
        String minStr = s.substring(3);
        int hourInt = Integer.parseInt(hourStr);
        int minInt = Integer.parseInt(minStr);
        if (hourInt < 0 || hourInt > 23 || minInt < 0 || minInt > 59) {
            throw new IllegalArgumentException("Illegal Input");
        }
        this.h = hourInt;
        this.m = minInt;


    }

    // Returns a string representation of this clock, using the format HH:MM.
    public String toString() {
        String hStr;
        String mStr;

        if (this.h < 10) {
            hStr = "0" + Integer.toString(this.h);
        }
        else {
            hStr = Integer.toString(this.h);
        }
        if (this.m < 10) {
            mStr = "0" + this.m;
        }
        else {
            mStr = Integer.toString(this.m);
        }
        return (hStr + ":" + mStr);

    }

    // Is the time on this clock earlier than the time on that one?
    public boolean isEarlierThan(Clock that) {
        if (this.h == that.h) {
            if (this.m >= that.m) return false;
            return true;
        }
        else {
            if (this.h >= that.h) return false;
            return true;
        }

    }

    // Adds 1 minute to the time on this clock.
    public void tic() {
        int newMin = (this.m + 1) % 60;
        int newHour = ((this.m + 1) / 60 + this.h) % 24;
        this.m = newMin;
        this.h = newHour;
    }

    // Adds Δ minutes to the time on this clock.
    public void toc(int delta) {
        if (delta < 0) {
            throw new IllegalArgumentException("delta should be greater or equal to Zero");
            Q
        }
        int delMin = delta % 60;
        int delHour = delta / 60;

        int newMin = (this.m + delMin) % 60;
        int newHour = ((this.m + delMin) / 60 + delHour + this.h) % 24;
        // set the mins and hours
        this.m = newMin;
        this.h = newHour;


    }

    // Test client (see below).
    // @edu.umd.cs.findbugs.annotations.SuppressFBWarnings("DLS_DEAD_LOCAL_STORE")
    public static void main(String[] args) {
        Clock c1 = new Clock("22:06");
        System.out.println(c1);

        Clock c2 = new Clock(22, 6);
        System.out.println(c2);
        System.out.println(c1.isEarlierThan(c2));
        c1.tic();
        System.out.println(c1);
        c1.toc(3600);
        System.out.println(c1);
        System.out.println(c1.isEarlierThan(c2));
        Clock c3 = new Clock(12, 34);
        c3.toc(5);
        System.out.println(c3);
    }
}
