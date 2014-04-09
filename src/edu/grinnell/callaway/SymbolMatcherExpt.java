package edu.grinnell.callaway;

import static org.junit.Assert.*;

import org.junit.Test;

public class SymbolMatcherExpt
{
  
  public static void main(String[] args) throws Exception
  {
    SymbolMatcher match = new SymbolMatcher();
    match.matchSymbols("{oh boy (I am having) (so much) fun matching `symbols'}");
  }

}
