package com.capgemini.chess.service;

import java.util.List;

import com.capgemini.chess.service.to.ActualUserIDTO;
import com.capgemini.chess.service.to.OpponentToListTO;

public interface GetExistingMatchesForPlayerService {
	
	/**
	 * Method for getting existing match for actual user.
	 * @param actualUser
	 * @return List<OpponentToListTO>
	 */
	List<OpponentToListTO> getExistingMatchesForPlayer(ActualUserIDTO actualUser);
}
