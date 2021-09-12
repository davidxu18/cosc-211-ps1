/**
 * Deque implemented using a doubly linked list
 */

public class DLLDeque<E> implements SimpleDeque<E> {

	private int size = 0;

	private Node<E> head = new Node<E>();
	
	private Node<E> tail = new Node<E>();

	//head.value = null;
	//tail.value = null;
	//head.prev = null;
	//head.next = tail;
	//tail.prev = head;
	//tail.next = null;

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	@SuppressWarnings("unchecked")
	public void addFirst(E x) {	
		if (size == 0) {
			head.next = tail;
			tail.prev = head;
			}

		// make a new Node to store x
		Node<E> nd = new Node<E>();
		nd.value = x;
		nd.next = head.next;
		nd.prev = head;
		nd.next.prev = nd;
		nd.prev.next = nd;

		++size;
    	}

	@Override
	public E removeFirst() {

		if (size == 0) {
			throw new IndexOutOfBoundsException();
		}

		E value = head.next.value;
		head.next = head.next.next;
		--size;
		return value;
	}

	@Override
	public E peekFirst() {

		if (size == 0) {
			throw new IndexOutOfBoundsException();
		}

		return head.next.value;
	}

	@Override
	@SuppressWarnings("unchecked")
	public void addLast(E x) {

		if (size == 0) {
			head.next = tail;
			tail.prev = head;
			}

		// make a new Node to store x
		Node<E> nd = new Node<E>();
		nd.value = x;
		nd.prev = tail.prev;
		nd.prev.next = nd;
		nd.next = tail;
		nd.next.prev = nd;

		++size;
	}

	@Override
	public E removeLast() {
		if (size == 0) {
			throw new IndexOutOfBoundsException();
		}

		E value = tail.prev.value;
		tail.prev = tail.prev.prev;
		tail.prev.next = tail;
		
		--size;

		return value;
	}	

	@Override
	public E peekLast() {

		if (size == 0) {
			throw new IndexOutOfBoundsException();
		}

		return tail.prev.value;
	}

	private class Node<E> {
		Node<E> next;
		Node<E> prev;
		E value;
	}
}
