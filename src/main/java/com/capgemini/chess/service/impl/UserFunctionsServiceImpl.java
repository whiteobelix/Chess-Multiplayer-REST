package com.capgemini.chess.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.chess.dao.UserDAO;
import com.capgemini.chess.service.GetExistingMatchesForPlayerService;
import com.capgemini.chess.service.GetMatchPropositionsForPlayerService;
import com.capgemini.chess.service.UserFunctionsService;
import com.capgemini.chess.service.to.ActualUserIDTO;
import com.capgemini.chess.service.to.MatchTO;
import com.capgemini.chess.service.to.OpponentToListTO;

/**
 * Contains fasade methods implementations
 * 
 * @author PMUNTOWS
 *
 */
@Service
public class UserFunctionsServiceImpl implements UserFunctionsService {

	private GetExistingMatchesForPlayerService getExistingMatchesForPlayerService;
	private GetMatchPropositionsForPlayerService getMatchPropositionsForPlayerService;
	private UserDAO userDAO;

	@Autowired
	UserFunctionsServiceImpl(GetExistingMatchesForPlayerService getExistingMatchesForPlayerService,
			GetMatchPropositionsForPlayerService getMatchPropositionsForPlayerService, UserDAO userDAO) {
		this.getExistingMatchesForPlayerService = getExistingMatchesForPlayerService;
		this.getMatchPropositionsForPlayerService = getMatchPropositionsForPlayerService;
		this.userDAO = userDAO;
	}

	@Override
	public List<OpponentToListTO> getMatches(ActualUserIDTO actualUser) {
		List<OpponentToListTO> matchesList = new ArrayList<>();
		if (userDAO.showPublicProfile(actualUser) != null) {

			matchesList.addAll(getExistingMatchesForPlayerService.getExistingMatchesForPlayer(actualUser));
			matchesList.addAll(getMatchPropositionsForPlayerService.getMatchPropositionsForPlayer(actualUser));
		}
		return matchesList;
	}

	@Override
	public OpponentToListTO showPublicProfile(ActualUserIDTO actualUser) {
		return userDAO.showPublicProfile(actualUser);
	}

	@Override
	public MatchTO createNewMatch(Long userID, Long opponentID) {
		return null;
	}

}
