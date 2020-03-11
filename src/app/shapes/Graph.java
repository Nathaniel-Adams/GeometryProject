//=============================================================================
// Graph.java
//
// Class that allows the creation and display of the graphs of various
// geometric shapes.
//
//          Original Author: Craig Jones
//                    Class: CS275
// Date of First Submission: 02/29/2020
//                  Project: GeometryProject (Winter 2020 Team Project)
//
// Notes:
// 1. This class contains 2 important elements:
//     a. A JFrame - A window which will be the canvas for displaying various
//        geometric shapes.
//     b. A shapeList - a collection of lineList's. Each lineList is a
//        collection of lines (defined by two endpoints) that describe a shape.
//
// 2. This drawing works as follows:
//     a. A JFrame is instantiated to create the display window.
//     b. An image buffer (essentially a bitmap), which fits inside the JFrame
//        window, is created to gather all the shapes which will be plotted.
//     c. Once all the shapes have been rendered into the image buffer, the
//        buffer is drawn into the JFrame in one operation.
// 3. To use this class to display shapes:
//     a. Instantiate a Graph object
//     b. Create a lineList for each shape
//     c. Add each lineList to the class shapeList
//     d. Call PlotShapes() to plot the shapes into the JFrame window.
//        Note: PlotShapes() will analyze the extents of all the shapes to
//              determine a scale factor to assure that all the shapes will fit
//              into the JFrame window.
//        Note: The JFrame window uses a coordinate system which places the
//              (0, 0) origin in the upper left corner of the window. The
//              rendering code will transform the image so that the shapes will
//              appear to be drawn in the more familiar cartesian coordinate
//              system with the (0, 0) origin in the lower left corner of the
//              JFrame window.
//        Note: This class does not allow for negative coordinate values.
//
//  4. Use the static main() method in this class definition as a template for
//     displaying shapes. The case DISPLAY: code in isosceles.java also
//     demonstrates how to use this functionality.
//
//
// Revisions: 
//
//       Revisor          Date     Description
//  -----------------  ----------  --------------------------------------------
//
//=============================================================================

package app.shapes;
import java.awt.BasicStroke;
import java.awt.Color;
import java.lang.Math;
import java.awt.Container;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.ArrayList;

public class Graph extends JPanel {
   
   // Add a little extra space at the bottom to allow for the "Scale Factor: x"
   // to be inserted.
   private static final int TEXT_EXTRA = 15;
   
   // Size of the JFrame window in pixels
   private static final int FRAME_SIZE = 530;

   // Number of pixels we will shift the image buffer, in both the X & Y
   // directions, away from the origin of the JFrame origin.  This will prevent
   // any part of the plotted shapes from being plotted on the JFrame window
   // boundaries on all sides.
   private static final int FRAME_OFFSET = 10;

   // The size of the image buffer.
   private static final int BUFFER_SIZE = FRAME_SIZE - (2 * FRAME_OFFSET);
         
   // A list of shapes (collection of lineList's) to be plotted into the graph
   public ArrayList<ArrayList<Line>> shapeList;
   
   // JFrame window into which the shapes will be plotted
   private JFrame frame;

   // The graphic extents of the entire collection of shapes.
   private double xMin, yMin;
   private double xMax, yMax; 

