package udaan.beone.mrpoint.http.util;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

import udaan.beone.mrpoint.http.model.LoginInfoREST;
import udaan.beone.mrpoint.http.model.LoginRequestREST;

/**
 * Created by Vaibhav on 3/11/2016.
 */
public class HTTPConst {

//    public static final String SERVER_DEFAULT_LINK = "http://beonemart/shg-ws";
//    public static final String SERVER_DEFAULT_LINK = "http://198.12.153.113:8080/shg-ws";
    public static final String SERVER_DEFAULT_LINK = "http://192.168.0.xxx/shg-ws";
    public static String SERVER_LINK = SERVER_DEFAULT_LINK;

    public static boolean localIPActive() {
        return (SERVER_DEFAULT_LINK.contains("xxx"));
    }
    public static final String GET_CALL = "GET";
    public static final String PUT_CALL = "PUT";
    public static final String POST_CALL = "POST";
    public static final String DELETE_CALL = "DELETE";

    public static final String AUTH_LOGIN = "Login";
    public static final String AUTH_SELECT_GROUP = "Select Group";

    public static final String MEMBER_GET_ALL_MEMBER_NAMES = "Get All Member Names";

    public static final String ACCOUNT_GET_AUTH_MR_STOCK = "Get Auth Stock";
    public static final String ACCOUNT_GET_AUTH_MR_ACCOUNT = "Get Auth Account";
    public static final String ACCOUNT_GET_OWNER_MR_STOCK = "Get Owner Stock";
    public static final String ACCOUNT_GET_OWNER_MR_ACCOUNT = "Get Owner Account";

    public static final String INV_VERIFY_STOCK_ID = "Verify Item";
    public static final String INV_GET_ALL_ACTIVE_ITEM_TAG_BY_TYPE = "Get All Active Tags By Type";
    public static final String INV_GET_ACTIVE_ITEM_TAG_BY_STOCK_TYPE = "Get Active Tags By StockType";
    public static final String INV_GET_ACTIVE_ITEM_TAG_BY_BRAND_TYPE = "Get Active Tags By Brand";
    public static final String INV_MARK_ITEM_TAGS_PRINTED = "Mark Tags Printed";
    public static final String INV_GET_ALL_LOTS_TO_STOCK = "Get All Lots to Create Items";
    public static final String INV_GET_LOTS_TO_STOCK_FOR_TYPE = "Get All Lots to Create Items By Stock Type";
    public static final String INV_GET_LOTS_TO_STOCK_FOR_BRAND = "Get All Lots to Create Items By Brand";
    public static final String INV_GENERATE_STOCK_FROM_LOTS = "Generate Items from Lots";
    public static final String INV_SEARCH_STOCK_TYPE = "Search Stock Type";
    public static final String INV_SEARCH_BRAND = "Search Brand";
    public static final String INV_GET_LOT = "Get Lot";
    public static final String INV_GET_STOCK_TYPE = "Get Stock Type";
    public static final String INV_GET_BRAND = "Get Brand";
    public static final String INV_GET_STOCK_ITEMS_FOR_TYPE = "Get Items for Type";
    public static final String INV_CREATE_ITEM_TAG_FOR_STOCK_ITEMS = "Create Tags For Items";

    public static final String VISIT_GET_ACTIVE_VISITS_FOR_OWNER = "Get Active Visits for Owner";
    public static final String VISIT_CREATE_VISIT = "Create Visit";
    public static final String VISIT_SCHEDULED_VISIT = "Schedule Visit";
    public static final String VISIT_START_VISIT = "Start Visit";
    public static final String VISIT_END_VISIT = "End Visit";
    public static final String VISIT_GET_STOCK_ITEM = "Get Item";
    public static final String VISIT_CHECK_STOCK_ITEM = "Check Item";
    public static final String VISIT_CHECK_STOCK_ITEMS = "Check Items";
    public static final String VISIT_TRANSFER_STOCK = "Transfer Stock";
    public static final String VISIT_DIRECT_SALE = "Direct Sale";
    public static final String VISIT_GET_OUTSTANDING_PAY_TXS = "Get Open Pay Txs";
    public static final String VISIT_TRANSFER_PAY = "Transfer Pay";
    public static final String VISIT_GET_VISITS_FOR_MEMBER = "Get Visits Account";
    public static final String VISIT_GET_VISITS_FOR_OWNER = "Get Visits Account for Owner";
    public static final String VISIT_GET_VISITS_FOR_AUTH = "Get Visits Account for Auth";
    public static final String VISIT_GET_ALL_VISITS = "Get All Visits";
    public static final String VISIT_GET_VISITS_FOR_OWNER_FOR_ROLE = "Get Visits for Owner with Role";
    public static final String VISIT_GET_VISITS_FOR_AUTH_FOR_ROLE = "Get Visits for Auth with Role";
    public static final String VISIT_DISCOUNT_ITEMS = "Discount Items";
    public static final String VISIT_DISCOUNT_STOCK_TYPE = "Discount Stock Type";
    public static final String VISIT_DISCOUNT_LOT = "Discount Lot";
    public static final String VISIT_GET_TXS_FOR_OWNER_IN_RANGE = "Get Txs For Owner In Range";
    public static final String VISIT_GET_STOCK_TXS_FOR_OWNER_IN_RANGE = "Get Stock Txs For Owner In Range";
    public static final String VISIT_GET_PAY_TXS_FOR_OWNER_IN_RANGE = "Get Pay Txs For Owner In Range";
    public static final String VISIT_GET_VISIT_PRINT_DATA = "Get Visit Print Data";
    public static final String VISIT_GET_VISIT_PRINT_DATA_IN_RANGE = "Get Visit Print Data In Range";

    public static final String ENUM_GET_PRODUCT_PRICING = "ENUM_GET_PRODUCT_PRICING";
    public static final String ENUM_ADD_PRODUCT_PRICING = "ENUM_ADD_PRODUCT_PRICING";
    public static final String ENUM_UPDATE_PRODUCT_PRICING = "ENUM_UPDATE_PRODUCT_PRICING";
    public static final String ENUM_GET_ITEM_CONDITION = "ENUM_GET_ITEM_CONDITION";
    public static final String ENUM_ADD_ITEM_CONDITION = "ENUM_ADD_ITEM_CONDITION";
    public static final String ENUM_UPDATE_ITEM_CONDITION = "ENUM_UPDATE_ITEM_CONDITION";
    public static final String ENUM_GET_PRODUCT_CATEGORY = "ENUM_GET_PRODUCT_CATEGORY";
    public static final String ENUM_GET_PRODUCT_CATEGORY_TREE = "ENUM_GET_PRODUCT_CATEGORY_TREE";
    public static final String ENUM_ADD_PRODUCT_CATEGORY = "ENUM_ADD_PRODUCT_CATEGORY";
    public static final String ENUM_UPDATE_PRODUCT_CATEGORY = "ENUM_UPDATE_PRODUCT_CATEGORY";

}
