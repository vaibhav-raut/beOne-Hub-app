package udaan.beone.mrpoint.http.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class LoginRequestREST {

	@JsonIgnore
	public static final JSONRepo JSONRepo = new JSONRepo<LoginRequestREST>() {
		@Override
		protected Class<LoginRequestREST> objectClass() {
			return LoginRequestREST.class;
		}
	};

	private String memberDistrictCode;
	private long groupNo;
	private long memberNo;
	private String groupDistrictCode;
	private long selectedGroupNo;
	private String passcode;
	
	public String getMemberDistrictCode() {
		return memberDistrictCode;
	}
	public void setMemberDistrictCode(String memberDistrictCode) {
		this.memberDistrictCode = memberDistrictCode;
	}
	public long getGroupNo() {
		return groupNo;
	}
	public void setGroupNo(long groupNo) {
		this.groupNo = groupNo;
	}
	public long getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(long memberNo) {
		this.memberNo = memberNo;
	}
	public String getGroupDistrictCode() {
		return groupDistrictCode;
	}
	public void setGroupDistrictCode(String groupDistrictCode) {
		this.groupDistrictCode = groupDistrictCode;
	}
	public long getSelectedGroupNo() {
		return selectedGroupNo;
	}
	public void setSelectedGroupNo(long selectedGroupNo) {
		this.selectedGroupNo = selectedGroupNo;
	}
	public String getPasscode() {
		return passcode;
	}
	public void setPasscode(String passcode) {
		this.passcode = passcode;
	}
}
