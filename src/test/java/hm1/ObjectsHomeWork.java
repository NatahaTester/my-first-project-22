package hm1;

import org.junit.jupiter.api.Test;

public class ObjectsHomeWork {
    @Test
    public void workingWithBin() {
        Bin infoBin = new Bin();

        infoBin.setColor("Black");
        infoBin.setMaterial("Plastic");
        infoBin.setVolume(20.5);

        System.out.println("bin");
        System.out.println(infoBin.getColor());
        System.out.println(infoBin.getVolume());
        System.out.println(infoBin.getMaterial());
    }

    @Test
    public void workingWithCarpet() {
        Carpet infoCarpet = new Carpet();

        infoCarpet.setColor("Black");
        infoCarpet.setHeight(2.5);
        infoCarpet.setWidth(1.5);
        infoCarpet.setMaterial("Polyester");
        infoCarpet.setPicture("Cobra");

        System.out.println("hw1.Carpet");
        System.out.println(infoCarpet.getColor());
        System.out.println(infoCarpet.getHeight());
        System.out.println(infoCarpet.getWidth());
        System.out.println(infoCarpet.getMaterial());
        System.out.println(infoCarpet.getPicture());
    }

    @Test
    public void workingWithChair() {
        Chair infoChair = new Chair();

        infoChair.setColor("Yellow");
        infoChair.setHeight(0.7);
        infoChair.setMaterial("Wood");
        infoChair.setLegsCount(4);
        infoChair.setSeatShape("Circle");

        System.out.println("hw1.Chair");
        System.out.println(infoChair.getColor());
        System.out.println(infoChair.getHeight());
        System.out.println(infoChair.getMaterial());
        System.out.println(infoChair.getLegsCount());
        System.out.println(infoChair.getSeatShape());
    }

    @Test
    public void workingWithCharger() {
        Charger infoCharger = new Charger();

        infoCharger.setColor("White");
        infoCharger.setBrand("Apple");
        infoCharger.setForModels("iPhone 6/7/8/10");
        infoCharger.setPower(15);
        infoCharger.setWireLength(1.5);

        System.out.println("hw1.Charger");
        System.out.println(infoCharger.getColor());
        System.out.println(infoCharger.getBrand());
        System.out.println(infoCharger.getForModels());
        System.out.println(infoCharger.getPower());
        System.out.println(infoCharger.getWireLength());
    }

    @Test
    public void workingWithLamp() {
        Lamp infoLamp = new Lamp();

        infoLamp.setPower(60);
        infoLamp.setShape("Cylinder");
        infoLamp.setBulbCount(1);
        infoLamp.setUsage("hw1.Table-lamp");
        infoLamp.setVoltage(230);

        System.out.println("hw1.Lamp");
        System.out.println(infoLamp.getPower());
        System.out.println(infoLamp.getShape());
        System.out.println(infoLamp.getBulbCount());
        System.out.println(infoLamp.getUsage());
        System.out.println(infoLamp.getVoltage());
    }

    @Test
    public void workingWithSofa() {
        Sofa infoSofa = new Sofa();

        infoSofa.setWidth(1.7);
        infoSofa.setHeight(2.2);
        infoSofa.setColor("Grey");
        infoSofa.setMaterial("Textile");

        System.out.println("hw1.Sofa");
        System.out.println(infoSofa.getWidth());
        System.out.println(infoSofa.getHeight());
        System.out.println(infoSofa.getColor());
        System.out.println(infoSofa.getMaterial());
    }

    @Test

    public void workingWithTable() {
        Table infoTable = new Table();

        infoTable.setWidth(1.5);
        infoTable.setHeight(1.2);
        infoTable.setColor("Orange");
        infoTable.setUsage("Desk");

        System.out.println("hw1.Table");
        System.out.println(infoTable.getWidth());
        System.out.println(infoTable.getHeight());
        System.out.println(infoTable.getColor());
        System.out.println(infoTable.getUsage());
    }

    @Test
    public void workingWithTV() {
        TV infoTV = new TV();

        infoTV.setBrand("LG");
        infoTV.setDiagonal(42.5);
        infoTV.setPrice(300);
        infoTV.setYear(2015);
        infoTV.setFrameWidth(2);

        System.out.println("hw1.TV");
        System.out.println(infoTV.getBrand());
        System.out.println(infoTV.getDiagonal());
        System.out.println(infoTV.getPrice());
        System.out.println(infoTV.getYear());
        System.out.println(infoTV.getFrameWidth());
    }

    @Test
    public void workingWithWardrobe() {
        Wardrobe infoWardrobe = new Wardrobe();

        infoWardrobe.setWidth(1.5);
        infoWardrobe.setHeight(2);
        infoWardrobe.setDoorCount(2);
        infoWardrobe.setShelvesCount(5);
        infoWardrobe.setColor("Orange");

        System.out.println("hw1.Wardrobe");
        System.out.println(infoWardrobe.getWidth());
        System.out.println(infoWardrobe.getHeight());
        System.out.println(infoWardrobe.getDoorCount());
        System.out.println(infoWardrobe.getShelvesCount());
        System.out.println(infoWardrobe.getColor());
    }

    @Test
    public void workingWithWondow() {
        Window infoWindow = new Window();

        infoWindow.setHeight(1.7);
        infoWindow.setWidth(1.5);
        infoWindow.setShape("Square");
        infoWindow.setTransparency(100);
        infoWindow.setFrameMaterial("Plastic");

        System.out.println("hw1.Window");
        System.out.println(infoWindow.getHeight());
        System.out.println(infoWindow.getWidth());
        System.out.println(infoWindow.getShape());
        System.out.println(infoWindow.getTransparency());
        System.out.println(infoWindow.getFrameMaterial());
    }
}
