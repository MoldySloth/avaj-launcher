package avaj.simulator.aircraft;

import avaj.simulator.MyLogger;
import avaj.weather.Coordinates;
import avaj.simulator.WeatherTower;

public class Helicopter extends Aircraft implements Flyable {
    private WeatherTower weatherTower;
    private MyLogger logs = new MyLogger();

    Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void     updateConditions() {
        // change conditions according to the current weather
        String weather = this.weatherTower.getWeather(this.coordinates);
        switch (weather) {
            case "Sun":
                this.coordinates = new Coordinates(
                        coordinates.getLongitude() + 10,
                        coordinates.getLatitude() + 0,
                        coordinates.getHeight() + 2
                );
                logs.writeTo("Helicopter#" + super.name + "(" + super.id + "): Luckily I have my sunglasses on, it's getting hot\n");
                break;
            case "Rain":
                this.coordinates = new Coordinates(
                        coordinates.getLongitude() + 5,
                        coordinates.getLatitude() + 0,
                        coordinates.getHeight() + 0
                );
                logs.writeTo("Helicopter#" + super.name + "(" + super.id + "): It's raining cats and dogs out here!\n");
                break;
            case "Fog":
                this.coordinates = new Coordinates(
                        coordinates.getLongitude() + 1,
                        coordinates.getLatitude() + 0,
                        coordinates.getHeight() + 0
                );
                logs.writeTo("Helicopter#" + super.name + "(" + super.id + "): Oooo... this weather reminds me of a horror film...\n");
                break;
            case "Snow":
                this.coordinates = new Coordinates(
                        coordinates.getLongitude() + 0,
                        coordinates.getLatitude() + 0,
                        coordinates.getHeight() - 12
                );
                logs.writeTo("Helicopter#" + super.name + "(" + super.id + "): Think all the snow it clogging up the motor\n");
                break;
            default:
                break;
        }
        // check them against max and min values allowed
        // land if necessary
        if (this.coordinates.getHeight() == 0) {
            logs.writeTo("Helicopter#" + super.name + "(" + super.id + "): landing.\n");
            logs.writeTo("Tower says: Helicopter#" + super.name + "(" + super.id + ") unregistered from weather tower.\n");
            this.weatherTower.unregister(this);
        }
    }

    public void     registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        logs.writeTo("Tower says: Helicopter#" + super.name + "(" + super.id + ") registered to weather tower.\n");
        weatherTower.register(this);
    }
}

// Name
//  Helicopter
// Attributes
//  private weatherTower: WeatherTower
// Methods
//  private Helicopter(name: string, coordinates: Coordinates)
//  public updateConditions(): void
//  public registerTower(weatherTower: WeatherTower): void

// Sun - Long + 10, Height + 2
// Rain - Long + 5
// Fog - Long + 1
// Snow - Height - 12
