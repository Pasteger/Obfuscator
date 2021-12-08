package it.college;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class ReplaceIdentifierName {

    private static final String[] typesIdentifier = {
            "String", "int", "boolean", "double", "float", "BufferedWriter", "BufferedReader"};
    private static final int[] LengthsOfTypesNames = {
            7, 4, 8, 7, 6, 15, 15};

    public static String replaceIdentifierName(String text) {
        String result = text;

        for (int i = 0; i < typesIdentifier.length; i++) {

            Pattern identifierPattern = Pattern.compile(typesIdentifier[i] + "\\s(\\w{2,})(\\s|;)");
            Matcher identifierMatcher = identifierPattern.matcher(result);
            while (identifierMatcher.find()) {
                int start = identifierMatcher.start();
                int end = identifierMatcher.end();
                String pattern = result.substring(start, end);
                String oldName = pattern.substring(LengthsOfTypesNames[i], pattern.length() - 1);

                String newName = ClassForSavingNewReplacedIdentifierName.giveNewIdentifierName(oldName);


                //Дальше идёт неоптимизированная громадина. Будьте осторожны

                //Вариация 1 " имя "
                String replacedOldName = " " + oldName + " ";
                String replacedNewName = " " + newName + " ";
                Pattern identifierNamePattern = Pattern.compile(replacedOldName);
                Matcher identifierNameMatcher = identifierNamePattern.matcher(result);
                result = identifierNameMatcher.replaceAll(replacedNewName);

                //Вариация 2 " имя;"
                replacedOldName = " " + oldName + ";";
                replacedNewName = " " + newName + ";";
                identifierNamePattern = Pattern.compile(replacedOldName);
                identifierNameMatcher = identifierNamePattern.matcher(result);
                result = identifierNameMatcher.replaceAll(replacedNewName);

                //Вариация 4 " имя)"
                replacedOldName = " " + oldName + "\\)";
                replacedNewName = " " + newName + "\\)";
                identifierNamePattern = Pattern.compile(replacedOldName);
                identifierNameMatcher = identifierNamePattern.matcher(result);
                result = identifierNameMatcher.replaceAll(replacedNewName);

                //Вариация 5 " имя."
                replacedOldName = " " + oldName + "\\.";
                replacedNewName = " " + newName + "\\.";
                identifierNamePattern = Pattern.compile(replacedOldName);
                identifierNameMatcher = identifierNamePattern.matcher(result);
                result = identifierNameMatcher.replaceAll(replacedNewName);

                //Вариация 6 " имя="
                replacedOldName = " " + oldName + "=";
                replacedNewName = " " + newName + "=";
                identifierNamePattern = Pattern.compile(replacedOldName);
                identifierNameMatcher = identifierNamePattern.matcher(result);
                result = identifierNameMatcher.replaceAll(replacedNewName);


                //Вариация 7 "(имя "
                replacedOldName = "\\(" + oldName + " ";
                replacedNewName = "\\(" + newName + " ";
                identifierNamePattern = Pattern.compile(replacedOldName);
                identifierNameMatcher = identifierNamePattern.matcher(result);
                result = identifierNameMatcher.replaceAll(replacedNewName);

                //Вариация 8 ".имя "
                replacedOldName = "\\." + oldName + " ";
                replacedNewName = "\\." + newName + " ";
                identifierNamePattern = Pattern.compile(replacedOldName);
                identifierNameMatcher = identifierNamePattern.matcher(result);
                result = identifierNameMatcher.replaceAll(replacedNewName);

                //Вариация 9 "=имя "
                replacedOldName = "=" + oldName + " ";
                replacedNewName = "=" + newName + " ";
                identifierNamePattern = Pattern.compile(replacedOldName);
                identifierNameMatcher = identifierNamePattern.matcher(result);
                result = identifierNameMatcher.replaceAll(replacedNewName);


                //Вариация 10 "(имя)"
                replacedOldName = "\\(" + oldName + "\\)";
                replacedNewName = "\\(" + newName + "\\)";
                identifierNamePattern = Pattern.compile(replacedOldName);
                identifierNameMatcher = identifierNamePattern.matcher(result);
                result = identifierNameMatcher.replaceAll(replacedNewName);

                //Вариация 12 "(имя."
                replacedOldName = "\\(" + oldName + "\\.";
                replacedNewName = "\\(" + newName + "\\.";
                identifierNamePattern = Pattern.compile(replacedOldName);
                identifierNameMatcher = identifierNamePattern.matcher(result);
                result = identifierNameMatcher.replaceAll(replacedNewName);

                //Вариация 13 ".имя)"
                replacedOldName = "\\." + oldName + "\\)";
                replacedNewName = "\\." + newName + "\\)";
                identifierNamePattern = Pattern.compile(replacedOldName);
                identifierNameMatcher = identifierNamePattern.matcher(result);
                result = identifierNameMatcher.replaceAll(replacedNewName);

                //Вариация 14 ".имя."
                replacedOldName = "\\." + oldName + "\\.";
                replacedNewName = "\\." + newName + "\\.";
                identifierNamePattern = Pattern.compile(replacedOldName);
                identifierNameMatcher = identifierNamePattern.matcher(result);
                result = identifierNameMatcher.replaceAll(replacedNewName);


                //Вариация 15 "=имя "
                replacedOldName = "=" + oldName + " ";
                replacedNewName = "=" + newName + " ";
                identifierNamePattern = Pattern.compile(replacedOldName);
                identifierNameMatcher = identifierNamePattern.matcher(result);
                result = identifierNameMatcher.replaceAll(replacedNewName);

                //Вариация 17 "=имя)"
                replacedOldName = "=" + oldName + "\\)";
                replacedNewName = "=" + newName + "\\)";
                identifierNamePattern = Pattern.compile(replacedOldName);
                identifierNameMatcher = identifierNamePattern.matcher(result);
                result = identifierNameMatcher.replaceAll(replacedNewName);

                //Вариация 18 "(имя="
                replacedOldName = "\\(" + oldName + "=";
                replacedNewName = "\\(" + newName + "=";
                identifierNamePattern = Pattern.compile(replacedOldName);
                identifierNameMatcher = identifierNamePattern.matcher(result);
                result = identifierNameMatcher.replaceAll(replacedNewName);

                //Вариация 19 "=имя."
                replacedOldName = "=" + oldName + "\\.";
                replacedNewName = "=" + newName + "\\.";
                identifierNamePattern = Pattern.compile(replacedOldName);
                identifierNameMatcher = identifierNamePattern.matcher(result);
                result = identifierNameMatcher.replaceAll(replacedNewName);

                //Вариация 20 ".имя="
                replacedOldName = "\\." + oldName + "=";
                replacedNewName = "\\." + newName + "=";
                identifierNamePattern = Pattern.compile(replacedOldName);
                identifierNameMatcher = identifierNamePattern.matcher(result);
                result = identifierNameMatcher.replaceAll(replacedNewName);


                //Вариация 21 " имя,"
                replacedOldName = " " + oldName + ",";
                replacedNewName = " " + newName + ",";
                identifierNamePattern = Pattern.compile(replacedOldName);
                identifierNameMatcher = identifierNamePattern.matcher(result);
                result = identifierNameMatcher.replaceAll(replacedNewName);

                //Вариация 22 "(имя,"
                replacedOldName = "\\(" + oldName + ",";
                replacedNewName = "\\(" + newName + ",";
                identifierNamePattern = Pattern.compile(replacedOldName);
                identifierNameMatcher = identifierNamePattern.matcher(result);
                result = identifierNameMatcher.replaceAll(replacedNewName);

                //Вариация 23 ".имя,"
                replacedOldName = "\\." + oldName + ",";
                replacedNewName = "\\." + newName + ",";
                identifierNamePattern = Pattern.compile(replacedOldName);
                identifierNameMatcher = identifierNamePattern.matcher(result);
                result = identifierNameMatcher.replaceAll(replacedNewName);

                //Вариация 24 ",имя)"
                replacedOldName = "," + oldName + "\\)";
                replacedNewName = "," + newName + "\\)";
                identifierNamePattern = Pattern.compile(replacedOldName);
                identifierNameMatcher = identifierNamePattern.matcher(result);
                result = identifierNameMatcher.replaceAll(replacedNewName);

                //Вариация 25 ",имя."
                replacedOldName = "," + oldName + "\\.";
                replacedNewName = "," + newName + "\\.";
                identifierNamePattern = Pattern.compile(replacedOldName);
                identifierNameMatcher = identifierNamePattern.matcher(result);
                result = identifierNameMatcher.replaceAll(replacedNewName);

                //Вариация 27 ",имя,"
                replacedOldName = "," + oldName + "\\(";
                replacedNewName = "," + newName + "\\(";
                identifierNamePattern = Pattern.compile(replacedOldName);
                identifierNameMatcher = identifierNamePattern.matcher(result);
                result = identifierNameMatcher.replaceAll(replacedNewName);


                //Вариация 28 " имя+"
                replacedOldName = " " + oldName + "\\+";
                replacedNewName = " " + newName + "\\+";
                identifierNamePattern = Pattern.compile(replacedOldName);
                identifierNameMatcher = identifierNamePattern.matcher(result);
                result = identifierNameMatcher.replaceAll(replacedNewName);

                //Вариация 29 "+имя "
                replacedOldName = "\\+" + oldName + " ";
                replacedNewName = "\\+" + newName + " ";
                identifierNamePattern = Pattern.compile(replacedOldName);
                identifierNameMatcher = identifierNamePattern.matcher(result);
                result = identifierNameMatcher.replaceAll(replacedNewName);

                //Вариация 30 "+имя+"
                replacedOldName = "\\+" + oldName + "\\+";
                replacedNewName = "\\+" + newName + "\\+";
                identifierNamePattern = Pattern.compile(replacedOldName);
                identifierNameMatcher = identifierNamePattern.matcher(result);
                result = identifierNameMatcher.replaceAll(replacedNewName);

                //Вариация 31 " имя-"
                replacedOldName = " " + oldName + "-";
                replacedNewName = " " + newName + "-";
                identifierNamePattern = Pattern.compile(replacedOldName);
                identifierNameMatcher = identifierNamePattern.matcher(result);
                result = identifierNameMatcher.replaceAll(replacedNewName);

                //Вариация 32 "-имя "
                replacedOldName = "-" + oldName + " ";
                replacedNewName = "-" + newName + " ";
                identifierNamePattern = Pattern.compile(replacedOldName);
                identifierNameMatcher = identifierNamePattern.matcher(result);
                result = identifierNameMatcher.replaceAll(replacedNewName);

                //Вариация 33 "-имя-"
                replacedOldName = "-" + oldName + "-";
                replacedNewName = "-" + newName + "-";
                identifierNamePattern = Pattern.compile(replacedOldName);
                identifierNameMatcher = identifierNamePattern.matcher(result);
                result = identifierNameMatcher.replaceAll(replacedNewName);


                //Вариация 34 " имя!"
                replacedOldName = " " + oldName + "!";
                replacedNewName = " " + newName + "!";
                identifierNamePattern = Pattern.compile(replacedOldName);
                identifierNameMatcher = identifierNamePattern.matcher(result);
                result = identifierNameMatcher.replaceAll(replacedNewName);

                //Вариация 35 "!имя "
                replacedOldName = "!" + oldName + " ";
                replacedNewName = "!" + newName + " ";
                identifierNamePattern = Pattern.compile(replacedOldName);
                identifierNameMatcher = identifierNamePattern.matcher(result);
                result = identifierNameMatcher.replaceAll(replacedNewName);
                //не закончено

                //Слава Богу, она закончилась!

                identifierMatcher = identifierPattern.matcher(result);
            }
        }
        return result;
    }
}
