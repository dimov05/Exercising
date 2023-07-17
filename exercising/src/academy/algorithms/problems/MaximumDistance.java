package academy.algorithms.problems;

//Write a function that takes fuel (liters), fuelUsage (liters/100km), passengers, airConditioner (boolean) and returns maximum distance that car can travel.
//
//        fuel is the number of liters of fuel in the fuel tank.
//        fuelUsage is basic fuel consumption per 100 km (with the driver inside only).
//        Every additional passenger is increasing basic fuel consumption by 5%.
//        If the air conditioner is ON true, its increasing total (not basic) fuel consumption by 10%.
//        Examples
//        totalDistance(70.0, 7.0, 0, false) ➞ 1000.0
//
//        totalDistance(36.1, 8.6, 3, true) ➞ 331.83
//
//        totalDistance(55.5, 5.5, 5, false) ➞ 807.3
//        Notes
//        fuel and fuelUsage are always greater than 1.
//        passengers are always greater or equal to 0.
//        The tolerance of the returned value is 0.1.
public class MaximumDistance {
    public static void main(String[] args) {

        double liters = 55.5;
        double fuelUsage = 5.5;
        int passengers = 5;
        boolean airConditioner = false;
        System.out.printf("%.1f", totalDistance(liters, fuelUsage, passengers, airConditioner));
    }

    private static double totalDistance(double liters, double fuelUsage, int passengers, boolean airConditioner) {
        fuelUsage = fuelUsage * (1 + passengers * 0.05);
        fuelUsage = airConditioner ? fuelUsage * 1.10 : fuelUsage;
        return liters / fuelUsage * 100;

    }
}
