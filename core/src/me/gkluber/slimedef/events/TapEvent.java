package me.gkluber.slimedef.events;

import com.badlogic.gdx.math.Vector2;

/**
 * Created by gklub on 12/29/2017.
 */

public class TapEvent implements Event{
    private Vector2 pos;

    public TapEvent(Vector2 pos)
    {
        this.pos = pos;
    }

    public int getId()
    {
        return 4;
    }

    public Vector2 getPosition()
    {
        return pos;
    }

    public int getX()
    {
        return (int) getPosition().x;
    }

    public int getY()
    {
        return (int) getPosition().y;
    }

    public String getEventName()
    {
        return "Tap Event";
    }
}
