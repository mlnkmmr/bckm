package model.angled;

import model.GeometricModelElement;
import model.Point;
import util.Constants;

/**
 * @author Tessa Crößmann
 *
 */
public class RectangleElement extends AngledGeometricElement
{
	
	Point X;
	Point Y;
	 Point Z;
	 Point A;
	 int lengthx;
	 int lengthy;
	
	public RectangleElement(Point x, Point a, int lengthx, int lengthy)
	{
		this.lengthx = lengthx;
		this.lengthy = lengthy;
		x = X;
		a = A;
		Y.setX(x.getX() + lengthx);
		Y.setY(x.getY());
		Z.setX(x.getX());
		Z.setY(x.getY() + lengthy);
	}
	
	@Override
	protected String getJSONClassName()
	{
		return Constants.GEOMETRIC_ANGLED_RECTANGLE_ELEMENT;
	}

	@Override
	public GeometricModelElement cloneElement()
	{
		RectangleElement rectangle = new RectangleElement(X, A, lengthx, lengthy);
		Point CloneX = new Point(X.getX(), X.getY());
		Point CloneY = new Point(Y.getX(), Y.getY());
		Point CloneZ = new Point(Z.getX(), Z.getY());
		Point CloneA = new Point(A.getX(), A.getY());
		return rectangle;
	}

}
