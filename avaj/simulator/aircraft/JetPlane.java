package avaj.simulator.aircraft;

import avaj.simulator.MyLogger;
import avaj.weather.Coordinates;
import avaj.simulator.WeatherTower;

public class JetPlane extends Aircraft implements Flyable {
    private WeatherTower weatherTower;
    private MyLogger logs = new MyLogger();

    JetPlane(String name, Coordinates coordinates) {
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
                logs.writeTo("JetPlan#" + super.name + "(" + super.id + "): We are gliding like oil through fire in this sunshine\n");
                break;
            case "Rain":
                this.coordinates = new Coordinates(
                        coordinates.getLongitude() + 0,
                        coordinates.getLatitude() + 5,
                        coordinates.getHeight() + 0
                );
                logs.writeTo("JetPlane#" + super.name + "(" + super.id + "): It's a sea of torture out here! BRING ON THE TEQUILA\n");
                break;
            case "Fog":
                this.coordinates = new Coordinates(
                        coordinates.getLongitude() + 0,
                        coordinates.getLatitude() + 1,
                        coordinates.getHeight() + 0
                );
                logs.writeTo("JetPlane#" + super.name + "(" + super.id + "): My mother told me a story about fog once...\n");
                break;
            case "Snow":
                this.coordinates = new Coordinates(
                        coordinates.getLongitude() + 0,
                        coordinates.getLatitude() + 0,
                        coordinates.getHeight() - 7
                );
                logs.writeTo("JetPlane#" + super.name + "(" + super.id + "): Umm... Lets see how this goes?\n");
                break;
            default:
                break;
        }
        // check them against max and min values allowed
        // land if necessary
        if (this.coordinates.getHeight() == 0) {
            logs.writeTo("JetPlane#" + super.name + "(" + super.id + "): landing.\n");
            logs.writeTo("Tower says: JetPlane#" + super.name + "(" + super.id + ") unregistered from weather tower.\n");
            this.weatherTower.unregister(this);
        }
    }

    public void     registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        logs.writeTo("Tower says: JetPlane#" + super.name + "(" + super.id + ") registered to weather tower.\n");
        weatherTower.register(this);
    }
}

// Name
//  JetPlane
// Attributes
//  private weatherTower: WeatherTower
// Methods
//  private JetPlane(name: string, coordinates: Coordinates)
//  public updateConditions(): void
//  public registerTower(weatherTower: WeatherTower): void

// Sun - Lat + 10, Height + 2
// Rain - Lat + 5
// Fog - Lat + 1
// Snow - Height - 7
