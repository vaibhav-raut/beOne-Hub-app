package udaan.beone.mrpoint.http.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class ItemTagO {

	@JsonIgnore
	public static JSONRepo JSONRepo = new JSONRepo<ItemTagO>() {
		@Override
		protected Class<ItemTagO> objectClass() {
			return ItemTagO.class;
		}
	};

	private String tagStatus;
	private String brandName;
	private int itemNos;
	private List<ByType> byTypes;
	
	public String getTagStatus() {
		return tagStatus;
	}
	public void setTagStatus(String tagStatus) {
		this.tagStatus = tagStatus;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public int getItemNos() {
		return itemNos;
	}
	public void setItemNos(int itemNos) {
		this.itemNos = itemNos;
	}
	public List<ByType> getByTypes() {
		return byTypes;
	}
	public void setByTypes(List<ByType> byTypes) {
		this.byTypes = byTypes;
	}
	public void addByType(ByType byType) {
		if(this.byTypes == null) {
			this.byTypes = new ArrayList<ByType>();
		}
		this.byTypes.add(byType);
	}
	
	public static class ByType {

		private long stockTypeId;
		private String tagStatus;
		private String stockTypeName;
		private String brandName;
		private BigDecimal mrpPriceAm;
		private int itemNos;
		private List<ItemTagM> itemTags;
		
		public long getStockTypeId() {
			return stockTypeId;
		}
		public void setStockTypeId(long stockTypeId) {
			this.stockTypeId = stockTypeId;
		}
		public String getTagStatus() {
			return tagStatus;
		}
		public void setTagStatus(String tagStatus) {
			this.tagStatus = tagStatus;
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
		public BigDecimal getMrpPriceAm() {
			return mrpPriceAm;
		}
		public void setMrpPriceAm(BigDecimal mrpPriceAm) {
			this.mrpPriceAm = mrpPriceAm;
		}
		public int getItemNos() {
			return itemNos;
		}
		public void setItemNos(int itemNos) {
			this.itemNos = itemNos;
		}
		public List<ItemTagM> getItemTags() {
			return itemTags;
		}
		public void setItemTags(List<ItemTagM> itemTags) {
			this.itemTags = itemTags;
		}
		public void addItemTag(ItemTagM itemTag) {
			if(this.itemTags == null) {
				this.itemTags = new ArrayList<ItemTagM>();
			}
			this.itemTags.add(itemTag);
		}
	}
}
