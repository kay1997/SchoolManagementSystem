package com.repository.equipment;

import com.app.SchoolManagementSystemApplication;
import com.domain.equipment.Stationery;
import com.factory.equipment.StationeryFactory;
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
public class StationeryRepositoryImplTest {
    @Autowired
    private StationeryRepository repository;
    private String stationeryNo = null;

    @Test
    public void CreateStationeryTest() throws IOException {
        Stationery stationery = StationeryFactory.getStationery("Pen123", "Pen");
        Stationery result = repository.create(stationery);
        stationeryNo = result.getStationeryCode();
        Assert.assertNotNull(stationery);
    }

    @Test
    public void GetStationeryTest() throws IOException {

        Stationery stationery = repository.read(stationeryNo);
        Assert.assertNotNull(stationery);
    }
}
