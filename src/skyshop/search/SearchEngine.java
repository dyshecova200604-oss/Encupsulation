package skyshop.search;

import org.skypro.skyshop.product.DiscountProduct;

import java.util.ArrayList;
import java.util.List;


public class SearchEngine {
    private final List<Searchable> items;


    public SearchEngine(int capacity) {
        items = new ArrayList<>(capacity);
    }

    public void add(Searchable item) {
        items.add(item);
    }

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

    public void add(DiscountProduct banana) {
    }
}