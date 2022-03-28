/**
 * This class represents a Board object
 *
 * @author Maggie Li
 */
public class Board
{
    /** The Boggle grid board */
    private String[][] grid;

    /**
     * Instantiates a Board object
     *
     * @param grid The Boggle grid board
     */
    public Board(String[][] grid)
    {
        this.grid = grid;
    }

    /**
     * Draws the Boggle board
     * <p>
     * Creates the Boggle board based on the created Board object
     */
    public void drawBoard()
    {
        for(int row = 0; row < grid.length; row++)
        {
            for (int col = 0; col < grid[0].length; col++)
            {
                System.out.print(grid[row][col] + "|");
            }
            System.out.println();
        }
    }

}
