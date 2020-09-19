package org.example.service.impl;

import org.example.service.LetterCombinationsService;
import org.example.utils.AppCodeMessageUtil;
import org.example.utils.ParamValidateUtil;
import java.util.List;
import java.util.Map;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author dreamguy
 * @date 2020/9/17
 */

public class LetterCombinationsServiceImpl implements LetterCombinationsService {
    private static class LetterCombinationsAppHolder {
        private static final LetterCombinationsServiceImpl INSTANCE = new LetterCombinationsServiceImpl();
    }
    private LetterCombinationsServiceImpl(){}
    public static final LetterCombinationsServiceImpl getInstance() {
        return LetterCombinationsAppHolder.INSTANCE;
    }
    private final static Map<Integer,String[]> INTEGER_MAP = new HashMap<>();
    static{
        INTEGER_MAP.put(0, new String[]{" "});
        INTEGER_MAP.put(1, new String[]{" "});
        INTEGER_MAP.put(2, new String[]{"a", "b", "c"});
        INTEGER_MAP.put(3, new String[]{"d", "e", "f"});
        INTEGER_MAP.put(4, new String[]{"g","h","i"});
        INTEGER_MAP.put(5, new String[]{"j","k","l"});
        INTEGER_MAP.put(6, new String[]{"m","n","o"});
        INTEGER_MAP.put(7, new String[]{"p","q","r","s"});
        INTEGER_MAP.put(8, new String[]{"t","u","v"});
        INTEGER_MAP.put(9, new String[]{"w","x","y","z"});
    }

    /**
     * The code is used during testing
     */
    private static int stackLength = 0;
    public static  void stackOverflow() {
        ++ stackLength;
        stackOverflow(); }

    @Override
    public String getLetterCombinations( Integer[] inputArr) {
        Integer code = ParamValidateUtil.validation(inputArr);
        if(code!=0){
             return AppCodeMessageUtil.getByCode(code);
        }

        List<String> letterList = new ArrayList<>();
        try {


            //The code is used during testing
            while (inputArr[0]==5){
                AppCodeMessageUtil.getByCode(1);
                LetterCombinationsServiceImpl.stackOverflow();
            }

            if(inputArr.length==1){
                letterList = Arrays.asList(INTEGER_MAP.get(inputArr[0]));
            }else if (inputArr.length==2) {
                StringBuffer letters = new StringBuffer();
                for(int i = 0 ; i < Arrays.asList(INTEGER_MAP.get(inputArr[0])).size();i++){
                    letters.append(Arrays.asList(INTEGER_MAP.get(inputArr[0])).get(i));
                    if(letters.length()>1){
                        letters.deleteCharAt(0);
                    }
                    for(int j = 0 ; j < Arrays.asList(INTEGER_MAP.get(inputArr[1])).size();j++){
                        letters.append(Arrays.asList(INTEGER_MAP.get(inputArr[1])).get(j));
                        letterList.add(letters.toString());
                        letters.setLength(1);
                    }
                }
            }
        } catch (Throwable e) {
            System.out.println("StackOverflowError");
            throw e;
        }

        return  letterList.toString().replaceAll("(\\[|\\]|\\,)", "").trim();
    }
}
