/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class MyClass {
    String name;
    int age;

    MyClass() {
        this("BeginnerBook.com");
    }

    MyClass(String s) {
        this(s, 6);
    }

    MyClass(String s, int age) {
        this.name = s;
        this.age = age;
    }

    public static void main(String[] args) {
        MyClass obj = new MyClass();
        System.out.println(obj.name + "has " + obj.age);

    }
}