   // The scale factor to be used to cause the entire group of shapes to fit 
   // within the confines of the image buffer.
   private double scaleFactor;





   
   // This sample for drawing two triangles can be used as a template for 
   // drawing various shapes.  
   // This static main() method can also be run as a separate program via the 
   // Debug/Debug File option in NetBeans -- very handy for testing!
   public static void main(String[] args) {
      
      // instantiate a new graph object
      Line            line;
      ArrayList<Line> lineList;
      Point           pt1, pt2;
      Graph           graph;
      
      // Instantiate a graph object and initialize it
      graph = new Graph();
      graph.InitializeGraph("Isosceles Triangles", graph);
   
      // Create a new line list for the polygon
      lineList = Line.CreateLineList();
    
      // Create a new line object from two points
      // Note:Tthe two points are deep copied into the line object by the 
      //       Line(pt1, pt2) constructor.
      pt1  = new Point(0.0, 0.0);
      pt2  = new Point(2.07055, 0.0);
      line = new Line(pt1, pt2); 
      lineList.add(line);
      
      // Create a 2nd line to add to the line list (the 1st point is the same
      // as above)
      pt2.setPointX(1.035276);
      pt2.setPointY(3.8637);
      line = new Line(pt1, pt2);
      lineList.add(line);
      
      // Create a 3rd line to add to the line list (the 2nd point is the same
      // as above)
      pt1.setPointX(2.07055);
      pt1.setPointY(0.0);
      line = new Line(pt1, pt2);
      lineList.add(line);
           
      // Add the lineList to the shapeList    
      // Note: Outside of this class, you will need to use 
      // GetShapeList().add(lineList) instead of this below:
      graph.shapeList.add(lineList);
      
      // Adding a second new polygon
      lineList = Line.CreateLineList();
      
      pt1  = new Point(9.0, 8.0);
      pt2  = new Point(13.0, 5.0);
      line = new Line(pt1, pt2);
      lineList.add(line);
      
      pt2.setPointX(17.0);
      pt2.setPointY(8.0);
      line = new Line(pt1, pt2);
      lineList.add(line);
      
      pt1.setPointX(13.0);
      pt1.setPointY(5.0); 
      line = new Line(pt1, pt2);
      lineList.add(line);

      graph.shapeList.add(lineList);
      
      // Plot the shapes to the JFrame window.
      graph.PlotShapes();
      
   } // main()
   


   
   
  
   // This is an extension to the default Graph constructor that does the actual
   // initialization of the new graph context. The reason the initialization is 
   // done in this method rather than in the Graph constructor is that the call 
   // to the frame.getContentPane().add(graph) method requires a reference to 
   // the graph object and I couldn't figure out how to pass the reference to 
   // the graph object while the object was still being constructed (using 
   // "this" doesn't seem to be legal in this situation).  Kind of quirky I know
   // but I'll see if I can fix it if I have time.
   public void InitializeGraph(String shapeName, Graph graph) {
      
      // Specify that the JFrame created will have the host operating system's
      // default look and feel.
      JFrame.setDefaultLookAndFeelDecorated(true);
      
      // Create a new JFrame window with the shape name in the title.
      frame = new JFrame(shapeName);
       
      // Add our Graph class instance to the list of classes that can provide
      // services to this JFrame instance.  This allows a callback to our
      // Graph object's paint() override method.
      frame.getContentPane().add(graph);

      // Use the default handling to close the JFrame window.
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      frame.setBackground(Color.WHITE);
      
      // Set the frame window size
      frame.setSize(FRAME_SIZE, FRAME_SIZE + TEXT_EXTRA);

      SetJFrame(frame);
      
      // Instantiate the shapeList for this group of shape(s)
      SetShapeList(new ArrayList<ArrayList<Line>>());
      
      // Initialize the extent values to the extreme opposite sense.
      SetXMin(Double.MAX_VALUE);
      SetYMin(Double.MAX_VALUE);
      SetXMax(Double.MIN_VALUE);
      SetYMax(Double.MIN_VALUE);

      SetScaleFactor(1.0);
            
   } // InitializeGraph()

   

   
   

   // Applies all the transformations to scale and position the shape 
   // coordinates in the image buffer and then renders them into the JFrame 
   // window.
   public void PlotShapes() {
      
      int             numberOfShapes;
      int             numberOfLines;
      ArrayList<Line> lineList;
           
      // Iterate through the shapeList to prepare the lines that make up each 
      // shape for rendering into the image buffer.
      numberOfShapes = GetShapeList().size();
      for(int ii = 0; ii < numberOfShapes; ii++) {

         // Organize each line's endpoints so that the smallest x value is in x1
         // While iterating, check each line against the current extent values 
         // to adjust the extent values as needed.
         lineList = GetShapeList().get(ii);
         numberOfLines = lineList.size();
         for(int jj = 0; jj < numberOfLines; jj++) 
            GetExtents(lineList.get(jj));

      } // outer for
      
      // Determine the scale factor so that the shapes will draw as large as
      // posible in the image buffer without spilling out.
      determineScaleFactor();
      
      // Apply the scale to coordinates of all the shapes
      RefactorLines();
      
      // This causes the graph to be displayed (ie. it will cause our paint() 
      // override  method to be called).
      GetJFrame().setVisible(true);
      
   } // PlotShapes()
   



   
   
