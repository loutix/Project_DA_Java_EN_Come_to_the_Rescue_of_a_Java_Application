package com.hemebiotech.analytics;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter implements ISymptonCounter {

    public ISymptomReader iSymptomReader;
    public ISymptomWriter iSymptomWriter;

    public AnalyticsCounter(final String SYMPTOMS_FILE_PATH, final String SAVE_FILE_PATH) throws IOException {
        this.iSymptomReader = new ReadSymptomDataFromFile(SYMPTOMS_FILE_PATH);
        this.iSymptomWriter = new WriteSymptomDataToFile(SAVE_FILE_PATH);

        // add symptoms in ArrayList
        List<String> symptomsList = this.getSymptoms();
        // count symptoms
        Map<String, Integer> symptomsCounted = this.countSymptoms(symptomsList);
        // write out file
        this.writeSymptoms(symptomsCounted);
    }

    /**
     * Read data from resources adn return a List<String> symptoms
     *
     * @return List<String>
     */
    public List<String> getSymptoms() {
        try {
            return iSymptomReader.getSymptoms();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public Map<String, Integer> countSymptoms(List<String> symptoms) {
        Map<String, Integer> symptomsOccurrence = new TreeMap<>();

        for (String symptom : symptoms) {
            symptomsOccurrence.putIfAbsent(symptom, 0);
            symptomsOccurrence.put(symptom, symptomsOccurrence.get(symptom) + 1);
        }

        return symptomsOccurrence;
    }

    /**
     * Writes the result in output file
     *
     * @param symptoms
     */
    public void writeSymptoms(Map<String, Integer> symptoms) throws IOException {
        iSymptomWriter.writeSymptoms(symptoms);
    }
}
