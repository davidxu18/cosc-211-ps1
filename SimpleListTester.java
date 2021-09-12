// A simple program that uses a SimpleList

public class SimpleListTester {
    
    public static void main(String[] args) {
	// create a SimpleList of Integers, using the
	// ArraySimpleListOne implementation
	SimpleList<Integer> list = new ArraySimpleListOne<Integer>();

	// add a few elements to the list, and prints its contents	
	list.add(0, 1);
	list.add(1, 2);
	list.add(2, 3);
	list.add(3, 4);
	System.out.println("list contents:");
	printList(list);

	// insert a value
	System.out.println("adding value 5 at index 1...");
	list.add(1, 5);
	System.out.println("list contents:");
	printList(list);

	// remove a value
	System.out.println("remove value " + list.remove(2) + " from index 2");
	System.out.println("list contents:");
	printList(list);
    }

    static void printList(SimpleList<Integer> list) {
	System.out.print("[");
	
	for (int i = 0; i < list.size(); ++i) {
	    
	    System.out.print(list.get(i));
	    
	    if (i < list.size() - 1)
		System.out.print(", ");
	}
	
	System.out.println("]\n");
    }

    
}
