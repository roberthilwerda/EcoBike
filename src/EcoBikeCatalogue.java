import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class EcoBikeCatalogue {

    private List<Bike> catalogue;

    public List<Bike> getCatalogue() {
        return catalogue;
    }

    public EcoBikeCatalogue(){
        this.catalogue = new ArrayList<Bike>();
    }

    public static EcoBikeCatalogue read(String filename) throws FileNotFoundException {
        EcoBikeCatalogue catalogue = new EcoBikeCatalogue();
        Scanner sc = new Scanner(new File(filename));
        while(sc.hasNext()){
            String next = sc.next();

            if (next.equals("FOLDING")) {catalogue.addBike(FoldingBike.read(sc.nextLine()));}
            if (next.equals("SPEEDELEC")) {catalogue.addBike(SpeedElec.read(sc.nextLine()));}
            if (next.equals("E-BIKE")) {catalogue.addBike(EBike.read(sc.nextLine()));}

        }
        return catalogue;
    }

    public void addBike(Bike bike){this.catalogue.add(bike);}

    public boolean equals(Object obj){
        if(obj == this){return true;}
        if(obj == null){return false;}
        if(obj instanceof EcoBikeCatalogue){
            EcoBikeCatalogue that = (EcoBikeCatalogue) obj;
            return catalogue.equals(that.catalogue);
        }
        return false;
    }

    public String toString(){
        String result = "";
        for(int i = 0; i < catalogue.size(); i++){result += catalogue.get(i).toString();}
        return result;
    }

    public static void main(String[] args) throws FileNotFoundException{
        EcoBikeCatalogue testert = read("resources/ecobike.txt");
        System.out.println(testert);

    }

}
