package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the radnik database table.
 * 
 */
@Entity
@NamedQuery(name="Radnik.findAll", query="SELECT r FROM Radnik r")
public class Radnik implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idradnik;

	private String ime;

	private String password;

	private String prezime;

	private String username;

	public Radnik() {
	}

	public int getIdradnik() {
		return this.idradnik;
	}

	public void setIdradnik(int idradnik) {
		this.idradnik = idradnik;
	}

	public String getIme() {
		return this.ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPrezime() {
		return this.prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}