package com.service.equipment;

import com.domain.equipment.Textbook;
import com.service.IService;

import java.util.Set;

public interface TextbookService extends IService<Textbook, String> {

    Set<Textbook> getAll();

}
