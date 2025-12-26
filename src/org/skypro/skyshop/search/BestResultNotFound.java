package org.skypro.skyshop.search;

public class BestResultNotFound extends Exception {
    public BestResultNotFound(String message) {
        super("Результат поиска для '" + message + " 'не найдены.");
    }
}


