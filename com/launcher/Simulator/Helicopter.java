package com.launcher.Simulator;

import com.launcher.Simulator.Coordinates;
import com.launcher.Simulator.WeatherTower;
import com.launcher.Simulator.Aircraft;
import com.launcher.Simulator.Flyable;
import com.launcher.Simulator.Colors;
import com.launcher.Simulator.avajFileWritter;

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
		String msg[] = {
			"🌞  Keep your face to the sun and you will never see the shadows",
			"🌧️  The best thing one can do when it's raining is to let it rain",
			"🌫️  I like the muted sounds, the shroud of grey, and the silence that comes with fog",
			"⛄  The snow doesn't give a soft white damn whom it touches"
		};
		int msgIndex = 0;
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
			msgIndex = 1;
		}
		break;
		case "FOG": {
			this.coordinates = new Coordinates(
				coordinates.getLongitude() + 1,
				coordinates.getLatitude(),
				coordinates.getHeight());
			msgIndex = 2;
		}
			break;
		case "SNOW": {
			this.coordinates = new Coordinates(
				coordinates.getLongitude(),
				coordinates.getLatitude(),
				coordinates.getHeight() - 12);
			msgIndex = 3;
		}
			break;

		default:
			break;
		}
		new avajFileWritter("Helicopter#" + this.name + "("+ this.id +"): " + msg[msgIndex] + "\n");
		if (this.coordinates.getHeight() <= 0) {
			this.weatherTower.unregister(this);
			new avajFileWritter("Tower says: Helicopter#" + this.name + "(" + this.id + ")" + " unregistered from weather tower.\n");
		}

	}

	public void registerTower(WeatherTower weatherTower) {
		this.weatherTower = weatherTower;
		this.weatherTower.register(this);
		new avajFileWritter("Tower says: Helicopter#" + this.name + "(" + this.id + ")" + " registered to weather tower.\n");
	}
}
