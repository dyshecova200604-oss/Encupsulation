package org.skypro.skyshop.search;

import org.skypro.skyshop.BestResultNotFound;
import java.util.*;
import java.util.stream.Collectors;

public class SearchEngine {
    private final Set<Searchable> searchables;

    public SearchEngine() {
        // Используем HashSet вместо анонимного класса
        searchables = new HashSet<>();
    }

    public void add(Searchable searchable) {
        if (searchable != null) { // Проверка на null перед добавлением
            searchables.add(searchable);
        }
    }

    // Метод maxResult остается без изменений, он подсчитывает вхождения подстроки
    public int maxResult(String query, String str) {
        int count = 0;
        int index = 0;
        while ((index = str.indexOf(query, index)) != -1) {
            count++;
            index += query.length(); // Перемещаем индекс дальше, чтобы избежать повторного подсчета той же подстроки
        }
        return count;
    }

    public Map<String, Searchable> search(String query) {
        // Используем stream API для фильтрации и сбора результатов
        List<Searchable> results = searchables.stream()
                .filter(searchable -> searchable != null && searchable.getSearchTerm().contains(query))
                .collect(Collectors.toList());

        // Создаем Map из отфильтрованных результатов
        // Важно: если есть дубликаты имен, последний элемент с этим именем перезапишет предыдущий.
        // Если нужно хранить все, лучше использовать List<Searchable>.
        Map<String, Searchable> map = new TreeMap<>();
        for (Searchable searchable : results) {
            map.put(searchable.getName(), searchable);
        }

        if (results.isEmpty()) {
            System.out.println("Поиск по запросу '" + query + "' не дал результатов.");
        }
        return map;
    }

    public Searchable bestResult(String query) throws BestResultNotFound {
        int maxScore = -1; // Инициализируем -1, чтобы даже результат с 0 совпадений был учтен, если query есть, но встречается 0 раз
        Searchable best = null;

        // Получаем все найденные элементы (продукты и статьи)
        List<Searchable> allMatchingItems = searchables.stream()
                .filter(searchable -> searchable != null && searchable.getSearchTerm().contains(query))
                .collect(Collectors.toList());

        if (allMatchingItems.isEmpty()) {
            throw new BestResultNotFound("Ничего не найдено по запросу '" + query + "'.");
        }
        for (Searchable searchable : allMatchingItems) {
            // Проверка на null на всякий случай, хотя фильтр выше уже должен это исключить
            if (searchable == null) {
                continue;
            }
            int score = maxResult(query, searchable.getSearchTerm());
            if (score > maxScore) {
                best = searchable;
                maxScore = score;
            } else if (score == 0 && maxScore < 0 && searchable.getSearchTerm().contains(query)) { // Если query есть, но 0 совпадений, но это первый такой элемент
                best = searchable;
                maxScore = 0;
            }
        }
        if (best == null) {

            if (!allMatchingItems.isEmpty() && allMatchingItems.get(0) != null) {
                best = allMatchingItems.get(0);
            } else {
                throw new BestResultNotFound("Не удалось найти лучший результат для запроса '" + query + "'.");
            }
        }
        return best;
    }

    private void checkBestResultNotNull(Searchable best) throws BestResultNotFound {
        if (best == null) {
            throw new BestResultNotFound("Ничего не найдено");
        }
    }
}