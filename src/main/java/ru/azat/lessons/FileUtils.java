package ru.azat.lessons;

import java.io.*;

public class FileUtils {
    public static void main(String[] args) {

    }

    public static void readFIleChar(File file) throws IOException {
        FileInputStream fis = new FileInputStream(file);
        StringBuilder stringBuilder = new StringBuilder();
        int nextByte;
        while ((nextByte = fis.read()) != -1){
            stringBuilder.append((char)nextByte);
        }
    }
}
