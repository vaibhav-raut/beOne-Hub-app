package udaan.beone.mrpoint.http.model;

import java.util.List;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;


@JsonSerialize
public class MemberName {

	private long memberAcNo;
	private long groupAcNo;
	private String memberName;
	private String mrole;
	private String status;
	private List<BankAccountShort> memberBankAcNos;

	public long getMemberAcNo() {
		return memberAcNo;
	}

	public void setMemberAcNo(long memberAcNo) {
		this.memberAcNo = memberAcNo;
	}

	public long getGroupAcNo() {
		return groupAcNo;
	}

	public void setGroupAcNo(long groupAcNo) {
		this.groupAcNo = groupAcNo;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMrole() {
		return mrole;
	}

	public void setMrole(String mrole) {
		this.mrole = mrole;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<BankAccountShort> getMemberBankAcNos() {
		return memberBankAcNos;
	}

	public void setMemberBankAcNos(List<BankAccountShort> memberBankAcNos) {
		this.memberBankAcNos = memberBankAcNos;
	}
}
