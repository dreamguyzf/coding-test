package org.example.service.impl;

import org.example.service.LetterCombinationsService;
import org.example.utils.AppCodeMessageUtil;
import org.example.utils.ParamValidateUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by dreamguy on 2020/9/22.
 */

public class LetterCombinationsServiceZeroToNinetyImpl implements LetterCombinationsService {
    private static final String[] KEYS = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    @Override
    public String getLetterCombinations(Integer[] inputArr) {
        Integer code = ParamValidateUtil.InputZeroToNinetyValidate(inputArr);
        if(code!=0){
            return AppCodeMessageUtil.getByCode(code);
        }
        List<String> list = new ArrayList();
        try{
            while (inputArr[0]==55){
                AppCodeMessageUtil.getByCode(1);
                LetterCombinationsServiceZeroToNineImpl.stackOverflow();
            }
            String digits = Arrays.toString(inputArr).replaceAll("(\\[|\\]|\\,|\\ )", "").trim();
            digits = digits.replaceAll("1","").replaceAll("0","");
            if ("".equals(digits) || digits == null) {
                return list.toString();
            }
            int[] index = new int[]{0};
            backTracking(list,"", digits, index);
        }catch (Throwable e) {
            System.out.println("StackOverflowError");
            throw e;
        }
        return list.toString().replaceAll("(\\[|\\]|\\,)", "").trim();
    }

    public void backTracking(List<String> list,String combination, String digits, int[] index) {
        if (index[0] == digits.length()) {
            list.add(combination);
        } else {
            int k = Integer.valueOf(digits.substring(index[0], index[0] + 1));
            String letters = KEYS[k];
            index[0]++;
            for (int i = 0; i < letters.length(); i++) {
                String letter = letters.substring(i, i + 1);
                backTracking(list,combination + letter, digits, index);
            }
            index[0]--;
        }
    }
}
