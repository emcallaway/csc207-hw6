
package edu.grinnell.callaway;


/**
* A really simple experiment with ArrayBasedQueues.
*
* @author Samuel A. Rebelsky.
*/
public class ImprovedArrBasedQueueExpt
{
  /**
* Do all the work. (Well, make the helpers do all the work.)
*/
  public static void main(String[] args)
    throws Exception
  {
    ReportingLinearStructure<String> expt =
        new ReportingLinearStructure<String>(new ImprovedArrayBasedQueue<String>(3),
                                             "expt.");
    // Put in a few values, then remove two
    expt.isEmpty();
    expt.isFull();
    expt.put("a");
    expt.peek();
    expt.put("b");
    expt.peek();
    expt.put("c");
    expt.peek();
    expt.isFull();
    expt.get();
    expt.peek();
    expt.put("d");
    expt.peek();
    expt.get();
    expt.isFull();
    expt.put("x");
    expt.peek();
    expt.get();
    expt.peek();
    expt.get();
    expt.peek();
    expt.get();
    expt.isEmpty();
    expt.isFull();

  } // main(String[])
} // class ArrayBasedQueueExpt 
