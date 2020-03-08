package udaan.beone.mrpoint.http.util;

import udaan.beone.mrpoint.data.DataManager;
import udaan.beone.mrpoint.http.model.LoginInfoREST;
import udaan.beone.mrpoint.http.model.MemberSearchInfo;
import udaan.beone.mrpoint.http.model.MrAccount;
import udaan.beone.mrpoint.http.model.MrStock;
import udaan.beone.mrpoint.http.model.MrVisit;

/**
 * Created by Vaibhav on 3/11/2016.
 */
public class HTTPUtil {

    public static String getCallURL(String call) {
        String url = "";

        switch (call) {

            case HTTPConst.AUTH_LOGIN:
                url = HTTPConst.SERVER_LINK + "/auth/v1/login";
                break;

            case HTTPConst.AUTH_SELECT_GROUP:
                url = HTTPConst.SERVER_LINK + "/auth/v1/select_group";
                break;

            case HTTPConst.MEMBER_GET_ALL_MEMBER_NAMES:
                url = HTTPConst.SERVER_LINK + "/member/v1/all_member_search_by_name";
//                url = HTTPConst.SERVER_LINK + "/member/v1/all_member_search";
                break;

            case HTTPConst.ACCOUNT_GET_AUTH_MR_STOCK:
                url = HTTPConst.SERVER_LINK + "/mr/account/v1/get_mr_stock";
                break;

            case HTTPConst.ACCOUNT_GET_AUTH_MR_ACCOUNT:
                url = HTTPConst.SERVER_LINK + "/mr/account/v1/get_mr_account";
                break;

            case HTTPConst.ACCOUNT_GET_OWNER_MR_STOCK:
                url = HTTPConst.SERVER_LINK + "/mr/account/v1/get_mr_stock";
                break;

            case HTTPConst.ACCOUNT_GET_OWNER_MR_ACCOUNT:
                url = HTTPConst.SERVER_LINK + "/mr/account/v1/get_mr_account";
                break;

            case HTTPConst.INV_VERIFY_STOCK_ID:
                url = HTTPConst.SERVER_LINK + "/mr/inventory/v1/verify_stock_id";
                break;

            case HTTPConst.INV_GET_ALL_ACTIVE_ITEM_TAG_BY_TYPE:
                url = HTTPConst.SERVER_LINK + "/mr/inventory/v1/get_all_active_item_tag_by_type";
                break;

            case HTTPConst.INV_GET_ACTIVE_ITEM_TAG_BY_STOCK_TYPE:
                url = HTTPConst.SERVER_LINK + "/mr/inventory/v1/get_active_item_tag_by_stock_type";
                break;

            case HTTPConst.INV_GET_ACTIVE_ITEM_TAG_BY_BRAND_TYPE:
                url = HTTPConst.SERVER_LINK + "/mr/inventory/v1/get_active_item_tag_by_brand";
                break;

            case HTTPConst.INV_MARK_ITEM_TAGS_PRINTED:
                url = HTTPConst.SERVER_LINK + "/mr/inventory/v1/mark_item_tags_printed";
                break;

            case HTTPConst.INV_GET_ALL_LOTS_TO_STOCK:
                url = HTTPConst.SERVER_LINK + "/mr/inventory/v1/get_all_lots_to_stock";
                break;

            case HTTPConst.INV_GET_LOTS_TO_STOCK_FOR_TYPE:
                url = HTTPConst.SERVER_LINK + "/mr/inventory/v1/get_lots_to_stock_for_type";
                break;

            case HTTPConst.INV_GET_LOTS_TO_STOCK_FOR_BRAND:
                url = HTTPConst.SERVER_LINK + "/mr/inventory/v1/get_lots_to_stock_for_brand";
                break;

            case HTTPConst.INV_GENERATE_STOCK_FROM_LOTS:
                url = HTTPConst.SERVER_LINK + "/mr/inventory/v1/generate_stock_from_lots";
                break;

            case HTTPConst.INV_SEARCH_STOCK_TYPE:
                url = HTTPConst.SERVER_LINK + "/mr/inventory/v1/search_stock_type";
                break;

            case HTTPConst.INV_SEARCH_BRAND:
                url = HTTPConst.SERVER_LINK + "/mr/inventory/v1/search_brand";
                break;

            case HTTPConst.INV_GET_LOT:
                url = HTTPConst.SERVER_LINK + "/mr/inventory/v1/get_lot";
                break;

            case HTTPConst.INV_GET_STOCK_TYPE:
                url = HTTPConst.SERVER_LINK + "/mr/inventory/v1/get_stock_type";
                break;

            case HTTPConst.INV_GET_BRAND:
                url = HTTPConst.SERVER_LINK + "/mr/inventory/v1/get_brand";
                break;

            case HTTPConst.INV_GET_STOCK_ITEMS_FOR_TYPE:
                url = HTTPConst.SERVER_LINK + "/mr/inventory/v1/get_stock_items_for_type";
                break;

            case HTTPConst.INV_CREATE_ITEM_TAG_FOR_STOCK_ITEMS:
                url = HTTPConst.SERVER_LINK + "/mr/inventory/v1/create_item_tag_for_stock_items";
                break;

            case HTTPConst.VISIT_GET_ACTIVE_VISITS_FOR_OWNER:
                url = HTTPConst.SERVER_LINK + "/mr/visit/v1/get_active_visits_for_owner";
                break;

            case HTTPConst.VISIT_CREATE_VISIT:
                url = HTTPConst.SERVER_LINK + "/mr/visit/v1/create_visit";
                break;

            case HTTPConst.VISIT_SCHEDULED_VISIT:
                url = HTTPConst.SERVER_LINK + "/mr/visit/v1/scheduled_visit";
                break;

            case HTTPConst.VISIT_START_VISIT:
                url = HTTPConst.SERVER_LINK + "/mr/visit/v1/start_visit";
                break;

            case HTTPConst.VISIT_END_VISIT:
                url = HTTPConst.SERVER_LINK + "/mr/visit/v1/end_visit";
                break;

            case HTTPConst.VISIT_GET_STOCK_ITEM:
                url = HTTPConst.SERVER_LINK + "/mr/visit/v1/get_stock_item";
                break;

            case HTTPConst.VISIT_CHECK_STOCK_ITEM:
                url = HTTPConst.SERVER_LINK + "/mr/visit/v1/check_stock_item";
                break;

            case HTTPConst.VISIT_CHECK_STOCK_ITEMS:
                url = HTTPConst.SERVER_LINK + "/mr/visit/v1/check_stock_items";
                break;

            case HTTPConst.VISIT_TRANSFER_STOCK:
                url = HTTPConst.SERVER_LINK + "/mr/visit/v1/transfer_stock";
                break;

            case HTTPConst.VISIT_DIRECT_SALE:
                url = HTTPConst.SERVER_LINK + "/mr/visit/v1/direct_sold";
                break;

            case HTTPConst.VISIT_GET_OUTSTANDING_PAY_TXS:
                url = HTTPConst.SERVER_LINK + "/mr/visit/v1/get_outstanding_pay_txs";
                break;

            case HTTPConst.VISIT_TRANSFER_PAY:
                url = HTTPConst.SERVER_LINK + "/mr/visit/v1/transfer_pay";
                break;

            case HTTPConst.VISIT_GET_VISITS_FOR_MEMBER:
                url = HTTPConst.SERVER_LINK + "/mr/account/v1/get_all_visits_for_member";
                break;

            case HTTPConst.VISIT_GET_VISITS_FOR_OWNER:
                url = HTTPConst.SERVER_LINK + "/mr/account/v1/get_visits_for_owner";
                break;

            case HTTPConst.VISIT_GET_VISITS_FOR_AUTH:
                url = HTTPConst.SERVER_LINK + "/mr/account/v1/get_visits_for_auth";
                break;

            case HTTPConst.VISIT_GET_ALL_VISITS:
                url = HTTPConst.SERVER_LINK + "/mr/account/v1/get_all_visits";
                break;

            case HTTPConst.VISIT_GET_VISITS_FOR_OWNER_FOR_ROLE:
                url = HTTPConst.SERVER_LINK + "/mr/account/v1/get_visits_for_owner_for_role";
                break;

            case HTTPConst.VISIT_GET_VISITS_FOR_AUTH_FOR_ROLE:
                url = HTTPConst.SERVER_LINK + "/mr/account/v1/get_visits_for_auth_for_role";
                break;

            case HTTPConst.VISIT_DISCOUNT_ITEMS:
                url = HTTPConst.SERVER_LINK + "/mr/visit/v1/discount_items";
                break;

            case HTTPConst.VISIT_DISCOUNT_STOCK_TYPE:
                url = HTTPConst.SERVER_LINK + "/mr/visit/v1/discount_stock_type";
                break;

            case HTTPConst.VISIT_DISCOUNT_LOT:
                url = HTTPConst.SERVER_LINK + "/mr/visit/v1/discount_lot";
                break;

            case HTTPConst.VISIT_GET_TXS_FOR_OWNER_IN_RANGE:
                url = HTTPConst.SERVER_LINK + "/mr/visit/v1/get_txs_for_owner_in_range";
                break;

            case HTTPConst.VISIT_GET_STOCK_TXS_FOR_OWNER_IN_RANGE:
                url = HTTPConst.SERVER_LINK + "/mr/visit/v1/get_stock_txs_for_owner_in_range";
                break;

            case HTTPConst.VISIT_GET_PAY_TXS_FOR_OWNER_IN_RANGE:
                url = HTTPConst.SERVER_LINK + "/mr/visit/v1/get_pay_txs_for_owner_in_range";
                break;

            case HTTPConst.VISIT_GET_VISIT_PRINT_DATA:
                url = HTTPConst.SERVER_LINK + "/mr/visit/v1/get_visit_print_data";
                break;

            case HTTPConst.VISIT_GET_VISIT_PRINT_DATA_IN_RANGE:
                url = HTTPConst.SERVER_LINK + "/mr/visit/v1/get_visit_print_data_in_range";
                break;

            case HTTPConst.ENUM_GET_PRODUCT_PRICING:
                url = HTTPConst.SERVER_LINK + "/mr/enum/v1/product_pricing";
                break;

            case HTTPConst.ENUM_ADD_PRODUCT_PRICING:
                url = HTTPConst.SERVER_LINK + "/mr/enum/v1/product_pricing";
                break;

            case HTTPConst.ENUM_UPDATE_PRODUCT_PRICING:
                url = HTTPConst.SERVER_LINK + "/mr/enum/v1/update_product_pricing";
                break;

            case HTTPConst.ENUM_GET_ITEM_CONDITION:
                url = HTTPConst.SERVER_LINK + "/mr/enum/v1/item_condition";
                break;

            case HTTPConst.ENUM_ADD_ITEM_CONDITION:
                url = HTTPConst.SERVER_LINK + "/mr/enum/v1/item_condition";
                break;

            case HTTPConst.ENUM_UPDATE_ITEM_CONDITION:
                url = HTTPConst.SERVER_LINK + "/mr/enum/v1/update_item_condition";
                break;

            case HTTPConst.ENUM_GET_PRODUCT_CATEGORY:
                url = HTTPConst.SERVER_LINK + "/mr/enum/v1/product_category";
                break;

            case HTTPConst.ENUM_GET_PRODUCT_CATEGORY_TREE:
                url = HTTPConst.SERVER_LINK + "/mr/enum/v1/product_category_tree";
                break;

            case HTTPConst.ENUM_ADD_PRODUCT_CATEGORY:
                url = HTTPConst.SERVER_LINK + "/mr/enum/v1/product_category";
                break;

            case HTTPConst.ENUM_UPDATE_PRODUCT_CATEGORY:
                url = HTTPConst.SERVER_LINK + "/mr/enum/v1/update_product_category";
                break;

        }

        return url;
    }

