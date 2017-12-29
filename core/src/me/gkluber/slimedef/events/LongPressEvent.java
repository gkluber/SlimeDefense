package me.gkluber.slimedef.events;

import com.badlogic.gdx.math.Vector2;

/**
 * Created by gklub on 12/29/2017.
 */

public class LongPressEvent implements Event {
    private Vector2 pos;

    public LongPressEvent(Vector2 pos)
    {
        this.pos = pos;
    }

    public int getId()
    {
        return 5;
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
        return "Long Press Event";
    }
}
