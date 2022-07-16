import java.util.Arrays;
import java.util.Iterator;
import java.util.stream.Stream;

class ArrayList<E> {
	private int sizeOfList = 0;
	private static int capacity = 2;
	private Object customArray[];

	// private static int newCapacity = oldCapacity + (oldCapacity >> 1);
	ArrayList() {
		customArray = new Object[capacity];
	}

	private void ensureCapacity() {
		int newSize = sizeOfList * 2;
		customArray = Arrays.copyOf(customArray, newSize);
	}

	public void add(E ele) {

		if (sizeOfList == customArray.length) {

			ensureCapacity();
		}
		customArray[sizeOfList] = ele;
		sizeOfList++;
		System.out.println(sizeOfList + "sizeOfList");
	}

	@SuppressWarnings("unchecked")
	public void remove(int index) {
		if (sizeOfList <= index || index < 0) {
			throw new IndexOutOfBoundsException("Index: " + index + ", Size " + sizeOfList);
		} else {
			// index 3
			Object item = customArray[index];
			// length 6 - (3+1) = 2
			int numElts = customArray.length - (index + 1);
			// streamOf(customArray[2],customArray[4]) skipped 3
			System.out.println(numElts +"****" + (numElts+ 2));
			System.arraycopy( customArray, index + 1, customArray, index, numElts ) ;
		}

	}

	// Print method
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append('[');
		for (int i = 0; i < sizeOfList; i++) {
			if(customArray[i] != null) {  sb.append(customArray[i].toString());}
			if (i < sizeOfList - 1) {
				sb.append(",");
			}
		}
		sb.append(']');
		return sb.toString();
	}

	public int getSize() {
		return sizeOfList;
	}

	@SuppressWarnings("unchecked")
	public Object get(int index) {

		if (sizeOfList <= index || index < 0) {
			throw new IndexOutOfBoundsException("Index: " + index + ", Size " + sizeOfList);
		} else {
			return customArray[index];
		}
	}

}

public class ArrayListCustom {
	public static void main(String[] args) {
		ArrayList<Integer> l = new ArrayList();
		int i = 0;
		while (i < 10) {
			l.add(i);
			i++;
		}
		System.out.println("List: " + l);
		System.out.println("Size: " + l.getSize());
		System.out.println("Find: " + l.get(2));
		l.remove(3);
		System.out.println("List: " + l);
		System.out.println("Size: " + l.getSize());

	}
}
