package hm1;

public class Lamp {
   private int bulbCount;
   private String shape;
   private double power;
   private double voltage;
   private String usage;


   public int getBulbCount() {
      return bulbCount;
   }

   public void setBulbCount(int bulbCount) {
      this.bulbCount = bulbCount;
   }

   public String getShape() {
      return shape;
   }

   public void setShape(String shape) {
      this.shape = shape;
   }

   public double getPower() {
      return power;
   }

   public void setPower(double power) {
      this.power = power;
   }

   public double getVoltage() {
      return voltage;
   }

   public void setVoltage(double voltage) {
      this.voltage = voltage;
   }

   public String getUsage() {
      return usage;
   }

   public void setUsage(String usage) {
      this.usage = usage;
   }
}
