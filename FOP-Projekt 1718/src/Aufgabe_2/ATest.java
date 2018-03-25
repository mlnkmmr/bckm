package Aufgabe_2;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.awt.Color;
import java.awt.List;
import java.lang.reflect.Array;
import java.util.Comparator;

import org.junit.Assert;
import org.junit.Before;

import Aufgabe_1.A.A;
import Aufgabe_1.A.ComparatorColor;
import Aufgabe_1.V.ComparatorInteger;
import Aufgabe_1.V.V;
import data.ListItem;
import model.GeometricModelElement;

public class ATest {

	private ListItem<Integer> lst1, lst2, lst3, lst4, lst5;
	private ListItem<Integer> lst1Test, lst2Test, lst3Test, lst4Test, lst5Test;
	private ListItem<ListItem<Integer>> outerList1, outerList2;
	protected V<Integer> vInt = new V<>();
	A<Integer> MeinA = new A<>();
	private Comparator<GeometricModelElement> cmpColor = new ComparatorColor();
	private Comparator<Integer> cmpInt = new ComparatorInteger();

	/*****************************************************************
	 * invertTriples
	 *****************************************************************/

	@Test
	public void invertTriples_Test_1() {
		Integer[] arr = { 1, 2, 3, 4, 5, 6 };
		Integer[] arrFin = { 3, 2, 1, 6, 5, 4 };
		MeinA.invertTriples(arr);
		assertArrayEquals(arr, arrFin);
	}

	@Test
	public void invertTriples_Test_2() {
		Integer[] arr = { 1, 2 };
		Integer[] arrFin = { 1, 2 };
		MeinA.invertTriples(arr);
		assertArrayEquals(arr, arrFin);
	}

	@Test
	public void invertTriples_Test_3() {
		Integer[] arr = { 1, 2, 3, 4, 5, 6, 7 };
		Integer[] arrFin = { 3, 2, 1, 6, 5, 4, 7 };
		MeinA.invertTriples(arr);
		assertArrayEquals(arr, arrFin);
	}

	@Test(expected = IllegalArgumentException.class)
	public void invertTriples_Test_4() {
		MeinA.invertTriples(null);
	}

	/*****************************************************************
	 * insertSingleHead
	 *****************************************************************/

	@Test
	public void insertSingleHead_Test_1() {
		lst1= new ListItem<Integer>(0);
		lst1.key = 1;

		int testInt = MeinA.insertSingleHead(lst1, 42).key;
		assertEquals(testInt, 42);

	}

	@Test
	public void insertSingleHead_Test_2() {
		//Initialize ListItems
		lst1= new ListItem<Integer>(0);
		lst2= new ListItem<Integer>(0);
		lst3= new ListItem<Integer>(0);
		lst4= new ListItem<Integer>(0);
		lst5= new ListItem<Integer>(0);
				
		lst1.key = 1;
		lst2.key = 2;
		lst3.key = 3;
		lst4.key = 4;
		lst5.key = 5;
		lst1.next = lst2;
		lst2.next = lst3;
		lst3.next = lst4;
		lst4.next = lst5;
		ListItem<Integer> a = MeinA.insertSingleHead(lst1, 17);
		int akey = a.key;
		int akeynext = a.next.key;
		assertEquals(akey, 17);
		assertEquals(akeynext, 1);
	}

	@Test
	public void insertSingleHead_Test_3() {
		//Initialize ListItems
		lst1= new ListItem<Integer>(0);
		lst2= new ListItem<Integer>(0);
		lst3= new ListItem<Integer>(0);
		lst4= new ListItem<Integer>(0);
		lst5= new ListItem<Integer>(0);
		
		lst1.key = 1;
		lst2.key = 3123;
		lst3.key = 3;
		lst4.key = 4;
		lst5.key = 5;
		lst1.next = lst2;
		lst2.next = lst3;
		lst3.next = lst4;
		lst4.next = lst5;
		ListItem<Integer> a = MeinA.insertSingleHead(lst1, 25);
		int akey = a.key;
		int akeynextnext = a.next.next.key;
		assertEquals(akey, 25);
		assertEquals(akeynextnext, 3123);
	}

