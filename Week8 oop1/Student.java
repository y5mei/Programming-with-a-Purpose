/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class Student {
    private String name;
    private int age;

    public Student(String n, int a) {
        name = n;
        age = a;
    }

    public String toString() {
        return "this is a instance method";
    }

    public static String printClass() {
        return "this is a static method";
    }

    public static void main(String[] args) {
        Student stu1 = new Student("ZhangSan", 21);
        System.out.println(stu1);
        System.out.println(Student.printClass());
        printClass();

    }
}
