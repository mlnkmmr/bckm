package Aufgabe_1.B;

import java.util.Comparator;

import model.round.RoundGeometricElement;

/**
 * Die Klasse implementiert einen java.util.Comparator, welcher den Vergleich anhang der Fläche durchführt. Dabei ist
 * eine kleinere Fläche als kleiner zu bewerten.
 */
public class ComparatorSurface implements Comparator<RoundGeometricElement> {
	/**
	 * Implementieren Sie die Metode compare der Klasse ComparatorSurface, welche einen java.util.Comparator
	 * implementiert. Die Methode führt den Vergleich anhand der Fläche durch. Dabei ist eine kleinere Fläche als
	 * kleiner anzusehen.
	 */
	@Override
	public int compare(RoundGeometricElement elem1, RoundGeometricElement elem2) {
		
		double x1=elem1.getPoints()[0].getX();
		double x2=elem1.getPoints()[1].getX();
		double size1=0;
		double size2=0;
		if(x1<x2){
		  size1=Math.PI*((x2-x1)/2)*((x2-x1)/2);
		}
		else{
		  size1=Math.PI*((x1-x2)/2)*((x1-x2)/2);
		}
		
		double x3=elem2.getPoints()[0].getX();
		double x4=elem2.getPoints()[1].getX();
		if(x3<x4){
		  size2=Math.PI*((x4-x3)/2)*((x3-x4)/2);
		}
		else{
		  size2=Math.PI*((x3-x4)/2)*((x3-x4)/2);
		}
		
		if(size1<size2){
		return -1;
		}
		else if(size2>size1){
			return 1;
		}
		else
		return 0;
	}
}