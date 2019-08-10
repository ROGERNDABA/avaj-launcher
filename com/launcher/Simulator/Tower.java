package com.launcher.Simulator;

import com.launcher.Simulator.Flyable;
import java.util.List;
import java.util.ArrayList;

/**
 * Tower
 */
public class Tower {

	private List<Flyable> observer = new ArrayList<Flyable>();

	public void register(Flyable flyable) {
		this.observer.add(flyable);
	}

	public void unregister(Flyable flyable) {
		this.observer.remove(flyable);
	}

	protected void conditionsChanged() {
		for (int i = 0;i < observer.size();i++) {
			observer.get(i).updateConditions();
			System.out.println("===== " + observer.get(i).toString());
		}
	}
}
