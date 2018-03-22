package model.angled;

import model.GeometricModelElement;
import util.Constants;
import model.Point;

public class EquilateralTriangleElement extends AngledGeometricElement{
	
	private Point a;
	private Point b;
	private Point c;
	
	//Punkt A soll hierbei der Punkt n�her am Ursprung sein, es word ein dritter Punkt oberhalb der 3 Punkte berechnet
	public EquilateralTriangleElement (Point A, Point B){
		a=A;
		b=B;
		c.setX((b.getX()-a.getX())*Math.cos(Math.toRadians(60))-(b.getY()-a.getY())*Math.sin(Math.toRadians(60))+a.getX());
		c.setX((b.getX()-a.getX())*Math.sin(Math.toRadians(60))-(b.getY()-a.getY())*Math.cos(Math.toRadians(60))+a.getY());
	}

	
	
	@Override
	protected String getJSONClassName() {
		return Constants.GEOMETRIC_ANGLED_EQUILATERAL_TRIANGLE_ELEMENT;
	}

	@Override
	public GeometricModelElement cloneElement() {

		Point CloneA=new Point(a.getX(), a.getY());
		Point CloneB=new Point(b.getX(), b.getY());
		EquilateralTriangleElement Clone= new EquilateralTriangleElement(CloneA, CloneB);
		return null;
	}
}