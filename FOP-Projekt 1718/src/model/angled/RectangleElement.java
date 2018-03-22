package model.angled;

import model.GeometricModelElement;
import model.Point;
import util.Constants;

/**
 * @author Tessa
 *
 */
public class RectangleElement extends AngledGeometricElement
{
	/**
	 * Constructor first point => lower left corner second point => upper right corner
	 */
	public RectangleElement(Point x, Point y)
	{
		
		
	}
	
	@Override
	protected String getJSONClassName()
	{
		return Constants.GEOMETRIC_ANGLED_RECTANGLE_ELEMENT;
	}

	@Override
	public GeometricModelElement cloneElement()
	{
		// TODO Auto-generated method stub
		return null;
	}

}
