package org.sg.vdf.mbelkaid.bank_account;

import java.util.Date;

public class BankClientAccount {

	private double balance;

	private AccountStatement accountStatement;

	public BankClientAccount(AccountStatement accountStatement) {
		this.accountStatement = accountStatement;
	}

	public void withdrawal(double value, Date date) {
		processOperation(0 - value, date);
	}

	public void deposit(double value, Date date) {
		processOperation(value, date);
	}

	public String printHistory() {
		return accountStatement.printHistory();
	}

	private void processOperation(double value, Date date) {
		Operation operation = new Operation(date, value);
		double balanceUpdated = balance + value;
		balance = balanceUpdated;
		accountStatement.addRow(operation, balanceUpdated);
	}

	public AccountStatement getAccountStatement() {
		return accountStatement;
	}

	public void setAccountStatement(AccountStatement accountStatement) {
		this.accountStatement = accountStatement;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

//	public static void main(String[] args) {
//		BankClientAccount a = new BankClientAccount(new AccountStatement());
//		a.deposit(1000, new Date());
//		a.withdrawal(90, new Date());
//		System.out.println(a.printHistory());
//	}

}
