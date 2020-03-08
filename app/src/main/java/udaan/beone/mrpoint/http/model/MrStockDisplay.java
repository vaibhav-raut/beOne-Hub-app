package udaan.beone.mrpoint.http.model;


import android.os.Parcelable;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class MrStockDisplay {

	private long ownerAcNo;
	private String ownerAcNoName;
	private BigDecimal cumMrPrice;
	private BigDecimal cumSelectedMrPrice;
	private int cumNoStock;
	private int cumSelectedNoStock;
	private List<MrStockDisplayItem> displayItems;

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

	public List<MrStockDisplayItem> getDisplayItems() {
		return displayItems;
	}

	public void setDisplayItems(List<MrStockDisplayItem> displayItems) {
		this.displayItems = displayItems;
	}

	public void addDisplayItem(MrStockDisplayItem displayItem) {
		if(this.displayItems == null) {
			this.displayItems = new ArrayList<MrStockDisplayItem>();
		}
		this.displayItems.add(displayItem);
	}

	public static class MrStockDisplayItem {

		private String brand;
		private String stockType;
		private String category;
		private String pics;
		private BigDecimal cumMrPrice;
		private int cumNoStock;
		private BigDecimal mrPrice;
		private BigDecimal mrpPrice;
		private BigDecimal disMrpPrice;
		private ArrayList<ItemDisplay> itemDisplays;

		public String getBrand() {
			return brand;
		}

		public void setBrand(String brand) {
			this.brand = brand;
		}

		public String getStockType() {
			return stockType;
		}

		public void setStockType(String stockType) {
			this.stockType = stockType;
		}

		public String getCategory() {
			return category;
		}

		public void setCategory(String category) {
			this.category = category;
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

		public int getCumNoStock() {
			return cumNoStock;
		}

		public void setCumNoStock(int cumNoStock) {
			this.cumNoStock = cumNoStock;
		}

		public BigDecimal getMrPrice() {
			return mrPrice;
		}

		public void setMrPrice(BigDecimal mrPrice) {
			this.mrPrice = mrPrice;
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

		public ArrayList<ItemDisplay> getItemDisplays() {
			return itemDisplays;
		}

		public void setItemDisplays(ArrayList<ItemDisplay> itemDisplays) {
			this.itemDisplays = itemDisplays;
		}

		public void addItemDisplay(ItemDisplay itemDisplay) {
			if(this.itemDisplays == null) {
				this.itemDisplays = new ArrayList<ItemDisplay>();
			}
			this.itemDisplays.add(itemDisplay);
		}
	}

	public static class ItemDisplay {
		private long stockItemId;
		private String stockType;
		private String brand;
		private String itemStatus;
		private String itemCondition;
		private String designNo;
		private BigDecimal mrPrice;
		private BigDecimal mrpPrice;

		public long getStockItemId() {
			return stockItemId;
		}

		public void setStockItemId(long stockItemId) {
			this.stockItemId = stockItemId;
		}

		public String getStockType() {
			return stockType;
		}

		public void setStockType(String stockType) {
			this.stockType = stockType;
		}

		public String getBrand() {
			return brand;
		}

		public void setBrand(String brand) {
			this.brand = brand;
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

		public BigDecimal getMrPrice() {
			return mrPrice;
		}

		public void setMrPrice(BigDecimal mrPrice) {
			this.mrPrice = mrPrice;
		}

		public BigDecimal getMrpPrice() {
			return mrpPrice;
		}

		public void setMrpPrice(BigDecimal mrpPrice) {
			this.mrpPrice = mrpPrice;
		}
	}

	public static MrStockDisplay buildMrStockDisplay(MrStock mrStock) {

		MrStockDisplay mrStockDisplay = new MrStockDisplay();

		mrStockDisplay.setOwnerAcNo(mrStock.getOwnerAcNo());
		mrStockDisplay.setOwnerAcNoName(mrStock.getOwnerAcNoName());
		mrStockDisplay.setCumMrPrice(mrStock.getCumMrPrice());
		mrStockDisplay.setCumSelectedMrPrice(mrStock.getCumSelectedMrPrice());
		mrStockDisplay.setCumNoStock(mrStock.getCumNoStock());
		mrStockDisplay.setCumSelectedNoStock(mrStock.getCumSelectedNoStock());

		for(MrStock.ByBrand brand: mrStock.getBrands().values()) {

			String brandName = brand.getName();

			for(MrStock.ByType type: brand.getTypes().values()) {

				MrStockDisplayItem displayItem = new MrStockDisplayItem();
				displayItem.setBrand(brandName);
				displayItem.setStockType(type.getName());
				displayItem.setCategory(type.getCategory());
				displayItem.setPics(type.getPics());
				displayItem.setCumMrPrice(type.getCumMrPrice());
				displayItem.setCumNoStock(type.getCumNoStock());
				boolean infoToFilled = true;

				for(MrStock.Item item : type.getItems().values()) {

					if(infoToFilled) {
						displayItem.setMrPrice(item.getDisMrPrice());
						displayItem.setMrpPrice(item.getDisMrpPrice());
						displayItem.setDisMrpPrice(item.getDisMrpPrice());
						infoToFilled = false;
					}
					ItemDisplay itemDisplay = new ItemDisplay();

					itemDisplay.setStockItemId(item.getStockItemId());
					itemDisplay.setStockType(item.getName());
					itemDisplay.setBrand(brandName);
					itemDisplay.setItemStatus(item.getItemStatus());
					itemDisplay.setItemCondition(item.getItemCondition());
					itemDisplay.setDesignNo(item.getDesignNo());
					itemDisplay.setMrPrice(item.getDisMrPrice());
					itemDisplay.setMrpPrice(item.getDisMrpPrice());

					displayItem.addItemDisplay(itemDisplay);
				}
				mrStockDisplay.addDisplayItem(displayItem);
			}
		}

		return mrStockDisplay;
	}
}
