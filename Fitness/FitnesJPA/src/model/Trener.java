package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the trener database table.
 * 
 */
@Entity
@NamedQuery(name="Trener.findAll", query="SELECT t FROM Trener t")
public class Trener implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idtrener;

	private String email;

	private String ime;

	private String password;

	private String prezime;

	//bi-directional many-to-one association to Komentar
	@OneToMany(mappedBy="trener")
	private List<Komentar> komentars;

	//bi-directional many-to-one association to Trening
	@OneToMany(mappedBy="trener")
	private List<Trening> trenings;

	public Trener() {
	}

	public int getIdtrener() {
		return this.idtrener;
	}

	public void setIdtrener(int idtrener) {
		this.idtrener = idtrener;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public List<Komentar> getKomentars() {
		return this.komentars;
	}

	public void setKomentars(List<Komentar> komentars) {
		this.komentars = komentars;
	}

	public Komentar addKomentar(Komentar komentar) {
		getKomentars().add(komentar);
		komentar.setTrener(this);

		return komentar;
	}

	public Komentar removeKomentar(Komentar komentar) {
		getKomentars().remove(komentar);
		komentar.setTrener(null);

		return komentar;
	}

	public List<Trening> getTrenings() {
		return this.trenings;
	}

	public void setTrenings(List<Trening> trenings) {
		this.trenings = trenings;
	}

	public Trening addTrening(Trening trening) {
		getTrenings().add(trening);
		trening.setTrener(this);

		return trening;
	}

	public Trening removeTrening(Trening trening) {
		getTrenings().remove(trening);
		trening.setTrener(null);

		return trening;
	}

}