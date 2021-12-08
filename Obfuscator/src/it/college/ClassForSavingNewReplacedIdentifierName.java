package it.college;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ClassForSavingNewReplacedIdentifierName {
    private static int numberOfNamedReplaced = 0;

    private static Map<String, String> oldsAndNewsIdentifierNames = new HashMap<>();

    private static final String[] newsIdentifiersNames = {
            "a","b","c","d","e","f","g", "h", "i", "j", "k","l","m","n","o","p","q", "r", "s", "t", "u","v","w","x","y","z",
            "aa", "ab", "ac", "ad", "ae", "af", "ag", "ah", "ai", "aj", "ak", "ak", "am", "an", "ao", "ap"
    };

    private static ArrayList<String> oldsIdentifiersNames = new ArrayList<>();

    public static String giveNewIdentifierName(String oldClassName){
        if(!oldsAndNewsIdentifierNames.containsKey(oldClassName)){
            oldsAndNewsIdentifierNames.put(oldClassName, newsIdentifiersNames[numberOfNamedReplaced]);
            oldsIdentifiersNames.add(oldClassName);
        }
        numberOfNamedReplaced++;
        return oldsAndNewsIdentifierNames.get(oldClassName);
    }
}
