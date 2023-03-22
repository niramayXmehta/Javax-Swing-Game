package GameItems;

public class HealingBlaster extends SuperBlaster
{
    private int healPlayer = 3;
    public HealingBlaster()
    {
        name = "Healing Blaster";
        damage = 4;
    }

    public int damage_weapon(MainPlayer p)
    {
        p.health += healPlayer;
        return damage;
    }
}
