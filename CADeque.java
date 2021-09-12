/**
  want the following operations:
  - addFirst, removeFirst, peekFirst
  - addLast, removeLast, peekLast
  - size
  - isEmpty
 */

public class CADeque<E> implements SimpleDeque<E> {
    public static final int DEFAULT_CAPACITY = 16;
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
    // size---------------------------------------------------------------------
    @Override
    public int size() {
      return this.size;
    }
    // isEmpty------------------------------------------------------------------
    @Override
    public boolean isEmpty() {
      return this.size == 0;
    }
    // addFirst------------------------------------------------------------------
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
    // removeFirst--------------------------------------------------------------
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
    // peekFirst--------------------------------------------------------------
    @Override
    @SuppressWarnings("unchecked")
    public E peekFirst() {
      if(size ==0){
        throw new NullPointerException();
      }
      return (E) contents[start];
    }
    // addLast##################################################################
    @Override
    public void addLast(E x){
      if( size == capacity) {
        increaseCapacity();
        // System.out.println("increased capacity to");
        // System.out.println(capacity);
        // System.out.println(size);
      }
      // this is to fix the initial weirdness
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
    // removeLast###############################################################
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
    // peekLast#################################################################
    @Override
    public E peekLast() {
      if(size ==0){
        System.out.println("here?");
        throw new NullPointerException();
      }
      return (E) contents[end];
    }
    // increaseCapacity---------------------------------------------------------
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
