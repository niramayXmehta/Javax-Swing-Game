/***********************************************************************/
/*This the class that contains the story line of the game*/

package GameSettings;

import GameItems.MainPlayer;
import GameItems.PlasmaBlaster;
import GameItems.RadakaiAlien;
import GameItems.ScastarsAlien;
import GameItems.HealingBlaster;
import GameItems.SuperAlien;

public class GameStory 
{
    //Objects of different classes to be used in the Adventure Story
    private SpaceGame game;
    private GUI gui;
    private ScreenSetting sc;
    MainPlayer newPlayer = new MainPlayer();
    SuperAlien alien;
    int orbCount;
    private GameEvents ge = new GameEvents();

    public GameStory(SpaceGame sg, GUI graphicalUI, ScreenSetting screenSetting)
    {
        this.game = sg;
        this.gui = graphicalUI;
        this.sc = screenSetting;
    }

    //This sets the default settings 
    public void defaultSettings()
    {
        newPlayer.health = 10;
        gui.healthLeftLabel.setText("" + newPlayer.health);

        gui.weaponNameLabel.setText("Stealth Knife");

        orbCount = 0;
    }

    //A Switch Case Block that controls the whole game
    public void selectPos(String nextPos)
    {
        switch(nextPos)
        {
            case "colonyEntrance": colonyEntrance(); break;
            case "attackSoldier": attackSoldier(); break;
            case "talkSoldier": talkSoldier(); break;
            case "wiseMan": wiseMan(); break;
            case "galacticJunction": galacticJunction(); break;
            case "west": west(); break;
            case "northRadakai": northRadakai(); break;
            case "south": south(); break;
            case "scastars": scastars(); break;
            case "fight": fight(); break;
            case "playerAtt": playerAtt(); break;
            case "monsterAtt": monsterAtt(); break;
            case "victory": victory(); break;
            case "defeat": defeat(); break;
            case "toTitleScreen": toTitleScreen(); break;
        }
    }

    //Various methods that resemble different events in the story
    //It uses switch-case to depict different scenarios in the code
    //Object ge of class GameEvents is used to show the various texts in the screen in the GUI. It changes at every event.

    /***********************************************************************/

    //Colony Entrance Event
    public void colonyEntrance()
    {
        ge.setEvent(game, gui, "You reach the entrance of a budding space colony.\nA space soldier is blocking your entry\nWhat action do you perform?",
        "Attack the soldier", "Have a chat with the soldier", "Walk away from the colony", "x", 
        "attackSoldier","talkSoldier", "wiseMan", "");
    }

    /***********************************************************************/

    //Three actions you can perform at the Colony Entrance, shown by the following methods
    public void attackSoldier()
    {
        ge.setEvent(game, gui, "The soldier dodges your attack and fights back\nand shoots you with the Magna Blaster.\n(You health reduces by 3)",
        "Continue --->", "x", "x", "x", 
        "colonyEntrance","", "", "");
        
        newPlayer.health -= 3;
        gui.healthLeftLabel.setText("" + newPlayer.health);
    }
    public void talkSoldier()
    {
        if (orbCount == 0)
        {
            ge.setEvent(game, gui, "Soldier: Hiii! You have arrived at the RM-62-UX Galactic Colony.\nSorry but we cannot let you enter the town, it is prohibited for strangers",
            "Continue --->", "x", "x", "x", 
            "colonyEntrance","", "", "");
        }
        else if (orbCount >= 1) //This is when you destroy the aliens ahead in the game - prevents the game from becoming never-ending
        {
            ending();
        }
    }
    public void wiseMan()//Weapon changes from Stealth Knife to Healing Blaster
    {
        ge.setEvent(game, gui, "You walk and encounter an old man sitting under a PhotonTree\nYou talk to him\nOld Man: Go West. You will find a junction there. Defeat the aliens in either north or south\nto enter the colony.\nAnd here, take this Healing Blaster to help you on your ADVENTURE.", 
        "Go West", "x", "x", "x", 
        "galacticJunction", "", "", "");

        newPlayer.currentBlaster = new HealingBlaster();
        gui.weaponNameLabel.setText(newPlayer.currentBlaster.name);
    }

    /***********************************************************************/

    //Reaching Galactic Junction Event
    public void galacticJunction()
    {
        ge.setEvent(game, gui, "You go west and after walking for some time, you reach a galactic juntion.\n(If you go east, you will reach RM-62-UX Colony)",
        "Head East", "Head West", "Head North", "Head South",
        "colonyEntrance","west", "northRadakai", "south");
    }

    /***********************************************************************/

