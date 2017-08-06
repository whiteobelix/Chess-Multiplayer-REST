package com.capgemini.chess.dataaccess.entities;

/**
 * User entity contains all user fields
 * @author PMUNTOWS
 *
 */

public class UserEntity {
	
	private long id;
	private String login;
	private String password;
	private String name;
	private String surname;
	private String email;
	private String aboutMe;
	private String lifeMotto;
	private StatsEntity stats;
	
	public UserEntity(){
	}

	public UserEntity(long id, String login, String name, String surname){
		this.id = id;
		this.login = login;
		this.name = name;
		this.surname = surname;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAboutMe() {
		return aboutMe;
	}

	public void setAboutMe(String aboutMe) {
		this.aboutMe = aboutMe;
	}

	public String getLifeMotto() {
		return lifeMotto;
	}

	public void setLifeMotto(String lifeMotto) {
		this.lifeMotto = lifeMotto;
	}

	public StatsEntity getStats() {
		return stats;
	}

	public void setStats(StatsEntity stats) {
		this.stats = stats;
	}
}
