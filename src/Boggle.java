import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Boggle
{

    private boolean playing = true;
    private ArrayList correctWords = new ArrayList<>();

    String[][] board = {{"y", "s", "m"},
            {"y", "a", "i"},
            {"a", "a", "r"}};

    String[] words = {"yay", "sir", "sim", "say", "rim", "ray", "ram", "may", "air", "aim", "yays", "yams", "rims", "rays", "raya", "rams", "mays", "maya", "aria", "aims", "maria", "arias"};

    public void play()
    {
        String[][] board = {{"y", "s", "m"},
                            {"y", "a", "i"},
                            {"a", "a", "r"}};

        Board grid = new Board(board);

        System.out.println("Welcome to Boggle!\n");
        System.out.println("The goal of the game is to find as many words as you can in the 3x3 jumbled grid of 9 letters!");
        System.out.println("The letters can be in any direction - up, down, left, right, or diagonal.");
        System.out.println("Letters can only be used per word, and words must be 3 letters or longer.\n");

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
                System.out.print("Good try! All the possible answers were: ");
                for (int i = 0; i < words.length; i++)
                {
                    System.out.print(words[i] + " ");
                }
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
                if (correctWords.contains(word))
                {
                    System.out.println("Already Found");

                    System.out.print("\033[H\033[2J");
                    System.out.flush();

                    System.out.println("Found Word(s): " + correctWords + "\n");
                }
                else
                {
                    correctWords.add(word);

                    System.out.print("\033[H\033[2J");
                    System.out.flush();

                    System.out.println("Found Word(s): " + correctWords);
                }
            }
        }
        return false;
    }

    public void endgame()
    {
        for (int i = 0; i <= correctWords.size(); i++)
        {
            if (i == 22)
            {
                playing = false;
                System.out.println("Good job! You have found all the possible words!");
            }
        }
    }

}