/*
Line
By Andrew Martinus
Last modified on April 24, 2024
This class contains various methods relating to the properties of lines
*/

class Line {
    /*====================================================================
    |  double length (int x1, int y1, int x2, int y2)                    |
    |--------------------------------------------------------------------|
    |  returns double - The magnitude length of the string               |
    |--------------------------------------------------------------------|
    |  int x1 - This parameter is the first point's x coordinate         |
    |--------------------------------------------------------------------|
    |  int y1 - This parameter is the first point's y coordinate         |
    |--------------------------------------------------------------------|
    |  int x2 - This parameter is the second point's x coordinate        |
    |--------------------------------------------------------------------|
    |  int y2 - This parameter is the second point's y coordinate        |
    |--------------------------------------------------------------------|
    |  This method takes the coordinates of two points and then returns  |
    |  the length of the line segment formed by the two points           |
    ====================================================================*/
    public static double length (int x1, int y1, int x2, int y2){
        double length = Math.sqrt((Math.pow(x2-x1, 2)+Math.pow(y2-y1, 2)));
        return length;
    }

    /*====================================================================
    |  double slope (int x1, int y1, int x2, int y2)                     |
    |--------------------------------------------------------------------|
    |  returns double - The magnitude length of the string               |
    |--------------------------------------------------------------------|
    |  int x1 - This parameter is the first point's x coordinate         |
    |--------------------------------------------------------------------|
    |  int y1 - This parameter is the first point's y coordinate         |
    |--------------------------------------------------------------------|
    |  int x2 - This parameter is the second point's x coordinate        |
    |--------------------------------------------------------------------|
    |  int y2 - This parameter is the second point's y coordinate        |
    |--------------------------------------------------------------------|
    |  This method takes the coordinates of two points and then returns  |
    |  the the average slope of the two points                           |
    ====================================================================*/
    public static double slope (int x1, int y1, int x2, int y2){
        double slope = (double) (y2-y1)/ (double) (x2-x1);
        return slope;
    }
}