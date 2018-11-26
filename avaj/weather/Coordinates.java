package avaj.weather;

public class Coordinates {
    private int     longitude;
    private int     latitude;
    private int     height;

    public Coordinates(int longitude, int latitude, int height) {
        this.longitude = checkInt(longitude);
        this.latitude = checkInt(latitude);
        this.height = checkInt(height);
    }

    public int getLongitude() { return this.longitude; }

    public int getLatitude() { return this.latitude; }

    public int getHeight() { return this.height; }

    private static int checkInt(int number) {
        if (number < 0) {
            number = 0;
        } else if (number > 100) {
            number = 100;
        }
        return number;
    }
}

// Composition -> Child of Aircraft

// Name
//  Coordinates
// Attributes
//  private longitude: int
//  private latitude: int
//  private height: int
// Methods
//  private Coordinates( longitude: int, latitude: int, height: int)
//  public getLongitude()
//  public getLatitude()
//  public getHeight()