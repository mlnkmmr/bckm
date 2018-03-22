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
	
	public TrapezoidElement(Point a, Point b, Point c, Point d) {
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
	}
	
	@Override
	protected String getJSONClassName() {
		return Constants.GEOMETRIC_ANGLED_TRAPEZOID_ELEMENT;
	}

	@Override
	public TrapezoidElement cloneElement() {
		TrapezoidElement trapezoid = new TrapezoidElement(a, b, c, d);

		Point[] p = new Point[super.getPoints().length];
		for (int i = 0; i < p.length; i++) {
			Point old = super.getPoint(i);
			Point n = new Point(old.getX(), old.getY());
			p[i] = n;
		}
		trapezoid.setPoints(p);
		trapezoid.changeColorCode(super.getColorCode());
		return trapezoid;
	}
}
