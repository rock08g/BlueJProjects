import edu.duke.*;
import java.io.*;

public class PerimeterRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        int totalPt = 0;
        for (Point p : s.getPoints()) {
            totalPt++;
        }  
        return totalPt;
    }
    
    public double getAverageLength (Shape s) {
        double countPt = getNumPoints(s);
        double totalPerim = getPerimeter(s);
        double averageLen = totalPerim / countPt;
        return averageLen;
    }
    
    public double getLargestSide (Shape s) {
        double largestSide = 0;
        Point prevPt = s.getLastPoint();
        for (Point p : s.getPoints()) {
            double currDist = prevPt.distance(p);
            if (currDist > largestSide) {
                largestSide = currDist;
            }
        }
        return largestSide;
    }
    
    public double getLargestX (Shape s) {
        double largestX = 0;
        for (Point p : s.getPoints()) {
            double x = p.getX();
            if (x > largestX) {
                largestX = x;
            }
        }
        return largestX;
    }
    
    public double getLargestPerimeterMultipleFiles (DirectoryResource dr) {
        double largestPerim = 0.0;
        for (File f : dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double perim = getPerimeter (s);
            if (perim > largestPerim) {
                largestPerim = perim;
            }
        }
        return largestPerim;
    }
    
    public String getFileWithLargestPerimeter (DirectoryResource dr) {
        double largestPerim = 0.0;
        File temp = null;
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double perim = getPerimeter (s);
            if (perim > largestPerim) {
                largestPerim = perim;
                temp = f;
            }
        }
        return temp.toString();
    }
        
    
    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        System.out.println("perimeter = " + length);
        int countPt = getNumPoints(s);
        System.out.println("There are " + countPt + " number of points in this shape");
        double averageLen = getAverageLength(s);
        System.out.println("the average length of a side in your shape is " + averageLen);
        double longestSide = getLargestSide(s);
        System.out.println("the longest side is " + longestSide);
        double largestX = getLargestX(s);
        System.out.println("The largest X will be " + largestX);
    }
    
    public void testPerimeterMultipleFiles () {
        DirectoryResource dr = new DirectoryResource();
        double largestPerim = 0.0;
        largestPerim = getLargestPerimeterMultipleFiles(dr);
        System.out.println("The largest perimeter between multiple files is " + largestPerim);
        String fileWithLargestPerim = getFileWithLargestPerimeter(dr);
        System.out.println("The file with the largest perimeter is " + fileWithLargestPerim);
    }

    public static void main (String[] args) {
        PerimeterRunner pr = new PerimeterRunner();
        pr.testPerimeter();
        pr.testPerimeterMultipleFiles();
    }

    
}
