package org.skypro.skyshop.service;

public interface Searchable {

    String searchTerm();

    String getTypeContent();

    String getName();

    default String getStringRepresentation() {
        return String.format("Имя - %s тип - %s ", getName(), getTypeContent());
    }
}
