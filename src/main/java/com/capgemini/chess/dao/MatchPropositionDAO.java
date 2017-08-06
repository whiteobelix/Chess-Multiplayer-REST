package com.capgemini.chess.dao;

import java.util.List;

import com.capgemini.chess.service.to.OpponentToListTO;

public interface MatchPropositionDAO {
	
	List<OpponentToListTO> matchPropositions(Long max, Long min);	
}
	
