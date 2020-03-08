package udaan.beone.mrpoint.http.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MemberLoanAcREST {

	@JsonIgnore
	public static final JSONRepo JSONRepo = new JSONRepo<MemberLoanAcREST>() {
		@Override
		protected Class<MemberLoanAcREST> objectClass() {
			return MemberLoanAcREST.class;
		}
	};

	private long memberLoanAcNo;
	private long memberAcNo;
	private String loanType;
	private String loanCalculation;
	private String accountStatus;
	private String recoveryPeriod;
	private String loanSource;
	private long approvedByMember;
	private String mrole;
	private String memberName;
	private String approvedByMemberName;
	private BigDecimal principle;
	private BigDecimal pendingPrinciple;
	private BigDecimal recoveredInterest;
	private BigDecimal projectedInterest;
	private BigDecimal installment;
	private BigDecimal preEmiInterest;
	private BigDecimal pendingInterestDue;
	private float rateOfInterest;
	private int startupNoOfInst;
	private int expNoOfInst;
	private int noOfInstPaid;
	private int noOfInsallLate;
	private int noOfInsallMissed;
	private String requestedDate;
	private String approvedDate;
	private String disbursementDate;
	private String instStartDate;
	private String expCompletionDate;
	private String closureDate;
	private String developmentPlan;
	private String statusMessage;
	private List<Attachment> attachments;
	private Set<Long> multiMToLoanAcs = new HashSet<Long>(0);
	private MemberAcREST memberAc;
	List<Transaction> transactions;
	
	public long getMemberLoanAcNo() {
		return memberLoanAcNo;
	}
	public void setMemberLoanAcNo(long memberLoanAcNo) {
		this.memberLoanAcNo = memberLoanAcNo;
	}
	public long getMemberAcNo() {
		return memberAcNo;
	}
	public void setMemberAcNo(long memberAcNo) {
		this.memberAcNo = memberAcNo;
	}
	public String getLoanType() {
		return loanType;
	}
	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}
	public String getLoanCalculation() {
		return loanCalculation;
	}
	public void setLoanCalculation(String loanCalculation) {
		this.loanCalculation = loanCalculation;
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
	public String getLoanSource() {
		return loanSource;
	}
	public void setLoanSource(String loanSource) {
		this.loanSource = loanSource;
	}
	public long getApprovedByMember() {
		return approvedByMember;
	}
	public void setApprovedByMember(long approvedByMember) {
		this.approvedByMember = approvedByMember;
	}
	public String getMrole() {
		return mrole;
	}
	public void setMrole(String mrole) {
		this.mrole = mrole;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getApprovedByMemberName() {
		return approvedByMemberName;
	}
	public void setApprovedByMemberName(String approvedByMemberName) {
		this.approvedByMemberName = approvedByMemberName;
	}
	public BigDecimal getPrinciple() {
		return principle;
	}
	public void setPrinciple(BigDecimal principle) {
		this.principle = principle;
	}
	public BigDecimal getPendingPrinciple() {
		return pendingPrinciple;
	}
	public void setPendingPrinciple(BigDecimal pendingPrinciple) {
		this.pendingPrinciple = pendingPrinciple;
	}
	public BigDecimal getRecoveredInterest() {
		return recoveredInterest;
	}
	public void setRecoveredInterest(BigDecimal recoveredInterest) {
		this.recoveredInterest = recoveredInterest;
	}
	public BigDecimal getProjectedInterest() {
		return projectedInterest;
	}
	public void setProjectedInterest(BigDecimal projectedInterest) {
		this.projectedInterest = projectedInterest;
	}
	public BigDecimal getInstallment() {
		return installment;
	}
	public void setInstallment(BigDecimal installment) {
		this.installment = installment;
	}
	public BigDecimal getPreEmiInterest() {
		return preEmiInterest;
	}
	public void setPreEmiInterest(BigDecimal preEmiInterest) {
		this.preEmiInterest = preEmiInterest;
	}
	public BigDecimal getPendingInterestDue() {
		return pendingInterestDue;
	}
	public void setPendingInterestDue(BigDecimal pendingInterestDue) {
		this.pendingInterestDue = pendingInterestDue;
	}
	public float getRateOfInterest() {
		return rateOfInterest;
	}
	public void setRateOfInterest(float rateOfInterest) {
		this.rateOfInterest = rateOfInterest;
	}
	public int getStartupNoOfInst() {
		return startupNoOfInst;
	}
	public void setStartupNoOfInst(int startupNoOfInst) {
		this.startupNoOfInst = startupNoOfInst;
	}
	public int getExpNoOfInst() {
		return expNoOfInst;
	}
	public void setExpNoOfInst(int expNoOfInst) {
		this.expNoOfInst = expNoOfInst;
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
	public String getDisbursementDate() {
		return disbursementDate;
	}
	public void setDisbursementDate(String disbursementDate) {
		this.disbursementDate = disbursementDate;
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
	public String getDevelopmentPlan() {
		return developmentPlan;
	}
	public void setDevelopmentPlan(String developmentPlan) {
		this.developmentPlan = developmentPlan;
	}
	public String getStatusMessage() {
		return statusMessage;
	}
	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
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
	public Set<Long> getMultiMToLoanAcs() {
		return multiMToLoanAcs;
	}
	public void setMultiMToLoanAcs(Set<Long> multiMToLoanAcs) {
		this.multiMToLoanAcs = multiMToLoanAcs;
	}

	public MemberAcREST getMemberAc() {
		return memberAc;
	}
	public void setMemberAc(MemberAcREST memberAc) {
		this.memberAc = memberAc;
	}
	public List<Transaction> getTransactions() {
		return transactions;
	}
	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}
	public void addTransaction(Transaction transaction) {
		if(transactions == null) {
			transactions = new ArrayList<Transaction>();
		}
		this.transactions.add(transaction);
	}
}
