package ar.edu.unaj.app.spotify.login.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usertoken", schema = "test")
public class UserToken {
	@Id
	private String id;
	private String token;
	private Date highDate;
	
	public UserToken(String id, String token, Date highDate) {
		this.id = id;
		this.token = token;
		this.highDate = highDate;
	}

	public UserToken() {
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Date getHighDate() {
		return highDate;
	}

	public void setHighDate(Date highDate) {
		this.highDate = highDate;
	}


}
