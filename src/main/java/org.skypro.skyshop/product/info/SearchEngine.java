package org.skypro.skyshop.product.info;

import org.skypro.skyshop.exception.BestResultNotFound;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchEngine {

    private final List<Searchable> arrSearchElements;


    public SearchEngine() {
        arrSearchElements = new ArrayList<>();
    }

    public List<Searchable> search(String text) {

        return arrSearchElements.stream().filter(e -> e.searchTerm().equals(text)).toList();
    }

    public void add(Searchable searchElement) {
        arrSearchElements.add(searchElement);
    }

    public Searchable getSearchTherm(String text) throws BestResultNotFound {

        Map<Searchable, Integer> map = new HashMap<>();
        int maxCount = 0;
        for (Searchable searchElement : arrSearchElements) {
            int count = 0;
            int index = 0;
            int indexSubString = searchElement.searchTerm().indexOf(text, index);

            while (indexSubString != -1) {
                count++;
                index = index + text.length();
                indexSubString = searchElement.searchTerm().indexOf(text, index);
                map.put(searchElement, count);
                if (count > maxCount) maxCount = count;
            }
        }
        if (maxCount != 0) {
            int finalMaxCount = maxCount;
            return map.entrySet().stream().filter(e -> e.getValue() == finalMaxCount).map(Map.Entry::getKey).findFirst().get();
        } else throw new BestResultNotFound(text);
    }
}
