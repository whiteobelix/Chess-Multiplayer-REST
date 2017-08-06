package com.capgemini.chess.service.mapper;

import com.capgemini.chess.dataaccess.entities.UserEntity;
import com.capgemini.chess.service.to.OpponentToListTO;

/**
 * Mapper for getting OpponentToListTO object from entity
 * 
 * @author PMUNTOWS
 *
 */
public class OpponentToListMapper {

	public static OpponentToListTO opponentToListMapper(UserEntity userEntity) {
		OpponentToListTO opponentToListTO = new OpponentToListTO();

		opponentToListTO.setId(userEntity.getId());
		opponentToListTO.setLogin(userEntity.getLogin());
		opponentToListTO.setName(userEntity.getName());
		opponentToListTO.setSurname(userEntity.getSurname());

		return opponentToListTO;
	}
}
