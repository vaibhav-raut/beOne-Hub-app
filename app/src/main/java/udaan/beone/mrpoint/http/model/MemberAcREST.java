package udaan.beone.mrpoint.http.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;
import java.util.Date;

public class MemberAcREST {

	@JsonIgnore
	public static final JSONRepo JSONRepo = new JSONRepo<MemberAcREST>() {
		@Override
		protected Class<MemberAcREST> objectClass() {
			return MemberAcREST.class;
		}
	};

	private long memberAcNo;
	private Float creditRating;
	private Float meetingAttendance;
	private BigDecimal plannedMonthlySavingAm;
	private BigDecimal savedAm;
	private BigDecimal outstandingSavedAm;
	private BigDecimal provIntEnAm;
	private BigDecimal prevMonthIntEnAm;
	private BigDecimal dividedProfitDeclaredAm;
	private BigDecimal dividedProfitPaidAm;
	private BigDecimal returnedSavedAm;
	private BigDecimal returnedIntEnAm;
	private Integer noOfLoans;
	private Integer noOfActiveLoans;
	private BigDecimal loanAm;
	private BigDecimal recLoanAm;
	private BigDecimal recIntOnLoanAm;
	private BigDecimal projIntOnLoanAm;
	private BigDecimal badDeptClosedAm;
	private BigDecimal recPenaltyAm;
	private BigDecimal pendingPenaltyAm;
	private Integer meetingAttended;
	private Integer meetingMissed;
	private Date lastUpdatedTs;
	
	public long getMemberAcNo() {
		return memberAcNo;
	}
	public void setMemberAcNo(long memberAcNo) {
		this.memberAcNo = memberAcNo;
	}
	public Float getCreditRating() {
		return creditRating;
	}
	public void setCreditRating(Float creditRating) {
		this.creditRating = creditRating;
	}
	public Float getMeetingAttendance() {
		return meetingAttendance;
	}
	public void setMeetingAttendance(Float meetingAttendance) {
		this.meetingAttendance = meetingAttendance;
	}
	public BigDecimal getPlannedMonthlySavingAm() {
		return plannedMonthlySavingAm;
	}
	public void setPlannedMonthlySavingAm(BigDecimal plannedMonthlySavingAm) {
		this.plannedMonthlySavingAm = plannedMonthlySavingAm;
	}
	public BigDecimal getSavedAm() {
		return savedAm;
	}
	public void setSavedAm(BigDecimal savedAm) {
		this.savedAm = savedAm;
	}
	public BigDecimal getOutstandingSavedAm() {
		return outstandingSavedAm;
	}
	public void setOutstandingSavedAm(BigDecimal outstandingSavedAm) {
		this.outstandingSavedAm = outstandingSavedAm;
	}
	public BigDecimal getProvIntEnAm() {
		return provIntEnAm;
	}
	public void setProvIntEnAm(BigDecimal provIntEnAm) {
		this.provIntEnAm = provIntEnAm;
	}
	public BigDecimal getPrevMonthIntEnAm() {
		return prevMonthIntEnAm;
	}
	public void setPrevMonthIntEnAm(BigDecimal prevMonthIntEnAm) {
		this.prevMonthIntEnAm = prevMonthIntEnAm;
	}
	public BigDecimal getDividedProfitDeclaredAm() {
		return dividedProfitDeclaredAm;
	}
	public void setDividedProfitDeclaredAm(BigDecimal dividedProfitDeclaredAm) {
		this.dividedProfitDeclaredAm = dividedProfitDeclaredAm;
	}
	public BigDecimal getDividedProfitPaidAm() {
		return dividedProfitPaidAm;
	}
	public void setDividedProfitPaidAm(BigDecimal dividedProfitPaidAm) {
		this.dividedProfitPaidAm = dividedProfitPaidAm;
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
	public Integer getNoOfLoans() {
		return noOfLoans;
	}
	public void setNoOfLoans(Integer noOfLoans) {
		this.noOfLoans = noOfLoans;
	}
	public Integer getNoOfActiveLoans() {
		return noOfActiveLoans;
	}
	public void setNoOfActiveLoans(Integer noOfActiveLoans) {
		this.noOfActiveLoans = noOfActiveLoans;
	}
	public BigDecimal getLoanAm() {
		return loanAm;
	}
	public void setLoanAm(BigDecimal loanAm) {
		this.loanAm = loanAm;
	}
	public BigDecimal getRecLoanAm() {
		return recLoanAm;
	}
	public void setRecLoanAm(BigDecimal recLoanAm) {
		this.recLoanAm = recLoanAm;
	}
	public BigDecimal getRecIntOnLoanAm() {
		return recIntOnLoanAm;
	}
	public void setRecIntOnLoanAm(BigDecimal recIntOnLoanAm) {
		this.recIntOnLoanAm = recIntOnLoanAm;
	}
	public BigDecimal getProjIntOnLoanAm() {
		return projIntOnLoanAm;
	}
	public void setProjIntOnLoanAm(BigDecimal projIntOnLoanAm) {
		this.projIntOnLoanAm = projIntOnLoanAm;
	}
	public BigDecimal getBadDeptClosedAm() {
		return badDeptClosedAm;
	}
	public void setBadDeptClosedAm(BigDecimal badDeptClosedAm) {
		this.badDeptClosedAm = badDeptClosedAm;
	}
	public BigDecimal getRecPenaltyAm() {
		return recPenaltyAm;
	}
	public void setRecPenaltyAm(BigDecimal recPenaltyAm) {
		this.recPenaltyAm = recPenaltyAm;
	}
	public BigDecimal getPendingPenaltyAm() {
		return pendingPenaltyAm;
	}
	public void setPendingPenaltyAm(BigDecimal pendingPenaltyAm) {
		this.pendingPenaltyAm = pendingPenaltyAm;
	}
	public Integer getMeetingAttended() {
		return meetingAttended;
	}
	public void setMeetingAttended(Integer meetingAttended) {
		this.meetingAttended = meetingAttended;
	}
	public Integer getMeetingMissed() {
		return meetingMissed;
	}
	public void setMeetingMissed(Integer meetingMissed) {
		this.meetingMissed = meetingMissed;
	}
	public Date getLastUpdatedTs() {
		return lastUpdatedTs;
	}
	public void setLastUpdatedTs(Date lastUpdatedTs) {
		this.lastUpdatedTs = lastUpdatedTs;
	}
}
