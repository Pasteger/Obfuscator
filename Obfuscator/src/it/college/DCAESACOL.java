package it.college;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** Класс для удаления комментариев, удаления лишних пробелов и записи кода в одну линию*/

//DCAESACOL это абревиатура DeletingCommentsAndDeletingExtraSpaceAndCodeInOneLine
class DCAESACOL {
    public static String deletingCommentsAndDeletingExtraSpaceAndCodeInOneLine(StringBuilder text) {

        int i = 0;
        boolean thisIsString = false;
        // //..., /*...*/ и \n удаляются только если они не написаны внутри строки
        while (true) {
            try {
                char symbol = text.charAt(i);
                i++;
                if (symbol == '\"' & !thisIsString) {
                    thisIsString = true;
                    continue;
                }
                if (symbol == '\"' & thisIsString) {
                    if (text.charAt(i - 2) == '\\') {
                        continue;
                    }
                    thisIsString = false;
                    continue;
                }
                //Удаление однострочных комментариев
                if (symbol == '/' & text.charAt(i) == '/' & !thisIsString) {
                    int index = i - 1;
                    while (true) {
                        char stop = text.charAt(index);
                        if (stop == '\n') {
                            text.setCharAt(index, ' ');
                            break;
                        }
                        text.setCharAt(index, ' ');
                        index++;
                    }
                }
                //Удаление многострочных комментариев
                if (symbol == '/' & text.charAt(i) == '*' & !thisIsString) {
                    int index = i - 1;
                    while (true) {
                        char stop = text.charAt(index);
                        if (stop == '*' & text.charAt(index+1) == '/') {
                            text.setCharAt(index, ' ');
                            text.setCharAt(index+1, ' ');
                            break;
                        }
                        text.setCharAt(index, ' ');
                        index++;
                    }
                }
                //Удаление переходов на новую строку
                if (symbol == '\n' & !thisIsString) {
                    int index = i - 1;
                    text.setCharAt(index, ' ');
                }

            } catch (Exception e) {
                break;
            }
        }

        //Нет, то было не удаление, сейчас вместо комментариев пробелы. Эта маленькая регулярка удалит лишние пробелы
        Pattern commentPattern = Pattern.compile(" +");
        Matcher matcher = commentPattern.matcher(text);

        return matcher.replaceAll(" ");
    }
}
