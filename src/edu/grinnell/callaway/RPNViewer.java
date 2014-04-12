package edu.grinnell.callaway;

import java.io.PrintWriter;

public class RPNViewer
{
  
  /**
   * Print the current item in the stack
   * 
   * @precondition stack before command is not empty
   * @postcondition prints the last item put in before command
   * 
   * @param stack
   * @throws Exception
   */
  public void printTop(ArrayBasedStack<String> stack)
    throws Exception
  {
    PrintWriter pen = new PrintWriter(System.out, true);
    stack.pop();
    pen.print(stack.peek() + "\n");
    pen.flush();
  }//printTop(ArrayBasedStack<String>)

  /**
   * Print the entire stack
   *
   * @precondition stack before command is not empty
   * @postcondition prints entire stack, 
   *                   minus the command to print
   *                   
   * @param stack
   * @throws Exception
   */
  public void printAll(ArrayBasedStack<String> stack)
    throws Exception
  {
    PrintWriter pen = new PrintWriter(System.out, true);
    stack.pop();
    int size = stack.size;
   
    while (!stack.isEmpty())
      {
        pen.print(stack.pop() + "\n");
      }//while
    pen.flush();
    stack.size =size;
  }//printAll(ArrayBasedStack<String>)
  
  /**
   * Clear the stack
   * 
   * @param stack
   * @throws Exception
   */
  public void clear(ArrayBasedStack<String> stack)
      throws Exception
    {
      stack.size = 0;
    }//clear(ArrayBasedStack<String>)
}//class RPNViewer
