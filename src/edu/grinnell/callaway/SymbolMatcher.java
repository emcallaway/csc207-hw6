package edu.grinnell.callaway;

import java.io.PrintWriter;

public class SymbolMatcher
{
  PrintWriter pen = new PrintWriter(System.out, true);

  class CharInt
  {
    char character;
    int integer;

    public CharInt(char chara, int inte)
    {
      this.character = chara;
      this.integer = inte;
    }
  }

  public void addSpaces(int length)
  {
    for (int i = 0; i < length; i++)
      {
        pen.print(" ");
      }
  }

  public void addDash(int length)
  {
    for (int i = 0; i < length - 1; i++)
      {
        pen.print("-");
      }
  }

  public void makeLine(ArrayBasedStack<CharInt> stack, int index, char close)
    throws Exception
  {
    int prevInd = 0;
    prevInd = stack.peek().integer;
    for (int i = 0; i < prevInd; i++)
      pen.print(" ");

    pen.print(stack.pop().character);

    for (int i = 0; i < (index - prevInd) - 1; i++)
      pen.print("-");
    pen.print(close + "\n");
  }

  public void matchSymbols(String str)
    throws Exception
  {
    pen.print(str + "\n");
    ArrayBasedStack<CharInt> stack = new ArrayBasedStack<CharInt>(100);
    char c;
    for (int i = 0; i < str.length(); i++)
      {
        c = str.charAt(i);
        switch (c)
          {
            case ('('):
              stack.push(new CharInt(c, i));
              break;
            case ('{'):
              stack.push(new CharInt(c, i));
              break;
            case ('<'):
              stack.push(new CharInt(c, i));
              break;
            case ('['):
              stack.push(new CharInt(c, i));
              break;
            case ('\''):
              if (stack.peek().character == '\'')
                makeLine(stack, i, '\'');
              else
                stack.push(new CharInt(c, i));
              break;
            case (')'):
              if (stack.peek().character == '(')
                makeLine(stack, i, ')');
              break;
            case ('}'):
              if (stack.peek().character == '{')
                makeLine(stack, i, '}');
              break;
            case ('>'):
              if (stack.peek().character == '<')
                makeLine(stack, i, '>');
              break;
            case (']'):
              if (stack.peek().character == '[')
                makeLine(stack, i, ']');
              break;
            default:
              break;
          }
      } // for (i)
    /*
     * if (stack.isEmpty()) System.out.println("Everything matches!"); else
     * throw new Exception("Unmatched character.");
     */
    pen.close();
  }
} // class SymbolMatcher
