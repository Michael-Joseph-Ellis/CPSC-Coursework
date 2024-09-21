package cpsc2150.extendedConnectX.models;

/*

Michael Ellis - Michael-Joseph-Ellis

Ryan Chen - rchen55

Cooper Taylor - Cooper-Taylor

Adam Niemczura - AdamNiem

 */

public class BoardPosition
{
    private int Row;
    private int Column;

    /**
     * A paramaterized constructor for BoardPosition, accepts 2 integers
     * 
     * @param aRow the value of a row on the game board 
     * @param aColumn the value of a column on the game board
     * 
     * @pre aRow >= 0 AND aColumn >= 0
     * 
     * @post this.Row = aRow AND this.Column = aColumn
     * 
     */
    
    public BoardPosition(int aRow, int aColumn)
    {
        //parameterized constructor for BoardPosition
    }

    /**
     * Standard getter for the row of the board position 
     *
     * @return the row of the board position 
     * 
     * @pre this != null
     * 
     * @post getRow = aRow AND getColumn = #aColumn
     * 
     */

    public int getRow()
    {
        //returns the row
    }

    /**
     * Standard getter for the column of the board position
     * 
     * @return the column of the board position 
     * 
     * @pre this != null
     * 
     * @post getRow = #aRow AND getColumn = aColumn
     * 
     */

    public int getColumn()
    {
        //returns the column
    }

    /**
     * Standard override for the equals method
     * 
     * @param obj the object to compare to
     * 
     * @return true if the objects are equal, false otherwise
     * 
     * @pre obj != null
     * 
     * @post equals = true OR equals = false
     * 
     */

    @Override
    public boolean equals(Object obj)
    {

    }

    /**
     * Standard override for the toString method
     * 
     * @return the string representation of the board position
     * 
     * @pre this != null
     * 
     * @post toString = "Row: " + this.Row + " Column: " + this.Column
     * 
     */

    @Override
    public String toString()
    {

    }
}