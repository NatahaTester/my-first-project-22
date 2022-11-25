package hm1;

public class Bin {
    private double volume;
    private String material;
    private boolean lid;
    private boolean trashBag;
    private String color;



    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public boolean isLid() {
        return lid;
    }

    public void setLid(boolean lid) {
        this.lid = lid;
    }

    public boolean isTrashBag() {
        return trashBag;
    }

    public void setTrashBag(boolean trashBag) {
        this.trashBag = trashBag;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
