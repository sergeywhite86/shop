package org.skypro.skyshop.product.info;

import org.skypro.skyshop.exception.BestResultNotFound;

import java.util.HashMap;
import java.util.Map;

public class SearchEngine {

    private final Searchable[] arrSearchElements;
    private int index = 0;

    public SearchEngine(int size) {
        arrSearchElements = new Searchable[size];
    }

    public Searchable[] search(String text) {
        Searchable[] searchElements = new Searchable[5];
        int index = 0;
        for (Searchable searchable : arrSearchElements) {
            if (searchable == null) break;
            if (searchable.searchTerm().contains(text)) {
                searchElements[index] = searchable;
                index++;
                if (index == 4) break;
            }
        }
        return searchElements;
    }

    public void add(Searchable searchElement) {
        arrSearchElements[index] = searchElement;
        index++;
    }

    public Searchable getSearchTherm(String text) throws BestResultNotFound {

        Map<Searchable, Integer> map = new HashMap<>();
        int maxCount = 0;
        for (Searchable searchElement : arrSearchElements) {
            if (searchElement == null) break;
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
