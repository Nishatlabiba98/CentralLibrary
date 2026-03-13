package com.zipcodewilmington.centrallibrary;
import java.util.ArrayList;
import java.util.List;

public interface Searchable {
    boolean matchesKeyword(String keyword);
    String [] getSearchableFields();

    default List<String> search (String[] targets) {
        List<String> results = new ArrayList<>();
        for (String field : getSearchableFields()) {
            for (String target : targets) {
                if (field != null && field.toLowerCase().contains(target.toLowerCase())) {
                    results.add(field);
                }
            }
        }
        return results;
    }

    boolean matchesDate(String date);
    boolean matchesDateRange(String startDate, String endDate);
}




