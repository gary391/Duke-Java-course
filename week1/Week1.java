package week1;

public class Week1 {
    public static void main(String[] args) {
        int x; // Here we have not initialized the variable
        int y = 5;
        //System.out.println(x); // Here we have not initialized the variable so JAVA complier is complaining
        System.out.println(y);

        int a = 4;
        int b = a +2;
        int c = b - a;
        System.out.println(c);

        int k = 3;
        int m = 4 + k/2; // this will only take integer value 5.5 -> 5
        System.out.println(m);
        int l = m%3;
        System.out.println(l);

    }
}
