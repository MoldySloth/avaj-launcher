package avaj.simulator.aircraft;

import avaj.weather.Coordinates;

public class Aircraft {
    protected long          id;
    protected String        name;
    protected Coordinates coordinates;
    private static long     idCounter = 1;

    protected Aircraft(String name, Coordinates coordinates) {
        this.id = nextId();
        this.name = name;
        this.coordinates = coordinates;
    }

    private long    nextId() { return idCounter++; }

    public Coordinates getCoordinates() {
        return coordinates;
    }
}

// Abstract class for Helicopter, JetPlane and Baloon

// Name
//  Aircraft
// Attributes
//  protected id: long
//  protected name: string
//  protected coordinates: Coordinates
//  private idCounter: long
// Methods
//  protected Aircraft(name: string, coordinates: Coordinates)
//  private nextId(): long