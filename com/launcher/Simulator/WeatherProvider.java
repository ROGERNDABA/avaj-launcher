package com.launcher.Simulator;

import java.util.Random;

import com.launcher.Simulator.Coordinates;

/**
 * WeatherProvider
 */
public class WeatherProvider {
	private WeatherProvider weatherProvider = new WeatherProvider();
	private String[] weather = { "SUN", "FOG", "SNOW", "RAIN" };

	private WeatherProvider() {
	}

	public WeatherProvider getWeather() {
		return this.weatherProvider;
	}

	public String getCurrentWeather(Coordinates coordinates) {
		int rand = new Random().nextInt(4);
		return weather[rand];
	}
}
