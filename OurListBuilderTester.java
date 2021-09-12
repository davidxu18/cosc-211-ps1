public class OurListBuilderTester {

    /**
     * Add elements 0, 1, ..., size - 1 to list (in order).
     */
    public static void buildListFirst(SimpleDeque<Integer> list, int size) {
	for (int i = 0; i < size; ++i) {
	    list.addFirst(i);
	}
    }

    public static void buildListLast(SimpleDeque<Integer> list, int size) {
  for (int i = 0; i < size; ++i) {
      list.addLast(i);
  }
    }

    static int[] getSizeArray(int max, int step) {
	int[] sizes = new int[max / step];
	int size = step;

	for (int i = 0; i < max / step; ++i) {
	    sizes[i] = step + i * step;
	}

	return sizes;
    }


    public static void main(String[] args) {
	int[] sizes = getSizeArray(10_000, 100);
	RunTimer rt = new RunTimer();
	CSVWriter csv = new CSVWriter("list-buildtime.csv");

	csv.addEntry("list size");
	csv.addEntry("Circular Array Deque AddFirst time (ns)");
	csv.addEntry("DLL Deque AddFirst time (ns)");
  csv.addEntry("ASL Deque AddFirst time (ns)");
  csv.addEntry("LSL Deque AddFirst time (ns)");
  csv.addEntry("Circular Array Deque AddLast time (ns)");
  csv.addEntry("DLL Deque AddLast time (ns)");
  csv.addEntry("ASL Deque AddLast time (ns)");
  csv.addEntry("LSL Deque AddLast time (ns)");
  csv.endLine();

	SimpleDeque<Integer> CADeque;
	SimpleDeque<Integer> DLLDeque;
  SimpleDeque<Integer> ASLDeque;
  SimpleDeque<Integer> LSLDeque;

	for (int size : sizes) {
	    CADeque = new CADeque<Integer>();
	    DLLDeque = new DLLDeque<Integer>();
      ASLDeque = new ASLDeque<Integer>();
      LSLDeque = new LSLDeque<Integer>();

	    csv.addEntry(size);
//------------------------------------------------------------------------------
	    rt.reset();
	    rt.start();
	    buildListFirst(CADeque, size);
	    rt.stop();
	    csv.addEntry(rt.getElapsedNanos());
	    rt.reset();
	    rt.start();
	    buildListLast(CADeque, size);
	    rt.stop();
	    csv.addEntry(rt.getElapsedNanos());
//------------------------------------------------------------------------------
      rt.reset();
      rt.start();
      buildListFirst(DLLDeque, size);
      rt.stop();
      csv.addEntry(rt.getElapsedNanos());
      rt.reset();
      rt.start();
      buildListLast(DLLDeque, size);
      rt.stop();
      csv.addEntry(rt.getElapsedNanos());
//------------------------------------------------------------------------------
      rt.reset();
      rt.start();
      buildListFirst(ASLDeque, size);
      rt.stop();
      csv.addEntry(rt.getElapsedNanos());
      rt.reset();
      rt.start();
      buildListLast(ASLDeque, size);
      rt.stop();
      csv.addEntry(rt.getElapsedNanos());
//------------------------------------------------------------------------------
      rt.reset();
      rt.start();
      buildListFirst(LSLDeque, size);
      rt.stop();
      csv.addEntry(rt.getElapsedNanos());
      rt.reset();
      rt.start();
      buildListLast(LSLDeque, size);
      rt.stop();
      csv.addEntry(rt.getElapsedNanos());
//------------------------------------------------------------------------------

	    csv.endLine();
	}

	csv.close();
    }


}
