package avaj.simulator;

import avaj.weather.WeatherProvider;
import avaj.weather.Coordinates;

public class WeatherTower extends Tower {
    public String   getWeather(Coordinates coordinates) {
        // use weather provider to get the current weather
        return WeatherProvider.getProvider().getCurrentWeather(coordinates);
    }

    void    changeWeather() {
        super.conditionsChanged();
    }
}

// Inherits from Tower

// Name
//  WeatherTower
// Attributes
//  ---
// Methods
//  public getWeather( coordinates: Coordinates) : String
//  package changeWeather() : void
