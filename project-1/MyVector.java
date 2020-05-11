import java.util.ArrayList;

public class MyVector<E> {
	private ArrayList<Item> storageM;
	private Sorter sorter;

	public MyVector(int n) {
		storageM = new ArrayList<>(n);
		// TODO Auto-generated constructor stub
	}
	public MyVector(ArrayList<Item> arr) {
		storageM = arr;
		
	}

	public void add(Item item) {
		// TODO Auto-generated method stub
		storageM.add(item);
	}

	public void display() {
		// TODO Auto-generated method stub
		String ans="";
		for (Item data: storageM)
			ans = ans +" "+ data.getItem();
		System.out.println(ans);
	}

	public void setSortStrategy(Sorter sorter) {
		// TODO Auto-generated method stub
		setSorter(sorter);
	}

	public void performSort() {
		// TODO Auto-generated method stub
		sorter.sort(storageM);
	}
	public Sorter getSorter() {
		return sorter;
	}
	public void setSorter(Sorter sorter) {
		this.sorter = sorter;
	}

}
