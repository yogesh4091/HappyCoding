package parkinglot;

import java.lang.ref.WeakReference;
import java.util.*;

abstract class Vehicle {

  boolean fitInSmallSlot;
  boolean fitInCompactSlot;
  boolean fitInLargeSlot;

  boolean canFitInSmallSlot() {
    return fitInSmallSlot;
  }

  boolean canFitInCompactSlot() {
    return fitInCompactSlot;
  }

  boolean canFitInLargeSlot() {
    return fitInLargeSlot;
  }
}

class Motorcycle extends Vehicle {

  public Motorcycle() {
    fitInSmallSlot = true;
    fitInCompactSlot = true;
    fitInLargeSlot = true;
  }
}

class Car extends Vehicle {
  public Car() {
    fitInCompactSlot = true;
    fitInLargeSlot = true;
  }
}

class Bus extends Vehicle {
  public Bus() {
    fitInLargeSlot = true;
  }
}

abstract class Slot {

  private boolean isOccupied;
  private int slotNumber;

  Slot(int slotNumber) {
    isOccupied = false;
    this.slotNumber = slotNumber;
  }

  boolean isOccupied() {
    return isOccupied;
  }

  int getSlotNumber() {
    return slotNumber;
  }

  void park() {
    isOccupied = true;
  }

  void unPark() {
    isOccupied = false;
  }

  @Override
  public boolean equals(Object o) {
    return (((Slot) o).slotNumber == this.slotNumber);
  }

  @Override
  public int hashCode() {
    int hash = 5;
    hash = 53 * hash + this.slotNumber;
    return hash;
  }
}

class SmallSlot extends Slot {

  SmallSlot(int slotNumber) {
    super(slotNumber);
  }
}

class CompactSlot extends Slot {

  CompactSlot(int slotNumber) {
    super(slotNumber);
  }
}

class LargeSlot extends Slot {

  LargeSlot(int slotNumber) {
    super(slotNumber);
  }
}

public class ParkingLot {

  private final int totalSmallSlots;
  private final int totalCompactSlots;
  private final int totalLargeSlots;
  public Map<Long, Slot> occupiedSlots;
  private List<Slot> smallSlots;
  private List<Slot> compactSlots;
  private List<Slot> largeSlots;

  public ParkingLot(int totalSmallSlots, int totalCompactSlots, int totalLargeSlots) {
    this.totalSmallSlots = totalSmallSlots;
    this.totalCompactSlots = totalCompactSlots;
    this.totalLargeSlots = totalLargeSlots;
    smallSlots = new ArrayList<Slot>(totalSmallSlots);
    compactSlots = new ArrayList<Slot>(totalCompactSlots);
    largeSlots = new ArrayList<Slot>(totalLargeSlots);
    createSlots();
    occupiedSlots = new HashMap<Long, Slot>();
  }

  public static void main(String[] args) {

    ParkingLot parkingLot = new ParkingLot(1, 1, 2);
    Vehicle bike1 = new Motorcycle();
    Vehicle bike2 = new Motorcycle();
    Vehicle car1 = new Car();
    Vehicle bus1 = new Bus();
    parkingLot.park(bike1);
    parkingLot.park(bike2);
    parkingLot.park(car1);
    parkingLot.park(bus1);
    long uniqueToken = bike1.hashCode() * 43;
    parkingLot.unPark(uniqueToken);

    Bus bus = new Bus();
    WeakReference<Bus> weakReference = new WeakReference<Bus>(bus);
    bus = null;

  }

  private void createSlots() {

    for (int i = 1; i <= totalSmallSlots; i++) {
      smallSlots.add(new SmallSlot(i));
    }
    for (int i = 1; i <= totalCompactSlots; i++) {
      compactSlots.add(new CompactSlot(i));
    }
    for (int i = 1; i <= totalLargeSlots; i++) {
      largeSlots.add(new LargeSlot(i));
    }
  }

  public long park(Vehicle vehicle) {

    Slot slot;
    long uniqueToken = -1;

    if (vehicle.canFitInSmallSlot()) {
      if ((slot = getFirstEmptySlot(smallSlots)) != null) {
        uniqueToken = parkHelper(slot, vehicle);
        return uniqueToken;
      }
    }
    if (vehicle.canFitInCompactSlot()) {
      if ((slot = getFirstEmptySlot(compactSlots)) != null) {
        uniqueToken = parkHelper(slot, vehicle);
        return uniqueToken;
      }
    }

    if (vehicle.canFitInLargeSlot()) {
      if ((slot = getFirstEmptySlot(largeSlots)) != null) {
        uniqueToken = parkHelper(slot, vehicle);
        return uniqueToken;
      }
    }
    return uniqueToken;
  }

  public void unPark(long uniqueToken) {
    occupiedSlots.get(uniqueToken).unPark();
    occupiedSlots.remove(uniqueToken);
  }

  private Slot getFirstEmptySlot(List<Slot> slots) {
    Iterator<Slot> slotIterator = slots.iterator();
    Slot emptySlot = null;

    while (slotIterator.hasNext()) {
      emptySlot = slotIterator.next();
      if (!emptySlot.isOccupied()) {
        return emptySlot;
      }
    }
    return null;
  }

  private long parkHelper(Slot slot, Vehicle vehicle) {
    slot.park();
    long uniqueToken = vehicle.hashCode() * 43;
    occupiedSlots.put(uniqueToken, slot);
    return uniqueToken;
  }
}
