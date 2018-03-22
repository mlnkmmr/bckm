package Aufgabe_2;

import java.util.Comparator;

import org.junit.*;
import Aufgabe_1.B.ComparatorSurface;
import Aufgabe_1.C.C;
import Aufgabe_1.C.ComparatorRange;
import Aufgabe_1.V.ComparatorInteger;
import Aufgabe_1.V.V;
import data.ListItem;
import model.GeometricModelElement;
import model.Point;
import model.angled.AngledGeometricElement;
import model.angled.TriangleElement;
import model.round.CircleElement;
import model.round.EllipseElement;
import model.round.RoundGeometricElement;
import util.Constants;

public class CTest {
	
	private ListItem<Integer>	lst1, lst2, lst3;
	private ListItem<Integer>	listAscInt;
	private ListItem<Integer>	head;
	private ListItem<Integer>	head2;
	private ListItem<Integer>	lst;
	private ListItem<Integer>	oneElem= new ListItem<Integer>(1);

	protected C<Integer>		cInt	= new C<>();
	protected Integer[]			arrayAscInt;
	private Comparator<Integer>	cmpInt	= new ComparatorInteger();
	private Integer[] array1= {0,1,2,3,4};
	private Integer[] array2= {4,5,6,7,8};
	private Integer[] array3= {10,5,6,7,8};
	private Integer[] arr;
	
	protected ComparatorRange		cmp	= new ComparatorRange();
	
	private Point m11= new Point(1,1);
	private Point m12= new Point(3,1);
	private Point m13= new Point(2,3);
	private TriangleElement mittel1= new TriangleElement(m11, m12, m13);
	
	private Point m21= new Point(2,1);
	private Point m22= new Point(4,1);
	private Point m23= new Point(3,3);
	private TriangleElement mittel2= new TriangleElement(m21,m22,m23);
	
	private Point g1= new Point(2,1);
	private Point g2= new Point(4,1);
	private Point g3= new Point(3,4);
	private TriangleElement groﬂ= new TriangleElement(g1,g2,g3);
	
	private Point k1= new Point(1,2);
	private Point k2= new Point(2,2);
	private Point k3= new Point(1.5,3);
	private TriangleElement klein= new TriangleElement(k1,k2,k3);
	
	/**
	 * Creates a testList with Integers from 0 to 9
	 */
	@Before
	public void buildTestListAscInt() {
		listAscInt = new ListItem<Integer>(0);
		ListItem<Integer> p = listAscInt;
		for (int i = 1; i < 10; i++) {
			p.next = new ListItem<Integer>(i);
			p = p.next;
		}
	}
	@Before
	public void buildHeadAndLst() {
		head = new ListItem<Integer>(0);
		ListItem<Integer> p = head;
		for (int i = 1; i < 3; i++) {
			p.next = new ListItem<Integer>(i);
			p = p.next;
		}
		head2 = new ListItem<Integer>(0);
		ListItem<Integer> q = head2;
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
	}
	@Before
	public void makeTriangle(){
		
	}

	/**
	 * Creates a testArray with Integers from 0 to 9
	 */
	@Before
	public void buildTestArrayAscInt() {
		arrayAscInt = new Integer[10];
		for (int i = 0; i < 10; i++)
			arrayAscInt[i] = i;
	}
	
    

	/*****************************************************************
	 * combine
	 *****************************************************************/
    
	//Test: fÔøΩr beide Arrays wird eine null Referenz ÔøΩbergeben
	@Test
	public void combine_Test_1() {
		arrayAscInt=cInt.combine(null, null, this.cmpInt, null);
		Assert.	assertArrayEquals(null, arrayAscInt);
	}
	
    //Test: fÔøΩr cmp wird eine null Referenz ÔøΩbergeben
	@Test (expected = IllegalArgumentException.class)
	public void combine_Test_2() {
		cInt.combine(array1, array2, null, CircleElement.class);
	}
	
    //Test: fÔøΩr type wird eine null Referenz ÔøΩbergeben
	@Test (expected = IllegalArgumentException.class)
	public void combine_Test_3() {
		cInt.combine(array1, array2, this.cmpInt, null);
	}
	
    //Test: arrays sind nicht sortiert
	@Test(expected = IllegalArgumentException.class)
	public void combine_Test_4() {
		cInt.combine(array1, array3, this.cmpInt, CircleElement.class);
	}

