package com.launcher.simulator;

import java.util.Random;

import com.launcher.simulator.Coordinates;

/**
 * WeatherProvider
 */
public class WeatherProvider {
	private static WeatherProvider weatherProvider = new WeatherProvider();
	private static String[] weather = { "SUN", "FOG", "SNOW", "RAIN" };

	private WeatherProvider() {
	}

	public static WeatherProvider getProvider() {
		return weatherProvider;
	}

	public String getCurrentWeather(Coordinates coordinates) {
		int rand = new Random().nextInt(4);
		return weather[rand];
	}
}
