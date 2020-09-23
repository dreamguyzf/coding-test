package org.example.utils;

/**
 *
 * @author dreamguy
 * @date 2020/9/17
 */


public  class ParamValidateUtil {
    public static Integer InputZeroToNineValidate( Integer[] inputArr) {
        if (inputArr == null || inputArr.length == 0) {
            return -1;
        }
        if (inputArr.length > 2) {
            return -2;
        }
        int k = 0;
        while (k < inputArr.length) {
            if (inputArr[k] == null) {
                return -1;
            } else if (inputArr[k] > 9 || inputArr[k] < 0) {
                return -2;
            }
            k++;
        }
        return 0;
    }

    public static Integer InputZeroToNinetyValidate(Integer[] inputArr){
        if (inputArr == null || inputArr.length == 0) {
            return -1;
        }
        if (inputArr.length > 4) {
            return -3;
        }
        int k = 0;
        while (k < inputArr.length) {
            if (inputArr[k] == null) {
                return -1;
            } else if (inputArr[k] > 99 || inputArr[k] < 0) {
                return -3;
            }
            k++;
        }
        return 0;
    }


}
