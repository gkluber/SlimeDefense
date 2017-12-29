package me.gkluber.slimedef.entity;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;

import java.util.Random;

import me.gkluber.slimedef.util.Animation;
import me.gkluber.slimedef.util.ColorUtil;

/**
 * Created by gklub on 12/27/2017.
 */

public class Slime extends Damageable {
    private Color color;
    public Slime(Vector2 pos, double health)
    {
        super(pos, health);
        //90% alpha
        color = ColorUtil.drawColor().sub(0,0,0,0.1f);
    }

    public boolean damage(double hp)
    {
        health -= hp;
        return health > 0;
    }

    public void draw()
    {

    }

    public void move(Vector2 target)
    {

    }
    public void destroy()
    {

    }

    public void playAnimation(Animation an)
    {

    }

    public boolean act(Action a)
    {
        return false;
    }
}
