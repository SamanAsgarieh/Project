import java.util.ArrayList;
import java.util.Comparator;
/**
 * sorts list passed to it by bubble sort algorithm.
 * 
 */
public class InsertionSorter<T> extends Sorter {
	/**
	 * insertion sort method.
	 * @param list
	 */
	 void insertSort(ArrayList<Item> list) 
	    { 
	        int n = list.size(); 
	        for (int i=1 ; i<list.size(); ++i) 
	        { 
	            Item key = list.get(i); 
	            int j = i-1; 
	            while (j>=0 && list.get(j).compareTo(key)>=0) 
	            { 
	                list.set(j+1,list.get(j)); 
	                j = j-1; 
	            } 
	            list.set(j+1, key); 
	        } 
	    }          
	 /**
		 * this method calls the method above to sort the passed arraylist 
		 */   
	@Override
	public void sort(ArrayList list) {
		// TODO Auto-generated method stub
		insertSort(list);
	}

	

	
	



	
}

	 
	         