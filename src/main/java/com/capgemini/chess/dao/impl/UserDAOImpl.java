package com.capgemini.chess.dao.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.capgemini.chess.dao.UserDAO;
import com.capgemini.chess.data.Users;
import com.capgemini.chess.dataaccess.entities.UserEntity;
import com.capgemini.chess.service.mapper.OpponentToListMapper;
import com.capgemini.chess.service.to.ActualUserIDTO;
import com.capgemini.chess.service.to.OpponentToListTO;

@Repository
public class UserDAOImpl implements UserDAO{

	/**
	 * Gives opponent TO for given ID with public informations (excluding password and email). 
	 */
	@Override
	public OpponentToListTO showPublicProfile(ActualUserIDTO opponentIDTO) {
		OpponentToListTO profile = null;
		List<UserEntity> users = Users.getUsers();
		try {
			profile = users.stream().filter(us -> opponentIDTO.getId().equals(us.getId())).map(us -> OpponentToListMapper.opponentToListMapper(us)).collect(Collectors.toList()).get(0);
		} catch (NullPointerException e) {
			System.out.println("Profile error. User ID: "+ opponentIDTO.getId());
			e.printStackTrace();
		}		
		return profile ;
		}

	/**
	 * Gives list of opponents TO's for given ID's.
	 */
	@Override
	public	List<OpponentToListTO> playerTOByID(List <Long> opponentsID){
		List<UserEntity> users = Users.getUsers();
		List<OpponentToListTO> opponentsList = null;
		users = Users.getUsers();
		try {
			opponentsList = users.stream().filter(us -> opponentsID.contains(us.getId())).map(us -> OpponentToListMapper.opponentToListMapper(us)).collect(Collectors.toList());
		} catch (NullPointerException e) {
			System.out.println("Profile list error. ID's list: "+ opponentsID);
			e.printStackTrace();
		}			
		return opponentsList;
		}
}
