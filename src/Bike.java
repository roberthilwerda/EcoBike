public class Bike {

    public String getBrand() {
        return brand;
    }

    public int getWeight() {
        return weight;
    }

    public boolean hasLights() {
        return hasLights;
    }

    public String getColor() {
        return color;
    }

    public int getPrice() {
        return price;
    }

    private String brand;
    private int weight;
    private boolean hasLights;
    private String color;
    private int price;

    public Bike(String brand, int weight, boolean hasLights, String color, int price){
        this.brand = brand;
        this.weight = weight;
        this.hasLights = hasLights;
        this.color = color;
        this.price = price;
    }



    public boolean equals(Object obj){
        if(obj == this){return true;}
        if(obj == null){return false;}
        if(obj instanceof Bike){
            Bike that = (Bike) obj;
            return (this.brand.equals(that.brand) &&
                    (this.weight == that.weight) &&
                    (this.hasLights == that.hasLights) &&
                    (this.color.equals(that.color)) &&
                    (this.price == that.price));
        }
        return false;
    }
}
