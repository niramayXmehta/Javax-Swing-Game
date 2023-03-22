package GameSettings;

public class GameEvents 
{
    public GameEvents(){}
    
    public void setEvent(SpaceGame game, GUI gui, String mainText, 
                    String option1, String option2, String option3, String option4, 
                    String pos1, String pos2, String pos3, String pos4)
    {
        gui.mainTextArea.setText(mainText);

        gui.option1.setText(option1);
        gui.option2.setText(option2);
        gui.option3.setText(option3);
        gui.option4.setText(option4);

        game.nextPos1 = pos1;
        game.nextPos2 = pos2;
        game.nextPos3 = pos3;
        game.nextPos4 = pos4;
    }
}
