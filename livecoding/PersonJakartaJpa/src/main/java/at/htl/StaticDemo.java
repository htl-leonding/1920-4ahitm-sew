package at.htl;

public class StaticDemo {
    static int counter = 0;

    public StaticDemo() {
        counter++;
    }

    public static void main(String[] args) {
        StaticDemo a = new StaticDemo();
        StaticDemo b = new StaticDemo();
        StaticDemo c = new StaticDemo();
        StaticDemo.counter++;
        System.out.println(c.counter);
    }
}
