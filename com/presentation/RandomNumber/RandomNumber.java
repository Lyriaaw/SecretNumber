package com.presentation.RandomNumber;

import java.util.Random;

/**
 * (commentaires)
 *
 * @author Amalric Lombard de Buffières <amalric.debuffieres@icloud.com>
 * @version 1.0.0
 */
public class RandomNumber {

    int randomNumber;
    boolean isFinished;

    int score;



    public RandomNumber() {
    }

    public int getRandomNumber() {
        return randomNumber;
    }

    public void setRandomNumber(int randomNumber) {
        this.randomNumber = randomNumber;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public void setFinished(boolean finished) {
        isFinished = finished;
    }

    @Override
    public String toString() {
        return "RandomNumber{" +
                "randomNumber=" + randomNumber +
                '}';
    }


    /**
     * Start the game
     * Must be called before any action
     */
    public void initGame() {

        Random random = new Random();   // Used to pick a random number

        randomNumber = random.nextInt(100) + 1; // pick a random number from 0 to 100

        score = 0;      // init the score

        isFinished = false; // false until the game is finished

    }


    /**
     * Must be user when the player wants to try a Number
     * @param userNumber The Integer value of the userInput
     * @return != messages depending on the hits
     */
    public String tryForANumber(int userNumber) {
        score++;    // One try added to the score

        String response = "";   // preparing the game's response

        if (randomNumber < userNumber) {
            response = "Less";
        } else if (randomNumber > userNumber) {
            response = "More";
        } else {
            response = "You Win";
            isFinished = true;
        }

        return response;
    }









}
