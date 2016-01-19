/*
 *  Projet - APO Creation d'un RPG
 *  Decembre 2015
 *  Gaetan MARTIN & Jensen Joymangul
 */
package rpg;

import controllerPackage.ControllerUI;
import controllerPackage.DisplayCharacter;
import java.util.ArrayList;
import me.grea.antoine.utils.Dice;

/**
 * Class scenario representing an event without a fight, i.e where the
 * characters can find items, etc ..
 *
 * @author Gaetan
 */
public class Scenario extends Event
{

    /**
     * Item to be found to the player characters
     */
    private ArrayList<Item> itemFound;

    public void setItemFound(ArrayList<Item> itemFound)
    {
        this.itemFound = itemFound;
    }

    /**
     * Default constructor initializing the list of characters
     *
     * @param playerChacraters
     * @param aiChacraters
     */
    public Scenario(ArrayList<Character> playerChacraters, ArrayList<Character> aiChacraters)
    {
        super(playerChacraters, aiChacraters);
    }

    /**
     * Constructor initializing the list of characters and message
     *
     * @param playerChacraters
     * @param aiChacraters
     * @param msg
     */
    public Scenario(ArrayList<Character> playerChacraters, ArrayList<Character> aiChacraters, String msg)
    {
        super(playerChacraters, aiChacraters, msg);
        this.itemFound = new ArrayList<>();
    }

    /**
     * Launch the scenario
     */
    @Override
    public void launch()
    {
        System.out.println(introMessage);
        this.askAction();
    }

    /**
     * Ask to the player to do something
     */
    private void askAction()
    {
        String text = "What do you want to do? \n";
        ArrayList<String> choices = new ArrayList();
        choices.add("\t 0. Leave the game \n");
        choices.add("\t 1. Have a look for an item \n");
        choices.add("\t 2. Continue the adventure \n");
        for (String c : choices)
        {
            text += c;
        }
        int choice = ControllerUI.readInt(text, 0, choices.size() - 1);
        switch (choice)
        {
            case 0:
                RPG.quitGame();
            case 1:
                this.findItem();
                break;
            case 2:
                break;
            default:
                break;
        }
    }

    /**
     * Add the items randomly to the player Characters
     */
    private void findItem()
    {
        if (this.itemFound.isEmpty())
        {
            System.out.println("You found nothing");
        } else
        {
            for (Item i : itemFound)
            {
                int r = Dice.roll(0, playerCharacters.size() - 1);
                new DisplayCharacter(playerCharacters.get(r)).addItem(i);
            }
        }
    }

}
