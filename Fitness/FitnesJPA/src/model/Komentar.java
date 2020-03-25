package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the komentar database table.
 * 
 */
@Entity
@NamedQuery(name="Komentar.findAll", query="SELECT k FROM Komentar k")
public class Komentar implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idkomentar;

	private String tekst;

	//bi-directional many-to-one association to Clan
	@ManyToOne
	@JoinColumn(name="idClan")
	private Clan clan;

	//bi-directional many-to-one association to Trener
	@ManyToOne
	@JoinColumn(name="idTrener")
	private Trener trener;

	public Komentar() {
	}

	public int getIdkomentar() {
		return this.idkomentar;
	}

	public void setIdkomentar(int idkomentar) {
		this.idkomentar = idkomentar;
	}

	public String getTekst() {
		return this.tekst;
	}

	public void setTekst(String tekst) {
		this.tekst = tekst;
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