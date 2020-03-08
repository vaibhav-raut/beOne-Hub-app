package udaan.beone.mrpoint.http.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class MemberREST {

	@JsonIgnore
	public static final JSONRepo JSONRepo = new JSONRepo<MemberREST>() {
		@Override
		protected Class<MemberREST> objectClass() {
			return MemberREST.class;
		}
	};

	private long memberAcNo;
	private long parentGroupAcNo;
	private List<Long> mappingGroupAcNos;
	private long recommendedByMemberAcNo;
	private long approvedByMemberAcNo;
	private String memberName;
	private String displayAddress;
	private String recommendedByMemberName;
	private String approvedByMemberName;
	private String approvalStatus;
	private String activeStatus;
	private String mrole;
	private String roleCategory;
	private String passcode;
	private byte passSet;
	private String gender;
	private Float percentageProfileComplete;
	private String uidaiNo;
	private String panCardNo;
	private String voterIdNo;
	private String drivingLicenseNo;
	private String photoUrl;
	private String statusMessage;
	private String location;
	private String dateOfEnroll;
	private String dateOfBirth;
	private String dateOfAnni;
	private String dateOfClosure;
	private BigDecimal monthlySaving;
	private int noPlannedSavingInst;
	private String errorMessages;
	private long lastLoggedInTs;
	@JsonIgnore
	private MemberAcREST account;
	private MMessageREST mmessage;
	private List<Attachment> attachments;
	private List<MemberContactREST> contacts;
	private List<BankAccountREST> bankAccounts;
	@JsonIgnore
	private List<MemberSavingAcREST> memberSavingAc;
	@JsonIgnore
	private List<MemberLoanAcREST> memberLoanAc;
	@JsonIgnore
	private MemberOtherAcInfo memberOtherAcInfo;
	@JsonIgnore
	private List<Transaction> transactions;
	private Map<String, String> displayNames;

	public long getMemberAcNo() {
		return memberAcNo;
	}
	public void setMemberAcNo(long memberAcNos) {
		this.memberAcNo = memberAcNos;
	}
	public long getParentGroupAcNo() {
		return parentGroupAcNo;
	}
	public void setParentGroupAcNo(long parentGroupAcNo) {
		this.parentGroupAcNo = parentGroupAcNo;
	}
	public List<Long> getMappingGroupAcNos() {
		return mappingGroupAcNos;
	}
	public void setMappingGroupAcNos(List<Long> mappingGroupAcNos) {
		this.mappingGroupAcNos = mappingGroupAcNos;
	}
	public void addMappingGroupAcNo(Long mappingGroupAcNo) {
		if(this.mappingGroupAcNos == null) {
			this.mappingGroupAcNos = new ArrayList<Long>();
		}
		this.mappingGroupAcNos.add(mappingGroupAcNo);
	}
	public long getRecommendedByMemberAcNo() {
		return recommendedByMemberAcNo;
	}
	public void setRecommendedByMemberAcNo(long recommendedByMemberAcNo) {
		this.recommendedByMemberAcNo = recommendedByMemberAcNo;
	}
	public long getApprovedByMemberAcNo() {
		return approvedByMemberAcNo;
	}
	public void setApprovedByMemberAcNo(long approvedByMemberAcNo) {
		this.approvedByMemberAcNo = approvedByMemberAcNo;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getDisplayAddress() {
		return displayAddress;
	}

	public void setDisplayAddress(String displayAddress) {
		this.displayAddress = displayAddress;
	}

	public String getRecommendedByMemberName() {
		return recommendedByMemberName;
	}
	public void setRecommendedByMemberName(String recommendedByMemberName) {
		this.recommendedByMemberName = recommendedByMemberName;
	}
	public String getApprovedByMemberName() {
		return approvedByMemberName;
	}
	public void setApprovedByMemberName(String approvedByMemberName) {
		this.approvedByMemberName = approvedByMemberName;
	}
	public String getApprovalStatus() {
		return approvalStatus;
	}
	public void setApprovalStatus(String approvalStatus) {
		this.approvalStatus = approvalStatus;
	}
	public String getActiveStatus() {
		return activeStatus;
	}
	public void setActiveStatus(String activeStatus) {
		this.activeStatus = activeStatus;
	}
	public String getMrole() {
		return mrole;
	}
	public void setMrole(String mrole) {
		this.mrole = mrole;
	}
	public String getRoleCategory() {
		return roleCategory;
	}
	public void setRoleCategory(String roleCategory) {
		this.roleCategory = roleCategory;
	}
	public String getPasscode() {
		return passcode;
	}
	public void setPasscode(String passcode) {
		this.passcode = passcode;
	}
	public byte getPassSet() {
		return passSet;
	}
	public void setPassSet(byte passSet) {
		this.passSet = passSet;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Float getPercentageProfileComplete() {
		return percentageProfileComplete;
	}
	public void setPercentageProfileComplete(Float percentageProfileComplete) {
		this.percentageProfileComplete = percentageProfileComplete;
	}
	public String getPhotoUrl() {
		return photoUrl;
	}
	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}
	public String getStatusMessage() {
		return statusMessage;
	}
	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getUidaiNo() {
		return uidaiNo;
	}
	public void setUidaiNo(String uidaiNo) {
		this.uidaiNo = uidaiNo;
	}
	public String getPanCardNo() {
		return panCardNo;
	}
	public void setPanCardNo(String panCardNo) {
		this.panCardNo = panCardNo;
	}
	public String getVoterIdNo() {
		return voterIdNo;
	}
	public void setVoterIdNo(String voterIdNo) {
		this.voterIdNo = voterIdNo;
	}
	public String getDrivingLicenseNo() {
		return drivingLicenseNo;
	}
	public void setDrivingLicenseNo(String drivingLicenseNo) {
		this.drivingLicenseNo = drivingLicenseNo;
	}
	public String getDateOfEnroll() {
		return dateOfEnroll;
	}
	public void setDateOfEnroll(String dateOfEnroll) {
		this.dateOfEnroll = dateOfEnroll;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getDateOfAnni() {
		return dateOfAnni;
	}
	public void setDateOfAnni(String dateOfAnni) {
		this.dateOfAnni = dateOfAnni;
	}
	public String getDateOfClosure() {
		return dateOfClosure;
	}
	public void setDateOfClosure(String dateOfClosure) {
		this.dateOfClosure = dateOfClosure;
	}
	public BigDecimal getMonthlySaving() {
		return monthlySaving;
	}
	public void setMonthlySaving(BigDecimal monthlySaving) {
		this.monthlySaving = monthlySaving;
	}
	public int getNoPlannedSavingInst() {
		return noPlannedSavingInst;
	}
	public void setNoPlannedSavingInst(int noPlannedSavingInst) {
		this.noPlannedSavingInst = noPlannedSavingInst;
	}
	public String getErrorMessages() {
		return errorMessages;
	}
	public void setErrorMessages(String errorMessages) {
		this.errorMessages = errorMessages;
	}
	public long getLastLoggedInTs() {
		return lastLoggedInTs;
	}
	public void setLastLoggedInTs(long lastLoggedInTs) {
		this.lastLoggedInTs = lastLoggedInTs;
	}
	public MMessageREST getMmessage() {
		return mmessage;
	}
	public void setMmessage(MMessageREST mmessage) {
		this.mmessage = mmessage;
	}
	public List<Attachment> getAttachments() {
		return attachments;
	}
	public void setAttachments(List<Attachment> attachments) {
		this.attachments = attachments;
	}
	public void addAttachment(Attachment attachment) {
		if(this.attachments == null) {
			this.attachments = new ArrayList<Attachment>();
		}
		this.attachments.add(attachment);
	}
	public List<MemberContactREST> getContacts() {
		return contacts;
	}
	public void setContacts(List<MemberContactREST> contacts) {
		this.contacts = contacts;
	}
	public void addContact(MemberContactREST contact) {
		if(this.contacts == null) {
			this.contacts = new ArrayList<MemberContactREST>();
		}
		this.contacts.add(contact);
	}
	public List<BankAccountREST> getBankAccounts() {
		return bankAccounts;
	}
	public void setBankAccounts(List<BankAccountREST> bankAccounts) {
		this.bankAccounts = bankAccounts;
	}
	public void addBankAccount(BankAccountREST bankAccount) {
		if(this.bankAccounts == null) {
			this.bankAccounts = new ArrayList<BankAccountREST>();
		}
		this.bankAccounts.add(bankAccount);
	}	

	public Map<String, String> getDisplayNames() {
		return displayNames;
	}
	public void setDisplayNames(Map<String, String> displayNames) {
		this.displayNames = displayNames;
	}

	public MemberAcREST getAccount() {
		return account;
	}

	public void setAccount(MemberAcREST account) {
		this.account = account;
	}

	public List<MemberSavingAcREST> getMemberSavingAc() {
		return memberSavingAc;
	}

	public void setMemberSavingAc(List<MemberSavingAcREST> memberSavingAc) {
		this.memberSavingAc = memberSavingAc;
	}

	public List<MemberLoanAcREST> getMemberLoanAc() {
		return memberLoanAc;
	}

	public void setMemberLoanAc(List<MemberLoanAcREST> memberLoanAc) {
		this.memberLoanAc = memberLoanAc;
	}

	public MemberOtherAcInfo getMemberOtherAcInfo() {
		return memberOtherAcInfo;
	}

	public void setMemberOtherAcInfo(MemberOtherAcInfo memberOtherAcInfo) {
		this.memberOtherAcInfo = memberOtherAcInfo;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	public Map<String,String> toStringInfo() {

		Map<String,String> memberInfo = new HashMap<String,String>();
		memberInfo.put("memberAcNo", Long.toString(memberAcNo));
		memberInfo.put("name", contacts.get(0).getNameTitle() + " " + contacts.get(0).getFirstName() + " " + contacts.get(0).getLastName());
		memberInfo.put("activeStatus", activeStatus);
		memberInfo.put("mrole", mrole);
		memberInfo.put("password", passcode);

		return memberInfo;
	}
}
