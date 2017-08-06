package com.capgemini.chess.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.capgemini.chess.dataaccess.entities.MatchEntity;
import com.capgemini.chess.status.Status;

public class Matches {

	private static List<MatchEntity> matches = new ArrayList<>(
			Arrays.asList(new MatchEntity(1L, 1L, 2L, Status.RECEIVED), new MatchEntity(2L, 2L, 1L, Status.RECEIVED),
					new MatchEntity(3L, 1L, 3L, Status.RECEIVED), new MatchEntity(4L, 1L, 4L, Status.RECEIVED),
					new MatchEntity(5L, 1L, 5L, Status.RECEIVED), new MatchEntity(6L, 1L, 6L, Status.RECEIVED)));

	public static List<MatchEntity> getMatches() {
		return matches;
	}

	public static void setMatches(List<MatchEntity> matches) {
		Matches.matches = matches;
	}
}
