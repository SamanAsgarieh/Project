/* ENSF 480 - Lab 5 Exercise A and B
 * M. Moussavi, October 2018
 */
/**
 * this class is a generic class, which both itself, and its generic type implement comparable
 * in order for them to be compared.
 * @author saman
 * @param <E>
 */

class Item <E extends Comparable<E> > implements Comparable<Item<E>>{
	private E item;
	public Item(E value) {
		item = value;
	}
/**
 * setter method
 * @param value
 */
	public void setItem(E value){
		item = value;
	}
/**
 * getter method
 * @return
 */
	public E getItem(){
		return item;
	}
/**
 * compares two Item objects.
 */
	@Override
	public int compareTo(Item o) {
		// TODO Auto-generated method stub
return this.getItem().compareTo((E) o.getItem());
}

	





}
