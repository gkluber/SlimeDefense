package me.gkluber.slimedef.events;

import com.badlogic.gdx.math.Vector2;

/**
 * Created by gklub on 12/30/2017.
 */

public class MouseMoveEvent implements Event {
    private Vector2 pos;

    public MouseMoveEvent(Vector2 pos)
    {
        this.pos = pos;
    }

    public int getId()
    {
        return 7;
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
        return "Mouse Move Event";
    }
}
