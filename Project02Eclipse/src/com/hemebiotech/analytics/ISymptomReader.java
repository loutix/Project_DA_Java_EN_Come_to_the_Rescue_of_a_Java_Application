package com.hemebiotech.analytics;

import java.io.FileNotFoundException;
import java.util.List;

public interface ISymptomReader {

    List<String> getSymptoms() throws FileNotFoundException;
}
