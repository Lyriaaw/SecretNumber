package com.presentation;

import com.presentation.Gui.Frame;
import com.presentation.RandomNumber.Player;
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


    /**
     * Launch and manage the game from the console
     */
    public static void launchOnConsole() {
        RandomNumber game = new RandomNumber();

        Player player = new Player();
        player.askUserForName();

        String gameResponse;


        game.initGame();

        while (!game.isFinished()) {

            // Ask player for a number
            int userNumber = player.askUserInputFromConsole();

            // try the number entered by the user
            gameResponse = game.tryForANumber(userNumber);

            // Displaying game message
            System.out.println(gameResponse);

        }

        System.out.println("Congratulations " + player.getName() + " !! ");
        System.out.println("You won with a score = " + game.getScore());
    }


}
