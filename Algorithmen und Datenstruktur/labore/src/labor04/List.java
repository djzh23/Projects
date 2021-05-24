package labor04;

import java.util.Iterator;

public interface List<T>{

	public boolean isEmpty();

	public int size();

	public T get(int index);

	public void add1(int index, T e);

	void add(int index, T e);

	public Iterator<T> iterator();
	
	public boolean search(T e);



	
	
	

}
