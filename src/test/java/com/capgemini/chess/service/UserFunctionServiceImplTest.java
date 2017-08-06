package com.capgemini.chess.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.capgemini.chess.dao.UserDAO;
import com.capgemini.chess.service.to.ActualUserIDTO;
import com.capgemini.chess.service.to.OpponentToListTO;

@RunWith(MockitoJUnitRunner.class)
public class UserFunctionServiceImplTest {

	@Mock
	UserDAO userDao;

	@Test
	public void testReadUserSuccessful() throws Exception {
		// given
		OpponentToListTO oneUser = new OpponentToListTO();

		oneUser.setId(1L);
		oneUser.setName("Capitan");
		ActualUserIDTO userIDTO = new ActualUserIDTO();
		userIDTO.setId(1L);

		// when
		when(userDao.showPublicProfile(userIDTO)).thenReturn(oneUser);

		// then
		assertNotNull(oneUser);
		assertEquals("Capitan", oneUser.getName());
		assertEquals(1, (int) (long) oneUser.getId());
	}

}