    //Three directions other than that towards the Colony, from the Galactic Junction
    public void west()
    {
        ge.setEvent(game, gui, "You arrive at Space-Inn.\nYour friend owns this inn and he offers you some food and lets you rest.\n(Your health recovers by 3)",
        "Head East", "x", "x", "x", 
        "galacticJunction", "", "", "");

        newPlayer.health += 3;
        gui.healthLeftLabel.setText("" + newPlayer.health);
    }
    public void northRadakai() //You encounter the alien Radakai
    {
        alien = new RadakaiAlien();
        ge.setEvent(game, gui, "You have come face-to-face with the " + alien.name + "!!\n(It is a fast creature with low health, but high damage)",
        "Fight It", "Run Away", "x", "x", 
        "fight","galacticJunction", "", "");
    }
    public void south()//Weapon changes from Healing Blaster to Plasma Blaster
    {
        ge.setEvent(game, gui, "You stubmle open a space chest.\nYou blast it open and find the Plasma Blaster.\n(Your new weapon is the Plasma Blaster)",
        "Walk Further", "x", "x", "x", 
        "scastars","", "", "");

        newPlayer.currentBlaster = new PlasmaBlaster();
        gui.weaponNameLabel.setText(newPlayer.currentBlaster.name);
    }
    public void scastars()//You encounter the alien Scastars
    {
        newPlayer.currentBlaster = new PlasmaBlaster();
        alien = new ScastarsAlien();
        ge.setEvent(game, gui, "You have come face-to-face with the " + alien.name +"!!\n(It is a giant creature with high health, but low damage)",
        "Fight It", "Run Away", "x", "x", 
        "fight","galacticJunction", "", "");
    }

    /***********************************************************************/

    //Following methods are for the fight scenes between the player and aliens
    public void fight()
    {
        ge.setEvent(game, gui, alien.name + "'s health is " + alien.health + ". What will you do?",
        "Attack", "Run", "x", "x",
        "playerAtt", "galacticJunction", "x", "x");
    }
    public void playerAtt()//Player attack turn
    {
        int playerDamage = newPlayer.currentBlaster.damage_weapon(newPlayer);

        gui.healthLeftLabel.setText("" + newPlayer.health);
        alien.health -= playerDamage;

        if (newPlayer.currentBlaster.name.equals("Healing Blaster"))
        {
            gui.mainTextArea.setText("You attacked " + alien.name + " and reduced its health by " + 
            playerDamage + ". Its current health is " + 
            alien.health + ".\nYou healed by 3 (powers of the Healing Blaster)"); 
        }
        else if (newPlayer.currentBlaster.name.equals("Plasma Blaster"))
        {
            gui.mainTextArea.setText("You attacked " + alien.name + " and reduced its health by " + 
            playerDamage + ". Its current health is " + 
            alien.health);
        }
        
        gui.option1.setText("Continue --->");
        gui.option2.setText("x");
        gui.option3.setText("x");
        gui.option4.setText("x");

        //Checking if the monster if alive or dead
        if(alien.health > 0)
        {

            game.nextPos1 = "monsterAtt";
            game.nextPos2 = "";
            game.nextPos3 = "";
            game.nextPos4 = "";
        }
        else if (alien.health < 1)//Victory if alien is dead
        {
            game.nextPos1 = "victory";
            game.nextPos2 = "";
            game.nextPos3 = "";
            game.nextPos4 = "";
        }
    }
    public void monsterAtt()
    {
        int monsterDamage = alien.damage;
        gui.mainTextArea.setText("The monster attacked you and reduced your health by " + alien.damage);
        newPlayer.health -= monsterDamage;
        gui.healthLeftLabel.setText("" + newPlayer.health);

        gui.option1.setText("Continue --->");
        gui.option2.setText("x");
        gui.option3.setText("x");
        gui.option4.setText("x");

        //Checking if the player is alive or dead
        if(newPlayer.health > 0)
        {
            game.nextPos1 = "fight";
            game.nextPos2 = "";
            game.nextPos3 = "";
            game.nextPos4 = "";
        }
        else if (newPlayer.health < 1)//Defeat if player is dead
        {
            game.nextPos1 = "defeat";
            game.nextPos2 = "";
            game.nextPos3 = "";
            game.nextPos4 = "";
        }
    }

    /***********************************************************************/

    //victory and defeat methods depending on the fight outcome
    public void victory()
    {
        ge.setEvent(game, gui, "You have defeated " + alien.name + "! Hoorrayy.\n(You obtain a Golden Orb from the alien)",
        "Head towards the Colony", "x", "x", "x", 
        "colonyEntrance", "", "", "");
        
        orbCount++;
    }
    public void defeat() //Possible Ending 1 - You are defeated by the monster and it's GAME OVER.
    {
        ge.setEvent(game, gui, "You have been defeated\nGAME OVER", 
        "Go to Title Screen", "", "", "", 
        "toTitleScreen", "", "", "");
    }

    /***********************************************************************/

    //Possible Ending 2 - You enter the colony and head your own way.
    public void ending()
    {
        gui.mainTextArea.setText("Soldier: You again??!\nOh you have brought the Golden Orb with you. You have defeated Scasta!\nYou seem to have legendary skills, welcome to our Colony, Sir!");
        
        gui.option1.setText("Go to the title screen");
        gui.option2.setVisible(false);
        gui.option3.setVisible(false);
        gui.option4.setVisible(false);

        game.nextPos1 = "toTitleScreen";
    }
    public void toTitleScreen()
    {
        defaultSettings();
        sc.showTitlePage();
    }

    /***********************************************************************/
}
