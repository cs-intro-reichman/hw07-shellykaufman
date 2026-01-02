/** Draws ths Sierpinski Triangle fractal. */
public class Sierpinski {
	
	public static void main(String[] args) {
		sierpinski(Integer.parseInt(args[0]));
	}
	
	// Draws a Sierpinski triangle of depth n on the standard canvass.
	public static void sierpinski (int n) {

		double x1 = 0.0;
        double y1 = 0.0;
        double x2 = 1.0;
        double y2 = 0.0;
        double x3 = 0.5;
        double y3 = Math.sqrt(3) / 2.0; 

        StdDraw.setPenColor(StdDraw.BLACK);
        double[] xCoords = { x1, x2, x3 };
        double[] yCoords = { y1, y2, y3 };
        StdDraw.polygon(xCoords, yCoords);

        sierpinski(n, x1, x2, x3, y1, y2, y3);	
	}
	
	// Does the actual drawing, recursively.
	private static void sierpinski(int n, double x1, double x2, double x3,
		                                 double y1, double y2, double y3) {
		if (n <= 0) {
            return;
        }
		double midBottomX = (x1 + x2) / 2.0;
        double midBottomY = (y1 + y2) / 2.0;
        
        double midRightX = (x2 + x3) / 2.0;
        double midRightY = (y2 + y3) / 2.0;
        
        double midLeftX = (x3 + x1) / 2.0;
        double midLeftY = (y3 + y1) / 2.0;

        StdDraw.setPenColor(StdDraw.WHITE);
        double[] xMidPoints = { midBottomX, midRightX, midLeftX };
        double[] yMidPoints = { midBottomY, midRightY, midLeftY };
        StdDraw.filledPolygon(xMidPoints, yMidPoints);

        sierpinski(n - 1, x1, midBottomX, midLeftX, y1, midBottomY, midLeftY);
        sierpinski(n - 1, midBottomX, x2, midRightX, midBottomY, y2, midRightY);
        sierpinski(n - 1, midLeftX, midRightX, x3, midLeftY, midRightY, y3);
	}
}