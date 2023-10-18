package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class CountSymptomData implements ISymptomCounter {
    /**
     * Count and sort symptoms occurrences
     *
     * @param symptoms<String> symptoms
     * @return Map<String, Integer> symptomsOccurrence
     */

    public Map<String, Integer> countSymptoms(List<String> symptoms) {
        Map<String, Integer> symptomsOccurrence = new TreeMap<>();

        symptoms.forEach(symptom -> {
            symptomsOccurrence.putIfAbsent(symptom, 0);
            symptomsOccurrence.put(symptom, symptomsOccurrence.get(symptom) + 1);
        });

        return symptomsOccurrence;
    }
}
