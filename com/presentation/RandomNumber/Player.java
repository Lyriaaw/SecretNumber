package com.presentation.RandomNumber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;

/**
 * (commentaires)
 *
 * @author Amalric Lombard de Buffières <amalric.debuffieres@icloud.com>
 * @version 1.0.0
 */
public class Player {


    /**
     * Player's name
     */
    private String name;


    // private List<Integer> scoreHistory;


    public Player() {
    }

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    {
    /* public List<Integer> getScoreHistory() {
        return scoreHistory;
    }

    public void setScoreHistory(List<Integer> scoreHistory) {
        this.scoreHistory = scoreHistory;
    }
    */
    }

    /**
     * Ask directly to the user for the value he wants to try
     * @return the user input as an Integer
     */
    public int askUserInputFromConsole() {

        BufferedReader userInputReader = new BufferedReader(new InputStreamReader(System.in));
        String userInputString = "";
        int userInput = 0;
        boolean correctUserInput = false;


        while (!correctUserInput) {

            System.out.print("Select a number (1 - 100) : ");

            // Taking the user's input as a String
            try {
                userInputString = userInputReader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }

            // Converting userInput as String to integer
            try {
                userInput = Integer.parseInt(userInputString);
                correctUserInput = true;
            } catch (NumberFormatException e) {
                e.printStackTrace();
                correctUserInput = false;
            }

        }

        // returning the user input
        return userInput;
    }


    /**
     * Ask the user for his name and define it as the player's name
     */
    public void askUserForName() {

        String userName = "";

        BufferedReader userInputReader = new BufferedReader(new InputStreamReader(System.in));

        // Taking the user Input
        try {
            System.out.println("Enter your name : ");
            userName = userInputReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            userName = "IOError";
        }

        this.name = userName;

    }











}
