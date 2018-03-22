package Aufgabe_1.C;

import java.lang.reflect.Array;
import java.util.Comparator;

import data.ListItem;

/**
 * Tasks of subproject 1.C
 *
 * @author Lukas Roehr
 * @author David Koehler
 * @param <T>
 *            Generic Type
 */
public class C<T> {
	/**
	 * Die Methode kombiniert zwei nach dem übergebenem Comparator aufsteigend
	 * sortierte Arrays zu einem Array, das wiederum gemäß des Comparators
	 * aufsteigend sortiert ist, und gibt dieses zurück. Wird für cmp eine
	 * null-Referenz übergeben, so ist eine IllegalArgumentException zu werfen. Ist
	 * eines der beiden oder gar beide Arrays nicht aufsteigend gemäß cmp
	 * sortiert, so wird ebenfalls eine IllegalArgumentException geworfen. Wird für
	 * beide Arrays eine null-Referenz übergeben, so soll null zurückgegeben
	 * werden. Implementieren Sie diese Methode rekursiv.
	 * 
	 * @param arr1
	 *            the first array
	 * @param arr2
	 *            the second array to combine
	 * @param cmp
	 *            the comparator
	 * @return a combined Array with all elements of the two given arrays.
	 */
	public T[] combine(T[] arr1, T[] arr2, Comparator<T> cmp, Class<?> type) throws IllegalArgumentException {

		if (cmp == null || type == null) {
			throw new IllegalArgumentException("Comparator or type is null!");
		}
		if (arr1 == null && arr2 == null) {
			return null;
		}
		if (arr1 == null)
			return arr2;
		if (arr2 == null)
			return arr1;

		if (!isSorted(arr1, cmp, 0) || !isSorted(arr2, cmp, 0)) {
			throw new IllegalArgumentException("The arrays aren't sorted according to the comparator!");
		}

		T[] combined;
		try {
			combined = (T[]) Array.newInstance(type, arr1.length + arr2.length);
		} catch (Exception ex) {
			throw new IllegalArgumentException("Error while initializing array!");
		}
		return combineRec(combined, arr1, arr2, cmp, 0, 0);
	}

	private boolean isSorted(T[] arrx, Comparator<T> cmp, int offset) {
		if (arrx == null)
			throw new IllegalArgumentException("Array is empty!");
		if (offset + 1 == arrx.length)
			return true;
		if (cmp.compare(arrx[offset], arrx[offset + 1]) <= 0) {
			return isSorted(arrx, cmp, offset + 1);
		}
		return false;
	}

	private T[] combineRec(T[] combined, T[] arr1, T[] arr2, Comparator<T> cmp, int offset1, int offset2) {
		if (offset1 + offset2 == combined.length)
			return combined;
		if (offset1 + 1 == arr1.length) {
			combined[offset1 + offset2] = arr2[offset2];
			return combineRec(combined, arr1, arr2, cmp, offset1, offset2 + 1);
		}
		if (offset2 + 1 == arr2.length) {
			combined[offset1 + offset2] = arr1[offset1];
			return combineRec(combined, arr1, arr2, cmp, offset1 + 1, offset2);
		}
		int i = cmp.compare(arr1[offset1], arr2[offset2]);
		if (i <= 0) {
			combined[offset1 + offset2] = arr1[offset1];
			return combineRec(combined, arr1, arr2, cmp, offset1 + 1, offset2);
		} else if (i == 1) {
			combined[offset1 + offset2] = arr2[offset2];
			return combineRec(combined, arr1, arr2, cmp, offset1, offset2 + 1);
		}
		return null;
	}

	/**
	 * Die Methode fügt die komplette Liste head an den Anfang der Liste lst an und
	 * gibt den neuen Listenkopf zurück. Falls für head eine null-Referenz
	 * übergeben wird, soll eine IllegalArgumentException geworfen werden, es sei
	 * denn, lst ist ebenfalls null. Hierfür darf ein neues Listenelement erstellt
	 * werden. Implementieren Sie diese Methode rekursiv.
	 * 
	 * @param lst
	 *            the list where to add the new head onto
	 * @param head
	 *            the new head (may be longer than one element)
	 * @return the list with the new head in front
	 */
	public ListItem<T> insertHead(ListItem<T> lst, ListItem<T> head) {
		if (head == null) {
			if (lst != null)
				throw new IllegalArgumentException("head is null!");
			else
				return null;
		}
		insertHeadRec(lst, head);
		return head;
	}

