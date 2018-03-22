package Aufgabe_1.C;

import java.util.Comparator;

import model.Point;
import model.angled.AngledGeometricElement;

/**
 * Die Klasse implementiert einen java.util.Comparator, welcher den Vergleich
 * anhang des Umfangs durchführt. Dabei ist ein kleinerer Umfang als kleiner zu
 * bewerten.
 */
public class ComparatorRange implements Comparator<AngledGeometricElement> {
	/**
	 * Implementieren Sie die Metode compare der Klasse ComparatorRange, welche
	 * einen java.util.Comparator implementiert. Die Methode führt den Vergleich
	 * anhand des Umfangs durch. Dabei ist ein kleinerer Umfang als kleiner zu
	 * bewerten.
	 */
	@Override
	public int compare(AngledGeometricElement elem1, AngledGeometricElement elem2) {
		if (range(elem1) < range(elem2))
			return -1;
		if (range(elem1) == range(elem2))
			return 0;
		else // (range(elem1) > range(elem2))
			return 1;
	}

	private double range (AngledGeometricElement elem) {
		double distanceSum = 0;
		int numberPoints = elem.getNumberOfPoints();
		Point[] points = elem.getPoints();
		for (int i = 0; i < numberPoints; i++) {
			distanceSum += (Math.abs(points[i].getX() - points[(i + 1) % numberPoints].getX()))
					+ (Math.abs(points[i].getY() - points[(i + 1) % numberPoints].getY()));
		}
		return distanceSum;
	}
}