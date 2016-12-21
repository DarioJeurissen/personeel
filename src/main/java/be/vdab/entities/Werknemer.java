package be.vdab.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.Valid;

import org.hibernate.validator.constraints.Email;

import com.sun.istack.NotNull;

import be.vdab.util.HelperClass;

/**
 *
 * @author Dario.Jeurissen
 *
 */

@Entity
@Table(name="werknemers")
public class Werknemer implements Serializable{
	private static final long serialVersionUID=1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) //Changed from Identity to auto, to avoid error that made chefid not able to be null
	private long id;
	private String familienaam;
	private String voornaam;
	@Email
	private String email;
	private BigDecimal salaris;
	@Version
	private long versie;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "chefid")
	@Valid
	private Werknemer chef;
	@OneToMany(mappedBy = "chef")
	@Valid
	private List<Werknemer> ondergeschikten;
	
	@Valid
	@ManyToOne(fetch = FetchType.LAZY, optional=false)
	@JoinColumn(name = "jobtitelid")
	private Jobtitel jobtitel;
	
	protected Werknemer(){
		
	}
	
	public Werknemer(String vnaam, String fnaam, String email, BigDecimal salaris) throws IllegalArgumentException{
		this.voornaam = HelperClass.isStringNotEmpty(vnaam, "Voornaam mag niet leeg zijn.");
		this.familienaam = HelperClass.isStringNotEmpty(fnaam, "Familienaam mag niet leeg zijn.");
		this.email = HelperClass.isValidEmail(email, "Email moet correct zijn. (formaat: email@domain.com");
		this.salaris = HelperClass.isBigDecimalNotNegative(salaris, "Salaris moet positief zijn.");
	}
	
	public Werknemer(String vnaam, String fnaam, String email, BigDecimal salaris, @Valid Jobtitel jobtitel) throws IllegalArgumentException{
		this(vnaam, fnaam, email, salaris);
		this.jobtitel = Objects.requireNonNull(jobtitel);
	}

	public long getId() {
		return id;
	}

	public String getFamilienaam() {
		return familienaam;
	}

	public String getVoornaam() {
		return voornaam;
	}

	public String getEmail() {
		return email;
	}

	public BigDecimal getSalaris() {
		return salaris;
	}

	public Werknemer getChef() {
		return chef;
	}

	public List<Werknemer> getOndergeschikten() {
		return Collections.unmodifiableList(ondergeschikten);
	}
	
	public Jobtitel getJobtitel(){
		return jobtitel;
	}
	
	public String getNaam(){
		return voornaam + " " + familienaam;
	}
	
	public void addSalaris(BigDecimal addToSalaris) throws IllegalArgumentException, NullPointerException{
		Objects.requireNonNull(addToSalaris);
		HelperClass.isBigDecimalBiggerThan(addToSalaris, BigDecimal.ONE);
		this.salaris = this.salaris.add(addToSalaris);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((familienaam == null) ? 0 : familienaam.hashCode());
		result = prime * result + ((voornaam == null) ? 0 : voornaam.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Werknemer))
			return false;
		Werknemer other = (Werknemer) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (familienaam == null) {
			if (other.familienaam != null)
				return false;
		} else if (!familienaam.equals(other.familienaam))
			return false;
		if (voornaam == null) {
			if (other.voornaam != null)
				return false;
		} else if (!voornaam.equals(other.voornaam))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return voornaam + " " + familienaam;
	}
}
