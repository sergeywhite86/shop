package org.skypro.skyshop.service;

import org.skypro.skyshop.exception.BestResultNotFound;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class SearchEngine {

    private final Map<String, Searchable> searchableMap;


    public SearchEngine() {
        searchableMap = new HashMap<>();
    }

    public Map<String, Searchable> search(String productName) {
        Map<String, Searchable> resultMap = new HashMap<>();
        if (searchableMap.containsKey(productName)) {
            resultMap.put(productName, searchableMap.get(productName));
            return resultMap;
        }
        return resultMap;
    }

    public void add(Searchable searchElement) {
        searchableMap.put(searchElement.getName(), searchElement);
    }

    public Map<String,Searchable> getSearchTherm(String text) throws BestResultNotFound {

        Map<String, Searchable> map = new TreeMap<>();
        int maxCount = 0;
        for (String searchElement : searchableMap.keySet()) {
            int count = 0;
            int index = 0;
            int indexSubString = searchElement.indexOf(text, index);

            while (indexSubString != -1) {
                count++;
                index = index + text.length();
                indexSubString = searchElement.indexOf(text, index);
                map.put(searchElement, searchableMap.get(searchElement));
                if (count > maxCount) maxCount = count;
            }
        }
        if (maxCount != 0) {
            return map;
        } else throw new BestResultNotFound(text);
    }
}
