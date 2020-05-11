import java.util.ArrayList;
import java.util.Comparator;

public class InsertionSorter<T> extends Sorter {
	 void insertSort(ArrayList<Item> list) 
	    { 
	        int n = list.size(); 
	        for (int i=1 ; i<list.size(); ++i) 
	        { 
	            Item key = list.get(i); 
	            int j = i-1; 
	  
	            /* Move elements of arr[0..i-1], that are 
	               greater than key, to one position ahead 
	               of their current position */
	            while (j>=0 && list.get(j).compareTo(key)>=0) 
	            { 
	                list.set(j+1,list.get(j)); 
	                j = j-1; 
	            } 
	            list.set(j+1, key); 
	        } 
	    }   
       
  
           
          
	@Override
	public void sort(ArrayList list) {
		// TODO Auto-generated method stub
		insertSort(list);
	}

	

	
	



	
}

	 
	         