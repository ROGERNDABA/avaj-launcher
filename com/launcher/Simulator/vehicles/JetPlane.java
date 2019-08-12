package com.launcher.simulator.vehicles;

import com.launcher.simulator.Coordinates;
import com.launcher.simulator.WeatherTower;
import com.launcher.simulator.vehicles.Aircraft;
import com.launcher.simulator.vehicles.Flyable;
import com.launcher.simulator.avajFileWritter;

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
		String msg[] = {
			"🌞  Make hay while the sun shines",
			"🌧️  Come rain or sunshine...actually it's just rain",
			"🌫️  Sometimes when you lose your way in the fog, you end up in a beautiful place!",
			"⛄  With luck, it might even snow for us"
		};
		int msgIndex = 0;
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
			msgIndex = 1;
		}
			break;
		case "FOG": {
			this.coordinates = new Coordinates(
				coordinates.getLongitude(),
				coordinates.getLatitude() + 1,
				coordinates.getHeight());
			msgIndex = 2;
		}
			break;
		case "SNOW": {
			this.coordinates = new Coordinates(
				coordinates.getLongitude(),
				coordinates.getLatitude(),
				coordinates.getHeight() - 7);
			msgIndex = 3;
		}
			break;

		default:
			break;
		}
		new avajFileWritter("JetPlane#" + this.name + "(" + this.id + "): " + msg[msgIndex] + "\n");

		if (this.coordinates.getHeight() <= 0) {
			this.weatherTower.unregister(this);
			new avajFileWritter("Tower says: JetPlane#" + this.name + "(" + this.id + ")" + " unregistered from weather tower.\n");
		}

	}

	public void registerTower(WeatherTower weatherTower) {
		this.weatherTower = weatherTower;
		this.weatherTower.register(this);
		new avajFileWritter("Tower says: JetPlane#" + this.name + "(" + this.id + ")" + " registered to weather tower.\n");
	}

}
