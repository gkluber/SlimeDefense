package me.gkluber.slimedef.events;

import com.badlogic.gdx.math.Vector2;

/**
 * Created by gklub on 12/29/2017.
 */

public class PanEvent implements Event{
    private Vector2 pos;
    private Vector2 delta;

    public PanEvent(Vector2 pos, Vector2 delta)
    {
        this.pos = pos;
        this.delta = delta;
    }

    public int getId()
    {
        return 3;
    }

    public Vector2 getPosition()
    {
        return pos;
    }

    public Vector2 getDelta()
    {
        return delta;
    }

    public int getX()
    {
        return (int) getPosition().x;
    }

    public int getY()
    {
        return (int) getPosition().y;
    }

    public float getdX()
    {
        return delta.x;
    }

    public float getdY()
    {
        return delta.y;
    }

    public String getEventName()
    {
        return "Pan Event";
    }
}
