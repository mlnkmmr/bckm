package Aufgabe_2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;

import Aufgabe_1.D.D;

import java.util.Comparator;
import data.ListItem;

import junit.framework.Assert;

public class DTest {

	protected D<Integer> dInt = new D<>();
	protected Integer[] arrayAsdInt;

	private ListItem<Integer> lst;
	private ListItem<Integer> lst2;
	private ListItem<Integer> lst3;
	private ListItem<Integer> lst4;

	private Integer[] arr1 = { 1 };
	private Integer[] arr2 = { 10, 100, 1000 };
	private Integer[] arr3 = { 8, 9, 10, 11, 12 };
	private Integer[] arr4 = { 5, 4, 3, 2 };
	private Integer[] arr5 = {};

	/**
	 * Creates a testList with Integers from 0 to 9
	 */
	@Before
	public void buildTestListAsdInt() {
		ListItem<Integer> listAsdInt = new ListItem<Integer>(0);
		ListItem<Integer> p = listAsdInt;
		for (int i = 1; i < 10; i++) {
			p.next = new ListItem<Integer>(i);
			p = p.next;
		}
	}

	@Before
	public void buildElemAndLst() {
		ListItem<Integer> elem = new ListItem<Integer>(0);
		ListItem<Integer> p = elem;
		for (int i = 1; i < 3; i++) {
			p.next = new ListItem<Integer>(i);
			p = p.next;
		}
		ListItem<Integer> elem2 = new ListItem<Integer>(0);
		ListItem<Integer> q = elem2;
		for (int i = 1; i < 3; i++) {
			q.next = new ListItem<Integer>(i);
			q = q.next;
		}
		lst = new ListItem<Integer>(5);
		ListItem<Integer> u = lst;
		for (int i = 6; i < 10; i++) {
			u.next = new ListItem<Integer>(i);
			u = u.next;
		}
		lst2 = new ListItem<Integer>(1);
		ListItem<Integer> r = lst2;
		for (int i = 2; i < 6; i++) {
			r.next = new ListItem<Integer>(i);
			r = r.next;
		}
		lst3 = new ListItem<Integer>(3);
		ListItem<Integer> s = lst3;
		for (int i = 0; i < 6; i++) {
			s.next = new ListItem<Integer>(3);
			s = s.next;
		}
		lst4 = new ListItem<Integer>(1);
		ListItem<Integer> t = lst4;
		for (int i = 1; i <= 10; i++) {
			t.next = new ListItem<Integer>(i);
			t = t.next;
		}
	}

	/*****************************************************************
	 * switchElements
	 *****************************************************************/

	@Test
	public void switchElements_Test_1() {
		arrayAsdInt = dInt.switchElements(arr1, 0, 0);
		Assert.assertEquals(1, arrayAsdInt[0]);
		// arr1
	}

	@Test
	public void switchElements_Test_2() {
		arraysAsdInt = dInt.switchElements(arr3, 1, 3);
		Assert.assertEquals(8, arrayAsdInt[0]);
		Assert.assertEquals(11, arrayAsdInt[1]);
		Assert.assertEquals(10, arrayAsdInt[2]);
		Assert.assertEquals(9, arrayAsdInt[3]);
		Assert.assertEquals(12, arrayAsdInt[4]);
		// arr3
	}

	@Test
	public void switchElements_Test_3() {
		arrayAsdInt = dInt.switchElements(arr2, 0, 3);
		Assert.assertEquals(2, arrayAsdInt[0]);
		Assert.assertEquals(4, arrayAsdInt[1]);
		Assert.assertEquals(3, arrayAsdInt[2]);
		Assert.assertEquals(5, arrayAsdInt[3]);
		// arr4
	}

	@Test(expected = IllegalArgumentException.class)
	public void switchElements_Test_4() {
		dInt.switchElements(arr5, 3, 5);
		// arr5
	}

	@Test(expected = IllegalArgumentException.class)
	public void switchElements_Test_5() {
		dInt.switchElements(arr2, 4, 1);
		// arr2
	}

	/*****************************************************************
	 * insertLast
	 *****************************************************************/

	@Test
	public void insertLast_Test_1() {
		assert.assertEquals(0, dInt.insertLast(null, elem).key, 0);
		assert.assertEquals(1, dInt.insertLast(null, elem).next.key, 0);
		assert.assertEquals(2, dInt.insertLast(null, elem).next.next.key, 0);
	}

	@Test
	public void insertLast_Test_2() {
		assert.assertEquals(5, dInt.insertLast(lst, null).key, 0);
		assert.assertEquals(6, dInt.insertLast(lst, null).next.key, 0);
		assert.assertEquals(7, dInt.insertLast(lst, null).next.next.key, 0);
		assert.assertEquals(8, dInt.insertLast(lst, null).next.next.next.key, 0);
		assert.assertEquals(9, dInt.insertLast(lst, null).next.next.next.next.key, 0);
	}

	@Test
	public void insertLast_Test_3() {
		assert.assertEquals(5, dInt.insertLast(lst, elem).key, 0);
		assert.assertEquals(6, dInt.insertLast(lst, elem).next.key, 0);
		assert.assertEquals(7, dInt.insertLast(lst, elem).next.next.key, 0);
		assert.assertEquals(8, dInt.insertLast(lst, elem).next.next.next.key, 0);
		assert.assertEquals(9, dInt.insertLast(lst, elem).next.next.next.next.key, 0);
		assert.assertEquals(0, dInt.insertLast(lst, elem).next.next.next.next.next.key, 0);
		assert.assertEquals(1, dInt.insertLast(lst, elem).next.next.next.next.next.next.key, 0);
		assert.assertEquals(2, dInt.insertLast(lst, elem).next.next.next.next.next.next.next.key, 0);
	}

