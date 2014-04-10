package edu.grinnell.callaway;

import java.io.PrintWriter;

public class SymbolMatcherExpt
{
  
  public static void main(String[] args) throws Exception
  {
    PrintWriter pen = new PrintWriter(System.out, true);
    SymbolMatcher match = new SymbolMatcher();
    
    // Experiment 1
    match.matchSymbols("{oh [boy] (I am having) " +
    		"(<so> much) fun matching `symbols'}");
    pen.println("\nXXXXXXXXXXXXXXXXXXXXXXXX\n");
    
    // Experiment 2
    match.matchSymbols("(Hello (world)");
    pen.println("\nXXXXXXXXXXXXXXXXXXXXXXXX\n");
    
    // Experiment 3
    match.matchSymbols("(Hell[o (world)");
    pen.println("\nXXXXXXXXXXXXXXXXXXXXXXXX\n");
    
    // Experiment 4
    match.matchSymbols("(Hello (world))}  ]");
    pen.println();
    
    pen.close();
  } // main

} // SymbolMatcherExpt
