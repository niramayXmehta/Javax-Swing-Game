package GameSettings;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SpaceGame
{
    ChoiceHandler choiceHandler = new ChoiceHandler();
    GUI gui = new GUI();
    ScreenSetting sc = new ScreenSetting(gui);
    GameStory story = new GameStory(this, gui, sc);//Main narrative of the game

    String nextPos1, nextPos2, nextPos3, nextPos4;//For Switch Case

    public static void main(String[] args)
    {   
        SpaceGame game = new SpaceGame();

        game.gui.createGUI(game.choiceHandler);
        game.sc.showTitlePage(); 
        game.story.defaultSettings();
    }

    class ChoiceHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            String yourOption = event.getActionCommand();
            switch(yourOption)
            {
                case "Start": sc.showGamePage(); story.colonyEntrance(); break;
                case "O1": story.selectPos(nextPos1); break;
                case "O2": story.selectPos(nextPos2); break;
                case "O3": story.selectPos(nextPos3); break;
                case "O4": story.selectPos(nextPos4); break;
            }
        }
    }
    
}
