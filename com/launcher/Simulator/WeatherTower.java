package com.launcher.simulator;

import com.launcher.simulator.Coordinates;
import com.launcher.simulator.Tower;
import com.launcher.simulator.WeatherProvider;

/**
 * WeatherTower
 */
public class WeatherTower extends Tower {
	public String getWeather(Coordinates coordinates) {
		return WeatherProvider.getProvider().getCurrentWeather(coordinates);
	}

	void changeWeather() {
		this.conditionsChanged();
	}
}
