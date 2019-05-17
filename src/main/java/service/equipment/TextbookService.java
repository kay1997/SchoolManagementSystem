package service.equipment;

import domain.equipment.Textbook;
import service.IService;

import java.util.Set;

public interface TextbookService extends IService<Textbook, String> {

    Set<Textbook> getAll();

}
