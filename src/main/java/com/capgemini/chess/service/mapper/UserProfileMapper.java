package com.capgemini.chess.service.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.capgemini.chess.dataaccess.entities.UserEntity;
import com.capgemini.chess.service.to.UserProfileTO;

/**
 * Mapper gives userProfileTO including password and email
 * 
 * @author PMUNTOWS
 *
 */
public class UserProfileMapper {

	public static UserProfileTO map(UserEntity userEntity) {
		if (userEntity != null) {
			UserProfileTO userProfileTO = new UserProfileTO();
			userProfileTO.setAboutMe(userEntity.getAboutMe());
			userProfileTO.setEmail(userEntity.getEmail());
			userProfileTO.setId(userEntity.getId());
			userProfileTO.setLifeMotto(userEntity.getLifeMotto());
			userProfileTO.setLogin(userEntity.getLogin());
			userProfileTO.setName(userEntity.getName());
			userProfileTO.setPassword(userEntity.getPassword());
			userProfileTO.setSurname(userEntity.getSurname());
			return userProfileTO;
		}
		return null;
	}

	public static UserEntity map(UserProfileTO userTO) {
		if (userTO != null) {
			UserEntity userEntity = new UserEntity();
			userEntity.setAboutMe(userTO.getAboutMe());
			userEntity.setEmail(userTO.getEmail());
			userEntity.setId(userTO.getId());
			userEntity.setLifeMotto(userTO.getLifeMotto());
			userEntity.setLogin(userTO.getLogin());
			userEntity.setName(userTO.getName());
			userEntity.setPassword(userTO.getPassword());
			userEntity.setSurname(userTO.getSurname());
			return userEntity;
		}
		return null;
	}

	public static UserEntity update(UserEntity userEntity, UserProfileTO userTO) {
		if (userTO != null && userEntity != null) {
			userEntity.setAboutMe(userTO.getAboutMe());
			userEntity.setEmail(userTO.getEmail());
			userEntity.setId(userTO.getId());
			userEntity.setLifeMotto(userTO.getLifeMotto());
			userEntity.setName(userTO.getName());
			userEntity.setPassword(userTO.getPassword());
			userEntity.setSurname(userTO.getSurname());
		}
		return userEntity;
	}

	public static List<UserProfileTO> map2TOs(List<UserEntity> userEntities) {
		return userEntities.stream().map(UserProfileMapper::map).collect(Collectors.toList());
	}

	public static List<UserEntity> map2Entities(List<UserProfileTO> userTOs) {
		return userTOs.stream().map(UserProfileMapper::map).collect(Collectors.toList());
	}
}