	/*****************************************************************
	 * removeElementsEqualX
	 *****************************************************************/

	@Test
	public void removeElementsEqualX_Test_1() {
		//Initialize ListItems
		lst1= new ListItem<Integer>(0);
		lst2= new ListItem<Integer>(0);
		lst3= new ListItem<Integer>(0);
		lst4= new ListItem<Integer>(0);
		lst5= new ListItem<Integer>(0);
		lst1Test= new ListItem<Integer>(0);
		lst2Test= new ListItem<Integer>(0);
		lst3Test= new ListItem<Integer>(0);
		lst4Test= new ListItem<Integer>(0);
		lst5Test= new ListItem<Integer>(0);
		
		lst1.key = 1;
		lst2.key = 2;
		lst3.key = 3;
		lst4.key = 4;
		lst5.key = 5;
		lst1.next = lst2;
		lst2.next = lst3;
		lst3.next = lst4;
		lst4.next = lst5;
		lst1Test.key = 1;
		lst2Test.key = 2;
		lst3Test.key = 3;
		lst4Test.key = 4;
		lst5Test.key = 5;
		lst1Test.next = lst2Test;
		lst2Test.next = lst3Test;
		lst3Test.next = lst4Test;
		lst4Test.next = lst5Test;
		ListItem<Integer> a = MeinA.removeElementsEqualX(lst1, 1, cmpInt);// removing first
		int testkey1 = a.key;
		int testkey2 = lst1Test.next.key;
		assertEquals(testkey1, testkey2);

	}

	@Test
	public void removeElementsEqualX_Test_2() {
		//Initialize ListItems
		lst1= new ListItem<Integer>(0);
		lst2= new ListItem<Integer>(0);
		lst3= new ListItem<Integer>(0);
		lst4= new ListItem<Integer>(0);
		lst5= new ListItem<Integer>(0);
		lst1Test= new ListItem<Integer>(0);
		lst2Test= new ListItem<Integer>(0);
		lst3Test= new ListItem<Integer>(0);
		lst4Test= new ListItem<Integer>(0);
		lst5Test= new ListItem<Integer>(0);
		
		lst1.key = 1;
		lst2.key = 2;
		lst3.key = 3;
		lst4.key = 4;
		lst5.key = 5;
		lst1.next = lst2;
		lst2.next = lst3;
		lst3.next = lst4;
		lst4.next = lst5;
		lst1Test.key = 1;
		lst2Test.key = 2;
		lst3Test.key = 3;
		lst4Test.key = 4;
		lst5Test.key = 5;
		lst1Test.next = lst2Test;
		lst2Test.next = lst3Test;
		lst3Test.next = lst4Test;
		lst4Test.next = lst5Test;
		ListItem<Integer> a = MeinA.removeElementsEqualX(lst1, 2, cmpInt);// removing second
		int testkey1 = a.next.key;
		int testkey2 = lst1Test.next.next.key;
		assertEquals(testkey1, testkey2);
	}

	@Test
	public void removeElementsEqualX_Test_3() {
		//Initialize ListItems
		lst1= new ListItem<Integer>(0);
		lst2= new ListItem<Integer>(0);
		lst3= new ListItem<Integer>(0);
		lst4= new ListItem<Integer>(0);
		lst5= new ListItem<Integer>(0);
		
		lst1.key = 1;
		lst2.key = 2;
		lst3.key = 3;
		lst4.key = 4;
		lst5.key = 5;
		lst1.next = lst2;
		lst2.next = lst3;
		lst3.next = lst4;
		lst4.next = lst5;
		ListItem<Integer> a = MeinA.removeElementsEqualX(lst1, 2, cmpInt);// removing second
		ListItem<Integer> testkey1 = a.next.next.next.next;
		assertNull(testkey1);

	}

	@Test(expected = IllegalArgumentException.class)
	public void removeElementsEqualX_Test_4() {
		MeinA.removeElementsEqualX(null, null, cmpInt);
	}

