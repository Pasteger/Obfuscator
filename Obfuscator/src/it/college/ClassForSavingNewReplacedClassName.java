package it.college;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class ClassForSavingNewReplacedClassName {
    private static int numberOfNamedReplaced = 0;

    private static Map<String, String> oldsAndNewsClassesNames = new HashMap<>();

    private static String[] newsClassesNames = {
            "A","B","C","D","E","F","G", "H", "I", "J"};

    private static ArrayList<String> oldsClassNames = new ArrayList<>();

    public static String giveNewClassName(String oldClassName){
        if(!oldsAndNewsClassesNames.containsKey(oldClassName)){
            oldsAndNewsClassesNames.put(oldClassName, newsClassesNames[numberOfNamedReplaced]);
            oldsClassNames.add(oldClassName);
        }
        numberOfNamedReplaced++;
        return oldsAndNewsClassesNames.get(oldClassName);
    }

    public static ArrayList<String> getOldsClassNames(){
        return oldsClassNames;
    }
}
