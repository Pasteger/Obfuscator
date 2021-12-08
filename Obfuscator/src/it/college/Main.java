package it.college;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

//Пример файлов для обфусцирования, которые можно вводить
/*
D:\\Programs\\JavaProject\\DownloadFilesObfuscator\\src\\it\\colledge\\download\\DownloadMusic.java
D:\\Programs\\JavaProject\\DownloadFilesObfuscator\\src\\it\\colledge\\download\\FilesDownloaded.java
D:\\Programs\\JavaProject\\DownloadFilesObfuscator\\src\\it\\colledge\\download\\DownloadPicture.java
D:\\Programs\\JavaProject\\DownloadFilesObfuscator\\src\\it\\colledge\\download\\ParallelDownload.java
D:\\Programs\\JavaProject\\DownloadFilesObfuscator\\src\\it\\colledge\\download\\DownloadUsingNIO.java
D:\\Programs\\JavaProject\\DownloadFilesObfuscator\\src\\it\\colledge\\download\\MP3Player.java
D:\\Programs\\JavaProject\\DownloadFilesObfuscator\\src\\it\\colledge\\download\\Main.java
D:\\Programs\\JavaProject\\DownloadFilesObfuscator\\src\\it\\colledge\\download\\ThisIsThread.java
*/

public class Main {
    private static ArrayList<String> FILES = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                Добро пожаловать в обфускатор o/
                Введите в консоль адреса java-файлов проекта, что вы хотите обфусцировать, в определённом проекте
                Обратите внимание, что из-за переименования классов, придётся обфусцировать все файлы проекта,
                где используются остальные его классы!
                Вводите все адреса по образцу:
                D:\\Project\\src\\com\\company\\Class.java
                Чтобы завершить ввод введите 0.
                Ввод:
                """);

        while (true) {
            String file = scanner.next();
            if (file.equals("0")) {
                break;
            }
            //В строковый массив вносятся адреса java-файлов
            FILES.add(file);
        }

        System.out.println("Замечательно! Начинаем работу!");

        StringBuilder textInFile;
        String newTextInFile;

        for (String file : FILES) {
            //Содержимое файла записывается в строку
            textInFile = ReadingAndWritingFile.readingFile(file);
            if (textInFile.toString().equals("Error")){
                System.out.println("Не удалось считать файл " + file);
                continue;
            }

            //Ну здесь и комментировать нет смысла, названия методов говорят сами за себя
            System.out.println("deletingCommentsAndDeletingExtraSpaceAndCodeInOneLine " + file);
            newTextInFile = DCAESACOL.deletingCommentsAndDeletingExtraSpaceAndCodeInOneLine(textInFile);

            System.out.println("replaceIdentifierName " + file);
            newTextInFile = ReplaceIdentifierName.replaceIdentifierName(newTextInFile);
            System.out.println("replaceClassName " + file);
            newTextInFile = ReplaceClassName.replaceClassName(newTextInFile);

            ReadingAndWritingFile.writingFile(file, newTextInFile);
        }

        for (String file : FILES) {
            textInFile = ReadingAndWritingFile.readingFile(file);
            System.out.println("replaceDeclaredClassName " + file);
            newTextInFile = ReplaceClassName.replaceDeclaredClassName(textInFile.toString());
            ReadingAndWritingFile.writingFile(file, newTextInFile);
        }
    }
}
