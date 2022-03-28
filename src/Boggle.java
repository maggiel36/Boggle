import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.util.Arrays;

public class Boggle
{

    private boolean playing = true;
    private ArrayList foundWords = new ArrayList<>();

    String[] words = {"yay", "sir", "sim", "say", "rim", "ray", "ram", "may", "air", "aim", "yays", "yams", "rims", "rays", "raya", "rams", "mays", "maya", "aria", "aims", "maria", "arias"};
    ArrayList<String> answers = new ArrayList<>(Arrays.asList(words));

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
            endgame();
        }
    }

    public boolean isWord(String word)
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
        return false;
    }

    public void endgame()
    {
        for (int i = 0; i <= foundWords.size(); i++)
        {
            if (i == 22)
            {
                playing = false;
                System.out.println("Good job! You have found all the possible words!");
            }
        }
    }
}