package sda.tema.SDA_Tema_4.utils;

import java.util.HashMap;
import java.util.Map;

public final class DiscountHelper {

    private static DiscountHelper instance;
    private Map<Integer, Integer> discountValues;

    private DiscountHelper() {
        this.discountValues = new HashMap<>();
        //the key is the threshold
        //the value is the discount
        this.discountValues.put(1000, 1);
        this.discountValues.put(2000, 2);
        this.discountValues.put(3000, 3);
        this.discountValues.put(4000, 4);
        this.discountValues.put(10000, 10);
    }

    public static DiscountHelper getInstance() {
        if (null == instance) {
            instance = new DiscountHelper();
        }
        return instance;
    }

    public Integer getDiscountByAmount(Integer amount) {
        return this.discountValues.getOrDefault(amount, 0);
    }

}
