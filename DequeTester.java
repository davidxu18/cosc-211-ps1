import java.util.Random;

public class DequeTester {
    static Random rand = new Random(10);
    static final int TEST_SIZE = 1_000;

    public static void main(String[] args) {
	// choose a SimpleDeque implementation to test
      	// SimpleDeque<Integer> deque = new ASLDeque<Integer>();
	SimpleDeque<Integer> deque = new CADeque<Integer>();

	// test that exceptions are thrown
	System.out.println("testing exceptions...");
	if (testExceptions(deque)) {
	    System.out.println("  ...test passed!");
	} else {
	    System.out.println("  ...test failed.");
	}

	// test addition and removal of elements
	System.out.println("testing addition and removal...");
	if (testAddRemove(deque)) {
	    System.out.println("  ...test passed!");
	} else {
	    System.out.println("  ...test failed.");
	}
    }

    static boolean testExceptions(SimpleDeque<Integer> deque) {

	// an empty deque should throw an exception
	try {
	    deque.removeFirst();
	    System.out.println("  ...removeFirst failed to throw exception!");
	    return false;
	} catch (Exception e) {

	}

	try {
	    deque.removeLast();
	    System.out.println("  ...removeLast failed to throw exception!");
	    return false;
	} catch (Exception e) {

	}

	return true;
    }

    static boolean testAddRemove(SimpleDeque<Integer> deque) {
	int[] values = new int[TEST_SIZE];

	for (int i = 0; i < values.length; ++i) {
	    values[i] = rand.nextInt(TEST_SIZE);
	}

	// insert elements to back and test contents
	if (!populateFromBack(deque, values)) {
	    return false;
	}

	if (!removeFromBack(deque, values)) {
	    return false;
	}

	// insert elements to front and test contents
	if (!populateFromFront(deque, values)) {
	    return false;
	}

	if (!removeFromFront(deque, values)) {
	    return false;
	}


	return true;
    }

    static boolean populateFromBack(SimpleDeque<Integer> deque, int[] values) {
	for (int i = 0; i < values.length; ++i) {
	    deque.addLast(values[i]);
	    if (deque.size() != i + 1) {
		System.out.println("  ...size method failed after addLast.");
		return false;
	    }
	}

	return true;
    }

    static boolean removeFromBack(SimpleDeque<Integer> deque, int[] values) {
	for (int i = values.length - 1; i >= 0; --i) {
	    if (deque.peekLast() != values[i]) {
		System.out.println("  ...peekLast returned wrong element.");
		return false;
	    }

	    if (deque.removeLast() != values[i]) {
		System.out.println("  ...removeLast returned wrong element.");
		return false;
	    }

	    if (deque.size() != i) {
		System.out.println("  ...size incorrect after removeLast.");
		return false;
	    }
	}

	return true;
    }

    static boolean populateFromFront(SimpleDeque<Integer> deque, int[] values) {
	for (int i = values.length - 1; i >= 0; --i) {
	    deque.addFirst(values[i]);

	    if (deque.size() != values.length - i) {
		System.out.println("  ...size method failed after addFirst.");
		return false;
	    }
	}

	return true;
    }

    static boolean removeFromFront(SimpleDeque<Integer> deque, int[] values) {
	for (int i = 0; i < values.length; ++i) {
	    if (deque.peekFirst() != values[i]) {
		System.out.println("  ...peekFirst returned wrong element.");
		return false;
	    }

	    if (deque.removeFirst() != values[i]) {
		System.out.println("  ...removeFirst returned wrong element.");
		return false;
	    }

	    if (deque.size() != values.length - i - 1) {
		System.out.println("  ...size incorrect after removeFirst.");
		return false;
	    }
	}

	return true;
    }



}
