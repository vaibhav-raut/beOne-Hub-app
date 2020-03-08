package udaan.beone.mrpoint.http.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.math.BigDecimal;
import java.util.Date;

@JsonSerialize
public class StockItem {

	@JsonIgnore
	public static final JSONRepo JSONRepo = new JSONRepo<StockItem>() {
		@Override
		protected Class<StockItem> objectClass() {
			return StockItem.class;
		}
	};

	private long stockItemId;
	private long stockTypeId;
	private long brandId;
	private String stockItemName;
	private String stockTypeName;
	private String brandName;
	private long lotId;
	private long sInvoiceId;
	private String itemStatus;
	private String itemCondition;
	private long pkgId;
	private long ownerAcNo;
	private String ownerAcNoDisplay;
	private String ownerName;
	private String designNo;
	private BigDecimal wsPrice;
	private BigDecimal mrPrice;
	private BigDecimal disMrPrice;
	private BigDecimal mrpPrice;
	private BigDecimal disMrpPrice;
	private BigDecimal soldPrice;
	private BigDecimal mrSoldPrice;
	private float discountPer;
	private BigDecimal discountAm;
	private float vatPer;
	private BigDecimal vatAm;
	private Date checkTs;
	private int checkFlag;
	
	public long getStockItemId() {
		return stockItemId;
	}
	public void setStockItemId(long stockItemId) {
		this.stockItemId = stockItemId;
	}
	public long getStockTypeId() {
		return stockTypeId;
	}
	public void setStockTypeId(long stockTypeId) {
		this.stockTypeId = stockTypeId;
	}
	public long getBrandId() {
		return brandId;
	}
	public void setBrandId(long brandId) {
		this.brandId = brandId;
	}
	public String getStockItemName() {
		return stockItemName;
	}
	public void setStockItemName(String stockItemName) {
		this.stockItemName = stockItemName;
	}
	public String getStockTypeName() {
		return stockTypeName;
	}
	public void setStockTypeName(String stockTypeName) {
		this.stockTypeName = stockTypeName;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public long getLotId() {
		return lotId;
	}
	public void setLotId(long lotId) {
		this.lotId = lotId;
	}
	public long getsInvoiceId() {
		return sInvoiceId;
	}
	public void setsInvoiceId(long sInvoiceId) {
		this.sInvoiceId = sInvoiceId;
	}
	public String getItemStatus() {
		return itemStatus;
	}
	public void setItemStatus(String itemStatus) {
		this.itemStatus = itemStatus;
	}
	public String getItemCondition() {
		return itemCondition;
	}
	public void setItemCondition(String itemCondition) {
		this.itemCondition = itemCondition;
	}
	public long getPkgId() {
		return pkgId;
	}
	public void setPkgId(long pkgId) {
		this.pkgId = pkgId;
	}
	public long getOwnerAcNo() {
		return ownerAcNo;
	}
	public void setOwnerAcNo(long ownerAcNo) {
		this.ownerAcNo = ownerAcNo;
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
	public String getDesignNo() {
		return designNo;
	}
	public void setDesignNo(String designNo) {
		this.designNo = designNo;
	}
	public BigDecimal getWsPrice() {
		return wsPrice;
	}
	public void setWsPrice(BigDecimal wsPrice) {
		this.wsPrice = wsPrice;
	}
	public BigDecimal getMrPrice() {
		return mrPrice;
	}
	public void setMrPrice(BigDecimal mrPrice) {
		this.mrPrice = mrPrice;
	}

	public BigDecimal getDisMrPrice() {
		return disMrPrice;
	}

	public void setDisMrPrice(BigDecimal disMrPrice) {
		this.disMrPrice = disMrPrice;
	}

	public BigDecimal getMrpPrice() {
		return mrpPrice;
	}
	public void setMrpPrice(BigDecimal mrpPrice) {
		this.mrpPrice = mrpPrice;
	}
	public BigDecimal getDisMrpPrice() {
		return disMrpPrice;
	}
	public void setDisMrpPrice(BigDecimal disMrpPrice) {
		this.disMrpPrice = disMrpPrice;
	}
	public BigDecimal getSoldPrice() {
		return soldPrice;
	}
	public void setSoldPrice(BigDecimal soldPrice) {
		this.soldPrice = soldPrice;
	}
	public BigDecimal getMrSoldPrice() {
		return mrSoldPrice;
	}
	public void setMrSoldPrice(BigDecimal mrSoldPrice) {
		this.mrSoldPrice = mrSoldPrice;
	}
	public float getDiscountPer() {
		return discountPer;
	}
	public void setDiscountPer(float discountPer) {
		this.discountPer = discountPer;
	}
	public BigDecimal getDiscountAm() {
		return discountAm;
	}
	public void setDiscountAm(BigDecimal discountAm) {
		this.discountAm = discountAm;
	}
	public float getVatPer() {
		return vatPer;
	}
	public void setVatPer(float vatPer) {
		this.vatPer = vatPer;
	}
	public BigDecimal getVatAm() {
		return vatAm;
	}
	public void setVatAm(BigDecimal vatAm) {
		this.vatAm = vatAm;
	}
	public Date getCheckTs() {
		return checkTs;
	}
	public void setCheckTs(Date checkTs) {
		this.checkTs = checkTs;
	}
	public int getCheckFlag() {
		return checkFlag;
	}
	public void setCheckFlag(int checkFlag) {
		this.checkFlag = checkFlag;
	}
}
