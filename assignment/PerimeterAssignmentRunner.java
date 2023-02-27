package assignment;

import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        /* Start with totalPerim = 0 */
        double totalPerim = 0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();  // Here we need to get the last point of the shape
        // For each point currPt in the shape,
            for (Point currPt: s.getPoints() ) {
                // Find distance from prevPt point to currPt, and name it currDist
                // Any time we name a quantity we name a variable.
                    double currDist = prevPt.distance(currPt);
                // Update totalPerim by currDist
                    totalPerim = totalPerim +  currDist;
                // Update prevPt to be currPt, this is required to iterate over all the points.
                prevPt = currPt;
            }

        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        // Put code here
        int countPoints = 0 ;
        for(Point eachPoint: s.getPoints() ){
            countPoints = countPoints + 1;
        }
        return countPoints;
    }

    public double getAverageLength(Shape s) {
        // Put code here
        double AvgLength =  getPerimeter(s)/ getNumPoints(s);
        return AvgLength;
    }

    public double getLargestSide(Shape s) {
         double largestSideValue = 0;  //Starting value
        // calculatedValue between two points
        Point prevPt = s.getLastPoint();
        for (Point currPt: s.getPoints() ) {
            double currDist = prevPt.distance(currPt);
            if (currDist >= largestSideValue) {
                largestSideValue = currDist;
            }
        prevPt = currPt;
        }
        // Compare the calculatedValue with largestSideValue
        // replace the largestSideValue with the calculatedValue.
        return largestSideValue;
    }

    public double getLargestX(Shape s) {
        int largestPoint = 0;
        for (Point currPt: s.getPoints() ) {
            if (currPt.getX()>=largestPoint){
                largestPoint = currPt.getX();
            }
        }
        return largestPoint;
    }

    public double getLargestPerimeterMultipleFiles() {
        DirectoryResource dr = new DirectoryResource();
        double largestPerimeter = 0d;
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            if (getPerimeter(s) >= largestPerimeter){
                largestPerimeter = getPerimeter(s);
            }
        }
        return largestPerimeter;
    }


    public String getFileWithLargestPerimeter() {
        double largestPerimeter = 0d;
        File temp = null;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            if (getPerimeter(s) >= largestPerimeter) {
                largestPerimeter = getPerimeter(s);
                temp = f;
            }
        }
        return temp.getName();
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        System.out.println("perimeter = " + length);
        int count = getNumPoints(s);
        System.out.println("Count of Points = " + count);
        double average = getAverageLength(s);
        System.out.println("Average length: " + average);
        double largestSide= getLargestSide(s);
        System.out.println("Largest Side: " + largestSide);
        double largestPoint = getLargestX(s);
        System.out.println("Largest Point is: "+ largestPoint);
        System.out.print("FileName with the largest Perimeter: ");
        testFileWithLargestPerimeter();
//        System.out.print("Largest perimeter of multiple files: ");
//        testPerimeterMultipleFiles();

    }
    
    public void testPerimeterMultipleFiles() {
        System.out.println(getLargestPerimeterMultipleFiles());
    }

    public void testFileWithLargestPerimeter() {
        System.out.println(getFileWithLargestPerimeter());
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }


    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeter();
    }
}
