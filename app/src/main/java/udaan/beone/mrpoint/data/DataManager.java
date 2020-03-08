package udaan.beone.mrpoint.data;

import udaan.beone.mrpoint.http.model.LoginInfoREST;
import udaan.beone.mrpoint.http.model.LoginRequestREST;
import udaan.beone.mrpoint.http.model.MemberSearchInfo;
import udaan.beone.mrpoint.http.model.MrAccount;
import udaan.beone.mrpoint.http.model.MrStock;
import udaan.beone.mrpoint.http.model.MrStockDisplay;
import udaan.beone.mrpoint.http.model.MrVisit;
import udaan.beone.mrpoint.http.model.MemberVisitAc;
import udaan.beone.mrpoint.http.util.HTTPConst;
import udaan.beone.mrpoint.util.DataUtil;
import udaan.beone.mrpoint.util.DateUtil;

/**
 * Created by Vaibhav on 3/15/2016.
 */
public class DataManager {

    final public static String ACCOUNT_USER = "ACCOUNT_USER";
    final public static String ACCOUNT_PASSWORD = "ACCOUNT_PASSWORD";
    final public static String ACCOUNT_SELECTED_GROUP = "ACCOUNT_SELECTED_GROUP";

    final public static String ACCOUNT_LOCAL_IP = "ACCOUNT_LOCAL_IP";

    final public static String ACCOUNT_TYPE = "com.beone.udaan";
    final public static String ACCOUNT_USERNAME_DELIMITER = "-";

    private static DataManager dataManager;

    static {
        dataManager = new DataManager();
    }

    private DataManager() {
    }

    public static DataManager instance() {
        return dataManager;
    }

    private int ipNo;

    // Data Set
    private LoginRequestREST loginRequestREST;
    private LoginInfoREST loginInfoREST;
    private String authToken;
    private long authTokenTime;
    private long loginMemberAcNo;
    private long loginGroupAcNo;
    private long selectedMemberAcNo;
    private long selectedGroupAcNo;
    private String displayLoginMemberAcNo;
    private String displayLoginGroupAcNo;
    private String displaySelectedMemberAcNo;
    private String displaySelectedGroupAcNo;
    private MemberSearchInfo allSGMembers;
    private MrStock authStock;
    private MrStockDisplay authStockDisplay;
    private MrAccount authAccount;
    private MemberVisitAc authVisitAc;
    private MrStock ownerStock;
    private MrStockDisplay ownerStockDisplay;
    private MrAccount ownerAccount;
    private MemberVisitAc ownerVisitAc;
    private MrVisit activeVisit;

    private boolean authStockDirty;
    private boolean authAccountDirty;
    private boolean authVisitAcDirty;
    private boolean ownerStockDirty;
    private boolean ownerAccountDirty;
    private boolean ownerVisitAcDirty;
    private boolean activeVisitDirty;

    public int getIpNo() {
        return ipNo;
    }

    public void setIpNo(String ipNoStr) {
        int ipNo = 0;
        if(ipNoStr != null && ipNoStr.length() > 0) {
            ipNo = Integer.parseInt(ipNoStr);
        }
        setIpNo(ipNo);
    }
    public void setIpNo(int ipNo) {
        this.ipNo = ipNo;
        HTTPConst.SERVER_LINK = HTTPConst.SERVER_DEFAULT_LINK.replace("xxx", DataUtil.fillZeros(ipNo, 3));
    }

    public void setDataDirty() {
        this.authStockDirty = true;
        this.authAccountDirty = true;
        this.ownerStockDirty = true;
        this.ownerAccountDirty = true;
        this.activeVisitDirty = true;
    }
    public void setAllAccountDirty() {
        this.authAccountDirty = true;
        this.ownerAccountDirty = true;
        this.activeVisitDirty = true;
    }
    public void setAuthDataDirty() {
        this.authStockDirty = true;
        this.authAccountDirty = true;
    }
    public void setOwnerDataDirty() {
        this.ownerStockDirty = true;
        this.ownerAccountDirty = true;
        this.activeVisitDirty = true;
    }
    public void setMemberVisitAcDirty() {
        this.authVisitAcDirty = true;
        this.ownerVisitAcDirty = true;
    }
    public void setActiveVisitDirty() {
        this.activeVisitDirty = true;
    }
    public void setOwnerStockDirty() {
        this.ownerStockDirty = true;
    }
    public boolean isAuthStockDirty() {
        return authStockDirty;
    }
    public boolean isAuthAccountDirty() {
        return authAccountDirty;
    }
    public boolean isOwnerStockDirty() {
        return ownerStockDirty;
    }
    public boolean isOwnerAccountDirty() {
        return ownerAccountDirty;
    }
    public boolean isActiveVisitDirty() {
        return activeVisitDirty;
    }

