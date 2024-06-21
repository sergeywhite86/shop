package org.skypro.skyshop.service;

import lombok.Data;

@Data
public final class Article implements Searchable{

   private final String name;
   private final String text;

    public Article(String name, String text) {
        this.name = name;
        this.text = text;
    }

    @Override
    public String toString() {
        return String.format("%s \n %s", name, text);
    }

    @Override
    public String searchTerm() {
        return toString();
    }

    @Override
    public String getTypeContent() {
        return "ARTICLE";
    }

    @Override
    public String getName() {
        return name;
    }


    @Override
    public int compareTo(Searchable o) {
        return Integer.compare(o.getName().length(), this.getName().length());
    }
}
