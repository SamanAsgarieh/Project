/* ENSF 480 - Lab 5 Exercise A and B
 * M. Moussavi, October 2018
 */

class Item <E extends Comparable<E> > implements Comparable<Item<E>>{
	private E item;
	public Item(E value) {
		item = value;
	}

	public void setItem(E value){
		item = value;
	}

	public E getItem(){
		return item;
	}

	@Override
	public int compareTo(Item o) {
		// TODO Auto-generated method stub
return this.getItem().compareTo((E) o.getItem());
}

	





}
