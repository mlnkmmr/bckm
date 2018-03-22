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
public class RegularHexagonElement extends HexagonElement {

	public RegularHexagonElement(Point pA, Point pB, Point pC, Point pD, Point pE, Point pF) {
		super(pA, pB, pC, pD, pE, pF);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected String getJSONClassName() {
		return Constants.GEOMETRIC_ANGLED_HEXAGON_REGULARHEXAGON_ELEMENT;
	}

	@Override
	public GeometricModelElement cloneElement() {
		RegularHexagonElement regularHexagon = new RegularHexagonElement(a, b, c, d, e, f);
		// copy the points
		Point[] p = new Point[super.getPoints().length];
		for (int i = 0; i < p.length; i++) {
			Point old = super.getPoint(i);
			Point n = new Point(old.getX(), old.getY());
			p[i] = n;
		}
		regularHexagon.setPoints(p);
		return regularHexagon;

	}

}
