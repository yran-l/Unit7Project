import java.util.Scanner;

public class PostageSimulatorRunner {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        PackageSimulator sim = new PackageSimulator();
        boolean run = true;
        while (run) {

            System.out.println("________________________________________________");
            System.out.println("What would you like to do?");
            System.out.println("1. Calculate cost of one package");
            System.out.println("2. Simulate packages");
            System.out.println("3. How package costs are calculated");
            System.out.println("4. Exit");
            System.out.print("Input: ");
            String temp = s.nextLine();
            int userChoice = Integer.parseInt(temp);
            System.out.println("________________________________________________");

            if (userChoice == 1) {

                System.out.print("Enter the zip code of origin package: ");
                String origin = s.nextLine();
                System.out.print("Enter the zip code of destination package: ");
                String destination = s.nextLine();
                System.out.print("Enter the weight of the package: ");
                double pounds = Double.parseDouble(s.nextLine());
                System.out.print("Enter the height of the package: ");
                double height = Double.parseDouble(s.nextLine());
                System.out.print("Enter the length of the package: ");
                double length = Double.parseDouble(s.nextLine());
                System.out.print("Enter the width of the package: ");
                double width = Double.parseDouble(s.nextLine());

                System.out.println("Cost: " + PostageCalculator.calculatePostage(origin, destination, pounds, length, width, height));

            }
            else if (userChoice == 2)
            {

                System.out.print("How many packages would you like to simulate? ");
                int num = Integer.parseInt(s.nextLine());
                sim.generatePackages(num);
                sim.getSimulationInfo();
                sim.resetSimulation();
            }
            else if (userChoice == 3)
            {
                System.out.println(
                        "The base cost is $3.75\n" +
                                "Add 5 cents for each tenth of a pound\n" +
                                "Divide the difference in county codes by 100 and add that to calculate the final total\n" +
                                "\n" +
                                "Any package that exceeds a combined 36 inches will cost an additional 10 cents per inch.\n" +
                                "Additionally, packages that are more than 40 pounds will be charged 10 cents per tenth of a pound over the 40 pound limit."
                );
            }
            else if (userChoice == 4)
            {
                run = false;
            }
        }
    }
}