package com.presentation;

import com.presentation.Gui.Frame;
import com.presentation.RandomNumber.RandomNumber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {

        launchOnConsole();

        // launchOnGui();

    }

    /**
     * Launch the application from Frame
     */
    public static void launchOnGui() {

        Frame frame = new Frame();
    }



    public static void launchOnConsole() {
        RandomNumber game = new RandomNumber();

        game.initGame();

        while (!game.isFinished()) {
            BufferedReader userInputReader = new BufferedReader(new InputStreamReader(System.in));



            String userInputString = "";
            int userInput = 0;

            boolean correctUserInput;
            do {

                System.out.print("Select a number (1 - 100) : ");

                // Taking the user's input as a String
                try {

                    userInputString = userInputReader.readLine();

                } catch (IOException e) {

                    e.printStackTrace();

                }

                // Converting userInput as String to integer
                try {

                    userInput = Integer.parseInt(userInputString);
                    correctUserInput = true;

                } catch (NumberFormatException e) {
                    e.printStackTrace();

                    correctUserInput = false;
                }

            } while (!correctUserInput);

            System.out.println(game.tryForANumber(userInput));

        }

        System.out.println("You won with a score = " + game.getScore());
    }

}