	/*****************************************************************
	 * insertHead
	 *****************************************************************/
    //Test: list ist null wird ÔøΩbergeben
	@Test
	public void insertHead_Test_1() {
		Assert.assertEquals(0, cInt.insertHead(null, head).key, 0);
		Assert.assertEquals(1, cInt.insertHead(null, head).next.key, 0);
		Assert.assertEquals(2, cInt.insertHead(null, head).next.next.key, 0);
	}
    //Test: list und head sind null
	@Test
	public void insertHead_Test_2() {
       Assert.assertEquals(null, cInt.insertHead(null, null));
	}
    //Test: Bedingungen erfÔøΩllt
	@Test
	public void insertHead_Test_3() {
		Assert.assertEquals(0, cInt.insertHead(lst, head).key, 0);
		Assert.assertEquals(1, cInt.insertHead(lst, head).next.key, 0);
		Assert.assertEquals(2, cInt.insertHead(lst, head).next.next.key, 0);
		Assert.assertEquals(5, cInt.insertHead(lst, head).next.next.next.key, 0);
		Assert.assertEquals(6, cInt.insertHead(lst, head).next.next.next.next.key, 0);
		Assert.assertEquals(7, cInt.insertHead(lst, head).next.next.next.next.next.key, 0);
		Assert.assertEquals(8, cInt.insertHead(lst, head).next.next.next.next.next.next.key, 0);
		Assert.assertEquals(9, cInt.insertHead(lst, head).next.next.next.next.next.next.next.key, 0);

	}
	//Test: head null
    @Test (expected = IllegalArgumentException.class)
    public void insertHead_Test_4() {
       cInt.insertHead(lst, null);
	}

	/*****************************************************************
	 * removeLast
	 *****************************************************************/
    //Test:lst ist null
	@Test
	public void removeLast_Test_1() {
      Assert.assertEquals(null, cInt.removeLast(null));
	}
    //Test:lst enthÔøΩlt nur ein Element
	@Test
	public void removeLast_Test_2() {
      Assert.assertEquals(null, cInt.removeLast(oneElem));
	}
    //Test: kein Randfall
	@Test
	public void removeLast_Test_3() {
      Assert.assertEquals(0, cInt.removeLast(head).key, 0);
      Assert.assertEquals(1, cInt.removeLast(head).next.key, 0);
      Assert.assertEquals(null, cInt.removeLast(head).next.next);
	}

	/*****************************************************************
	 * invert
	 *****************************************************************/
    //Test: lst ist null
	@Test
	public void invert_Test_1() {
      Assert.assertEquals(null, cInt.invert(null));
	}
    //Test: lst enthÔøΩlt nur ein Element
	@Test
	public void invert_Test_2() {
     Assert.assertEquals(1, cInt.invert(oneElem).key, 0);
	}
    //Test kein Randfall
	@Test
	public void invert_Test_3() {
     Assert.assertEquals(2, cInt.invert(head).key, 0);
     Assert.assertEquals(2, cInt.invert(head).next.key, 0);
     Assert.assertEquals(1, cInt.invert(head).next.next.key, 0);
     Assert.assertEquals(null, cInt.invert(head).next.next);
	}

	/*****************************************************************
	 * combineLists
	 *****************************************************************/
    //Test unterschiedliche LÔøΩnge
	@Test
	public void combineLists_Test_1() {
     Assert.assertEquals(0, cInt.combineLists(head, lst).key, 0);
     Assert.assertEquals(6, cInt.combineLists(head, lst).next.key, 0);
     Assert.assertEquals(7, cInt.combineLists(head, lst).next.next.key, 0);
     Assert.assertEquals(8, cInt.combineLists(head, lst).next.next.next.key, 0);
     Assert.assertEquals(9, cInt.combineLists(head, lst).next.next.next.next.key, 0);
     Assert.assertEquals(null, cInt.combineLists(head, lst).next.next.next.next.next);
	}
    //Test null
	@Test
	public void combineLists_Test_2() {
     Assert.assertEquals(null,cInt.combineLists(null, null));
	}
    //Test keine Randbedingung
	@Test
	public void combineLists_Test_3() {
     Assert.assertEquals(0, cInt.combineLists(head, head2).key, 0);
     Assert.assertEquals(1, cInt.combineLists(head, head2).next.key, 0);
     Assert.assertEquals(2, cInt.combineLists(head, head2).next.next.key, 0);
     Assert.assertEquals(null, cInt.combineLists(head, head2).next.next.next);
	}
	//Test eine Liste null
    @Test
    public void combineLists_Test_4() {
     Assert.assertEquals(5, cInt.combineLists(lst, null).key, 0);
     Assert.assertEquals(6, cInt.combineLists(lst, null).next.key, 0);
     Assert.assertEquals(7, cInt.combineLists(lst, null).next.next.key, 0);
     Assert.assertEquals(8, cInt.combineLists(lst, null).next.next.next.key, 0);
     Assert.assertEquals(9, cInt.combineLists(lst, null).next.next.next.next.key, 0);
     Assert.assertEquals(null, cInt.combineLists(lst, null).next.next.next.next.next);
    }

