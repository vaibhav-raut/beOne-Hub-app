package udaan.beone.mrpoint.http.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;
import java.util.List;

public class MemberOtherAcInfo {

	@JsonIgnore
	public static final JSONRepo JSONRepo = new JSONRepo<MemberOtherAcInfo>() {
		@Override
		protected Class<MemberOtherAcInfo> objectClass() {
			return MemberOtherAcInfo.class;
		}
	};

	private List<PenaltyDetail> penaltyDetail;
	
	public List<PenaltyDetail> getPenaltyDetail() {
		return penaltyDetail;
	}

	public void setPenaltyDetail(List<PenaltyDetail> penaltyDetail) {
		this.penaltyDetail = penaltyDetail;
	}

	public static class PenaltyDetail {
		private String txType;
		private BigDecimal amount;

		public PenaltyDetail() {
		}
		public PenaltyDetail(String txType, BigDecimal amount) {
			this.txType = txType;
			this.amount = amount;
		}
		public String getTxType() {
			return txType;
		}
		public void setTxType(String txType) {
			this.txType = txType;
		}
		public BigDecimal getAmount() {
			return amount;
		}
		public void setAmount(BigDecimal amount) {
			this.amount = amount;
		}
	}
}

