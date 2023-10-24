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

        File path = new File(directoryPath);

        if(!path.exists()){
            path.getParentFile().mkdir();
        }

        FileWriter writer = new FileWriter(directoryPath);

        for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {
            final String line = entry.getKey() + ":" + entry.getValue();

            System.out.println(line);

            writer.write(line + "\n");

        }
        writer.close();
    }
}
