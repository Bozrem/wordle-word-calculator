package org.example;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class Main {
    public static String[] readEndWords() throws IOException {
        Path endWordPath = FileSystems.getDefault().getPath("src", "endWords.txt");
        List<String> endWordLines = Files.readAllLines(endWordPath, Charset.defaultCharset());
        return endWordLines.toArray(new String[0]);
    } // translates endWords.txt into an array


    public static void main(String[] args) throws IOException {
        String[] endWords = readEndWords();

    }
}