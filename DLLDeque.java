/**
 * Deque implemented using a doubly linked list
 */

public class DLLDeque<E> implements SimpleDeque<E> {

	private int size = 0;

	private Node<E> head = null;

	private Node<E> tail = null;

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public boolean isEmpty() {
		return head == null;
	}

	@Override
	@SuppressWarnings("unchecked")
	public void addFirst(E x) {	

		if (size == 0) {
			throw new IndexOutOfBoundsException();
		}

		// make a new Node to store x
		Node<E> nd = new Node<E>();
		nd.value = x;

	    	nd.next = this.head;
	   	this.head = nd;
		nd.prev = null;

		nd.next.prev = nd;
		++size;
    	}

	@Override
	public E removeFirst() {

		if (size == 0) {
			throw new IndexOutOfBoundsException();
		}

		E value = head.value;
		head = head.next;
		head.prev = null;
		--size;
		return value;
	}

	@Override
	public E peekFirst() {
		return head.value;
	}

	@Override
	@SuppressWarnings("unchecked")
	public void addLast(E x) {

		if (size == 0) {
			throw new IndexOutOfBoundsException();
		}

		// make a new Node to store x
		Node<E> nd = new Node<E>();
		nd.value = tail.value;
		nd.prev = tail.prev;
		nd.next = tail;
		
		tail.prev = nd;
		tail.value = x;
		++size;
	}

	@Override
	public E removeLast() {
		if (size == 0) {
			throw new IndexOutOfBoundsException();
		}

		E value = tail.value;
		tail = tail.prev;
		tail.next = null;

		--size;

		return value;
	}	

	@Override
	public E peekLast() {
		return tail.value;
	}

	private class Node<E> {
		Node<E> next;
		Node<E> prev;
		E value;
	}
}
