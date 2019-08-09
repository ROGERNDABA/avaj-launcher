package com.launcher.Simulator;

import java.io.*;

/**
 * Simulator
 */
public class Simulator {

	public static final String _RESET = "\u001B[0m";
	public static final String _BLACK = "\u001B[30m";
	public static final String _RED = "\u001B[31m";
	public static final String _GREEN = "\u001B[32m";
	public static final String _YELLOW = "\u001B[33m";
	public static final String _BLUE = "\u001B[34m";
	public static final String _PURPLE = "\u001B[35m";
	public static final String _CYAN = "\u001B[36m";
	public static final String _WHITE = "\u001B[37m";

	public static void main(String[] args) {

		try {
			int tries = 0;
			File file = new File(args[0]);
			BufferedReader b = new BufferedReader(new FileReader(file));

			String line = "";
			int lineNbr = 1;

			if ((line = b.readLine()) != null) {
				tries = Integer.parseInt(line);
				if (tries < 0)
					throw new Exception("Error: number must be positive Interger");
			}

			while ((line = b.readLine()) != null) {
				++lineNbr;
				try {
					System.out.println("---> " + lineNbr + " : " + line);
				} catch (NumberFormatException nfe) {
					System.err.println(_RED + "Error: First line of file must be an Integer" + _RESET);
				} catch (Exception e) {
				}
			}
		} catch (NumberFormatException nfe) {
			System.err.println(_RED + "Error: First line of file must be an Integer" + _RESET);
		} catch (Exception e) {
			System.err.println(_RED + "Error: " + e.getMessage() + _RESET);
		}
	}
}
