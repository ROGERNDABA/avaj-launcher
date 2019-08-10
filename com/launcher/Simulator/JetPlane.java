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

	}

	public void updateConditions() {
		String weather = this.weatherTower.getWeather(this.coordinates);
		switch (weather) {
		case "SUN": {
			this.coordinates = new Coordinates(
				coordinates.getLongitude(),
				coordinates.getLatitude() + 10,
				coordinates.getHeight() + 2
			);
		}
		break;
		case "RAIN": {
			this.coordinates = new Coordinates(
				coordinates.getLongitude(),
				coordinates.getLatitude() + 5,
				coordinates.getHeight());
		}
			break;
		case "FOG": {
			this.coordinates = new Coordinates(
				coordinates.getLongitude(),
				coordinates.getLatitude() + 1,
				coordinates.getHeight());
		}
			break;
		case "SNOW": {
			this.coordinates = new Coordinates(
				coordinates.getLongitude(),
				coordinates.getLatitude(),
				coordinates.getHeight() - 7);
		}
			break;

		default:
			break;
		}
		if (this.coordinates.getHeight() == 0) {
			this.weatherTower.unregister(this);
			System.out.println("Tower says: JetPlane#" + this.name + "(" + this.id + ")" + " unregistered from weather tower.");
		}

	}

	public void registerTower(WeatherTower weatherTower) {
		this.weatherTower = weatherTower;
		this.weatherTower.register(this);
		System.out.println("Tower says: JetPlane#" + this.name + "(" + this.id + ")" + " registered to weather tower.");
	}

}
