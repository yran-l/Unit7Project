import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PackageSimulator {
    private Package[] packages;
    private String[] zipCodes;
    private Scanner s;

    public PackageSimulator() {
        File f = new File("zipCodes");
        try {
            s = new Scanner(f);
        }
        catch (FileNotFoundException e) {
            System.out.println("File was not found");
            System.exit(1);
        }

        String data = "";
        while (s.hasNextLine()) {
            data += s.nextLine() + "|";
        }
        zipCodes = data.split("\\|");
    }


    public void generatePackages(int num) {
        packages = new Package[num];
        for (int i = 0; i < num; i ++) {

            String one = zipCodes[(int) (Math.random() * zipCodes.length)];
            String two = zipCodes[(int) (Math.random() * zipCodes.length)];
            Address origin = new Address("123", "Random Street", "3C", "City", "State", one);
            Address destination = new Address("123", "Random Street", "3C", "City", "State", two);

            double pounds = (Math.random() * 50) + .1;
            double length = (Math.random() * 13) + 2;
            double width = (Math.random() * 13) + 2;
            double height = (Math.random() * 13) + 2;

            packages[i] = new Package(origin, destination, pounds, length, width, height);

        }
    }

    public double generateTotalCost() {

        double total = 0;
        for (int i = 0; i < packages.length; i++) {
            total += PostageCalculator.calculatePostage(packages[i]);
        }
        return Math.round(total * 100) / 100.0;

    }

    public void getSimulationInfo() {

        System.out.println("Randomly Generated Packages Info: ");
        for (int i = 0; i < packages.length; i ++) {
            System.out.println("Package " + (i + 1) + ": ________________________________________________");
            System.out.println("Origin Address: " + packages[i].getOrigin());
            System.out.println("Destination Address: " + packages[i].getDestination());
            System.out.println("Weight: " + packages[i].getPounds() + " pounds");
            System.out.println("Height: " + packages[i].getHeight() + " inches");
            System.out.println("Length: " + packages[i].getLength() + " inches");
            System.out.println("Width: " + packages[i].getWidth() + " inches");
            System.out.println("Cost: " + PostageCalculator.calculatePostage(packages[i]));
        }
        System.out.println("________________________________________________");
        System.out.println("Total Cost of all packages: " + generateTotalCost());

    }

    public void resetSimulation() {
        packages = new Package[0];
    }
}