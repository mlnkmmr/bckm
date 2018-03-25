package model.angled;

import model.GeometricModelElement;
import model.Point;
import util.Constants;

/**
 * @author Tessa Crößmann
 *
 */
public class SquareElement extends RectangleElement
{
	
	public SquareElement(Point x, Point y, int sitelength)
	{
		super(x, y, sitelength, sitelength);	
	}
	
	
	@Override
	protected String getJSONClassName()
	{
		return Constants.GEOMETRIC_ANGLED_SQUARE_ELEMENT;
	}

	@Override
	public GeometricModelElement cloneElement()
	{
		SquareElement square = new SquareElement(X, Y, lengthx);
		Point CloneX = new Point(X.getX(), X.getY());
		Point CloneY = new Point(Y.getX(), Y.getY());
		Point CloneZ = new Point(Z.getX(), Z.getY());
		Point CloneA = new Point(A.getX(), A.getY());
		return square;
	}

}
