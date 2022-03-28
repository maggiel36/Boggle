import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.util.Arrays;

/**
 * This class represents a Boggle object
 *
 * @author Maggie Li
 */
public class Boggle
{
    /** The playing status of the Boggle game */
    private boolean playing = true;

    /** The words that the player has found */
    private ArrayList foundWords = new ArrayList<>();

    /** All the possible words that can be found in the Boggle game */
    String[] words = {"yay", "sir", "sim", "say", "rim", "ray", "ram", "may", "air", "aim", "yays", "yams", "rims", "rays", "raya", "rams", "mays", "maya", "aria", "aims", "maria", "arias"};

    /** The String array words is stored in this ArrayList answers */
    ArrayList<String> answers = new ArrayList<>(Arrays.asList(words));

    /**
     * Runs the Boggle game
     * <p>
     * While playing is true, the player can continue to find the words in the Boggle board, or enter "x" to quit the game, which will display all the answers in the Boggle board.
     */
    public void play()
    {
        String[][] board = {{"y", "s", "m"},
                            {"y", "a", "i"},
                            {"a", "a", "r"}};

        Board grid = new Board(board);

        System.out.println("Welcome to Boggle!\n");
        System.out.println("The goal of the game is to find as many words as you can in the 3x3 jumbled grid of 9 letters!");
        System.out.println("The letters can be in any direction - up, down, left, right, or diagonal.");
        System.out.println("Letters can only be once used per word, and words must be 3 letters or longer.\n");

        while (playing)
        {
            grid.drawBoard();

            Scanner scanner = new Scanner(System.in);
            System.out.println("\nPress (x) to quit");
            System.out.print("Enter a Word: ");
            String word = scanner.nextLine();

            if (word.equals("x"))
            {
                playing = false;
                System.out.print("Good try! All the possible answers were: " + answers);
            }

            isWord(word);
            endGame();
        }
    }

    /**
     * Searches to see if the word that the player enters is part of the word list.
     * <p>
     * If the word that the player enters if valid, it will add the word to the foundWords ArrayList.
     * If the word that the player enters has already been found by the player, it will notify the player that they have already found that word.
     *
     * @param word The word that the player enters
     */
    public void isWord(String word)
    {
        for (int i = 0; i < words.length; i++)
        {
            if (word.equals(words[i]))
            {
                if (foundWords.contains(word))
                {
                    System.out.println("You already found that word!");
                }
                else
                {
                    foundWords.add(word);
                }
                System.out.println("Found Word(s): " + foundWords + "\n");
            }
        }
    }

    /**
     * Ends the game if the player has found all 22 words in the Boggle board.
     * Prints a message congratulating the player.
     */
    public void endGame()
    {
        for (int i = 0; i <= foundWords.size(); i++)
        {
            if (i == 22)
            {
                System.out.println("Good job! You have found all the possible words!");
                playing = false;
            }
        }
    }
}