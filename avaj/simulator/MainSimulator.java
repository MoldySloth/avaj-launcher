package avaj.simulator;

import avaj.simulator.aircraft.AircraftFactory;
import avaj.simulator.aircraft.Flyable;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class MainSimulator {
    // new weather tower instance
    private static WeatherTower weatherTower = new WeatherTower();
    // list /array of Flyable
    private static  List<Flyable> flyables = new ArrayList<Flyable>();
    public static MyLogger logs = new MyLogger();

    public static void  main(String[] args) {
        // Read the file
        BufferedReader  br = null;
        FileReader      fr = null;

        try {
            fr = new FileReader(args[0]);
            br = new BufferedReader(fr);

            String line = br.readLine();
            int simulations = Integer.parseInt(line.split(" ")[0]);
            // Check amount of simulations to run
            if (simulations < 0) {
                System.out.println("Invalid simulations number of " + simulations);
                System.exit(1);
            }

            while ((line = br.readLine()) != null) {
                // Send line split to aircraft factory
                if (line.split(" ").length == 5) {
                    line.split(" ");
                } else {
                    throw new IllegalArgumentException("Not enough parameters given");
                }
                try {
                    Flyable flyable = AircraftFactory.newAircraft(
                            line.split(" ")[0], line.split(" ")[1],
                            Integer.parseInt(line.split(" ")[2]),
                            Integer.parseInt(line.split(" ")[3]),
                            Integer.parseInt(line.split(" ")[4])
                    );

                    if (flyable != null) {
                        flyables.add(flyable);
                    }
                } catch (IllegalArgumentException e) {
                    e.getMessage();
                }
            }

            // register flyable from list to tower
            for (Flyable next : flyables) {
                next.registerTower(weatherTower);
            }

            // change weather conditions based on number of simulations
            for (int i = 1; i <= simulations; i++) {
                weatherTower.changeWeather();
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found " + args[0]);
        } catch (IOException e) {
            System.out.println("There was an error while reading the file " + args[0]);
        } finally {
            // Logger... Get logs!
            logs.closeLogger();
            try {
                if (br != null)
                    br.close();
                if (fr != null)
                    fr.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}

// Coordinates are +
// Height is 0-100
// Aircraft passes 100 it stays at 100
// New aircraft gets a unique ID, no 2 with same ID
// If aircraft = 0... it lands, unregisters from weather tower and logs current coords
// Weather change --> aircraft logs a message
//      TYPE#NAME(UNIQUE_ID): MESSAGE
// When a aircraft registers or unregisters from the tower, a message is logged

// FILE INPUT
// Needs to be validated... if incorrect, execution stops
// Error message to stdout

// Relationships
//    Open arrow = Inheritance
//    Line = Association Relationship
//    Open diamond = Aggregation (A whole and it's parts) can exist outside the whole
//    Closed diamond = Composition (Child object can't exist without it's parent) Can't exist outside the whole
//    Multiplicity = Numbers (Specify the max amount of instances allowed)
//      0..1    zero to one
//      n       specific number
//      0..*    zero to many
//      1..*    one to many
//      n..m    specific number range

// Name in italics of << NAME >> is abstract class

// Visibility
//    Public (+)
//    Private (-)
//    Protected (#)
//    Package (~)
//    Derived (/)
//    Static (underlined)
