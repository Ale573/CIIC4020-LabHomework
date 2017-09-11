package arrayIndexList;

import indexList.IndexList;

public class ArrayIndexList<E> implements IndexList<E> {
	private static final int INITCAP = 5; 
	private static final int CAPTOAR = 5; 
	private static final int MAXEMPTYPOS = 10; 
	private E[] element; 
	private int size; 

	public ArrayIndexList() { 
		element = (E[]) new Object[INITCAP]; 
		size = 0; 
	} 
	

	public void add(int index, E e) throws IndexOutOfBoundsException {
		
		if(index > size || index < 0){
			throw new IndexOutOfBoundsException("add: Invalid Index = " + index);
		}
		element[index] = e;
		size++;
	}


	public void add(E e) {
		
		if(size == element.length){
			changeCapacity(CAPTOAR);
		}
		
		element[size] = e;
		size++;
		
	}


	public E get(int index) throws IndexOutOfBoundsException {
		if(index > size || index < 0){
			throw new IndexOutOfBoundsException("add: Invalid Index = " + index);
		}
		return element[index]; 
	}


	public boolean isEmpty() {
		if(size == 0){
			return true;
		}
		else
			return false;
	}


	public E remove(int index) throws IndexOutOfBoundsException {
		
		int number = 0;
		if(index > size || index < 0){
			throw new IndexOutOfBoundsException("add: Invalid Index = " + index);
		}
		
		size--;
//		for(int i = 0; i < element.length; i++){
//			if(element[i] == null){
//				number++;
//			}
//		}
//		
//		if(number == MAXEMPTYPOS){
//			changeCapacity(-CAPTOAR);
//		}
		
		return element[index];
	}


	public E set(int index, E e) throws IndexOutOfBoundsException {
		if(index > size || index < 0){
			throw new IndexOutOfBoundsException("add: Invalid Index = " + index);
		}
		return (element[index] = e);
	}


	public int size() {
		return size;
	}	
	
	
	
	// private methods  -- YOU CAN NOT MODIFY ANY OF THE FOLLOWING
	// ... ANALYZE AND USE WHEN NEEDED
	
	// you should be able to decide when and how to use
	// following method.... BUT NEED TO USE THEM WHENEVER
	// NEEDED ---- THIS WILL BE TAKEN INTO CONSIDERATION WHEN GRADING
	
	private void changeCapacity(int change) { 
		int newCapacity = element.length + change; 
		E[] newElement = (E[]) new Object[newCapacity]; 
		for (int i=0; i<size; i++) { 
			newElement[i] = element[i]; 
			element[i] = null; 
		} 
		element = newElement; 
	}
	
	// useful when adding a new element with the add
	// with two parameters....
	private void moveDataOnePositionTR(int low, int sup) { 
		// pre: 0 <= low <= sup < (element.length - 1)
		for (int pos = sup; pos >= low; pos--)
			element[pos+1] = element[pos]; 
	}

	// useful when removing an element from the list...
	private void moveDataOnePositionTL(int low, int sup) { 
		// pre: 0 < low <= sup <= (element.length - 1)
		for (int pos = low; pos <= sup; pos++)
			element[pos-1] = element[pos]; 
	}

}
