package com.factory.infrastructure;

import com.domain.infrastructure.Building;

public class BuildingFactory {

    public static Building getBuilding(String buildingNumber, String buildingName) {
        return new Building.Builder().buildingNumber(buildingNumber)
                .buildingName(buildingName)
                .build();
    }
}
