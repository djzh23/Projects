package labor04;

import java.util.Iterator;

public class ArrayListIteratorHelper<T> implements Iterator<T> {

	private List<T> internalArrayList;
	private int position = 0;
	
	public ArrayListIteratorHelper(List<T> internalArrayList) {
		this.internalArrayList = internalArrayList;
	}


	@Override
	public boolean hasNext() {
		return position < internalArrayList.size();
	}

	@Override
	public T next() {
		T value = internalArrayList.get(position);
		position++;
		return value;
	}

}
