package org.example;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class LetterCombinationsAppTest  {

    //or we could autowire this if we use spring to manage that object
    LetterCombinationsApp app = LetterCombinationsApp.getInstance();

    @Test
    public void testGetLetterCombinations(){
        String outputOne = app.getLetterCombinations(new Integer[]{2,3});
        System.out.println(outputOne);
        String outputTwo = app.getLetterCombinations(new Integer[]{9});
        System.out.println(outputTwo);
        String outputThree = app.getLetterCombinations(null);
        System.out.println(outputThree);
        // assert
        String expectOne = "ad ae af bd be bf cd ce cf";
        String expectTwo = "w x y z";
        String expectThree = "-1";
        Assert.assertEquals(expectOne,outputOne);
        Assert.assertEquals(expectTwo,outputTwo);
        Assert.assertEquals(expectThree,outputThree);
    }

}
