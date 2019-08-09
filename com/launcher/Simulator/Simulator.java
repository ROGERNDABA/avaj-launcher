package com.launcher.Simulator;

import java.io.*;
import java.util.Arrays;

import com.launcher.Simulator.AircraftFactory;
import com.launcher.Simulator.WeatherTower;

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

		AircraftFactory acf = new AircraftFactory();
		WeatherTower wt = new WeatherTower();
		try {
			if (args.length < 1)
				throw new Exception("Too few arguments");
			int tries = 0;
			File file = new File(args[0]);
			BufferedReader b = new BufferedReader(new FileReader(file));

			String line = "";
			int lineNbr = 0;

			while ((line = b.readLine()) != null) {

				if (line.trim().length() == 0)
					continue;
				if (lineNbr == 0) {
					tries = Integer.parseInt(line);
					if (tries < 0) {
						b.close();
						throw new Exception("Error: number must be positive Integer");
					}
					++lineNbr;
					continue;
				}
				String[] parts = line.split(" ");
				try {
					int lon = Integer.parseInt(parts[2]);
					int lat = Integer.parseInt(parts[3]);
					int h = Integer.parseInt(parts[4]);

					acf.newAircraft(parts[0], parts[1], lon, lat, h);
					System.out.println(Arrays.toString(parts));
				} catch (NumberFormatException nfe) {
					System.err.println(_RED + "Error: First line of file must be an Integer" + _RESET);
				} catch (Exception e) {
				}
			}
			b.close();
			if (lineNbr == 0)
				throw new Exception("File is empty");
		} catch (NumberFormatException nfe) {
			System.err.println(_RED + "Error: First line of file must be an Integer" + _RESET);
		} catch (Exception e) {
			System.err.println(_RED + "Error: " + e.getMessage() + _RESET);
		}
	}

}
