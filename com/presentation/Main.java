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

        // launchOnConsole();

        launchOnGui();

    }

    /**
     * Launch the application from Frame
     */
    public static void launchOnGui() {

        Frame frame = new Frame();
    }



    public static void launchOnConsole() {
        RandomNumber game = new RandomNumber();

        Player player = new Player("Player1");

        String gameResponse;


        game.initGame();

        while (!game.isFinished()) {

            int userNumber = player.askUserInputFromConsole();

            gameResponse = game.tryForANumber(userNumber);

            System.out.println(gameResponse);

        }


        System.out.println("You won with a score = " + game.getScore());
    }

}
