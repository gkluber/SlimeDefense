package me.gkluber.slimedef.events;

import com.badlogic.gdx.math.Vector2;

/**
 * Created by gklub on 12/29/2017.
 */

public class FlingEvent implements Event{
    Vector2 velocity;

    public FlingEvent(Vector2 velocity)
    {
        this.velocity = velocity;
    }

    public int getId()
    {
        return 6;
    }

    public Vector2 getVelocity()
    {
        return velocity;
    }

    public int getVX()
    {
        return (int) getVelocity().x;
    }

    public int getVY()
    {
        return (int) getVelocity().y;
    }

    public String getEventName()
    {
        return "Fling Event";
    }
}
