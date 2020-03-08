package udaan.beone.mrpoint.http.model;

public class BankAccountShort {

	private long bankAcNo;
	private long bankGroupAcNo;
	private String displayAccount;
	private String bankAccountType;

	public long getBankAcNo() {
		return bankAcNo;
	}

	public void setBankAcNo(long bankAcNo) {
		this.bankAcNo = bankAcNo;
	}

	public long getBankGroupAcNo() {
		return bankGroupAcNo;
	}

	public void setBankGroupAcNo(long bankGroupAcNo) {
		this.bankGroupAcNo = bankGroupAcNo;
	}

	public String getDisplayAccount() {
		return displayAccount;
	}

	public void setDisplayAccount(String displayAccount) {
		this.displayAccount = displayAccount;
	}

	public String getBankAccountType() {
		return bankAccountType;
	}

	public void setBankAccountType(String bankAccountType) {
		this.bankAccountType = bankAccountType;
	}
}
