package com.luisaraujoc.cativeriolfc.Util;

import com.luisaraujoc.cativeriolfc.Entity.Person;
import com.luisaraujoc.cativeriolfc.Entity.Time;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TimeSorter {

	public static List<Time> sortearTimes(List<Person> pessoas, int numTimes) {
		if (pessoas.size() < numTimes * 5) {
			throw new IllegalArgumentException("Not enough players to form the requested number of teams.");
		}

		// Shuffle the list to ensure randomness
		Collections.shuffle(pessoas);

		List<Time> times = new ArrayList<>();
		for (int i = 0; i < numTimes; i++) {
			times.add(new Time("Time " + (i + 1)));
		}

		int index = 0;
		while (index < pessoas.size() && !times.isEmpty()) {
			for (Time time : times) {
				if (time.getJogadores().size() < 6 && index < pessoas.size()) {
					time.addJogador(pessoas.get(index++));
				}
			}
		}

		for (Time time : times) {
			time.validateJogadores();
		}

		return times;
	}
}