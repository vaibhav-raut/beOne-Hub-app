package udaan.beone.mrpoint.http.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.math.BigDecimal;
import java.util.Map;

@JsonSerialize
public class MrStock {

	@JsonIgnore
	public static final JSONRepo JSONRepo = new JSONRepo<MrStock>() {
		@Override
		protected Class<MrStock> objectClass() {
			return MrStock.class;
		}
	};

	private long ownerAcNo;
	private String ownerAcNoName;
	private BigDecimal cumMrPrice;
	private BigDecimal cumSelectedMrPrice;
	private int cumNoStock;
	private int cumSelectedNoStock;
	private Map<Long, ByBrand> brands;

	public long getOwnerAcNo() {
		return ownerAcNo;
	}
	public void setOwnerAcNo(long ownerAcNo) {
		this.ownerAcNo = ownerAcNo;
	}
	public String getOwnerAcNoName() {
		return ownerAcNoName;
	}
	public void setOwnerAcNoName(String ownerAcNoName) {
		this.ownerAcNoName = ownerAcNoName;
	}
	public BigDecimal getCumMrPrice() {
		return cumMrPrice;
	}
	public void setCumMrPrice(BigDecimal cumMrPrice) {
		this.cumMrPrice = cumMrPrice;
	}
	public BigDecimal getCumSelectedMrPrice() {
		return cumSelectedMrPrice;
	}
	public void setCumSelectedMrPrice(BigDecimal cumSelectedMrPrice) {
		this.cumSelectedMrPrice = cumSelectedMrPrice;
	}
	public int getCumNoStock() {
		return cumNoStock;
	}
	public void setCumNoStock(int cumNoStock) {
		this.cumNoStock = cumNoStock;
	}
	public int getCumSelectedNoStock() {
		return cumSelectedNoStock;
	}
	public void setCumSelectedNoStock(int cumSelectedNoStock) {
		this.cumSelectedNoStock = cumSelectedNoStock;
	}
	public Map<Long, ByBrand> getBrands() {
		return brands;
	}
	public void setBrands(Map<Long, ByBrand> brands) {
		this.brands = brands;
	}
	public void putBrand(Long brandId, ByBrand brand) {
		this.brands.put(brandId, brand);
	}

	static public class ByBrand {
		private long brandId;
		private String name;
		private String description;
		private String properties;
		private BigDecimal cumMrPrice;
		private BigDecimal cumSelectedMrPrice;
		private int cumNoStock;
		private int cumSelectedNoStock;
		private Map<Long, ByType> types;

		public long getBrandId() {
			return brandId;
		}
		public void setBrandId(long brandId) {
			this.brandId = brandId;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public String getProperties() {
			return properties;
		}
		public void setProperties(String properties) {
			this.properties = properties;
		}
		public BigDecimal getCumMrPrice() {
			return cumMrPrice;
		}
		public void setCumMrPrice(BigDecimal cumMrPrice) {
			this.cumMrPrice = cumMrPrice;
		}
		public BigDecimal getCumSelectedMrPrice() {
			return cumSelectedMrPrice;
		}
		public void setCumSelectedMrPrice(BigDecimal cumSelectedMrPrice) {
			this.cumSelectedMrPrice = cumSelectedMrPrice;
		}
		public int getCumNoStock() {
			return cumNoStock;
		}
		public void setCumNoStock(int cumNoStock) {
			this.cumNoStock = cumNoStock;
		}
		public int getCumSelectedNoStock() {
			return cumSelectedNoStock;
		}
		public void setCumSelectedNoStock(int cumSelectedNoStock) {
			this.cumSelectedNoStock = cumSelectedNoStock;
		}
		public Map<Long, ByType> getTypes() {
			return types;
		}
		public void setTypes(Map<Long, ByType> types) {
			this.types = types;
		}
		public void putType(Long typeId, ByType type) {
			this.types.put(typeId, type);
		}
	}

	static public class ByType {
		private long stockTypeId;
		private String name;
		private String category;
		private String description;
		private String properties;
		private String pics;
		private BigDecimal cumMrPrice;
		private BigDecimal cumSelectedMrPrice;
		private int cumNoStock;
		private int cumSelectedNoStock;
		private Map<Long, Item> items;

		public long getStockTypeId() {
			return stockTypeId;
		}
		public void setStockTypeId(long stockTypeId) {
			this.stockTypeId = stockTypeId;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getCategory() {
			return category;
		}
		public void setCategory(String category) {
			this.category = category;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public String getProperties() {
			return properties;
		}
		public void setProperties(String properties) {
			this.properties = properties;
		}
		public String getPics() {
			return pics;
		}
		public void setPics(String pics) {
			this.pics = pics;
		}
		public BigDecimal getCumMrPrice() {
			return cumMrPrice;
		}
		public void setCumMrPrice(BigDecimal cumMrPrice) {
			this.cumMrPrice = cumMrPrice;
		}
		public BigDecimal getCumSelectedMrPrice() {
			return cumSelectedMrPrice;
		}
		public void setCumSelectedMrPrice(BigDecimal cumSelectedMrPrice) {
			this.cumSelectedMrPrice = cumSelectedMrPrice;
		}
		public int getCumNoStock() {
			return cumNoStock;
		}
		public void setCumNoStock(int cumNoStock) {
			this.cumNoStock = cumNoStock;
		}
		public int getCumSelectedNoStock() {
			return cumSelectedNoStock;
		}
		public void setCumSelectedNoStock(int cumSelectedNoStock) {
			this.cumSelectedNoStock = cumSelectedNoStock;
		}
		public Map<Long, Item> getItems() {
			return items;
		}
		public void setItems(Map<Long, Item> items) {
			this.items = items;
		}
		public void putItem(Long itemId, Item item) {
			this.items.put(itemId, item);
		}
	}

	static public class Item {
		private long stockItemId;
		private String name;
		private String itemStatus;
		private String itemCondition;
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
		private long checkTs;
		private int checkFlag;

		public long getStockItemId() {
			return stockItemId;
		}
		public void setStockItemId(long stockItemId) {
			this.stockItemId = stockItemId;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
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

		public long getCheckTs() {
			return checkTs;
		}

		public void setCheckTs(long checkTs) {
			this.checkTs = checkTs;
		}

		public int getCheckFlag() {
			return checkFlag;
		}

		public void setCheckFlag(int checkFlag) {
			this.checkFlag = checkFlag;
		}
	}
}
