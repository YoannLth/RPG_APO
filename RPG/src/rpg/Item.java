/*
 *  Projet - APO Creation d'un RPG
 *  Decembre 2015
 *  Gaetan MARTIN & Jensen JOYMANGUL
 */
package rpg;

/**
 * Item class : represents an item / object of the game
 *
 * @author p1509413
 */
public class Item
{

    /**
     * Effect of the item
     */
    protected Effect effect;

    /**
     * Name of the item
     */
    protected String name = "Default";

    /**
     * Weight of the item
     */
    protected int weight;

    /**
     * Constructor
     *
     * @param n : name of the item
     * @param w : weight of the item
     */
    public Item(String n, int w)
    {
        this.name = n;
        this.weight = w;
    }

    /**
     * Add an effect to the item
     *
     * @param e : The effect to add
     */
    public void setEffect(Effect e)
    {
        this.effect = e;
    }

    // ------ Getters
    
    public Effect getEffect()
    {
        return effect;
    }

    public String getName()
    {
        return name;
    }

    public int getWeight()
    {
        return weight;
    }
    
    @Override
    public String toString()
    {
        String s;
        s= "\nItem : " + this.getName() + " avec un poid de " + this.getWeight();
        s+= "\n" + this.getEffect().toString();
        return s;
    }
}