	/*****************************************************************
	 * arrayIntoLists
	 *****************************************************************/

	@Test
	public void arrayIntoLists_Test_1() {
      Assert.assertEquals(null,cInt.arrayIntoList(arr));
	}

	@Test
	public void arrayIntoLists_Test_2() {
	Assert.assertEquals(0, cInt.arrayIntoList(array1).key, 0);
	Assert.assertEquals(1, cInt.arrayIntoList(array1).next.key, 0);
	Assert.assertEquals(2, cInt.arrayIntoList(array1).next.next.key, 0);
	Assert.assertEquals(3, cInt.arrayIntoList(array1).next.next.next.key, 0);
	Assert.assertEquals(4, cInt.arrayIntoList(array1).next.next.next.next.key, 0);
    Assert.assertEquals(null, cInt.arrayIntoList(array1).next.next.next.next.next);
	}

	@Test
	public void arrayIntoLists_Test_3() {
		Assert.assertEquals(5, cInt.arrayIntoList(array2).key, 0);
		Assert.assertEquals(6, cInt.arrayIntoList(array2).next.key, 0);
		Assert.assertEquals(7, cInt.arrayIntoList(array2).next.next.key, 0);
		Assert.assertEquals(8, cInt.arrayIntoList(array2).next.next.next.key, 0);
		Assert.assertEquals(9, cInt.arrayIntoList(array2).next.next.next.next.key, 0);
	    Assert.assertEquals(null, cInt.arrayIntoList(array2).next.next.next.next.next);
    }
	

	@Test(expected = IllegalArgumentException.class)
	public void arrayIntoLists_Test_4() {
     cInt.arrayIntoList(null);
	}

	/*****************************************************************
	 * ComparatorRange.compare
	 *****************************************************************/

	@Test
	public void compare_Test_1() {
     Assert.assertEquals(0, cmp.compare(mittel1, mittel2));
	}

	@Test
	public void compare_Test_2() {
		Assert.assertEquals(-1, cmp.compare(mittel1, groﬂ));
	}

	@Test
	public void compare_Test_3() {
		Assert.assertEquals(1, cmp.compare(mittel1, klein));
	}

	/*****************************************************************
	 * mirror
	 *****************************************************************/

	@Test
	public void mirror_Test_1() {
		mittel1.mirror(Constants.Y_AXIS);
       Assert.assertEquals(-1, mittel1.getPoints()[0].getX(),0.000001);
       Assert.assertEquals(1, mittel1.getPoints()[0].getY(),0.000001);
       Assert.assertEquals(-3, mittel1.getPoints()[1].getX(),0.000001);
       Assert.assertEquals(1, mittel1.getPoints()[1].getY(),0.000001);
       Assert.assertEquals(-2, mittel1.getPoints()[2].getX(),0.000001);
       Assert.assertEquals(3, mittel1.getPoints()[2].getY(),0.000001);
	}

	@Test
	public void mirror_Test_2() {
		mittel1.mirror(Constants.X_AXIS);
	       Assert.assertEquals(1, mittel1.getPoints()[0].getX(),0.000001);
	       Assert.assertEquals(-1, mittel1.getPoints()[0].getY(),0.000001);
	       Assert.assertEquals(3, mittel1.getPoints()[1].getX(),0.000001);
	       Assert.assertEquals(-1, mittel1.getPoints()[1].getY(),0.000001);
	       Assert.assertEquals(2, mittel1.getPoints()[2].getX(),0.000001);
	       Assert.assertEquals(-3, mittel1.getPoints()[2].getY(),0.000001);
	}

	@Test
	public void mirror_Test_3() {
		mittel1.mirror(Constants.X_AXIS);
		mittel1.mirror(Constants.Y_AXIS);
	       Assert.assertEquals(-1, mittel1.getPoints()[0].getX(),0.000001);
	       Assert.assertEquals(-1, mittel1.getPoints()[0].getY(),0.000001);
	       Assert.assertEquals(-3, mittel1.getPoints()[1].getX(),0.000001);
	       Assert.assertEquals(-1, mittel1.getPoints()[1].getY(),0.000001);
	       Assert.assertEquals(-2, mittel1.getPoints()[2].getX(),0.000001);
	       Assert.assertEquals(-3, mittel1.getPoints()[2].getY(),0.000001);
	}
}