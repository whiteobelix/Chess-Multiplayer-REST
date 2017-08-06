package com.capgemini.chess.dao;

import java.util.List;

import com.capgemini.chess.service.to.ActualUserIDTO;
import com.capgemini.chess.service.to.OpponentToListTO;

public interface UserDAO {
	
	OpponentToListTO showPublicProfile(ActualUserIDTO opponentIDTO);	

	List<OpponentToListTO> playerTOByID(List <Long> opponentsID);	    
}

