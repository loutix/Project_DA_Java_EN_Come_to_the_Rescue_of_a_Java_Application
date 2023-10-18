package com.hemebiotech.analytics;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriteSymptomDataToFile implements ISymptomWriter {


    private final String directoryPath;

    /**
     * Control if path is null or empty
     *
     * @param directoryPath
     */
    public WriteSymptomDataToFile(String directoryPath) {

        if (directoryPath == null || directoryPath.isEmpty()) {
            throw new NullPointerException("Erreur le path directory est null ou vide");
        }
        this.directoryPath = directoryPath;
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
