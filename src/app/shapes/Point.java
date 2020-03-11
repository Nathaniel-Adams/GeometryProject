//=============================================================================
// Point.java
//
// Defines a point class.
//
//          Original Author: Craig Jones
//                    Class: CS275
// Date of First Submission: 02/29/2020
//                  Project: GeometryProject (Winter 2020 Team Project)
//
// Revisions: 
//
//       Revisor          Date     Description
//  -----------------  ----------  --------------------------------------------
//
//=============================================================================
package app.shapes;


public class Point {
   
   double x, y;
   
   // Point constructor
   public Point(double x, double y) {
      this.x = x;
      this.y = y;
   } // Point()

   


   
   // Deep copy a point object
   public void CopyPoint(Point pt) {
      
      this.setPointX(pt.getPointX());
      this.setPointY(pt.getPointY());
      
   } // CopyPoint()


   
   
   // Exchanges the coordinate values between two points.
   public void swapPoints(Point pt) {
      double xTemp;
      double yTemp;
      
      xTemp = this.getPointX();
      yTemp = this.getPointY();
      
      this.setPointX(pt.getPointX());
      this.setPointY(pt.getPointY());
      
      pt.setPointX(xTemp);
      pt.setPointY(yTemp);
      
   } // swapPoints()
   
   
   // get accessors
   public double getPointX() {
      return x;
   } // getPointX()
   
   public double getPointY() {
      return y;
   } // getPointY()
   
   
   // set mutators
   public void setPointX(double x) {
      this.x = x;
   } // setPointX()
   
   public void setPointY(double y) {
      this.y = y;
   } // setPointY()
   
} // class Point
