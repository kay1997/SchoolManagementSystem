package repository.equipment;

import domain.equipment.Textbook;
import repository.IRepository;

import java.util.Set;

public interface TextbookRepository  extends IRepository<Textbook, String> {

    Set<Textbook> getAll();
}
