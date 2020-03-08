package udaan.beone.mrpoint.http.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class BrandName {

	@JsonIgnore
	public static final JSONRepo JSONRepo = new JSONRepo<BrandName>() {
		@Override
		protected Class<BrandName> objectClass() {
			return BrandName.class;
		}
	};

	private long brandId;
	private String brandName;
	private long manufactureAcNo;
	private String manufactureName;
	
	public BrandName() {
		super();
	}
	public BrandName(long brandId, String brandName, long manufactureAcNo,
			String manufactureName) {
		super();
		this.brandId = brandId;
		this.brandName = brandName;
		this.manufactureAcNo = manufactureAcNo;
		this.manufactureName = manufactureName;
	}
	
	public long getBrandId() {
		return brandId;
	}
	public void setBrandId(long brandId) {
		this.brandId = brandId;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public long getManufactureAcNo() {
		return manufactureAcNo;
	}
	public void setManufactureAcNo(long manufactureAcNo) {
		this.manufactureAcNo = manufactureAcNo;
	}
	public String getManufactureName() {
		return manufactureName;
	}
	public void setManufactureName(String manufactureName) {
		this.manufactureName = manufactureName;
	}
}
