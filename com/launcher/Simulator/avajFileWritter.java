package com.launcher.simulator;

import java.io.*;

/**
 * FileWritter
 */
public class avajFileWritter {
	public avajFileWritter(String str) {
		try {
			File file = new File("simulation.txt");
			PrintWriter pw = new PrintWriter(new FileWriter(file, true));
			pw.write(str);
			pw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}