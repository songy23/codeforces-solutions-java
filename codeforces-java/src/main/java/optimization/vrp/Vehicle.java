package optimization.vrp;

import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang3.Validate;

import com.google.common.collect.Lists;

public class Vehicle {

    private final int index;
    private final Location warehouse;
    private final List<Location> locations = Lists.newLinkedList();

    private int capacity;

    public Vehicle(int index, int capacity, Location warehouse) {
        this.index = index;
        this.capacity = capacity;
        this.warehouse = warehouse;
    }

    public boolean canSatisfy(Location location) {
        return capacity >= location.getDemand();
    }

    public void addLocation(Location location) {
        Validate.isTrue(canSatisfy(location), "can't satisfy the demand of location %d", location.getIndex());
        capacity = capacity - location.getDemand();
        locations.add(location);
    }

    public double calcCost() {
        if (locations.isEmpty()) {
            return 0.0;
        }

        double cost = 0.0;
        Iterator<Location> iterator = getLocations().iterator();
        Location first = iterator.next();
        Location second = iterator.next();

        cost = cost + first.dist(second);

        while (iterator.hasNext()) {
            Location next = iterator.next();
            first = second;
            second = next;
            cost = cost + first.dist(second);
        }

        return cost;
    }

    public boolean isFull() {
        return capacity == 0;
    }

    @Override
    public String toString() {
        return "Vehicle [" + index + ", c=" + capacity + "; " + locations + "]";
    }

    public List<Location> getLocations() {
        List<Location> result = Lists.newLinkedList();
        result.add(warehouse);
        result.addAll(locations);
        result.add(warehouse);
        return result;
    }

    public List<Location> getLocationsWithoutDepot() {
        return locations;
    }

    public int getIndex() {
        return index;
    }
}
