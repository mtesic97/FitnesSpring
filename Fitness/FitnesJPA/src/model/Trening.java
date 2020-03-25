package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the trening database table.
 * 
 */
@Entity
@NamedQuery(name="Trening.findAll", query="SELECT t FROM Trening t")
public class Trening implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idtrening;

	private String datumTreninga;

	private String vremeTreninga;

	//bi-directional many-to-one association to Clan
	@ManyToOne
	@JoinColumn(name="idClana")
	private Clan clan;

	//bi-directional many-to-one association to Trener
	@ManyToOne
	@JoinColumn(name="idTrenera")
	private Trener trener;

	public Trening() {
	}

	public int getIdtrening() {
		return this.idtrening;
	}

	public void setIdtrening(int idtrening) {
		this.idtrening = idtrening;
	}

	public String getDatumTreninga() {
		return this.datumTreninga;
	}

	public void setDatumTreninga(String datumTreninga) {
		this.datumTreninga = datumTreninga;
	}

	public String getVremeTreninga() {
		return this.vremeTreninga;
	}

	public void setVremeTreninga(String vremeTreninga) {
		this.vremeTreninga = vremeTreninga;
	}

	public Clan getClan() {
		return this.clan;
	}

	public void setClan(Clan clan) {
		this.clan = clan;
	}

	public Trener getTrener() {
		return this.trener;
	}

	public void setTrener(Trener trener) {
		this.trener = trener;
	}

}