	/*****************************************************************
	 * ringShiftLeft
	 *****************************************************************/

	@Test
	public void ringShiftLeft_Test_1() {
		//Initialize ListItems
		lst1= new ListItem<Integer>(0);
		lst2= new ListItem<Integer>(0);
		lst3= new ListItem<Integer>(0);
		lst4= new ListItem<Integer>(0);
		lst5= new ListItem<Integer>(0);
		lst1Test= new ListItem<Integer>(0);
		lst2Test= new ListItem<Integer>(0);
		lst3Test= new ListItem<Integer>(0);
		lst4Test= new ListItem<Integer>(0);
		lst5Test= new ListItem<Integer>(0);
		
		lst1.key = 1;
		lst2.key = 2;
		lst3.key = 3;
		lst4.key = 4;
		lst5.key = 5;
		lst1.next = lst2;
		lst2.next = lst3;
		lst3.next = lst4;
		lst4.next = lst5;
		lst1Test.key = 1;
		lst2Test.key = 2;
		lst3Test.key = 3;
		lst4Test.key = 4;
		lst5Test.key = 5;
		lst1Test.next = lst2Test;
		lst2Test.next = lst3Test;
		lst3Test.next = lst4Test;
		lst4Test.next = lst5Test;
		ListItem<Integer> newHead = MeinA.ringShiftLeft(lst1);
		int testKey1 = newHead.key;
		int testkey2 = lst1Test.next.key;
		assertEquals(testKey1, testkey2);
	}

	@Test
	public void ringShiftLeft_Test_2() {
		//Initialize ListItems
		lst1= new ListItem<Integer>(0);
		lst2= new ListItem<Integer>(0);
		lst3= new ListItem<Integer>(0);
		lst4= new ListItem<Integer>(0);
		lst5= new ListItem<Integer>(0);
		lst1Test= new ListItem<Integer>(0);
		lst2Test= new ListItem<Integer>(0);
		lst3Test= new ListItem<Integer>(0);
		lst4Test= new ListItem<Integer>(0);
		lst5Test= new ListItem<Integer>(0);
		
		lst1.key = 1;
		lst2.key = 2;
		lst3.key = 3;
		lst4.key = 4;
		lst5.key = 5;
		lst1.next = lst2;
		lst2.next = lst3;
		lst3.next = lst4;
		lst4.next = lst5;
		lst1Test.key = 1;
		lst2Test.key = 2;
		lst3Test.key = 3;
		lst4Test.key = 4;
		lst5Test.key = 5;
		lst1Test.next = lst2Test;
		lst2Test.next = lst3Test;
		lst3Test.next = lst4Test;
		lst4Test.next = lst5Test;
		ListItem<Integer> newHead = MeinA.ringShiftLeft(lst1);
		int testKey1 = newHead.next.next.next.next.key;
		int testkey2 = lst1Test.key;
		assertEquals(testKey1, testkey2);
	}

	@Test
	public void ringShiftLeft_Test_3() {
		//Initialize ListItems
		lst1= new ListItem<Integer>(0);
		lst2= new ListItem<Integer>(0);
		lst3= new ListItem<Integer>(0);
		lst4= new ListItem<Integer>(0);
		lst5= new ListItem<Integer>(0);
		lst1Test= new ListItem<Integer>(0);
		lst2Test= new ListItem<Integer>(0);
		lst3Test= new ListItem<Integer>(0);
		lst4Test= new ListItem<Integer>(0);
		lst5Test= new ListItem<Integer>(0);
		
		lst1.key = 1;
		lst2.key = 2;
		lst3.key = 3;
		lst4.key = 4;
		lst5.key = 5;
		lst1.next = lst2;
		lst2.next = lst3;
		lst3.next = lst4;
		lst4.next = lst5;
		lst1Test.key = 1;
		lst2Test.key = 2;
		lst3Test.key = 3;
		lst4Test.key = 4;
		lst5Test.key = 5;
		lst1Test.next = lst2Test;
		lst2Test.next = lst3Test;
		lst3Test.next = lst4Test;
		lst4Test.next = lst5Test;
		ListItem<Integer> newHead = MeinA.ringShiftLeft(lst1);
		int testKey1 = newHead.next.key;
		int testkey2 = lst1Test.next.next.key;
		assertEquals(testKey1, testkey2);
	}

