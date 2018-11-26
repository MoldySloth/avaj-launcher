package avaj.simulator.aircraft;

import avaj.simulator.MyLogger;
import avaj.weather.Coordinates;
import avaj.simulator.WeatherTower;

public class Baloon extends Aircraft implements Flyable {
    private WeatherTower weatherTower;
    private MyLogger logs = new MyLogger();

    Baloon(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void     updateConditions() {
        // change conditions according to the current weather
        String weather = this.weatherTower.getWeather(this.coordinates);
        switch (weather) {
            case "Sun":
                this.coordinates = new Coordinates(
                        coordinates.getLongitude() + 2,
                        coordinates.getLatitude(),
                        coordinates.getHeight() + 4
                );
                logs.writeTo("Ballon#" + super.name + "(" + super.id + "): Great weather for a baloon ride!\n");
                break;
            case "Rain":
                this.coordinates = new Coordinates(
                        coordinates.getLongitude() + 0,
                        coordinates.getLatitude() + 0,
                        coordinates.getHeight() + 5
                );
                logs.writeTo("Ballon#" + super.name + "(" + super.id + "): This is dampening our spirits...\n");
                break;
            case "Fog":
                this.coordinates = new Coordinates(
                        coordinates.getLongitude() + 0,
                        coordinates.getLatitude() + 0,
                        coordinates.getHeight() - 3
                );
                logs.writeTo("Ballon#" + super.name + "(" + super.id + "): We can't see where we are... Hope we don't crash!\n");
                break;
            case "Snow":
                this.coordinates = new Coordinates(
                        coordinates.getLongitude() + 0,
                        coordinates.getLatitude() + 0,
                        coordinates.getHeight() - 15
                );
                logs.writeTo("Ballon#" + super.name + "(" + super.id + "): Brrrrrrrr!!!!!!!\n");
                break;
            default:
                break;
        }
        // check them against max and min values allowed
        // land if necessary
        if (this.coordinates.getHeight() == 0) {
            logs.writeTo("Ballon#" + super.name + "(" + super.id + "): landing.\n");
            this.weatherTower.unregister(this);
            logs.writeTo("Tower says: Ballon#" + super.name + "(" + super.id + ") unregistered from weather tower.\n");

        }
    }

    public void     registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        logs.writeTo("Tower says: Ballon#" + super.name + "(" + super.id + ") registered to weather tower.\n");
        weatherTower.register(this);
}
}

// Name
//  Baloon
// Attributes
//  private weatherTower: WeatherTower
// Methods
//  private Baloon(name: string, coordinates: Coordinates)
//  public updateConditions(): void
//  public registerTower(weatherTower: WeatherTower): void

// Sun - Long + 2, Height + 4
// Rain - Height + 5
// Fog - Height - 3
// Snow - Height - 15
