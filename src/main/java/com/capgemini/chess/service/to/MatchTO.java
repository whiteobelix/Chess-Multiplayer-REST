package com.capgemini.chess.service.to;

import com.capgemini.chess.status.Status;

/**
 * MatchTO class contains fields of match
 * 
 * @author PMUNTOWS
 *
 */
public class MatchTO {
	Long matchID;
	Long playerID;
	Long opponentForPlayerID;
	Status status;

	public Long getMatchID() {
		return matchID;
	}

	public void setMatchID(Long matchID) {
		this.matchID = matchID;
	}

	public Long getPlayerID() {
		return playerID;
	}

	public void setPlayerID(Long playerID) {
		this.playerID = playerID;
	}

	public Long getOpponentForPlayerID() {
		return opponentForPlayerID;
	}

	public void setOpponentForPlayerID(Long opponentForPlayerID) {
		this.opponentForPlayerID = opponentForPlayerID;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

}
