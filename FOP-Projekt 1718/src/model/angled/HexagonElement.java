/**
 * 
 */
package model.angled;

import model.GeometricModelElement;
import model.Point;
import util.Constants;

/**
 * @author Robin Mackert
 *
 */
public class HexagonElement extends AngledGeometricElement {
	Point a,b,c,d,e,f;

	
	public HexagonElement(Point pA,Point pB,Point pC,Point pD,Point pE,Point pF) {
		a=pA;
		b=pB;
		c=pC;
		d=pD;
		e=pE;
		f=pF;
		
	}
	@Override
	protected String getJSONClassName() {
		return Constants.GEOMETRIC_ANGLED_HEXAGON_ELEMENT;
	}

	@Override
	public GeometricModelElement cloneElement() {
		HexagonElement hexagon = new HexagonElement(a, b, c, d, e, f);
		// copy the points
		Point[] p = new Point[super.getPoints().length];
		for (int i = 0; i < p.length; i++) {
			Point old = super.getPoint(i);
			Point n = new Point(old.getX(), old.getY());
			p[i] = n;
		}
		hexagon.setPoints(p);
		return hexagon;

	}

}
