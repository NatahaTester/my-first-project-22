package hm3;

import io.opentelemetry.sdk.metrics.internal.view.SumAggregation;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class TestForVehicleAndRoad {
    Vehicle car = new Vehicle();
    Vehicle train = new Vehicle();
    Vehicle plane = new Vehicle();

    Road toMinsk = new Road();
    Road toTallin = new Road();
    Road toVilnus = new Road();

    float distance100km = 100;

    @Test
    public void infoForVehicleAndRoads() {

        car.setVehicleType("Car: ");
        car.setFuelConsumption(10);
        car.setFuelTankCapacity(50);

        train.setVehicleType("Train: ");
        train.setFuelConsumption(5);
        train.setFuelTankCapacity(100);

        plane.setVehicleType("Plane: ");
        plane.setFuelConsumption(20);
        plane.setFuelTankCapacity(70);

        toMinsk.setDestinationPointName("Minsk");
        toMinsk.setDistanceKm(478);

        toTallin.setDestinationPointName("Tallin");
        toTallin.setDistanceKm(309);

        toVilnus.setDestinationPointName("Vilnus");
        toVilnus.setDistanceKm(295);

        float carFuelFor1km = car.getFuelConsumption() / distance100km;
        float trainFuelFor1km = train.getFuelConsumption() / distance100km;
        float planeFuelFor1km = plane.getFuelConsumption() / distance100km;

        System.out.print("Route from Riga to ");
        System.out.println(toMinsk.getDestinationPointName());

        float carFuelToMinsk = carFuelFor1km * toMinsk.getDistanceKm();
        System.out.print(car.getVehicleType());
        System.out.print(carFuelToMinsk);
        System.out.print(" liters, ");
        if (carFuelToMinsk <= car.getFuelTankCapacity()) {
            System.out.println("one tank is enough");
        } else {
            System.out.println("one tank is not enough");
        }

        float trainFuelToMinsk = trainFuelFor1km * toMinsk.getDistanceKm();
        System.out.print(train.getVehicleType());
        System.out.print(trainFuelToMinsk);
        System.out.print(" liters, ");
        if (trainFuelToMinsk <= train.getFuelTankCapacity()) {
            System.out.println("one tank is enough");
        } else {
            System.out.println("one tank is not enough");
        }

        float planeFuelToMinsk = planeFuelFor1km * toMinsk.getDistanceKm();
        System.out.print(plane.getVehicleType());
        System.out.print(planeFuelToMinsk);
        System.out.print(" liters, ");
        if (planeFuelToMinsk <= plane.getFuelTankCapacity()) {
            System.out.println("one tank is enough");
        } else {
            System.out.println("one tank is not enough");
        }

        System.out.println("");
        System.out.print("Route from Riga to ");
        System.out.println(toTallin.getDestinationPointName());

        float carFuelToTallin = carFuelFor1km * toTallin.getDistanceKm();
        System.out.print(car.getVehicleType());
        System.out.print(carFuelToTallin);
        System.out.print(" liters, ");
        if (carFuelToTallin <= car.getFuelTankCapacity()) {
            System.out.println("one tank is enough");
        } else {
            System.out.println("one tank is not enough");
        }

        float trainFuelToTallin = trainFuelFor1km * toTallin.getDistanceKm();
        System.out.print(train.getVehicleType());
        System.out.print(trainFuelToTallin);
        System.out.print(" liters, ");
        if (trainFuelToTallin <= train.getFuelTankCapacity()) {
            System.out.println("one tank is enough");
        } else {
            System.out.println("one tank is not enough");
        }

        float planeFuelToTallin = planeFuelFor1km * toTallin.getDistanceKm();
        System.out.print(plane.getVehicleType());
        System.out.print(planeFuelToTallin);
        System.out.print(" liters, ");
        if (planeFuelToTallin <= plane.getFuelTankCapacity()) {
            System.out.println("one tank is enough");
        } else {
            System.out.println("one tank is not enough");
        }

        System.out.println("");
        System.out.print("Route from Riga to ");
        System.out.println(toVilnus.getDestinationPointName());

        float carFuelToVilnus = carFuelFor1km * toVilnus.getDistanceKm();
        System.out.print(car.getVehicleType());
        System.out.print(carFuelToVilnus);
        System.out.print(" liters, ");
        if (carFuelToVilnus <= car.getFuelTankCapacity()) {
            System.out.println("one tank is enough");
        } else {
            System.out.println("one tank is not enough");
        }

        float trainFuelToVilnus = trainFuelFor1km * toVilnus.getDistanceKm();
        System.out.print(train.getVehicleType());
        System.out.print(trainFuelToVilnus);
        System.out.print(" liters, ");
        if (trainFuelToVilnus <= train.getFuelTankCapacity()) {
            System.out.println("one tank is enough");
        } else {
            System.out.println("one tank is not enough");
        }

        float planeFuelToVilnus = planeFuelFor1km * toVilnus.getDistanceKm();
        System.out.print(plane.getVehicleType());
        System.out.print(planeFuelToVilnus);
        System.out.print(" liters, ");
        if (planeFuelToVilnus <= plane.getFuelTankCapacity()) {
            System.out.println("one tank is enough");
        } else {
            System.out.println("one tank is not enough");
        }

    }
}
