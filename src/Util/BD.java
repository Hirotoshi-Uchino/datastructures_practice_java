package Util;

import java.math.BigDecimal;

public class BD{

    private static int digits = 5;

    public static BigDecimal convert(double d){
        BigDecimal val = new BigDecimal(d);
        val.setScale(5, BigDecimal.ROUND_HALF_UP);
        return val;
    }

}
