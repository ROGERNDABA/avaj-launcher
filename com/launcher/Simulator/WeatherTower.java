package com.launcher.Simulator;

import com.launcher.Simulator.Coordinates;
import com.launcher.Simulator.Tower;
import com.launcher.Simulator.WeatherProvider;

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
