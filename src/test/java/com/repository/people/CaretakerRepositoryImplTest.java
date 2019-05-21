package com.repository.people;

import com.app.SchoolManagementSystemApplication;
import com.domain.people.Caretaker;
import com.factory.people.CaretakerFactory;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@SpringBootTest(classes = SchoolManagementSystemApplication.class)
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.JVM)
public class CaretakerRepositoryImplTest {
    @Autowired
    private CaretakerRepository repository;
    private String caretakerId = null;

    @Test
    public void CreateCaretakerTest() throws IOException {
        Caretaker caretaker = CaretakerFactory.getCaretaker("970826", "Kaylen", "Abrahams", "260897", "Strandloper", "0605220503", 22);
        Caretaker result = repository.create(caretaker);
        caretakerId = result.getCaretakerIDNumber();
        Assert.assertNotNull(caretaker);
    }

    @Test
    public void GetCaretakerTest() throws IOException {

        Caretaker caretaker = repository.read(caretakerId);
        Assert.assertNotNull(caretaker);
    }
}
