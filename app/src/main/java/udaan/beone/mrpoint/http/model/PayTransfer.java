package udaan.beone.mrpoint.http.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@JsonSerialize
public class PayTransfer {

	@JsonIgnore
	public static final JSONRepo JSONRepo = new JSONRepo<PayTransfer>() {
		@Override
		protected Class<PayTransfer> objectClass() {
			return PayTransfer.class;
		}
	};

	private long ownerAcNo;
	private long authAcNo;
	private long mrVisitId;
	private BigDecimal amount;
	private String description;
	private String entryLocation;
	private List<PayTx> payTxs;

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
	public long getMrVisitId() {
		return mrVisitId;
	}
	public void setMrVisitId(long mrVisitId) {
		this.mrVisitId = mrVisitId;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getEntryLocation() {
		return entryLocation;
	}
	public void setEntryLocation(String entryLocation) {
		this.entryLocation = entryLocation;
	}		
	public List<PayTx> getPayTxs() {
		return payTxs;
	}
	public void setPayTxs(List<PayTx> payTxs) {
		this.payTxs = payTxs;
	}
	public void addPayTx(PayTx payTx) {
		if(this.payTxs == null) {
			this.payTxs = new ArrayList<PayTx>();
		}
		
		this.payTxs.add(payTx);
	}

	public static class PayTx {
		private String stockTxType;
		private BigDecimal payAmount;
		private BigDecimal outstandingAmount;
		private String description;
		
		public String getStockTxType() {
			return stockTxType;
		}
		public void setStockTxType(String stockTxType) {
			this.stockTxType = stockTxType;
		}
		public BigDecimal getPayAmount() {
			return payAmount;
		}
		public void setPayAmount(BigDecimal payAmount) {
			this.payAmount = payAmount;
		}
		public BigDecimal getOutstandingAmount() {
			return outstandingAmount;
		}
		public void setOutstandingAmount(BigDecimal outstandingAmount) {
			this.outstandingAmount = outstandingAmount;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
	}
}
