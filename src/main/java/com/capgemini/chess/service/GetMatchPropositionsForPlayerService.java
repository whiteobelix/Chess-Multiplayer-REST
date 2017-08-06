package com.capgemini.chess.service;

import java.util.List;

import com.capgemini.chess.service.to.ActualUserIDTO;
import com.capgemini.chess.service.to.OpponentToListTO;

public interface GetMatchPropositionsForPlayerService {

	/**
	 * Method for getting match propositions for actual user.
	 * @param actualUser
	 * @return List<OpponentToListTO
	 */
	List<OpponentToListTO> getMatchPropositionsForPlayer(ActualUserIDTO actualUser);

}
