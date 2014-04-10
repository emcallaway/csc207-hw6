package edu.grinnell.callaway;

import java.io.PrintWriter;

public class SymbolMatcherExpt {

	public static void main(String[] args) throws Exception {
		PrintWriter pen = new PrintWriter(System.out, true);
		SymbolMatcher match = new SymbolMatcher();

		// Experiment 1
		match.matchSymbols("{oh [boy] (I am having) "
				+ "(<so> much) fun matching `symbols'}");
		pen.println("\nXXXXXXXXXXXXXXXXXXXXXXXX\n");

		// Experiment 2
		match.matchSymbols("(Hello (world)");
		pen.println("\nXXXXXXXXXXXXXXXXXXXXXXXX\n");

		// Experiment 3
		match.matchSymbols("(Hell[o (world)");
		pen.println("\nXXXXXXXXXXXXXXXXXXXXXXXX\n");

		// Experiment 4
		match.matchSymbols("(Hello (world))}  ]");
		pen.println("\nXXXXXXXXXXXXXXXXXXXXXXXX\n");

		// Experiment 5
		match.matchSymbols("You seem a <little> unhappy (with [[the way]] the world {is changing})");
		pen.println("\nXXXXXXXXXXXXXXXXXXXXXXXX\n");

		// Experiment 6
		match.matchSymbols("<<<{(())}>>>");
		pen.println("\nXXXXXXXXXXXXXXXXXXXXXXXX\n");

		// Experiment 7
		match.matchSymbols("<{[}])>");
		pen.println("\nXXXXXXXXXXXXXXXXXXXXXXXX\n");

		// Experiment 8
		match.matchSymbols("`Did {you} <walk (through)> walls?'");
		pen.println("\nXXXXXXXXXXXXXXXXXXXXXXXX\n");

		// Experiment 9
		match.matchSymbols("One look, (twice bold), three [four], they <way> she looks at [((me))]");
		pen.println("\nXXXXXXXXXXXXXXXXXXXXXXXX\n");

		pen.close();
	} // main

} // SymbolMatcherExpt
