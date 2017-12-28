package me.gkluber.slimedef.events;

import com.badlogic.gdx.math.Vector2;

/**
 * Created by gklub on 12/27/2017.
 *
 * Equivalent to TapEvent and ClickEvent
 * Fired when game clicked or touched on mobile
 */

public class InteractEvent implements Event{

    private Vector2 pos;

    public InteractEvent(Vector2 pos)
    {
        this.pos = pos;
    }

    public int getId()
    {
        return 0;
    }

    public String getEventName()
    {
        return "Interact Event";
    }
}

