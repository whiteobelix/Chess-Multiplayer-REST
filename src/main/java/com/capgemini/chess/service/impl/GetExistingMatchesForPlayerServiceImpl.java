package com.capgemini.chess.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.chess.dao.ExistingMatchDAO;
import com.capgemini.chess.dao.UserDAO;
import com.capgemini.chess.service.GetExistingMatchesForPlayerService;
import com.capgemini.chess.service.to.ActualUserIDTO;
import com.capgemini.chess.service.to.OpponentToListTO;

/**
 * 
 * @author Pawel Muntowski
 *
 */

@Service
public class GetExistingMatchesForPlayerServiceImpl implements GetExistingMatchesForPlayerService {

	private ExistingMatchDAO existingMatches;
	private UserDAO userDAO;

	@Autowired
	public GetExistingMatchesForPlayerServiceImpl(ExistingMatchDAO existingMatches, UserDAO userDAO) {
		this.existingMatches = existingMatches;
		this.userDAO = userDAO;
	}

	/**
	 * Method for providing existing matches for actual user.
	 */
	@Override
	public List<OpponentToListTO> getExistingMatchesForPlayer(ActualUserIDTO actualUser) {
		List<Long> usersID = null;
		try {
			usersID = existingMatches.getIDOfOpponentFromMyMatch(actualUser.getId());
		} catch (NullPointerException n) {
			n.printStackTrace();
		} catch (IndexOutOfBoundsException i) {
			i.printStackTrace();
		}

		try {
			usersID.addAll(existingMatches.getIDOfCreatorFromOpponentMatch(actualUser.getId()));
		} catch (NullPointerException n) {
			n.printStackTrace();
		} catch (IndexOutOfBoundsException i) {
			i.printStackTrace();
		}

		return userDAO.playerTOByID(usersID);
	}

}
