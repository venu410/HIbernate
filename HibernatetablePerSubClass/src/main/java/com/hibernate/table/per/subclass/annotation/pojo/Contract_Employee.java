package com.hibernate.table.per.subclass.annotation.pojo;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "con_Emp2")
@PrimaryKeyJoinColumn(name = "ID")
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
