package udaan.beone.mrpoint.http.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;

public class MemberSavingAcREST {

	@JsonIgnore
	public static final JSONRepo JSONRepo = new JSONRepo<MemberSavingAcREST>() {
		@Override
		protected Class<MemberSavingAcREST> objectClass() {
			return MemberSavingAcREST.class;
		}
	};

	private long memberSavingAcNo;
	private long memberAc;
	private String accountStatus;
	private String recoveryPeriod;
	private BigDecimal savedAm;
	private BigDecimal intReturnedAm;
	private BigDecimal cumulativeSavedAm;
	private BigDecimal installmentAm;
	private BigDecimal totalIntEnAm;
	private BigDecimal currentFyIntEnAm;
	private BigDecimal prevMonthIntAm;
	private BigDecimal returnedSavedAm;
	private BigDecimal returnedIntEnAm;
	private int expectedNoOfInst;
	private int noOfInstPaid;
	private int noOfInsallLate;
	private int noOfInsallMissed;
	private String requestedDate;
	private String approvedDate;
	private String actualStartDate;
	private String instStartDate;
	private String expCompletionDate;
	private String closureDate;
		
	public MemberSavingAcREST() {
		super();
	}

	public long getMemberSavingAcNo() {
		return memberSavingAcNo;
	}

	public void setMemberSavingAcNo(long memberSavingAcNo) {
		this.memberSavingAcNo = memberSavingAcNo;
	}

	public long getMemberAc() {
		return memberAc;
	}

	public void setMemberAc(long memberAc) {
		this.memberAc = memberAc;
	}

	public String getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}

	public String getRecoveryPeriod() {
		return recoveryPeriod;
	}

	public void setRecoveryPeriod(String recoveryPeriod) {
		this.recoveryPeriod = recoveryPeriod;
	}

	public BigDecimal getSavedAm() {
		return savedAm;
	}

	public void setSavedAm(BigDecimal savedAm) {
		this.savedAm = savedAm;
	}

	public BigDecimal getIntReturnedAm() {
		return intReturnedAm;
	}

	public void setIntReturnedAm(BigDecimal intReturnedAm) {
		this.intReturnedAm = intReturnedAm;
	}

	public BigDecimal getCumulativeSavedAm() {
		return cumulativeSavedAm;
	}

	public void setCumulativeSavedAm(BigDecimal cumulativeSavedAm) {
		this.cumulativeSavedAm = cumulativeSavedAm;
	}

	public BigDecimal getInstallmentAm() {
		return installmentAm;
	}

	public void setInstallmentAm(BigDecimal installmentAm) {
		this.installmentAm = installmentAm;
	}

	public BigDecimal getTotalIntEnAm() {
		return totalIntEnAm;
	}

	public void setTotalIntEnAm(BigDecimal totalIntEnAm) {
		this.totalIntEnAm = totalIntEnAm;
	}

	public BigDecimal getCurrentFyIntEnAm() {
		return currentFyIntEnAm;
	}

	public void setCurrentFyIntEnAm(BigDecimal currentFyIntEnAm) {
		this.currentFyIntEnAm = currentFyIntEnAm;
	}

	public BigDecimal getPrevMonthIntAm() {
		return prevMonthIntAm;
	}

	public void setPrevMonthIntAm(BigDecimal prevMonthIntAm) {
		this.prevMonthIntAm = prevMonthIntAm;
	}

	public BigDecimal getReturnedSavedAm() {
		return returnedSavedAm;
	}

	public void setReturnedSavedAm(BigDecimal returnedSavedAm) {
		this.returnedSavedAm = returnedSavedAm;
	}

	public BigDecimal getReturnedIntEnAm() {
		return returnedIntEnAm;
	}

	public void setReturnedIntEnAm(BigDecimal returnedIntEnAm) {
		this.returnedIntEnAm = returnedIntEnAm;
	}

	public int getExpectedNoOfInst() {
		return expectedNoOfInst;
	}

	public void setExpectedNoOfInst(int expectedNoOfInst) {
		this.expectedNoOfInst = expectedNoOfInst;
	}

	public int getNoOfInstPaid() {
		return noOfInstPaid;
	}

	public void setNoOfInstPaid(int noOfInstPaid) {
		this.noOfInstPaid = noOfInstPaid;
	}

	public int getNoOfInsallLate() {
		return noOfInsallLate;
	}

	public void setNoOfInsallLate(int noOfInsallLate) {
		this.noOfInsallLate = noOfInsallLate;
	}

	public int getNoOfInsallMissed() {
		return noOfInsallMissed;
	}

	public void setNoOfInsallMissed(int noOfInsallMissed) {
		this.noOfInsallMissed = noOfInsallMissed;
	}

	public String getRequestedDate() {
		return requestedDate;
	}

	public void setRequestedDate(String requestedDate) {
		this.requestedDate = requestedDate;
	}

	public String getApprovedDate() {
		return approvedDate;
	}

	public void setApprovedDate(String approvedDate) {
		this.approvedDate = approvedDate;
	}

	public String getActualStartDate() {
		return actualStartDate;
	}

	public void setActualStartDate(String actualStartDate) {
		this.actualStartDate = actualStartDate;
	}

	public String getInstStartDate() {
		return instStartDate;
	}

	public void setInstStartDate(String instStartDate) {
		this.instStartDate = instStartDate;
	}

	public String getExpCompletionDate() {
		return expCompletionDate;
	}

	public void setExpCompletionDate(String expCompletionDate) {
		this.expCompletionDate = expCompletionDate;
	}

	public String getClosureDate() {
		return closureDate;
	}

	public void setClosureDate(String closureDate) {
		this.closureDate = closureDate;
	}
}
