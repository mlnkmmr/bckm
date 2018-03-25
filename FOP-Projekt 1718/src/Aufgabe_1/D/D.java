package Aufgabe_1.D;

import java.lang.reflect.Array;
import java.util.Comparator;
import data.ListItem;

/**
 * Tasks of subproject 1.D
 * 
 * @author Lukas Roehr
 * @author David Koehler
 * @param <T>
 *            Generic Type
 */
public class D<T> {

	/**
	 * Die Methode vertauscht die Elemente an den zwei angegebenen Indizes. Falls
	 * f�r arr eine null-Referenz übergeben wird oder einer der Indizes nicht in dem
	 * Array liegt, soll eine IllegalArgumentException geworfen werden.
	 * Implementieren Sie diese Methode in konstanter Laufzeit.
	 * 
	 * @param arr
	 *            The array to work on
	 * @param ind1
	 *            Index of the first element
	 * @param ind2
	 *            Index of the second element
	 * @return 
	 * @throws IllegalArgumentException
	 *             if arr is null or Indices is invalid.
	 */
	public Integer[] switchElements(T[] arr, int ind1, int ind2) throws IllegalArgumentException {
		if (arr[ind1].equals(null) || arr[ind2].equals(null) || ind1 >= arr.length || ind2 >= arr.length || ind1 < 0
				|| ind2 < 0) {
			throw new IllegalArgumentException(
					"Indizes nicht im Gültigkeitsbereich oder Nullreferenz an eimen der Indizes");
		} else {
			T stack = arr[ind1];
			arr[ind1] = arr[ind2];
			arr[ind2] = stack;
		}
		return;
	}

	/**
	 * Die Methode fügt die Liste elem an das Ende von lst an und gibt das Ergebnis
	 * zurück. Implementieren Sie diese Methode iterativ.
	 * 
	 * @param lst
	 *            the list to work on
	 * @param elem
	 *            the list element(s) to add to the end
	 * @return the list lst with elem added to the end
	 */
	public ListItem<T> insertLast(ListItem<T> lst, ListItem<T> elem) {
		ListItem<T> curr = lst;
		while (curr.next != null) {
			curr = curr.next;
		}
		curr.next = elem;

		return lst;
	}

	/**
	 * Die Methode löscht das zweitgrößte Element aus der Eingabeliste. Ist dieses
	 * Element nicht enthalten, so ist es bereits als gelöscht anzusehen. Falls für
	 * cmp eine null-Referenz übergeben wird, soll eine IllegalArgumentException
	 * geworfen werden. Implementieren Sie diese Methode iterativ.
	 *
	 * @param lst
	 *            the list to work on
	 * @param cmp
	 *            the comparator to detect the second max element
	 * @return the list lst without the second biggest element
	 * @throws IllegalArgumentException
	 */
	public ListItem<T> removeSecMaxElement(ListItem<T> lst, Comparator<T> cmp) throws IllegalArgumentException {
		if (cmp == null) {
			throw new IllegalArgumentException("Comparator is null");

		} else {
			ListItem<T> curr = lst;
			ListItem<T> curr2 = lst;
			T secMaxElem = null;
			T maxElem = curr.key;

			while (curr.next != null) {
				if (cmp.compare(curr.key, secMaxElem) > 0 && cmp.compare(curr.key, maxElem) < 0
						&& cmp.compare(curr.key, curr.next.key) != 0)
					secMaxElem = curr.key;
				curr = curr.next;
			}
			while (curr2.next != null) {
				if (curr2.key.equals(secMaxElem))
					return lst.next;
				if (curr2.next.key.equals(secMaxElem))
					curr2.next = curr2.next.next;
				curr2 = curr2.next;
			}

		}
		return lst;
	}

	/**
	 * Für i = 1,2,3,... vertauscht die Methode die Schl�sselwerte an den Positionen
	 * 3i - 2 und 3i, d.h.: Das Element, das vorher an Position 3i - 2 war, ist
	 * hinterher an Position 3i und umgekehrt. Ist kein komplettes Triple mehr
	 * übrig, auf dem die Operation ausgeführt werden kann, so bricht die Methode ab
	 * und ist fertig. Falls eine null-Referenz übergeben wird, soll eine
	 * IllegalArgumentException geworfen werden. Implementieren Sie diese Methode
	 * rekursiv.
	 * 
	 * @param lst
	 *            the list to work on
	 * @return the list where all complete triples are inverted
	 * @throws IllegalArgumentException
	 */
	public ListItem<T> invertTriples(ListItem<T> lst) throws IllegalArgumentException {
		if (lst == null)
			throw new IllegalArgumentException("Übergebene Liste == null");
		ListItem<T> curr = lst;
		helpInvertTriples(curr);
		return lst;
	}

	/**
	 * Hilfsfunktion von invertTriples. Führt die Rekursion durch.
	 * 
	 * @param curr
	 * @throws Exception
	 */
	private void helpInvertTriples(ListItem<T> curr) {
		if (curr.next == null || curr.next.next == null)
			return;
		if (curr.next.next != null) {
			ListItem<T> stack = curr.next.next;
			curr.next.next = curr;
			curr.next.next = stack;
		}
		if (curr.next.next.next != null)
			helpInvertTriples(curr.next.next.next);

	}

	/**
	 * Die Methode erhält eine Liste und gibt eine Liste von genau zwei Listen
	 * zurück, wobei alle Elemente an einer ungeraden Position der Eingabeliste in
	 * der ersten Liste zu finden sind, alle Elemente der Eingabeliste mit einer
	 * geraden Position in der zweiten Liste. Hierfür dürfen neue Listenelemente der
	 * Klasse ListItem<ListItem<T>> erstellt werden. Implementieren Sie diese
	 * Methode rekursiv.
	 *
	 * @param lst
	 *            the list to split
	 * @return a list of two lists where all list elements of the input list are
	 *         located
	 */
	public ListItem<ListItem<T>> divideAlternatinglyIntoLists(ListItem<T> lst) {;
		ListItem<T> left = lst;
		ListItem<T> right = lst.next;
		splitList(left);
		splitList(right);
		ListItem<ListItem<T>> first = new ListItem<ListItem<T>>(left);
		ListItem<ListItem<T>> second=new ListItem<ListItem<T>>(left);
		first.next=second;
		return first;
		
	}
	/**
	 * Teilt die Eingabeliste in zwei indem nur jedes 2te Element genommen wird.
	 * @param currList
	 */
	private void splitList(ListItem<T> currList) {
		if (currList.next == null || currList.next.next == null)
			return;
		else {
			currList.next = currList.next.next;
			splitList(currList.next);
		}
	}

	/**
	 * Die Methode erhält eine Liste und wandelt diese in ein Array um, d.h. genau
	 * alle Schlüsselwerte der Liste sind in dem Array, welches zurückgegeben wird,
	 * in ursprünglicher Reihenfolge enthalten. Sind keine Schlüsselwerte in der
	 * Liste enthalten, so soll ein Array der Länge null zurückgegeben werden.
	 * Implementieren Sie diese Methode iterativ.
	 *
	 * 
	 * @param lst
	 *            the list to convert
	 * @return a array with all key values of the given list
	 */
	public T[] listIntoArray(ListItem<T> lst, Class<?> type) {
		ListItem<T> curr = lst;
		T[] arr = null;
		int i = 0;
		while (lst.next != null) {
			Array.set(arr, i, curr);
			i++;
			curr = curr.next;
		}
		return arr;
	}
}
