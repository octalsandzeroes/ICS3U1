import java.util.*;
import java.io.*;

public class Ships {
    private char[] shipArray;
    private String shipStartCoord; // the starting Coord of a ship in "[Index #],[Index #]" format
    private String shipEndCoord; // the ending Coord of a ship in "[Index #],[Index #]" format
    private String shipName;
    private char shipChar;
    private int shipHealth;

    public Ships(String shipName, char shipChar, int shipSize, String shipStartCoord, String shipEndCoord){
        // initializes the fields of the object
        this.shipArray = new char[shipSize];
        this.shipStartCoord = shipStartCoord;
        this.shipEndCoord = shipEndCoord;
        this.shipName = shipName;
        this.shipChar = shipChar;
        this.shipHealth = shipSize;

        // fills the ships array with the ship character initially
        for (int i = 0; i < shipSize; i++){
            this.shipArray[i] = shipChar;
        }
    }

    public char[] accessShipArray(){
        return this.shipArray;
    }

    public String accessShipStartCoord(){
        return this.shipStartCoord;
    }

    public String accessShipEndCoord(){
        return this.shipEndCoord;
    }
}
