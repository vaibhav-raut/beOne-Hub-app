package udaan.beone.mrpoint.util;

public class EnumConst {

	public static final long SystemAcNo = 1000010001l;

	public static final int CheckFlag_Unchecked = 0;
	public static final int CheckFlag_Checked = 1;
	public static final int CheckFlag_Missing = 2;
	public static final int CheckFlag_Sold = 3;
	
	public static final String MrStat_Titel_Total = "Total";
	public static final String MrStat_Titel_This_Month = "This Month";
	public static final String MrStat_Titel_Last_Month = "Last Month";
	
	public static final String MANUFACTURER_CSV = "MANUFACTURER_CSV";
	public static final String BRAND_CSV = "BRAND_CSV";
	public static final String STOCK_TYPE_CSV = "STOCK_TYPE_CSV";
	public static final String PURCHASE_INVOICE_CSV = "PURCHASE_INVOICE_CSV";
	public static final String LOT_CSV = "LOT_CSV";
	public static final String MEMBERS_CSV = "MEMBERS_CSV";

	
	// All Enum Name 
	public static final String ItemCondition = "ItemCondition";
	public static final String InvoiceStatus = "InvoiceStatus";
	public static final String ItemStatus = "ItemStatus";
	public static final String LotStatus = "LotStatus";
	public static final String MrStatus = "MrStatus";
	public static final String MrType = "MrType";
	public static final String PaymentType = "PaymentType";
	public static final String PkgStatus = "PkgStatus";
	public static final String PkgType = "PkgType";
	public static final String ProductCategory = "ProductCategory";
	public static final String ProductPricing = "ProductPricing";
	public static final String ShipmentStatus = "ShipmentStatus";
	public static final String StockTxType = "StockTxType";
	public static final String StockTypeStatus = "StockTypeStatus";
	public static final String TagStatus = "TagStatus";
	public static final String VisitStatus = "VisitStatus";
	public static final String VisitType = "VisitType";

	// ItemCondition Enum Name 
	public static final String ItemCondition_Fresh = "Fresh";
	public static final String ItemCondition_Discount = "Discount";
	public static final String ItemCondition_DamageLevel = "DamageLevel";

	// InvoiceStatus Enum Name 
	public static final String InvoiceStatus_Draft = "Draft";
	public static final String InvoiceStatus_Quotation = "Quotation";
	public static final String InvoiceStatus_Ordered = "Ordered";
	public static final String InvoiceStatus_Processing = "Processing";
	public static final String InvoiceStatus_Shipped = "Shipped";
	public static final String InvoiceStatus_Delivered = "Delivered";
	public static final String InvoiceStatus_To_Stock = "To Stock";
	public static final String InvoiceStatus_Complete = "Complete";
	public static final String InvoiceStatus_Cancelled = "Cancelled";

	// ItemStatus Enum Name 
	public static final String ItemStatus_Created = "Created";
	public static final String ItemStatus_Stocked = "Stocked";
	public static final String ItemStatus_Discarded = "Discarded";
	public static final String ItemStatus_Lost = "Lost";
	public static final String ItemStatus_Sold = "Sold";
	public static final String ItemStatus_Mark_Sold = "Mark Sold";
	public static final String ItemStatus_Damaged = "Damaged";
	public static final String ItemStatus_Damage_Returned = "Damage Returned";
	public static final String ItemStatus_Damage_Sold = "Damage Sold";

	// LotStatus Enum Name 
	public static final String LotStatus_Draft = "Draft";
	public static final String LotStatus_Quotation = "Quotation";
	public static final String LotStatus_Ordered = "Ordered";
	public static final String LotStatus_Processing = "Processing";
	public static final String LotStatus_Shipped = "Shipped";
	public static final String LotStatus_Delivered = "Delivered";
	public static final String LotStatus_To_Stock = "To Stock";
	public static final String LotStatus_Created = "Created";
	public static final String LotStatus_Stocked = "Stocked";
	public static final String LotStatus_Sold_Out = "Sold Out";
	public static final String LotStatus_Cancelled = "Cancelled";

	// PaymentType Enum Name 
	public static final String PaymentType_x = "x";

	// PkgStatus Enum Name 
	public static final String PkgStatus_x = "x";

	// PkgType Enum Name 
	public static final String PkgType_x = "x";

	// ProductCategory Enum Name 
	public static final String ProductCategory_x = "x";

	// ProductPricing Enum Name 
	public static final String ProductPricing_Default = "Default";

	// ShipmentStatus Enum Name 
	public static final String ShipmentStatus_x = "x";

