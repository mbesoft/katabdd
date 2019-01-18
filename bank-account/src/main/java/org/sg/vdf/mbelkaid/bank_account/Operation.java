package org.sg.vdf.mbelkaid.bank_account;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Operation {

	public static final String CELL_FORMAT = "%-12s";
	
	private SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

	private Date date;
	private double amount;

	public Operation(Date date, double amount) {
		this.amount = amount;
		this.date = date;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String printOperation() {
		return "|" + String.format(CELL_FORMAT, amount < 0 ? "WITHDRAWAL" : "DEPOSIT") + "|"
				+ String.format(CELL_FORMAT, sdf.format(date)) + printAmount();
	}

	private String printAmount() {
		String str = String.format("%.2f", Math.abs(amount));
		return "|" + String.format("%-12s", str);

	}

}
