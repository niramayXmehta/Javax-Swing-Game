package GameSettings;
import java.awt.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import GameSettings.SpaceGame.ChoiceHandler;

public class GUI 
{
    JFrame gameWindow;
    JPanel titlePanel, startButtonPanel, mainTextPanel, optionButtonsPanel, playerStatusPanel;
    JLabel titleLabel, healthLabel, healthLeftLabel, weaponLabel, weaponNameLabel;
    JButton startButton, option1, option2, option3, option4;
    JTextArea mainTextArea;
    Font title = new Font("Times New Roman", Font.BOLD, 85);
    Font text = new Font("Times New Roman", Font.PLAIN, 25);
    Font labels = new Font("Times New Roman", Font.ITALIC, 25);

    public void createGUI(ChoiceHandler choiceHandler)
    {
        //Building the window for the game
        gameWindow = new JFrame();
        gameWindow.setSize(1500, 600);
        gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameWindow.getContentPane().setBackground(Color.white);
        gameWindow.setLayout(null);

        //---------------------------------------------------------------------------//
        
        //Title Screen for the Adventure Game
        titlePanel = new JPanel();
        titlePanel.setBounds(400, 100, 600, 500);
        titlePanel.setBackground(Color.white);

        titleLabel = new JLabel("Space Game");
        titleLabel.setForeground(Color.black);
        titleLabel.setFont(title);
        titlePanel.add(titleLabel);

        //Start Button for the Game
        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(600, 400, 200, 100);
        startButtonPanel.setBackground(Color.white);

        startButton = new JButton("Start");
        startButton.setForeground(Color.orange);
        startButton.setBackground(Color.white);
        startButton.setFont(text);
        startButton.setFocusPainted(false);

        startButton.addActionListener(choiceHandler);
        startButton.setActionCommand("Start");
        startButtonPanel.add(startButton);

        gameWindow.add(titlePanel);
        gameWindow.add(startButtonPanel);
        
        //---------------------------------------------------------------------------//

        //Game Play Screen (Text Game)
        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(250, 100, 1000, 200);
        mainTextPanel.setBackground(Color.white);
        gameWindow.add(mainTextPanel);

        // //This is the area where the main text of the game appears
        mainTextArea = new JTextArea("Main Text Area");
        mainTextArea.setBounds(250, 100, 1000, 200);
        mainTextArea.setBackground(Color.white);
        mainTextArea.setForeground(Color.blue);
        mainTextArea.setFont(text);
        mainTextArea.setLineWrap(true);
        mainTextArea.setEditable(false);
        mainTextPanel.add(mainTextArea);
    
        //---------------------------------------------------------------------------//

        // //This the area where the option's buttons appear
        optionButtonsPanel = new JPanel();
        optionButtonsPanel.setBounds(350, 350, 500, 150);
        optionButtonsPanel.setBackground(Color.white);
        optionButtonsPanel.setLayout(new GridLayout(4, 1));
        gameWindow.add(optionButtonsPanel);

        // // //Option Button 1
        option1 = new JButton("Option 1");
        option1.setBackground(Color.white);
        option1.setForeground(Color.black);
        option1.setFont(text);
        option1.setFocusPainted(false);

        option1.addActionListener(choiceHandler);
        option1.setActionCommand("O1");
        optionButtonsPanel.add(option1);

        // // //Option Button 2
        option2 = new JButton("Option 2");
        option2.setBackground(Color.white);
        option2.setForeground(Color.black);
        option2.setFont(text);
        option2.setFocusPainted(false);

        option2.addActionListener(choiceHandler);
        option2.setActionCommand("O2");
        optionButtonsPanel.add(option2);

        // // //Option Button 3
        option3 = new JButton("Option 3");
        option3.setBackground(Color.white);
        option3.setForeground(Color.black);
        option3.setFont(text);
        option3.setFocusPainted(false);

        option3.addActionListener(choiceHandler);
        option3.setActionCommand("O3");
        optionButtonsPanel.add(option3);

        // // //Option Button 4
        option4 = new JButton("x");
        option4.setBackground(Color.white);
        option4.setForeground(Color.black);
        option4.setFont(text);
        option4.setFocusPainted(false);

        option4.addActionListener(choiceHandler);
        option4.setActionCommand("O4");
        optionButtonsPanel.add(option4);
        
        //---------------------------------------------------------------------------//

        // //This the player status panel, displaying weapon of the player and its health left
        playerStatusPanel = new JPanel();
        playerStatusPanel.setBounds(250, 15, 800, 50);
        playerStatusPanel.setBackground(Color.white);
        playerStatusPanel.setLayout(new GridLayout(1, 4)); 
        gameWindow.add(playerStatusPanel);

        // // //This is to display the health of the player
        healthLabel = new JLabel("Health");
        healthLabel.setFont(text);
        healthLabel.setForeground(Color.black);
        playerStatusPanel.add(healthLabel);

        healthLeftLabel = new JLabel();
        healthLeftLabel.setFont(labels);
        healthLeftLabel.setForeground(Color.black);
        playerStatusPanel.add(healthLeftLabel);

        // // //This is to display the weapon of the player
        weaponLabel = new JLabel("Weapon");
        weaponLabel.setFont(text);
        weaponLabel.setForeground(Color.black);
        playerStatusPanel.add(weaponLabel);

        weaponNameLabel = new JLabel();
        weaponNameLabel.setFont(labels);
        weaponNameLabel.setForeground(Color.black);
        playerStatusPanel.add(weaponNameLabel);

        //---------------------------------------------------------------------------//

        gameWindow.setVisible(true);


    }
}