package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;

public class WriteSymptomDataToFile implements ISymptomWriter {


    @Override
    public void writeSymptoms(Map<String, Integer> symptoms) throws IOException {

        try {
            FileWriter writer = new FileWriter ("result.out");

            for(Map.Entry<String, Integer> entry : symptoms.entrySet()) {
                writer.write(entry.getKey()+ ":" +entry.getValue() + "\n");
            }
            writer.close();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
