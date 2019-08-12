package com.launcher.simulator.vehicles;

import com.launcher.simulator.vehicles.Flyable;
import com.launcher.simulator.vehicles.Helicopter;
import com.launcher.simulator.Coordinates;

/**
 * AircraftFactory
 */
public class AircraftFactory {
	public Flyable newAircraft(String type, String name, int longitude, int latitude, int height) {
		Coordinates coos = new Coordinates(longitude, latitude, height);
		if (type.equalsIgnoreCase("helicopter"))
			return new Helicopter(name, coos);
		else if (type.equalsIgnoreCase("jetplane"))
			return new JetPlane(name, coos);
		else if (type.equalsIgnoreCase("baloon"))
			return new Baloon(name, coos);
		return null;
	}
}
