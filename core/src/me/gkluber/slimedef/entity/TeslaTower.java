package me.gkluber.slimedef.entity;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

import me.gkluber.slimedef.util.Animation;

/**
 * Created by gklub on 1/25/2018.
 */

public class TeslaTower extends Tower {
    public TeslaTower(Vector2 pos)
    {
        super(pos);
    }

    public void draw(ShapeRenderer renderer)
    {
        //todo
    }
    public void move(Vector2 target)
    {

    }//uses animation, etc. to move
    public void destroy()
    {

    }
    public boolean act(Action a)
    {
        return false;
    }

    public void playAnimation(Animation a)
    {

    }
}
