package it.college;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class ReplaceClassName {

    public static String replaceClassName(String text) {

        //Если класс public, то его название нельзя менять
        Pattern publicPattern = Pattern.compile("public.?class");
        Matcher publicMatcher = publicPattern.matcher(text);
        if (publicMatcher.find()) {
            return text;
        }

        Pattern commentPattern = Pattern.compile("class\\s(\\w{2,})\\s");
        Matcher matcher = commentPattern.matcher(text);
        if(!matcher.find()){
            return text;
        }
        int start = matcher.start();
        int end = matcher.end();
        String oldName = text.substring(start + 6, end - 1);
        String newName = ClassForSavingNewReplacedClassName.giveNewClassName(oldName);

        return matcher.replaceFirst("class " + newName + " ");
    }

    //Классы использзуются в других классах проекта,
    //значит если изменились их названия - нужно изменить их названия там,
    //где они используются
    public static String replaceDeclaredClassName(String text) {
        String result = text;

        ArrayList<String> oldNames = ClassForSavingNewReplacedClassName.getOldsClassNames();
        for (String oldName : oldNames) {
            String newName = ClassForSavingNewReplacedClassName.giveNewClassName(oldName);

            //Может существовать множество вариаций вызова класса из другого класса,
            //Все они прописаны здесь

            //вариация 1
            Pattern pattern = Pattern.compile("\\s" + oldName + "\\s");
            Matcher matcher = pattern.matcher(result);
            result = matcher.replaceAll(" " + newName + " ");

            //вариация 2
            pattern = Pattern.compile("\\s" + oldName + "\\.");
            matcher = pattern.matcher(result);
            result = matcher.replaceAll(" " + newName + ".");

            //вариация 3
            pattern = Pattern.compile("\\s" + oldName + "\\(");
            matcher = pattern.matcher(result);
            result = matcher.replaceAll(" " + newName + "(");


            //вариация 4
            pattern = Pattern.compile("\\." + oldName + "\\s");
            matcher = pattern.matcher(result);
            result = matcher.replaceAll("." + newName + " ");

            //вариация 5
            pattern = Pattern.compile("\\." + oldName + "\\.");
            matcher = pattern.matcher(result);
            result = matcher.replaceAll("." + newName + ".");

            //вариация 6
            pattern = Pattern.compile("\\." + oldName + "\\(");
            matcher = pattern.matcher(result);
            result = matcher.replaceAll("." + newName + "(");


            //вариация 7
            pattern = Pattern.compile("\\(" + oldName + "\\s");
            matcher = pattern.matcher(result);
            result = matcher.replaceAll("(" + newName + " ");

            //вариация 8
            pattern = Pattern.compile("\\(" + oldName + "\\.");
            matcher = pattern.matcher(result);
            result = matcher.replaceAll("(" + newName + ".");

            //вариация 9
            pattern = Pattern.compile("\\(" + oldName + "\\(");
            matcher = pattern.matcher(result);
            result = matcher.replaceAll("(" + newName + "(");


            //вариация 10
            pattern = Pattern.compile("!" + oldName + "\\s");
            matcher = pattern.matcher(result);
            result = matcher.replaceAll("!" + newName + " ");

            //вариация 11
            pattern = Pattern.compile("!" + oldName + "\\.");
            matcher = pattern.matcher(result);
            result = matcher.replaceAll("!" + newName + ".");

            //вариация 12
            pattern = Pattern.compile("!" + oldName + "\\(");
            matcher = pattern.matcher(result);
            result = matcher.replaceAll("!" + newName + "(");
        }

        return result;
    }
}
