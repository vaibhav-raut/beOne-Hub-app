package udaan.beone.mrpoint.util;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by Vaibhav on 15-05-2016.
 */
public class DataUtil {
    public final static long MEMBER_RANGE_FOR_GROUP = 10000L;
    public final static long GROUP_RANGE_FOR_DISTRICT = 100000L;
    public final static long MEMBER_RANGE_FOR_DISTRICT = MEMBER_RANGE_FOR_GROUP * GROUP_RANGE_FOR_DISTRICT;

    public final static double ZERO_DOUBLE = 0.0;
    public final static float ZERO_FLOAT = 0.0F;
    public final static int ZERO_INTEGER = 0;
    public final static long ZERO_LONG = 0L;
    public final static BigDecimal ZERO_BIG_DECIMAL = new BigDecimal(0);
    public final static String EMPTY_STRING = "";
    public final static Date INVALID_DATE = new Date(32503660200000L);

    public static DateFormat display_df = new SimpleDateFormat("dd-MM-yy");

    public static long getDistrictFromGroupAc(long groupAcNo) {
        if(groupAcNo > 0l) {
            return (groupAcNo / DataUtil.GROUP_RANGE_FOR_DISTRICT);
        }
        return 0l;
    }

    public static long getDistrictFromMemberAc(long memberAcNo) {
        if(memberAcNo > 0l) {
            return (memberAcNo / DataUtil.MEMBER_RANGE_FOR_DISTRICT);
        }
        return 0l;
    }

    public static long getGroupNoFromGroupAc(long groupAcNo) {
        if(groupAcNo > 0l) {
            return (groupAcNo % DataUtil.GROUP_RANGE_FOR_DISTRICT);
        }
        return 0l;
    }

    public static long getMemberNoFromMemberAc(long memberAcNo) {
        if(memberAcNo > 0l) {
            return ((memberAcNo % DataUtil.GROUP_RANGE_FOR_DISTRICT) % MEMBER_RANGE_FOR_GROUP);
        }
        return 0l;
    }

    public static long getGroupNoFromMemberAc(long memberAcNo) {
        if(memberAcNo > 0l) {
            return ((memberAcNo % DataUtil.GROUP_RANGE_FOR_DISTRICT) / MEMBER_RANGE_FOR_GROUP);
        }
        return 0l;
    }

    public static String getDisplayGroupAcNo(String districtCode, long groupAcNo) {
        if(districtCode != null && groupAcNo > 0l) {
            StringBuilder sb = new StringBuilder();
            sb.append(districtCode);
            sb.append("-");
            sb.append(getGroupNoFromGroupAc(groupAcNo));

            return sb.toString();
//            return (districtCode + " - " + getGroupNoFromGroupAc(groupAcNo));
        }
        return DataUtil.EMPTY_STRING;
    }

    public static String getDisplayMemberAcNo(String districtCode, long memberAcNo) {
        if(districtCode != null && memberAcNo > 0l) {
            StringBuilder sb = new StringBuilder();
            long groupAcNo = getGroupNoFromMemberAc(memberAcNo);

            sb.append(districtCode);
            sb.append("-");
            sb.append(getGroupNoFromMemberAc(memberAcNo));
            sb.append("-");
            sb.append(getMemberNoFromMemberAc(memberAcNo));

            return sb.toString();
//            return (districtCode + " - " + getGroupNoFromMemberAc(memberAcNo) + " - " + getMemberNoFromMemberAc(memberAcNo));
        }
        return DataUtil.EMPTY_STRING;
    }

    public static String fillZeros(long num, int size) {
        return fillZeros(DataUtil.toString(num), size);
    }

    public static String fillZeros(String num, int size) {
        if(num == null) {
            num = DataUtil.EMPTY_STRING;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = size - num.length(); i > 0; i--) {
            sb.append("0");
        }
        sb.append(num);
        return sb.toString();
    }

    public static BigDecimal roundUp(BigDecimal amount, int decimal) {

        if(amount == null) {
            return DataUtil.ZERO_BIG_DECIMAL;
        }

        return amount.setScale(decimal, BigDecimal.ROUND_UP);
    }

    public static BigDecimal roundHalfUp(BigDecimal amount, int decimal) {

        if(amount == null) {
            return DataUtil.ZERO_BIG_DECIMAL;
        }

        return amount.setScale(decimal, BigDecimal.ROUND_HALF_UP);
    }

    public static String convertTimeToDisplayDate(long time){
        if(time > DataUtil.ZERO_LONG) {
            Date date = new Date(time);
            return display_df.format(date).toString();
        }
        return DataUtil.EMPTY_STRING;
    }

    public static String convertTimeToDisplayDate(Date date){
        if(date != null) {
            return display_df.format(date).toString();
        }
        return DataUtil.EMPTY_STRING;
    }

    public static String toString(Short i) {
        if(i != null) {
            return i.toString();
        }
        return "0";
    }

    public static String toString(Integer i) {
        if(i != null) {
            return i.toString();
        }
        return "0";
    }

    public static String toString(Long l) {
        if(l != null) {
            return l.toString();
        }
        return "0";
    }

    public static String toString(Float f) {
        if(f != null) {
            return f.toString();
        }
        return "0";
    }

    public static String toString(Double d) {
        if(d != null) {
            return d.toString();
        }
        return "0";
    }

    public static String toString(BigDecimal bd) {
        if(bd != null) {
            return BDUtil.format(roundHalfUp(bd, 0));
        }
        return "0";
    }

    public static String toString(BigDecimal bd, int dec) {
        if(bd != null) {
            return BDUtil.format(roundHalfUp(bd, dec));
        }
        return "0";
    }

    public static String toString(BigDecimal a, BigDecimal b) {

        if(a == null && b == null) {
            return EMPTY_STRING;
        }
        if(a == null) {
            return toString(b);
        }
        if(b == null) {
            return toString(a);
        }
        return (toString(a) + " / " + toString(b));
    }

    public static String toString(String s) {
        if(s != null) {
            return s;
        }
        return "";
    }

    public static String stockToString(BigDecimal bd, int dec) {

        return (toString(bd) + " / " + toString(dec));
    }

}
