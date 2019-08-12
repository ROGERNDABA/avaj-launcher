package com.launcher.simulator;

import java.io.*;
import com.launcher.simulator.vehicles.AircraftFactory;
import com.launcher.simulator.WeatherTower;
import com.launcher.simulator.WeatherProvider;
import com.launcher.simulator.Colors;

/**
 * Simulator
 */
public class Simulator {
	public static void main(String[] args) {

		AircraftFactory acf = new AircraftFactory();
		WeatherTower wt = new WeatherTower();
		int tries = 0;


		try {
			if (args.length < 1)
				throw new Exception("Too few arguments");
			File file = new File(args[0]);
			File simulationFile = new File("simulation.txt");
			BufferedReader b = new BufferedReader(new FileReader(file));

			String line = "";
			int lineNbr = 1;

			if (simulationFile.exists()){
				simulationFile.delete();
			}

			while ((line = b.readLine()) != null) {

				if (line.trim().length() == 0)
					continue;
				if (lineNbr == 1) {
					tries = Integer.parseInt(line);
					if (tries < 0) {
						b.close();
						throw new Exception("Error: number must be positive Integer");
					}
					lineNbr++;
					continue;
				}
				String[] parts = line.split(" ");
				if (parts.length != 5)
					throw new Exception(" Line " + lineNbr + ": There must be exactly 5 params");
				try {
					int lon = Integer.parseInt(parts[2]);
					int lat = Integer.parseInt(parts[3]);
					int h = Integer.parseInt(parts[4]);

					acf.newAircraft(parts[0], parts[1], lon, lat, h).registerTower(wt);

				} catch (NumberFormatException nfe) {
					System.err.println(
							Colors._RED + "Error Line " + lineNbr + ": 3rd, 4th and 5th arguments must be numbers" + Colors._RESET);
					break;
				} catch (Exception e) {
				}
			}
			b.close();
			if (lineNbr == 1)
				throw new Exception("File is empty");
		} catch (NumberFormatException nfe) {
			System.err.println(Colors._RED + "Error: First line of file must be an Integer" + Colors._RESET);
		} catch (Exception e) {
			System.err.println(Colors._RED + "Error: " + e.getMessage() + Colors._RESET);
		}

		WeatherProvider.getProvider();
		while (tries > 0) {
			wt.changeWeather();
			tries--;
		}

	}

}
