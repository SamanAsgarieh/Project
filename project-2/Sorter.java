import java.util.ArrayList;
/**
 * abstract class which contains an unimplemented method,sort,which will be implemented 
 * by classes that implement it.
 * @author saman
 *
 * @param <T>
 */
public abstract class Sorter<T> {
public abstract void sort(ArrayList<Item> list);
}
