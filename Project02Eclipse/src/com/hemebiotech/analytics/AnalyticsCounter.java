package com.hemebiotech.analytics;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class AnalyticsCounter {

    private final ISymptomReader iSymptomReader;
    private final ISymptomCounter iSymptomCounter;
    private final ISymptomWriter iSymptomWriter;

    public AnalyticsCounter(final String symptomsFilePath, final String directoryPath) throws IOException {
        this.iSymptomReader = new ReadSymptomDataFromFile(symptomsFilePath);
        this.iSymptomCounter = new CountSymptomData();
        this.iSymptomWriter = new WriteSymptomDataToFile(directoryPath);
    }

    /**
     * Read data from resources and return a List<String> symptoms
     *
     * @return List<String>
     */

    public List<String> getSymptoms() throws FileNotFoundException {
        return iSymptomReader.getSymptoms();
    }

    /**
     * Count occurrences of each existing symptom
     *
     * @param symptomsList<String> symptomsList symptoms
     * @return Map<String, Integer>
     */
    public Map<String, Integer> countSymptoms(List<String> symptomsList) {
        return this.iSymptomCounter.countSymptoms(symptomsList);
    }

    /**
     * write the contains of the map on out file
     *
     * @param symptoms<> symptoms
     */

    public void writeSymptoms(Map<String, Integer> symptoms) throws IOException {
        iSymptomWriter.writeSymptoms(symptoms);
    }

}
