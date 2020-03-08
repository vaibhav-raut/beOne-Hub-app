package udaan.beone.mrpoint.http.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@JsonSerialize
public class MrAccount {

	@JsonIgnore
	public static final JSONRepo JSONRepo = new JSONRepo<MrAccount>() {
		@Override
		protected Class<MrAccount> objectClass() {
			return MrAccount.class;
		}
	};

	private long memberAcNo;
	private MemberREST memberInfo;
	private String mrRole;
	private String mrStatus;
	private String mrType;
	private BigDecimal registrationPaidAm;
	private BigDecimal registrationPendingAm;
	private BigDecimal depositPaidAm;
	private BigDecimal depositPendingAm;
	private BigDecimal depositReturnAm;
	private BigDecimal creditLimitAm;
	private BigDecimal totalCollectedAm;
	private BigDecimal totalPaidCollectedAm;
	private BigDecimal currentCollectedAm;
	private BigDecimal soldPaidAm;
	private BigDecimal soldPendingAm;
	private BigDecimal paidInterestPenaltyAm;
	private BigDecimal pendingInterestPenaltyAm;
	private long lastVisitOn;
	private long interestCalculatedOn;
	private BigDecimal currentStockAm;
	private BigDecimal currentStockDiscountAm;
	private BigDecimal currentStockUnsettledAm;
	private BigDecimal currentStockToReturnAm;
	private int currentStockNo;
	private int currentStockDiscountNo;
	private int currentStockUnsettledNo;
	private int currentStockToReturnNo;
	private float performanceIndex;
	private float returnIndex;
	private float salesIndex;
	private List<MrStat> mrStats;
	private List<MrVisit> mrVisits;

	public long getMemberAcNo() {
		return memberAcNo;
	}
	public void setMemberAcNo(long memberAcNo) {
		this.memberAcNo = memberAcNo;
	}
	public MemberREST getMemberInfo() {
		return memberInfo;
	}
	public void setMemberInfo(MemberREST memberInfo) {
		this.memberInfo = memberInfo;
	}

	public String getMrRole() {
		return mrRole;
	}

	public void setMrRole(String mrRole) {
		this.mrRole = mrRole;
	}

