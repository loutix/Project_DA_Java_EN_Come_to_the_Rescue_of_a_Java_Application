package com.hemebiotech.analytics;

import java.io.IOException;

public class Main {
    final static String SYMPTOMS_FILE_PATH = ".\\Project02Eclipse\\src\\resources\\symptoms.txt";
    final static String DIRECTORY_PATH = ".\\Project02Eclipse\\src\\writer";

    public static void main(String[] args) throws IOException {
        new AnalyticsCounter(SYMPTOMS_FILE_PATH, DIRECTORY_PATH);
    }
}
