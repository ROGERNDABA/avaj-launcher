package com.launcher.Simulator;

import com.launcher.Simulator.Flyable;
import com.launcher.Simulator.Helicopter;

/**
 * AircraftFactory
 */
public class AircraftFactory {
	public Flyable newAircraft(String type, String name, int longitude, int latitude, int height) {
		Coordinates coos = new Coordinates(longitude, latitude, height);
		// if (type == "Helicopter")
		return new Helicopter(name, coos);
	}
}