	public String getMrStatus() {
		return mrStatus;
	}
	public void setMrStatus(String mrStatus) {
		this.mrStatus = mrStatus;
	}
	public String getMrType() {
		return mrType;
	}
	public void setMrType(String mrType) {
		this.mrType = mrType;
	}
	public BigDecimal getRegistrationPaidAm() {
		return registrationPaidAm;
	}
	public void setRegistrationPaidAm(BigDecimal registrationPaidAm) {
		this.registrationPaidAm = registrationPaidAm;
	}
	public BigDecimal getRegistrationPendingAm() {
		return registrationPendingAm;
	}
	public void setRegistrationPendingAm(BigDecimal registrationPendingAm) {
		this.registrationPendingAm = registrationPendingAm;
	}
	public BigDecimal getDepositPaidAm() {
		return depositPaidAm;
	}
	public void setDepositPaidAm(BigDecimal depositPaidAm) {
		this.depositPaidAm = depositPaidAm;
	}
	public BigDecimal getDepositPendingAm() {
		return depositPendingAm;
	}
	public void setDepositPendingAm(BigDecimal depositPendingAm) {
		this.depositPendingAm = depositPendingAm;
	}
	public BigDecimal getDepositReturnAm() {
		return depositReturnAm;
	}
	public void setDepositReturnAm(BigDecimal depositReturnAm) {
		this.depositReturnAm = depositReturnAm;
	}
	public BigDecimal getCreditLimitAm() {
		return creditLimitAm;
	}
	public void setCreditLimitAm(BigDecimal creditLimitAm) {
		this.creditLimitAm = creditLimitAm;
	}
	public BigDecimal getTotalCollectedAm() {
		return totalCollectedAm;
	}
	public void setTotalCollectedAm(BigDecimal totalCollectedAm) {
		this.totalCollectedAm = totalCollectedAm;
	}
	public BigDecimal getTotalPaidCollectedAm() {
		return totalPaidCollectedAm;
	}
	public void setTotalPaidCollectedAm(BigDecimal totalPaidCollectedAm) {
		this.totalPaidCollectedAm = totalPaidCollectedAm;
	}
	public BigDecimal getCurrentCollectedAm() {
		return currentCollectedAm;
	}
	public void setCurrentCollectedAm(BigDecimal currentCollectedAm) {
		this.currentCollectedAm = currentCollectedAm;
	}
	public BigDecimal getSoldPaidAm() {
		return soldPaidAm;
	}
	public void setSoldPaidAm(BigDecimal soldPaidAm) {
		this.soldPaidAm = soldPaidAm;
	}
	public BigDecimal getSoldPendingAm() {
		return soldPendingAm;
	}
	public void setSoldPendingAm(BigDecimal soldPendingAm) {
		this.soldPendingAm = soldPendingAm;
	}
	public BigDecimal getPaidInterestPenaltyAm() {
		return paidInterestPenaltyAm;
	}
	public void setPaidInterestPenaltyAm(BigDecimal paidInterestPenaltyAm) {
		this.paidInterestPenaltyAm = paidInterestPenaltyAm;
	}
	public BigDecimal getPendingInterestPenaltyAm() {
		return pendingInterestPenaltyAm;
	}
	public void setPendingInterestPenaltyAm(BigDecimal pendingInterestPenaltyAm) {
		this.pendingInterestPenaltyAm = pendingInterestPenaltyAm;
	}
	public long getLastVisitOn() {
		return lastVisitOn;
	}
	public void setLastVisitOn(long lastVisitOn) {
		this.lastVisitOn = lastVisitOn;
	}
	public long getInterestCalculatedOn() {
		return interestCalculatedOn;
	}
	public void setInterestCalculatedOn(long interestCalculatedOn) {
		this.interestCalculatedOn = interestCalculatedOn;
	}
	public BigDecimal getCurrentStockAm() {
		return currentStockAm;
	}
	public void setCurrentStockAm(BigDecimal currentStockAm) {
		this.currentStockAm = currentStockAm;
	}
	public BigDecimal getCurrentStockDiscountAm() {
		return currentStockDiscountAm;
	}
	public void setCurrentStockDiscountAm(BigDecimal currentStockDiscountAm) {
		this.currentStockDiscountAm = currentStockDiscountAm;
	}
	public BigDecimal getCurrentStockUnsettledAm() {
		return currentStockUnsettledAm;
	}
	public void setCurrentStockUnsettledAm(BigDecimal currentStockUnsettledAm) {
		this.currentStockUnsettledAm = currentStockUnsettledAm;
	}
	public BigDecimal getCurrentStockToReturnAm() {
		return currentStockToReturnAm;
	}
	public void setCurrentStockToReturnAm(BigDecimal currentStockToReturnAm) {
		this.currentStockToReturnAm = currentStockToReturnAm;
	}
	public int getCurrentStockNo() {
		return currentStockNo;
	}
	public void setCurrentStockNo(int currentStockNo) {
		this.currentStockNo = currentStockNo;
	}
	public int getCurrentStockDiscountNo() {
		return currentStockDiscountNo;
	}
	public void setCurrentStockDiscountNo(int currentStockDiscountNo) {
		this.currentStockDiscountNo = currentStockDiscountNo;
	}
	public int getCurrentStockUnsettledNo() {
		return currentStockUnsettledNo;
	}
	public void setCurrentStockUnsettledNo(int currentStockUnsettledNo) {
		this.currentStockUnsettledNo = currentStockUnsettledNo;
	}
	public int getCurrentStockToReturnNo() {
		return currentStockToReturnNo;
	}
	public void setCurrentStockToReturnNo(int currentStockToReturnNo) {
		this.currentStockToReturnNo = currentStockToReturnNo;
	}
	public float getPerformanceIndex() {
		return performanceIndex;
	}
	public void setPerformanceIndex(float performanceIndex) {
		this.performanceIndex = performanceIndex;
	}
	public float getReturnIndex() {
		return returnIndex;
	}
	public void setReturnIndex(float returnIndex) {
		this.returnIndex = returnIndex;
	}
	public float getSalesIndex() {
		return salesIndex;
	}
	public void setSalesIndex(float salesIndex) {
		this.salesIndex = salesIndex;
	}
	public List<MrStat> getMrStats() {
		return mrStats;
	}
	public void setMrStats(List<MrStat> mrStats) {
		this.mrStats = mrStats;
	}
	public void addMrStats(MrStat mrStat) {
		if(mrStats == null) {
			mrStats = new ArrayList<MrStat>();
		}

		this.mrStats.add(mrStat);
	}
	public List<MrVisit> getMrVisits() {
		return mrVisits;
	}
	public void setMrVisits(List<MrVisit> mrVisits) {
		this.mrVisits = mrVisits;
	}
	public void addMrVisits(MrVisit mrVisit) {
		if(mrVisits == null) {
			mrVisits = new ArrayList<MrVisit>();
		}

		this.mrVisits.add(mrVisit);
	}

