package com.capgemini.chess.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.capgemini.chess.dataaccess.entities.UserEntity;

public class Users {

	private static List<UserEntity> users = new ArrayList<>(
			Arrays.asList(new UserEntity(1L, "marekN", "marek", "Nocny"), new UserEntity(2L, "annaA", "Anna", "Anucka"),
					new UserEntity(3L, "rafałR", "Rafał", "Rudawy"), new UserEntity(4L, "jurekK", "Jurek", "Kapusta"),
					new UserEntity(5L, "kotBury", "Andrzej", "Jaki"), new UserEntity(6L, "marianJ", "Marin", "Junak")));

	public static List<UserEntity> getUsers() {
		return users;
	}

	public static void setUsers(List<UserEntity> users) {
		Users.users = users;
	}
}
