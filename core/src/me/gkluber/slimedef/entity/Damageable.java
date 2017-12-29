package me.gkluber.slimedef.entity;

import com.badlogic.gdx.math.Vector2;

/**
 * Created by gklub on 12/28/2017.
 */

public abstract class Damageable extends Entity{
    protected double health;

    public Damageable(Vector2 pos, double health)
    {
        super(pos);
        this.health = health;
    }

    public double getHealth()
    {
        return health;
    }

    public boolean isAlive()
    {
        return health > 0;
    }

    public abstract boolean damage(double hp); //returns true if this kills entity
}