	public static class MrStat {

		private String title;
		private BigDecimal stockAm;
		private BigDecimal stockReturnedAm;
		private BigDecimal stockDamagedAm;
		private BigDecimal stockSoldAm;
		private BigDecimal stockSoldDiscountAm;
		private BigDecimal stockMrSoldAm;
		private int stockNo;
		private int stockReturnedNo;
		private int stockDamagedNo;
		private int stockSoldDiscountNo;
		private int stockSoldNo;
		private int visitCounter;

		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public BigDecimal getStockAm() {
			return stockAm;
		}
		public void setStockAm(BigDecimal stockAm) {
			this.stockAm = stockAm;
		}
		public BigDecimal getStockReturnedAm() {
			return stockReturnedAm;
		}
		public void setStockReturnedAm(BigDecimal stockReturnedAm) {
			this.stockReturnedAm = stockReturnedAm;
		}
		public BigDecimal getStockDamagedAm() {
			return stockDamagedAm;
		}
		public void setStockDamagedAm(BigDecimal stockDamagedAm) {
			this.stockDamagedAm = stockDamagedAm;
		}
		public BigDecimal getStockSoldAm() {
			return stockSoldAm;
		}
		public void setStockSoldAm(BigDecimal stockSoldAm) {
			this.stockSoldAm = stockSoldAm;
		}
		public BigDecimal getStockSoldDiscountAm() {
			return stockSoldDiscountAm;
		}
		public void setStockSoldDiscountAm(BigDecimal stockSoldDiscountAm) {
			this.stockSoldDiscountAm = stockSoldDiscountAm;
		}
		public BigDecimal getStockMrSoldAm() {
			return stockMrSoldAm;
		}
		public void setStockMrSoldAm(BigDecimal stockMrSoldAm) {
			this.stockMrSoldAm = stockMrSoldAm;
		}
		public int getStockNo() {
			return stockNo;
		}
		public void setStockNo(int stockNo) {
			this.stockNo = stockNo;
		}
		public int getStockReturnedNo() {
			return stockReturnedNo;
		}
		public void setStockReturnedNo(int stockReturnedNo) {
			this.stockReturnedNo = stockReturnedNo;
		}
		public int getStockDamagedNo() {
			return stockDamagedNo;
		}
		public void setStockDamagedNo(int stockDamagedNo) {
			this.stockDamagedNo = stockDamagedNo;
		}
		public int getStockSoldNo() {
			return stockSoldNo;
		}
		public void setStockSoldNo(int stockSoldNo) {
			this.stockSoldNo = stockSoldNo;
		}
		public int getStockSoldDiscountNo() {
			return stockSoldDiscountNo;
		}
		public void setStockSoldDiscountNo(int stockSoldDiscountNo) {
			this.stockSoldDiscountNo = stockSoldDiscountNo;
		}
		public int getVisitCounter() {
			return visitCounter;
		}
		public void setVisitCounter(int visitCounter) {
			this.visitCounter = visitCounter;
		}

	}
}
