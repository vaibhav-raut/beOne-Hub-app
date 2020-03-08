package udaan.beone.mrpoint.http.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;

public class Lot {

	@JsonIgnore
	public static final JSONRepo JSONRepo = new JSONRepo<Lot>() {
		@Override
		protected Class<Lot> objectClass() {
			return Lot.class;
		}
	};

	private long lotId;
	private long invoiceId;
	private long stockTypeId;
	private String lotStatus;
	private String name;
	private int noPerSet;
	private int noOfSets;
	private int noPurchased;
	private int noDelivered;
	private int noToStock;
	private int noCreated;
	private int noStocked;
	private int noSold;
	private int noDamaged;
	private BigDecimal itemPriceAm;
	private BigDecimal lotPriceAm;
	private float discountPer;
	private BigDecimal discountAm;
	private BigDecimal vatAm;
	private BigDecimal avgMrItemSoldAm;
	private int returnCounter;
	private float performanceIndex;
	private float returnIndex;
	private float salesIndex;
	private float sales20PerDays;
	private float sales40PerDays;
	private float sales60PerDays;
	private float sales80PerDays;
	private float sales100PerDays;
	
	public long getLotId() {
		return lotId;
	}
	public void setLotId(long lotId) {
		this.lotId = lotId;
	}

	public long getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(long invoiceId) {
		this.invoiceId = invoiceId;
	}

	public long getStockTypeId() {
		return stockTypeId;
	}
	public void setStockTypeId(long stockTypeId) {
		this.stockTypeId = stockTypeId;
	}
	public String getLotStatus() {
		return lotStatus;
	}
	public void setLotStatus(String lotStatus) {
		this.lotStatus = lotStatus;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNoPerSet() {
		return noPerSet;
	}
	public void setNoPerSet(int noPerSet) {
		this.noPerSet = noPerSet;
	}
	public int getNoOfSets() {
		return noOfSets;
	}
	public void setNoOfSets(int noOfSets) {
		this.noOfSets = noOfSets;
	}
	public int getNoPurchased() {
		return noPurchased;
	}
	public void setNoPurchased(int noPurchased) {
		this.noPurchased = noPurchased;
	}
	public int getNoDelivered() {
		return noDelivered;
	}
	public void setNoDelivered(int noDelivered) {
		this.noDelivered = noDelivered;
	}
	public int getNoToStock() {
		return noToStock;
	}
	public void setNoToStock(int noToStock) {
		this.noToStock = noToStock;
	}
	public int getNoCreated() {
		return noCreated;
	}
	public void setNoCreated(int noCreated) {
		this.noCreated = noCreated;
	}
	public int getNoStocked() {
		return noStocked;
	}
	public void setNoStocked(int noStocked) {
		this.noStocked = noStocked;
	}
	public int getNoSold() {
		return noSold;
	}
	public void setNoSold(int noSold) {
		this.noSold = noSold;
	}
	public int getNoDamaged() {
		return noDamaged;
	}
	public void setNoDamaged(int noDamaged) {
		this.noDamaged = noDamaged;
	}
	public BigDecimal getItemPriceAm() {
		return itemPriceAm;
	}
	public void setItemPriceAm(BigDecimal itemPriceAm) {
		this.itemPriceAm = itemPriceAm;
	}
	public BigDecimal getLotPriceAm() {
		return lotPriceAm;
	}
	public void setLotPriceAm(BigDecimal lotPriceAm) {
		this.lotPriceAm = lotPriceAm;
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
	public BigDecimal getVatAm() {
		return vatAm;
	}
	public void setVatAm(BigDecimal vatAm) {
		this.vatAm = vatAm;
	}
	public BigDecimal getAvgMrItemSoldAm() {
		return avgMrItemSoldAm;
	}
	public void setAvgMrItemSoldAm(BigDecimal avgMrItemSoldAm) {
		this.avgMrItemSoldAm = avgMrItemSoldAm;
	}
	public int getReturnCounter() {
		return returnCounter;
	}
	public void setReturnCounter(int returnCounter) {
		this.returnCounter = returnCounter;
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
	public float getSales20PerDays() {
		return sales20PerDays;
	}
	public void setSales20PerDays(float sales20PerDays) {
		this.sales20PerDays = sales20PerDays;
	}
	public float getSales40PerDays() {
		return sales40PerDays;
	}
	public void setSales40PerDays(float sales40PerDays) {
		this.sales40PerDays = sales40PerDays;
	}
	public float getSales60PerDays() {
		return sales60PerDays;
	}
	public void setSales60PerDays(float sales60PerDays) {
		this.sales60PerDays = sales60PerDays;
	}
	public float getSales80PerDays() {
		return sales80PerDays;
	}
	public void setSales80PerDays(float sales80PerDays) {
		this.sales80PerDays = sales80PerDays;
	}
	public float getSales100PerDays() {
		return sales100PerDays;
	}
	public void setSales100PerDays(float sales100PerDays) {
		this.sales100PerDays = sales100PerDays;
	}

	public static LotS buildLotS(Lot lot) {
		LotS lotS = new LotS();

		lotS.setLotId(lot.getLotId());
		lotS.setInvoiceId(lot.getInvoiceId());
		lotS.setStockTypeId(lot.getStockTypeId());
		lotS.setLotStatus(lot.getLotStatus());
		lotS.setName(lot.getName());
		lotS.setNoToStock(lot.getNoToStock());

		return lotS;
	}

	public static LotS buildLotSToGenerate(Lot lot) {
		LotS lotS = buildLotS(lot);
		lotS.setNoToStock(lot.getNoDamaged());

		return lotS;
	}
	public static class LotS {

		@JsonIgnore
		public static final JSONRepo JSONRepo = new JSONRepo<LotS>() {
			@Override
			protected Class<LotS> objectClass() {
				return LotS.class;
			}
		};

		private long lotId;
		private long invoiceId;
		private long stockTypeId;
		private String lotStatus;
		private String name;
		private int noToStock;

		public long getLotId() {
			return lotId;
		}

		public void setLotId(long lotId) {
			this.lotId = lotId;
		}

		public long getInvoiceId() {
			return invoiceId;
		}

		public void setInvoiceId(long invoiceId) {
			this.invoiceId = invoiceId;
		}

		public long getStockTypeId() {
			return stockTypeId;
		}

		public void setStockTypeId(long stockTypeId) {
			this.stockTypeId = stockTypeId;
		}

		public String getLotStatus() {
			return lotStatus;
		}

		public void setLotStatus(String lotStatus) {
			this.lotStatus = lotStatus;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getNoToStock() {
			return noToStock;
		}

		public void setNoToStock(int noToStock) {
			this.noToStock = noToStock;
		}
	}
}
