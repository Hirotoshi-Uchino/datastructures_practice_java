package Util;

import java.math.BigDecimal;

public class TD { // TruncateDigit
    private static int digits = 5;

    public static double truncate(double d){
        BigDecimal val = new BigDecimal(d);
        return val.setScale(digits, BigDecimal.ROUND_HALF_UP).doubleValue();
    }


}
