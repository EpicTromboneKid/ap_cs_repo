import java.awt.Color;
import java.awt.Point;
import java.awt.geom.*;
import java.util.*;
import gpdraw.*;

/**
 * Provides utilities to draw irregular polygons with the use of an arraylist
 * it represents, and how to use it.
 *
 * @author  Chaaruhaas Kandregula
 * @version 11/15/2024
 *
 * @author  Period - 3
 * @author  Assignment - IrregularPolygon
 * 
 * @author  Sources - None
 */
public class IrregularPolygon
{
    private DrawingTool pen;
    // private DrawingTool pen = new DrawingTool( new SketchPad( 300, 300, 0 ) );
    private ArrayList<Point2D.Double> myPolygon;

    //constuctors
    
    public IrregularPolygon()
    {
        myPolygon = new ArrayList<Point2D.Double>();
    }

    // public methods

    public void add( Point2D.Double aPoint )
    {
        myPolygon.add(aPoint);
    }

    public double perimeter()
    {
        double perimeter = 0;

        if (myPolygon.size() < 3) {
            return 0;
        }
        
        for (int i = 1; i < myPolygon.size(); i++) {
            double diffx = myPolygon.get(i).x - myPolygon.get(i-1).x;
            double diffy = myPolygon.get(i).y - myPolygon.get(i-1).y;

            perimeter += Math.sqrt(diffx*diffx + diffy*diffy);
        }

        double diffx = myPolygon.get(0).x - myPolygon.get(myPolygon.size()-1).x;
        double diffy = myPolygon.get(0).y - myPolygon.get(myPolygon.size()-1).y;

        perimeter += Math.sqrt(diffx*diffx + diffy*diffy);


        return perimeter;
    }

    public double area()
    {
        double area = 0;

        if (myPolygon.size() <= 3) {
            return 0;
        }

        for (int i = 1; i < myPolygon.size(); i++) {
            area += myPolygon.get(i-1).x*myPolygon.get(i).y; 
            area -= myPolygon.get(i).x*myPolygon.get(i-1).y; 
        }

        area += myPolygon.get(myPolygon.size()-1).x*myPolygon.get(0).y;
        area -= myPolygon.get(0).x*myPolygon.get(myPolygon.size()-1).y;

        return Math.abs(0.5*area); //fix this!
    }

    public void draw()
    {
        for (int i = 1; i < myPolygon.size(); i++) {
            // g.drawLine(myPolygon.get(i-1).x, myPolygon.get(i-1).y, myPolygon.get(i).x, myPolygon.get(i).y)
        }
    }
}
