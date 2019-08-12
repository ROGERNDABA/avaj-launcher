package com.launcher.simulator.vehicles;

import com.launcher.simulator.Coordinates;
import com.launcher.simulator.WeatherTower;
import com.launcher.simulator.vehicles.Aircraft;
import com.launcher.simulator.vehicles.Flyable;
import com.launcher.simulator.avajFileWritter;

/**
 * Baloon
 */
public class Baloon extends Aircraft implements Flyable {

	private WeatherTower weatherTower;

	Baloon(String name, Coordinates coordinates) {
		super(name, coordinates);
	}

	public void updateConditions() {
		String weather = this.weatherTower.getWeather(this.coordinates);
		String msg[] = {
			"🌞  I see trees are green🌳, red roses too🌹",
			"🌧️  All it does is rain",
			"🌫️  It sure is foggy outside",
			"⛄  Do you wanna build a snowman"
		};
		int msgIndex = 0;
		switch (weather) {
		case "SUN": {
			this.coordinates = new Coordinates(
				coordinates.getLongitude() + 2,
				coordinates.getLatitude(),
				coordinates.getHeight() + 4
			);
		}
		break;
		case "RAIN": {
			this.coordinates = new Coordinates(
				coordinates.getLongitude(),
				coordinates.getLatitude(),
				coordinates.getHeight() - 5);
			msgIndex = 1;
		}
			break;
		case "FOG": {
			this.coordinates = new Coordinates(
				coordinates.getLongitude(),
				coordinates.getLatitude(),
				coordinates.getHeight() - 3);
			msgIndex = 2;
		}
			break;
		case "SNOW": {
			this.coordinates = new Coordinates(
				coordinates.getLongitude(),
				coordinates.getLatitude(),
				coordinates.getHeight() - 15);
			msgIndex = 3;
		}
			break;

		default:
			break;
		}
		new avajFileWritter("Baloon#" + this.name + "(" + this.id + "): " + msg[msgIndex] + "\n");

		if (this.coordinates.getHeight() <= 0) {
			this.weatherTower.unregister(this);
			new avajFileWritter("Tower says: Baloon#" + this.name + "(" + this.id + ")" + " unregistered from weather tower.\n");
		}

	}

	public void registerTower(WeatherTower weatherTower) {
		this.weatherTower = weatherTower;
		this.weatherTower.register(this);
		new avajFileWritter("Tower says: Baloon#" + this.name + "(" + this.id + ")" + " registered to weather tower.\n");
	}
}
