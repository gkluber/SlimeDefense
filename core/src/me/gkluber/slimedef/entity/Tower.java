package me.gkluber.slimedef.entity;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by gklub on 12/27/2017.
 */

public abstract class Tower extends Entity{
    protected float rotation;

    public Tower(Vector2 pos)
    {
        super(pos);
        rotation = 0f;
    }

    public abstract void draw(ShapeRenderer renderer);
    public abstract void move(Vector2 target); //uses animation, etc. to move
    public abstract void destroy();
    public abstract boolean act(Action a);
}
