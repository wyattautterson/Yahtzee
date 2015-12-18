/**
 * Created by wautterson16 on 12/18/15.
 */
import java.util.Scanner;

public class YahtzeeGame
{
	/* instance data should include the five yahtzee dice, a scoreboard, and a CONSTANT (static final) variable NUM_SIDES
	which should be set to six (the number of sides on a yahtzee die) */
    private YahtzeeDie one;
    private YahtzeeDie two;
    private YahtzeeDie three;
    private YahtzeeDie four;
    private YahtzeeDie five;
    private YahtzeeScorecard scorecard;
    private static final int NUM_SIDES = 6;
    Scanner keyboard = new Scanner(System.in);

    /* initializes the dice and scoreboard */
    public YahtzeeGame()
    {
		one = new YahtzeeDie(NUM_SIDES);
        two = new YahtzeeDie(NUM_SIDES);
        three = new YahtzeeDie(NUM_SIDES);
        four = new YahtzeeDie(NUM_SIDES);
        five = new YahtzeeDie(NUM_SIDES);
        scorecard = new YahtzeeScorecard();
    }

    /* check to see if the game is over, and while the game is not over call the method takeTurn()
    once the game ends (hint: there are 13 turns in a game of Yahtzee), the method should print a
    final scorecard and return the grand total */
    public int playGame() {
        for (int i = 1; i <= 13; i++){
            takeTurn();
    }
        scorecard.printScoreCard();
        return scorecard.getGrandTotal();
    }

    /* 	1. call rollDice()
        2. call printDice()
        3. Ask the user if they are satisfied with their roll, or if they would like to roll again.
           If they are not satisfied continue, otherwise call markScore()
        4. call chooseFrozen()
        5. call rollDice()
        6. call printDice()
        7. Ask the user if they are satisfied with their roll, or if they would like to roll again.
           If they are not satisfied continue, otherwise call markScore()
        8. call chooseFrozen()
        9. call rollDice()
        10. call printDice()
        11. call markScore()
    */
    private void takeTurn(){
        rollDice();
        printDice();
        System.out.println();
        System.out.println("Are you (s)atisfied with your roll, or would you like to (r)oll again? (s/r): ");
        String s = keyboard.nextLine();
        int counter = 1;
        while (s.indexOf("s") > -1 && counter < 3){
            chooseFrozen();
            rollDice();
            printDice();
            System.out.println("Are you (s)atisfied with your roll, or would you like to (r)oll again? (s/r): ");
            s = keyboard.nextLine();
            counter++;
        }
        markScore();
    }

    /* Rolls all unfrozen dice.  Also resets all dice to the unfrozen state after the roll */
    private void rollDice()
    {
		if (!one.isFrozen())
            one.rollDie();
        if (!two.isFrozen())
            two.rollDie();
        if (!three.isFrozen())
            three.rollDie();
        if (!four.isFrozen())
            four.rollDie();
        if (!five.isFrozen())
            five.rollDie();

    }

    /* Asks the user which dice should be frozen 1-5 (should be read in in one line) */
    private void chooseFrozen()
    {
        System.out.println("Which dice would you like to freeze? (1-5): ");
        String s = keyboard.nextLine();
        if (s.indexOf("1") > -1)
            one.freezeDie();
        if (s.indexOf("2") > -1)
            two.freezeDie();
        if (s.indexOf("3") > -1)
            three.freezeDie();
        if (s.indexOf("4") > -1)
            four.freezeDie();
        if (s.indexOf("5") > -1)
            five.freezeDie();

    }

    /* Should print the value of all five dice separated by a tab (\t) to the console */
    private void printDice()
    {
        System.out.println(one.getValue() +"\t"+ two.getValue()+"\t"+ three.getValue() +"\t"+ four.getValue()+"\t"+
        five.getValue());
    }

    /* 1. Print a scoreboard
       2. Ask the user where they would like to mark their score.
       3. Call appropriate function
       4. If false is returned the user entered an invalid number, so ask the user to try again	*/
    private void markScore()
    {
        scorecard.printScoreCard();
        System.out.println("Where would you like to place your score?");
        System.out.println(" 1. Ones    7. 3 of Kind");
        System.out.println(" 2. Twos    8. 4 of Kind");
        System.out.println(" 3. Threes  9. Full House");
        System.out.println(" 4. Fours   10. Sm Straight");
        System.out.println(" 5. Fives   11. Lg Straight");
        System.out.println(" 6. Sixes   12. Yahtzee");
        System.out.println("        13. Chance");
        System.out.println("Enter 1-13: ");
        int category = keyboard.nextInt();
        keyboard.nextLine();
        boolean successfullMark = false;
        boolean inBetweenOneAndThirteen = category >= 1 && category <=13;
        while (!(inBetweenOneAndThirteen && successfullMark)){
            switch (category){
                case 1: successfullMark = scorecard.markOnes(one.getValue(),two.getValue(), three.getValue(),
                four.getValue(),five.getValue());break;
                case 2: successfullMark = scorecard.markOnes(one.getValue(),two.getValue(), three.getValue(),
                        four.getValue(),five.getValue());break;
                case 3: successfullMark = scorecard.markOnes(one.getValue(),two.getValue(), three.getValue(),
                        four.getValue(),five.getValue());break;
                case 4: successfullMark = scorecard.markOnes(one.getValue(),two.getValue(), three.getValue(),
                        four.getValue(),five.getValue());break;
                case 5: successfullMark = scorecard.markOnes(one.getValue(),two.getValue(), three.getValue(),
                        four.getValue(),five.getValue());break;
                case 6: successfullMark = scorecard.markOnes(one.getValue(),two.getValue(), three.getValue(),
                        four.getValue(),five.getValue());break;
                case 7: successfullMark = scorecard.markOnes(one.getValue(),two.getValue(), three.getValue(),
                        four.getValue(),five.getValue());break;
                case 8: successfullMark = scorecard.markOnes(one.getValue(),two.getValue(), three.getValue(),
                        four.getValue(),five.getValue());break;
                case 9: successfullMark = scorecard.markOnes(one.getValue(),two.getValue(), three.getValue(),
                        four.getValue(),five.getValue());break;
                case 10: successfullMark = scorecard.markOnes(one.getValue(),two.getValue(), three.getValue(),
                        four.getValue(),five.getValue());break;
                case 11: successfullMark = scorecard.markOnes(one.getValue(),two.getValue(), three.getValue(),
                        four.getValue(),five.getValue());break;
                case 12: successfullMark = scorecard.markOnes(one.getValue(),two.getValue(), three.getValue(),
                        four.getValue(),five.getValue());break;
                case 13: successfullMark = scorecard.markOnes(one.getValue(),two.getValue(), three.getValue(),
                        four.getValue(),five.getValue());break;
                default: category = keyboard.nextInt();
                    keyboard.nextLine();

                    System.out.println("Please Re-Enter your category selection (1-13)");
            }
            if (!successfullMark){
                System.out.println("Please Re-Enter your category selection (1-13)");
                category = keyboard.nextInt();
                keyboard.nextLine();
            }
        }
    }
}