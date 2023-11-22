package be.intecbrussel.sellers;

// This class is used in IceCreamCar class to manage stock of each element.
public class Stock {
    private int iceRockets;
    private int cones;
    private int balls;
    private int magni;

    public Stock(int iceRockets, int cones, int balls, int magni) {
        this.iceRockets = iceRockets;
        this.cones = cones;
        this.balls = balls;
        this.magni = magni;

        System.out.println("****************** Initial Stocks *****************");
        System.out.println("IceRocket stock: " + getIceRockets());
        System.out.println("Cones stock: " + getCones());
        System.out.println("Balls stock: " + getBalls());
        System.out.println("Magnum stock: " + getMagni());
        System.out.println("***************************************************");
        System.out.println();
    }

    public int getIceRockets() {
        return iceRockets;
    }

    public void setIceRockets(int iceRockets) {
        this.iceRockets = iceRockets;
    }

    public int getCones() {
        return cones;
    }

    public void setCones(int cones) {
        this.cones = cones;
    }

    public int getBalls() {
        return balls;
    }

    public void setBalls(int balls) {
        this.balls = balls;
    }

    public int getMagni() {
        return magni;
    }

    public void setMagni(int magni) {
        this.magni = magni;
    }
}
