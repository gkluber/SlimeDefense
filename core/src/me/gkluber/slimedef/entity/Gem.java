package me.gkluber.slimedef.entity;

import com.badlogic.gdx.math.Vector2;

import me.gkluber.slimedef.util.Animation;

/**
 * Created by gklub on 12/28/2017.
 */

public class Gem extends Entity{

    public Gem(Vector2 pos)
    {
        super(pos);
    }

    public void draw()
    {

    }

    public void destroy()
    {

    }

    public void move(Vector2 target)
    {

    }

    public void playAnimation(Animation an)
    {

    }

    //gem has no actions
    public boolean act(Action an)
    {
        return false;
    }
}
