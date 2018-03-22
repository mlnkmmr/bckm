package model.angled;

import model.GeometricModelElement;
import model.Point;
import util.Constants;

public class TriangleElement extends AngledGeometricElement {
	
	private Point a;
	private Point b;
	private Point c;

	public TriangleElement (Point A, Point B, Point C){
		a=A;
		b=B;
		c=C;
		
	}
		
	
	@Override
	protected String getJSONClassName() {
		return Constants.GEOMETRIC_ANGLED_TRIANGLE_ELEMENT;
	}
	
	@Override
	public TriangleElement cloneElement() {
		TriangleElement triangle = new TriangleElement(a, b, c);
		Point CloneC=new Point(c.getX(), c.getY());
		Point CloneA=new Point(a.getX(), a.getY());
		Point CloneB=new Point(b.getX(), b.getY());
		return triangle;
	}
}
