package org.skypro.skyshop.product.info;

public class SearchEngine {

    private final Searchable [] arrSearchElements;
    private  int index = 0;

    public SearchEngine(int size) {
        arrSearchElements = new Searchable[size];
    }

    public Searchable [] search(String text){
       Searchable [] searchElements = new Searchable[5];
       int index = 0;
        for (Searchable searchable : arrSearchElements) {
            if(searchable == null) break;
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
        index ++;
    }
}
