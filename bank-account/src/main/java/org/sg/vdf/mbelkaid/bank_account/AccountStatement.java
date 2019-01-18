package org.sg.vdf.mbelkaid.bank_account;

import java.util.ArrayList;
import java.util.List;

public class AccountStatement {

	public static final String HEADER = "|Operation   |Date        |Amount      |Balance";

	private List<StatementRow> statement = new ArrayList<StatementRow>();

	public void addRow(Operation operation, double balance) {
		statement.add(new StatementRow(operation, balance));
	}

	public List<StatementRow> getStatement() {
		return statement;
	}

	public void setStatement(List<StatementRow> statement) {
		this.statement = statement;
	}

	public String printHistory() {
		String str = HEADER;
		for (StatementRow statementRow : statement) {
			str = str + "\n" + statementRow.printRow();
		}
		return str;
	}

}
