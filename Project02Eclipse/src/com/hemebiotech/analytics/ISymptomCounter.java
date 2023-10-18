package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

public interface ISymptomCounter {
    /**
     * Count occurrences of each existing symptom
     *
     * @param symptoms<String> symptoms
     * @return symptomsOccurrence
     */
    Map<String, Integer> countSymptoms(List<String> symptoms);
}

