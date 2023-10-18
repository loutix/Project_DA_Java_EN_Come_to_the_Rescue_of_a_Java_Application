package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Main {
    final static String SYMPTOMS_FILE_PATH = ".\\src\\resources\\symptoms.txt";
    final static String DIRECTORY_PATH = ".\\src\\writer";


    public static void main(String[] args) throws IOException {
        AnalyticsCounter analyticsCounter = new AnalyticsCounter(SYMPTOMS_FILE_PATH, DIRECTORY_PATH);

        // add symptoms in ArrayList
        final List<String> symptomsList = analyticsCounter.getSymptoms();

        // count symptoms
        final Map<String, Integer> symptomsCounted = analyticsCounter.countSymptoms(symptomsList);

        // write out file
        analyticsCounter.writeSymptoms(symptomsCounted);
    }
}
