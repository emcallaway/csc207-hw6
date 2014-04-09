package edu.grinnell.callaway;

public class ImprovedArrayBasedQueue<T>
  extends ArrayBasedQueue<T>
{

  public ImprovedArrayBasedQueue(int capacity) throws Exception
  {
    super(capacity);
  } // ImprovedArrayBasedQueue(int capacity)
  
  
  @Override
  public boolean isFull()
  {
    return (!this.isEmpty() && this.front != this.back());
  } // isFull()
  
  @Override
  public void put(T val)
      throws Exception
    {
      
     if (this.isFull())
        {
          throw new Exception("no more room!");
        } // this.isFull()
     /*
      this.values[this.back()] = val;
      ++this.size;*/
    }
  
  @Override
  public T get()
      throws Exception
      {
        return null; //STUB
        
      }
  
  @Override
  int back()
  {
    if(super.isFull())
      {
        
      }
    
    return this.size; //STUB
  } // back()
}
