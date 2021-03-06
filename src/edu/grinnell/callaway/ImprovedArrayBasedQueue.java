package edu.grinnell.callaway;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ImprovedArrayBasedQueue<T>
    extends
      ArrayBasedQueue<T>
{

  /*
   * Fields
   */

  int back; // index of the last element currently in the queue

  /*
   * Constructors
   */

  public ImprovedArrayBasedQueue(int capacity) throws Exception
  {
    super(capacity);
    this.back = 0;
  } // ImprovedArrayBasedQueue(int capacity)

  /*
   * Methods
   */

  @Override
  /**
   * Determine whether the queue is full
   */
  public boolean isFull()
  {
    return !this.isEmpty() && this.front == ((this.back) % this.values.length);
  } // isFull()

  @Override
  /**
   * Insert a value in the queue in the next available index
   * 
   * Throws Exception if queue is full
   */
  public void put(T val)
    throws Exception
  {

    if (this.isFull())
      {
        throw new Exception("no more room!");
      } // if(this.isFull())

    this.values[this.back()] = val;
    this.size++;
  } // put()

  @Override
  /**
   * Retrieve, erase, and return the current value in the queue.
   */
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
  /**
   * See which element will be next returned by get().
   */
  public T peek()
    throws Exception
  {
    if (this.isEmpty())
      {
        throw new Exception("empty");
      } // if empty
    return this.values[this.front];
  } // peek()

  /*
   * Helper Methods
   */
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
      } // if back is at the end of the queue
    else
      return this.back++;
  } // back()

  /*
   * Iterator
   */
  class ImprovedArrayBasedQueueIterator<T>
      implements
        Iterator<T>
  {
    // +--------+----------------------------------------------------------
    // | Fields |
    // +--------+

    T[] values;
    int pos;

    // +--------------+----------------------------------------------------
    // | Constructors |
    // +--------------+

    /**
     * Create a new iterator.
     */

    public ImprovedArrayBasedQueueIterator(ImprovedArrayBasedQueue<T> q)
    {
      this.pos = q.front;
      this.values = q.values;
    } // ImprovedArrayBasedQueueIterator

    // +---------+---------------------------------------------------------
    // | Methods |
    // +---------+

    @Override
    /**
     * Return the current element
     */
    public T next()
      throws NoSuchElementException
    {
      if (!this.hasNext())
        {
          throw new NoSuchElementException("no elements remain");
        } // if no elements
      T next;
      if (this.pos == this.values.length)
        {
          this.pos = 0;
          next = this.values[this.values.length - 1];
        }// if the queue is wrapped around
      next = this.values[pos];
      pos++;
      return next;
    } // next()

    @Override
    /**
     * Check if there are any further elements in the queue
     */
    public boolean hasNext()
    {
      return this.pos != ImprovedArrayBasedQueue.this.back;
    } // hasNext()

    @Override
    /**
     * Unsupported
     */
    public void remove()
      throws UnsupportedOperationException
    {
      throw new UnsupportedOperationException();
    } // remove()
  } // ImprovedArrayBasedQueueIterator<T>
} // class ImprovedArrayBasedQueue
