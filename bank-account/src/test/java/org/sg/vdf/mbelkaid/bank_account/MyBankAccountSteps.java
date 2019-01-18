package org.sg.vdf.mbelkaid.bank_account;

import java.util.Date;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MyBankAccountSteps {

	private BankClientAccount bca;

	//According to cucumber doc, this Scenario seems to be an anti-pattern ?
	//TODO According to my understanding, may be, it should have more precisions ?
	@Given("^a bank client$")
	public void a_bank_client() throws Throwable {
		bca = new BankClientAccount(new AccountStatement());
	}

	@When("^I want to make a deposit in my account$")
	public void want_to_make_a_deposit_in_my_account() throws Throwable {
		bca.deposit(1000, new Date());
	}

	@Then("^save money$")
	public void save_money() throws Throwable {
		Assert.assertTrue(bca.getBalance() == 1000);
	}
	
	@Given("^I am a bank client$")
	public void the_same_bank_client() throws Throwable {
		bca = new BankClientAccount(new AccountStatement());
		bca.setBalance(1000);//Need it to test US2
	}

	@When("^I want to make a withdrawal from my account$")
	public void want_to_make_a_withdrawal_from_my_account() throws Throwable {
		bca.withdrawal(90, new Date());
	}

	@Then("^retrieve some or all of my savings$")
	public void retrieve_some_or_all_of_my_savings() throws Throwable {
		Assert.assertTrue(bca.getBalance() == 910);
	}

	@Given("^The same bank client$")
	public void bank_client() throws Throwable {
		bca = new BankClientAccount(new AccountStatement());
	}

	@When("^I check my operations$")
	public void check_my_operations() throws Throwable {
		bca.deposit(1000, new Date());
		bca.withdrawal(90, new Date());
	}

	@Then("^I see the history$")
	public void see_the_history() throws Throwable {
		String expected = "|Operation   |Date        |Amount      |Balance\n" + 
					      "|DEPOSIT     |18-01-2019  |1000,00     |1000,00\n" + 
					      "|WITHDRAWAL  |18-01-2019  |90,00       |910,00";
		Assert.assertEquals(expected,bca.printHistory());
	}

}
