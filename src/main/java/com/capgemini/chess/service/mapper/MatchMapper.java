package com.capgemini.chess.service.mapper;

import com.capgemini.chess.dataaccess.entities.MatchEntity;
import com.capgemini.chess.service.to.MatchTO;

public class MatchMapper {

	public static MatchTO map(MatchEntity matchEntity) {
		if (matchEntity != null) {
			MatchTO matchTO = new MatchTO();
			matchTO.setMatchID(matchEntity.getMatchID());
			matchTO.setPlayerID(matchEntity.getPlayerID());
			matchTO.setOpponentForPlayerID(matchEntity.getOpponentForPlayerID());
			matchTO.setStatus(matchEntity.getStatus());
			return matchTO;
		}
		return null;
	}

	public static MatchEntity map(MatchTO matchTO) {
		if (matchTO != null) {
			MatchEntity matchEntity = new MatchEntity();
			matchEntity.setMatchID(matchTO.getMatchID());
			matchEntity.setPlayerID(matchTO.getPlayerID());
			matchEntity.setOpponentForPlayerID(matchTO.getOpponentForPlayerID());
			matchEntity.setStatus(matchTO.getStatus());
			return matchEntity;
		}
		return null;
	}

}
