package optimization.vrp;

import java.io.PrintWriter;
import java.util.List;

public class Result {

    private final InputData input;
    private final List<Vehicle> vehicles;
    private final boolean optimal;

    public Result(InputData input, List<Vehicle> vehicles, boolean optimal) {
        this.input = input;
        this.vehicles = vehicles;
        this.optimal = optimal;
    }

    public void outputTo(PrintWriter out) {
        out.print(calcCost());
        out.print(' ');
        out.print(optimal ? 1 : 0);
        out.print('\n');

        for (Vehicle vehicle : vehicles) {
            List<Location> locations = vehicle.getLocations();
            for (Location location : locations) {
                out.print(location.getIndex());
                out.print(' ');
            }
            out.print('\n');
        }
    }

    public double calcCost() {
        return 0.0;
    }

    public void visualizeTo(String filename) {
        new Drawer(input, this, filename).visualize();
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

}
