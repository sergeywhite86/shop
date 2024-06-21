package org.skypro.skyshop.service;

import org.skypro.skyshop.exception.BestResultNotFound;

import java.util.*;

public class SearchEngine {

    private final Set< Searchable> searchableSet;


    public SearchEngine() {
        searchableSet = new HashSet<>();
    }

    public Searchable search(String productName) {
        if (containsProductByName(productName)) {
            return getProductByName(productName);
        }
        return null;
    }

    public void add(Searchable searchElement) {
        searchableSet.add(searchElement);
    }

    public Set<Searchable> getSearchTherm(String text) throws BestResultNotFound {

        Set<Searchable> set = new TreeSet<>();
        int maxCount = 0;
        List<String> stringList = searchableSet.stream().map(Searchable::getName).toList();
        for (String searchElement : stringList) {
            int count = 0;
            int index = 0;
            int indexSubString = searchElement.indexOf(text, index);

            while (indexSubString != -1) {
                count++;
                index = index + text.length();
                indexSubString = searchElement.indexOf(text, index);
                set.add(getProductByName(searchElement));
                if (count > maxCount) maxCount = count;
            }
        }
        if (maxCount != 0) {
            return set;
        } else throw new BestResultNotFound(text);
    }

    private boolean containsProductByName(String searchElement) {
        return searchableSet.stream().anyMatch(searchable -> searchable.getName().equals(searchElement));
    }
    private Searchable getProductByName(String searchElement) {
        return searchableSet.stream().filter(searchable -> searchable.getName().equals(searchElement)).findFirst().orElse(null);
    }
}
