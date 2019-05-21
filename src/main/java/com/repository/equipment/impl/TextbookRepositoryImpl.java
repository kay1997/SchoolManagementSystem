package com.repository.equipment.impl;

import com.domain.equipment.Textbook;
import com.repository.equipment.TextbookRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;
@Repository("InMemory")
public class TextbookRepositoryImpl implements TextbookRepository {

    private static TextbookRepositoryImpl repository = null;
    private Set<Textbook> textbooks;

    private TextbookRepositoryImpl(){
        this.textbooks = new HashSet<>();
    }

    public static TextbookRepositoryImpl getRepository(){
        if (repository == null) repository = new TextbookRepositoryImpl();
        return repository;
    }


    public Textbook create(Textbook textbook){
        this.textbooks.add(textbook);
        return textbook;
    }

    private Textbook findTextbook(String textbookCode) {
        return this.textbooks.stream()
                .filter(textbook -> textbook.getTextbookCode().trim().equals(textbookCode))
                .findAny()
                .orElse(null);
    }

    public Textbook read(String textbookCode){

        Textbook textbook = findTextbook(textbookCode);
        return textbook;
    }

    public void delete(String textbookCode) {
        Textbook textbook = findTextbook(textbookCode);
        if (textbook != null) this.textbooks.remove(textbook);

    }

    public Textbook update(Textbook textbook) {
        Textbook toDelete = findTextbook(textbook.getTextbookCode());
        if (toDelete != null) {
            this.textbooks.remove(toDelete);
            return create(textbook);
        }
        return null;
    }

    public Set<Textbook> getAll(){
        return this.textbooks;
    }
}

