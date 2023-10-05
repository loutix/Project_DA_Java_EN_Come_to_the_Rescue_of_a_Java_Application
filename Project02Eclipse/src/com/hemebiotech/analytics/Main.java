package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {

        // path resource
        final String ROOT = ".\\Project02Eclipse\\src\\resources\\";
        String fileName = "symptoms.txt";

        ReadSymptomDataFromFile readSymptomDataFromFile = new ReadSymptomDataFromFile(ROOT + fileName);
        WriteSymptomDataToFile writeSymptomDataToFile = new WriteSymptomDataToFile();
        AnalyticsCounter analyticsCounter = new AnalyticsCounter(readSymptomDataFromFile, writeSymptomDataToFile);

        // add symptoms in ArrayList
        List<String> symptomsList = analyticsCounter.getSymptoms();

        // count symptoms
        Map<String, Integer> symptomsCounted = analyticsCounter.countSymptoms(symptomsList);

        // sort symptoms map
        Map<String, Integer> symptomsSorted = analyticsCounter.sortSymptoms(symptomsCounted);

        // write out file
        analyticsCounter.writeSymptoms(symptomsSorted);
    }
}
