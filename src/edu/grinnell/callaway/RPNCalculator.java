package edu.grinnell.callaway;

import java.math.BigDecimal;

public class RPNCalculator
{

  public ArrayBasedStack<String> calculate(ArrayBasedStack<String> stack)
    throws Exception
  {
    String operator = stack.pop();

    switch (operator)
      {
        case ("+"):
          stack.push(String.valueOf(getBD(
                                          stack.pop()).add(getBD(stack.pop()))));
          break;
        case ("-"):
          stack.push(String.valueOf(getBD(
                                          stack.pop()).subtract(getBD(stack.pop()))));
          break;
        case ("/"):
          stack.push(String.valueOf(getBD(
                                          stack.pop()).divide(getBD(stack.pop()))));
          break;
        case ("*"):
          stack.push(String.valueOf(getBD(
                                          stack.pop()).multiply(getBD(stack.pop()))));
          break;
        case ("^"):
          long exp = Long.valueOf(stack.pop());
          BigDecimal fin = getBD("1");
          BigDecimal num = getBD(stack.pop());
          for (long i = 0; i<exp; i++)
            {
              fin = fin.multiply(num);
            }
          stack.push(String.valueOf(fin));
          break;
      }
    return stack;
  }

  public BigDecimal getBD(String num)
  {
    return BigDecimal.valueOf(Double.valueOf(num));
  }
}
