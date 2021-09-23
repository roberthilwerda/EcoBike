import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FoldingBike extends Bike{

    private int wheelSize;
    private int nGears;

    public FoldingBike(String brand, int weight, boolean hasLights, String color, int price, int wheelSize, int nGears){
        super(brand, weight, hasLights, color, price);
        this.wheelSize = wheelSize;
        this.nGears = nGears;
    }

    public static FoldingBike read(String line){
        Scanner sc = new Scanner(line);
        sc.next();
        sc.useDelimiter("; ");
        String brand = sc.next();
        int wheelSize = sc.nextInt();
        int nGears = sc.nextInt();
        int weight = sc.nextInt();
        boolean hasLights = sc.nextBoolean();
        String color = sc.next();
        int price = sc.nextInt();

        return new FoldingBike(brand, weight, hasLights, color, price, wheelSize, nGears);
    }

    public int getWheelSize() {
        return wheelSize;
    }

    public int getnGears() {
        return nGears;
    }

    public void writeToFile(PrintWriter writer){
        writer.print("FOLDING BIKE");
        writer.print(getBrand() + "; ");
        writer.print(getWheelSize() + "; ");
        writer.print(getnGears() + "; ");
        writer.print(getWeight() + "; ");
        writer.print(hasLights() + "; ");
        writer.print(getColor() + "; ");
        writer.print(getPrice() + "\n");


                //FoldingBike(String brand, int weight, boolean hasLights, String color, int price, int wheelSize, int nGears)
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (obj instanceof FoldingBike) {
            FoldingBike that = (FoldingBike) obj;
            return (super.equals(that)) &&
                    (this.wheelSize == that.wheelSize) &&
                    (this.nGears == that.nGears);
        }
        return false;

    }

    public String toString() {
        String result = "";
        if (hasLights()) {
            result += "FOLDING BIKE " + getBrand() + " with " + getnGears() + " gears and head/tail light.\n Price: " + getPrice() + " euros.\n";
        }
        else {
            result += "FOLDING BIKE " + getBrand() + " with " + getnGears() + " gears and no head/tail light.\n Price: " + getPrice() + " euros.\n";
        }
        return result;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner("BIKE Brompton; 20; 6; 9283; TRUE; black; 1199");
        FoldingBike foldingBike = read(sc.nextLine());

        System.out.println(foldingBike);
    }

}
