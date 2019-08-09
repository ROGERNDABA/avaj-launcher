package com.launcher.Simulator;

import com.launcher.Simulator.Flyable;
import com.launcher.Simulator.Helicopter;

/**
 * AircraftFactory
 */
public class AircraftFactory {
	public Flyable newAircraft(String type, String name, int longitude, int latitude, int height) {
		if (type == "Helicopter")
			return (new Helicopter(name, new Coordinates(longitude, latitude, height)));
	}
}
