package com.hemebiotech.analytics;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class ReadSymptomDataFromFile implements ISymptomReader {

    private String filepath;

    /**
     * @param filepath
     */
    public ReadSymptomDataFromFile(String filepath) {
        this.filepath = filepath;
    }

    /**
     * Read data from resources adn return a List<String> symptoms
     *
     * @return  ArrayList<String> symptomsList
     * @throws FileNotFoundException
     */

    @Override
    public List<String> getSymptoms() throws FileNotFoundException {
        ArrayList<String> symptomsList = new ArrayList<String>();

        if (filepath != null) {
            try {
                BufferedReader reader = new BufferedReader(new FileReader(filepath));
                String line = reader.readLine();
                while (line != null) {
                    symptomsList.add(line);
                    line = reader.readLine();
                }
                reader.close();
            } catch (IOException e) {
                throw new RuntimeException("Erreur lors de la lecture du fichier", e);
            }
        } else {
            throw new FileNotFoundException("Erreur fichier non trouvé");
        }
        return symptomsList;
    }

}
