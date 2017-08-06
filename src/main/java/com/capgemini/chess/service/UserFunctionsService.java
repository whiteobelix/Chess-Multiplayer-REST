package com.capgemini.chess.service;

import java.util.List;

import com.capgemini.chess.service.to.ActualUserIDTO;
import com.capgemini.chess.service.to.MatchTO;
import com.capgemini.chess.service.to.OpponentToListTO;

/**
 * Fasade provide three public methods in the chess game for logged user.
 * Each user have specific ID.
 * 
 * @author Pawel Muntowski
 *
 */
public interface UserFunctionsService {
	List<OpponentToListTO> getMatches(ActualUserIDTO actualUser);

	OpponentToListTO showPublicProfile(ActualUserIDTO actualUser);

	MatchTO createNewMatch(Long playerID, Long opponentID);

}
