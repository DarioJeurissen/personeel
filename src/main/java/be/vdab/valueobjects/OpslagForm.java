package be.vdab.valueobjects;

import java.math.BigDecimal;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

public class OpslagForm {
	@NotNull
	@DecimalMin("1")
	private BigDecimal bonus;

	public OpslagForm(){
	}
	
	public void setBonus(BigDecimal bonus){
		this.bonus = bonus;
	}
	
	public BigDecimal getBonus() {
		return bonus;
	}
	public void addToSalaris(BigDecimal bonus) {
		this.bonus.add(bonus);
	}
	
}
