package Aufgabe_1.A;

import data.ListItem;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Tasks of subproject 1.A
 * 
 * @author Lukas Roehr
 * @author David Koehler
 * @author Tessa Cr��mann
 * @param <T>
 *            Generic Type
 */
public class A<T> {

	/**
	 * Für i = 0, 1, 2, ... vertauscht die Methode die Elemente an den Indizes 3i und 3i + 2, d.h.: Das Element, das
	 * vorher an Index 3i war, ist hinterher an Index 3i + 2 und umgekehrt. Ist kein komplettes Triple mehr übrig, so
	 * bricht die Methode ab und ist fertig. Falls eine null-Referenz übergeben wird, soll eine IllegalArgumentException
	 * geworfen werden. Implementieren Sie diese Methode rekursiv.
	 * 
	 * @param arr
	 *            the array to work on
	 * 
	 * @throws IllegalArgumentException
	 *             if arr is null
	 */
	
	public void invertTriples(T[] arr) throws IllegalArgumentException
	{
		if(arr == null)
		{
			throw new IllegalArgumentException("arr ist null");
		}
		
		T swap = arr[0];
		arr[0] = arr[2];
		arr[2] = swap; 
		T[] help = Arrays.copyOf(arr, 3); 
		T[] narr = Arrays.copyOfRange(arr, 3, arr.length - 1); 
		
		if(narr.length < 3)
		{
			return;
		}
		else
		{
			invertTriples(narr);
		}
		
		arr = connect(help, narr);
	}

	/**
	 * Die Hilfsmethode f�gt 2 Arrays zusammen, indem es das erste auf die gemeinsame L�nge erweitert und dann die Arrays zusammenf�gt.
	 * @param eins erstes Array, an welches das 2. angeh�ngt wird.
	 * @param zwei zweites Array. 
	 * @return T[] return 
	 */
	public T[] connect(T[] eins, T[] zwei)
	{
		T[] result = Arrays.copyOf(eins, eins.length + zwei.length);
		System.arraycopy(zwei, 0, result, eins.length, zwei.length);
		return result;
	}
	
	/**
	 * Fügt ein Listenelement mit dem Schlüsselwert key am Anfang der Liste ein und gibt diesen neuen Listenkopf zurück.
	 * Hierfür darf ein neues Listenelement erstellt werden. Implementieren Sie diese Methode in konstanter Laufzeit.
	 * 
	 * @param lst
	 *            the list to add the element to the head
	 * @param key
	 *            the key to set for the new list head
	 * @return the new List
	 */
	public ListItem<T> insertSingleHead(ListItem<T> lst, T key) 
	{
		ListItem<T> l = new ListItem<T>(key);
		l.next = lst;
		return l;
	}

	/**
	 * Die Methode entfernt alle Listenelemente, deren Schlüsselwert gleich dem Parameter key ist, aus dem Parameter lst
	 * und gibt die resultierende Liste zurück. Nutzen Sie zum Vergleich den Parameter cmp vom Typ java.util.Comparator.
	 * Falls für cmp oder key eine null-Referenz übergeben wird, soll eine IllegalArgumentException geworfen werden.
	 * Implementieren Sie diese Methode rekursiv.
	 * 
	 * @param lst
	 *            the list to work on
	 * @param key
	 *            comparison element
	 * @param cmp
	 *            comparator
	 * @return the new list
	 * @throws IllegalArgumentException
	 *             if key or cmp is null
	 */
	
	public ListItem<T> removeElementsEqualX(ListItem<T> lst, T key, Comparator<T> cmp) throws IllegalArgumentException 
	{
		if(cmp == null || key == null)
		{
			throw new IllegalArgumentException("cmp oder die Liste sind null");
		}
		
		if(lst == null)
		{
			return null;
		}
		
		else if(cmp.compare(lst.key, key) == 0)
		{
			if(lst.next == null)
			{
				return null;
			}
			lst = lst.next;
			removeElementsEqualX(lst, key, cmp);
			return lst;
		}
		else 
		{
			if(lst.next == null)
			{
			    return lst;
			}
			if(cmp.compare(lst.next.key, key) == 0)
			{
				lst.next = lst.next.next;
			}
			if(cmp.compare(lst.next.key, key) != 0)
			{
				removeElementsEqualX(lst.next, key, cmp);
				return lst;
			}
			else
			{
				removeElementsEqualX(lst, key, cmp);
				return lst;
			}
		}
		
	}

