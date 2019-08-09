package Helicopter;

import Aircraft.Aircraft;
import Coorrdinates.Coordinates;
import WeatherTower.WeatherTower;

/**
 * Helicopter
 */
public class Helicopter extends Aircraft {
	private WeatherTower weatherTower;

	Helicopter(String name, Coordinates coordinates) {
		super(name, coordinates);
	}

	public void updateConditions() {

	}

	public void registerTower(WeatherTower weatherTower) {
		this.weatherTower = weatherTower;
	}
}
