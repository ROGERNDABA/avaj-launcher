package com.launcher.simulator.vehicles;

import com.launcher.simulator.WeatherTower;

/**
 * Flyable
 */
public interface Flyable {
	public void updateConditions();

	public void registerTower(WeatherTower weatherTower);
}
