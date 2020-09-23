package org.example;

import org.example.service.LetterCombinationsService;
import org.example.service.impl.LetterCombinationsServiceZeroToNineImpl;
import org.example.service.impl.LetterCombinationsServiceZeroToNinetyImpl;
import org.junit.Assert;
import org.junit.Test;
import java.util.Arrays;

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
    LetterCombinationsService appZeroToNine   = LetterCombinationsServiceZeroToNineImpl.getInstance();
    LetterCombinationsService appZeroToNinety = new LetterCombinationsServiceZeroToNinetyImpl();

    /**
     *Right test
     */
    @Test
    public void testRightOfGetLetterCombinations(){
        String output1 = appZeroToNine .getLetterCombinations(new Integer[]{2,3});
        String output2 = appZeroToNine .getLetterCombinations(new Integer[]{9});
        String output1ForNineTy = appZeroToNinety .getLetterCombinations(new Integer[]{2,3});
        String output2ForNineTy = appZeroToNinety .getLetterCombinations(new Integer[]{9});

        // assert
        String expect1 = "ad ae af bd be bf cd ce cf";
        String expect2 = "w x y z";

        Assert.assertEquals(expect1,output1);
        Assert.assertEquals(expect1,output1ForNineTy);
        Assert.assertEquals(expect2,output2);
        Assert.assertEquals(expect2,output2ForNineTy);
    }

    /**
     *conformance test
     */
    @Test
    public void testConformanceOfGetLetterCombinations(){
        String output3 = appZeroToNine.getLetterCombinations(new Integer[]{1,2,3});
        System.out.println(output3);
        String output3ForNineTy = appZeroToNinety.getLetterCombinations(new Integer[]{1,2,3});
        System.out.println(output3ForNineTy);

        String expect3 = "the parameter value must be between 0 and 9";
        String expect3ForNineTy = "ad ae af bd be bf cd ce cf";

        Assert.assertEquals(expect3,output3);
        Assert.assertEquals(expect3ForNineTy,output3ForNineTy);
    }

    /**
     * range test
     */
    @Test
    public void testRangeOfGetLetterCombinations(){
        String output4  = appZeroToNine.getLetterCombinations(new Integer[]{0,0});
        String output5  = appZeroToNine.getLetterCombinations(new Integer[]{9,9});
        String output5ForNinety = appZeroToNinety.getLetterCombinations(new Integer[]{99,99});
        String output6   = appZeroToNine.getLetterCombinations(new Integer[]{9,10});
        String output6ForNinety = appZeroToNinety.getLetterCombinations(new Integer[]{99,100});
        String output7 = appZeroToNine .getLetterCombinations(new Integer[]{10,9});
        String output7ForNinety = appZeroToNinety.getLetterCombinations(new Integer[]{100,99});
        String output8 = appZeroToNine.getLetterCombinations(new Integer[]{-1,0});
        String output9  = appZeroToNine.getLetterCombinations(new Integer[]{0,-1});
        String output10   = appZeroToNine.getLetterCombinations(new Integer[]{-1,-1});
        String output11   = appZeroToNine.getLetterCombinations(new Integer[]{10,10});
        String output11ForNinety  = appZeroToNinety.getLetterCombinations(new Integer[]{100,100});

        String expect4  = "";
        String expect5  = "ww wx wy wz xw xx xy xz yw yx yy yz zw zx zy zz";
        String expect5Ninety = "wwww wwwx wwwy wwwz wwxw wwxx wwxy wwxz wwyw wwyx wwyy wwyz wwzw wwzx wwzy wwzz wxww wxwx wxwy wxwz wxxw wxxx wxxy wxxz wxyw wxyx wxyy wxyz wxzw wxzx wxzy wxzz wyww wywx wywy wywz wyxw wyxx wyxy wyxz wyyw wyyx wyyy wyyz wyzw wyzx wyzy wyzz wzww wzwx wzwy wzwz wzxw wzxx wzxy wzxz wzyw wzyx wzyy wzyz wzzw wzzx wzzy wzzz xwww xwwx xwwy xwwz xwxw xwxx xwxy xwxz xwyw xwyx xwyy xwyz xwzw xwzx xwzy xwzz xxww xxwx xxwy xxwz xxxw xxxx xxxy xxxz xxyw xxyx xxyy xxyz xxzw xxzx xxzy xxzz xyww xywx xywy xywz xyxw xyxx xyxy xyxz xyyw xyyx xyyy xyyz xyzw xyzx xyzy xyzz xzww xzwx xzwy xzwz xzxw xzxx xzxy xzxz xzyw xzyx xzyy xzyz xzzw xzzx xzzy xzzz ywww ywwx ywwy ywwz ywxw ywxx ywxy ywxz ywyw ywyx ywyy ywyz ywzw ywzx ywzy ywzz yxww yxwx yxwy yxwz yxxw yxxx yxxy yxxz yxyw yxyx yxyy yxyz yxzw yxzx yxzy yxzz yyww yywx yywy yywz yyxw yyxx yyxy yyxz yyyw yyyx yyyy yyyz yyzw yyzx yyzy yyzz yzww yzwx yzwy yzwz yzxw yzxx yzxy yzxz yzyw yzyx yzyy yzyz yzzw yzzx yzzy yzzz zwww zwwx zwwy zwwz zwxw zwxx zwxy zwxz zwyw zwyx zwyy zwyz zwzw zwzx zwzy zwzz zxww zxwx zxwy zxwz zxxw zxxx zxxy zxxz zxyw zxyx zxyy zxyz zxzw zxzx zxzy zxzz zyww zywx zywy zywz zyxw zyxx zyxy zyxz zyyw zyyx zyyy zyyz zyzw zyzx zyzy zyzz zzww zzwx zzwy zzwz zzxw zzxx zzxy zzxz zzyw zzyx zzyy zzyz zzzw zzzx zzzy zzzz";
        String expect6  = "the parameter value must be between 0 and 9";
        String expect6Ninety = "the parameter value must be between 0 and 99";

        Assert.assertEquals(expect4,output4);
        Assert.assertEquals(expect5,output5);
        Assert.assertEquals(expect5Ninety,output5ForNinety);
        Assert.assertEquals(expect6,output6);
        Assert.assertEquals(expect6Ninety,output6ForNinety);
        Assert.assertEquals(expect6,output7);
        Assert.assertEquals(expect6Ninety,output7ForNinety);
        Assert.assertEquals(expect6,output8);
        Assert.assertEquals(expect6,output9);
        Assert.assertEquals(expect6,output10);
        Assert.assertEquals(expect6,output11);
        Assert.assertEquals(expect6Ninety,output11ForNinety);
    }

    /**
     * existence test
     */
    @Test
    public void testExistOfGetLetterCombinations(){
        String output3 = appZeroToNine .getLetterCombinations(null);
        String output12   = appZeroToNine .getLetterCombinations(new Integer[]{});
        String output13 = appZeroToNine .getLetterCombinations(new Integer[]{null});
        String output14 = appZeroToNine .getLetterCombinations(new Integer[]{2,null});
        String output14ForNineTy = appZeroToNinety.getLetterCombinations(new Integer[]{23,null});
        String output15  = appZeroToNine .getLetterCombinations(new Integer[]{null,2});
        String output15ForNineTy = appZeroToNinety.getLetterCombinations(new Integer[]{null,23});
        String output16  = appZeroToNine .getLetterCombinations(new Integer[]{null,null});

        String expect3 = "value cannot be null";

        Assert.assertEquals(expect3,output3);
        Assert.assertEquals(expect3,output12);
        Assert.assertEquals(expect3,output13);
        Assert.assertEquals(expect3,output14);
        Assert.assertEquals(expect3,output14ForNineTy);
        Assert.assertEquals(expect3,output15);
        Assert.assertEquals(expect3,output15ForNineTy);
        Assert.assertEquals(expect3,output16);
    }

    /**
     * Exception test
     */
    @Test
    public void testExceptionOfGetLetterCombinationsFor9(){
        try {
            appZeroToNine .getLetterCombinations(new Integer[]{5});
            Assert.fail();
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    /**
     * Exception test
     */
    @Test
    public void testExceptionOfGetLetterCombinationsFor99(){
        try {
            appZeroToNinety.getLetterCombinations(new Integer[]{55});
            Assert.fail();
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }




}
