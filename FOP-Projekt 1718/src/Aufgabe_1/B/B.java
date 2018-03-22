package Aufgabe_1.B;

import data.ListItem;

import java.lang.reflect.Array;
import java.util.Comparator;

/**
 * Tasks of subproject 1.B
 *
 * @author Lukas Roehr
 * @author David Koehler
 * @param <T>
 *            Generic Type
 */
public class B<T> {

	/**
	 * Die Methode rotiert alle vollständigen Quadruple5 im Ring nach links, d.h. solange noch vier Elemente übrig sind,
	 * werden alle Elemente dieses Quadruples um eins nach links geschoben, das erste Element wird zum letzten. Falls
	 * für arr eine null-Referenz übergeben wird, soll eine IllegalArgumentException geworfen werden. Implementieren Sie
	 * diese Methode rekursiv.
	 * 
	 * @param arr
	 *            the array to work on
	 * @throws IllegalArgumentException
	 *             if arr is null
	 */
	public void rotateQuadrupleLeft(T[] arr) throws IllegalArgumentException {
		if(arr==null)
			throw new IllegalArgumentException("The array must be unequal null.");
		rotateQuadrupleLeftHelper(arr, 0);
	}
	public void rotateQuadrupleLeftHelper(T[] arr, int i){
		if(i+3<arr.length){
			T tmp0=arr[0+i];
			T tmp1=arr[1+i];
			T tmp2=arr[2+i];
			T tmp3=arr[3+i];
			arr[0+i]=tmp1;
			arr[1+i]=tmp2;
			arr[2+i]=tmp3;
			arr[4+i]=tmp0;
			rotateQuadrupleLeftHelper(arr, i+4);
		}
		else return;
	}

	/**
	 * Fügt den Parameter key in den gemäß cmp aufsteigend sortierten Parameter lst ein. Nach dem Einfügen muss der
	 * Parameter lst aufsteigend nach cmp vom Typ java.util.Comparator sortiert sein. Die Methode gibt den Kopf der
	 * Liste zurück. Hierfür darf ein neues Listenelement erstellt werden. Implementieren Sie diese Methode rekursiv.
	 * 
	 * @param lst
	 *            list in which the element is to be inserted
	 * @param key
	 *            key to insert
	 * @param cmp
	 *            comparator
	 * @return the new list
	 * @throws IllegalArgumentException
	 *             if key or cmp is null
	 */
	public ListItem<T> insertSingle(ListItem<T> lst, T key, Comparator<T> cmp) throws IllegalArgumentException {
		if (key == null || cmp == null)
			throw new IllegalArgumentException("The key and the comparator must be unequal null.");
		insert(lst, key, cmp);
		return lst;
	}
	public void insert(ListItem<T> lst, T key, Comparator <T> cmp){
		if(cmp.compare(lst.key, key)>0 && cmp.compare(lst.next.key, key)<0){
			ListItem<T> tmp=lst.next;
			ListItem<T> dummy = new ListItem<>(key);
			dummy.next=tmp;
			lst.next=dummy;
		}
		else insert(lst.next, key, cmp);
	}
	

	/**
	 * Löscht das Kopf-Element des Parameters lst. Die Methode gibt den neuen Listenkopf zurück. Wenn für lst eine
	 * null-Referenz übergeben wird, ist der Kopf als bereits gelöscht anzusehen. Implementieren Sie diese Methode in
	 * konstanter Laufzeit.
	 * 
	 * @param lst
	 *            the list to work on
	 * @return list with a new head
	 */
	public ListItem<T> removeHead(ListItem<T> lst) {
		if(lst==null)
		return null;
		ListItem<T> tmp=lst.next;
		lst.next=null;
		return tmp;
	}

