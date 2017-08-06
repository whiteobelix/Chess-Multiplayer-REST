package com.capgemini.chess.dataaccess.entities;

import com.capgemini.chess.status.Status;

/**
 * Entity of match
 * @author PMUNTOWS
 *
 */
public class MatchEntity {

	private Long matchID;
	private Long playerID;
	private Long opponentForPlayerID;
	private Status status;
	
	public MatchEntity(){
	}
	
	public MatchEntity(Long matchID, Long playerID, Long opponentForPlayerID, Status status){
		this.matchID = matchID;
		this.playerID = playerID;
		this.opponentForPlayerID = opponentForPlayerID;
		this.status = status;
	}
	
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
