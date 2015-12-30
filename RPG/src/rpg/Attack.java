/*
 *  Projet - APO Creation d'un RPG
 *  Decembre 2015
 *  Gaetan MARTIN & Jensen Joymangul
 */
package rpg;

import static java.lang.Math.abs;

/**
 * Class representing a physical attack
 *
 * @author Gaetan
 */
public class Attack implements Capacity
{
    private Weapon weapon;         //Weapon used during attack

    /**
     * Effect of the attack
     *
     * @param source Character attacking
     * @param target Target Character
     * @return Effect of attack(to apply on target character)
     */
    public Effect getEffect(Character source, Character target)
    {
        int damage = this.weapon.getEffect().getValue() + source.getAbilities().get(Ability.STRENGTH);
        int defence = target.getAbilities().get(Ability.DEFENSE) + target.getArmor().getEffect().getValue();
        int netDamage = abs(defence - damage);
        return new Effect(Ability.HEALTH,(-netDamage),1);
    }


    @Override
    public double probaWin(Character source)
    {
        int dexterity = source.getAbilities().get(Ability.DEXTERITY);
        int netDexterity = dexterity - this.weapon.getManageability();
        if(netDexterity >= 0)
            return 1;
        if(netDexterity <0 && netDexterity >=-20)
            return 0.8;
        if(netDexterity <-20 && netDexterity >=-40)
            return 0.6;
        if(netDexterity <-40 && netDexterity >=-60)
            return 0.4;
        if(netDexterity <-60 && netDexterity >=-80)
            return 0.2;
        if(netDexterity <-80 && netDexterity >=-100)
            return 0.1;     
        return 0.5;
    }
}