	/*****************************************************************
	 * listsInList
	 *****************************************************************/

	@Test
	public void listsInList_Test_1() {
		//Initialize ListItems
		lst1= new ListItem<Integer>(0);
		lst2= new ListItem<Integer>(0);
		lst3= new ListItem<Integer>(0);
		lst4= new ListItem<Integer>(0);
		lst5= new ListItem<Integer>(0);
		lst1Test= new ListItem<Integer>(0);
		lst2Test= new ListItem<Integer>(0);
		lst3Test= new ListItem<Integer>(0);
		lst4Test= new ListItem<Integer>(0);
		lst5Test= new ListItem<Integer>(0);
		outerList1 = new ListItem<ListItem<Integer>>(null);
		outerList2 = new ListItem<ListItem<Integer>>(null);
		
		lst1.key = 1;
		lst2.key = 2;
		lst3.key = 3;
		lst1.next = lst2;
		lst2.next = lst3;
		lst3.next=null;
		lst4.key = 4;
		lst5.key = 5;
		lst4.next = lst5;
		lst5.next=null;
		outerList1.key = lst1;
		outerList2.key = lst4;
		outerList1.next = outerList2;
		lst1Test.key = 1;
		lst2Test.key = 2;
		lst3Test.key = 3;
		lst4Test.key = 4;
		lst5Test.key = 5;
		lst1Test.next = lst2Test;
		lst2Test.next = lst3Test;
		lst3Test.next = lst4Test;
		lst4Test.next = lst5Test;
		ListItem<Integer> a = MeinA.listsInList(outerList1);
		int testKey1 = a.key;
		int testKey2 = lst1Test.key;
		int testkey3 = a.next.key;
		int testkey4 = lst1Test.next.key;
		int testkey5 = a.next.next.key;
		int testkey6 = lst1Test.next.next.key;
		int testkey7 = a.next.next.next.key;
		int testkey8 = lst1Test.next.next.next.key;
		int testkey9 = a.next.next.next.next.key;
		int testkey10 = lst1Test.next.next.next.next.key;
		assertEquals(testKey1, testKey2); // Test die die Keys der zurückgegebenen Liste mit der TestListe vergleicht
		assertEquals(testkey3, testkey4);
		assertEquals(testkey5, testkey6);
		assertEquals(testkey7, testkey8);
		assertEquals(testkey9, testkey10);
	}

	@Test
	public void listsInList_Test_2() {
		//Initialize ListItems
		lst1= new ListItem<Integer>(0);
		lst2= new ListItem<Integer>(0);
		lst3= new ListItem<Integer>(0);
		lst4= new ListItem<Integer>(0);
		lst5= new ListItem<Integer>(0);
		lst1Test= new ListItem<Integer>(0);
		lst2Test= new ListItem<Integer>(0);
		lst3Test= new ListItem<Integer>(0);
		lst4Test= new ListItem<Integer>(0);
		lst5Test= new ListItem<Integer>(0);
		outerList1 = new ListItem<ListItem<Integer>>(null);
		outerList2 = new ListItem<ListItem<Integer>>(null);
		
		lst1.key = 1;
		lst2.key = 2;
		lst3.key = 3;
		lst4.key = 4;
		lst5.key = 5;
		lst1.next=null;
		lst2.next = lst3;
		lst3.next = lst4;
		lst4.next = lst5;
		lst5.next=null;
		outerList1.key = lst1;
		outerList2.key = lst2;
		outerList1.next = outerList2;
		lst1Test.key = 1;
		lst2Test.key = 2;
		lst3Test.key = 3;
		lst4Test.key = 4;
		lst5Test.key = 5;
		lst1Test.next = lst2Test;
		lst2Test.next = lst3Test;
		lst3Test.next = lst4Test;
		lst4Test.next = lst5Test;
		ListItem<Integer> a = MeinA.listsInList(outerList1);
		int testKey1 = a.key;
		int testKey2 = lst1Test.key;
		int testkey3 = a.next.key;
		int testkey4 = lst1Test.next.key;
		int testkey5 = a.next.next.key;
		int testkey6 = lst1Test.next.next.key;
		int testkey7 = a.next.next.next.key;
		int testkey8 = lst1Test.next.next.next.key;
		int testkey9 = a.next.next.next.next.key;
		int testkey10 = lst1Test.next.next.next.next.key;
		assertEquals(testKey1, testKey2);
		assertEquals(testkey3, testkey4);
		assertEquals(testkey5, testkey6);
		assertEquals(testkey7, testkey8);
		assertEquals(testkey9, testkey10);
	}

