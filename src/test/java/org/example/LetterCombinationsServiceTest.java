package org.example;

import org.example.service.LetterCombinationsService;
import org.example.service.impl.LetterCombinationsServiceImpl;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author dreamguy
 * @date 2020/9/17
 */

/**
 * Unit test for se App.
 */
public class LetterCombinationsServiceTest {
    //or we could autowire this if we use spring to manage that object
    LetterCombinationsService app = LetterCombinationsServiceImpl.getInstance();

    /**
     *Right test
     */
    @Test
    public void testRightOfGetLetterCombinations(){
        String output1 = app.getLetterCombinations(new Integer[]{2,3});
        System.out.println(output1);
        String output2 = app.getLetterCombinations(new Integer[]{9});
        System.out.println(output2);

        // assert
        String expect1 = "ad ae af bd be bf cd ce cf";
        String expect2 = "w x y z";

        Assert.assertEquals(expect1,output1);
        Assert.assertEquals(expect2,output2);
    }

    /**
     *conformance test
     */
    @Test
    public void testConformanceOfGetLetterCombinations(){
        String output3 = app.getLetterCombinations(new Integer[]{1,2,3});
        System.out.println(output3);

        String expect3 = "the parameter value must be between 0 and 99";

        Assert.assertEquals(expect3,output3);
    }

    /**
     * range test
     */
    @Test
    public void testRangeOfGetLetterCombinations(){
        String output4  = app.getLetterCombinations(new Integer[]{0,0});
        String output5  = app.getLetterCombinations(new Integer[]{9,9});
        String output6   = app.getLetterCombinations(new Integer[]{9,10});
        String output7 = app.getLetterCombinations(new Integer[]{10,9});
        String output8 = app.getLetterCombinations(new Integer[]{-1,0});
        String output9  = app.getLetterCombinations(new Integer[]{0,-1});
        String output10   = app.getLetterCombinations(new Integer[]{-1,-1});
        String output11   = app.getLetterCombinations(new Integer[]{10,10});

        String expect4  = "";
        String expect5  = "ww wx wy wz xw xx xy xz yw yx yy yz zw zx zy zz";
        String expect6  = "the parameter value must be between 0 and 99";

        Assert.assertEquals(expect4,output4);
        Assert.assertEquals(expect5,output5);
        Assert.assertEquals(expect6,output6);
        Assert.assertEquals(expect6,output7);
        Assert.assertEquals(expect6,output8);
        Assert.assertEquals(expect6,output9);
        Assert.assertEquals(expect6,output10);
        Assert.assertEquals(expect6,output11);
    }

    /**
     * existence test
     */
    @Test
    public void testExistOfGetLetterCombinations(){
        String output3 = app.getLetterCombinations(null);
        String outputTwelve   = app.getLetterCombinations(new Integer[]{});
        String outputThirteen = app.getLetterCombinations(new Integer[]{null});
        String output14 = app.getLetterCombinations(new Integer[]{2,null});
        String outputFifteen  = app.getLetterCombinations(new Integer[]{null,2});
        String output16  = app.getLetterCombinations(new Integer[]{null,null});

        String expect3 = "value cannot be null";

        Assert.assertEquals(expect3,output3);
        Assert.assertEquals(expect3,outputTwelve);
        Assert.assertEquals(expect3,outputThirteen);
        Assert.assertEquals(expect3,output14);
        Assert.assertEquals(expect3,outputFifteen);
        Assert.assertEquals(expect3,output16);
    }

    /**
     * Exception test
     */
    @Test
    public void testExceptionOfGetLetterCombinations(){
        try {
            app.getLetterCombinations(new Integer[]{5});
            Assert.fail();
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }


}
