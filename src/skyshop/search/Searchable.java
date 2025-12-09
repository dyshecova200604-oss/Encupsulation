package skyshop.search;

public interface Searchable {
    /**
     * Возвращает имя Searchable-объекта (например, название товара или заголовок статьи).
     */
    String getName();

    /**
     * Возвращает search term — строку, по которой будем искать.
     * Например: для товара — имя товара, для статьи — название + текст.
     */
    String getSearchTerm();

    /**
     * Возвращает тип содержимого в виде строки (например, "PRODUCT" или "ARTICLE").
     */
    String getType();

    /**
     * Возвращает строковое представление объекта для показа в результатах поиска.
     * По умолчанию возвращает: "<name> — <type>".
     * Можно переопределить в реализациях при необходимости.
     */
    default String getStringRepresentation() {
        return getName() + " — " + getType();
    }
}
