package com.seydou.fizzbuzzLike.utils;

import org.springframework.web.bind.annotation.RequestAttribute;

import java.util.ArrayList;
import java.util.List;

public class Utils {

    /**
     * Verify if int1 is multiple of int2
     * @param int1 value to test
     * @param int2 multiple
     * @return
     */
    public static boolean isMultiple(Integer int1, Integer int2){
        return int1 % int2 == 0;
    };


    public static List<String> getResultList(Integer int1,Integer int2,Integer limit,String str1,String str2) {
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= limit; i++) {
            if (Utils.isMultiple(i, int1) && Utils.isMultiple(i, int2)) {
                list.add(str1 + str2);
            } else if (Utils.isMultiple(i, int1)) {
                list.add(str1);
            } else if (Utils.isMultiple(i, int2)) {
                list.add(str2);
            } else {
                list.add(String.valueOf(i));
            }
        }
        return list;
    }
}