    public boolean isAuthVisitAcDirty() {
        return authVisitAcDirty;
    }

    public boolean isOwnerVisitAcDirty() {
        return ownerVisitAcDirty;
    }

    public void onLogin(LoginInfoREST loginInfoREST) {
        this.setLoginInfoREST(loginInfoREST);

        this.loginRequestREST.setMemberNo(loginInfoREST.getMemberAcNo());
        this.setLoginMemberAcNo(loginInfoREST.getMemberAcNo());
        this.setLoginGroupAcNo(loginInfoREST.getSelectedGroupAcNo());
        this.setSelectedMemberAcNo(loginInfoREST.getMemberAcNo());
        this.setSelectedGroupAcNo(loginInfoREST.getSelectedGroupAcNo());
    }

    public void onSelectGroup(LoginInfoREST loginInfoREST) {
        setLoginInfoREST(loginInfoREST);

//        this.setSelectedMemberAcNo(0l);
        this.setSelectedGroupAcNo(loginInfoREST.getSelectedGroupAcNo());
    }

    public void onLogout() {
        loginRequestREST = null;
        loginInfoREST = null;
        authToken = null;

        this.setLoginMemberAcNo(0l);
        this.setLoginGroupAcNo(0l);
        this.setSelectedMemberAcNo(0l);
        this.setSelectedGroupAcNo(0l);
    }
    public LoginRequestREST getLoginRequestREST() {
        return loginRequestREST;
    }

    public void setLoginRequestREST(LoginRequestREST loginRequestREST) {
        this.loginRequestREST = loginRequestREST;
    }

    public LoginInfoREST getLoginInfoREST() {
        return loginInfoREST;
    }

    public void setLoginInfoREST(LoginInfoREST loginInfoREST) {
        this.loginInfoREST = loginInfoREST;
        if(loginInfoREST != null) {
            setAuthToken(loginInfoREST.getAuthToken());
        }
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
        this.authTokenTime = System.currentTimeMillis();
    }

    public long getAuthTokenTime() {
        return authTokenTime;
    }

    public long getLoginMemberAcNo() {
        return loginMemberAcNo;
    }

    public void setLoginMemberAcNo(long loginMemberAcNo) {
        if(this.loginMemberAcNo != loginMemberAcNo) {
            this.loginMemberAcNo = loginMemberAcNo;

            if(loginInfoREST != null) {
                displayLoginMemberAcNo = DataUtil.getDisplayMemberAcNo(loginInfoREST.getMemberDistrictCode(), loginMemberAcNo);
            } else {
                displayLoginMemberAcNo = null;

                authStock = null;
                authStockDisplay = null;
                authAccount = null;
                authVisitAc = null;
            }
        }
    }

    public long getLoginGroupAcNo() {
        return loginGroupAcNo;
    }

    public void setLoginGroupAcNo(long loginGroupAcNo) {
        if(this.loginGroupAcNo != loginGroupAcNo) {
            this.loginGroupAcNo = loginGroupAcNo;

            if(loginInfoREST != null) {
                displayLoginGroupAcNo = DataUtil.getDisplayGroupAcNo(loginInfoREST.getMemberDistrictCode(), loginGroupAcNo);
            } else {
                displayLoginGroupAcNo = null;
            }
        }
    }

    public long getSelectedMemberAcNo() {
        return selectedMemberAcNo;
    }

    public void setSelectedMemberAcNo(long selectedMemberAcNo) {
        if(this.selectedMemberAcNo != selectedMemberAcNo) {
            this.selectedMemberAcNo = selectedMemberAcNo;
            activeVisit = null;

            if(loginInfoREST != null) {
                displaySelectedMemberAcNo = DataUtil.getDisplayMemberAcNo(loginInfoREST.getGroupDistrictCode(), selectedMemberAcNo);
            } else {
                displaySelectedMemberAcNo = null;
            }

            if(this.selectedMemberAcNo != this.loginMemberAcNo) {
                setOwnerStock(null);
                ownerStockDisplay = null;
                setOwnerAccount(null);
                setOwnerVisitAc(null);
            } else {
                setOwnerStock(authStock);
                ownerStockDisplay = authStockDisplay;
                setOwnerAccount(authAccount);
                setOwnerVisitAc(authVisitAc);
            }
        }
    }

