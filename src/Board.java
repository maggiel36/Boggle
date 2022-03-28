public class Board
{
    private String[][] grid;

    public Board(String[][] grid)
    {
        this.grid = grid;
    }

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
