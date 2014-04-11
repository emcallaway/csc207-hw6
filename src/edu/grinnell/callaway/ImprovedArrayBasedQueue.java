package edu.grinnell.callaway;

public class ImprovedArrayBasedQueue<T>
  extends ArrayBasedQueue<T>
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
    return false;
  //  return !this.isEmpty() && this.front == this.back;
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
<<<<<<< HEAD
      ++this.size;
      System.out.println("Front = " + this.front);
=======
      this.size++;
 //     System.out.println("S: " + this.size);
//      System.out.println("B: " + this.back);
>>>>>>> 1ce8cedb88e69a59f98f063e35d1d984f2acebf8
    }
  
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
<<<<<<< HEAD
        this.front = (this.front+1)% this.size;
        System.out.println("Front = " + this.front);
=======
        this.front = (this.front+1)% this.values.length;
>>>>>>> 1ce8cedb88e69a59f98f063e35d1d984f2acebf8
        // We're removing an element, so decrement the size
        --this.size;
        // And we're done
        return result;
        
      }
  @Override
  public T peek()
    throws Exception
  {
    if (this.isEmpty())
      {
        throw new Exception("empty");
      } // if empty
//    System.out.println("F: " + this.front);
    return this.values[this.front];
  } // peek()
  
  @Override
  int back()
  {
<<<<<<< HEAD
    if (this.values.length == this.back)
      {
        this.back = 0;
        int i = 0;
        while(this.values[i] != null);
        {
          this.back++;
          i++;
        }//while
      }//if back is the end of the queue
    /*else
      {
        this.back++;
      }//else
    */
    System.out.println("back = " + this.back);
    return this.back;
=======
   // System.out.println("L: " + this.values.length);
    if (this.back == this.values.length)
      { 
        this.back = 0;
        return this.back;
      }
    else return this.back++;

>>>>>>> 1ce8cedb88e69a59f98f063e35d1d984f2acebf8
  } // back()
}
