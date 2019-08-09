package com.launcher.Simulator;

import java.io.*;

/**
 * Simulator
 */
public class Simulator {

	public static void main(String[] args) {

		try {

			File file = new File(args[0]);
			BufferedReader b = new BufferedReader(new FileReader(file));

			String readLine = "";

			System.out.println("Reading file using Buffered Reader");

			while ((readLine = b.readLine()) != null) {
				System.out.println(readLine);
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
}
