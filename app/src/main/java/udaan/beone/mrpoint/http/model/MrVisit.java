package udaan.beone.mrpoint.http.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.math.BigDecimal;

import udaan.beone.mrpoint.data.DataManager;
import udaan.beone.mrpoint.http.model.s.MrVisitS;
import udaan.beone.mrpoint.util.AndroidUtil;
import udaan.beone.mrpoint.util.EnumConst;

@JsonSerialize
public class MrVisit {

	@JsonIgnore
	public static final JSONRepo JSONRepo = new JSONRepo<MrVisit>() {
		@Override
		protected Class<MrVisit> objectClass() {
			return MrVisit.class;
		}
	};

	private long mrVisitId;
	private long ownerAcNo;
	private long authAcNo;
	private String ownerAcNoDisplay;
	private String ownerName;
	private String authAcNoDisplay;
	private String authName;
	private String visitStatus;
	private String visitType;
	private long scheduledTs;
	private long startTs;
	private long endTs;
	private long latestUpdateTs;
	private BigDecimal openingOutstandingAm;
	private BigDecimal soldPaidAm;
	private BigDecimal soldPendingAm;
	private BigDecimal closingOutstandingAm;
	private BigDecimal openingInterestPenaltyAm;
	private BigDecimal paidInterestPenaltyAm;
	private BigDecimal closingInterestPenaltyAm;
	private BigDecimal openingCollectedAm;
	private BigDecimal paidCollectedAm;
	private BigDecimal receivedCollectedAm;
	private BigDecimal closingCollectedAm;
	private BigDecimal openingRegistrationAm;
	private BigDecimal paidRegistrationAm;
	private BigDecimal closingRegistrationAm;
	private BigDecimal openingDepositAm;
	private BigDecimal paidDepositAm;
	private BigDecimal returnedDepositAm;
	private BigDecimal closingDepositAm;
	private BigDecimal openingStockAm;
	private BigDecimal returnStockAm;
	private BigDecimal soldStockAm;
	private BigDecimal soldStockDiscountAm;
	private BigDecimal mrSoldStockAm;
	private BigDecimal givenStockAm;
	private BigDecimal closingStockAm;
	private int openingStockNo;
	private int returnStockNo;
	private int soldStockNo;
	private int soldStockDiscountNo;
	private int givenStockNo;
	private int closingStockNo;
	private BigDecimal authBalanceAm;
	private BigDecimal authStockAm;
	private int authStockNo;
	private BigDecimal totalStockAm;
	private BigDecimal totalStockReturnedAm;
	private BigDecimal totalStockDamagedAm;
	private BigDecimal totalStockSoldAm;
	private BigDecimal totalStockSoldDiscountAm;
	private int totalStockNo;
	private int totalStockReturnedNo;
	private int totalStockDamagedNo;
	private int totalStockSoldNo;
	private int totalStockSoldDiscountNo;
	private BigDecimal totalPaidSoldAm;
	private BigDecimal totalPaidInterestPenaltyAm;
	private BigDecimal totalPaidCollectedAm;
	private BigDecimal totalRegistrationPaidAm;
	private BigDecimal totalDepositPaidAm;
	private int totalVisitCounter;
	private String location;
	private String description;
	
	public long getMrVisitId() {
		return mrVisitId;
	}
	public void setMrVisitId(long mrVisitId) {
		this.mrVisitId = mrVisitId;
	}
	public long getOwnerAcNo() {
		return ownerAcNo;
	}
	public void setOwnerAcNo(long ownerAcNo) {
		this.ownerAcNo = ownerAcNo;
	}
	public long getAuthAcNo() {
		return authAcNo;
	}
	public void setAuthAcNo(long authAcNo) {
		this.authAcNo = authAcNo;
	}

	public String getOwnerAcNoDisplay() {
		return ownerAcNoDisplay;
	}

