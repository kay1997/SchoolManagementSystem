package com.service.equipment;

import com.app.SchoolManagementSystemApplication;
import com.domain.equipment.Textbook;
import com.factory.equipment.TextbookFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.repository.equipment.TextbookRepository;
import com.repository.equipment.impl.TextbookRepositoryImpl;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(classes = SchoolManagementSystemApplication.class)
@RunWith(SpringRunner.class)
public class TextbookServiceTest {

    private TextbookRepository repository;
    private Textbook textbook;

    private Textbook getSavedTextbook() {
        Set<Textbook> savedTextbooks = this.repository.getAll();
        return savedTextbooks.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = TextbookRepositoryImpl.getRepository();
        this.textbook = TextbookFactory.getTextbook("I.T001", "I.T");
    }

    @Test
    public void a_create() {
        Textbook created = this.repository.create(this.textbook);
        System.out.println("In create, created = " + created);
        d_getAll();
        Assert.assertSame(created, this.textbook);
    }

    @Test
    public void b_read() {
        Textbook savedTextbook = getSavedTextbook();
        System.out.println("In read, textbook code = " + savedTextbook.getTextbookCode());
        Textbook read = this.repository.read(savedTextbook.getTextbookCode());
        System.out.println("In read, read = " + read);
        d_getAll();
        Assert.assertEquals(savedTextbook, read);
    }

    @Test
    public void e_delete() {
        Textbook savedTextbook = getSavedTextbook();
        this.repository.delete(savedTextbook.getTextbookCode());
        d_getAll();
    }

    @Test
    public void c_update() {
        String newTextbookCode = "New Test Textbook Code";
        Textbook updated = new Textbook.Builder().copy(getSavedTextbook()).textbookCode(newTextbookCode).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(newTextbookCode, updated.getTextbookCode());
    }

    @Test
    public void d_getAll() {
        Set<Textbook> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
//        Assert.assertSame(1, all.size());
    }
}
