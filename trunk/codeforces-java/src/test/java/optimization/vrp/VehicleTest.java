package optimization.vrp;

import java.util.Arrays;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class VehicleTest {

    Location warehouse = new Location(0, 0, 0.0, 0.0);

    @Test
    public void getLocations_containsWarehouses() {
        Vehicle vehicle = new Vehicle(1, 10, warehouse);
        assertEquals(vehicle.getLocations(), Arrays.asList(warehouse, warehouse));
    }

    @Test
    public void addLocation() {
        Vehicle vehicle = new Vehicle(1, 10, warehouse);

        Location location = new Location(1, 5, 1.0, 1.0);
        vehicle.addLocation(location);

        assertEquals(vehicle.getLocations(), Arrays.asList(warehouse, location, warehouse));
    }

    @Test
    public void canSatisfy() {
        Vehicle vehicle = new Vehicle(1, 10, warehouse);
        assertFalse(vehicle.canSatisfy(new Location(1, 50, 1.0, 1.0)));
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void addLocation_unsatisfiable() {
        Vehicle vehicle = new Vehicle(1, 10, warehouse);
        vehicle.addLocation(new Location(1, 50, 1.0, 1.0));
    }

    @Test
    public void calcCost() {
        Vehicle vehicle = new Vehicle(1, 100, warehouse);

        vehicle.addLocation(new Location(1, 5, 0.0, 1.0));
        vehicle.addLocation(new Location(2, 5, 1.0, 1.0));
        vehicle.addLocation(new Location(3, 5, 1.0, 0.0));

        assertEquals(vehicle.calcCost(), 4.0, 0.01);
    }

    @Test
    public void isFull() {
        Vehicle vehicle = new Vehicle(1, 10, warehouse);
        vehicle.addLocation(new Location(1, 10, 1.0, 1.0));
        assertTrue(vehicle.isFull());
    }
}
