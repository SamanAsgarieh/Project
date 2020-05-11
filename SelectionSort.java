import java.util.ArrayList;
/**
 * sorts list passed to it by selection sort algorithm.
 * 
 */
public class SelectionSort<T> extends Sorter {
	/**
	 * selection sort method.
	 * @param list
	 */
	public static void selectionSort(ArrayList<Item> list) {
		for (int i = 0; i < list.size(); i++) {
			int pos = i;
			for (int j = i ; j < list.size() ; j++) {
				if (list.get(j).compareTo(list.get(pos))<0)
					pos = j;
			}
			Item min = list.get(pos);
			list.set(pos, list.get(i));
			list.set(i, min);
		}
	}

	/**
	 * this method calls the method above to sort the passed arraylist 
	 */
	@Override
	public void sort(ArrayList list) {
		selectionSort(list);
		// TODO Auto-generated method stub

	}
}
