package org.universities.organization_educational_process.tools;

import lombok.NonNull;

public class SupportingTools {
    private SupportingTools(){}

    public static String formationCorrectValue(@NonNull String value) {
        var firstLetter = value.substring(0, 1).toUpperCase();
        var nextWorld = value.substring(1).toLowerCase();

        return firstLetter + nextWorld;
    }
}
