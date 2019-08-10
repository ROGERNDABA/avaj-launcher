package com.launcher.Simulator;

import com.launcher.Simulator.Coordinates;
import com.launcher.Simulator.WeatherTower;
import com.launcher.Simulator.Aircraft;
import com.launcher.Simulator.Flyable;

/**
 * Helicopter
 */
public class Helicopter extends Aircraft implements Flyable {
	private WeatherTower weatherTower;

	Helicopter(String name, Coordinates coordinates) {
		super(name, coordinates);

	}

	public void updateConditions() {
		String weather = this.weatherTower.getWeather(this.coordinates);
		switch (weather) {
		case "SUN": {
			this.coordinates = new Coordinates(
				coordinates.getLongitude() + 10,
				coordinates.getLatitude(),
				coordinates.getHeight() + 2
			);
		}
		break;
		case "RAIN": {
			this.coordinates = new Coordinates(
				coordinates.getLongitude() + 5,
				coordinates.getLatitude(),
				coordinates.getHeight());
		}
			break;
		case "FOG": {
			this.coordinates = new Coordinates(
				coordinates.getLongitude() + 1,
				coordinates.getLatitude(),
				coordinates.getHeight());
		}
			break;
		case "SNOW": {
			this.coordinates = new Coordinates(
				coordinates.getLongitude(),
				coordinates.getLatitude(),
				coordinates.getHeight() - 12);
		}
			break;

		default:
			break;
		}
		if (this.coordinates.getHeight() == 0) {
			this.weatherTower.unregister(this);
			System.out.println("Tower says: Helicopter#" + this.name + "(" + this.id + ")" + " unregistered from weather tower.");
		}

	}

	public void registerTower(WeatherTower weatherTower) {
		this.weatherTower = weatherTower;
		this.weatherTower.register(this);
		System.out.println("Tower says: Helicopter#" + this.name + "(" + this.id + ")" + " registered to weather tower.");
	}
}
