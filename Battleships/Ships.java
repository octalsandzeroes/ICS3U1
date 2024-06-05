import java.util.*;
import java.io.*;

public class Ships {
    private char[] shipArray;
    private String shipStartCoords; // the starting coords of a ship in "[Index #],[Index #]" format
    private String shipEndCoords; // the ending coords of a ship in "[Index #],[Index #]" format
    private int shipHealth;

    public Ships(int shipSize, char shipChar, String shipStartCoords, String shipEndCoords){
        // initializes the fields of the object
        this.shipHealth = shipSize;
        this.shipStartCoords = shipStartCoords;
        this.shipEndCoords = shipEndCoords;
        this.shipArray = new char[shipSize];

        // fills the ships array with the ship character initially
        for (int i = 0; i < shipSize; i++){
            this.shipArray[i] = shipChar;
            System.out.print(shipChar);
        }
    }

    public char[] accessShipArray(){
        return this.shipArray;
    }

    public String accessShipStartCoords(){
        return this.shipStartCoords;
    }

    public String accessShipEndCoords(){
        return this.shipEndCoords;
    }
}
