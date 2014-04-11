package edu.grinnell.callaway;

public class ImprovedArrayBasedQueue<T>
    extends
      ArrayBasedQueue<T>
{

  int back;

  public ImprovedArrayBasedQueue(int capacity) throws Exception
  {
    super(capacity);
    this.back = 0;
  } // ImprovedArrayBasedQueue(int capacity)

  @Override
  public boolean isEmpty()
  {
    return this.size <= 0;
  } // isEmpty()

  @Override
  public boolean isFull()
  {
    return !this.isEmpty() && this.front == ((this.back) % this.values.length);
  } // isFull()

  @Override
  public void put(T val)
    throws Exception
  {

    if (this.isFull())
      {
        throw new Exception("no more room!");
      } // this.isFull()

    this.values[this.back()] = val;
    this.size++;
  } // put()

  @Override
  public T get()
    throws Exception
  {
    if (this.isEmpty())
      {
        throw new Exception("empty");
      } // if empty
    // Grab and clear the element at the front of the queue
    T result = this.values[this.front];
    this.values[this.front] = null;
    this.front = (this.front + 1) % (this.values.length);
    // We're removing an element, so decrement the size
    --this.size;
    // And we're done
    return result;

  } // get()

  @Override
  public T peek()
    throws Exception
  {
    if (this.isEmpty())
      {
        throw new Exception("empty");
      } // if empty
    return this.values[this.front];
  } // peek()

  @Override
  /**
   * Figure out where the next element should go and advance to the
   * next location.
   */
  int back()
  {
    if (this.back >= this.values.length - 1)
      {
        this.back = 0;
        return this.values.length - 1;
      } // if
    else
      return this.back++;
  } // back()
} // class ImprovedArrayBasedQueue
