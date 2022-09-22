package com.seydou.fizzbuzzLike.Utils;

import com.seydou.fizzbuzzLike.utils.Utils;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UtilsTest {

    @Test
    public void testIsMultipleIsOk(){
        Assert.isTrue(Utils.isMultiple(10,2),"test Ko");
        Assert.isTrue(!Utils.isMultiple(10,3),"test ok");
    }


    private String concatainer (List<String> list){
        String result = "";
        for (String val:list){
            result += val;
        }
        return result;
    }

    @Test
    public void testGetResultList(){
        List<String> expectedLKist = Arrays.asList("1","foo","3","foobar");
        String chaineExpected = concatainer(expectedLKist);
        String chaineResult = concatainer(Utils.getResultList(2,4,4,"foo","bar"));
        Assert.isTrue(chaineExpected.equals(chaineResult), "testGetResultList KO ");

    }

    @Test
    public void testGetResultListKO(){
        List<String> expectedLKist = Arrays.asList("1","foo","4","foobar");
        String chaineExpected = concatainer(expectedLKist);
        String chaineResult = concatainer(Utils.getResultList(2,4,4,"foo","bar"));
        Assert.isTrue(!chaineExpected.equals(chaineResult), "testGetResultList KO ");
    }

    @Test
    public void sanityzeMultibpleOK(){
        Assert.isTrue(Utils.sanityzeMultibple(1).equals(1), "sanityzeMultibpleOK KO");
        Assert.isTrue(Utils.sanityzeMultibple(0).equals(1), "sanityzeMultibpleOK KO");
        Assert.isTrue(Utils.sanityzeMultibple(-10).equals(1), "sanityzeMultibpleOK KO");

    }
    @Test
    public void sanityzeMultibpleKO(){
        Assert.isTrue(!Utils.sanityzeMultibple(10).equals(1), "sanityzeMultibpleKO KO");
    }
    @Test
    public void sanityzeLimitOK(){
        Assert.isTrue(Utils.sanityzeLimit(10).equals(10), "sanityzeLimitOK KO");
        Assert.isTrue(Utils.sanityzeLimit(101).equals(100), "sanityzeLimitOK KO");
        Assert.isTrue(Utils.sanityzeLimit(0).equals(1), "sanityzeLimitOK KO");
        Assert.isTrue(Utils.sanityzeLimit(-50).equals(1), "sanityzeLimitOK KO");
    }
    @Test
    public void sanityzeLimitKO(){
        Assert.isTrue(!Utils.sanityzeLimit(-50).equals(-50), "sanityzeLimitKO KO");
        Assert.isTrue(!Utils.sanityzeLimit(0).equals(0), "sanityzeLimitKO KO");
        Assert.isTrue(!Utils.sanityzeLimit(101).equals(101), "sanityzeLimitKO KO");
    }
}
