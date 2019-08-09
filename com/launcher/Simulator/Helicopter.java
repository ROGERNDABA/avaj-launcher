package com.launcher.Simulator;

import com.launcher.Simulator.Aircraft;
import com.launcher.Simulator.Coordinates;
import com.launcher.Simulator.WeatherTower;

/**
 * Helicopter
 */
public class Helicopter extends Aircraft {
	private WeatherTower weatherTower;

	Helicopter(String name, Coordinates coordinates) {
		super(name, coordinates);
	}

	public void updateConditions() {

	}

	public void registerTower(WeatherTower weatherTower) {
		this.weatherTower = weatherTower;
	}
}
