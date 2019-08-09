package Aircraft;

import Coorrdinates.*;

/**
 * Aircraft
 */
public class Aircraft {
	protected long id;
	protected String name;
	protected Coordinates coordinates;

	private long idCounter = 0;

	protected Aircraft(String name, Coordinates coordinates) {
	}

	private long nextId() {
		return 1;
	}

	public static void main(String[] args) {
		System.out.println("Hello there!");
	}
}
