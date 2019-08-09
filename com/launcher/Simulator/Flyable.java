package com.launcher.Simulator;

import com.launcher.Simulator.WeatherTower;

/**
 * Flyable
 */
public interface Flyable {
	public void updateConditions();

	public void registerTower(WeatherTower weatherTower);
}
