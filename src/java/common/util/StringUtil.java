package common.util;

import static java.lang.String.join;
import java.util.ArrayList;
import java.util.List;

public class StringUtil {
    public static boolean isBlank(String s){
        if( null == s || s.isEmpty() || 0 == s.trim().length()){
            return true;
        }
        else {
            return false;
        }
    }
    public static String dateConvert(String s){
        return String.join("", s.split("-"));
    }
    public static String filmTagConvert(String s){
        List results=new ArrayList<String>();
        for(int i = 0; i<s.length(); i+=2)
            results.add(s.substring(i, i+2));
        return String.join(" ", results);
    }
}
