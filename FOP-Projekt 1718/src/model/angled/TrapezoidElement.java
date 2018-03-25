/**
 * 
 */
package model.angled;

import model.GeometricModelElement;
import model.Point;
import util.Constants;

/**
 * @author Malin
 *
 */
public class TrapezoidElement extends AngledGeometricElement {
	
	Point a;
	Point b;
	Point c;
	Point d;
	
	public TrapezoidElement(Point A, Point B, Point C, Point D) {
		this.a = A;
		this.b = B;
		this.c = C;
		this.d = D;
	}
	
	@Override
	protected String getJSONClassName() {
		return Constants.GEOMETRIC_ANGLED_TRAPEZOID_ELEMENT;
	}

	@Override
	public TrapezoidElement cloneElement()
	{
		TrapezoidElement trapezoid = new TrapezoidElement(a, b, c, d);
		Point CloneA = new Point(a.getX(), a.getY());
		Point CloneB = new Point(b.getX(), b.getY());
		Point CloneC = new Point(c.getX(), c.getY());
		Point CloneD = new Point(d.getX(), d.getY());
		return trapezoid;
	}
}