	private void insertHeadRec(ListItem<T> lst, ListItem<T> head) {
		if (head.next == null) {
			head.next = lst;
			return;
		}
		insertHeadRec(lst, head.next);
	}

	/**
	 * Die Methode entfernt das letzte Listenelement aus der Liste lst und gibt die
	 * resultierende Liste zurück. Wenn für lst eine null-Referenz übergeben
	 * wird, ist das letzte Element als bereits gelöscht anzusehen. Implementieren
	 * Sie diese Methode iterativ.
	 * 
	 * @param lst
	 *            the list to work on
	 * @return the list without the last element
	 */
	public ListItem<T> removeLast(ListItem<T> lst) {
		if (lst == null)
			return null;
		while (lst.next.next != null) {
			lst = lst.next;
		}
		lst.next = null;
		return lst;
	}

	/**
	 * Die Methode invertiert die komplette Reihenfolge der Liste lst, d.h. das
	 * erste Element wird zum neuen letzten Element, das zweite zum neuen
	 * zweitletzten, usw. Implementieren Sie diese Methode iterativ.
	 * 
	 * @param lst
	 *            the list to work on
	 * @return the inverted list
	 */
	public ListItem<T> invert(ListItem<T> lst) {
		if (lst == null) {
			return null;
		}

		if (lst.next == null) {
			return lst;
		}
		if (lst.next.next == null) {
			ListItem<T> rtrn = lst.next;
			rtrn.next = lst;
			return rtrn;
		}
		ListItem<T> prior = lst;
		ListItem<T> curr = lst.next;
		ListItem<T> nxt = lst.next.next;
		if (curr == null)
			return lst;
		do {
			curr.next = prior;
			prior = curr;
			curr = nxt;
			if (curr != null) {
				nxt = curr.next;
			}
		} while (curr != null);
		return prior;
	}

	/**
	 * Die Methode gibt eine Liste zurück, die an gerader Position alle Elemente
	 * aus lst1 und an ungerader Position alle Elemente aus lst2 enthält. Sollte
	 * die Länge der beiden Listen unterschiedlich sein, so ist der Rest der
	 * längeren Liste anzuhängen. Implementieren Sie diese Methode rekursiv.
	 * 
	 * @param lst1
	 *            the first list
	 * @param lst2
	 *            the second list to work with
	 * @return the combined list
	 */
	public ListItem<T> combineLists(ListItem<T> lst1, ListItem<T> lst2) {
		if (lst1 == null) {
			return lst2;
		}
		if (lst2 == null) {
			return lst1;
		}
		lst1.next = combineLists(lst2.next, lst1.next);
		return lst1;
	}

	/**
	 * Die Methode gibt eine Liste zurück, in welcher alle Elemente des
	 * Eingabearrays in der ursprünglichen Reihenfolge als Schlüsselwerte der
	 * Liste zu finden sind. Falls für arr eine null-Referenz übergeben wird, soll
	 * eine IllegalArgumentException geworfen werden. Falls das Array die Länge
	 * null hat, soll null zurückgegeben werden. Hierfür dürfen neue
	 * Listenelemente erstellt werden. Implementieren Sie diese Methode iterativ.
	 * 
	 * @param arr
	 *            the array to convert
	 * @return a list where the keys are the elements of the given array
	 * @throws IllegalArgumentException
	 */
	public ListItem<T> arrayIntoList(T[] arr) throws IllegalArgumentException {
		if (arr == null)
			throw new IllegalArgumentException("array is null!");
		if (arr.length == 0) {
			return null;
		}
		ListItem<T> lstbegin = new ListItem<T>(arr[0]);
		ListItem<T> lstloop = lstbegin;
		for (int i = 1; i < arr.length; i++) {
			lstloop.next = (ListItem<T>) arr[i];
			lstloop = lstloop.next;
		}
		return lstbegin;
	}
}