package skyshop.search;

import java.util.ArrayList;
import java.util.List;

public class SearchEngine {
    private final List<Searchable> items;
    private final int capacity;

    public SearchEngine(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity must be > 0");
        }
        this.items = new ArrayList<>(capacity);
        this.capacity = capacity;
    }

    /**
     * Добавляет новый Searchable в движок. Если место закончилось — элемент не добавляется.
     */
    public void add(Searchable s) {
        if (s == null) {
            return;
        }
        if (items.size() >= capacity) {
            System.out.println("SearchEngine: превышена ёмкость, элемент не добавлен: " + s.getSearchTerm());
            return;
        }
        items.add(s);
    }

    /**
     * Ищет keyword в каждом Searchable.getSearchTerm() используя contains (регистронезависимо).
     * Возвращает список найденных соответствий (не более 5).
     */
    public List<Searchable> search(String keyword) {
        List<Searchable> results = new ArrayList<>();
        if (keyword == null || keyword.isEmpty()) {
            return results; // возвращаем пустой список
        }
        String lower = keyword.toLowerCase();
        for (Searchable s : items) {
            if (s != null && s.getSearchTerm() != null && s.getSearchTerm().toLowerCase().contains(lower)) {
                results.add(s);
                if (results.size() == 5) {
                    break; // ограничиваем до 5 результатов
                }
            }
        }
        return results;
    }
}