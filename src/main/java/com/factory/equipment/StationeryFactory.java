package com.factory.equipment;

import com.domain.equipment.Stationery;

public class StationeryFactory {

    public static Stationery getStationery(String stationeryCode, String stationeryType) {
        return new Stationery.Builder().stationeryCode(stationeryCode).stationeryType(stationeryType).build();
    }
}
