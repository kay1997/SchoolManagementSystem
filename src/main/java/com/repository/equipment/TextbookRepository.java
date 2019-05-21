package com.repository.equipment;

import com.domain.equipment.Textbook;
import com.repository.IRepository;

import java.util.Set;

public interface TextbookRepository  extends IRepository<Textbook, String> {

    Set<Textbook> getAll();
}
