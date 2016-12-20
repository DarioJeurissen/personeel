package be.vdab.entities;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import be.vdab.util.HelperClass;

/**
 *
 * @author Dario.Jeurissen
 *
 */

@Entity
@Table(name = "jobtitels")
public class Jobtitel implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@NotNull
	private String naam;
	@Version
	private long versie;
	
	@OneToMany(mappedBy = "jobtitel")
	@Valid
	private List<Werknemer> werknemers;
	
	
	public Jobtitel(){
		
	}
	
	public Jobtitel(String naam) throws IllegalArgumentException{
		this.naam = HelperClass.isStringNotEmpty(naam);
	}
	
	public long getId(){
		return id;
	}
	
	public String getNaam(){
		return naam;
	}
	
	public List<Werknemer> getWerknemers(){
		return Collections.unmodifiableList(werknemers);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((naam == null) ? 0 : naam.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Jobtitel))
			return false;
		Jobtitel other = (Jobtitel) obj;
		if (naam == null) {
			if (other.naam != null)
				return false;
		} else if (!naam.equals(other.naam))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return naam;
	}
	
	
	
}
