package org.skypro.skyshop.search;

import skyshop.search.Searchable;

public class Article implements Searchable {
    private final String title;
    private final String text;

    public Article(String title, String text) {
        this.title = title != null ? title : "";
        this.text = text != null ? text : "";
    }

    @Override
    public String getName() {
        return title;
    }

    /**
     * Для поиска возвращаем комбинацию названия и текста статьи.
     */
    @Override
    public String getSearchTerm() {
        return title + " " + text;
    }

    @Override
    public String getStringRepresentation() {
        return title + ": " + text;
    }

    @Override
    public String getType() {
        return "ARTICLE";
    }

    /**
     * toString должен выводить:
     * Название статьи
     * Текст статьи
     */
    @Override
    public String toString() {
        return title + System.lineSeparator() + text + System.lineSeparator();
    }
}