	/**
	 * Die Methode verschiebt alle Listenelemente des Parameters lst um eine Stelle nach rechts. Das letzte Element wird
	 * der neue Kopf der Liste. Die Methode gibt den neuen Kopf der korrekt im Ring nach rechts geshifteten Liste
	 * zurück. Implementieren Sie diese Methode rekursiv.
	 * 
	 * @param lst
	 *            the list to work on
	 * @return the new list
	 */
	public ListItem<T> ringShiftRight(ListItem<T> lst) {
		if(lst==null)
	      return null;
		ListItem<T> head= getLast(lst);
		ListItem<T> second= lst;
		ListItem<T> last= vorletztesELement(lst);
		last.next=null;
		head.next=second;
		  return head;
	}
	/**
	 * Die Methode geht die Liste rekursiv durch und gibt das letzte Element 
	 * zur�ck
	 * @param lst Die Liste deren Letztes Element zur�ckgegeben werden soll
	 * @return Gibt das letzte Listenelement zur�ck
	 */
	public ListItem<T> getLast(ListItem<T> lst){
		if(lst.next==null)
			return lst;
		else
		    getLast(lst);
		    return null;
	}
	/**
	 * Die Methode geht die Liste rekursiv durch und gibt das vorletzte Element 
	 * zur�ck
	 * @param lst Die Liste deren Letztes Element zur�ckgegeben werden soll
	 * @return Gibt das vorletzte Listenelement zur�ck
	 */
	public ListItem<T> vorletztesELement(ListItem<T> lst){
		if(lst.next.next==null)
			return lst;
		else
		    getLast(lst);
		    return null;
	}

	/**
	 * Die Methode teilt die übergebene Liste in eine Liste von mehreren einelementrigen Listen auf, wobei jeder
	 * Schlüsselwert der Eingabeliste zu genau einem Schlüsselwert einer einelementrigen Liste wird. Hierfür dürfen neue
	 * Listenelemente der Klasse ListItem<ListItem<T>> erstellt werden. Implementieren Sie diese Aufgabe iterativ.
	 * 
	 * @param lst
	 *            the list to split
	 * @return List of (List of T)
	 */
	public ListItem<ListItem<T>> listInLists(ListItem<T> lst) {
		if(lst==null){
			return null;
		}
		ListItem<ListItem<T>> first=new ListItem<>(lst);
		ListItem<ListItem<T>> tmp=first;
		lst.next=null;
		lst=lst.next;
		ListItem<T> size=lst;
		for(int i=0; i<size.getSize(); i++){
			ListItem<ListItem<T>> second=new ListItem<>(lst);
			first.next=second;
			first=second;
			ListItem<T> nxt=lst.next;
			lst.next=null;
			lst=nxt;
		}
		return tmp;
	}

	

	/**
	 * Die Methode selektiert alle Schlüsselwerte der Liste lst, die vom übergebenen Typ type sind. Diese Elemente
	 * werden in einem Array zurückgegeben. Falls für type oder für lst eine null-Referent übergeben wird, soll eine
	 * IllegalArgumentException geworfen werden. Implementieren Sie diese Aufgabe iterativ.
	 * 
	 * @param lst
	 *            the list to select of
	 * @param type
	 *            the class to select, must be a subclass of the generic type T
	 * @return a array with all keys of the List that are the given class type
	 * @throws IllegalArgumentException
	 *             if type is null
	 */
	public T[] selectType(ListItem<T> lst, Class<? extends T> type) throws IllegalArgumentException {
		if (type == null || lst == null)
			throw new IllegalArgumentException("The list and the type must be unequal null.");
		int j=0;
		ListItem<T> first=lst;
		while(lst!=null){
			if(type.isInstance(lst.key))
					j++;
			lst=lst.next;
		}
		T[] arr=(T[])Array.newInstance(type, j);
		lst=first;
		int a=0;
		while(lst!=null){
			if(type.isInstance(lst.key)){
			arr[a]=lst.key;
			a++;
			}
			lst=lst.next;
		}
		return arr;
	}
}