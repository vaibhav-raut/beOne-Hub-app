package udaan.beone.mrpoint.http.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.ArrayList;
import java.util.List;

@JsonSerialize
public class StockTransfer {

	@JsonIgnore
	public static final JSONRepo JSONRepo = new JSONRepo<StockTransfer>() {
		@Override
		protected Class<StockTransfer> objectClass() {
			return StockTransfer.class;
		}
	};

	private List<StockItemL> stockItems;
	private long ownerAcNo;
	private long authAcNo;
	private long mrVisitId;
	private String stockTxType;
	private String description;
	private String entryLocation;
	
	public List<StockItemL> getStockItems() {
		return stockItems;
	}
	public void setStockItems(List<StockItemL> stockItems) {
		this.stockItems = stockItems;
	}
	public void addStockItems(StockItemL stockItemId) {
		if(this.stockItems == null) {
			this.stockItems = new ArrayList<StockItemL>();
		}
		this.stockItems.add(stockItemId);
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
	public long getMrVisitId() {
		return mrVisitId;
	}
	public void setMrVisitId(long mrVisitId) {
		this.mrVisitId = mrVisitId;
	}
	public String getStockTxType() {
		return stockTxType;
	}
	public void setStockTxType(String stockTxType) {
		this.stockTxType = stockTxType;
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
	
}
