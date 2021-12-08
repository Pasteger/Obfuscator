package it.college;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;

class ReadingAndWritingFile {
    public static StringBuilder readingFile(String file) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            StringBuilder text = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                text.append(line).append('\n');
            }
            return text;
        }
        catch (Exception e){
            return new StringBuilder("Error");
        }
    }

    public static void writingFile(String fileForWriting, String result) throws IOException {
        Path file = Paths.get(
                fileForWriting);
        Files.write(file, Collections.singleton(result), StandardCharsets.UTF_8);
    }
}
