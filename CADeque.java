/**
  This code uses a circular array to implement a simple Deque.
  The following methods are used:
    - size() : returns size of deque
    - isEmpty() : returns true if the deque is empty
    - addFirst() : adds element to start of Deque
    - removeFirst() : removes the first element and returns it
    - peekFirst() : returns the first element
    - addLast() : adds element to end of Deque
    - removeLast() : removes the last element and returns it
    - peekLast() : returns the last element
    - increaseCapacity() : doubles the capacity of the array.
 **/

public class CADeque<E> implements SimpleDeque<E> {
    // This defines the default capacity of the array
    public static final int DEFAULT_CAPACITY = 16;
    // Stores the current capacity of array
    private int capacity;
    // The size of the deque
    private int size = 0;
    // The index of the first element
    private int start = 0;
    // The index of the last element
    private int end = 0;
    // The circular array
    private Object[] contents;

    // Constructors
    public CADeque() {
      this(DEFAULT_CAPACITY);
    }

    public CADeque(int initialCapacity) {
      this.capacity = initialCapacity;
      contents = new Object[capacity];
    }
    /** size()------------------------------------------------------------------
    Returns the size of the deque.
    ----------------------------------------------------------------------------
    */
    @Override
    public int size() {
      return this.size;
    }
    /** isEmpty()---------------------------------------------------------------
    Returns true if the deque is empty and false if the deque is not empty.
    ----------------------------------------------------------------------------
    */
    @Override
    public boolean isEmpty() {
      return this.size == 0;
    }
    /** addFirst()--------------------------------------------------------------
    1) checks if there is space to insert an element. If not, calls increase
    capacity.
    2) If this is the first call to addFirst (size == 0), then insert the
    element at index 0.
    3) If start is at the 0 index, insert the element at the end of the array
    and shift start to the end of the array.
    4) If start is not at the 0 index, insert the element before start, and
    shift start back.
    5) Increase size
    ----------------------------------------------------------------------------
    */
    @Override
    @SuppressWarnings("unchecked")
    public void addFirst(E x){
      if( size == capacity) {
        increaseCapacity();
      }
      if(size ==0){
        contents[0] = x;
      }
      else if(start ==0){
        contents[capacity-1] = x;
        start = capacity-1;
      }
      else {
        contents[start-1] = x;
        --start;
      }
      ++size;
    }
    /** removeFirst()-----------------------------------------------------------
    1) Check if the deque is empty, if so return exception.
    2) Else, store the item at start to return. Then shift start back if not at
    the end of the deque. If at the end of the deque, move start to the start.
    3) Decrease the size
    4) Return the element
    ----------------------------------------------------------------------------
    */
    @Override
    @SuppressWarnings("unchecked")
    public E removeFirst() {
      if(size ==0){
        throw new NullPointerException();
      }
      E item = (E) contents[start];
      if(start == capacity-1){
        start = 0;
      }
      else{
        ++start;
      }
      --size;
      return (E) item;
    }
    /** peekFirst()-------------------------------------------------------------
    1) Check if the deque is empty, if so return an exception
    2) Return the element at start
    ----------------------------------------------------------------------------
    */
    @Override
    @SuppressWarnings("unchecked")
    public E peekFirst() {
      if(size ==0){
        throw new NullPointerException();
      }
      return (E) contents[start];
    }
    /** addLast()--------------------------------------------------------------
    1) Check if the array has space. If not increase capacity.
    2) If the deque is empty, insert the element at index 0.
    3) If end is at the end of the array, insert at 0 and set end at 0.
    4) If end is not at the end of the array, insert at end+1 and shift end back.
    5) Increase size.
    ----------------------------------------------------------------------------
    */
    @Override
    public void addLast(E x){
      if( size == capacity) {
        increaseCapacity();
      }
      if (size == 0) {
        contents[0] = x;
      }
      else if (end == capacity -1){
        contents[0] = x;
        end = 0;
      }
      else {
        contents[end+1] = x;
        ++end;
      }
      ++size;
    }
    /** removeLast()------------------------------------------------------------
    1) If the deque is empty, return an exception.
    2) Store the element at end, then if end is at 0, shift end to the end of
    the array. Otherwise, shift end backwards.
    3) Reduce size.
    4) Return element.
    ----------------------------------------------------------------------------
    */
    @Override
    @SuppressWarnings("unchecked")
    public E removeLast() {
      if(size==0){
        throw new NullPointerException();
      }
      E item = (E) contents[end];
      if(end == 0){
        end = capacity-1;
      }
      else{
        --end;
      }
      --size;
      return (E) item;
    }
    /** peekLast()--------------------------------------------------------------
    1) If deque is empty, then return an exception.
    2) Return element at end.
    ----------------------------------------------------------------------------
    */
    @Override
    public E peekLast() {
      if(size ==0){
        throw new NullPointerException();
      }
      return (E) contents[end];
    }
    /** increaseCapacity()------------------------------------------------------
    1) Create a new array with twice the capacity.
    2) Copy all elements from the current deque to the new deque.
    3) Change contents to point to the new array, set the size to the old
    capacity, and set the endpoint to capacity, and update the capacity.
    ----------------------------------------------------------------------------
    */
    private void increaseCapacity() {
      Object[] bigContents = new Object[2 * capacity];
      for(int i = 0; i < capacity; ++i){
        bigContents[i] =  this.removeFirst();
      }
      contents = bigContents;
      size = capacity;
      end = capacity-1;
      capacity = 2 * capacity;
    }



}
