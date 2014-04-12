package edu.grinnell.callaway;

import java.io.IOException;
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
    PrintWriter pen = new PrintWriter(System.out, true);
    java.io.BufferedReader eyes;
    java.io.InputStreamReader istream;
    istream = new java.io.InputStreamReader(System.in);
    eyes = new java.io.BufferedReader(istream);

    ArrayBasedStack<String> stack = new ArrayBasedStack<String>(30);
    pen.print("Enter a number: ");
    pen.flush();
    stack.put(eyes.readLine());
    RPNCalculator calc = new RPNCalculator();
    RPNViewer viewer = new RPNViewer();

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
          }
        else if (stack.peek().equals("p"))
          {
            viewer.printTop(stack);
          }
        else if (stack.peek().equals("s"))
          {
            viewer.printAll(stack);
          }
        else if (stack.peek().equals("c"))
          {
            viewer.clear(stack);
            pen.print("Enter a number: ");
            pen.flush();
            stack.put(eyes.readLine());
          }
      }

    eyes.close();

    pen.close();
  }
}
