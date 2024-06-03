import java.util.*;
import java.io.*;

public class BattleshipRunner{
    public static void main(String[] args) {
        final int GRID_SIZE = 10;

        String charCoords = "A,10"; // pre-check coordinates in "[Char][Int]" format
        String test;

        Grids Player = new Grids(GRID_SIZE);
        Grids CPU = new Grids(GRID_SIZE);

        do{
            test = Grids.coordcheck(charCoords, GRID_SIZE);
        } while (test.compareTo("") == 0);
    } 
}