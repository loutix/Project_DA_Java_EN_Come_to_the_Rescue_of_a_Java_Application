package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

public interface ISymptonCounter {
    /**
     * Count occurrences of each existing symptom
     *
     * @param symptoms
     * @return symptomsOccurrence
     */
    public Map<String, Integer> countSymptoms(List<String> symptoms);
}

