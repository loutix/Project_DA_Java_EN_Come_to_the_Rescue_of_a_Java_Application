package com.hemebiotech.analytics;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class ReadSymptomDataFromFile implements ISymptomReader {

    private final String FILEPATH;

    /**
     * @param FILEPATH
     */
    public ReadSymptomDataFromFile(String FILEPATH) throws FileNotFoundException {

        if (FILEPATH == null || FILEPATH.isEmpty()) {
            throw new FileNotFoundException("Erreur le path du fichier est null ou vide");
        }

        this.FILEPATH = FILEPATH;
    }

    /**
     * Read data from resources adn return a List<String> symptoms
     *
     * @return ArrayList<String> symptomsList
     */

    @Override
    public List<String> getSymptoms() {
        ArrayList<String> symptomsList = new ArrayList<String>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(FILEPATH));
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
