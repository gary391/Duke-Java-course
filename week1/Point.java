package week1;

public class Point {

    //Attribute
    private int x;
    private int y;

    // Constructor
    public Point(int startx, int starty){
        this.x = startx;
        this.y = starty;
    }

    // Getter

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public double distance(Point otherPt){
        int dx = x - otherPt.getX();
        int dy = y - otherPt.getY();
        return Math.sqrt(dx *dx + dy *dy);
    }
//    public static void main(String[] args) {
//        Point p1 = new Point(3, 4);
//        Point p2 = new Point(2,2);
//        System.out.println("The distance between the points " +  p1.distance(p2));
//    }
}
