/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class Huntingtons {

    // Returns the maximum number of consecutive repeats of CAG in the DNA string.
    public static int maxRepeats(String dna) {
        int count = 0;
        int maxcount = 0;
        int n = dna.length();
        char[] dnaarray = dna.toCharArray();
        int i = 0;
        while (i < n - 2) {
            if (dnaarray[i] == 'C') {
                if (dnaarray[i + 1] == 'A' && dnaarray[i + 2] == 'G') {
                    count += 1;
                    maxcount = Math.max(maxcount, count);
                    // System.out.println(
                    //         dnaarray[i] + " " + dnaarray[i + 1] + " " + dnaarray[i + 2] + "///"
                    //                 + i);
                    i += 3;
                    continue;

                }
            }
            // System.out.println(dnaarray[i] + "  " + i);
            i += 1;
            count = 0;
        }
        return maxcount;
    }

    // Returns a copy of s, with all whitespace (spaces, tabs, and newlines) removed.
    public static String removeWhitespace(String s) {
        // StringBuilder sb = new StringBuilder();
        // Set<String> h = new HashSet<>(Arrays.asList("a", "b"));
        // 单引号是 char，双引号是String
        // char[] DNA = { 'A', 'G', 'C', 'T' };
        // for (char c : s.toCharArray())
        //     if (c == 'A' || c == 'G' | c == 'C' | c == 'T')
        //         sb.append(c);
        // return sb.substring(0);

        String noSpaceString;
        noSpaceString = s.replace("\n", "").replace("\t", "").replace(" ", "");
        return noSpaceString;

    }

    // Returns one of these diagnoses corresponding to the maximum number of repeats:
    // "not human", "normal", "high risk", or "Huntington's".
    public static String diagnose(int maxRepeats) {
        if (maxRepeats <= 9) return "not human";
        if (maxRepeats <= 35) return "normal";
        if (maxRepeats <= 39) return "high risk";
        if (maxRepeats <= 180) return "Huntington’s ";
        return "not human";

    }

    // Sample client (see below).
    public static void main(String[] args) {

        // Input file is a object In
        String filename = args[0];
        In input = new In(filename);
        String dna = input.readAll();
        int repeat = 0;


        // System.out.println(removeWhitespace(dna).length());

        dna = removeWhitespace(dna);
        repeat = maxRepeats(dna);
        System.out.println("max repeats = " + repeat);
        System.out.println(diagnose(repeat));
    }

}
