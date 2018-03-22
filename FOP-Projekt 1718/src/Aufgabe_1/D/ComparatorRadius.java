package Aufgabe_1.D;

import java.util.Comparator;

import model.round.CircleElement;

/**
 * Die Klasse implementiert einen java.util.Comparator, welcher den Vergleich anhang des Radius durchführt. Dabei ist
 * ein kleinerer Radius als kleiner zu bewerten.
 */
public class ComparatorRadius implements Comparator<CircleElement> {
	/**
	 * Implementieren Sie die Metode compare der Klasse ComparatorRadius, welche einen java.util.Comparator
	 * implementiert. Die Methode führt den Vergleich anhand des Radius durch. Dabei ist ein kleinerer Radius als
	 * kleiner zu bewerten.
	 */
	@Override
	public int compare(CircleElement elem1, CircleElement elem2) {
		double elem1X1=elem1.getPoint(0).getX(); 
		double elem1X2=elem1.getPoint(1).getX();
		double elem2X1=elem2.getPoint(0).getX();
		double elem2X2=elem2.getPoint(1).getX();
		double deltaElem1=(elem1X1-elem1X2)/2;
		double deltaElem2=(elem2X1-elem2X2)/2;
		int ergebniss=(int) (deltaElem1-deltaElem2);
		return ergebniss;
	}
}