package org.sg.vdf.mbelkaid.bank_account;

public class StatementRow {

	private Double balance;
	private Operation operation;

	public StatementRow(Operation operation, Double balance) {
		this.balance = balance;
		this.operation = operation;
	}

	public Operation getOperation() {
		return operation;
	}

	public void setOperation(Operation operation) {
		this.operation = operation;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public String printRow() {
		return  operation.printOperation() + "|" + String.format("%.2f", balance);
	}

}