	@Test
	public void listsInList_Test_3() {
		//Initialize ListItems
		lst1= new ListItem<Integer>(0);
		lst2= new ListItem<Integer>(0);
		lst3= new ListItem<Integer>(0);
		lst4= new ListItem<Integer>(0);
		lst5= new ListItem<Integer>(0);
		lst1Test= new ListItem<Integer>(0);
		lst2Test= new ListItem<Integer>(0);
		lst3Test= new ListItem<Integer>(0);
		lst4Test= new ListItem<Integer>(0);
		lst5Test= new ListItem<Integer>(0);
		outerList1 = new ListItem<ListItem<Integer>>(null);
		outerList2 = new ListItem<ListItem<Integer>>(null);
		
		lst1.key = 1;
		lst2.key = 2;
		lst3.key = 3;
		lst4.key = 4;
		lst5.key = 5;
		lst1.next = lst2;
		lst2.next = lst3;
		lst3.next = lst4;
		lst4.next = lst5;
		outerList1.key = lst1;
		outerList2.key = null;
		outerList1.next = outerList2;
		lst1Test.key = 1;
		lst2Test.key = 2;
		lst3Test.key = 3;
		lst4Test.key = 4;
		lst5Test.key = 5;
		lst1Test.next = lst2Test;
		lst2Test.next = lst3Test;
		lst3Test.next = lst4Test;
		lst4Test.next = lst5Test;
		ListItem<Integer> a = MeinA.listsInList(outerList1);
		int testKey1 = a.key;
		int testKey2 = lst1Test.key;
		int testkey3 = a.next.key;
		int testkey4 = lst1Test.next.key;
		int testkey5 = a.next.next.key;
		int testkey6 = lst1Test.next.next.key;
		int testkey7 = a.next.next.next.key;
		int testkey8 = lst1Test.next.next.next.key;
		int testkey9 = a.next.next.next.next.key;
		int testkey10 = lst1Test.next.next.next.next.key;
		assertEquals(testKey1, testKey2);
		assertEquals(testkey3, testkey4);
		assertEquals(testkey5, testkey6);
		assertEquals(testkey7, testkey8);
		assertEquals(testkey9, testkey10);

	}

	@Test(expected = IllegalArgumentException.class)
	public void listsInList_Test_4() {
		MeinA.listsInList(null);

	}

	/*****************************************************************
	 * arrayRunsToListOfLists
	 *****************************************************************/

