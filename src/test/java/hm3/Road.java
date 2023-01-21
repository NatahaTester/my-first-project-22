package hm3;

public class Road {

    private String startingPointName;
    private String destinationPointName;
    private int distanceKm;

    public String getStartingPointName() {
        return startingPointName;
    }

    public void setStartingPointName(String startingPointName) {
        this.startingPointName = startingPointName;
    }

    public String getDestinationPointName() {
        return destinationPointName;
    }

    public void setDestinationPointName(String destinationPointName) {
        this.destinationPointName = destinationPointName;
    }

    public int getDistanceKm() {
        return distanceKm;
    }

    public void setDistanceKm(int distanceKm) {
        this.distanceKm = distanceKm;
    }
}
