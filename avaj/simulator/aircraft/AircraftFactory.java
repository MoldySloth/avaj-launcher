package avaj.simulator.aircraft;

import avaj.weather.Coordinates;

public class AircraftFactory {
    public static Flyable  newAircraft(String type, String name, int longitude, int latitude, int height) {

        switch (type.toLowerCase()) {
            case "baloon":
                return new Baloon(name, new Coordinates(longitude, latitude, height));
            case "jetplane":
                return new JetPlane(name, new Coordinates(longitude, latitude, height));
            case "helicopter":
                return new Helicopter(name, new Coordinates(longitude, latitude, height));
            default:
                break;
        }
        return null;
    }
}

// factory method to create a new Aircraft

// Name
//  Aircraft
// Attributes
//  ----
// Methods
//  public newAircraft(type: string, name: string, longitude: int, latitude: int, height: int): Flyable
