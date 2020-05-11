import java.util.ArrayList;
/**
 * vector class contains a generic arraylist and an object of Sorter.There are several methods to modify this list.
 * @author saman
 *
 * @param <E>
 */
public class MyVector<E> {
	private ArrayList<Item> storageM;
	private Sorter sorter;
/**
 * constructor
 * @param n
 */
	public MyVector(int n) {
		storageM = new ArrayList<>(n);
		// TODO Auto-generated constructor stub
	}
	/**
	 * constructor
	 * @param arr
	 */
	public MyVector(ArrayList<Item> arr) {
		storageM = arr;
		
	}
/**
 * adds an item to the list
 * @param item
 */
	public void add(Item item) {
		// TODO Auto-generated method stub
		storageM.add(item);
	}
/**
 * prints the objects in the list
 */
	public void display() {
		// TODO Auto-generated method stub
		String ans="";
		for (Item data: storageM)
			ans = ans +" "+ data.getItem();
		System.out.println(ans);
	}
/**
 * setter method
 * @param sorter
 */
	public void setSortStrategy(Sorter sorter) {
		// TODO Auto-generated method stub
		setSorter(sorter);
	}
/**
 * sorts the list
 */
	public void performSort() {
		// TODO Auto-generated method stub
		sorter.sort(storageM);
	}
	/**
	 * getter method
	 * @return
	 */
	public Sorter getSorter() {
		return sorter;
	}
	/**
	 * setter method
	 * @param sorter
	 */
	public void setSorter(Sorter sorter) {
		this.sorter = sorter;
	}

}