    public static int getPathVariableNo(String call) {
        int pathVariableNo = 0;

        switch (call) {

            case HTTPConst.AUTH_LOGIN:
                pathVariableNo = 0;
                break;

            case HTTPConst.AUTH_SELECT_GROUP:
                pathVariableNo = 0;
                break;

            case HTTPConst.MEMBER_GET_ALL_MEMBER_NAMES:
                pathVariableNo = 3;
                break;

            case HTTPConst.ACCOUNT_GET_AUTH_MR_STOCK:
                pathVariableNo = 1;
                break;

            case HTTPConst.ACCOUNT_GET_AUTH_MR_ACCOUNT:
                pathVariableNo = 1;
                break;

            case HTTPConst.ACCOUNT_GET_OWNER_MR_STOCK:
                pathVariableNo = 1;
                break;

            case HTTPConst.ACCOUNT_GET_OWNER_MR_ACCOUNT:
                pathVariableNo = 1;
                break;

            case HTTPConst.INV_VERIFY_STOCK_ID:
                pathVariableNo = 0;
                break;

            case HTTPConst.INV_GET_ALL_ACTIVE_ITEM_TAG_BY_TYPE:
                pathVariableNo = 0;
                break;

            case HTTPConst.INV_GET_ACTIVE_ITEM_TAG_BY_STOCK_TYPE:
                pathVariableNo = 1;
                break;

            case HTTPConst.INV_GET_ACTIVE_ITEM_TAG_BY_BRAND_TYPE:
                pathVariableNo = 1;
                break;

            case HTTPConst.INV_MARK_ITEM_TAGS_PRINTED:
                pathVariableNo = 0;
                break;

            case HTTPConst.INV_GET_ALL_LOTS_TO_STOCK:
                pathVariableNo = 1;
                break;

            case HTTPConst.INV_GET_LOTS_TO_STOCK_FOR_TYPE:
                pathVariableNo = 1;
                break;

            case HTTPConst.INV_GET_LOTS_TO_STOCK_FOR_BRAND:
                pathVariableNo = 1;
                break;

            case HTTPConst.INV_GENERATE_STOCK_FROM_LOTS:
                pathVariableNo = 0;
                break;

            case HTTPConst.INV_SEARCH_STOCK_TYPE:
                pathVariableNo = 1;
                break;

            case HTTPConst.INV_SEARCH_BRAND:
                pathVariableNo = 1;
                break;

            case HTTPConst.INV_GET_LOT:
                pathVariableNo = 1;
                break;

            case HTTPConst.INV_GET_STOCK_TYPE:
                pathVariableNo = 1;
                break;

            case HTTPConst.INV_GET_BRAND:
                pathVariableNo = 1;
                break;

            case HTTPConst.INV_GET_STOCK_ITEMS_FOR_TYPE:
                pathVariableNo = 1;
                break;

            case HTTPConst.INV_CREATE_ITEM_TAG_FOR_STOCK_ITEMS:
                pathVariableNo = 0;
                break;

            case HTTPConst.VISIT_GET_ACTIVE_VISITS_FOR_OWNER:
                pathVariableNo = 2;
                break;

            case HTTPConst.VISIT_CREATE_VISIT:
                pathVariableNo = 0;
                break;

            case HTTPConst.VISIT_SCHEDULED_VISIT:
                pathVariableNo = 0;
                break;

            case HTTPConst.VISIT_START_VISIT:
                pathVariableNo = 0;
                break;

            case HTTPConst.VISIT_END_VISIT:
                pathVariableNo = 0;
                break;

            case HTTPConst.VISIT_GET_STOCK_ITEM:
                pathVariableNo = 0;
                break;

            case HTTPConst.VISIT_CHECK_STOCK_ITEM:
                pathVariableNo = 0;
                break;

            case HTTPConst.VISIT_CHECK_STOCK_ITEMS:
                pathVariableNo = 0;
                break;

            case HTTPConst.VISIT_TRANSFER_STOCK:
                pathVariableNo = 0;
                break;

            case HTTPConst.VISIT_DIRECT_SALE:
                pathVariableNo = 0;
                break;

            case HTTPConst.VISIT_GET_OUTSTANDING_PAY_TXS:
                pathVariableNo = 0;
                break;

            case HTTPConst.VISIT_TRANSFER_PAY:
                pathVariableNo = 0;
                break;

            case HTTPConst.VISIT_GET_VISITS_FOR_MEMBER:
                pathVariableNo = 3;
                break;

            case HTTPConst.VISIT_GET_VISITS_FOR_OWNER:
                pathVariableNo = 3;
                break;

            case HTTPConst.VISIT_GET_VISITS_FOR_AUTH:
                pathVariableNo = 3;
                break;

            case HTTPConst.VISIT_GET_ALL_VISITS:
                pathVariableNo = 2;
                break;

            case HTTPConst.VISIT_GET_VISITS_FOR_OWNER_FOR_ROLE:
                pathVariableNo = 3;
                break;

            case HTTPConst.VISIT_GET_VISITS_FOR_AUTH_FOR_ROLE:
                pathVariableNo = 3;
                break;

            case HTTPConst.VISIT_DISCOUNT_ITEMS:
                pathVariableNo = 0;
                break;

            case HTTPConst.VISIT_DISCOUNT_STOCK_TYPE:
                pathVariableNo = 0;
                break;

            case HTTPConst.VISIT_DISCOUNT_LOT:
                pathVariableNo = 1;
                break;

            case HTTPConst.VISIT_GET_TXS_FOR_OWNER_IN_RANGE:
                pathVariableNo = 3;
                break;

            case HTTPConst.VISIT_GET_STOCK_TXS_FOR_OWNER_IN_RANGE:
                pathVariableNo = 3;
                break;

            case HTTPConst.VISIT_GET_PAY_TXS_FOR_OWNER_IN_RANGE:
                pathVariableNo = 3;
                break;

            case HTTPConst.VISIT_GET_VISIT_PRINT_DATA:
                pathVariableNo = 2;
                break;

            case HTTPConst.VISIT_GET_VISIT_PRINT_DATA_IN_RANGE:
                pathVariableNo = 3;
                break;

            case HTTPConst.ENUM_GET_PRODUCT_PRICING:
                pathVariableNo = 0;
                break;

            case HTTPConst.ENUM_ADD_PRODUCT_PRICING:
                pathVariableNo = 0;
                break;

            case HTTPConst.ENUM_UPDATE_PRODUCT_PRICING:
                pathVariableNo = 0;
                break;

            case HTTPConst.ENUM_GET_ITEM_CONDITION:
                pathVariableNo = 0;
                break;

            case HTTPConst.ENUM_ADD_ITEM_CONDITION:
                pathVariableNo = 0;
                break;

            case HTTPConst.ENUM_UPDATE_ITEM_CONDITION:
                pathVariableNo = 0;
                break;

            case HTTPConst.ENUM_GET_PRODUCT_CATEGORY:
                pathVariableNo = 0;
                break;

            case HTTPConst.ENUM_GET_PRODUCT_CATEGORY_TREE:
                pathVariableNo = 0;
                break;

            case HTTPConst.ENUM_ADD_PRODUCT_CATEGORY:
                pathVariableNo = 0;
                break;

            case HTTPConst.ENUM_UPDATE_PRODUCT_CATEGORY:
                pathVariableNo = 0;
                break;

        }
        return pathVariableNo;
    }

