package hm3;

import io.opentelemetry.sdk.metrics.internal.view.SumAggregation;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class TestForVehicleAndRoad {

    @Test
    public void infoForVehicleAndRoads() {
        Vehicle car = new Vehicle();
        car.setVehicleType("Car");
        car.setFuelConsumption(10);
        car.setFuelTankCapacity(50);

        Vehicle train = new Vehicle();
        train.setVehicleType("Train");
        train.setFuelConsumption(5);
        train.setFuelTankCapacity(200);

        Vehicle plane = new Vehicle();
        plane.setVehicleType("Plane");
        plane.setFuelConsumption(8);
        plane.setFuelTankCapacity(150);

        Road toMinsk = new Road();
        toMinsk.setStartingPointName("Riga");
        toMinsk.setDestinationPointName("Minsk");
        toMinsk.setDistanceKm(478);

        Road toTallin = new Road();
        toTallin.setStartingPointName("Riga");
        toTallin.setDestinationPointName("Tallin");
        toTallin.setDistanceKm(309);

        Road toVilnus = new Road();
        toVilnus.setStartingPointName("Riga");
        toVilnus.setDestinationPointName("Vilnus");
        toVilnus.setDistanceKm(295);


        int rasstoanie = 478;
        int rashod;
        int kilometri = 100;


    }
}
