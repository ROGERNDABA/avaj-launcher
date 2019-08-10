package com.launcher.Simulator;

import com.launcher.Simulator.Coordinates;
import com.launcher.Simulator.WeatherTower;
import com.launcher.Simulator.Aircraft;
import com.launcher.Simulator.Flyable;

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
			Colors._GREEN + "🌞  I see trees are green🌳, red roses too🌹" + Colors._RESET,
			Colors._CYAN + "🌧️  All it does is rain" + Colors._RESET,
			Colors._PURPLE + "🌫️  It sure is foggy outside" + Colors._RESET,
			Colors._WHITE + "⛄  Do you wanna build a snowman" + Colors._RESET
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
		System.out.println("Baloon#" + this.name + "(" + this.id + "): " + msg[msgIndex]);

		System.out.println("-----> "+this.coordinates.getHeight());
		if (this.coordinates.getHeight() == 0) {
			this.weatherTower.unregister(this);
			System.out.println("Tower says: Baloon#" + this.name + "(" + this.id + ")" + " unregistered from weather tower.");
		}

	}

	public void registerTower(WeatherTower weatherTower) {
		this.weatherTower = weatherTower;
		this.weatherTower.register(this);
		System.out.println("Tower says: Baloon#" + this.name + "(" + this.id + ")" + " registered to weather tower.");
	}
}
