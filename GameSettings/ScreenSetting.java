package GameSettings;

public class ScreenSetting 
{   
    private GUI gui;

    public ScreenSetting(GUI graphicalUI)
    {
        this.gui = graphicalUI;
    }

    public void showTitlePage()
    {
        //This will display the title page and hide the gameplay page
        gui.titlePanel.setVisible(true);
        gui.startButtonPanel.setVisible(true);

        gui.mainTextPanel.setVisible(false);
        gui.optionButtonsPanel.setVisible(false);
        gui.playerStatusPanel.setVisible(false);
    }

    public void showGamePage()
    {
        //This will display the title page and hide the gameplay page
        gui.mainTextPanel.setVisible(true);
        gui.optionButtonsPanel.setVisible(true);
        gui.playerStatusPanel.setVisible(true);

        gui.titlePanel.setVisible(false);
        gui.startButtonPanel.setVisible(false);
    }
}
