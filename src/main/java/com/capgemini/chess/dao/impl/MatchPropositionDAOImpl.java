package com.capgemini.chess.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.capgemini.chess.dao.MatchPropositionDAO;
import com.capgemini.chess.dataaccess.entities.UserEntity;
import com.capgemini.chess.service.to.OpponentToListTO;
import com.capgemini.chess.service.mapper.OpponentToListMapper;
/**
 * Data Access Object gives list of opponents Transport Objects
 * @author PMUNTOWS
 *
 */
@Repository
public class MatchPropositionDAOImpl implements MatchPropositionDAO{
	
	private Map<Long, UserEntity> users = new HashMap<>();
	
	
	/**
	 * Gives list of opponent TO's with given experince level range (from -2 to +2) for match propositions .
	 */
	@Override
	public List<OpponentToListTO> matchPropositions(Long max, Long min) {
		return users.values().stream().filter(u -> u.getStats().getLevel() <= max && u.getStats().getLevel() >= min).map(users -> OpponentToListMapper.opponentToListMapper(users)).collect(Collectors.toList());		
	}
}