	public void setOwnerAcNoDisplay(String ownerAcNoDisplay) {
		this.ownerAcNoDisplay = ownerAcNoDisplay;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getAuthAcNoDisplay() {
		return authAcNoDisplay;
	}

	public void setAuthAcNoDisplay(String authAcNoDisplay) {
		this.authAcNoDisplay = authAcNoDisplay;
	}

	public String getAuthName() {
		return authName;
	}

	public void setAuthName(String authName) {
		this.authName = authName;
	}

	public String getVisitStatus() {
		return visitStatus;
	}
	public void setVisitStatus(String visitStatus) {
		this.visitStatus = visitStatus;
	}
	public String getVisitType() {
		return visitType;
	}
	public void setVisitType(String visitType) {
		this.visitType = visitType;
	}
	public long getScheduledTs() {
		return scheduledTs;
	}
	public void setScheduledTs(long scheduledTs) {
		this.scheduledTs = scheduledTs;
	}
	public long getStartTs() {
		return startTs;
	}
	public void setStartTs(long startTs) {
		this.startTs = startTs;
	}
	public long getEndTs() {
		return endTs;
	}
	public long getLatestUpdateTs() {
		return latestUpdateTs;
	}
	public void setLatestUpdateTs(long latestUpdateTs) {
		this.latestUpdateTs = latestUpdateTs;
	}
	public void setEndTs(long endTs) {
		this.endTs = endTs;
	}
	public BigDecimal getOpeningOutstandingAm() {
		return openingOutstandingAm;
	}
	public void setOpeningOutstandingAm(BigDecimal openingOutstandingAm) {
		this.openingOutstandingAm = openingOutstandingAm;
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
	public BigDecimal getClosingOutstandingAm() {
		return closingOutstandingAm;
	}
	public void setClosingOutstandingAm(BigDecimal closingOutstandingAm) {
		this.closingOutstandingAm = closingOutstandingAm;
	}
	public BigDecimal getOpeningInterestPenaltyAm() {
		return openingInterestPenaltyAm;
	}
	public void setOpeningInterestPenaltyAm(BigDecimal openingInterestPenaltyAm) {
		this.openingInterestPenaltyAm = openingInterestPenaltyAm;
	}
	public BigDecimal getPaidInterestPenaltyAm() {
		return paidInterestPenaltyAm;
	}
	public void setPaidInterestPenaltyAm(BigDecimal paidInterestPenaltyAm) {
		this.paidInterestPenaltyAm = paidInterestPenaltyAm;
	}
	public BigDecimal getClosingInterestPenaltyAm() {
		return closingInterestPenaltyAm;
	}
	public void setClosingInterestPenaltyAm(BigDecimal closingInterestPenaltyAm) {
		this.closingInterestPenaltyAm = closingInterestPenaltyAm;
	}
	public BigDecimal getOpeningCollectedAm() {
		return openingCollectedAm;
	}
	public void setOpeningCollectedAm(BigDecimal openingCollectedAm) {
		this.openingCollectedAm = openingCollectedAm;
	}
	public BigDecimal getPaidCollectedAm() {
		return paidCollectedAm;
	}
	public void setPaidCollectedAm(BigDecimal paidCollectedAm) {
		this.paidCollectedAm = paidCollectedAm;
	}
	public BigDecimal getReceivedCollectedAm() {
		return receivedCollectedAm;
	}
	public void setReceivedCollectedAm(BigDecimal receivedCollectedAm) {
		this.receivedCollectedAm = receivedCollectedAm;
	}
	public BigDecimal getClosingCollectedAm() {
		return closingCollectedAm;
	}
	public void setClosingCollectedAm(BigDecimal closingCollectedAm) {
		this.closingCollectedAm = closingCollectedAm;
	}
	public BigDecimal getOpeningRegistrationAm() {
		return openingRegistrationAm;
	}
	public void setOpeningRegistrationAm(BigDecimal openingRegistrationAm) {
		this.openingRegistrationAm = openingRegistrationAm;
	}
	public BigDecimal getPaidRegistrationAm() {
		return paidRegistrationAm;
	}
	public void setPaidRegistrationAm(BigDecimal paidRegistrationAm) {
		this.paidRegistrationAm = paidRegistrationAm;
	}
	public BigDecimal getClosingRegistrationAm() {
		return closingRegistrationAm;
	}
	public void setClosingRegistrationAm(BigDecimal closingRegistrationAm) {
		this.closingRegistrationAm = closingRegistrationAm;
	}
	public BigDecimal getOpeningDepositAm() {
		return openingDepositAm;
	}
	public void setOpeningDepositAm(BigDecimal openingDepositAm) {
		this.openingDepositAm = openingDepositAm;
	}
	public BigDecimal getPaidDepositAm() {
		return paidDepositAm;
	}
	public void setPaidDepositAm(BigDecimal paidDepositAm) {
		this.paidDepositAm = paidDepositAm;
	}
	public BigDecimal getReturnedDepositAm() {
		return returnedDepositAm;
	}
	public void setReturnedDepositAm(BigDecimal returnedDepositAm) {
		this.returnedDepositAm = returnedDepositAm;
	}
	public BigDecimal getClosingDepositAm() {
		return closingDepositAm;
	}
	public void setClosingDepositAm(BigDecimal closingDepositAm) {
		this.closingDepositAm = closingDepositAm;
	}
	public BigDecimal getOpeningStockAm() {
		return openingStockAm;
	}
	public void setOpeningStockAm(BigDecimal openingStockAm) {
		this.openingStockAm = openingStockAm;
	}
	public BigDecimal getReturnStockAm() {
		return returnStockAm;
	}
	public void setReturnStockAm(BigDecimal returnStockAm) {
		this.returnStockAm = returnStockAm;
	}
	public BigDecimal getSoldStockAm() {
		return soldStockAm;
	}
	public void setSoldStockAm(BigDecimal soldStockAm) {
		this.soldStockAm = soldStockAm;
	}
	public BigDecimal getSoldStockDiscountAm() {
		return soldStockDiscountAm;
	}
	public void setSoldStockDiscountAm(BigDecimal soldStockDiscountAm) {
		this.soldStockDiscountAm = soldStockDiscountAm;
	}
	public BigDecimal getMrSoldStockAm() {
		return mrSoldStockAm;
	}
	public void setMrSoldStockAm(BigDecimal mrSoldStockAm) {
		this.mrSoldStockAm = mrSoldStockAm;
	}
	public BigDecimal getGivenStockAm() {
		return givenStockAm;
	}
	public void setGivenStockAm(BigDecimal givenStockAm) {
		this.givenStockAm = givenStockAm;
	}
	public BigDecimal getClosingStockAm() {
		return closingStockAm;
	}
	public void setClosingStockAm(BigDecimal closingStockAm) {
		this.closingStockAm = closingStockAm;
	}
	public int getOpeningStockNo() {
		return openingStockNo;
	}
	public void setOpeningStockNo(int openingStockNo) {
		this.openingStockNo = openingStockNo;
	}
	public int getReturnStockNo() {
		return returnStockNo;
	}
	public void setReturnStockNo(int returnStockNo) {
		this.returnStockNo = returnStockNo;
	}
	public int getSoldStockNo() {
		return soldStockNo;
	}
	public void setSoldStockNo(int soldStockNo) {
		this.soldStockNo = soldStockNo;
	}
	public int getSoldStockDiscountNo() {
		return soldStockDiscountNo;
	}
	public void setSoldStockDiscountNo(int soldStockDiscountNo) {
		this.soldStockDiscountNo = soldStockDiscountNo;
	}
	public int getGivenStockNo() {
		return givenStockNo;
	}
	public void setGivenStockNo(int givenStockNo) {
		this.givenStockNo = givenStockNo;
	}
	public int getClosingStockNo() {
		return closingStockNo;
	}
	public void setClosingStockNo(int closingStockNo) {
		this.closingStockNo = closingStockNo;
	}

	public BigDecimal getAuthBalanceAm() {
		return authBalanceAm;
	}

	public void setAuthBalanceAm(BigDecimal authBalanceAm) {
		this.authBalanceAm = authBalanceAm;
	}

	public BigDecimal getAuthStockAm() {
		return authStockAm;
	}

	public void setAuthStockAm(BigDecimal authStockAm) {
		this.authStockAm = authStockAm;
	}

	public int getAuthStockNo() {
		return authStockNo;
	}

	public void setAuthStockNo(int authStockNo) {
		this.authStockNo = authStockNo;
	}

	public BigDecimal getTotalStockAm() {
		return totalStockAm;
	}
	public void setTotalStockAm(BigDecimal totalStockAm) {
		this.totalStockAm = totalStockAm;
	}
	public BigDecimal getTotalStockReturnedAm() {
		return totalStockReturnedAm;
	}
	public void setTotalStockReturnedAm(BigDecimal totalStockReturnedAm) {
		this.totalStockReturnedAm = totalStockReturnedAm;
	}
	public BigDecimal getTotalStockDamagedAm() {
		return totalStockDamagedAm;
	}
	public void setTotalStockDamagedAm(BigDecimal totalStockDamagedAm) {
		this.totalStockDamagedAm = totalStockDamagedAm;
	}
	public BigDecimal getTotalStockSoldAm() {
		return totalStockSoldAm;
	}
	public void setTotalStockSoldAm(BigDecimal totalStockSoldAm) {
		this.totalStockSoldAm = totalStockSoldAm;
	}
	public BigDecimal getTotalStockSoldDiscountAm() {
		return totalStockSoldDiscountAm;
	}
	public void setTotalStockSoldDiscountAm(BigDecimal totalStockSoldDiscountAm) {
		this.totalStockSoldDiscountAm = totalStockSoldDiscountAm;
	}
	public int getTotalStockNo() {
		return totalStockNo;
	}
	public void setTotalStockNo(int totalStockNo) {
		this.totalStockNo = totalStockNo;
	}
	public int getTotalStockReturnedNo() {
		return totalStockReturnedNo;
	}
	public void setTotalStockReturnedNo(int totalStockReturnedNo) {
		this.totalStockReturnedNo = totalStockReturnedNo;
	}
	public int getTotalStockDamagedNo() {
		return totalStockDamagedNo;
	}
	public void setTotalStockDamagedNo(int totalStockDamagedNo) {
		this.totalStockDamagedNo = totalStockDamagedNo;
	}
	public int getTotalStockSoldNo() {
		return totalStockSoldNo;
	}
	public void setTotalStockSoldNo(int totalStockSoldNo) {
		this.totalStockSoldNo = totalStockSoldNo;
	}
	public int getTotalStockSoldDiscountNo() {
		return totalStockSoldDiscountNo;
	}
	public void setTotalStockSoldDiscountNo(int totalStockSoldDiscountNo) {
		this.totalStockSoldDiscountNo = totalStockSoldDiscountNo;
	}
	public BigDecimal getTotalPaidSoldAm() {
		return totalPaidSoldAm;
	}
	public void setTotalPaidSoldAm(BigDecimal totalPaidSoldAm) {
		this.totalPaidSoldAm = totalPaidSoldAm;
	}
	public BigDecimal getTotalPaidInterestPenaltyAm() {
		return totalPaidInterestPenaltyAm;
	}
	public void setTotalPaidInterestPenaltyAm(BigDecimal totalPaidInterestPenaltyAm) {
		this.totalPaidInterestPenaltyAm = totalPaidInterestPenaltyAm;
	}
	public BigDecimal getTotalPaidCollectedAm() {
		return totalPaidCollectedAm;
	}
	public void setTotalPaidCollectedAm(BigDecimal totalPaidCollectedAm) {
		this.totalPaidCollectedAm = totalPaidCollectedAm;
	}
	public BigDecimal getTotalRegistrationPaidAm() {
		return totalRegistrationPaidAm;
	}
	public void setTotalRegistrationPaidAm(BigDecimal totalRegistrationPaidAm) {
		this.totalRegistrationPaidAm = totalRegistrationPaidAm;
	}
	public BigDecimal getTotalDepositPaidAm() {
		return totalDepositPaidAm;
	}
	public void setTotalDepositPaidAm(BigDecimal totalDepositPaidAm) {
		this.totalDepositPaidAm = totalDepositPaidAm;
	}
	public int getTotalVisitCounter() {
		return totalVisitCounter;
	}
	public void setTotalVisitCounter(int totalVisitCounter) {
		this.totalVisitCounter = totalVisitCounter;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public MrVisitS buildMrVisitShort() {
		MrVisitS mrVisitS = new MrVisitS();

		mrVisitS.setMrVisitId(mrVisitId);
		mrVisitS.setOwnerAcNo(ownerAcNo);
		mrVisitS.setAuthAcNo(authAcNo);
		mrVisitS.setVisitStatus(visitStatus);
		mrVisitS.setVisitType(visitType);
		mrVisitS.setLocation(location);
		mrVisitS.setDescription(description);

		return mrVisitS;
	}

	public static MrVisitS buildCreateMrVisit() {
		MrVisitS mrVisitS = new MrVisitS();

		if(DataManager.instance().getLoginMemberAcNo() == 0l ||
				DataManager.instance().getSelectedMemberAcNo() == 0l) {
			return null;
		}

		mrVisitS.setAuthAcNo(DataManager.instance().getLoginMemberAcNo());
		mrVisitS.setOwnerAcNo(DataManager.instance().getSelectedMemberAcNo());
		mrVisitS.setVisitStatus(EnumConst.VisitStatus_Unscheduled);

		String role = DataManager.instance().getOwnerAccount().getMrRole();
		switch (role) {
			case EnumConst.MRole_Local_HUB_Manager:
				mrVisitS.setVisitType(EnumConst.VisitType_Local_HUB);
				break;

			case EnumConst.MRole_Sub_Local_HUB_Manager:
				mrVisitS.setVisitType(EnumConst.VisitType_Sub_Local_HUB);
				break;

			case EnumConst.MRole_Super_Sales_Executive:
				mrVisitS.setVisitType(EnumConst.VisitType_SSE_Account);
				break;

			case EnumConst.MRole_Sales_Executive:
				mrVisitS.setVisitType(EnumConst.VisitType_SE_Account);
				break;

			case EnumConst.MRole_Micro_Retailer:
				mrVisitS.setVisitType(EnumConst.VisitType_Scheduled_MR_Visit);
				break;

		}

//		mrVisitS.setLocation(location);
//		mrVisitS.setDescription(description);

			return mrVisitS;
	}
}