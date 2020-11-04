package elluican.test;

import java.util.Iterator;

public class SingleSortedLinkedList<T extends Comparable<T>> implements Iterable<T> {

	private Node<T> element;
	private int size = 0;


	private int condition;
	
	/**
	 * 0 for ascending
	 * 1 for descending
	 * @param order
	 */
	public SingleSortedLinkedList(int order) {
		this.condition=order;
	}
	
    public SingleSortedLinkedList() {
		this.condition=0;
	}
	
	public int size() {
		return size;
	}


	/**
	 *
	 * data by default inserted in ascending order
	 * In order to change default order needs to be mentioned when creating the collection
	 * SingleSortedLinkedList(int order);
	 * @param data
	 */
	public void addElement(T data) {
		Node<T> newNode = new Node<>();
		newNode.setData(data);

		if (element == null) {
			element = newNode;
			size++;
			return;
		}

		Node<T> currentElement = element;

		boolean sortingConditionCurrentElement = (condition == 0) ? data.compareTo(currentElement.getData()) < 0
				: data.compareTo(currentElement.getData()) > 0;

		// In case first element itself is bigger/lower than data to be added
		if (sortingConditionCurrentElement) {
			element = newNode;
			element.setNextElement(currentElement);

		} else {

			Node<T> nextElement = currentElement.getNextElement();
			
			while (nextElement != null) {
				boolean sortingConditionNextElement = (condition == 0) ? data.compareTo(nextElement.getData()) < 0
						: data.compareTo(nextElement.getData()) > 0;
				
				if (sortingConditionNextElement) {
					newNode.setNextElement(nextElement);
					break;
				} else {
					currentElement = nextElement;
					nextElement = currentElement.getNextElement();
				}
			}

			currentElement.setNextElement(newNode);
		}

		size++;
	}

	@Override
	public Iterator<T> iterator() {
		return new SingleSortedLinkedListIterator<T>(element);
	}

	class SingleSortedLinkedListIterator<T extends Comparable<T>> implements Iterator<T> {

		Node<T> elementForIteration;

		public SingleSortedLinkedListIterator(Node<T> toBeIterated) {
			elementForIteration = toBeIterated;
		}

		@Override
		public boolean hasNext() {
			return elementForIteration != null;
		}

		@Override
		public T next() {
			if (elementForIteration == null) {
				throw new ArrayIndexOutOfBoundsException();
			}
			T data = elementForIteration.getData();
			elementForIteration = elementForIteration.getNextElement();

			return data;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}

	}
}