	/**
	 * Die Methode verschiebt alle Listenelemente des Parameters lst um eine Stelle nach links. Das erste Element wird
	 * das neue letzte Element der Liste. Die Methode gibt den neuen Kopf der korrekt im Ring nach links geshifteten
	 * Liste zurück. Implementieren Sie diese Methode iterativ.
	 * 
	 * @param lst
	 *            the list to work on
	 * @return the new list
	 */
	public ListItem<T> ringShiftLeft(ListItem<T> lst) 
	{
		ListItem<T> rueckgabe = lst.next;
		ListItem<T> current = lst; 
		while(current.next != null)
		{
			current = current.next;
		}
		current.next = lst;
		lst.next = null;
		return rueckgabe;
	}

	/**
	 * Die Methode erstellt eine zusammenhänge Liste aus dem Parameter lsts. Dazu sollen alle Listen des Parameters lsts
	 * in der ursprünglichen Reihenfolge hintereinander angefägt werden und der Kopf der resultierenden Liste
	 * zurückgegeben werden. Falls für lsts eine null-Referenz übergeben wird, soll eine IllegalArgumentException
	 * geworfen werden; eine Liste von leeren Listen (also null als Schlüsselwert von lsts) ist hingegen zulässig.
	 * Hierfür dürfen neue Listenelemente der Klasse ListItem<ListItem<T>> erstellt werden. Implementieren Sie diese
	 * Methode rekursiv.
	 * 
	 * @param lsts
	 *            the lists to work on
	 * @return linked list
	 * @throws IllegalArgumentException
	 *             if lsts is null.
	 */
	
	public ListItem<T> listsInList(ListItem<ListItem<T>> lsts) throws IllegalArgumentException 
	{
		if(lsts == null)
		{
			throw new IllegalArgumentException("Die Liste von Listen ist null");
		}
		if(lsts.next == null)
		{
			return lsts.key;
		}
		
		ListItem<T> lastlist = null;
		if(lsts.next != null)
		{
			lastlist = listsInList(lsts.next);
		}
		
		ListItem<T> nlst = lsts.key;
		findlast(nlst).next = lastlist;
		return nlst;
	}
	
	/**
	 * Die Funktion geht die Liste durch um das Letzte Element der Liste zu finden und zur�ckzugeben.
	 * @param lst Die �bergebene Liste
	 * @return Das letzte Listenelement. 
	 */
	public ListItem<T> findlast(ListItem<T> lst)
	{
		if(lst.next != null)
		{
			lst = findlast(lst.next);
		}
		return lst;
	}
	
	/**
	 * Die Methode überträgt alle Runs des Parameters arr als Liste in eine Liste und gibt den Kopf der erstellten
	 * Liste von Listen zurück. Nutzen Sie zum Vergleich den Parameter cmp. Falls für arr oder cmp eine null-Referenz
	 * übergeben wird soll eine IllegalArgumentException geworfen werden. Wird ein Array der Länge null übergeben, so
	 * ist null zurückzugeben. Hierfür dürfen neue Listenelemente erstellt werden. Implementieren Sie diese Methode
	 * iterativ.
	 * 
	 * @param arr
	 *            the array to work on
	 * @param cmp
	 *            the Comparator to use for finding runs
	 * @return a list of lists with all ascend sorted runs of the array
	 * @throws IllegalArgumentException
	 *             if arr or cmp is null
	 */
	public ListItem<ListItem<T>> arrayRunsToListOfLists(T[] arr, Comparator<T> cmp) throws IllegalArgumentException {
		if(arr == null || cmp == null)
		{
			throw new IllegalArgumentException("arr oder cmp sind null");
		}
		/*ListItem<ListItem<T>> nlst = new ListItem<ListItem<T>>(null);
		//ListItem<T> einzelneLst = new ListItem<T>(arr[0]);
		for(int i = 0; i < arr.length; i++)
		{
			while(cmp.compare(arr[i], arr[i+1]) == -1)
			{
				//einzelneLst.next.insert(arr[i+1]);
				ListItem<T> einzelneLst = new ListItem<T>(arr[i+1]);
				
			}
		}
		*/
		/*ListItem<T> fistLast = new ListItem<T>(arr[0]);
		for(int i = 0; i < arr.length; i++)
		{
			
		}
		*/
		return null;
		
		
		
		
		
		
		
		
	}
}