   // Figure out the best scale factor to use to map the shapes into the
   // image buffer.  Essentially, we want to make the shapes as big as possible
   // in the image buffer.  This means that we will scale up if the shapes are 
   // too small (relative to the size of the image buffer) or scale them down if 
   // they are too big to all fit into the image buffer.  Essentially we will 
   // just find which direction (X or Y) has the largest magnitude and go from 
   // there.
   private void determineScaleFactor() {

      double max = xMax;
      double factor = 1.0;
      
      // Use the largest value since that is what has to fit in the image buffer
      if(yMax > xMax)
         max = yMax;
      
      // Scale the maximum exent value down below the BUFFER_SIZE.
      // Note: Use (BUFFER_SIZE - 1) in case rounding the double values to int
      //       causes the int value to round beyond the image buffer limits.
      while(max > BUFFER_SIZE - (TEXT_EXTRA + 1)) {
         max /= 10.0;
         factor /= 10.0;
      } // while
      
      // Now that the maximum extent is smaller than the BUFFER_SIZE limit, 
      // scale it up to be as close to the full buffer image size as possible.
      SetScaleFactor(((BUFFER_SIZE - (TEXT_EXTRA + 1)) / max) * factor);
      
   } // determineScaleFactor()
   




   
   // Scale the line coordinates so that the plot of the shapes will fill the
   // extent of the image buffer.
   private void RefactorLines() {
      int             numberOfShapes;
      int             numberOfLines;
      double          xShift;
      double          yShift;
      double          scaleFactor;
      Line            line;
      ArrayList<Line> lineList;
      
      // Apply the scaleFactor to the extent values
      scaleFactor = GetScaleFactor();
      SetXMin(GetXMin() * GetScaleFactor());
      SetYMin(GetYMin() * GetScaleFactor());
      SetXMax(GetXMax() * GetScaleFactor());
      SetYMax(GetYMax() * GetScaleFactor());
      
      // Determine how far we need to shift in each direction to center the
      // shapes in the image buffer.  
      xShift = (BUFFER_SIZE - (int)(GetXMax() - GetXMin())) / 2;
      yShift = (BUFFER_SIZE - (int)(GetYMax() - GetYMin())) / 2;
      
      // Add a little more to the yShift value to make room for the "Scale 
      // Factor: xxx.xxx" text at the bottom.  -4 is just an empirical 
      // adjustment to improve the positioning.
      yShift += (TEXT_EXTRA / 2.0) - 4;

      // Loop through the shapeList to apply the scaleFactor to all the shapes
      numberOfShapes = GetShapeList().size();
      for(int ii = 0; ii < numberOfShapes; ii++) {

         // Iterate through all the lines in the current shape & apply the 
         // scale factor.
         lineList = GetShapeList().get(ii);
         numberOfLines = lineList.size();
         
         for(int jj = 0; jj < numberOfLines; jj++) {
            line = lineList.get(jj);
            line.pt1.setPointX((line.pt1.getPointX() * scaleFactor) + xShift);
            line.pt1.setPointY((line.pt1.getPointY() * scaleFactor) + yShift);
            line.pt2.setPointX((line.pt2.getPointX() * scaleFactor) + xShift);
            line.pt2.setPointY((line.pt2.getPointY() * scaleFactor) + yShift);
         } // inner for
      } // outer for

   } // RefactorLines()


   

   


   // Checks the specified line against the current extent values to adjust the
   // extent values as needed.
   private void GetExtents(Line line) {

      double x1, y1, x2, y2;

      x1 = line.pt1.getPointX();
      x2 = line.pt2.getPointX();
      y1 = line.pt1.getPointY();
      y2 = line.pt2.getPointY();

      // See if any coordinate value of this line exceeds the previous extent
      // values.
      if(x1 < GetXMin())
         SetXMin(x1);
      if(x1 > GetYMax())
         SetXMax(x1);
      if(x2 < GetXMin())
         SetXMin(x2);
      if(x2 > GetXMax())
         SetXMax(x2);

      if(y1 < GetYMin())
         SetYMin(y1);
      if(y1 > GetYMax())
         SetYMax(y1);
      if(y2 < GetYMin())
         SetYMin(y2);
      if(y2 > GetYMax())
         SetYMax(y2);

   } // GetExtents()





   // This method is called by the JFrame class as a result of our code calling
   // the JFrame setVisible(true) method.
@Override
   public void paint(Graphics g) {
      
      // Render the lines contained in the shapeList into an image buffer.
      Image img = CreateImage();
      
      // Plot the image buffer into the JFrame window, offset by FRAME_OFFSET
      // pixels from the window's borders.
      g.drawImage(img, FRAME_OFFSET, FRAME_OFFSET, this);
      
   } // paint()

   




