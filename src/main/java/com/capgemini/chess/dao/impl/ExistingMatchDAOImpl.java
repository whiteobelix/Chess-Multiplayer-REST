package com.capgemini.chess.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.capgemini.chess.dao.ExistingMatchDAO;
import com.capgemini.chess.data.Matches;
import com.capgemini.chess.dataaccess.entities.MatchEntity;

/**
 * Data Access Object gives IDs from existing match.
 * @author Pawel Muntowski
 *
 */
@Repository
public class ExistingMatchDAOImpl implements ExistingMatchDAO{

	private List<MatchEntity> existingMatches = new ArrayList<>();
	
	/**
	 * Method gives ID list of opponents from logged user matches.
	 */
	//biorę id przeciwników z meczów zalogowanego użytkownika
	//dawna nazwa: getIDOfPlayerWhosCreateMatch
	@Override
	public List<Long> getIDOfOpponentFromMyMatch(Long loggedPlayerID){
		existingMatches = Matches.getMatches();
		List<Long> ids = existingMatches.stream().filter(em -> loggedPlayerID.equals(em.getPlayerID()))
				.map(em -> em.getOpponentForPlayerID()).collect(Collectors.toList());		
		return ids;
	} 

	/**
	 * Method gives ID list of players who created matches witch logged user.
	 */
	@Override
	public List<Long> getIDOfCreatorFromOpponentMatch(Long loggedPlayerID){	
		existingMatches = Matches.getMatches();
		List<Long> ids = existingMatches.stream().filter(em -> loggedPlayerID.equals(em.getOpponentForPlayerID()))
				.map(em -> em.getPlayerID()).collect(Collectors.toList());	
		return ids;
	}
}

