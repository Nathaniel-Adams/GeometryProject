//=============================================================================
// Line.java
//
// Defines a Line class.
//
// Use this class to build a lineList to pass an array of all the lines that
// describe the given polygon to the graphing code.
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

import java.util.ArrayList;


public class Line {

   public Point pt1;
   public Point pt2;
  
   

   // Line constructor. Performs a deep copy of the point coordinates.
   public Line(Point pt1, Point pt2) {
      this.pt1 = new Point(pt1.getPointX(), pt1.getPointY());
      this.pt2 = new Point(pt2.getPointX(), pt2.getPointY());
   } // Line()
   
   
   // Instantiate a lineList array. (A list of lines defined by their endpoints.
   public static ArrayList<Line> CreateLineList() {
      
      ArrayList<Line> lineList;
      
      lineList = new ArrayList<Line>();
      
      return lineList;
   
   } // CreateLineList()

} // class Line

