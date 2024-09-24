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
     * A parameterized constructor for BoardPosition, accepts 2 integers
     * 
     * @param aRow the value of a row on the game board 
     * @param aColumn the value of a column on the game board
     * 
     * @return getRow = aRow AND row = #aRow AND getColumn = aColumn AND column = #aColumn 
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
     * @post getRow = #Row AND Row = #Row AND Column = #Column
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
     * @post getColumn = #Column AND Row = #Row AND Column = #Column
     * 
     */

    public int getColumn()
    {
        //returns the column
    }

    /**
     * Standard override for the equals method
     * 
     * @param obj the BoardPosition object to compare to
     * 
     * @return true IF (this.getColumn() == obj.getColumn() AND this.getRow() == obj.getRow()) ELSE false
     * 
     * @pre obj != null
     * 
     * @post equals = true OR equals = false AND obj = #obj AND Row = #Row AND Column = #Column
     * 
     */

    @Override
    public boolean equals(BoardPosition obj)
    {

    }

    /**
     * Standard override for the toString method
     * 
     * @return the string representation of the board position
     * 
     * @pre this != null
     * 
     * @post toString = "Row: " + this.Row + " Column: " + this.Column AND Column = #Column AND Row = #Row
     * 
     */

    @Override
    public String toString()
    {

    }
}
