import java.util.ArrayList;
/**
 * sorts list passed to it by bubble sort algorithm.
 * 
 */
public class BubbleSorter<T> extends Sorter {
	/**
	 * bubble sort method.
	 * @param list
	 */
	 public static void bubbleSort(ArrayList<Item> list)
	  {
	        Item temp;
	        if (list.size()>1) // check if the number of orders is larger than 1
	        {
	            for (int x=0; x<list.size(); x++) // bubble sort outer loop
	            {
	                for (int i=0; i < list.size()-1; i++) {
	                    if (list.get(i).compareTo(list.get(i+1)) >= 0)
	                    {
	                        temp = list.get(i);
	                        list.set(i,list.get(i+1) );
	                        list.set(i+1, temp);
	                    }
	                }
	            }
	        }

	  }
	 /**
		 * this method calls the method above to sort the passed arraylist 
		 */
	@Override
	public void sort(ArrayList list) {
		// TODO Auto-generated method stub
		bubbleSort(list);
	}
    



	




}
