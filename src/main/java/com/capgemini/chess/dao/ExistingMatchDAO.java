package com.capgemini.chess.dao;

import java.util.List;

public interface ExistingMatchDAO {
	
	List<Long> getIDOfOpponentFromMyMatch(Long userID);
	
	List<Long> getIDOfCreatorFromOpponentMatch(Long userID);
}
