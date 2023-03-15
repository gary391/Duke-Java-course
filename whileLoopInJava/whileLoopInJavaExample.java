package whileLoopInJava;

public class whileLoopInJavaExample {
    static int x = 0;
    static int y = 7;
    public static void main(String[] args) {
//        whileLoopInJavaExample wl = new whileLoopInJavaExample();

        while (x < y ) {
            System.out.println(x);
            x = x  + 3;
        }
        System.out.println("You have exited the while loop");
    }
}