    public static String getCallType(String call) {
        String type = "";

        switch (call) {

            case HTTPConst.AUTH_LOGIN:
                type = HTTPConst.POST_CALL;
                break;

            case HTTPConst.AUTH_SELECT_GROUP:
                type = HTTPConst.POST_CALL;
                break;

            case HTTPConst.MEMBER_GET_ALL_MEMBER_NAMES:
                type = HTTPConst.GET_CALL;
                break;

            case HTTPConst.ACCOUNT_GET_AUTH_MR_STOCK:
                type = HTTPConst.GET_CALL;
                break;

            case HTTPConst.ACCOUNT_GET_AUTH_MR_ACCOUNT:
                type = HTTPConst.GET_CALL;
                break;

            case HTTPConst.ACCOUNT_GET_OWNER_MR_STOCK:
                type = HTTPConst.GET_CALL;
                break;

            case HTTPConst.ACCOUNT_GET_OWNER_MR_ACCOUNT:
                type = HTTPConst.GET_CALL;
                break;

            case HTTPConst.INV_VERIFY_STOCK_ID:
                type = HTTPConst.GET_CALL;
                break;

            case HTTPConst.INV_GET_ALL_ACTIVE_ITEM_TAG_BY_TYPE:
                type = HTTPConst.GET_CALL;
                break;

            case HTTPConst.INV_GET_ACTIVE_ITEM_TAG_BY_STOCK_TYPE:
                type = HTTPConst.GET_CALL;
                break;

            case HTTPConst.INV_GET_ACTIVE_ITEM_TAG_BY_BRAND_TYPE:
                type = HTTPConst.GET_CALL;
                break;

            case HTTPConst.INV_MARK_ITEM_TAGS_PRINTED:
                type = HTTPConst.POST_CALL;
                break;

            case HTTPConst.INV_GET_ALL_LOTS_TO_STOCK:
                type = HTTPConst.GET_CALL;
                break;

            case HTTPConst.INV_GET_LOTS_TO_STOCK_FOR_TYPE:
                type = HTTPConst.GET_CALL;
                break;

            case HTTPConst.INV_GET_LOTS_TO_STOCK_FOR_BRAND:
                type = HTTPConst.GET_CALL;
                break;

            case HTTPConst.INV_GENERATE_STOCK_FROM_LOTS:
                type = HTTPConst.POST_CALL;
                break;

            case HTTPConst.INV_SEARCH_STOCK_TYPE:
                type = HTTPConst.GET_CALL;
                break;

            case HTTPConst.INV_SEARCH_BRAND:
                type = HTTPConst.GET_CALL;
                break;

            case HTTPConst.INV_GET_LOT:
                type = HTTPConst.GET_CALL;
                break;

            case HTTPConst.INV_GET_STOCK_TYPE:
                type = HTTPConst.GET_CALL;
                break;

            case HTTPConst.INV_GET_BRAND:
                type = HTTPConst.GET_CALL;
                break;

            case HTTPConst.INV_GET_STOCK_ITEMS_FOR_TYPE:
                type = HTTPConst.GET_CALL;
                break;

            case HTTPConst.INV_CREATE_ITEM_TAG_FOR_STOCK_ITEMS:
                type = HTTPConst.POST_CALL;
                break;

            case HTTPConst.VISIT_GET_ACTIVE_VISITS_FOR_OWNER:
                type = HTTPConst.GET_CALL;
                break;

            case HTTPConst.VISIT_CREATE_VISIT:
                type = HTTPConst.PUT_CALL;
                break;

            case HTTPConst.VISIT_SCHEDULED_VISIT:
                type = HTTPConst.POST_CALL;
                break;

            case HTTPConst.VISIT_START_VISIT:
                type = HTTPConst.POST_CALL;
                break;

            case HTTPConst.VISIT_END_VISIT:
                type = HTTPConst.POST_CALL;
                break;

            case HTTPConst.VISIT_GET_STOCK_ITEM:
                type = HTTPConst.GET_CALL;
                break;

            case HTTPConst.VISIT_CHECK_STOCK_ITEM:
                type = HTTPConst.GET_CALL;
                break;

            case HTTPConst.VISIT_CHECK_STOCK_ITEMS:
                type = HTTPConst.POST_CALL;
                break;

            case HTTPConst.VISIT_TRANSFER_STOCK:
                type = HTTPConst.POST_CALL;
                break;

            case HTTPConst.VISIT_DIRECT_SALE:
                type = HTTPConst.POST_CALL;
                break;

            case HTTPConst.VISIT_GET_OUTSTANDING_PAY_TXS:
                type = HTTPConst.GET_CALL;
                break;

            case HTTPConst.VISIT_TRANSFER_PAY:
                type = HTTPConst.POST_CALL;
                break;

            case HTTPConst.VISIT_GET_VISITS_FOR_MEMBER:
                type = HTTPConst.GET_CALL;
                break;

            case HTTPConst.VISIT_GET_VISITS_FOR_OWNER:
                type = HTTPConst.GET_CALL;
                break;

            case HTTPConst.VISIT_GET_VISITS_FOR_AUTH:
                type = HTTPConst.GET_CALL;
                break;

            case HTTPConst.VISIT_GET_ALL_VISITS:
                type = HTTPConst.GET_CALL;
                break;

            case HTTPConst.VISIT_GET_VISITS_FOR_OWNER_FOR_ROLE:
                type = HTTPConst.GET_CALL;
                break;

            case HTTPConst.VISIT_GET_VISITS_FOR_AUTH_FOR_ROLE:
                type = HTTPConst.GET_CALL;
                break;

            case HTTPConst.VISIT_DISCOUNT_ITEMS:
                type = HTTPConst.POST_CALL;
                break;

            case HTTPConst.VISIT_DISCOUNT_STOCK_TYPE:
                type = HTTPConst.POST_CALL;
                break;

            case HTTPConst.VISIT_DISCOUNT_LOT:
                type = HTTPConst.POST_CALL;
                break;

            case HTTPConst.VISIT_GET_TXS_FOR_OWNER_IN_RANGE:
                type = HTTPConst.GET_CALL;
                break;

            case HTTPConst.VISIT_GET_STOCK_TXS_FOR_OWNER_IN_RANGE:
                type = HTTPConst.GET_CALL;
                break;

            case HTTPConst.VISIT_GET_PAY_TXS_FOR_OWNER_IN_RANGE:
                type = HTTPConst.GET_CALL;
                break;

            case HTTPConst.VISIT_GET_VISIT_PRINT_DATA:
                type = HTTPConst.GET_CALL;
                break;

            case HTTPConst.VISIT_GET_VISIT_PRINT_DATA_IN_RANGE:
                type = HTTPConst.GET_CALL;
                break;

            case HTTPConst.ENUM_GET_PRODUCT_PRICING:
                type = HTTPConst.GET_CALL;
                break;

            case HTTPConst.ENUM_ADD_PRODUCT_PRICING:
                type = HTTPConst.PUT_CALL;
                break;

            case HTTPConst.ENUM_UPDATE_PRODUCT_PRICING:
                type = HTTPConst.POST_CALL;
                break;

            case HTTPConst.ENUM_GET_ITEM_CONDITION:
                type = HTTPConst.GET_CALL;
                break;

            case HTTPConst.ENUM_ADD_ITEM_CONDITION:
                type = HTTPConst.PUT_CALL;
                break;

            case HTTPConst.ENUM_UPDATE_ITEM_CONDITION:
                type = HTTPConst.POST_CALL;
                break;

            case HTTPConst.ENUM_GET_PRODUCT_CATEGORY:
                type = HTTPConst.GET_CALL;
                break;

            case HTTPConst.ENUM_GET_PRODUCT_CATEGORY_TREE:
                type = HTTPConst.GET_CALL;
                break;

            case HTTPConst.ENUM_ADD_PRODUCT_CATEGORY:
                type = HTTPConst.PUT_CALL;
                break;

            case HTTPConst.ENUM_UPDATE_PRODUCT_CATEGORY:
                type = HTTPConst.POST_CALL;
                break;

        }
        return type;
    }

