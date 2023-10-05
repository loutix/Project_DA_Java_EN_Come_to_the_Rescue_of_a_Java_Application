package com.hemebiotech.analytics;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {
    public ISymptomReader iSymptomReader;
    public ISymptomWriter iSymptomWriter;

    public AnalyticsCounter(ISymptomReader iSymptomReader, ISymptomWriter iSymptomWriter) {
        this.iSymptomReader = iSymptomReader;
        this.iSymptomWriter = iSymptomWriter;
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

    /**
     * Count occurrences of each existing symptom
     *
     * @param symptoms
     * @return symptomsOccurrence
     */
    public Map<String, Integer> countSymptoms(List<String> symptoms) {

        Map<String, Integer> symptomsOccurrence = new HashMap<>();

        for (String symptom : symptoms) {
            symptomsOccurrence.putIfAbsent(symptom, 0);
            symptomsOccurrence.put(symptom, symptomsOccurrence.get(symptom) + 1);
        }

        return symptomsOccurrence;
    }

    /**
     * Sort alphabetically the key of symptoms maps
     *
     * @param symptoms
     * @return symptomsSorted
     */
    public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {

        TreeMap<String, Integer> symptomsSorted = new TreeMap<>(symptoms);

        for (Map.Entry<String, Integer> entry : symptomsSorted.entrySet()) {
            System.out.print(entry.getKey());
            System.out.println(":" + entry.getValue());
        }
        return symptomsSorted;
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
