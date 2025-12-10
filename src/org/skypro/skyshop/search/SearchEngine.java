
package org.skypro.skyshop.search;
import org.skypro.skyshop.BestResultNotFound;
import java.util.ArrayList;
import java.util.List;
public class SearchEngine{
    private final List<Searchable> searchables;

    public SearchEngine() {
        this.searchables = new ArrayList<>();
    }

    public void add(Searchable searchable) {
        if (searchable != null) {
            searchables.add(searchable);
        }
    }

    public int maxResult(String query, String str) {
        int count = 0;
        int index = 0;
        while ((index = str.indexOf(query, index)) != -1) {
            count++;
            index += query.length();
        }
        return count;
    }

    public Searchable bestResult(String query) throws BestResultNotFound {
        Searchable best = null;
        int maxScore = 0;

        for (Searchable searchable : searchables) {
            if (searchable != null) {
                int score = maxResult(query, searchable.getSearchTerm());
                if (score > maxScore) {
                    best = searchable;
                    maxScore = score;
                }
            }
        }

        return checkBestResultNotNull(best);
    }

    private Searchable checkBestResultNotNull(Searchable best) throws BestResultNotFound {
        if (best == null) {
            throw new BestResultNotFound("Ничего не найдено");
        }
        return best;
    }
}