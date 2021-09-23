import org.w3c.dom.ls.LSOutput;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class EcoBikeApplication {

    public static void main(String[] args) throws IOException {

        boolean exit = false;
        System.out.println("Enter file location of catalogue: ");
        String fileLocation = new Scanner(System.in).next();
        EcoBikeCatalogue catalogue = EcoBikeCatalogue.read(fileLocation);

        while(exit == false){

        System.out.println("Please make your choice:\n" +
                "1 - Show the entire EcoBike catalogue\n" +
                "2 – Add a new folding bike\n" +
                "3 – Add a new speedelec\n" +
                "4 – Add a new e-bike\n" +
                "5 – Find first item of a particular brand\n" +
                "6 – Write to file\n" +
                "7 – Stop the program");

        Scanner sc = new Scanner(System.in);
        int userInput = sc.nextInt();
        if(userInput == 1){System.out.println(catalogue);}
        if(userInput == 2){addFoldingBike(catalogue);}
        if(userInput == 3){addSpeedElec(catalogue);}
        if(userInput == 4){addEBike(catalogue);}
        if(userInput == 5){findItem();}
        if(userInput == 6){writeToFile(catalogue);}
        if(userInput == 7){exit = true;}
        }
    }

    public static void addFoldingBike(EcoBikeCatalogue catalogue) throws IOException {
        System.out.println("Enter brand: ");
        String brand =  new Scanner(System.in).next();
        System.out.println("Enter wheel size: ");
        int wheelSize =  new Scanner(System.in).nextInt();
        System.out.println("Enter number of gears: ");
        int nGears =  new Scanner(System.in).nextInt();
        System.out.println("Enter weight of the bike: ");
        int weight =  new Scanner(System.in).nextInt();
        System.out.println("Enter if the bike has lights true/false: ");
        boolean hasLights =  new Scanner(System.in).nextBoolean();
        System.out.println("Enter color: ");
        String color =  new Scanner(System.in).next();
        System.out.println("Enter price: ");
        int price =  new Scanner(System.in).nextInt();
        catalogue.addBike(new FoldingBike(brand, weight, hasLights, color, price, wheelSize, nGears));
    }

    public static void addSpeedElec(EcoBikeCatalogue catalogue){
        System.out.println("Enter brand: ");
        String brand =  new Scanner(System.in).next();
        System.out.println("Enter maximum speed: ");
        int maxSpeed =  new Scanner(System.in).nextInt();
        System.out.println("Enter weight of the bike: ");
        int weight =  new Scanner(System.in).nextInt();
        System.out.println("Enter if the bike has lights true/false: ");
        boolean hasLights =  new Scanner(System.in).nextBoolean();
        System.out.println("Enter battery capacity: ");
        int batteryCapacity =  new Scanner(System.in).nextInt();
        System.out.println("Enter color: ");
        String color =  new Scanner(System.in).next();
        System.out.println("Enter price: ");
        int price =  new Scanner(System.in).nextInt();
        catalogue.addBike(new SpeedElec(brand, weight, hasLights, color, price, maxSpeed, batteryCapacity));
    }

    public static void addEBike(EcoBikeCatalogue catalogue){
        System.out.println("Enter brand: ");
        String brand =  new Scanner(System.in).next();
        System.out.println("Enter maximum speed: ");
        int maxSpeed =  new Scanner(System.in).nextInt();
        System.out.println("Enter weight of the bike: ");
        int weight =  new Scanner(System.in).nextInt();
        System.out.println("Enter if the bike has lights true/false: ");
        boolean hasLights =  new Scanner(System.in).nextBoolean();
        System.out.println("Enter battery capacity: ");
        int batteryCapacity =  new Scanner(System.in).nextInt();
        System.out.println("Enter color: ");
        String color =  new Scanner(System.in).next();
        System.out.println("Enter price: ");
        int price =  new Scanner(System.in).nextInt();
        catalogue.addBike(new EBike(brand, weight, hasLights, color, price, maxSpeed, batteryCapacity));;

    }

    public static void findItem(){
        System.out.println("Enter brand: ");
        //filter method
    }

    public static void writeToFile(EcoBikeCatalogue catalogue) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter("resources/ecobikeTEST.txt");
        ArrayList<Bike> writeList = (ArrayList) catalogue.getCatalogue();
        for(int i = 0; i < writeList.size(); i++){
            if(writeList.get(i) instanceof FoldingBike){((FoldingBike) writeList.get(i)).writeToFile(writer);}
            if(writeList.get(i) instanceof SpeedElec){((SpeedElec) writeList.get(i)).writeToFile(writer);}
            if(writeList.get(i) instanceof EBike){((EBike) writeList.get(i)).writeToFile(writer);}
        }
        writer.close();
    }

}

