package com.hemebiotech.analytics;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriteSymptomDataToFile implements ISymptomWriter {


    private final String SAVE_FILE_PATH;

    public WriteSymptomDataToFile(String SAVE_FILE_PATH) {

        if (SAVE_FILE_PATH == null || SAVE_FILE_PATH.isEmpty()) {
            throw new NullPointerException("Erreur le path directory est null ou vide");
        }
        this.SAVE_FILE_PATH = SAVE_FILE_PATH;
    }

    @Override
    public void writeSymptoms(Map<String, Integer> symptoms) throws IOException {


        try {
            File directory = new File(SAVE_FILE_PATH);
            directory.mkdir();

            FileWriter writer = new FileWriter(new File(directory, "result.out"));

            for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {
                writer.write(entry.getKey() + ":" + entry.getValue() + "\n");
            }
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException("Erreur lors de l'écriture du fichier");
        }
    }
}
