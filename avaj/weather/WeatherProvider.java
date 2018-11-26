package avaj.weather;

import java.util.*;

public class WeatherProvider {
    private static WeatherProvider weatherProvider = null;
    private static String[] weather = {"Rain", "Fog", "Sun", "Snow"};

    private WeatherProvider() { }

    public static WeatherProvider   getProvider() {
        if (weatherProvider == null) {
            weatherProvider = new WeatherProvider();
        }
        return weatherProvider;
    }

    public String   getCurrentWeather(Coordinates coordinates) {
        // random number to and return random weather element
        Random rand = new Random();
        int n = rand.nextInt(4);
        return weather[n];
    }
}

//Rain
//Fog
//Sun
//Snow

// Name
//  WeatherProvider
// Attributes
//  private weatherProvider : WeatherProvider
//  private static weather: String[];
// Methods
//  private WeatherProvider()
//  public static getProvider() : WeatherProvider
//  public getCurrentWeather( coordinates: Coordinates ): String