   // Build an image buffer from all the shapes in the shapeList. 
   private Image CreateImage() {
      
      int             x1, y1, x2, y2;
      int             numberOfLines;
      int             numberOfShapes;
      Line            line;
      ArrayList<Line> lineList;
      String          string = String.format("Scale Factor: %.2f", 
                                             GetScaleFactor());
      
      // Create a buffered image
      BufferedImage bImage = new BufferedImage(BUFFER_SIZE,
                                               BUFFER_SIZE + TEXT_EXTRA,
                                               BufferedImage.TYPE_INT_RGB);

      // Grab a graphics context from the buffered image.
      Graphics g = bImage.getGraphics();
      
      // Set the background color of the image.
      g.setColor(Color.BLACK);
      g.fillRect(0, 0, bImage.getWidth(), bImage.getHeight());

      // Set the line color.
      g.setColor(Color.RED);

      // Iterate through the shapeList to render the lines that make up each 
      // shape into the image buffer.
      numberOfShapes = GetShapeList().size();
      for(int ii = 0; ii < numberOfShapes; ii++) {

         // Render each line in the current shape.
         lineList = GetShapeList().get(ii);
         numberOfLines = lineList.size();
         for(int jj = 0; jj < numberOfLines; jj++) {
         
            // Convert the point coordiantes to screen pixel integers.
            line = lineList.get(jj);
            x1 = doubleToInt(line.pt1.getPointX(), 5);
            y1 = doubleToInt(line.pt1.getPointY(), 5);
            x2 = doubleToInt(line.pt2.getPointX(), 5);
            y2 = doubleToInt(line.pt2.getPointY(), 5);
      
            // The JFrame coordinate system places the origin at the upper left 
            // corner. We are using the cartesian coordinate system with the 
            // origin at the lower left corner, so we need to adjust the Y 
            // coordinate values to compensate to for that.
            y1 = BUFFER_SIZE - y1;
            y2 = BUFFER_SIZE - y2;
          
            // Render the line into the image buffer.
            g.drawLine(x1, y1, x2, y2);

         } // inner for
      } // outer for
      
      // Set the text color and render it into the image buffer.
      g.setColor(Color.YELLOW);
      g.drawString(string, 10, BUFFER_SIZE + (TEXT_EXTRA - 3));

      return bImage;

   } // CreateImage()   



   

   // shapeList mutator
   private void SetShapeList(ArrayList<ArrayList<Line>> shapeList) {
      this.shapeList = shapeList;
   } // SetShapeList()

   // shapeList accessor  
   public ArrayList<ArrayList<Line>> GetShapeList() {
      return shapeList;
    } // GetShapeList()
   
   // JFrame mutator
   private void SetJFrame(JFrame frame) {
      this.frame = frame;
   } // SetJFrame()

   // JFrame accessor
   private JFrame GetJFrame() {
      return frame;
   } // GetJFrame()

   // scaleFactor mutator
   private void SetScaleFactor(double scaleFactor) {
      this.scaleFactor = scaleFactor;
   } // SetScaleFactor()

   // scaleFactor accessor
   private double GetScaleFactor() {
      return scaleFactor;
   } // GetScaleFactor()

   // xMin mutator
   private void SetXMin(double xMin) {
      this.xMin = xMin;
   } // SetXMin()

   // xMin accessor
   private double GetXMin() {
      return xMin;
   } // GetXMin() 

   // xMax mutator
   private void SetXMax(double xMax) {
      this.xMax = xMax;
   } // SetXMax()

   // xMax accessor
   private double GetXMax() {
      return xMax;
   } // GetXMax() 



   // yMin mutator
   private void SetYMin(double yMin) {
      this.yMin = yMin;
   } // SetYMin()

   // yMin accessor
   private double GetYMin() {
      return yMin;
   } // GetYMin() 

   // yMax mutator
   private void SetYMax(double yMax) {
      this.yMax = yMax;
   } // SetYMax()

   // yMax accessor
   private double GetYMax() {
      return yMax;
   } // GetYMax() 

   
   
   // Convert a double precision number to integer after rounding it to the 
   // specified number of decimal places behind the decimal point.
   private int doubleToInt(double value, int decimalPlaces) {

      double shift = Math.pow(10,decimalPlaces);

      return (int)Math.round((value * shift) / shift);

   } // doubleToInt()

} // class Graph

