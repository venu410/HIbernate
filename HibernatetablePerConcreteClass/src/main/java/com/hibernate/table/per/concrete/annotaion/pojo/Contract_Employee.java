package com.hibernate.table.per.concrete.annotaion.pojo;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Con_Emp")
@AttributeOverrides({
	@AttributeOverride(name = "id",column = @Column(name="id")),
	@AttributeOverride(name = "name",column = @Column(name="name"))
})
public class Contract_Employee extends Employee {

	private int pay_per_hour;
	private String contract_period;

	public int getPay_per_hour() {
		return pay_per_hour;
	}

	public void setPay_per_hour(int pay_per_hour) {
		this.pay_per_hour = pay_per_hour;
	}

	public String getContract_period() {
		return contract_period;
	}

	public void setContract_period(String contract_period) {
		this.contract_period = contract_period;
	}

}
