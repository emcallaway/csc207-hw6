package edu.grinnell.callaway;

import java.io.PrintWriter;

public class RPNUI
{
  /**
   * @param args
   * @throws Exception
   */
  public static void main(String[] args)
    throws Exception
  {
    //preparing out- and input
    PrintWriter pen = new PrintWriter(System.out, true);
    java.io.BufferedReader eyes;
    java.io.InputStreamReader istream;
    istream = new java.io.InputStreamReader(System.in);
    eyes = new java.io.BufferedReader(istream);

    //base structure
    ArrayBasedStack<String> stack = new ArrayBasedStack<String>(30);
    pen.print("Enter a number: ");
    pen.flush();
    stack.put(eyes.readLine());
    RPNCalculator calc = new RPNCalculator();
    RPNViewer viewer = new RPNViewer();

    //as long as the command isn't to quit
    while (!stack.peek().equals("q"))
      {
        pen.print("Enter a number: ");
        pen.flush();
        stack.put(eyes.readLine());

        if (stack.peek().equals("+") || stack.peek().equals("-")
            || stack.peek().equals("/") || stack.peek().equals("*")
            || stack.peek().equals("^"))
          {
            calc.calculate(stack);
          }//if operand
        else if (stack.peek().equals("p"))
          {
            viewer.printTop(stack);
          }//else "p"
        else if (stack.peek().equals("s"))
          {
            viewer.printAll(stack);
          }//else "s"
        else if (stack.peek().equals("c"))
          {
            viewer.clear(stack);
            pen.print("Enter a number: ");
            pen.flush();
            stack.put(eyes.readLine());
          }//else "c"
      }//while

    //close the pen and reader
    eyes.close();
    pen.close();
    
  }//main(String)
}//class RPNUI
