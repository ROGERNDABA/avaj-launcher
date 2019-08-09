package com.launcher.Simulator;

import com.launcher.Simulator.Coordinates;
import com.launcher.Simulator.WeatherTower;
import com.launcher.Simulator.Aircraft;
import com.launcher.Simulator.Flyable;

/**
 * JetPlane
 */
public class JetPlane extends Aircraft implements Flyable {

	private WeatherTower weatherTower;

	JetPlane(String name, Coordinates coordinates) {
		super(name, coordinates);
		System.out.println("JetPlane Constructor");
	}

	public void updateConditions() {
	}

	public void registerTower(WeatherTower weatherTower) {
		this.weatherTower = weatherTower;
	}

}
