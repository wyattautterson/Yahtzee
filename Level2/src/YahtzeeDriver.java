/**
 * Created by wautterson16 on 12/17/15.
 */
import java.util.Scanner;

public class YahtzeeDriver
{
    /*
    1. Creates a new instance of the YahtzeeGame class
    2. Calls the playGame method on the Yahtzee object
    3. Asks user if they would like to play again
    4. When the user is done playing, prints the number of games played, min, max, and average score
    */
    public static void main(String [] args)
    {
        Scanner keyboard = new Scanner(System.in);
        int games = 0;
        int minScore = 1576;
        int maxScore = 0;
        int totalScore = 0;
        do {
            int score;
            YahtzeeGame myGame = new YahtzeeGame();
            System.out.println("Welcome to Wyatt's APCSA Yahtzee Game!");
            score = myGame.playGame();
            System.out.println("Do you want to play again Yes or No? ");
            String s = keyboard.nextLine();
            games++;
            if (score < minScore) {
                minScore = score;
            } else if (score > maxScore) {
                maxScore = score;
            }
            totalScore += score;
        }
            while (keyboard.equals("Yes")) ;
        double AverageScore = totalScore*1.0/games;


        System.out.println("Number of games played: "+ games);
        System.out.println("Maximum Score: "+ maxScore);
        System.out.println("Minimum Score: "+minScore);
        System.out.println("Average Score: "+AverageScore);


    }
}

