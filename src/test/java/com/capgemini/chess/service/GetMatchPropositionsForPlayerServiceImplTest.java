package com.capgemini.chess.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;

import org.mockito.runners.MockitoJUnitRunner;

import com.capgemini.chess.dao.ExistingMatchDAO;
import com.capgemini.chess.dao.MatchPropositionDAO;
import com.capgemini.chess.dao.UserDAO;
import com.capgemini.chess.service.to.ActualUserIDTO;
import com.capgemini.chess.service.to.OpponentToListTO;
import com.capgemini.chess.service.GetMatchPropositionsForPlayerService;
import com.capgemini.chess.service.impl.GetMatchPropositionsForPlayerServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class GetMatchPropositionsForPlayerServiceImplTest {

	@Mock
	ExistingMatchDAO existingMatches;

	@Mock
	MatchPropositionDAO matchPropositions;

	@Mock
	UserDAO publicProfile;

	@Test
	public void shouldReturnMatchPropositionsForPlayer() {

		GetMatchPropositionsForPlayerService getMatchPropositionsForPlayerService = new GetMatchPropositionsForPlayerServiceImpl(
				existingMatches, matchPropositions, publicProfile);

		// given
		ActualUserIDTO actualUserIDTO = new ActualUserIDTO();
		actualUserIDTO.setId(9L);
		List<Long> usersIDs = addUsersIDs();
		List<OpponentToListTO> matches = addMatches();
		OpponentToListTO userProfile = new OpponentToListTO();
		userProfile.setId(actualUserIDTO.getId());
		userProfile.setLevel(8L);

		when(existingMatches.getIDOfOpponentFromMyMatch(10L)).thenReturn(usersIDs);
		when(matchPropositions.matchPropositions(10L, 6L)).thenReturn(matches);
		when(publicProfile.showPublicProfile(actualUserIDTO)).thenReturn(userProfile);

		// when
		List<OpponentToListTO> propositions = getMatchPropositionsForPlayerService
				.getMatchPropositionsForPlayer(actualUserIDTO);

		// then
		assertEquals(5, propositions.size());
		assertEquals(6, (int) (long) propositions.get(0).getLevel());
	}

	List<Long> addUsersIDs() {
		List<Long> usersIDs = new ArrayList<>();
		usersIDs.add(11L);
		usersIDs.add(12L);
		usersIDs.add(17L);
		usersIDs.add(16L);
		usersIDs.add(15L);
		usersIDs.add(14L);
		usersIDs.add(13L);
		return usersIDs;
	}

	List<OpponentToListTO> addMatches() {
		List<OpponentToListTO> matches = new ArrayList<>();

		OpponentToListTO someOpponent1 = new OpponentToListTO();
		someOpponent1.setId(11L);
		someOpponent1.setLevel(6L);
		OpponentToListTO someOpponent2 = new OpponentToListTO();
		someOpponent2.setId(12L);
		someOpponent2.setLevel(7L);
		OpponentToListTO someOpponent3 = new OpponentToListTO();
		someOpponent3.setId(13L);
		someOpponent3.setLevel(8L);
		OpponentToListTO someOpponent4 = new OpponentToListTO();
		someOpponent4.setId(14L);
		someOpponent4.setLevel(9L);
		OpponentToListTO someOpponent5 = new OpponentToListTO();
		someOpponent5.setId(15L);
		someOpponent5.setLevel(100L);
		OpponentToListTO someOpponent6 = new OpponentToListTO();
		someOpponent6.setId(16L);
		someOpponent6.setLevel(1L);
		OpponentToListTO someOpponent7 = new OpponentToListTO();
		someOpponent7.setId(17L);
		someOpponent7.setLevel(10L);

		matches.add(someOpponent1);
		matches.add(someOpponent2);
		matches.add(someOpponent3);
		matches.add(someOpponent4);
		matches.add(someOpponent5);
		matches.add(someOpponent6);
		matches.add(someOpponent7);
		return matches;
	}

}