    public static boolean isNonTokenCall(String call) {

        switch(call) {
            case HTTPConst.AUTH_LOGIN:
                return true;
        }

        return false;
    }

    public static boolean saveResponseData(String call, String jsonResponseStr) {

        switch (call) {

            case HTTPConst.AUTH_LOGIN: {
                LoginInfoREST o = (LoginInfoREST) LoginInfoREST.JSONRepo.buildObject(jsonResponseStr);
                if (o != null) {
                    DataManager.instance().onLogin(o);
                    return true;
                }
                break;
            }

            case HTTPConst.AUTH_SELECT_GROUP: {
                LoginInfoREST o = (LoginInfoREST) LoginInfoREST.JSONRepo.buildObject(jsonResponseStr);
                if (o != null) {
                    DataManager.instance().onSelectGroup(o);
                    return true;
                }
                break;
            }

            case HTTPConst.MEMBER_GET_ALL_MEMBER_NAMES: {
                MemberSearchInfo o = (MemberSearchInfo) MemberSearchInfo.JSONRepo.buildObject(jsonResponseStr);
                if(o != null) {
                    DataManager.instance().setAllSGMembers(o);
                    return true;
                }
                break;
            }

            case HTTPConst.ACCOUNT_GET_AUTH_MR_STOCK: {
                MrStock o = (MrStock) MrStock.JSONRepo.buildObject(jsonResponseStr);
                if(o != null) {
                    DataManager.instance().setAuthStock(o);
                    return true;
                }
                break;
            }

            case HTTPConst.ACCOUNT_GET_AUTH_MR_ACCOUNT: {
                MrAccount o = (MrAccount) MrAccount.JSONRepo.buildObject(jsonResponseStr);
                if(o != null) {
                    DataManager.instance().setAuthAccount(o);
                    return true;
                }
                break;
            }

            case HTTPConst.ACCOUNT_GET_OWNER_MR_STOCK: {
                MrStock o = (MrStock) MrStock.JSONRepo.buildObject(jsonResponseStr);
                if(o != null) {
                    DataManager.instance().setOwnerStock(o);
                    return true;
                }
                break;
            }

            case HTTPConst.ACCOUNT_GET_OWNER_MR_ACCOUNT: {
                MrAccount o = (MrAccount) MrAccount.JSONRepo.buildObject(jsonResponseStr);
                if(o != null) {
                    DataManager.instance().setOwnerAccount(o);
                    return true;
                }
                break;
            }

            case HTTPConst.INV_VERIFY_STOCK_ID:
                return true;

            case HTTPConst.INV_GET_ALL_ACTIVE_ITEM_TAG_BY_TYPE:
                return true;

            case HTTPConst.INV_GET_ACTIVE_ITEM_TAG_BY_STOCK_TYPE:
                return true;

            case HTTPConst.INV_GET_ACTIVE_ITEM_TAG_BY_BRAND_TYPE:
                return true;

            case HTTPConst.INV_MARK_ITEM_TAGS_PRINTED:
                return true;

            case HTTPConst.INV_GET_ALL_LOTS_TO_STOCK:
                return true;

            case HTTPConst.INV_GET_LOTS_TO_STOCK_FOR_TYPE:
                return true;

            case HTTPConst.INV_GET_LOTS_TO_STOCK_FOR_BRAND:
                return true;

            case HTTPConst.INV_GENERATE_STOCK_FROM_LOTS:
                return true;

            case HTTPConst.INV_SEARCH_STOCK_TYPE:
                return true;

            case HTTPConst.INV_SEARCH_BRAND:
                return true;

            case HTTPConst.INV_GET_LOT:
                return true;

            case HTTPConst.INV_GET_STOCK_TYPE:
                return true;

            case HTTPConst.INV_GET_BRAND:
                return true;

            case HTTPConst.INV_GET_STOCK_ITEMS_FOR_TYPE:
                return true;

            case HTTPConst.INV_CREATE_ITEM_TAG_FOR_STOCK_ITEMS:
                return true;

            case HTTPConst.VISIT_GET_ACTIVE_VISITS_FOR_OWNER: {
                MrVisit o = (MrVisit) MrVisit.JSONRepo.buildObject(jsonResponseStr);
                if (o != null) {
                    DataManager.instance().setActiveVisit(o);
                    return true;
                }
                break;
            }

            case HTTPConst.VISIT_CREATE_VISIT: {
                MrVisit o = (MrVisit) MrVisit.JSONRepo.buildObject(jsonResponseStr);
                if (o != null) {
                    DataManager.instance().setActiveVisit(o);
                    return true;
                }
                break;
            }

            case HTTPConst.VISIT_SCHEDULED_VISIT: {
                MrVisit o = (MrVisit) MrVisit.JSONRepo.buildObject(jsonResponseStr);
                if (o != null) {
                    DataManager.instance().setActiveVisit(o);
                    return true;
                }
                break;
            }

            case HTTPConst.VISIT_START_VISIT: {
                MrVisit o = (MrVisit) MrVisit.JSONRepo.buildObject(jsonResponseStr);
                if (o != null) {
                    DataManager.instance().setActiveVisit(o);
                    return true;
                }
                break;
            }

            case HTTPConst.VISIT_END_VISIT: {
                MrVisit o = (MrVisit) MrVisit.JSONRepo.buildObject(jsonResponseStr);
                if (o != null) {
                    DataManager.instance().setActiveVisit(o);
                    return true;
                }
                break;
            }

            case HTTPConst.VISIT_GET_STOCK_ITEM:
                return true;

            case HTTPConst.VISIT_CHECK_STOCK_ITEM:
                return true;

            case HTTPConst.VISIT_CHECK_STOCK_ITEMS: {
                MrStock o = (MrStock) MrStock.JSONRepo.buildObject(jsonResponseStr);
                if(o != null) {
                    DataManager.instance().setOwnerStock(o);
                    return true;
                }
                break;
            }

            case HTTPConst.VISIT_TRANSFER_STOCK: {
                MrStock o = (MrStock) MrStock.JSONRepo.buildObject(jsonResponseStr);
                if(o != null) {
                    DataManager.instance().setOwnerStock(o);
                    return true;
                }
                break;
            }

            case HTTPConst.VISIT_DIRECT_SALE: {
                MrStock o = (MrStock) MrStock.JSONRepo.buildObject(jsonResponseStr);
                if(o != null) {
                    DataManager.instance().setOwnerStock(o);
                    return true;
                }
                break;
            }

            case HTTPConst.VISIT_GET_OUTSTANDING_PAY_TXS:
                return true;

            case HTTPConst.VISIT_TRANSFER_PAY:
                return true;

            case HTTPConst.VISIT_GET_VISITS_FOR_MEMBER:
                return true;

            case HTTPConst.VISIT_GET_VISITS_FOR_OWNER:
                return true;

            case HTTPConst.VISIT_GET_VISITS_FOR_AUTH:
                return true;

            case HTTPConst.VISIT_GET_ALL_VISITS:
                return true;

            case HTTPConst.VISIT_GET_VISITS_FOR_OWNER_FOR_ROLE:
                return true;

            case HTTPConst.VISIT_GET_VISITS_FOR_AUTH_FOR_ROLE:
                return true;

            case HTTPConst.VISIT_DISCOUNT_ITEMS:
                return true;

            case HTTPConst.VISIT_DISCOUNT_STOCK_TYPE:
                return true;

            case HTTPConst.VISIT_DISCOUNT_LOT:
                return true;

            case HTTPConst.VISIT_GET_TXS_FOR_OWNER_IN_RANGE:
                return true;

            case HTTPConst.VISIT_GET_STOCK_TXS_FOR_OWNER_IN_RANGE:
                return true;

            case HTTPConst.VISIT_GET_PAY_TXS_FOR_OWNER_IN_RANGE:
                return true;

            case HTTPConst.VISIT_GET_VISIT_PRINT_DATA:
                return true;

            case HTTPConst.VISIT_GET_VISIT_PRINT_DATA_IN_RANGE:
                return true;

            case HTTPConst.ENUM_GET_PRODUCT_PRICING:
                return true;

            case HTTPConst.ENUM_ADD_PRODUCT_PRICING:
                return true;

            case HTTPConst.ENUM_UPDATE_PRODUCT_PRICING:
                return true;

            case HTTPConst.ENUM_GET_ITEM_CONDITION:
                return true;

            case HTTPConst.ENUM_ADD_ITEM_CONDITION:
                return true;

            case HTTPConst.ENUM_UPDATE_ITEM_CONDITION:
                return true;

            case HTTPConst.ENUM_GET_PRODUCT_CATEGORY:
                return true;

            case HTTPConst.ENUM_GET_PRODUCT_CATEGORY_TREE:
                return true;

            case HTTPConst.ENUM_ADD_PRODUCT_CATEGORY:
                return true;

            case HTTPConst.ENUM_UPDATE_PRODUCT_CATEGORY:
                return true;
        }

        return false;
    }
}
