package com.launcher.Simulator;

import com.launcher.Simulator.Coordinates;

/**
 * Aircraft
 */
public class Aircraft {
	protected long id;
	protected String name;
	protected Coordinates coordinates;

	private long idCounter = 0;

	protected Aircraft(String name, Coordinates coordinates) {
		this.id = nextId();
		this.coordinates = coordinates;
		this.name = name;
	}

	private long nextId() {
		return ++idCounter;
	}

	public static void main(String[] args) {
		System.out.println("Hello there!");
	}
}
