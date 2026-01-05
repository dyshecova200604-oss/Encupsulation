package org.skypro.skyshop.SearchЕngine;


import org.skypro.skyshop.search.BestResultNotFound;
import org.skypro.skyshop.search.Searchable;

public class SearchEngine {
   private int count = 0;
    private final int size = 0;
    Searchable[] searchables;

    public SearchEngine(int size) {
        this.searchables = new Searchable[size];
    }
    public void add(Searchable searchable) {
        if (count >= searchables.length) {
            System.out.println("Добавить объект невозможно!");
        }
        searchables[count] = searchable;
        count++;
    }
    public Searchable[] search(String searchTerm) {
        int countResalt = 0;
        Searchable[] result = new Searchable[5];
        for (Searchable searchable : searchables) {
            if (searchable == null) {
                continue;
            }
            if (searchable.getSearchTerm().toLowerCase().contains(searchTerm.toLowerCase())) {
                result[countResalt] = searchable;
                countResalt++;
            }
            if (countResalt == result.length) {
                break;
            }
        }
        return result;
    }

    public Searchable BestResult (String searchTerm) throws BestResultNotFound {
        Searchable[] result = new Searchable[5];
        Searchable bestResult = null;
        int maxFound = 0;
        int score;
        for (Searchable searchable : searchables) {
            String str = searchable.getSearchTerm().toLowerCase();
            String subStr = searchTerm.toLowerCase();
            score = resultMaxFound(str, subStr);
            if (score > maxFound) {
                maxFound = score;
                bestResult = searchable;
            } else if (bestResult == null) {
                throw new BestResultNotFound(searchTerm);
            }
        }
        return bestResult;
    }
    private int resultMaxFound (String str, String subStr){
        int score = 0;
        int index = 0;
        int indexSubStr = str.indexOf(subStr, index);
        while (indexSubStr != -1) {
            score++;
            index = indexSubStr + subStr.length();
            indexSubStr = str.indexOf(subStr, index);
        }
        return score;
    }
}


