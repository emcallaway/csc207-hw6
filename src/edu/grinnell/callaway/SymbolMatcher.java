package edu.grinnell.callaway;

import java.io.PrintWriter;

/**
 * A class to match and display the nesting of parenthetical, bracketed, and
 * other statements.
 * 
 * @author Erin Callaway
 * @author Helen Dougherty
 */
public class SymbolMatcher
{
  PrintWriter pen = new PrintWriter(System.out, true);

  /**
   * An inner class that stores a character value and an integer value.
   */
  class CharInt
  {
    char character;
    int integer;

    /**
     * Constructs a CharInt that holds a character and integer value.
     * 
     * @param charac
     * @param integ
     */
    public CharInt(char charac, int integ)
    {
      this.character = charac;
      this.integer = integ;
    } // CharInt (chara, inte)
  } // class CharInt

  /**
   * Prints the amount of white space required.
   * 
   * @param length
   */
  public void addSpaces(int length)
  {
    for (int i = 0; i < length; i++)
      pen.print(" ");
  } // addSpaces (length)

  /**
   * Prints the matching symbols and a line of dash placeholders between the
   * opening and closing symbols.
   * 
   * @param open
   * @param index
   * @param close
   * @throws Exception
   */
  public void makeLine(CharInt open, int index, char close)
    throws Exception
  {
    int prevInd = 0;
    prevInd = open.integer;
    addSpaces(prevInd);

    pen.print(open.character);

    for (int i = 0; i < (index - prevInd) - 1; i++)
      pen.print("-");
    pen.print(close + "\n");
  } // makeLine (open, index, close)

  /**
   * Produces a visual representation of the matching of different symbols in
   * the given string.
   * 
   * @param str
   * @throws Exception
   */
  public void matchSymbols(String str)
    throws Exception
  {
    pen.print(str + "\n");
    ArrayBasedStack<CharInt> stack = new ArrayBasedStack<CharInt>(30);
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
            case ('`'):
              stack.push(new CharInt(c, i));
              break;
            case (')'):
              if (!stack.isEmpty() && stack.peek().character == '(')
                makeLine(stack.pop(), i, ')');
              else
                {
                  addSpaces(i);
                  pen.print(") <- UNMATCHED\n");
                } // else )
              break;
            case ('}'):
              if (!stack.isEmpty() && stack.peek().character == '{')
                makeLine(stack.pop(), i, '}');
              else
                {
                  addSpaces(i);
                  pen.print("} <- UNMATCHED\n");
                } // else }
              break;
            case ('>'):
              if (!stack.isEmpty() && stack.peek().character == '<')
                makeLine(stack.pop(), i, '>');
              else
                {
                  addSpaces(i);
                  pen.print("> <- UNMATCHED\n");
                } // else >
              break;
            case (']'):
              if (!stack.isEmpty() && stack.peek().character == '[')
                makeLine(stack.pop(), i, ']');
              else
                {
                  addSpaces(i);
                  pen.print("] <- UNMATCHED\n");
                } // else ]
              break;
            case ('\''):
              if (!stack.isEmpty() && stack.peek().character == '`')
                makeLine(stack.pop(), i, '\'');
              else
                {
                  addSpaces(i);
                  pen.print("\' <- UNMATCHED\n");
                } // else '
              break;
          } // switch (c)
      } // for (i)
    while (!stack.isEmpty())
      {
        addSpaces(stack.peek().integer);
        pen.print(stack.pop().character + " <- UNMATCHED\n");
      } // while (empty)
    pen.flush();
  } // matchSymbols(str)
} // class SymbolMatcher
