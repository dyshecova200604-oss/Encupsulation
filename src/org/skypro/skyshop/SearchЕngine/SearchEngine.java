package org.skypro.skyshop.SearchЕngine;

import org.skypro.skyshop.search.BestResultNotFound;
import org.skypro.skyshop.search.Searchable;

import java.util.*;
import java.util.stream.Collectors;
public class SearchEngine {
    Set<Searchable> searchables;

    public SearchEngine() {
        searchables = new HashSet<>();
    }

    public void add(Searchable searchable) {
        searchables.add(searchable);
    }
    public Set<Searchable> search(String searchTerm) {
        return searchables.stream().filter(searchable -> searchable.getSearchTerm().contains(searchTerm)).
                collect(Collectors.toCollection(() -> new TreeSet<>()));
    }
    public Searchable getSearchBestMatch(String search) throws BestResultNotFound {
        int maxScore = 0;
        Searchable result = null;
        for (Searchable searchable : searchables) {
            int score = countingIncomingElements(searchable.getSearchTerm(), search);
            if ((searchable != null) && (score > maxScore)) {
                maxScore = score;
                result = searchable;
            }
        }
        if (result == null) throw new BestResultNotFound("Для " + search + " запроса не нашлось");
        return result;
    }
    public int countingIncomingElements(String str, String subStr) {
        int count = 0;
        for (int index = 0; (index = str.indexOf(subStr, index)) != -1; index += subStr.length()) {
            count++;
        }
        return count;
    }
}