	/*****************************************************************
	 * removeSecMaxElement
	 *****************************************************************/

	@Test
	public void removeSecMaxElement_Test_1() {
		assert.assertEquals(5, dInt.removeSecMaxElement(lst, cmp).key, 0);
		assert.assertEquals(6, dInt.removeSecMaxElement(lst, cmp).next.key, 0);
		assert.assertEquals(7, dInt.removeSecMaxElement(lst, cmp).next.next.key, 0);
		assert.assertEquals(9, dInt.removeSecMaxElement(lst, cmp).next.next.next.key, 0);
	}

	@Test
	public void removeSecMaxElement_Test_2() {
		assert.assertEquals(1, dInt.removeSecMaxElement(lst2, cmp).key, 0);
		assert.assertEquals(2, dInt.removeSecMaxElement(lst2, cmp).next.key, 0);
		assert.assertEquals(3, dInt.removeSecMaxElement(lst2, cmp).next.next.key, 0);
		assert.assertEquals(5, dInt.removeSecMaxElement(lst2, cmp).next.next.next.key, 0);
	}

	@Test
	public void removeSecMaxElement_Test_3() {
		assert.assertEquals(3, dInt.removeSecMaxElement(lst3, cmp).key, 0);
		assert.assertEquals(3, dInt.removeSecMaxElement(lst3, cmp).next.key, 0);
		assert.assertEquals(3, dInt.removeSecMaxElement(lst3, cmp).next.next.key, 0);
		assert.assertEquals(3, dInt.removeSecMaxElement(lst3, cmp).next.next.next.key, 0);
		assert.assertEquals(3, dInt.removeSecMaxElement(lst3, cmp).next.next.next.next.key, 0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void removeSecMaxElement_Test_4() {
		dInt.removeSecMaxElement(lst, null);
	}

	/*****************************************************************
	 * invertTriples
	 *****************************************************************/

	@Test
	public void invertTriples_Test_1() {
		assert.assertEquals(7, dInt.removeSecMaxElement(lst, cmp).key, 0);
		assert.assertEquals(6, dInt.removeSecMaxElement(lst, cmp).next.key, 0);
		assert.assertEquals(5, dInt.removeSecMaxElement(lst, cmp).next.next.key, 0);
		assert.assertEquals(8, dInt.removeSecMaxElement(lst, cmp).next.next.next.key, 0);
		assert.assertEquals(9, dInt.removeSecMaxElement(lst, cmp).next.next.next.next.key, 0);
	}

	@Test
	public void invertTriples_Test_2() {
		assert.assertEquals(2, dInt.removeSecMaxElement(lst, cmp).key, 0);
		assert.assertEquals(1, dInt.removeSecMaxElement(lst, cmp).next.key, 0);
		assert.assertEquals(0, dInt.removeSecMaxElement(lst, cmp).next.next.key, 0);
		//lst2
	}

	@Test
	public void invertTriples_Test_3() {
		assert.assertEquals(3, dInt.removeSecMaxElement(lst, cmp).key, 0);
		assert.assertEquals(2, dInt.removeSecMaxElement(lst, cmp).next.key, 0);
		assert.assertEquals(1, dInt.removeSecMaxElement(lst, cmp).next.next.key, 0);
		assert.assertEquals(6, dInt.removeSecMaxElement(lst, cmp).next.next.next.key, 0);
		assert.assertEquals(5, dInt.removeSecMaxElement(lst, cmp).next.next.next.next.key, 0);
		assert.assertEquals(4, dInt.removeSecMaxElement(lst, cmp).next.next.next.next.next.key, 0);
		assert.assertEquals(9, dInt.removeSecMaxElement(lst, cmp).next.next.next.next.next.next.key, 0);
		assert.assertEquals(8, dInt.removeSecMaxElement(lst, cmp).next.next.next.next.next.next.key, 0);
		assert.assertEquals(7, dInt.removeSecMaxElement(lst, cmp).next.next.next.next.next.next.next.key, 0);
		assert.assertEquals(10, dInt.removeSecMaxElement(lst, cmp).next.next.next.next.next.next.next.next.key, 0);
		//lst4
	}

	@Test(expected = IllegalArgumentException.class)
	public void invertTriples_Test_4() {
		dInt.invertTriples(null);
	}

	/*****************************************************************
	 * divideAlternatinglyIntoLists
	 *****************************************************************/

	@Test
	public void divideAlternatinglyIntoLists_Test_1() {
		
	}

	@Test
	public void divideAlternatinglyIntoLists_Test_2() {
		
	}

	@Test
	public void divideAlternatinglyIntoLists_Test_3() {
		
	}

	/*****************************************************************
	 * listIntoArray
	 *****************************************************************/

	@Test
	public void listIntoArray_Test_1() {

	}

	@Test
	public void listIntoArray_Test_2() {

	}

	@Test
	public void listIntoArray_Test_3() {

	}

	@Test(expected = IllegalArgumentException.class)
	public void listIntoArray_Test_4() {

	}

	/*****************************************************************
	 * ComparatorRadius.compare
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
	 * rotate
	 *****************************************************************/

	@Test
	public void rotate_Test_1() {

	}

	@Test
	public void rotate_Test_2() {

	}

	@Test
	public void rotate_Test_3() {

	}
}