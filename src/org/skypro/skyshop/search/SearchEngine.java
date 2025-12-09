package org.skypro.skyshop.search;

import org.skypro.skyshop.BestResultNotFound;

public class SearchEngine {
    private final Searchable[] searchables;

    public SearchEngine(int size) { searchables = new Searchable[size]; }

    public void add(Searchable searchable) {
        for (int i = 0; i < searchables.length; i++) {
            if (searchables[i] == null) {
                searchables[i] = searchable;
                break;
            }
        }
    }
    public int maxResult(String query, String str) {
        int count = 0;
        for ( int index = 0; (index = str.indexOf(query, index)) != -1; index += query.length()) {
            count++;
        }
        return count;
    }

    public Searchable bestResult(String query) throws BestResultNotFound {
        int maxScore = 0;
        Searchable best = null;
        for (Searchable searchable : searchables) {
            if (searchable == null || !searchable.getSearchTerm().contains(query)) {
                continue;
            }
            int score = maxResult(query, searchable.getSearchTerm());
            if (score > maxScore) {
                best = searchable;
                maxScore = score;
            }
        }
         checkBestResultNotNull(best);
        return best;
    }

    private void checkBestResultNotNull(Searchable best) throws BestResultNotFound {
        if (best == null){
            throw new BestResultNotFound("Ничего не найдено");
        }
    }

}