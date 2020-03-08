package udaan.beone.mrpoint.http.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import udaan.beone.mrpoint.util.BDUtil;
import udaan.beone.mrpoint.util.DataUtil;

/**
 * Created by Vaibhav on 22-05-2016.
 */
@JsonSerialize
public class StockItemL {

    @JsonIgnore
    public static final JSONRepo JSONRepo = new JSONRepo<StockItemL>() {
        @Override
        protected Class<StockItemL> objectClass() {
            return StockItemL.class;
        }
    };

    private long stockItemId;
    private long stockTypeId;
    private long brandId;
    private long ownerAcNo;
    private String stockItemName;
    private String stockTypeName;
    private String brandName;
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

    public long getOwnerAcNo() {
        return ownerAcNo;
    }

    public void setOwnerAcNo(long ownerAcNo) {
        this.ownerAcNo = ownerAcNo;
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

    public static class StockItemsBunddle {
        private Map<Long, StockItemL> stockItemMap;
        private BigDecimal totalStockMrAm;
        private BigDecimal totalStockMrpAm;
        private BigDecimal discountAm;
        private int totalStockNo;

        public Map<Long, StockItemL> getStockItemMap() {
            return stockItemMap;
        }
        public void setStockItemMap(Map<Long, StockItemL> stockItemMap) {
            this.stockItemMap = stockItemMap;
        }
        public BigDecimal getTotalStockMrAm() {
            return totalStockMrAm;
        }
        public void setTotalStockMrAm(BigDecimal totalStockMrAm) {
            this.totalStockMrAm = totalStockMrAm;
        }
        public BigDecimal getTotalStockMrpAm() {
            return totalStockMrpAm;
        }
        public void setTotalStockMrpAm(BigDecimal totalStockMrpAm) {
            this.totalStockMrpAm = totalStockMrpAm;
        }
        public BigDecimal getDiscountAm() {
            return discountAm;
        }
        public void setDiscountAm(BigDecimal discountAm) {
            this.discountAm = discountAm;
        }
        public int getTotalStockNo() {
            return totalStockNo;
        }
        public void setTotalStockNo(int totalStockNo) {
            this.totalStockNo = totalStockNo;
        }
        public void clear() {
            stockItemMap.clear();
            totalStockMrAm = null;
            totalStockMrpAm = null;
            discountAm = null;
        }
    }

    public static StockItemsBunddle buildMrStockDisplay(MrStock mrStock) {

        StockItemsBunddle bunddle = new StockItemsBunddle();

        Map<Long, StockItemL> stockItemMap = new HashMap<Long, StockItemL>();
        BigDecimal totalStockMrAm = DataUtil.ZERO_BIG_DECIMAL;
        BigDecimal totalStockMrpAm = DataUtil.ZERO_BIG_DECIMAL;
        BigDecimal discountAm = DataUtil.ZERO_BIG_DECIMAL;
        int totalStockNo = 0;

        long ownerAcNo = mrStock.getOwnerAcNo();

        for(MrStock.ByBrand brand: mrStock.getBrands().values()) {

            long brandId = brand.getBrandId();
            String brandName = brand.getName();

            for(MrStock.ByType type: brand.getTypes().values()) {

                long stockTypeId = type.getStockTypeId();
                String stockTypeName = type.getName();

                for(MrStock.Item item : type.getItems().values()) {

                    StockItemL itemL = new StockItemL();

                    itemL.setStockItemId(item.getStockItemId());
                    itemL.setStockTypeId(stockTypeId);
                    itemL.setBrandId(brandId);
                    itemL.setOwnerAcNo(ownerAcNo);
                    itemL.setStockItemName(item.getName());
                    itemL.setStockTypeName(stockTypeName);
                    itemL.setItemCondition(item.getItemCondition());
                    itemL.setDesignNo(item.getDesignNo());
                    itemL.setWsPrice(item.getWsPrice());
                    itemL.setBrandName(brandName);
                    itemL.setItemStatus(item.getItemStatus());

                    itemL.setMrPrice(item.getMrPrice());
                    itemL.setDisMrPrice(item.getDisMrPrice());
                    itemL.setMrpPrice(item.getMrpPrice());
                    itemL.setDisMrpPrice(item.getDisMrpPrice());
                    itemL.setSoldPrice(item.getSoldPrice());
                    itemL.setMrSoldPrice(item.getMrSoldPrice());
                    itemL.setDiscountPer(item.getDiscountPer());
                    itemL.setDiscountAm(item.getDiscountAm());
                    itemL.setVatPer(item.getVatPer());
                    itemL.setVatAm(item.getVatAm());
                    itemL.setCheckTs(item.getCheckTs());
                    itemL.setCheckFlag(item.getCheckFlag());

                    stockItemMap.put(item.getStockItemId(), itemL);

                    totalStockMrAm = BDUtil.add(totalStockMrAm, item.getDisMrPrice());
                    totalStockMrpAm = BDUtil.add(totalStockMrpAm, item.getDisMrpPrice());
                    discountAm = BDUtil.add(discountAm, item.getDiscountAm());
                    totalStockNo++;
                }
            }
        }

        bunddle.setStockItemMap(stockItemMap);
        bunddle.setTotalStockMrAm(totalStockMrAm);
        bunddle.setTotalStockMrpAm(totalStockMrpAm);
        bunddle.setDiscountAm(discountAm);
        bunddle.setTotalStockNo(totalStockNo);

        return bunddle;
    }
}
