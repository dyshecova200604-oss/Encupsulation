import org.skypro.skyshop.product.DiscountProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.Article;
import skyshop.search.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        SearchEngine engine = new SearchEngine(20);

        // Создаем продукты
        SimpleProduct apple = new SimpleProduct("Яблоко", 100);
        DiscountProduct banana = new DiscountProduct("Банан", 150, 20); // цена со скидкой 120
        FixPriceProduct orange = new FixPriceProduct("Апельсин", 200);
        SimpleProduct laptop = new SimpleProduct("Ноутбук", 50000);
        SimpleProduct phone = new SimpleProduct("iPhone 15", 90000);

        // Добавляем все продукты в SearchEngine
        engine.add(apple);
        engine.add(orange);
        engine.add(laptop);
        engine.add(phone);

        // Создаем статьи
        Article a1 = new Article("Новый iPhone 15", "В обзоре сравним камеру и производительность iPhone 15.");
        Article a2 = new Article("Гайд по выбору бананов", "Как выбрать спелые бананы и хранить их правильно.");
        Article a3 = new Article("Скидки на электронику", "Большая распродажа ноутбуков и телевизоров.");
        Article a4 = new Article("Рецепты с яблоками", "Пироги, салаты и смузи с яблоками.");

        // Добавляем статьи
        engine.add(a1);
        engine.add(a2);
        engine.add(a3);
        engine.add(a4);

        // Демонстрация поиска
        performSearch(engine, "банан");
        performSearch(engine, "скидки");
        performSearch(engine, "iphone");
        performSearch(engine, "яблоко");
        performSearch(engine, "телевизор");
        performSearch(engine, "несуществующий_термин");
    }

    private static void performSearch(SearchEngine engine, String keyword) {
        System.out.println();
        System.out.println("Поиск по ключевому слову:" + keyword );

        List<Searchable> results = engine.search(keyword);

        // Проверяем количество найденных элементов
        if (results.isEmpty()) {
            System.out.println("Ничего не найдено.");
            return;
        }

        // Выводим найденные элементы
        System.out.println("Найденные элементы (до 5):");
        for (int i = 0; i < results.size(); i++) {
            Searchable s = results.get(i);
            System.out.println((i + 1) + ". " + s.getStringRepresentation() + " -> searchTerm: " + s.getSearchTerm());
            if (i == 4) break; // Ограничиваем вывод до 5 элементов
        }
    }
}