	// StockTxType Enum Name 
	public static final String StockTxType_Created = "Created";
	public static final String StockTxType_Stock_Verified = "Stock Verified";
	public static final String StockTxType_Given = "Given";
	public static final String StockTxType_Returned = "Returned";
	public static final String StockTxType_Sold = "Sold";
	public static final String StockTxType_Check = "Check";
	public static final String StockTxType_Damage_Returned = "Damage Returned";
	public static final String StockTxType_Damage_Sold = "Damage Sold";
	public static final String StockTxType_Damaged = "Damaged";
	public static final String StockTxType_Payment = "Payment";
	public static final String StockTxType_Sold_Paid = "Sold Paid";
	public static final String StockTxType_Collection_Paid = "Collection Paid";
	public static final String StockTxType_Registration_Fee = "Registration Fee";
	public static final String StockTxType_Deposit = "Deposit";
	public static final String StockTxType_Return_Deposit = "Return Deposit";
	public static final String StockTxType_Cash_Deposit = "Cash Deposit";
	public static final String StockTxType_Cash_Advance = "Cash Advance";
	public static final String StockTxType_Interest_Penalty = "Interest Penalty";
	public static final String StockTxType_Late_Fee = "Late Fee";
	public static final String StockTxType_Other_Fee = "Other Fee";

	// StockTypeStatus Enum Name 
	public static final String StockTypeStatus_Created = "Created";
	public static final String StockTypeStatus_Stocked = "Stocked";
	public static final String StockTypeStatus_Sold_Out = "Sold Out";
	public static final String StockTypeStatus_Sold_Out_Closed = "Sold Out Closed";
	
	// MRole for MR
	public static final String MRole_Udaan_Admin = "Udaan Admin";
	public static final String MRole_Mega_HUB_Manager = "Mega HUB Manager";
	public static final String MRole_Local_HUB_Manager = "Local HUB Manager";
	public static final String MRole_Sub_Local_HUB_Manager = "Sub Local HUB Manager";
	public static final String MRole_Sales_Executive = "Sales Executive";
	public static final String MRole_Super_Sales_Executive = "Super Sales Executive";
	public static final String MRole_Micro_Retailer = "Micro Retailer";

	// GroupType Enum Values
	public static final String GroupType_Udaan_Admin = "Udaan Admin";
	public static final String GroupType_Mega_HUB = "Mega HUB";
	public static final String GroupType_Local_HUB = "Local HUB";
	public static final String GroupType_Sub_Local_HUB = "Sub Local HUB";
	public static final String GroupType_Manufacturer = "Manufacturer";
	public static final String GroupType_Micro_Retailer = "Micro Retailer";
	public static final String GroupType_Sales_Executive = "Sales Executive";
	
	// TagStatus Enum Values
	public static final String TagStatus_Created = "Created";
	public static final String TagStatus_Printed = "Printed";
	public static final String TagStatus_Canceled = "Canceled";
	
	// VisitStatus Enum Values
	public static final String VisitStatus_Requested = "Requested";
	public static final String VisitStatus_Expected = "Expected";
	public static final String VisitStatus_Scheduled = "Scheduled";
	public static final String VisitStatus_Unscheduled = "Unscheduled";
	public static final String VisitStatus_Started = "Started";
	public static final String VisitStatus_Ended = "Ended";
	public static final String VisitStatus_Auto_Closed = "Auto Closed";
	public static final String VisitStatus_Not_Available = "Not Available";
	public static final String VisitStatus_Missed = "Missed";
	public static final String VisitStatus_Canceled = "Canceled";
	
	// VisitType Enum Values
	public static final String VisitType_MR_Pitch_Visit = "MR Pitch Visit";
	public static final String VisitType_Scheduled_MR_Visit = "Scheduled MR Visit";
	public static final String VisitType_Requested_MR_Visit = "Requested MR Visit";
	public static final String VisitType_Delivery_MR_Visit = "Delivery MR Visit";
	public static final String VisitType_Feedback_MR_Visit = "Feedback MR Visit";
	public static final String VisitType_Special_MR_Visit = "Special MR Visit";
	public static final String VisitType_Opening_MR_Account = "Opening MR Account";
	public static final String VisitType_Closing_MR_Account = "Closing MR Account";
	public static final String VisitType_SE_Account = "SE Account";
	public static final String VisitType_SSE_Account = "SSE Account";
	public static final String VisitType_Sub_Local_HUB = "Sub Local HUB";
	public static final String VisitType_Local_HUB = "Local HUB";
	public static final String VisitType_Direct_Sold = "Direct Sold";

	// MrStatus Enum Values
	public static final String MrStatus_Non_MR = "Non MR";
	public static final String MrStatus_Introduction = "Introduction";
	public static final String MrStatus_Interested = "Interested";
	public static final String MrStatus_Opening = "Opening";
	public static final String MrStatus_Submitted = "Submitted";
	public static final String MrStatus_Active = "Active";
	public static final String MrStatus_Inactive = "Inactive";
	public static final String MrStatus_Tobe_Closed = "Tobe Closed";
	public static final String MrStatus_Closed = "Closed";
	public static final String MrStatus_Disqualified = "Disqualified";
	public static final String MrStatus_Canceled = "Canceled";
	
	// MrType Enum Values
	public static final String MrType_Non_MR = "Non MR";
	public static final String MrType_Normal = "Normal";
	public static final String MrType_Discounted = "Discounted";
	public static final String MrType_Close_Circle = "Close Circle";

	public static boolean isVisitTypeNonMr(String visitType) {
		return (visitType.equals(VisitType_SE_Account) ||
				visitType.equals(VisitType_SSE_Account) ||
				visitType.equals(VisitType_Sub_Local_HUB) ||
				visitType.equals(VisitType_Local_HUB));
	}

}
