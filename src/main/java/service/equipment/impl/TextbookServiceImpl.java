package service.equipment.impl;



import domain.equipment.Textbook;
import org.springframework.stereotype.Service;
import repository.equipment.TextbookRepository;
import repository.equipment.impl.TextbookRepositoryImpl;
import service.equipment.TextbookService;

import java.util.Set;

@Service
public class TextbookServiceImpl implements TextbookService {

    private TextbookServiceImpl service = null;
    private TextbookRepository repository;

    private TextbookServiceImpl(){
        this.repository = TextbookRepositoryImpl.getRepository();
    }

    public TextbookService getService(){
        if (service == null) service = new TextbookServiceImpl();
        return service;
    }

    @Override
    public Textbook create(Textbook textbook) {
        return this.repository.create(textbook);
    }

    @Override
    public Textbook update(Textbook textbook) {
        return this.repository.update(textbook);
    }

    @Override
    public void delete(String textbookCode) {
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

