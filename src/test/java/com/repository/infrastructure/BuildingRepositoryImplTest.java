package com.repository.infrastructure;

import com.app.SchoolManagementSystemApplication;
import com.domain.infrastructure.Building;
import com.factory.infrastructure.BuildingFactory;

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
public class BuildingRepositoryImplTest {
        @Autowired
        private BuildingRepository repository;
        private String buildingNo = null;

        @Test
        public void CreateBuildingTest() throws IOException {
            Building building = BuildingFactory.getBuilding("2", "Admin");
            Building result = repository.create(building);
            buildingNo = result.getBuildingNumber();
            Assert.assertNotNull(building);
        }

        @Test
        public void GetBuildingTest() throws IOException {

            Building building = repository.read(buildingNo);
            Assert.assertNotNull(building);
        }
    }
