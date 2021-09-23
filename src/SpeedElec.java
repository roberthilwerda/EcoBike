import java.io.PrintWriter;
import java.util.Scanner;

public class SpeedElec extends Bike{

    private int maxSpeed;
    private int batteryCapacity;

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public int getBatteryCapacity() {
        return batteryCapacity;
    }

    public SpeedElec(String brand, int weight, boolean hasLights, String color, int price, int maxSpeed, int batteryCapacity) {
        super(brand, weight, hasLights, color, price);
        this.maxSpeed = maxSpeed;
        this.batteryCapacity = batteryCapacity;
    }

    public static SpeedElec read(String line){
        Scanner sc = new Scanner(line);
        sc.useDelimiter("; ");
        String brand = sc.next();
        int maxSpeed = sc.nextInt();
        int batteryCapacity = sc.nextInt();
        boolean hasLights = sc.nextBoolean();
        int weight = sc.nextInt();
        String color = sc.next();
        int price = sc.nextInt();
        return new SpeedElec(brand, weight, hasLights, color, price, maxSpeed, batteryCapacity);
    }

    public void writeToFile(PrintWriter writer){
        writer.print("SPEEDELEC");
        writer.print(getBrand() + "; ");
        writer.print(getMaxSpeed() + "; ");
        writer.print(getBatteryCapacity() + "; ");
        writer.print(getWeight() + "; ");
        writer.print(hasLights() + "; ");
        writer.print(getColor() + "; ");
        writer.print(getPrice() + "\n");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (obj instanceof SpeedElec) {
            SpeedElec that = (SpeedElec) obj;
            return (super.equals(that)) &&
                    (this.maxSpeed == that.maxSpeed) &&
                    (this.batteryCapacity == that.batteryCapacity);
        }
        return false;

    }

    public String toString() {
        if (hasLights()) {
            String result = "SPEEDELEC " + getBrand() + " with " + getBatteryCapacity() + " mAh battery and head/tail light.\n Price: " + getPrice() + " euros.\n";
            return result;
        }
        else {
            String result = "SPEEDELEC " + getBrand() + " with " + getBatteryCapacity() + " mAh battery and no head/tail light.\n Price: " + getPrice() + " euros.\n";
            return result;
        }
    }

}
