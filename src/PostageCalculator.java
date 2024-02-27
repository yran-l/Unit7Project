public class PostageCalculator {
    public static double calculatePostage(String zipCodeOne, String zipCodeTwo, double weight, double length, double width, double height) {
        double cost = 3.75;

        cost += Math.floor(weight / 0.1) * 0.05;
        cost += Math.abs(Integer.parseInt(zipCodeOne.substring(0, 3)) - Integer.parseInt(zipCodeTwo.substring(0, 3))) / 100.0;

        if (length + width + height > 36) {
            cost += (int)(length + width + height - 36) * 0.10;
        }

        if (weight > 40) {
            cost += Math.floor(Math.floor(weight - 40) / 0.1) * 0.10;
        }

        return Math.round(cost * 100) / 100.0;
    }

    public static double calculatePostage(Address addressOne, Address addressTwo, double weight, double length, double width, double height) {
        double cost = 3.75;
        cost += Math.floor(weight / 0.1) * 0.05;
        cost += Math.abs(Integer.parseInt(addressTwo.getZipCode().substring(0, 3)) - Integer.parseInt(addressOne.getZipCode().substring(0, 3))) / 100.0;

        if (length + width + height > 36) {
            cost += (int)(length + width + height - 36) * 0.10;
        }

        if (weight > 40) {
            cost += Math.floor(Math.floor(weight - 40) / 0.1) * 0.10;
        }

        return Math.round(cost * 100.0)/100.0;
    }

    public static double calculatePostage(Package box) {
        double cost = 3.75;
        cost += Math.floor(box.getPounds() / 0.1) * 0.05;
        cost += Math.abs(Integer.parseInt(box.getOrigin().getZipCode().substring(0, 3)) - Integer.parseInt(box.getDestination().getZipCode().substring(0, 3))) / 100.0;

        if (box.getLength() + box.getWidth() + box.getHeight() > 36) {
            cost += (int)(box.getLength() + box.getWidth() + box.getHeight() - 36) * 0.10;
        }

        if (box.getPounds() > 40) {
            cost += Math.floor(Math.floor(box.getPounds() - 40) / 0.1) * 0.10;
        }

        return Math.round(cost * 100) / 100.0;
    }
}