    public long getSelectedGroupAcNo() {
        return selectedGroupAcNo;
    }

    public void setSelectedGroupAcNo(long selectedGroupAcNo) {
        if(this.selectedGroupAcNo != selectedGroupAcNo) {
            this.selectedGroupAcNo = selectedGroupAcNo;

            if(loginInfoREST != null) {
                displaySelectedGroupAcNo = DataUtil.getDisplayGroupAcNo(loginInfoREST.getGroupDistrictCode(), selectedGroupAcNo);
            } else {
                displaySelectedGroupAcNo = null;
            }

            allSGMembers = null;
        }
    }

    public String getDisplayLoginMemberAcNo() {
        return displayLoginMemberAcNo;
    }

    public String getDisplayLoginGroupAcNo() {
        return displayLoginGroupAcNo;
    }

    public String getDisplaySelectedMemberAcNo() {
        return displaySelectedMemberAcNo;
    }

    public String getDisplaySelectedGroupAcNo() {
        return displaySelectedGroupAcNo;
    }

    public MemberSearchInfo getAllSGMembers() {
        return allSGMembers;
    }

    public void setAllSGMembers(MemberSearchInfo allSGMembers) {
        this.allSGMembers = allSGMembers;
    }

    public MrStock getAuthStock() {
        return authStock;
    }

    public void setAuthStock(MrStock authStock) {
        this.authStock = authStock;
        this.authStockDirty = false;

        if(authStock != null) {
            authStockDisplay = MrStockDisplay.buildMrStockDisplay(authStock);
        } else {
            authStockDisplay = null;
        }

        if(loginMemberAcNo == selectedMemberAcNo) {
            this.ownerStock = this.authStock;
            this.ownerStockDisplay = this.authStockDisplay;
            this.ownerStockDirty = false;
        }
    }

    public MrStockDisplay getAuthStockDisplay() {
        return authStockDisplay;
    }

    public MrAccount getAuthAccount() {
        return authAccount;
    }

    public void setAuthAccount(MrAccount authAccount) {
        this.authAccount = authAccount;
        this.authAccountDirty = false;

        if(loginMemberAcNo == selectedMemberAcNo) {
            this.ownerAccount = this.authAccount;
            this.ownerAccountDirty = false;
        }
    }

    public MrStock getOwnerStock() {
        return ownerStock;
    }

    public void setOwnerStock(MrStock ownerStock) {
        this.ownerStock = ownerStock;
        this.ownerStockDirty = false;

        if(ownerStock != null) {
            ownerStockDisplay = MrStockDisplay.buildMrStockDisplay(ownerStock);
        } else {
            ownerStockDisplay = null;
        }

        if(loginMemberAcNo == selectedMemberAcNo) {
            this.authStock = this.ownerStock;
            this.authStockDisplay = this.ownerStockDisplay;
            this.authStockDirty = false;
        }
    }

    public MrStockDisplay getOwnerStockDisplay() {
        return ownerStockDisplay;
    }

    public MrAccount getOwnerAccount() {
        return ownerAccount;
    }

    public void setOwnerAccount(MrAccount ownerAccount) {
        this.ownerAccount = ownerAccount;
        this.ownerAccountDirty = false;

        if(loginMemberAcNo == selectedMemberAcNo) {
            this.authAccount = this.ownerAccount;
            this.authAccountDirty = false;
        }
    }

    public MrVisit getActiveVisit() {
        return activeVisit;
    }

    public void setActiveVisit(MrVisit activeVisit) {
        this.activeVisit = activeVisit;
        this.activeVisitDirty = false;
    }

    public MemberVisitAc getAuthVisitAc() {
        return authVisitAc;
    }

    public void setAuthVisitAc(MemberVisitAc authVisitAc) {
        this.authVisitAcDirty = false;
        this.authVisitAc = authVisitAc;

        if(loginMemberAcNo == selectedMemberAcNo) {
            this.ownerVisitAc = this.authVisitAc;
            this.ownerVisitAcDirty = false;
        }
    }

    public MemberVisitAc getOwnerVisitAc() {
        return ownerVisitAc;
    }

    public void setOwnerVisitAc(MemberVisitAc ownerVisitAc) {
        this.ownerVisitAcDirty = false;
        this.ownerVisitAc = ownerVisitAc;

        if(loginMemberAcNo == selectedMemberAcNo) {
            this.authVisitAc = this.ownerVisitAc;
            this.authVisitAcDirty = false;
        }
    }
}
