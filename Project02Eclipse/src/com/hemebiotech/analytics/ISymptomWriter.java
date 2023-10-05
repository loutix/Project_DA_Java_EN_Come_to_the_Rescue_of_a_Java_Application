package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.Map;

/**
 * Anything that will write symptom data from a Map<String, Integer>
 * <p>
 * The implementation does not need to order the list
 */

public interface ISymptomWriter {
    /**
     * write the contains of the map on out file
     *
     * @param symptoms
     * @throws IOException
     */
    public void writeSymptoms(Map<String, Integer> symptoms) throws IOException;
}
