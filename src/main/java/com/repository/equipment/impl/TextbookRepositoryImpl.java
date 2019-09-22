package com.repository.equipment.impl;

import com.domain.equipment.Textbook;
import com.repository.equipment.TextbookRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository("InMemory")
public class TextbookRepositoryImpl implements TextbookRepository {

    private static TextbookRepositoryImpl repository = null;
    private Map<String, Textbook> educators;

    private TextbookRepositoryImpl() {
        this.educators = new HashMap<>();
    }

    public static TextbookRepositoryImpl getRepository() {
        if (repository == null) repository = new TextbookRepositoryImpl();
        return repository;
    }

    @Override
    public Set<Textbook> getAll() {
        Collection<Textbook> educators = this.educators.values();
        Set<Textbook> set = new HashSet<>();
        set.addAll(educators);
        return set;
    }

    @Override
    public Textbook create(Textbook textbook) {
        if (read(textbook.getTextbookCode()) == null) {
            this.educators.put(textbook.getTextbookCode(), textbook);
        }
        return textbook;
    }

    @Override
    public Textbook read(String e) {
        return this.educators.get(e);
    }

    @Override
    public Textbook update(Textbook textbook) {
        if (read(textbook.getTextbookCode()) != null) {
            educators.replace(textbook.getTextbookCode(), textbook);
        }
        return textbook;
    }

    @Override
    public void delete(String e) {
        Textbook textbook = read(e);
        this.educators.remove(e, textbook);
    }

}