package com.capgemini.chess.service;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.capgemini.chess.dao.MatchPropositionDAO;
import com.capgemini.chess.dao.UserDAO;
import com.capgemini.chess.service.to.OpponentToListTO;

@RunWith(MockitoJUnitRunner.class)
public class RestServicesTest {

	private MockMvc mockMvc;
	
	@Mock
	private GetExistingMatchesForPlayerService existingMatches;
	
	@Mock 
	private MatchPropositionDAO matchesProposition;
	
	@Mock
	private UserDAO userDAO;
	
	@Autowired
	WebApplicationContext wac;
	
	@Before
	public void setup(){
		Mockito.reset(existingMatches, matchesProposition, userDAO);
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
		
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/templates/");
		viewResolver.setSuffix(".html");
		mockMvc = MockMvcBuilders.standaloneSetup(new RestServices()).setViewResolvers(viewResolver).build();
	}
	
	@Test
	public void testGettingExistingMatches() throws Exception{	
		//given when
		List<OpponentToListTO> listOfMatches = new ArrayList <OpponentToListTO>();
		ResultActions resultActions = mockMvc.perform(get("/rest/matches/existing").param("id", "1"));
				
		//then
		resultActions.andExpect(model().attribute("listOfMatches", listOfMatches));
	}
}
