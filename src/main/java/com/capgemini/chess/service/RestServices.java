package com.capgemini.chess.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.chess.dao.MatchPropositionDAO;
import com.capgemini.chess.dao.UserDAO;
import com.capgemini.chess.service.to.ActualUserIDTO;
import com.capgemini.chess.service.to.OpponentToListTO;

@RestController
@RequestMapping(value = "/rest")
public class RestServices {

	private GetExistingMatchesForPlayerService existingMatches;
	private UserFunctionsService userService;

	@Autowired
	public RestServices(GetExistingMatchesForPlayerService existingMatches, UserFunctionsService userService) {
		this.existingMatches = existingMatches;
		this.userService = userService;
	}

	public RestServices() {
	}

	@RequestMapping(value = "/matches/existing", method = RequestMethod.GET)
	public List<OpponentToListTO> getExistingMatches(@RequestParam("id") Long id) {
		ActualUserIDTO userIDTO = new ActualUserIDTO();
		userIDTO.setId(id);
		List<OpponentToListTO> list = null;
		try {
			list = existingMatches.getExistingMatchesForPlayer(userIDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@RequestMapping(value = "/profile", method = RequestMethod.POST)
	public OpponentToListTO showProfile(@RequestBody ActualUserIDTO userIDTO) {
		OpponentToListTO userProfile = null;
		try {
			userProfile = userService.showPublicProfile(userIDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userProfile;
	}
}
