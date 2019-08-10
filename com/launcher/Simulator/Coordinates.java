package com.launcher.Simulator;

/**
 * Coordinates
 */
public class Coordinates {

	private int longitude;
	private int latitude;
	private int height;

	Coordinates(int longitude, int latitude, int height) {
		this.longitude = longitude;
		this.latitude = latitude;
		this.height = height;
	}

	int getLongitude() {
		return this.longitude;
	}

	int getLatitude() {
		return this.latitude;
	}

	int getHeight() {
		return this.height;
	}
}
