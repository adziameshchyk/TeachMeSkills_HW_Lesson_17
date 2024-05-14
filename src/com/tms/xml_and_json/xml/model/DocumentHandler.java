package com.tms.xml_and_json.xml.model;

import java.io.*;

public class DocumentHandler {

    private static DocumentHandler instance;
    private static File file;

    private DocumentHandler(File file) {
        DocumentHandler.file = file;
    }

    public static DocumentHandler getInstance(String fileName) {
        if (instance != null) {
            File newFile = new File(fileName);
            if (newFile.getAbsolutePath().equals(file.getAbsolutePath())) {
                return instance;
            }
        }
        instance = new DocumentHandler(new File(fileName));
        return instance;
    }

    public void write(String string) {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {

            writer.write(string);
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void write(StringBuilder sb) {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {

            writer.write(sb.toString());
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
