package edu.grinnell.callaway;

import java.io.PrintWriter;

public class RPNViewer
{
  public void printTop(ArrayBasedStack<String> stack)
    throws Exception
  {
    PrintWriter pen = new PrintWriter(System.out, true);
    stack.pop();
    pen.print(stack.peek() + "\n");
    pen.flush();
  }

  public void printAll(ArrayBasedStack<String> stack)
    throws Exception
  {
    PrintWriter pen = new PrintWriter(System.out, true);
    stack.pop();
    int size = stack.size;
   
    while (!stack.isEmpty())
      {
        pen.print(stack.pop() + "\n");
        
      }
    pen.flush();
    stack.size =size;
  }
  /**
   * printTop and printAll should not be called after
   * @param stack
   * @throws Exception
   */
  public void clear(ArrayBasedStack<String> stack)
      throws Exception
    {
      while(!stack.isEmpty())
        {
          stack.pop();
        }
    }
}
