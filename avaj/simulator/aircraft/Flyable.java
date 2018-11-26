package avaj.simulator.aircraft;

import avaj.simulator.WeatherTower;

public interface Flyable {
    public void     updateConditions();
    public void     registerTower(WeatherTower weatherTower);
}

// is an interface

// Name
//  Flyable
// Attributes
//  ----
// Methods
//  public updateConditions(): void
//  public registerTower(WeatherTower: WeatherTower): void
