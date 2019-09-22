package com.service.equipment.impl;



import com.domain.equipment.Textbook;
import com.service.equipment.TextbookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.repository.equipment.TextbookRepository;
import com.repository.equipment.impl.TextbookRepositoryImpl;

import java.util.Set;

@Service("ServiceImpl")
public class TextbookServiceImpl implements TextbookService {
    private static TextbookServiceImpl service;
    private TextbookRepository repository;

    private TextbookServiceImpl(){this.repository = TextbookRepositoryImpl.getRepository();}

    public static TextbookServiceImpl getService()
    {
        if(service == null){service = new TextbookServiceImpl();}
        return service;
    }

    @Override
    public Textbook create(Textbook textbook){
        return this.repository.create(textbook);
    }

    @Override
    public Textbook update(Textbook textbook) {
        return this.repository.update(textbook);
    }

    @Override
    public void delete(String textbookCode){
        this.repository.delete(textbookCode);
    }

    @Override
    public Textbook read(String textbookCode) {
        return this.repository.read(textbookCode);
    }

    @Override
    public Set<Textbook> getAll() {
        return this.repository.getAll();
    }

}
