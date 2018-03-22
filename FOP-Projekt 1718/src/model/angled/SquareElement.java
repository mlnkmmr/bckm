package model.angled;

import model.GeometricModelElement;
import model.Point;
import util.Constants;

/**
 * @author Tessa Crößmann
 *
 */
public class SquareElement extends AngledGeometricElement
{
	
	private Point X;
	private int Sitelength;
	
	public SquareElement(Point x, int sitelength)
	{
		x = X;
		
	}
	
	
	@Override
	protected String getJSONClassName()
	{
		return Constants.GEOMETRIC_ANGLED_SQUARE_ELEMENT;
	}

	@Override
	public GeometricModelElement cloneElement()
	{
		// TODO Auto-generated method stub
		return null;
	}

}
