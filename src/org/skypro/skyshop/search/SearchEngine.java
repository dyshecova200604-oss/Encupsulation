package org.skypro.skyshop.search;

import org.skypro.skyshop.BestResultNotFound;
import java.util.*;
import java.util.stream.Collectors;
public class SearchEngine {
    private final Set<Searchable> searchables;

    public SearchEngine() {
        searchables = new HashSet<>();
    }

    public void add(Searchable searchable) {
        searchables.add(searchable);
    }

    public int maxResult(String query, String str) {
        int count = 0;
        for ( int index = 0; (index = str.indexOf(query, index)) != -1; index += query.length()) {
            count++;
        }
        return count;
    }

    public TreeSet<Searchable> search(String query){
        TreeSet<Searchable> set = searchables.stream()
                .filter(searchable -> searchable != null && searchable.getSearchTerm().contains(query))
                .collect(Collectors.toCollection(() -> new TreeSet<>(new org.skypro.skyshop.search.SearchComparator())));
        if (set.isEmpty()){
            System.out.println("Поиск не дал результатов");
        }
        return set;
    }

    public Searchable bestResult(String query) throws BestResultNotFound {
        TreeSet<Searchable> results = search(query);

        Searchable best = results.stream()
                .filter(searchable -> searchable != null && searchable.getSearchTerm().contains(searchable.getName()))
                .max(Comparator.comparingInt(searchable -> maxResult(query, searchable.getSearchTerm())))
                .orElseThrow(() -> new BestResultNotFound("Ничего не найдено"));
        return best;
    }
}