	@Test
	public void arrayRunsToListOfLists_Test_1() {
		//Initialize ListItems
		lst1= new ListItem<Integer>(0);
		lst2= new ListItem<Integer>(0);
		lst3= new ListItem<Integer>(0);
		lst4= new ListItem<Integer>(0);
		lst5= new ListItem<Integer>(0);
		lst1Test= new ListItem<Integer>(0);
		lst2Test= new ListItem<Integer>(0);
		lst3Test= new ListItem<Integer>(0);
		lst4Test= new ListItem<Integer>(0);
		lst5Test= new ListItem<Integer>(0);

		Integer[] arr = { 1, 2, 3, 4, 5};

		lst1Test.key = 1;
		lst2Test.key = 2;
		lst3Test.key = 3;
		lst4Test.key = 4;
		lst5Test.key = 5;
		lst1Test.next = lst2Test;
		lst2Test.next = lst3Test;
		lst3Test.next = lst4Test;
		lst4Test.next = lst5Test;
		outerList1.key=lst1Test;
		ListItem<ListItem<Integer>>a=MeinA.arrayRunsToListOfLists(arr, cmpInt);
		int testKey1=outerList1.key.key;
		int testKey2=a.key.key;		
		int testKey3=outerList1.key.next.key;
		int testKey4=a.key.next.key;		
		int testKey5=outerList1.key.next.next.key;
		int testKey6=a.key.next.next.key;		
		int testKey7=outerList1.key.next.next.next.key;
		int testKey8=a.key.next.next.next.key;		
		int testKey9=outerList1.key.next.next.next.next.key;
		int testKey10=a.key.next.next.next.next.key;
		assertEquals(testKey1, testKey2);
		assertEquals(testKey3, testKey4);
		assertEquals(testKey5, testKey6);
		assertEquals(testKey7, testKey8);
		assertEquals(testKey9, testKey10);

	}

	@Test
	public void arrayRunsToListOfLists_Test_2() {
		//Initialize ListItems
		lst1= new ListItem<Integer>(0);
		lst2= new ListItem<Integer>(0);
		lst3= new ListItem<Integer>(0);
		lst4= new ListItem<Integer>(0);
		lst5= new ListItem<Integer>(0);
		lst1Test= new ListItem<Integer>(0);
		lst2Test= new ListItem<Integer>(0);
		lst3Test= new ListItem<Integer>(0);
		lst4Test= new ListItem<Integer>(0);
		lst5Test= new ListItem<Integer>(0);

		Integer[] arr = { 1, 2, 2, 2, 1};

		lst1Test.key = 1;
		lst2Test.key = 2;
		lst3Test.key = 2;
		lst4Test.key = 2;
		lst5Test.key = 1;
		lst1Test.next = lst2Test;
		lst2Test.next = lst3Test;
		lst3Test.next = lst4Test;
		lst4Test.next = null;
		outerList1.key=lst1Test;
		outerList2.key=lst5Test;
		outerList1.next=outerList2;
		ListItem<ListItem<Integer>>a=MeinA.arrayRunsToListOfLists(arr, cmpInt);
		int testKey1=outerList1.key.key;
		int testKey2=a.key.key;		
		int testKey3=outerList1.key.next.key;
		int testKey4=a.key.next.key;		
		int testKey5=outerList1.key.next.next.key;
		int testKey6=a.key.next.next.key;		
		int testKey7=outerList1.key.next.next.next.key;
		int testKey8=a.key.next.next.next.key;				
		int testKey9=outerList1.next.key.key;
		int testKey10=a.next.key.key;;
		assertEquals(testKey1, testKey2);
		assertEquals(testKey3, testKey4);
		assertEquals(testKey5, testKey6);
		assertEquals(testKey7, testKey8);
		assertEquals(testKey9, testKey10);
	}

	@Test
	public void arrayRunsToListOfLists_Test_3() {
		Integer[] arr = { 5,4,3,2,1};
		ListItem<ListItem<Integer>>a=MeinA.arrayRunsToListOfLists(arr, cmpInt);
		assertNull(a);


	}

	@Test(expected = IllegalArgumentException.class)
	public void arrayRunsToListOfLists_Test_4() {
		MeinA.arrayRunsToListOfLists(null, cmpInt);
		Integer[] arr = { 1, 2, 3, 4, 5, 6 };
		MeinA.arrayRunsToListOfLists(arr, null);
	}

	/*****************************************************************
	 * ComparatorColor.compare
	 *****************************************************************/

	@Test
	public void compare_Test_1() {

	}

	@Test
	public void compare_Test_2() {

	}

	@Test
	public void compare_Test_3() {

	}

	/*****************************************************************
	 * move
	 *****************************************************************/

	@Test
	public void move_Test_1() {

	}

	@Test
	public void move_Test_2() {

	}

	@Test
	public void move_Test_3() {

	}
}