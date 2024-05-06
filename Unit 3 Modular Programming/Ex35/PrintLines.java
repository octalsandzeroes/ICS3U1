import java.util.*;
import java.io.*;
import java.nio.file.Paths;

/*
PrintLines
By Andrew Martinus
Last modified on May 5, 2024
This program reads and prints out each line from a file called "line.txt"
*/

public class PrintLines{
    // main method
    public static void main(String[] args){
        final String FILE_NAME = "C:/Users/Andrew/Documents/Coding Projects/ICS3U1/Unit 3 Modular Programming/Ex35/line.txt";
        File f = new File(FILE_NAME);
        System.out.println(f.getAbsolutePath());
        System.out.println(Paths.get("").toAbsolutePath());
        //FileReader reader = new FileReader(FILE_NAME);
    }
}