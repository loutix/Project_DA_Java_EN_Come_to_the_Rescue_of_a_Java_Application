package com.hemebiotech.analytics;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class ReadSymptomDataFromFile implements ISymptomReader {

    private final String filePath;

    /**
     * Control if path is null or empty
     *
     * @param filePath
     * @throws FileNotFoundException
     */
    public ReadSymptomDataFromFile(String filePath) throws FileNotFoundException {

        if (filePath == null || filePath.isEmpty()) {
            throw new FileNotFoundException("Erreur le path du fichier est null ou vide");
        }

        this.filePath = filePath;
    }

    /**
     * Read data from resources and return a List<String> symptoms
     *
     * @return ArrayList<String> symptomsList
     */

    @Override
    public List<String> getSymptoms() {
        List<String> symptomsList = new ArrayList<String>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line = reader.readLine();
            while (line != null) {
                symptomsList.add(line);
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException("Erreur lors de la lecture du fichier");
        }

        return symptomsList;
    }

}
