package GameItems;

import java.util.ArrayList;

public class PlasmaBlaster extends SuperBlaster 
{
    private ArrayList<Integer> damageRandom = new ArrayList<Integer>();

    public PlasmaBlaster()
    {
        name = "Plasma Blaster";
        damage = 20;
        for (int i = 2; i <= damage; i+=2)
        {
            damageRandom.add(i);
        }
    }

    public int damage_weapon(MainPlayer p)
    {
        return damageRandom.get((int) (Math.random()*damageRandom.size()));
    }
}
