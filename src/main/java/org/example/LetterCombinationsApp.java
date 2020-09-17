package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Arrays;
/**
 *
 * @author dreamguy
 * @date 2020/9/17
 */
public class LetterCombinationsApp{
    private static class LetterCombinationsAppHolder {
        private static final LetterCombinationsApp INSTANCE = new LetterCombinationsApp();
    }
    private LetterCombinationsApp (){}
    public static final LetterCombinationsApp getInstance() {
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


    public String getLetterCombinations(Integer[] inputArr) {
        if(inputArr == null || inputArr.length == 0){
            return "-1";
        }

        List<String> letterList = new ArrayList<>();
        if(inputArr.length<2){
            letterList = Arrays.asList(INTEGER_MAP.get(inputArr[0]));
        }else {
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

        return  letterList.toString().replaceAll("(\\[|\\]|\\,)", "");
    }


}
