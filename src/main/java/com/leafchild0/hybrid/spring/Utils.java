package com.leafchild0.hybrid.spring;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author victor
 * @date 10/15/18
 */
final class Utils {

	private Utils() {}

	/**
	 * Returns list of data fro grid
	 */
	static List<CustomEvent> getGridData() {
		List<CustomEvent> dummyData = new ArrayList<>();

		dummyData.add(new CustomEvent("Some description", LocalDate.now(), CustomEvent.EventType.ACCOUNT_LOCKED));
		dummyData.add(new CustomEvent(LocalDate.of(1990, 1, 10)));
		dummyData.add(new CustomEvent(LocalDate.of(2018, 11, 1)));
		dummyData.add(new CustomEvent(LocalDate.of(2015, 8, 22)));
		dummyData.add(new CustomEvent(LocalDate.now()));
		dummyData.add(new CustomEvent(LocalDate.of(2007, 4, 16)));

		return dummyData;
	}
}
