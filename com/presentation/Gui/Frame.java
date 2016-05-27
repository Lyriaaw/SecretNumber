package com.presentation.Gui;

import com.presentation.RandomNumber.Player;
import com.presentation.RandomNumber.RandomNumber;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * (commentaires)
 *
 * @author Amalric Lombard de Buffières <amalric.debuffieres@icloud.com>
 * @version 1.0.0
 */
public class Frame extends JFrame implements ActionListener{

    JPanel mainPanel;

    JLabel gameInfo;
    JTextField userInput;
    JButton sendAnswer;


    RandomNumber game;
    Player player;

    public Frame() throws HeadlessException {

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setTitle("Random Number Game");
        this.setSize(500, 400);

        initGame();

        initGui();



        this.setVisible(true);

    }


    /**
     * Init Graphical components
     */
    private void initGui() {

        mainPanel = new JPanel();   // creating the main window panel

        // setting a layout manager to the panel
        GridLayout verticalLayout = new GridLayout(3, 1);
        mainPanel.setLayout(verticalLayout);

        // Creating the Label with the text "GameInfo" and Horizontal Aligment : center
        gameInfo = new JLabel("(Less | More ...)", SwingConstants.CENTER);
        //gameInfo.setFont(new Font("Arial", Font.PLAIN, 40));

        userInput = new JTextField();
        // userInput.setFont(new Font("Arial", Font.PLAIN, 40));
        userInput.setHorizontalAlignment(JTextField.CENTER);


        // Creating the button
        sendAnswer = new JButton("Try this number");
        sendAnswer.addActionListener(this);
        sendAnswer.setActionCommand("TRY_NUMBER");
        // sendAnswer.setFont(new Font("Arial", Font.PLAIN, 40));




        // adding components
        mainPanel.add(gameInfo);
        mainPanel.add(userInput);
        mainPanel.add(sendAnswer);


        this.setContentPane(mainPanel);
    }

    /**
     * Create and launch the game logic
     */
    private void initGame() {
        game = new RandomNumber();
        game.initGame();

        player = new Player();
        player.askUserForName();
    }


    /**
     * Somebody clicked on the TryNumber button
     */
    private void tryButtonClicked() {

        String userInputString = userInput.getText();

        if (userInputString.length() == 0) return;

        int triedNumber;
        try {
            triedNumber = Integer.parseInt(userInputString);
        } catch (NumberFormatException e) {
            e.printStackTrace();

            return;
        }


        String response = game.tryForANumber(triedNumber);

        String displayedString;

        if (response.equals("You Win")) {
            displayedString = "Congratulation " + player.getName() + " !! You won !" + " (score : " + game.getScore() + ")" + "\n";

        } else {
            displayedString = response;
        }
        gameInfo.setText(displayedString);


    }




    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().contains("TRY_NUMBER")) {
            tryButtonClicked();
        }

    }


}
