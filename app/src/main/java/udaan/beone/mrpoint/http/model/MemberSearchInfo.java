package udaan.beone.mrpoint.http.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public class MemberSearchInfo {

	@JsonIgnore
	public static final JSONRepo JSONRepo = new JSONRepo<MemberSearchInfo>() {
		@Override
		protected Class<MemberSearchInfo> objectClass() {
			return MemberSearchInfo.class;
		}
	};

	private long groupAcNo;
	private List<MemberName> memberNames;
	private List<BankAccountShort> groupBankAcNos;

	public long getGroupAcNo() {
		return groupAcNo;
	}

	public void setGroupAcNo(long groupAcNo) {
		this.groupAcNo = groupAcNo;
	}

	public List<MemberName> getMemberNames() {
		return memberNames;
	}

	public void setMemberNames(List<MemberName> memberNames) {
		this.memberNames = memberNames;
	}

	public List<BankAccountShort> getGroupBankAcNos() {
		return groupBankAcNos;
	}

	public void setGroupBankAcNos(List<BankAccountShort> groupBankAcNos) {
		this.groupBankAcNos = groupBankAcNos;
	}
}
